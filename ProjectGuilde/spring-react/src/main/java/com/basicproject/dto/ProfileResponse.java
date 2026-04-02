package com.basicproject.dto;

import com.basicproject.model.Profile;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProfileResponse {
  Long id;
  String username;
  String email;
  String firstName;
  String lastName;
  String displayName;
  String phone;
  String bio;
  String avatarUrl;
  String role;
  Instant createdAt;
  Instant updatedAt;

  public static ProfileResponse from(Profile p) {
    var u = p.getUser();
    return ProfileResponse.builder()
        .id(p.getId())
        .username(u.getUsername())
        .email(u.getEmail())
        .firstName(u.getFirstName())
        .lastName(u.getLastName())
        .displayName(p.getDisplayName())
        .phone(p.getPhone())
        .bio(p.getBio())
        .avatarUrl(p.getAvatarUrl())
        .role(p.getRole().name())
        .createdAt(p.getCreatedAt())
        .updatedAt(p.getUpdatedAt())
        .build();
  }
}
