package com.epam.alexander_rybalko.java.lesson1.task3;

/**
 * Created by Acer on 17.02.2018.
 */
public class Task3 {

    public double calculate(int a, int b, String op) {
        double result = 0;
        switch (op) {
            case "+": {
                result = getSum(a, b);
                break;
            }
            case "-": {
                result = getSubtract(a, b);
                break;
            }
            case "*": {
                result = getMultiply(a, b);
                break;
            }
            case "/": {
                result = getDivision(a, b);
                break;
            }
            default:{
                throw new ArithmeticException("Bad operation");
            }
        }
        return result;
    }

    private double getDivision(int a, int b) {
        return a * 1.0 / b;
    }

    private double getMultiply(int a, int b) {
        return a * b;
    }

    private double getSubtract(int a, int b) {
        return a - b;
    }

    private double getSum(int a, int b) {
        return a + b;
    }
}
