package org.example;

public class Ex20 {
    public static int[][] produtoMatrizPorConstante(int[][] matrix, int num) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * num;
            }
        }
        return matrix;
    }

    public static int[][] somaDuasMatrizesNumerosInteiros(int[][] matrix1, int[][] matrix2) {
        // Verifica se as matrizes são quadradas/retangulares, se são vazias e se são iguais (por esta ordem)
        if ((matrix1.length == 0) || (Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(matrix1) == -1) || (matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length))
            return new int[0][0];
        int[][] somaMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                somaMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return somaMatrix;
    }

    public static int calcularProduto(int[][] matrix1, int[][] matrix2, int linha, int coluna) {
        int produto = 0;
        for (int i = 0; i < matrix1.length; i++) {
            produto += matrix1[linha][i] * matrix2[i][coluna];
        }
        return produto;
    }

    public static int[][] produtoDuasMatrizesNumerosInteiros(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == 0 || !Ex16.verificarSeQuadrado(matrix1) || matrix1.length != matrix2.length)
            return new int[0][0];
        int[][] produtoMatrix = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                produtoMatrix[i][j] = calcularProduto(matrix1, matrix2, i, j);
            }
        }
        return produtoMatrix;
    }
}
