package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        Calculator calculator = new Calculator(10, 7);

        int addResult = calculator.add(calculator.getA(), calculator.getB());
        int subResult = calculator.subtract(calculator.getA(), calculator.getB());

        if (addResult == 17) {
            System.out.println("Calculator adding test OK");
        } else {
            System.out.println("Calculator adding test FAIL");
        }

        if (subResult == 3) {
            System.out.println("Calculator subtracting test OK");
        } else {
            System.out.println("Calculator subtracting test FAIL");
        }
    }
}
