package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex10Test {

    @Test
    void checkIfValidCurrency() {
        String E = "L";
        boolean expected = true, res = Ex10.checkIfValidCurrency(E);
        assertEquals(expected, res);
    }

    @Test
    void checkIfValidCurrencyInvalid() {
        String n = "Florint";
        boolean expected = false, result = Ex10.checkIfValidCurrency(n);
        assertEquals(expected, result);
    }

    @Test
    void currencyConverterLibra() {
        String curr = "L";
        int value = 30;
        double exp = 23.22, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterDolar() {
        String curr = "D";
        int value = 30;
        double exp = 46.02, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterIene() {
        String curr = "I";
        int value = 30;
        double exp = 4844.4, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterCoroaSueca() {
        String curr = "C";
        int value = 30;
        double exp = 287.79, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterFrancoSuico() {
        String curr = "F";
        int value = 30;
        double exp = 48.03, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterInvalido() {
        String curr = "D";
        int value = -30;
        double exp = -1, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res, 0.01);
    }

    @Test
    void currencyConverterZeroFronteira() {
        String curr = "D";
        int value = 0;
        double exp = 0, res = Ex10.currencyConverter(value, curr);
        assertEquals(exp, res);
    }

}