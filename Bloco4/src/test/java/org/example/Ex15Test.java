package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex15Test {
    @Test
    void verificarLinhasEColunasDadosValidos() {
        //Arrange
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int exp = 3;
        //Act
        int res = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void verificarLinhasEColunasDiferentesTamanhos() {
        //Arrange
        int[][] array = {{1, 2, 3}, {4, 5}, {7, 8, 9}};
        int exp = -1;
        //Act
        int res = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test()
    void verificarLinhasEColunasMatrizVazia() {
        //Arrange
        int[][] array = {};
        int exp = 0;
        //Act
        int res = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(array);
        //Assert
        assertEquals(exp, res);
    }

    @Test()
    void verificarLinhasEColunasMatriz2Linhas3Colunas() {
        //Arrange
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        int exp = 3;
        //Act
        int res = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(array);
        //Assert
        assertEquals(exp, res);
    }
}