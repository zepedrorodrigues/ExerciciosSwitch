package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ex6Test {
    @Test
    void devolverSomaDosParesValido() {
        //Arrange
        int num = 789;
        //Act
        int exp = 8;
        int res = Ex6.devolverSomaDosPares(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverSomaDosParesNumeroSoComImpares() {
        //Arrange
        int num = 777;
        //Act
        int exp = 0;
        int res = Ex6.devolverSomaDosPares(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverSomaDosParesZero() {
        //Arrange
        int num = 0;
        //Act
        int exp = -1;
        int res = Ex6.devolverSomaDosPares(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void somaDosValoresDumArray() {
        //Arrange
        int[] num = {7, 8, 9};
        //Act
        int exp = 24;
        int res = Ex6.somadosValoresDumArray(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void somaDosValoresDumArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        int exp = 0;
        int res = Ex6.somadosValoresDumArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void somaDosValoresDumArrayComZeroENegativos() {
        //Arrange
        int[] array = {0, -2, 3, 5, 6};
        //Act
        int exp = 12;
        int res = Ex6.somadosValoresDumArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverSomaDosParesNegativo() {
        //Arrange
        int num = -789;
        //Act
        int exp = -1;
        int res = Ex6.devolverSomaDosPares(num);
        //Assert
        assertEquals(exp, res);
    }
}