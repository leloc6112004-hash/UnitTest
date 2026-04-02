package com.basicproject.dto;

import com.basicproject.validation.OptionalEmail;
import com.basicproject.validation.PasswordMatches;
import com.basicproject.validation.StrongPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@PasswordMatches
public class RegisterRequest {
  @NotBlank private String username;

  @OptionalEmail private String email;

  @NotBlank
  @StrongPassword
  private String password;

  @NotBlank private String passwordConfirm;
  private String firstName;
  private String lastName;
}
