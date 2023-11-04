package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex10Test {
    @Test
    void devolverMultiplosDeUmNumeroDadosValidos() {
        //Arrange
        int min = 1;
        int max = 15;
        int num = 3;
        //Act
        int[] expected = {3, 6, 9, 12, 15};
        int[] res = Ex10.devolverMultiplosDeUmNumeroNmIntervalo(min, max, num);
        //Assert
        assertArrayEquals(expected, res);
    }

    @Test
    void devolverMultiplosDeUmNumeroDadosInvalidos() {
        //Arrange
        int min = 1;
        int max = 15;
        int multiplo = 0;
        //Act
        int[] expected = {};
        int[] res = Ex10.devolverMultiplosDeUmNumeroNmIntervalo(min, max, multiplo);
        //Assert
        assertArrayEquals(expected, res);
    }

    @Test
    void devolverMultiplosdeUmNumeroIntervaloUnico() {
        //Arrange
        int min = 2;
        int max = 2;
        int multiplo = 1;
        //Act
        int[] exp = {2};
        int[] res = Ex10.devolverMultiplosDeUmNumeroNmIntervalo(min, max, multiplo);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverMultiplosDeUmNumeroNegativo() {
        //Arrange
        int min = 1;
        int max = 5;
        int multiplo = -1;
        //Act
        int[] expected = {1, 2, 3, 4, 5};
        int[] res = Ex10.devolverMultiplosDeUmNumeroNmIntervalo(min, max, multiplo);
        //Assert
        assertArrayEquals(expected, res);
    }

    @Test
    void devolverMultiplosDeUmNumeroArrayVazio() {
        //Arrange
        int min = 1;
        int max = 5;
        int multiplo = 7;
        //Act
        int[] expected = {};
        int[] res = Ex10.devolverMultiplosDeUmNumeroNmIntervalo(min, max, multiplo);
        //Assert
        assertArrayEquals(expected, res);
    }
}