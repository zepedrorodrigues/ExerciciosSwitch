package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex16Test {

    @Test
    void numeroemArray6() {
        int num = 6, exp = 0, result = Ex16.numeroemArray(num);
        assertEquals(exp,result);
    }
    @Test
    void numeroemArray12(){
        int n =12, exp = 1, res = Ex16.numeroemArray(n);
        assertEquals(exp,res);
    }
    @Test
    void numeroemArray9(){
        int n = 9, exp = -1, res = Ex16.numeroemArray(n);
        assertEquals(exp,res);
    }
    @Test
    void numeroemArrayInvalido(){int n =-2, exp = 2, res = Ex16.numeroemArray(n);
    }
    @Test
    void numeroemArrayFronteira(){
        int n = 1, exp = -1, res = Ex16.numeroemArray(n);
        assertEquals(exp,res);
    }
}