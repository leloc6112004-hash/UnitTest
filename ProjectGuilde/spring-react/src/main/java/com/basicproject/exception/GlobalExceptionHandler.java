package com.basicproject.exception;

import com.basicproject.util.ApiFieldNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleValidation(
      MethodArgumentNotValidException ex) {
    Map<String, List<String>> out = new HashMap<>();
    for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
      String key = ApiFieldNames.toSnakeCase(fe.getField());
      out.computeIfAbsent(key, k -> new ArrayList<>()).add(fe.getDefaultMessage());
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(out);
  }

  @ExceptionHandler(FieldValidationException.class)
  public ResponseEntity<Map<String, List<String>>> handleFieldErrors(FieldValidationException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
  }

  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<Map<String, String>> handleResponseStatus(ResponseStatusException ex) {
    String reason = ex.getReason();
    if (reason == null || reason.isBlank()) {
      return ResponseEntity.status(ex.getStatusCode()).build();
    }
    return ResponseEntity.status(ex.getStatusCode()).body(Map.of("detail", reason));
  }
}
