package com.basicproject.dto;

import com.basicproject.model.AppUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Value
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {
  Long id;
  String username;
  String email;
  String firstName;
  String lastName;

  @JsonProperty("is_active")
  boolean active;

  ProfileResponse profile;

  public static UserResponse from(AppUser u) {
    return UserResponse.builder()
        .id(u.getId())
        .username(u.getUsername())
        .email(u.getEmail())
        .firstName(u.getFirstName())
        .lastName(u.getLastName())
        .active(u.isActive())
        .profile(u.getProfile() != null ? ProfileResponse.from(u.getProfile()) : null)
        .build();
  }
}
