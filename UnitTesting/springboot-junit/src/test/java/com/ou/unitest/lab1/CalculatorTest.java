package com.ou.unitest.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // ARRANGE
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Add two positive numbers")
    // Method_Scenario_ExpectedResult
    void add_positiveNumbers_returnSum() {
        // ACT
        int result = calculator.add(4, 1);

        // ASSERT
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Add two negative numbers")
    void add_negativeNumbers_returnSum() {
        // ACT
        int result = calculator.add(-1, -1);

        // ASSERT
        assertEquals(-2, result);
    }

    @Test
    @DisplayName("subtract two positive numbers")
    void subtract_positiveNumbers_returnDifference() {
        // ACT
        int result = calculator.subtract(5, 3);

        // ASSERT
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Multifly two positive numbers")
    void multifly_positiveNumbers_returnProduct() {
        // ACT
         int result = calculator.multiply(5, 3);

         // ASSERT
         assertEquals(15, result);
     }

     @Test
     @DisplayName("Divide by zero throws exception")
     void divide_byZero_throwsException() {
         // ACT
         Exception e = assertThrows(IllegalArgumentException.class, 
             () -> calculator.divide(10, 0)
         );

         // ASSERT
         assertTrue(e.getMessage().contains("Cannot divide by zero"));
    }
}
