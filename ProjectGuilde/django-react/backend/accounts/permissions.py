from rest_framework import permissions

from .models import Profile


class IsProfileOwnerOrReadOnly(permissions.BasePermission):
    """Chỉ chủ sở hữu profile (hoặc staff) mới được sửa."""

    def has_object_permission(self, request, view, obj):
        if request.method in permissions.SAFE_METHODS:
            return True
        user = request.user
        if not user or not user.is_authenticated:
            return False
        if user.is_staff:
            return True
        return getattr(obj, "user_id", None) == user.id


class IsAdminProfile(permissions.BasePermission):
    """Chỉ user có Profile.role == admin (hoặc Django superuser/staff)."""

    def has_permission(self, request, view):
        user = request.user
        if not user or not user.is_authenticated:
            return False
        if user.is_superuser or user.is_staff:
            return True
        profile = getattr(user, "profile", None)
        return bool(profile and profile.role == Profile.Role.ADMIN)


class IsModeratorOrAbove(permissions.BasePermission):
    """Moderator hoặc admin (hoặc staff Django)."""

    def has_permission(self, request, view):
        user = request.user
        if not user or not user.is_authenticated:
            return False
        if user.is_superuser or user.is_staff:
            return True
        profile = getattr(user, "profile", None)
        if not profile:
            return False
        return profile.role in (Profile.Role.MODERATOR, Profile.Role.ADMIN)
