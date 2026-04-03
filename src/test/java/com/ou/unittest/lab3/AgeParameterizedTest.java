package com.ou.unittest.lab3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class AgeParameterizedTest {

    private Age age;

    @BeforeEach
    void setUp() {
        // ARRANGE
        age = new Age();
    }

    // @Test
    // @DisplayName("Check working age positive numbers invalid")
    // // Method_Scinario_ExpectedResult
    // void isWorkingAge_positiveNumbersInvalid_returnResult() {
    //     // AAA - ARRANGE, ACT, ASSERT
    //     // ARRANGE
    //     // calculator = new Calculator(); // ARRANGE là khởi tạo
    //     // ACT
    //     boolean result = age.isWorkingAge(1); // ACT chuẩn bị dữ liệu để test thường gọi 1 hàm câu ngắn gọn
    //     // ASSERT
    //     assertEquals(false, result); // Kết quả mong đợi là 5 và truyền 2 số vào cho hàm add ở đây 2+3= mấy?kqmđ là 5
    // }

    // @Test
    // @DisplayName("Check working age positive numbers valid")
    // // Method_Scinario_ExpectedResult
    // void isWorkingAge_positiveNumbersValid1_returnResult() {
    //     // AAA - ARRANGE, ACT, ASSERT
    //     // ARRANGE
    //     // calculator = new Calculator(); // ARRANGE là khởi tạo
    //     // ACT
    //     boolean result = age.isWorkingAge(19); // ACT chuẩn bị dữ liệu để test thường gọi 1 hàm câu ngắn gọn
    //     // ASSERT
    //     assertEquals(true, result); // Kết quả mong đợi là 5 và truyền 2 số vào cho hàm add ở đây 2+3= mấy?kqmđ là 5
    // }

    // @Test
    // @DisplayName("Check working age positive numbers valid")
    // // Method_Scinario_ExpectedResult
    // void isWorkingAge_positiveNumbersValid2_returnResult() {
    //     // AAA - ARRANGE, ACT, ASSERT
    //     // ARRANGE
    //     // calculator = new Calculator(); // ARRANGE là khởi tạo
    //     // ACT
    //     boolean result = age.isWorkingAge(65); // ACT chuẩn bị dữ liệu để test thường gọi 1 hàm câu ngắn gọn
    //     // ASSERT
    //     assertEquals(true, result); // Kết quả mong đợi là 5 và truyền 2 số vào cho hàm add ở đây 2+3= mấy?kqmđ là 5
    // }

    @ParameterizedTest
    @CsvSource({
        "1, false",
        "17,false",
        "18,true",
        "19, true",
        "64,true",
        "65, true",
        "66,false"
    })
    void isWorkingAge_csv(int _age, boolean expected){
        assertEquals(expected, age.isWorkingAge(_age));
    }

}
