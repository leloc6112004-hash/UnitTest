package com.basicproject.controller;

import com.basicproject.dto.ProfileResponse;
import com.basicproject.dto.SetRoleRequest;
import com.basicproject.dto.UserResponse;
import com.basicproject.service.UserAccountService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {

  private final UserAccountService userAccountService;

  @GetMapping({"", "/"})
  @PreAuthorize("hasAnyRole('MODERATOR','ADMIN','STAFF','SUPERUSER')")
  public List<UserResponse> list() {
    return userAccountService.listUsers();
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAnyRole('MODERATOR','ADMIN','STAFF','SUPERUSER')")
  public UserResponse get(@PathVariable Long id) {
    return userAccountService.getUser(id);
  }

  @PatchMapping({"/{id}/set-role", "/{id}/set-role/"})
  @PreAuthorize("hasAnyRole('ADMIN','STAFF','SUPERUSER')")
  public ProfileResponse setRole(
      @PathVariable Long id, @Valid @RequestBody SetRoleRequest request) {
    return userAccountService.setRole(id, request);
  }
}
