package com.sg.craftsmanship.katas.bdd;

public class Calculator {
    private double result = 0;
    private Operators operator;

    Operators getOperator() {
        return operator;
    }

    void setOperator(Operators operator) {
        this.operator = operator;
    }

    public void operate(double value, Operators operator) {

        switch (operator) {

            case Plus:
                result += value;
                break;
            case Minus:
                result -= value;
                break;
            case Multiply:
                result *= value;
                break;
            case Divide:
                if (value == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                } else {
                    result /= value;
                }
                break;
            case None:
                result = value;
                break;
            case Equal:
                break;
        }

    }

    public double getResult() {
        return result;
    }

    public void clear() {
        result = 0;
    }
}
