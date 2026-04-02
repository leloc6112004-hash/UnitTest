package com.basicproject.controller;

import com.basicproject.dto.ProfilePatchRequest;
import com.basicproject.dto.ProfileResponse;
import com.basicproject.dto.UserPatchRequest;
import com.basicproject.dto.UserResponse;
import com.basicproject.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MeController {

  private final UserAccountService userAccountService;

  @GetMapping({"/me", "/me/"})
  public UserResponse me() {
    return UserResponse.from(userAccountService.currentUser());
  }

  @PatchMapping({"/me", "/me/"})
  public UserResponse patchMe(@Valid @RequestBody UserPatchRequest patch) {
    return userAccountService.patchMe(patch);
  }

  @GetMapping({"/me/profile", "/me/profile/"})
  public ProfileResponse myProfile() {
    var u = userAccountService.currentUser();
    if (u.getProfile() == null) {
      throw new org.springframework.web.server.ResponseStatusException(
          org.springframework.http.HttpStatus.NOT_FOUND);
    }
    return ProfileResponse.from(u.getProfile());
  }

  @PatchMapping({"/me/profile", "/me/profile/"})
  public ProfileResponse patchMyProfile(@RequestBody ProfilePatchRequest patch) {
    return userAccountService.patchMyProfile(patch);
  }
}
