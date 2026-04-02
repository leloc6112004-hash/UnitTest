from django.contrib.auth import get_user_model
from rest_framework import generics, permissions, status, viewsets
from rest_framework.decorators import action
from rest_framework.response import Response
from rest_framework_simplejwt.views import TokenObtainPairView

from .models import Profile
from .permissions import IsAdminProfile, IsModeratorOrAbove, IsProfileOwnerOrReadOnly
from .serializers import (
    CustomTokenObtainPairSerializer,
    ProfileAdminSerializer,
    ProfileSerializer,
    RegisterSerializer,
    UserSerializer,
    UserUpdateSerializer,
)

User = get_user_model()


class RegisterView(generics.CreateAPIView):
    queryset = User.objects.all()
    permission_classes = [permissions.AllowAny]
    serializer_class = RegisterSerializer


class MeView(generics.RetrieveUpdateAPIView):
    permission_classes = [permissions.IsAuthenticated]
    serializer_class = UserSerializer

    def get_object(self):
        return self.request.user

    def get_serializer_class(self):
        if self.request.method in ("PUT", "PATCH"):
            return UserUpdateSerializer
        return UserSerializer


class MeProfileView(generics.RetrieveUpdateAPIView):
    """GET/PATCH profile của chính mình (User ↔ Profile)."""

    permission_classes = [permissions.IsAuthenticated, IsProfileOwnerOrReadOnly]
    serializer_class = ProfileSerializer

    def get_object(self):
        return self.request.user.profile


class UserViewSet(viewsets.ReadOnlyModelViewSet):
    """Danh sách user + profile — moderator trở lên."""

    queryset = User.objects.select_related("profile").all().order_by("id")
    permission_classes = [permissions.IsAuthenticated, IsModeratorOrAbove]
    serializer_class = UserSerializer

    @action(
        detail=True,
        methods=["patch"],
        permission_classes=[permissions.IsAuthenticated, IsAdminProfile],
        url_path="set-role",
    )
    def set_role(self, request, pk=None):
        user = self.get_object()
        profile = user.profile
        serializer = ProfileAdminSerializer(profile, data=request.data, partial=True)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(ProfileAdminSerializer(profile).data)


class CustomTokenObtainPairView(TokenObtainPairView):
    serializer_class = CustomTokenObtainPairSerializer
