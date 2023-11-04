package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex20Test {
    @Test
    void produtoMatrizQuadradaPorConstante() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int num = 2;
        int[][] exp = {{2, 4, 6}, {8, 10, 12}, {14, 16, 18}};
        //Act
        int[][] res = Ex20.produtoMatrizPorConstante(matrix, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoMatrizRetangularPorConstante() {
        //Arrange
        int[][] matrix = {{1, 1, 1}, {1, 1, 1}};
        int num = 1;
        int[][] exp = {{1, 1, 1}, {1, 1, 1}};
        //Act
        int[][] res = Ex20.produtoMatrizPorConstante(matrix, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoMatrizIrregularPorConstante() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5}, {7}};
        int num = -2;
        int[][] exp = {{-2, -4, -6}, {-8, -10}, {-14}};
        //Act
        int[][] res = Ex20.produtoMatrizPorConstante(matrix, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoMatrizVaziaPorConstante() {
        //Arrange
        int[][] matrix = {};
        int num = 10;
        int[][] exp = {};
        //Act
        int[][] res = Ex20.produtoMatrizPorConstante(matrix, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoMatrizPorConstanteZero() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int num = 0;
        int[][] exp = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //Act
        int[][] res = Ex20.produtoMatrizPorConstante(matrix, num);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void somaDuasMatrizesQuadradasNumerosPositivos() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] exp = {{2, 4, 6}, {8, 10, 12}, {14, 16, 18}};
        //Act
        int[][] res = Ex20.somaDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void somaDuasMatrizesRetangularesNumerosNegativos() {
        //Arrange
        int[][] matrix1 = {{-1, 2, -3}, {4, -5, 6}};
        int[][] matrix2 = {{-1, 2, -3}, {4, -5, 6}};
        int[][] exp = {{-2, 4, -6}, {8, -10, 12}};
        //Act
        int[][] res = Ex20.somaDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void somaDuasMatrizesTamanhosDiferentesInvalido() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.somaDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void somaDuasMatrizesVazias() {
        //Arrange
        int[][] matrix1 = {};
        int[][] matrix2 = {};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.somaDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void somaDuasMatrizesIguaisIrregularesInvalido() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.somaDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoDuasMatrizes3x3NumerosPositivos() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] exp = {{6, 6, 6}, {15, 15, 15}, {24, 24, 24}};
        //Act
        int[][] res = Ex20.produtoDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoDuasMatrizes4x4NumerosNegativoseZero() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{0, -1, 1, 0}, {1, 0, -1, 1}, {-1, 0, 1, 0}, {1, -1, 0, 1}};
        int[][] exp = {{3, -5, 2, 6}, {7, -13, 6, 14}, {11, -21, 10, 22}, {15, -29, 14, 30}};
        //Act
        int[][] res = Ex20.produtoDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoDuasMatrizesRetangularesInvalido() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{-1, -2, -3}, {-4, -5, -6}};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.produtoDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoDuasMatrizesDiferentesFormatosInvalido() {
        //Arrange
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.produtoDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void produtoDuasMatrizesVazias() {
        //Arrange
        int[][] matrix1 = {};
        int[][] matrix2 = {};
        int[][] exp = {};
        //Act
        int[][] res = Ex20.produtoDuasMatrizesNumerosInteiros(matrix1, matrix2);
        //Assert
        assertArrayEquals(exp, res);
    }
}