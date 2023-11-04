package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {
    @Test
    void somanumerosParesPositivo() {
        int expected = 6;
        int resulted = Ex3.somaNumero(0, 4, true);
        assertEquals(expected, resulted);
    }

    @Test
    void somanumerosParesNegativo() {
        int expected = -6;
        int resulted = Ex3.somaNumero(-4, 0, true);
        assertEquals(expected, resulted);
    }

    @Test
    void somanumerosParesZero() {
        int expected = 0;
        int resulted = Ex3.somaNumero(0, 0, true);
        assertEquals(expected, resulted);
    }

    @Test
    void somanumerosImparesPositivo() {
        int expected = 4;
        int resulted = Ex3.somaNumero(0, 3, false);
        assertEquals(expected, resulted);
    }

    @Test
    void numerosImparesNegativo() {
        int expected = -4;
        int resulted = Ex3.somaNumero(-3, 0, false);
        assertEquals(expected, resulted);
    }

    @Test
    void numerosImparesZero() {
        int expected = 0;
        int resulted = Ex3.somaNumero(0, 0, false);
        assertEquals(expected, resulted);
    }

    @Test
    void quantidadeNumerosParPositivo() {
        int expected = 2;
        int result = Ex3.quantidadeNumeros(0, 2, true);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeNumerosParNeg() {
        int expected = 2;
        int result = Ex3.quantidadeNumeros(-2, 0, true);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeNumerosParZero() {
        int expected = 1;
        int result = Ex3.quantidadeNumeros(0, 0, true);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeNumerosImparPositivo() {
        int expected = 2;
        int result = Ex3.quantidadeNumeros(0, 3, false);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeNumerosImparNegativo() {
        int expected = 2;
        int result = Ex3.quantidadeNumeros(-3, 0, false);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeNumerosImparZero() {
        int expected = 0;
        int result = Ex3.quantidadeNumeros(0, 0, false);
        assertEquals(expected, result);
    }

    @Test
    void somaMultiplosPositivo() {
        int expected = 6;
        int result = Ex3.somaMultiplos(0, 4, 2);
        assertEquals(expected, result);
    }

    @Test
    void somaMultiplosNegativo() {
        int expected = -4;
        int result = Ex3.somaMultiplos(-5, 3, 2);
        assertEquals(expected, result);
    }

    @Test
    void somaMultiplosIntervaloZero() {
        int expected = 0;
        int result = Ex3.somaMultiplos(0, 0, 2);
        assertEquals(expected, result);
    }

    @Test
    void somaMultiplosInvalido() {
        int expected = -1;
        int result = Ex3.somaMultiplos(10, 20, 0);
        assertEquals(expected, result);
    }

    @Test
    void produtoMultiplosPositivo() {
        int expected = 48;
        int result = Ex3.produtoMultiplos(2, 6, 2);
        assertEquals(expected, result);
    }

    @Test
    void produtoMultiplosNegativo() {
        int expected = 0;
        int result = Ex3.produtoMultiplos(-5, 12, 2);
        assertEquals(expected, result);
    }

    @Test
    void produtoMultiplosNegativosemZero() {
        int expected = -3;
        int result = Ex3.produtoMultiplos(-5, -1, 3);
        assertEquals(expected, result);
    }

    @Test
    void produtoMultiplosArrayNulo() {
        int expected = 0;
        int result = Ex3.produtoMultiplos(-5, -2, 11);
        assertEquals(expected, result);
    }

    @Test
    void produtoMultiplosInválido() {
        int expected = -1;
        int result = Ex3.produtoMultiplos(0, 0, 0);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeMultiplos() {
        int expected = 3;
        int result = Ex3.quantidadeMultiplos(2, 6, 2);
        assertEquals(expected, result);
    }

    @Test
    void quantidadeMultiplosArrayVazio() {
        int min = 2, max = 12, mult = 20;
        int exp = 0, res = Ex3.quantidadeMultiplos(min, max, mult);
        assertEquals(exp, res);
    }

    @Test
    void quantidadeMultiplosArrayInválido() {
        int min = 2, max = 20, mult = 0, exp = -1, res = Ex3.quantidadeMultiplos(min, max, mult);
        assertEquals(exp, res);
    }

    @Test
    void mediaMultiplos1numero() {
        int expected = 2;
        int result = Ex3.mediaMultiplos1numero(0, 4, 2);
        assertEquals(expected, result);
    }
}
