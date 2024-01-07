package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import static org.junit.jupiter.api.Assertions.*;

class Ex18Test {

    @Test
    void menorNumerodeArraydeArraysValido() {
        // Arrange
        int[][] matriz = {{-1, 2, 4}, {6, -3, 0}, {7, 5, 4}};
        int exp = -3;
        // Act
        int res = Ex18.menorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void menorNumerodeArrayVazio() {
        // Arrange
        int[][] matriz = {};
        int exp = Integer.MIN_VALUE;
        // Act
        int res = Ex18.menorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void menorNumeroArrayValoresTodosIguais() {
        // Arrange
        int[][] matriz = {{1, 1, 1,}, {1, 1}, {1, 1, 1, 1}, {1}};
        // Act
        int exp = 1;
        int res = Ex18.menorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void maiorNumerodeArraydeArraysValido() {
        // Arrange
        int[][] matriz = {{3, 4, 5, 6}, {10, 2, 3, 4}, {4, 7}};
        int exp = 10;
        // Act
        int res = Ex18.maiorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void maiorNumerodeArraydeArraysVazio() {
        // Arrange
        int[][] matriz = {};
        int exp = Integer.MAX_VALUE;
        // Act
        int res = Ex18.maiorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void maiorNumerodeArraydeArrayscomNegativos() {
        // Arrange
        int[][] matriz = {{-4, 0, 7}, {1, 2}, {5, 6, 9}};
        int exp = 9;
        // Act
        int res = Ex18.maiorNumerodeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void mediaValoresArraydeArrays() {
        // Arrange
        int[][] matriz = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        double exp = 2;
        // Act
        double res = Ex18.mediavaloresArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res, 0.01);
    }

    @Test
    void mediaValoresdeArraydeArraysVazio() {
        // Arrange
        int[][] matriz = {};
        double exp = 0;
        // Act
        double res = Ex18.mediavaloresArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res, 0.01);
    }

    @Test
    void mediaValoresArraydeArraysDecimal() {
        // Arrange
        int[][] matriz = {{7, 8, 12}, {3, 4, 5}, {6, 7, 4}};
        double exp = 6.22;
        // Act
        double res = Ex18.mediavaloresArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res, 0.01);
    }

    @Test
    void produtodeValoresdeArraydeArraysZero() {
        // Arrange
        int[][] matriz = {{2, 3, 4, 5}, {1, 7, 9}, {10, 4, 0}};
        int exp = 0;
        // Act
        int res = Ex18.produtodeValoresdeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void produtodeValoresdeArrayVazio() {
        // Arrange
        int[][] matriz = {};
        int exp = 0;
        // Act
        int res = Ex18.produtodeValoresdeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void produtodeValoresdeArraysValido() {
        // Arrange
        int[][] matriz = {{1, 3, 4, 5}, {2, 7}, {9}};
        int exp = 7560;
        // Act
        int res = Ex18.produtodeValoresdeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void produtodeValoresdeArraycomNegativos() {
        // Arrange
        int[][] matriz = {{-3, 4, -5}, {2, 7}, {9, -1}};
        int exp = -7560;
        // Act
        int res = Ex18.produtodeValoresdeArraydeArrays(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void conjuntoElementosNaoRepetidosArraydeArrays() {
        // Arrange
        int[][] matriz = {{1, 2, 4, 5}, {4, 5, 3, 2}, {1, 7, 8}};
        int[] exp = {1, 2, 4, 5, 3, 7, 8};
        // Act
        int[] res = Ex18.conjuntoElementosNaoRepetidosArraydeArrays(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void conjuntoElementosNaoRepetidosArraydeArraysVazio() {
        // Arrange
        int[][] matriz = {};
        int[] exp = {};
        // Act
        int[] res = Ex18.conjuntoElementosNaoRepetidosArraydeArrays(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void conjuntodePrimosdeArraydeArray() {
        // Arrange
        int[][] matriz = {{1, 2, 7, 9}, {11, 19, 10, 1}, {0, 6, 9, 12, 13}};
        int[] exp = {2, 7, 11, 19, 13};
        // Act
        int[] res = Ex18.conjuntodePrimosdeArraydeArrays(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void conjuntodePrimosdeArrayVazio() {
        // Arrange
        int[][] matriz = {};
        int[] exp = {};
        // Act
        int[] res = Ex18.conjuntodePrimosdeArraydeArrays(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void conjuntodePrimosValoresNegativos() {
        // Arrange
        int[][] matriz = {{2, 7}, {-3, -11}};
        int[] exp = {2, 7};
        // Act
        int[] res = Ex18.conjuntodePrimosdeArraydeArrays(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalPrincipalMatrizQuadrangular() {
        // Arrange
        int[][] matriz = {{1, 2, 3, 4}, {0, 11, 3, 4}, {9, 6, 5, 7}, {1, 1, 1, 0}};
        int[] exp = {1, 11, 5, 0};
        // Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalPrincipalMatrizLinha0IgualComprimentoqueMatriz(){
        //Arrange
        int[][]matriz = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        int[] exp = {1,2,3,4};;
        //Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        //Assert
        assertArrayEquals(exp,res);}
    @Test
    void diagonalPrincipalMatrizRetangularHorizontal() {
        // Arrange
        int[][] matriz = {{1, 2, 3}, {0, 11, 3}};
        int[] exp = {1, 11};
        // Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalPrincipalMatrizRetangularVertical() {
        // Arrange
        int[][] matriz = {{1, 2}, {0, 11}, {9, 6}};
        int[] exp = {1, 11};
        // Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalPrincipalMatrizVazia() {
        // Arrange
        int[][] matriz = {};
        int[] exp = {};
        // Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalPrincipalMatrizMatrizNaoRetangular() {
        // Arrange
        int[][] matriz = {{1}, {1, 2}, {3, 4, 4}};
        int[] exp = {};
        // Act
        int[] res = Ex18.diagonalPrincipalMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalSecundariaMatriz() {
        // Arrange
        int[][] matriz = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[] exp = {1, 2, 3};
        // Act
        int[] res = Ex18.diagonalSecundariaMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalSecundariaMatrizNaoRetangular() {
        // Arrange
        int[][] matriz = {{2}, {7, 5, 6, 7}, {4}};
        int[] exp = {};
        // Act
        int[] res = Ex18.diagonalSecundariaMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalSecundariaMatrizVazia() {
        // Arrange
        int[][] matriz = {};
        int[] exp = {};
        // Act
        int[] res = Ex18.diagonalSecundariaMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalSecundariaMatrizRetangularHorizontal() {
        // Arrange
        int[][] matriz = {{1, 2, 3}, {1, 2, 3}};
        int[] exp = {3, 2};
        // Act
        int[] res = Ex18.diagonalSecundariaMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void diagonalSecundariaMatrizRetangularVertical() {
        // Arrange
        int[][] matriz = {{1, 2}, {1, 2}, {1, 2}};
        int[] exp = {2, 1};
        // Act
        int[] res = Ex18.diagonalSecundariaMatriz(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizIdentidadeValido() {
        // Arrange
        int[][] matriz = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        // Act
        boolean res = Ex18.testarMatrizIdentidade(matriz);
        // Assert
        assertTrue(res);
    }

    @Test
    void matrizIdentidadeInvalidoNaoQuadrangular() {
        // Arrange
        int[][] matriz = {{2}, {7, 5, 6, 7}, {4}};
        // Act
        boolean res = Ex18.testarMatrizIdentidade(matriz);
        // Assert
        assertFalse(res);
    }

    @Test
    void matrizIdentidadeInvalidoVazia() {
        // Arrange
        int[][] matriz = {};
        // Act
        boolean res = Ex18.testarMatrizIdentidade(matriz);
        // Assert
        assertFalse(res);
    }

    @Test
    void matrizIdentidadeInvalido() {
        // Arrange
        int[][] matriz = {{2, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 2, 1}};
        // Act
        boolean res = Ex18.testarMatrizIdentidade(matriz);
        // Assert
        assertFalse(res);
    }

    @Test
    void matrizInvertida3x3() {
        // Arrange
        double[][] matriz = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        double[][] exp = {{-24, 18, 5}, {20, -15, -4}, {-5, 4, 1}};
        // Act
        double[][] res = Ex18.matrizInvertida(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizInvertida4x4() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, -1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        // Act
        double[][] exp = {{-2/3d, 4 / 33d, 1 / 11d, 10 / 33d}, {2 / 3d, -19 / 33d, -2 / 11d, 2 / 33d}, {1 / 3d, -20 / 33d, -5 / 11d, 16 / 33d}, {-1 / 6d, 47 / 66d, 9 / 22d, -31 / 66d}};
        double[][] res = Ex18.matrizInvertida(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizInvertida2x2() {
        //Arrange
        double[][] matriz = {{1, 2}, {2, 3}};
        //Act
        double[][] exp = {{-3, 2}, {2, -1}};
        double[][] res = Ex18.matrizInvertida(matriz);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizInvertida1x1() {
        //Arrange
        double[][] matriz = {{2}};
        //Act
        double[][] exp = {{1 / 2d}};
        double[][] res = Ex18.matrizInvertida(matriz);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizTranspostaRetangular() {
        // Arrange
        double[][] matriz = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        double[][] exp = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}};
        // Act
        double[][] res = Ex18.matrizTranspostaDoubleQuadrada(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizTranspostaQuadrangular() {
        // Arrange
        double[][] matriz = {{10, 11, 12}, {10, 11, 12}, {10, 11, 12}};
        double[][] exp = {{10, 10, 10}, {11, 11, 11}, {12, 12, 12}};
        // Act
        double[][] res = Ex18.matrizTranspostaDoubleQuadrada(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizTranspostaNaoRetangular() {
        // Arrange
        double[][] matriz = {{10, 11, 12}, {10, 11}, {1, 2, 3}};
        double[][] exp = {};
        // Act
        double[][] res = Ex18.matrizTranspostaDoubleQuadrada(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizTranspostaVazia() {
        // Arrange
        double[][] matriz = {};
        double[][] exp = {};
        // Act
        double[][] res = Ex18.matrizTranspostaDoubleQuadrada(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void SubmatrizValida() {
        //Arrange
        double[][] matriz = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        int[] pos = {1, 1};
        double[][] exp = {{1, 3}, {5, 0}};
        // Act
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void subMatrizValida2() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, 1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        int[] pos = {2, 1};
        double[][] exp = {{1, 3, 4}, {0, 4, 4}, {4, 5, 6}};
        // Act
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void subMatrizMatrizVazia() {
        //Arrange
        double[][] matriz = {};
        int[] pos = {2, 1};
        double[][] exp = {};
        // Act
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void subMatrizPosicaoForadoRange() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, 1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        int[] pos = {10, 10};
        double[][] exp = {};
        // Act
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void determinanteMAtriz() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, 1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        // Act
        double exp = 10;
        double res = Ex18.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void determinanteMatriz2() {
        //Arrange
        double[][] matriz = {{1, 2, 3}, {0, 1, 4}, {5, 6, 4}};
        // Act
        double exp = 5;
        double res = Ex18.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void determinanteMatrizVazia() {
        //Arrange
        double[][] matriz = {};
        // Act
        double exp = Integer.MIN_VALUE;
        double res = Ex18.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void determinanteMatrizNaoQuadrada() {
        //Arrange
        double[][] matriz = {{1, 2, 3}, {0, 1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        // Act
        double exp = Integer.MIN_VALUE;
        double res = Ex18.verificarDeterminanteLaplace(matriz);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void matrizInvertidaVazia() {
        //Arrange
        double[][] matriz = {};
        // Act
        double[][] exp = {};
        double[][] res = Ex18.matrizInvertida(matriz);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void coFatordeXValido() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, -1, 4, 4}, {5, 6, 0, 4}, {4, 3, 5, 6}};
        int posA = 0;
        int posB = 0;
        //Act
        double exp = 44;
        double res = Ex18.coFatordeX(matriz, posA,posB);
        //Assert
        assertEquals(exp, res);}
    @Test
    void coFatordeXinvalido(){
        //Arrange
        double[][] matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int posA = 0;
        int posB= -1;
    }

    @Test
    void subMatrizmatrizGrande() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4, 5}, {0, 1, 4, 4, 5}, {5, 6, 4, 3, 4}, {0, 3, 4, 5, 6}, {9, 6, 5, 7, 8}};
        int[] pos = {2, 2};
        // Act
        double[][] exp = {{1, 2, 4, 5}, {0, 1, 4, 5}, {0, 3, 5, 6}, {9, 6, 7, 8}};
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void subMatriz4x4() {
        //Arrange
        double[][] matriz = {{1, 2, 3, 4}, {0, 1, 4, 4}, {5, 6, 4, 3}, {0, 3, 4, 5}};
        int[] pos = {2, 2};
        // Act
        double[][] exp = {{1, 2, 4}, {0, 1, 4}, {0, 3, 5}};
        double[][] res = Ex18.verificarSubMatriz(matriz, pos[0],pos[1]);
        // Assert
        assertArrayEquals(exp, res);
    }
    @Test
    public void testDevolverMatrizaDividirporDeterminante_DivisionAccuracy() {
        //Arrange
        double[][] inputMatrix = {{1, 2, 3, 4}, {0, 1, 4, 4}, {5, 6, 4, 3}, {0, 3, 4, 5}};
        double determinant = 10;
        //Act
        double[][] expected = {{0.1, 0.2, 0.3, 0.4}, {0, 0.1, 0.4, 0.4}, {0.5, 0.6, 0.4, 0.3}, {0, 0.3, 0.4, 0.5}};
        double[][] result = Ex18.devolverMatrizaDividirporDeterminante(inputMatrix, determinant);
        //Assert
        assertArrayEquals(expected, result);}
    @Test
    public void testaarMatrizIdentidadeLinha3coluna2diferentedeZero(){
        //Arrange
        int[][] matriz = {{1, 0, 0, 0}, {0, 1, 2, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        //Act & Assert
        assertFalse(Ex18.testarMatrizIdentidade(matriz));}
    @Test
    void verificarSubMatriz3x3i1igualamatrizlength(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int[]i={0,2};
        //Act
        double[][]exp = {{1,2},{1,2}};
        double[][]res = Ex18.verificarSubMatriz(matriz,i[0],i[1]);
        //Assert
        assertArrayEquals(exp,res);}

    @Test
    void coFatorXdelinha0coluna3(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int posA = 2;
        int posB = 1;
        //Act
        double expected = -0d;
        double result = Ex18.coFatordeX(matriz,posA,posB);
        //Assert
        assertEquals(expected,result);
    }
    @Test
    void verificarSubmatrizJNegativo(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = 2;
        int j = -3;
        //Act
        double[][] expected = {};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void verificarsubmatrizINegativo(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = -2;
        int j = 2;
        //Act
        double[][] expected = {};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void verificarSubmatrizIigualaZero(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = 0;
        int j = 2;
        //Act
        double[][] expected = {{1,2},{1,2}};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void verificarSubmatrizJigualaZero(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = 2;
        int j = 0;
        //Act
        double[][] expected = {{2,3},{2,3}};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void verificarSubMatrizInoLimiteSuperior(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = 3;
        int j = 0;
        //Act
        double[][] expected = {};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void verificarSubMatrizJnoLimiteSuperior(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int i = 0;
        int j = 3;
        //Act
        double[][] expected = {};
        double[][] result = Ex18.verificarSubMatriz(matriz,i,j);
        //Assert
        assertArrayEquals(expected,result);}

    @Test
    void veirifcarCofatordeXPosicaoForadoRange(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int posA = 0;
        int posB = 3;
        //Act
        double expected = -0.0;
        double result = Ex18.coFatordeX(matriz,posA,posB);
        //Assert
        assertEquals(expected,result);}
    @Test
    void verificarCofatordeXcomINegativo(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int posA = -1;
        int posB = 2;
        //Act
        double expected = -0.0;
        double result = Ex18.coFatordeX(matriz,posA,posB);
        //Assert
        assertEquals(expected,result);}
    @Test
    void verificarCofatordeXcomJNegativo(){
        //Arrange
        double[][]matriz = {{1,2,3},{1,2,3},{1,2,3}};
        int posA = 1;
        int posB = -2;
        //Act
        double expected = Integer.MIN_VALUE;
        double result = Ex18.coFatordeX(matriz,posA,posB);
        //Assert
        assertEquals(expected,result);}

    @Test
    void verificadordeDeterminante(){
        //Arrange
        double[][]matriz = {{0,2,3},{1,2,3},{1,2,3}};
        double determinante = 0;
        //Act
        double expected = 0;
        double result = Ex18.verificadordeDeterminante(matriz,determinante);
        //Assert
        assertEquals(expected,result);}

    }
