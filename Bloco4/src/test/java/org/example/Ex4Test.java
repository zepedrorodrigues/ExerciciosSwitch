package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex4Test {
    @Test
    void devolverArraySoComPares() {
        //Arrange
        int[] num = {7, 8, 9, 4, 5, 6, 3, 2, 1};
        int[] exp = {8, 4, 6, 2};
        //Act
        int[] res = Ex4.devolverArraySoComPares(num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverArraySoComParesArrayVazio() {
        //Arrange
        int[] array = {};
        int[] exp = {};
        //Act
        int[] res = Ex4.devolverArraySoComPares(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void estenderArray() {
        //Arrange
        int[] initial = {0, 1, 2, 3, 4};
        int[] exp = {0, 1, 2, 3, 4, 0};
        //Act
        int[] res = Ex4.estenderArray(initial);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void estenderArrayVazio() {
        //Arrange
        int[] num = {};
        int[] exp = {0};
        //Act
        int[] res = Ex4.estenderArray(num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverArraySoComParesSemPares() {
        //Arrange
        int[] num = {7, 7, 7, 7, 7, 7, 7};
        int[] exp = {};
        //Act
        int[] res = Ex4.devolverArraySoComPares(num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverArraySoComParesNegativosEZero() {
        //Arrange
        int[] num = {-6, 2, 5, 4, 3, 0, 5};
        int[] exp = {-6, 2, 4, 0};
        //Act
        int[] res = Ex4.devolverArraySoComPares(num);
        //Assert
        assertArrayEquals(exp, res);
    }
}