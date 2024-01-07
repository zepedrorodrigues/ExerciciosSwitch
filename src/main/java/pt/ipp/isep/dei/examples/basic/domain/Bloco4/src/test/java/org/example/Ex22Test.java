package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex22Test {
    @Test
    void matrizBase() {
        //Arrange
        int[][] matrizOriginal = {{1, 0, 3, 4, 0, 6, 0, 0, 9},
                {4, 0, 6, 0, 8, 0, 1, 0, 3},
                {7, 0, 9, 1, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 6, 0, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {0, 0, 0, 2, 0, 4, 5, 0, 7},
                {3, 4, 0, 6, 0, 0, 9, 0, 0},
                {6, 0, 0, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int[][] matrizAtual = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int[][] exp = {{1, 0, 1, 1, 0, 1, 2, 0, 1},
                {1, 2, 1, 0, 1, 2, 1, 2, 1},
                {1, 2, 1, 1, 0, 0, 2, 1, 0},
                {0, 0, 1, 0, 1, 2, 1, 1, 0},
                {0, 1, 1, 0, 1, 0, 1, 0, 1},
                {2, 0, 2, 1, 2, 1, 1, 0, 1},
                {1, 1, 0, 1, 2, 0, 1, 0, 0},
                {1, 0, 2, 0, 0, 0, 1, 1, 1},
                {1, 1, 0, 0, 1, 0, 1, 0, 2}};
        //Act
        int[][] res = Ex22.matrizBase(matrizOriginal, matrizAtual);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizBaseNumeroInvalido() {
        //Arrange
        int[][] matrizOriginal = {{1, 0, 3, 4, 0, 6, 0, 0, 9},
                {4, 0, 6, 0, 8, 0, 1, 0, 3},
                {7, 0, 9, 1, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 6, 0, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {0, 0, 0, 2, 0, 4, 5, 0, 7},
                {3, 4, 0, 6, 0, 10, 9, 0, 0},
                {6, 0, 0, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int[][] matrizAtual = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int[][] exp = {};
        //Act
        int[][] res = Ex22.matrizBase(matrizOriginal, matrizAtual);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizMascara() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int numero = 2;
        int[][] exp = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        //Act
        int[][] res = Ex22.matrizMascara(sudoku, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizMascaraNaoQuadrada() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5}};
        int numero = 3;
        int[][] exp = {};
        //Act
        int[][] res = Ex22.matrizMascara(sudoku, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void matrizMascaraNumeroInvalido() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 10},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int numero = 10;
        int[][] exp = {};
        //Act
        int[][] res = Ex22.matrizMascara(sudoku, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void verificarValidadeSudokuValido() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarValidadeSudokuNumerosRepetidos(sudoku);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarRepeticoesSemRepeticoes() {
        //Arrange
        int[] array = {3, 5, 9, 7, 1, 8, 6, 2, 4};
        //Act
        boolean res = Ex22.verificarRepeticoes(array);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarRepeticoescomZeros() {
        //Arrange
        int[] array = {1, 2, 3, 0, 5, 6, 7, 8, 0, 0};
        //Act
        boolean res = Ex22.verificarRepeticoes(array);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarRepeticoescomZeroseNumerosRepetidos() {
        //Arrange
        int[] array = {0, 1, 0, 2, 5, 6, 7, 8, 0, 1};
        //Act
        boolean res = Ex22.verificarRepeticoes(array);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarValidadeQuadradosSudokuValido() {
        //Arrange
        int[][] sudoku = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        //Act
        boolean res = Ex22.verificarValidadeQuadradosSudoku(sudoku);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarValidadeQuadradosSudokuInvalidoQuadradoRepetido() {
        //Arrange
        int[][] sudoku = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 1}}; // último quadrado inválido
        //Act
        boolean res = Ex22.verificarValidadeQuadradosSudoku(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarValidadeSudokuInvalidoTamanho() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4, 5},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarValidadeSudokuNumerosRepetidos(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarValidadeSudokuInvalidoLinha() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {2, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarValidadeSudokuNumerosRepetidos(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarValidadeSudokuInvalidoColuna() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {3, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarValidadeSudokuNumerosRepetidos(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarValidadeSudokuInvalidoQuadrado() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 1, 6, 0, 8, 9, 0, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 0, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarValidadeSudokuNumerosRepetidos(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void verificarSeHaCelulasPorPreencherTrue() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        boolean res = Ex22.verificarSeHaCelulasPorPreencher(sudoku);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarSeHaCelulasPorPreencherFalse() {
        //Arrange
        int[][] sudoku = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        //Act
        boolean res = Ex22.verificarSeHaCelulasPorPreencher(sudoku);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoLinhaseColunasSucessoLimiteInferior() {
        //Arrange
        int linha = 1;
        int coluna = 1;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertTrue(res);
    }

    @Test
    void inputValidoLinhaseColunasSucessoLimiteSuperior() {
        //Arrange
        int linha = 9;
        int coluna = 9;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertTrue(res);
    }

    @Test
    void inputValidoLinhaseColunasInvalidoLinhaLimiteSuperior() {
        //Arrange
        int linha = 10;
        int coluna = 5;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoLinhaseColunasInvalidoLinhaLimiteInferior() {
        //Arrange
        int linha = 0;
        int coluna = 5;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoLinhaseColunasInvalidoColunaLimiteSuperior() {
        //Arrange
        int linha = 5;
        int coluna = 10;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoLinhaseColunasInvalidoColunaLimiteInferior() {
        //Arrange
        int linha = 5;
        int coluna = 0;
        //Act
        boolean res = Ex22.inputValidoLinhaseColunas(linha, coluna);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoNumeroSucessoLimiteInferior() {
        //Arrange
        int numero = 1;
        //Act
        boolean res = Ex22.inputValidoNumero(numero);
        //Assert
        assertTrue(res);
    }

    @Test
    void inputValidoNumeroSucessoLimiteSuperior() {
        //Arrange
        int numero = 9;
        //Act
        boolean res = Ex22.inputValidoNumero(numero);
        //Assert
        assertTrue(res);
    }

    @Test
    void inputValidoNumeroInvalidoLimiteSuperior() {
        //Arrange
        int numero = 10;
        //Act
        boolean res = Ex22.inputValidoNumero(numero);
        //Assert
        assertFalse(res);
    }

    @Test
    void inputValidoNumeroInvalidoLimiteInferior() {
        //Arrange
        int numero = 0;
        //Act
        boolean res = Ex22.inputValidoNumero(numero);
        //Assert
        assertFalse(res);
    }

    @Test
    void adicionarNovoNumeroSudokuSucesso() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 0},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int linha = 9;
        int coluna = 9;
        int numero = 7;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 0},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 7}};
        //Act
        int[][] res = Ex22.adicionarNovoNumeroSudoku(sudoku, linha, coluna, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void adicionarNovoNumeroInsucessoCasaOcupada() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 1;
        int coluna = 1;
        int numero = 2;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.adicionarNovoNumeroSudoku(sudoku, linha, coluna, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void adicionarNovoNumeroInvalidoNumeroRepetido() {
        // Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 1;
        int coluna = 2;
        int numero = 1;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.adicionarNovoNumeroSudoku(sudoku, linha, coluna, numero);
        //Assert
        assertArrayEquals(exp, res);

    }

    @Test
    void adicionarNovoInputInvalido() {
        //Arrange
        int[][] sudoku = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 1;
        int coluna = 0;
        int numero = 7;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.adicionarNovoNumeroSudoku(sudoku, linha, coluna, numero);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void removerNumeroSudokuSucesso() {
        //Arrange
        int[][] matrizOriginal = {{1, 0, 3, 4, 0, 6, 0, 0, 0},
                {4, 0, 6, 0, 8, 0, 1, 0, 3},
                {7, 0, 9, 1, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 6, 0, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {0, 0, 0, 2, 0, 4, 5, 0, 7},
                {3, 4, 0, 6, 0, 0, 9, 0, 0},
                {6, 0, 0, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int[][] matrizAtual = {{1, 0, 3, 4, 0, 6, 0, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 1;
        int coluna = 9;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 0, 0, 0},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.removerNumeroSudoku(matrizOriginal, matrizAtual, linha, coluna);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void removerNumeroSudokuInsucesso() {
        //Arrange
        int[][] matrizOriginal = {{1, 0, 3, 4, 0, 6, 0, 0, 9},
                {4, 0, 6, 0, 8, 0, 1, 0, 3},
                {7, 0, 9, 1, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 6, 0, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {0, 0, 0, 2, 0, 4, 5, 0, 7},
                {3, 4, 0, 6, 0, 0, 9, 0, 0},
                {6, 0, 0, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int[][] matrizAtual = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 1;
        int coluna = 3;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.removerNumeroSudoku(matrizOriginal, matrizAtual, linha, coluna);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void removerNumeroSudokuInvalido() {
        //Arrange
        int[][] matrizOriginal = {{1, 0, 3, 4, 0, 6, 0, 0, 9},
                {4, 0, 6, 0, 8, 0, 1, 0, 3},
                {7, 0, 9, 1, 0, 0, 0, 5, 0},
                {0, 0, 4, 0, 6, 0, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {0, 0, 0, 2, 0, 4, 5, 0, 7},
                {3, 4, 0, 6, 0, 0, 9, 0, 0},
                {6, 0, 0, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 0}};
        int[][] matrizAtual = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        int linha = 10;
        int coluna = 7;
        int[][] exp = {{1, 0, 3, 4, 0, 6, 7, 0, 9},
                {4, 5, 6, 0, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 0, 0, 4, 5, 0},
                {0, 0, 4, 0, 6, 7, 8, 9, 0},
                {0, 6, 7, 0, 9, 0, 2, 0, 4},
                {8, 0, 1, 2, 3, 4, 5, 0, 7},
                {3, 4, 0, 6, 7, 0, 9, 0, 0},
                {6, 0, 8, 0, 0, 0, 3, 4, 5},
                {9, 1, 0, 0, 4, 0, 6, 0, 8}};
        //Act
        int[][] res = Ex22.removerNumeroSudoku(matrizOriginal, matrizAtual, linha, coluna);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void verificarSudokuTerminadoSucesso() {
        //Arrange
        int[][] sudokuTerminadoSemErros = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        //Act
        boolean res = Ex22.verificarSudokuTerminado(sudokuTerminadoSemErros);
        //Assert
        assertTrue(res);
    }

    @Test
    void verificarSudokuTerminadoInsucesso() {
        //Arrange
        int[][] sudokuTerminadoComErros = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 9}};
        //Act
        boolean res = Ex22.verificarSudokuTerminado(sudokuTerminadoComErros);
        //Assert
        assertFalse(res);
    }
}