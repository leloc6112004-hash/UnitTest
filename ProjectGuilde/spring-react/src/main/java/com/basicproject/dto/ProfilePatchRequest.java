package com.basicproject.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProfilePatchRequest {
  private String displayName;
  private String phone;
  private String bio;
  private String avatarUrl;
  private String role;
}
