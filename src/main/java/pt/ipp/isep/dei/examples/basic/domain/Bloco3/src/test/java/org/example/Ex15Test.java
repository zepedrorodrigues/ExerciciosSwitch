package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex15Test {
    @Test
    void dividirArrayemPareseImpares789456234() {
        int[] n = {7, 8, 9, 4, 5, 6, 2, 3, 4}, exp = {7, 9, 5, 3, 8, 4, 6, 2, 4}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }

    @Test
    void dividirArrayemPareseImparesOrdenado() {
        int[] n = {9, 7, 5, 3, 1, 8, 6, 4, 2}, exp = {9, 7, 5, 3, 1, 8, 6, 4, 2}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }

    @Test
    void dividirArrayemPareseImparesDesrdenado() {
        int[] n = {8, 6, 4, 2, 9, 7, 5, 3, 1}, exp = {9, 7, 5, 3, 1, 8, 6, 4, 2}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }

    @Test
    void dividirArrayemPareseImparesNegativo() {
        int[] n = {7, 8, 9, -4, 6, 2, 3, 4}, exp = {}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }

    @Test
    void dividirArrayemPareseImparesDez() {
        int[] n = {7, 8, 9, 10, 4, 6, 2, 3}, exp = {}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }

    @Test
    void dividirArrayemPareseImparesZero() {
        int[] n = {7, 8, 9, 0, 4, 6, 2, 3}, exp = {}, res = Ex15.dividirArrayEmPareseImpares(n);
        assertArrayEquals(exp, res);
    }
}