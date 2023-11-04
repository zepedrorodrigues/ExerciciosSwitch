package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex16Test {
    @Test
    void verificarSeQuadrado() {
        //Arrange
        int[][] matrix = {{3, 4, 5}, {5, 6, 7}, {7, 8, 9}};
        //Act
        boolean res = Ex16.verificarSeQuadrado(matrix);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarSeQuadradoNaoQuadrado() {
        //Arrange
        int[][] matrix = {{1}, {2, 3, 4}, {4, 5, 7}};
        //Act
        boolean res = Ex16.verificarSeQuadrado(matrix);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarSeQuadradoArrayVazio() {
        //Arrange
        int[][] matrix = {};
        //Act
        boolean res = Ex16.verificarSeQuadrado(matrix);
        //Assert
        assertFalse(res);
    }
}