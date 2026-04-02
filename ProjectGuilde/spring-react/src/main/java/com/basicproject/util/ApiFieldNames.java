package com.basicproject.util;

public final class ApiFieldNames {

  private ApiFieldNames() {}

  /** Chuyển tên thuộc tính Java (camelCase) sang snake_case cho JSON lỗi. */
  public static String toSnakeCase(String name) {
    if (name == null || name.isEmpty()) {
      return name;
    }
    StringBuilder out = new StringBuilder();
    char c0 = name.charAt(0);
    out.append(Character.toLowerCase(c0));
    for (int i = 1; i < name.length(); i++) {
      char c = name.charAt(i);
      if (Character.isUpperCase(c)) {
        out.append('_').append(Character.toLowerCase(c));
      } else {
        out.append(c);
      }
    }
    return out.toString();
  }
}
