package org.example;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Ex4Test {
    @Test
    void guardarAlgarismosNumArray() {
        long num = 123;
        int[] expected = {3, 2, 1};
        int[] res = Ex4.guardarAlgarismosNumArray(num);
        assertArrayEquals(expected, res);
    }

    @Test
    void guardarAlgarismosNumArrayNumNegativo() {
        long num = -123;
        int[] expected = {3, 2, 1};
        int[] res = Ex4.guardarAlgarismosNumArray(num);
        assertArrayEquals(expected, res);
    }

    @Test
    void guardarArrayAlgarismosPares() {
        long num = 12304;
        boolean opcao = true;
        int[] expected = {4, 0, 2};
        int[] res = Ex4.guardarArrayAlgarismosParesImpares(Ex4.guardarAlgarismosNumArray(num), opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void algarismosDeUmNumero() {
        long numero = 123;
        int expected = 3;
        int res = Ex4.algarismosDeUmNumero(numero);
        assertEquals(expected, res);
    }

    @Test
    void algarismosDeUmNumeroNegativo() {
        long numero = -123;
        int expected = 3;
        int res = Ex4.algarismosDeUmNumero(numero);
        assertEquals(expected, res);
    }

    @Test
    void algarismosDeUmNumeroZero() {
        long numero = 0;
        int expected = 1;
        int res = Ex4.algarismosDeUmNumero(numero);
        assertEquals(expected, res);
    }

    @Test
    void guardarAlgarismosNumArrayTest() {
        long numero = 123;
        int[] expected = {3, 2, 1};
        int[] res = Ex4.guardarAlgarismosNumArray(numero);
        assertArrayEquals(expected, res);
    }

    @Test
    void guardarAlgarismosNumArrayTestNegativo() {
        long numero = -123;
        int[] expected = {3, 2, 1};
        int[] res = Ex4.guardarAlgarismosNumArray(numero);
        assertArrayEquals(expected, res);
    }

    @Test
    void algarismosParesTest() {
        long numero = 123;
        boolean opcao = true;
        int expected = 1;
        int res = Ex4.numerosDeAlgarismosPares(numero, opcao);
        assertEquals(expected, res);
    }

    @Test
    void algarismosImpares() {
        long numero = 123;
        boolean opcao = false;
        int expected = 2;
        int res = Ex4.numerosDeAlgarismosPares(numero, opcao);
        assertEquals(expected, res);
    }

    @Test
    void algarismosParesZero() {
        long numero = 1230;
        boolean opcao = true;
        int expected = 2;
        int res = Ex4.numerosDeAlgarismosPares(numero, opcao);
        assertEquals(expected, res);
    }

    @Test
    void somaDeAlgarismosNumeroTest() {
        long numero = 123;
        int expected = 6;
        int res = Ex4.somaDeAlgarismosNumero(numero);
        assertEquals(expected, res);
    }

    @Test
    void somaDeAlgarismosParesTest() {
        long numero = 1230;
        boolean opcao = true;
        int expected = 2;
        int res = Ex4.somaDeAlgarismosPares(numero, opcao);
        assertEquals(expected, res);
    }

    @Test
    void somaDeAlgarismosImparesTest() {
        long numero = 1230;
        boolean opcao = false;
        int expected = 4;
        int res = Ex4.somaDeAlgarismosPares(numero, opcao);
        assertEquals(expected, res);
    }

    @Test
    void mediaDeAlgarismosNumerosTest() {
        long numero = 1230;
        float expected = 1.5F;
        float res = Ex4.mediaDeAlgarismosNumero(numero);
        assertEquals(expected, res);
    }

    @Test
        //acrescentei este, tenho dificuldade em acrescentar outros considerando que
        // para chegar a este já se fez um array testado
    void somaAlgarismosArray() {
        int[] array = {1, 2, 3};
        int expected = 6, result = Ex4.somaAlgarismosArray(array);
        assertEquals(expected, result);
    }

    @Test
    void devolverNumeroInverso() {
        int num = 789, exp = 987, result = Ex4.devolverNumeroInverso(num);
        assertEquals(exp, result);
    }

    @Test
    void devolverNumeroInversoNegativo() {
        int num = -697, exp = -796, result = Ex4.devolverNumeroInverso(num);
        assertEquals(exp, result);
    }

    @Test
    void devolverInversoZero() {
        int x = 0, exp = 0, res = Ex4.devolverNumeroInverso(x);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismoPares() {
        boolean opcao = true;
        long num = 7898;
        float exp = 8.0f, res = Ex4.mediadeAlgarismosParesNumero(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosParesZero() {
        long num = 0;
        float exp = 0, res = Ex4.mediadeAlgarismosParesNumero(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosPares11() {
        long num = 11;
        float exp = -1, res = Ex4.mediadeAlgarismosParesNumero(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosParesNegativo() {
        long num = -675;
        float exp = 6, res = Ex4.mediadeAlgarismosParesNumero(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosImpares() {
        long num = 43528;
        float exp = 4, res = Ex4.mediaDeAlgarismosImpares(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosImparesZero() {
        long num = 0;
        float exp = -1, res = Ex4.mediaDeAlgarismosImpares(num);
        assertEquals(exp, res);
    }

    @Test
    void mediaAlgarismosImparesNegativo() {
        long num = -657;
        float exp = 6, res = Ex4.mediaDeAlgarismosImpares(num);
        assertEquals(exp, res);
    }
}