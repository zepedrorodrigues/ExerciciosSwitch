package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex15Test {
    @Test
    void dividirArrayemPareseImpares789456234() {
        int[] n = {7,8,9,4,5,6,2,3,4}, exp = {7,9,5,3,8,4,6,2,4}, res = Ex15.DividirArrayemPareseImpares(n);
        assertArrayEquals(exp,res);
    }
    @Test
    void dividirArrayemPareseImpares789Menos46234(){
        int [] n = {7,8,9,-4,6,2,3,4}, exp = {}, res = Ex15.DividirArrayemPareseImpares(n);
        assertArrayEquals(exp,res);
    }
    @Test
    void dividirArrayemPareseImpares789DEZ4623(){
        int[] n = {7,8,9,10,4,6,2,3}, exp = {}, res = Ex15.DividirArrayemPareseImpares(n);
        assertArrayEquals(exp,res);
    }
}