package org.example;

public class Ex16 {
    public static boolean verificarSeQuadrado(int[][] matrix) {
        if (matrix.length == 0)
            return false;
        int linhas = matrix.length;
        int colunas = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(matrix);
        return (linhas == colunas);
    }
}
