package org.example;

public class Ex19 {
    public static int[][] verificarSubMatriz(int[][] matriz, int i) {
        int subColuna = 0;
        int[][] subMatriz = new int[matriz.length - 1][matriz.length - 1];
        for (int coluna = 0; coluna < matriz.length; coluna++) {
            if (coluna == i)
                continue;
            for (int linha = 1; linha < matriz.length; linha++) {
                subMatriz[linha - 1][subColuna] = matriz[linha][coluna];
            }
            subColuna++;
        }
        return subMatriz;
    }

    public static int verificarDeterminanteLaplace(int[][] matriz) {
        if (!Ex16.verificarSeQuadrado(matriz))
            return -1;
        if (matriz.length == 2)
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        if (matriz.length == 1)
            return matriz[0][0];
        int determinante = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i] == 0)
                continue;
            int[][] subMatriz = verificarSubMatriz(matriz, i);
            if (i % 2 == 0)
                determinante += matriz[0][i] * verificarDeterminanteLaplace(subMatriz);
            else
                determinante -= matriz[0][i] * verificarDeterminanteLaplace(subMatriz);
        }
        return determinante;
    }
}
