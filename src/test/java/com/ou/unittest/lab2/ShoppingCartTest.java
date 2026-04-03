package com.ou.unittest.lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp(){
        cart=new ShoppingCart();
    }

    @Test
    @DisplayName("Calculate total with one product and no discount")
    void CalculateTotal_withOneProductNoDiscount_returnSubtotal()
    {
        //ARRANGE
        Product laptop=new Product("Laptop", 1000.0);
        cart.addItem(laptop, 2);
        //ACT
        double total=cart.CalculateTotal(null);
        //ASSERT
        assertEquals(2000.0, total);
    }

}
