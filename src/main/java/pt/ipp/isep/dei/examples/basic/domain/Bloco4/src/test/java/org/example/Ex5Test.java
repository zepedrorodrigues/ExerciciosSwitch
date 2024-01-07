package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex5Test {

    @Test
    void elementosImparesDoVetorValoresPositivos() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        int[] exp = {1, 3, 5};
        //Act
        int[] res = Ex5.elementosImparesDoVetor(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void elementosImparesDoVetorSemImpares() {
        //Arrange
        int[] array = {2, 4, 6, 8, 10};
        int[] exp = {};
        //Act
        int[] res = Ex5.elementosImparesDoVetor(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void elementosImparesDoVetorVazio() {
        //Arrange
        int[] array = {};
        int[] exp = {};
        //Act
        int[] res = Ex5.elementosImparesDoVetor(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void elementosImparesDoVetorDadosValidosNegativoseZero() {
        //Arrange
        int[] array = {0, -1, -2, -3, -4, -5};
        int[] exp = {-1, -3, -5};
        //Act
        int[] res = Ex5.elementosImparesDoVetor(array);
        //Assert
        assertArrayEquals(exp, res);
    }
}