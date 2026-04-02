package com.basicproject.service;

import com.basicproject.dto.*;
import com.basicproject.exception.FieldValidationException;
import com.basicproject.model.AppUser;
import com.basicproject.model.Profile;
import com.basicproject.model.Role;
import com.basicproject.repository.AppUserRepository;
import com.basicproject.security.JwtService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AppUserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  @Transactional
  public void register(RegisterRequest req) {
    if (userRepository.existsByUsername(req.getUsername())) {
      throw new FieldValidationException(
          Map.of("username", List.of("Tên đăng nhập đã tồn tại.")));
    }
    String email = EmailNormalize.apply(req.getEmail());
    if (email != null && userRepository.existsByEmailIgnoreCase(email)) {
      throw new FieldValidationException(
          Map.of("email", List.of("Email đã được sử dụng.")));
    }
    AppUser user =
        AppUser.builder()
            .username(req.getUsername())
            .email(email)
            .password(passwordEncoder.encode(req.getPassword()))
            .firstName(req.getFirstName())
            .lastName(req.getLastName())
            .active(true)
            .staff(false)
            .superuser(false)
            .build();
    Profile profile = Profile.builder().role(Role.user).build();
    user.setProfile(profile);
    userRepository.save(user);
  }

  @Transactional(readOnly = true)
  public AuthResponse login(LoginRequest req) {
    AppUser user =
        userRepository
            .findByUsername(req.getUsername())
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Sai tài khoản hoặc mật khẩu."));
    if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
      throw new ResponseStatusException(
          HttpStatus.UNAUTHORIZED, "Sai tài khoản hoặc mật khẩu.");
    }
    if (!user.isEnabled()) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Tài khoản đã bị vô hiệu hóa.");
    }
    String access = jwtService.generateAccessToken(user);
    String refresh = jwtService.generateRefreshToken(user.getUsername());
    return AuthResponse.builder()
        .access(access)
        .refresh(refresh)
        .user(UserResponse.from(user))
        .build();
  }

  @Transactional(readOnly = true)
  public AccessOnlyResponse refresh(TokenRefreshRequest req) {
    String token = req.getRefresh();
    if (!jwtService.isRefreshToken(token)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token không hợp lệ.");
    }
    String username = jwtService.extractUsername(token);
    if (!jwtService.isTokenValid(token, username)) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token hết hạn.");
    }
    AppUser user =
        userRepository
            .findByUsername(username)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
    if (!user.isEnabled()) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Tài khoản đã bị vô hiệu hóa.");
    }
    return new AccessOnlyResponse(jwtService.generateAccessToken(user));
  }

}
