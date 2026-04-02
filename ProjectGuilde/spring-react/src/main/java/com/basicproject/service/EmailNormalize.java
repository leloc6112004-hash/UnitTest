package com.basicproject.service;

final class EmailNormalize {

  private EmailNormalize() {}

  static String apply(String raw) {
    if (raw == null) {
      return null;
    }
    String t = raw.trim();
    return t.isEmpty() ? null : t;
  }
}
