package com.basicproject.exception;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** Lỗi validation dạng map field → danh sách message (giống DRF). */
@Getter
@RequiredArgsConstructor
public class FieldValidationException extends RuntimeException {

  private final Map<String, List<String>> errors;
}
