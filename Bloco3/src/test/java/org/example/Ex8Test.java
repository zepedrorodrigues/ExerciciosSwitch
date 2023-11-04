package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex8Test {
    @Test
    public void numerosIguaisouInferioresaY() {
        int Y = 3;
        int[] expected = {0, 1, 2, 3}, result = Ex8.devolveNumerosIguaisouInferioresaY(Y);
        assertArrayEquals(expected, result);
    }

    @Test
    public void numerosIguaisouInferioresaNegativo() {
        int Y = -3;
        int[] expected = {}, result = Ex8.devolveNumerosIguaisouInferioresaY(Y);
        assertArrayEquals(expected, result);
    }

    @Test
    public void somaNumeros() {
        int[] numeros = {0, 1, 2, 3};
        int Y = 3, expected = 2, result = Ex8.somaNumerosquedeemY(numeros, Y);
        assertEquals(expected, result);
    }

    @Test
    void numerovalido5() {
        int Y = 5, exp = 3, result = Ex8.exercicio8(Y);
        assertEquals(exp, result);
    }

    @Test
    void numeroinvalido30() {
        int Y = 30, expected = -1, result = Ex8.exercicio8(Y);
        assertEquals(expected, result);
    }

    @Test
    void numeroinvalidoMenos10() {
        int Y = -10, expected = -1, result = Ex8.exercicio8(Y);
        assertEquals(expected, result);
    }

    @Test
    void numerosvalidos12() {
        int Y = 12, result = 4, expected = Ex8.exercicio8(Y);
        assertEquals(result, expected);
    }

    @Test
    void numerosvalidos0() {
        int Y = 0, result = 0, expected = Ex8.exercicio8(Y);
        assertEquals(result, expected);
    }

    @Test
    void numerosvalidos1() {
        int Y = 1, result = 1, expected = Ex8.exercicio8(Y);
        assertEquals(result, expected);
    }
}