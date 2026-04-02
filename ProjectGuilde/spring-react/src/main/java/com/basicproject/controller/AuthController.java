package com.basicproject.controller;

import com.basicproject.dto.*;
import com.basicproject.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping({"/register", "/register/"})
  @ResponseStatus(HttpStatus.CREATED)
  public void register(@Valid @RequestBody RegisterRequest request) {
    authService.register(request);
  }

  @PostMapping({"/token", "/token/"})
  public AuthResponse token(@Valid @RequestBody LoginRequest request) {
    return authService.login(request);
  }

  @PostMapping({"/token/refresh", "/token/refresh/"})
  public AccessOnlyResponse refresh(@Valid @RequestBody TokenRefreshRequest request) {
    return authService.refresh(request);
  }
}
