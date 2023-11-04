package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex7Test {

    @Test
    void devolvePosicaodoArrayInvalido() {
        int[] arr = {-1,2,3,4};
        int num = 7, exp = -1, res = Ex7.devolvePosicaodoArray(arr,num);
        assertEquals(exp,res);
    }
    @Test
    void devolvePosicaodoArrayValido(){
        int[] arr = {1,2,3,4,5,6};
        int num = 6, exp = 4, res = Ex7.devolvePosicaodoArray(arr,num);
        assertEquals(exp,res);
    }
    @Test
    void devolveposicaoArrayVazio(){
        int[] n = {};
        int num = 7, exp = -1, res = Ex7.devolvePosicaodoArray(n,num);
        assertEquals(exp,res);
    }
}