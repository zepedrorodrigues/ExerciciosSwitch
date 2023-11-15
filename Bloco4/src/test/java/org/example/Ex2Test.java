package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
    @Test
    void devolverNumerosDentroDeUmArrayNumeroPositivo() {
        // Arrange
        int num = 36781;
        int[] exp = {3, 6, 7, 8, 1};
        // Act
        int[] res = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        // Assert
        assertArrayEquals(exp, res);}
    @Test
    void devolverNumerosDentroDeumArrayUm(){
        //Arrange
        int num = 1;
        int[] exp = {1};
        //Act
        int[]res = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        //Assert
        assertArrayEquals(exp,res);}
    @Test
    void devolverNumerosDentroDeumArrayUmNegativo(){
        //Arrange
        int num = -1;
        int[] exp = {};
        //Act
        int[]res = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        //Assert
        assertArrayEquals(exp,res);}

    @Test
    void devolverNumerosDentroDeUmArrayNumeroNegativo() {
        // Arrange
        int num = -36781;
        int[] exp = {};
        // Act
        int[] res = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        // Assert
        assertArrayEquals(exp, res);}

    @Test
    void devolverNumerosDentroDeUmArrayZero() {
        // Arrange
        int num = 0;
        int[] exp = {};
        // Act
        int[] res = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        // Assert
        assertArrayEquals(exp, res);
    }
}