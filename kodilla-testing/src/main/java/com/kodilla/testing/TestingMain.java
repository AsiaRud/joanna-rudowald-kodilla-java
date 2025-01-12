package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        }else{
            System.out.println("test FAIL");
        }


        Calculator calculator = new Calculator(10, 7);

        int addResult = calculator.add(calculator.getA(), calculator.getB());
        int subResult = calculator.subtract(calculator.getA(), calculator.getB());

        if (calculator.getA()+calculator.getB() == addResult) {
            System.out.println("Calculator adding test OK");
        } else {
            System.out.println("Calculator adding test FAIL");
        }

        if (calculator.getA()-calculator.getB() == subResult) {
            System.out.println("Calculator subtracting test OK");
        } else {
            System.out.println("Calculator subtracting test FAIL");
        }
    }
}
