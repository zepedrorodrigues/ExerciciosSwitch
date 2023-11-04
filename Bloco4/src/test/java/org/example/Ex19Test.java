package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex19Test {

    @Test
    void verificarDeterminanteLaplace2x2() {
        // Arrange
        int[][] matriz = {{1, 2}, {3, 4}};
        int expected = -2;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteLaplace3x3comZero() {
        // Arrange
        int[][] matriz = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int expected = 0;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteLaplace4x4() {
        // Arrange
        int[][] matriz = {{-1, 0, 0, -2}, {1, 0, 5, -5}, {0, 1, 4, 0}, {0, 0, -5, 0}};
        int expected = -35;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteLaplace5x5() {
        // Arrange
        int[][] matriz = {{1, 2, 3, 4, 5}, {2, 3, 4, 5, 1}, {3, 4, 5, 1, 2}, {4, 5, 1, 2, 3}, {5, 1, 2, 3, 4}};
        int expected = 1875;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteMatriz1x1() {
        // Arrange
        int[][] matriz = {{8}};
        int expected = 8;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteInvalido3x2() {
        // Arrange
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        int expected = -1;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteInvalido2x3() {
        // Arrange
        int[][] matriz = {{1, 2}, {3, 4}, {5, 6}};
        int expected = -1;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }

    @Test
    void verificarDeterminanteMatrizVazia() {
        // Arrange
        int[][] matriz = {};
        int expected = -1;
        // Act
        int res = Ex19.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(expected, res);
    }
}