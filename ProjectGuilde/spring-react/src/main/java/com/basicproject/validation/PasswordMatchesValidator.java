package com.basicproject.validation;

import com.basicproject.dto.RegisterRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
    implements ConstraintValidator<PasswordMatches, RegisterRequest> {

  @Override
  public boolean isValid(RegisterRequest value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    String p = value.getPassword();
    String c = value.getPasswordConfirm();
    boolean ok = p != null && p.equals(c);
    if (!ok) {
      context.disableDefaultConstraintViolation();
      context
          .buildConstraintViolationWithTemplate("Mật khẩu xác nhận không khớp.")
          .addPropertyNode("passwordConfirm")
          .addConstraintViolation();
    }
    return ok;
  }
}
