package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex14Test {

    @Test
    void produtoEscalarEntre2VetoresCasoPositivo() {
        //Arrange
        int[] vetor1 = {1, 2, 3};
        int[] vetor2 = {4, 5, 6};
        //Act
        int exp = 32;
        int res = Ex14.produtoEscalarEntre2Vetores(vetor1, vetor2);
        //Assert
        assertEquals(exp, res);
    }
    @Test
    void produtoEscalarEntre2VetoresTamanhoDiferente() {
        //Arrange
        int[] vetor1 = {1, 2, 3, 4};
        int[] vetor2 = {4, 5, 6};
        //Act
        int exp = Integer.MIN_VALUE;
        int res = Ex14.produtoEscalarEntre2Vetores(vetor1, vetor2);
        //Assert
        assertEquals(exp, res);
    }
    @Test
    void produtoEscalarEntre2VetoresNegativo() {
        //Arrange
        int[] vetor1 = {-1, -2, -3};
        int[] vetor2 = {4, 5, 6};
        //Act
        int exp = -32;
        int res = Ex14.produtoEscalarEntre2Vetores(vetor1, vetor2);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void produtoEscalarEntre2VetoresZero() {
        //Arrange
        int[] vetor1 = {0, 0, 0};
        int[] vetor2 = {4, 5, 6};
        //Act
        int exp = 0;
        int res = Ex14.produtoEscalarEntre2Vetores(vetor1, vetor2);
        //Assert
        assertEquals(exp, res);}
    @Test
    void produtoEscalareEntre2VetoresVazio(){
        //Arrange
        int[] vetor1 = {};
        int[] vetor2 = {};
        //Act
        int exp = 0;
        int res = Ex14.produtoEscalarEntre2Vetores(vetor1,vetor2);
        //Assert
        assertEquals(exp,res);}
}