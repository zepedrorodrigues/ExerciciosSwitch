package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex16Test {

    @Test
    void numeroPerfeito() {
        int num = 6, exp = 0, result = Ex16.classificacaoNumeros(num);
        assertEquals(exp, result);
    }

    @Test
    void numeroAbundante() {
        int n = 12, exp = 1, res = Ex16.classificacaoNumeros(n);
        assertEquals(exp, res);
    }

    @Test
    void numeroReduzido() {
        int n = 9, exp = -1, res = Ex16.classificacaoNumeros(n);
        assertEquals(exp, res);
    }

    @Test
    void numeroInvalidoNegativo() {
        int n = -2, exp = 2, res = Ex16.classificacaoNumeros(n);
        assertEquals(exp, res);
    }

    @Test
    void numeroInvalidoZero() {
        int n = 0, exp = 2, res = Ex16.classificacaoNumeros(n);
        assertEquals(exp, res);
    }

    @Test
    void numeroReduzidoCasoFronteira() {
        int n = 1, exp = -1, res = Ex16.classificacaoNumeros(n);
        assertEquals(exp, res);
    }
}