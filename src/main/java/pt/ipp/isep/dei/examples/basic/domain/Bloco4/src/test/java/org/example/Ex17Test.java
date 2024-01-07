package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex17Test {

    @Test
    void verificarSeRetangular2x3True() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        //Act
        boolean res = Ex17.verificarSeRetangular(matrix);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarSeRetangular3x2True() {
        //Arrange
        int[][] matrix = {{1, 2}, {4, 5}, {7, 8}};
        //Act
        boolean res = Ex17.verificarSeRetangular(matrix);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarSeRetangularVazia() {
        //Arrange
        int[][] matrix = {};
        //Act
        boolean res = Ex17.verificarSeRetangular(matrix);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarSeRetangularMatrizquadradaFalse() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //Act
        boolean res = Ex17.verificarSeRetangular(matrix);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarSeRetangularMatrizIrregularFalse() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
        //Act
        boolean res = Ex17.verificarSeRetangular(matrix);
        //Assert
        assertFalse(res);
    }
}