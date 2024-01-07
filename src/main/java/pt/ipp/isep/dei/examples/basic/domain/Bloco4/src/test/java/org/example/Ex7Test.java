package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex7Test {
    @Test
    void devolverSomaDosImparesZero() {
        //Arrange
        int value = 0;
        //Act
        int exp = -1;
        int res = Ex7.devolverSomaDosImpares(value);
        //Assert
        assertEquals(exp, res);}

    @Test
    void devolverSomaDosImparesNegativos() {
        //Arrange
        int value = -123;
        //Act
        int exp = -1;
        int res = Ex7.devolverSomaDosImpares(value);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverSomaDosImpares() {
        //Arrange
        int value = 123;
        //Act
        int exp = 4;
        int res = Ex7.devolverSomaDosImpares(value);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverSomaDosImparesComZeros() {
        //Arrange
        int value = 10000;
        int exp = 1;
        //Act
        int res = Ex7.devolverSomaDosImpares(value);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void somaDosValoresDeUmArray() {
        //Arrange
        int[] value = {1, 2, 3};
        //Act
        int exp = 6;
        int res = Ex7.somaDosValoresDumArray(value);
        //Assert
        assertEquals(exp, res);}

    @Test
    void somaDosValoresDeUmArrayComZerosENegativos() {
        //Arrange
        int[] value = {1, -2, 1, 0};
        //Act
        int exp = 0;
        int res = Ex7.somaDosValoresDumArray(value);
        //Assert
        assertEquals(exp, res);}

    @Test
    void somaDosValoresArrayVazio() {
        //Arrange
        int[] value = {};
        //Act
        int exp = 0;
        int res = Ex7.somaDosValoresDumArray(value);
        //Assert
        assertEquals(exp, res);}
}