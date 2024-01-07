package org.example;

public class Ex17 {
    //A rectangular matrix is defined as a matrix that doesn’t have an equal number of rows and columns
    public static boolean verificarSeRetangular(int[][] arraydeArrays) {
        if (arraydeArrays.length == 0 || Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(arraydeArrays) == -1)
            return false;
        int linhas = arraydeArrays.length;
        int colunas = Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(arraydeArrays);
        return (linhas != colunas);
    }
}
