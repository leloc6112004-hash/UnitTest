package com.ou.unitest.lab1;

/**
 * Calculator đơn giản cho Lab 01 - Unit testing intro
 * https://maven.apache.org/download.cgi -> apache-maven-3.9.x.zip -> extract vào 1 program file C:\mvn\apache-maven-3.9.12
 * Cấu hình biến môi trường -> Nhấn phím Window + gõ env -> Chọn Edit the system env variables 
 * Nhấn nút Env variables 
 * Tại mục System variables => New -> tạo biến MAVEN_HOME / C:\mvn\apache-maven-3.9.12
 * Path => Edit -> New -> %MAVEN_HOME%\bin => OK
 * Google: Add env Maven home 
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double) a / b;
    }
}
