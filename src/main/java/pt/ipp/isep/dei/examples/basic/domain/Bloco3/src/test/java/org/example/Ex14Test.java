package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex14Test {
    @Test
    void devolverNumeroDumArray() {
        int num = 14240167, numDireita = 6;
        int[] exp = {1, 4, 2, 4, 0, 1, 6, 7, 6}, res = Ex14.devolvernumerodumarray(num, numDireita);
        assertArrayEquals(exp, res);
    }

    @Test
    void testarValidade() {
        int num = 14240167, numDireita = 6;
        boolean exp = true, res = Ex14.testarValidade(num, numDireita);
        assertEquals(exp, res);
    }

    @Test
    void testarValidadeZero() {
        int num = 0, numDireita = 0;
        boolean exp = false, result = Ex14.testarValidade(num, numDireita);
        assertEquals(exp, result);
    }

    @Test
    void devolverComNumerosZero() {
        int n = 1000000, nDireita = 0;
        int[] exp = {1, 0, 0, 0, 0, 0, 0, 0}, res = Ex14.devolvernumerodumarray(n, nDireita);
        assertArrayEquals(exp, res);
    }
}