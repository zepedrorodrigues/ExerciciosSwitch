package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex11Test {

    @Test
    void multiplosdeNumerosNumArrayNumIntervalo() {
        //Arrange
        int min = 4;
        int max = 12;
        int[] mult = {2, 3};
        //Act
        int[] exp = {6, 12};
        int[] res = Ex11.multiplosdeNumerosNumArrayNumIntervalo(min, max, mult);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void multiplosdeNumerosNumArrayNumIntervalocomZero() {
        //Arrange
        int min = 2;
        int max = 15;
        int[] mult = {0, 3};
        //Act
        int[] exp = {-1};
        int[] res = Ex11.multiplosdeNumerosNumArrayNumIntervalo(min, max, mult);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void multiplosdeNumerosNumArrayNumIntervalocomNegativos() {
        //Arrange
        int min = 2;
        int max = 20;
        int[] mult = {-2, 5};
        //Act
        int[] exp = {10, 20};
        int[] res = Ex11.multiplosdeNumerosNumArrayNumIntervalo(min, max, mult);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void multiplosdeNumerosNumArrayNumIntervalocomArrayVazio() {
        //Arrange
        int min = 2;
        int max = 50;
        int[] mult = {};
        //Act
        int[] exp = {-1};
        int[] result = Ex11.multiplosdeNumerosNumArrayNumIntervalo(min, max, mult);
        //Assert
        assertArrayEquals(exp, result);
    }

    @Test
    void multiplosdeNumerosNumArrayNumIntervaloSemMultiplos() {
        //Arrange
        int min = 2;
        int max = 10;
        int[] mult = {11, 13, 29};
        //Act
        int[] exp = {};
        int[] res = Ex11.multiplosdeNumerosNumArrayNumIntervalo(min, max, mult);
        //Assert
        assertArrayEquals(exp, res);
    }
}