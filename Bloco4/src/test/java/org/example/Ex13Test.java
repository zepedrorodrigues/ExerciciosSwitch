package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex13Test {

    @Test
    void devolverMenorValordeArray() {
        //Arrange
        int[] array = {0, 3, 4, 5};
        int exp = 0;
        //Act
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);
    }
    @Test
    void devolverMenorValordeArraysocomMinInteger(){
        //Arrange
        int[] array = {Integer.MIN_VALUE, 3, 4, 5};
        //Act
        int exp = Integer.MIN_VALUE;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);}

    @Test
    void devolverMenorValordeArraycomNumerosTodosIguais(){
        //Arrange
        int[] array = {1, 1, 1, 1};
        //Act
        int exp = 1;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);}
    @Test
    void devolverMenorValordeArraycomUmNumero(){
        //Arrange
        int[] array = {1};
        //Act
        int exp = 1;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);}

    @Test
    void devolverMenorValordeArrayDesordenado() {
        //Arrange
        int[] array = {10, 7, 1, 5};
        //Act
        int exp = 1;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverMenorValordeArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        int exp = Integer.MIN_VALUE;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);}

    @Test
    void devolverMenorValordeArrayComNegativos() {
        //Arrange
        int[] array = {-2, 3, 5, 0};
        //Act
        int exp = -2;
        int res = Ex13.devolverMenorValordeArray(array);
        //Assert
        assertEquals(exp, res);}

    @Test
    void devolverMaiorValordeArraycomZeroeNegativos() {
        //Arrange
        int[] array = {4, 19, 5, 0, -1};
        //Act
        int exp = 19;
        int res = Ex13.devolverMaiorValordeArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverMaiorValordeArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        int exp = Integer.MIN_VALUE;
        int res = Ex13.devolverMaiorValordeArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverMaiorValordeArrayTodosIguais() {
        //Arrange
        int[] array = {2, 2, 2, 2, 2, 2, 2};
        //Act
        int exp = 2;
        int res = Ex13.devolverMaiorValordeArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void mediaArray() {
        //Arrange
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        double exp = 44.0 / 8;
        double res = Ex13.mediaArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void mediaArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        double exp = Integer.MIN_VALUE;
        double res = Ex13.mediaArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void mediaArraycomZeroeNegativos() {
        //Arrange
        int[] array = {0, 3, -4, 5, 6, 2, 1};
        //Act
        double exp = 13.0 / 7;
        double res = Ex13.mediaArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void produtoNumerosArray() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        //Act
        int exp = 120;
        int res = Ex13.produtoNumerosArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void produtoNumerosArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        int exp = Integer.MIN_VALUE;
        int res = Ex13.produtoNumerosArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void produtoNumeroscomZero() {
        //Arrange
        int[] array = {0, 1, 4, 5, 7};
        //Act
        int exp = 0;
        int res = Ex13.produtoNumerosArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void produtoNumeroscomNegativos() {
        //Arrange
        int[] array = {-1, 2, -3, 4, -5};
        //Act
        int exp = -120;
        int res = Ex13.produtoNumerosArray(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void arraysValoresUnicos() {
        //Arrange
        int[] array = {4, 4, 4, 6, 6, 6, 5, 5, 5, 7};
        //Act
        int[] exp = {4, 6, 5, 7};
        int[] res = Ex13.arraysValoresUnicos(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void arraysValoresUnicosArrayVazio() {
        //Arrange
        int[] array = {};
        //Act
        int[] exp = {};
        int[] res = Ex13.arraysValoresUnicos(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void arraysValoresUnicoscomZeroeNegativos() {
        //Arrange
        int[] array = {0, -1, 2, 2, 3, 3, 4, 4};
        //Act
        int[] exp = {0, -1, 2, 3, 4};
        int[] res = Ex13.arraysValoresUnicos(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void arrayInvertido() {
        //Arrange
        int[] array = {5, 6, 7};
        //Act
        int[] exp = {7, 6, 5};
        int[] res = Ex13.arrayInvertido(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void arrayInvertidoVazio() {
        //Arrange
        int[] array = {};
        //Act
        int[] exp = {};
        int[] res = Ex13.arrayInvertido(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void arrayInvertidoNumeroGrande() {
        //Arrange
        int[] array = {7, 8, 9, 2, 3, 4, 5, 6, 7};
        //Act
        int[] exp = {7, 6, 5, 4, 3, 2, 9, 8, 7};
        int[] res = Ex13.arrayInvertido(array);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoZero() {
        //Arrange
        int numero = 0;
        //Act
        boolean exp = false;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoUm() {
        //Arrange
        int numero = 1;
        //Act
        boolean exp = false;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoDois() {
        //Arrange
        int numero = 2;
        //Act
        boolean exp = true;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoTres() {
        //Arrange
        int numero = 3;
        //Act
        boolean exp = true;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoQuatro() {
        //Arrange
        int numero = 4;
        //Act
        boolean exp = false;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarSeNumeroEPrimoNegativo() {
        //Arrange
        int numero = -1;
        //Act
        boolean exp = false;
        boolean res = Ex13.verificarSeNumeroPrimo(numero);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void numerosPrimosDoVetorNumeros1a9() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        int[] expected = {2, 3, 5, 7};
        int[] result = Ex13.numerosPrimosDoVetor(array);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void numerosPrimosDoVetorNumerosNegativosEZero() {
        //Arrange
        int[] array = {-2, -1, 0};
        //Act
        int[] expected = {};
        int[] result = Ex13.numerosPrimosDoVetor(array);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void numerosPrimosDoVetorTodosNumerosPrimos() {
        //Arrange
        int[] array = {2, 3, 5, 7, 11, 13, 17, 19};
        //Act
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] result = Ex13.numerosPrimosDoVetor(array);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void numerosPrimosDoVetorVazio() {
        //Arrange
        int[] array = {};
        //Act
        int[] expected = {};
        int[] result = Ex13.numerosPrimosDoVetor(array);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void numerosPrimosDoVetosTodosNaoPrimos() {
        //Arrange
        int[] array = {4, 6, 8, 9, 10, 12, 14, 15};
        //Act
        int[] expected = {};
        int[] result = Ex13.numerosPrimosDoVetor(array);
        //Assert
        assertArrayEquals(expected, result);
    }
}