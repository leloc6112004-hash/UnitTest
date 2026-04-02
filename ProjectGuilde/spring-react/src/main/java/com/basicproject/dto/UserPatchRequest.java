package com.basicproject.dto;

import com.basicproject.validation.OptionalEmail;
import lombok.Data;
import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserPatchRequest {
  @OptionalEmail private String email;
  private String firstName;
  private String lastName;
}
