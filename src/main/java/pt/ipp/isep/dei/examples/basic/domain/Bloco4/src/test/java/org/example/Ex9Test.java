package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Ex9Test {

    @Test
    void devolverMultiplosDeTres() {
        //Arrange
        int min = 1;
        int max = 10;
        //Act
        int[] exp = {3, 6, 9};
        int[] res = Ex9.devolverMultiplosDe3DeUmIntervalo(min, max);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverMultiplosDeTresNegativos() {
        //Arrange
        int min = -9;
        int max = 9;
        //Act
        int[] exp = {-9, -6, -3, 0, 3, 6, 9};
        int[] res = Ex9.devolverMultiplosDe3DeUmIntervalo(min, max);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverMultiplosDeTresMinIgualMax() {
        //Arrange
        int min = 3;
        int max = 3;
        //Act
        int[] exp = {3};
        int[] res = Ex9.devolverMultiplosDe3DeUmIntervalo(min, max);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverMultiplosDeTresMinMaiorMax() {
        //Arrange
        int min = 10;
        int max = 1;
        //Act
        int[] exp = {};
        int[] res = Ex9.devolverMultiplosDe3DeUmIntervalo(min, max);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverMultiplosDeTresVazio() {
        //Arrange
        int min = 1;
        int max = 2;
        //Act
        int[] exp = {};
        int[] res = Ex9.devolverMultiplosDe3DeUmIntervalo(min, max);
        //Assert
        assertArrayEquals(exp, res);
    }
}