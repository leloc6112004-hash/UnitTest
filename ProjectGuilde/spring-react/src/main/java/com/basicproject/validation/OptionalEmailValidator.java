package com.basicproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class OptionalEmailValidator implements ConstraintValidator<OptionalEmail, String> {

  private static final Pattern LOOSE =
      Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null || value.isBlank()) {
      return true;
    }
    return LOOSE.matcher(value.trim()).matches();
  }
}
