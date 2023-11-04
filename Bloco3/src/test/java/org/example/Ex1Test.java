package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {
    @Test
    void exercicio1invalido() {
        int x = -2;
        long expected = -1, result = Ex1.numeroFatorial(x);
        assertEquals(expected, result);
    }

    @Test
    void exercicio1CincoFatorial() {
        int num = 5;
        long expected = 120, result = Ex1.numeroFatorial(num);
        assertEquals(expected, result);
    }

    @Test
    void exercicio1ZeroFatorial() {
        int num = 0;
        long expected = 1, result = Ex1.numeroFatorial(num);
        assertEquals(expected, result);
    }

    @Test
    void exercicio1FatorialDemasiadoGrande() {
        int num = 25;
        long expected = -1, result = Ex1.numeroFatorial(num);
        assertEquals(expected, result);
    }
}