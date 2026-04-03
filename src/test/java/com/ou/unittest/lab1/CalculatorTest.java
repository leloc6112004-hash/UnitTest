package com.ou.unittest.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator; // Tạo 1 biến từ lớp Calculator bên file src với 1 biến tham chiếu từ lớp Calculator

    @BeforeEach
    void setUp(){
        //ARRANGE
        calculator=new Calculator();
    }

    @Test
    @DisplayName("Add two positive numbers")
    // Method_Scinario_ExpectedResult
    void add_positiveNumbers_returnSum() {
        // AAA - ARRANGE, ACT, ASSERT
        // ARRANGE
        // calculator = new Calculator(); // ARRANGE là khởi tạo
        // ACT
        int result = calculator.add(4, 1); // ACT chuẩn bị dữ liệu để test thường gọi 1 hàm câu ngắn gọn
        // ASSERT
        assertEquals(5, result); // Kết quả mong đợi là 5 và truyền 2 số vào cho hàm add ở đây 2+3= mấy?kqmđ là 5
    }

    @Test
    @DisplayName("Add two negative numbers")
     void add_negativeNumbers_returnSum() {
        // AAA - ARRANGE, ACT, ASSERT
        // ARRANGE
        // calculator = new Calculator(); // ARRANGE là khởi tạo
        // ACT
        int result = calculator.add(-1, -1); // ACT chuẩn bị dữ liệu để test thường gọi 1 hàm câu ngắn gọn
        // ASSERT
        assertEquals(-2, result); // Kết quả mong đợi là 5 và truyền 2 số vào cho hàm add ở đây 2+3= mấy?kqmđ là 5
    }

    @Test
    @DisplayName("subtract two positive numbers")
     void subtract_positiveNumbers_returnDifference() {
        int result = calculator.subtract(5, 3); 
        assertEquals(2, result);
    }

      @Test
    @DisplayName("subtract two negative numbers")
     void subtract_negativeNumbers_returnDifference() {
        int result = calculator.subtract(-5, -3); 
        assertEquals(-2, result);
    }

    @Test
    @DisplayName("Multifly two positive numbers")
     void Multifly_positiveNumbers_returnProduct() {
        int result = calculator.multiply(5, 3); 
        assertEquals(15, result);
    }

    @Test
    @DisplayName("Multifly two negative numbers")
     void Multifly_negativeNumbers_returnProduct() {
        int result = calculator.multiply(5, -3); 
        assertEquals(-15, result);
    }

    @Test
    @DisplayName("Divide by zero throws expection")
     void divide_byZero_throwsException() {
        Exception e= assertThrows(IllegalArgumentException.class, 
                    () -> calculator.divide(10, 0));
        assertTrue(e.getMessage().contains("Cannot divide by zero"));
    }
}
