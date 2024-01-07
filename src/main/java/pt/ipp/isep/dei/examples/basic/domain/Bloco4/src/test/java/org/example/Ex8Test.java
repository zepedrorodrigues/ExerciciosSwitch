package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Ex8Test {
    @Test
    void devolverVetorNumeroDeElementosValidos() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        int num = 3;
        //Act
        int[] exp = {1, 2, 3};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverVetorComNumeroDeElementosSuperior() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        int num = 10;
        //Act
        int[] exp = {};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverVetorComNumeroDeElementosNegativo() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        int num = -10;
        //Act
        int[] exp = {};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverVetorComZeroNumeroDeElementos() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        int num = 0;
        //Act
        int[] exp = {};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverVetorComArrayVazio() {
        //Arrange
        int[] array = {};
        int num = 3;
        //Act
        int[] exp = {};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void devolverVetorComValoresNegativosNoArray() {
        //Arrange
        int[] array = {-1, -2, 3, 4, -5};
        int num = 3;
        //Act
        int[] exp = {-1, -2, 3};
        int[] res = Ex8.devolverVetorComXElementos(array, num);
        //Assert
        assertArrayEquals(exp, res);
    }
    @Test
    void devolverVetorcomNumNegativo(){
        //Arrange
        int[]array= {1,2,3,4,5};
        int num = 0;
        //Act
        int[]exp = {};
        int[]res = Ex8.devolverVetorComXElementos(array,num);
        //Assert
        assertArrayEquals(exp,res);}
    @Test
    void devolverVetorcomNumIgualATamanhoVetor(){
        //Arrange
        int[]array = {1,2,3};
        int num = 3;
        //Act
        int[] exp = array;
        int[] res = Ex8.devolverVetorComXElementos(array,num);
        //Assert
        assertArrayEquals(exp,res);}
    @Test
    void devolverVetorcomNumIguala1(){
        //Arrange
        int[]array = {2,3,4,5};
        int num = 1;
        //Act
        int[]exp = {2};
        int[]res= Ex8.devolverVetorComXElementos(array,num);
        //Assert
        assertArrayEquals(exp,res);
    }

}