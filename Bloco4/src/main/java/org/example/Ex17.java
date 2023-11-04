package org.example;

public class Ex17 {
    public static boolean verificarSeRetangular(int[][] arraydeArrays) {
        if (arraydeArrays.length == 0)
            return false;
        int linhas = arraydeArrays.length;
        int colunas = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(arraydeArrays);
        return (linhas != colunas);
    }
}
