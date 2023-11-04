package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {

    @Test
    void somaElementosVetorDadosValidos() {
        // Arrange
        int[] array = {1, 2, 3, 4, 5};
        int exp = 15;
        // Act
        int res = Ex3.somaElementosVetor(array);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void somaElementosVetorVazio() {
        // Arrange
        int[] array = {};
        int exp = 0;
        // Act
        int res = Ex3.somaElementosVetor(array);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void somaElementosNegativos() {
        // Arrange
        int[] array = {-1, -2, -3, 0};
        int exp = -6;
        // Act
        int res = Ex3.somaElementosVetor(array);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void somaElementosZero() {
        // Arrange
        int[] array = {0, 0, 0, 0, 0};
        int exp = 0;
        // Act
        int res = Ex3.somaElementosVetor(array);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void somaElementosNegativosEPositivos() {
        // Arrange
        int[] array = {-1, 2, -3, 4};
        int exp = 2;
        // Act
        int res = Ex3.somaElementosVetor(array);
        // Assert
        assertEquals(exp, res);
    }
}