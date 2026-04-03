package com.ou.unittest.lab1;

/**
 * Calculator đơn giản cho Lab01 - Unit testing intro
 */

public class Calculator {
    public int add(int a, int b)
    {
        return a+b;
    }
      public int subtract(int a, int b)
    {
        return a-b;
    }
      public int multiply(int a, int b)
    {
        return a*b;
    }
    public double divide(int a, int b)
    {
        if(b==0)
        {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return (double)a/b;
    }

}
