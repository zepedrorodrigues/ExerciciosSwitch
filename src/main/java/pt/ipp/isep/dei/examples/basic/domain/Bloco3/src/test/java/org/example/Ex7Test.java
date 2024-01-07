package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex7Test {

    @Test
    void testeComQuatroNumeros() {
        int[] array = {1, 2, 3, 4};
        int exp = 3;
        int res = Ex7.arrayPositivos(array, 12);
        assertEquals(exp, res);
    }

    @Test
    void testeComZeroNoArray() {
        int[] array = {0, 1, 2, 3, 4};
        int exp = -1;
        int res = Ex7.arrayPositivos(array, 5);
        assertEquals(exp, res);
    }

    @Test
    void testeComNumerosNegativos() {
        int[] array = {-1, -2, -3, -4};
        int exp = -1;
        int res = Ex7.arrayPositivos(array, 12);
        assertEquals(exp, res);
    }

    @Test
    void testeComArrayVazio() {
        int[] array = {};
        int exp = -1;
        int res = Ex7.arrayPositivos(array, 12);
        assertEquals(exp, res);
    }
}