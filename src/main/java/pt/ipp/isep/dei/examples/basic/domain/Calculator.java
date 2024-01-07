package pt.ipp.isep.dei.examples.basic.domain;

/**
 * Calculator class.
 * This class is very simple in order to demonstrate how to build test cases for Unit Testing.
 */
public class Calculator {

    /**
     * Sums one operand to the other, returning the result.
     *
     * @param firstOperand  First operand to sum.
     * @param secondOperand Second Operand to sum.
     * @return The sum of firstOperand with secondOperand.
     */
    public int sum(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int divide(int dividend, int divisor) {
        throw new UnsupportedOperationException();
    }

    public int multiply(int dividend, int divisor) {
        throw new UnsupportedOperationException();
    }

    public int factorial(int number) {
        throw new UnsupportedOperationException();
    }

    /*
    public int subtract(int firstOperand, int secondOperand) {
        throw new UnsupportedOperationException();
    }
    */
}
