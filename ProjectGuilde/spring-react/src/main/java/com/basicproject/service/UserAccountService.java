package com.basicproject.service;

import com.basicproject.dto.*;
import com.basicproject.exception.FieldValidationException;
import com.basicproject.model.AppUser;
import com.basicproject.model.Profile;
import com.basicproject.model.Role;
import com.basicproject.repository.AppUserRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserAccountService {

  private final AppUserRepository userRepository;

  public AppUser currentUser() {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || !auth.isAuthenticated()) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    Object p = auth.getPrincipal();
    if (!(p instanceof AppUser u)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    return userRepository.findById(u.getId()).orElseThrow();
  }

  @Transactional
  public UserResponse patchMe(UserPatchRequest patch) {
    AppUser u = currentUser();
    if (patch.getEmail() != null) {
      String ne = EmailNormalize.apply(patch.getEmail());
      if (ne != null
          && userRepository.existsByEmailIgnoreCaseAndIdNot(ne, u.getId())) {
        throw new FieldValidationException(
            Map.of("email", List.of("Email đã được sử dụng.")));
      }
      u.setEmail(ne);
    }
    if (patch.getFirstName() != null) {
      u.setFirstName(patch.getFirstName());
    }
    if (patch.getLastName() != null) {
      u.setLastName(patch.getLastName());
    }
    userRepository.save(u);
    return UserResponse.from(userRepository.findById(u.getId()).orElseThrow());
  }

  @Transactional
  public ProfileResponse patchMyProfile(ProfilePatchRequest patch) {
    AppUser u = currentUser();
    Profile p = u.getProfile();
    if (p == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Không có profile.");
    }
    if (patch.getDisplayName() != null) {
      p.setDisplayName(patch.getDisplayName());
    }
    if (patch.getPhone() != null) {
      p.setPhone(patch.getPhone());
    }
    if (patch.getBio() != null) {
      p.setBio(patch.getBio());
    }
    if (patch.getAvatarUrl() != null) {
      p.setAvatarUrl(patch.getAvatarUrl());
    }
    userRepository.save(u);
    return ProfileResponse.from(userRepository.findById(u.getId()).orElseThrow().getProfile());
  }

  @Transactional(readOnly = true)
  public List<UserResponse> listUsers() {
    return userRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
        .map(UserResponse::from)
        .toList();
  }

  @Transactional(readOnly = true)
  public UserResponse getUser(Long id) {
    return userRepository
        .findById(id)
        .map(UserResponse::from)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Transactional
  public ProfileResponse setRole(Long userId, SetRoleRequest req) {
    AppUser target =
        userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    Role newRole;
    try {
      newRole = Role.valueOf(req.getRole());
    } catch (IllegalArgumentException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "role không hợp lệ");
    }
    if (target.getProfile() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
    target.getProfile().setRole(newRole);
    userRepository.save(target);
    return ProfileResponse.from(userRepository.findById(userId).orElseThrow().getProfile());
  }
}
