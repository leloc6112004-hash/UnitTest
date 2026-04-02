package com.basicproject.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Gần với Django mặc định: tối thiểu 8 ký tự, không được toàn chữ số (NumericPasswordValidator).
 */
public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    if (value.length() < 8) {
      return fail(context, "Mật khẩu phải có ít nhất 8 ký tự.");
    }
    if (value.chars().allMatch(Character::isDigit)) {
      return fail(context, "Mật khẩu không được chỉ gồm chữ số.");
    }
    return true;
  }

  private static boolean fail(ConstraintValidatorContext context, String msg) {
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
    return false;
  }
}
