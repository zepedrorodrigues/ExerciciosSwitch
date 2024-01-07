package org.example;

import java.util.Arrays;

public class Ex22 {
    public static int[][] matrizBase(int[][] matrizOriginal, int[][] matrizAtual) {
        if (!verificarSudokuTamanhoeNumeros(matrizOriginal) || !verificarSudokuTamanhoeNumeros(matrizAtual))
            return new int[0][0];
        int[][] base = new int[9][9];
        for (int i = 0; i < matrizAtual.length; i++) {
            for (int j = 0; j < matrizAtual.length; j++) {
                if (matrizAtual[i][j] == 0)
                    base[i][j] = 0; // células vazias
                else {
                    if (matrizOriginal[i][j] != 0)
                        base[i][j] = 1; // números que constam no Sudoku original
                    else
                        base[i][j] = 2; // números preenchidos pelo utilizador
                }
            }
        }
        return base;
    }

    public static int[][] matrizMascara(int[][] matrizSudoku, int numero) {
        if (!verificarSudokuTamanhoeNumeros(matrizSudoku))
            return new int[0][0];
        int[][] matrizMascara = new int[9][9];
        for (int i = 0; i < matrizSudoku.length; i++) {
            for (int j = 0; j < matrizSudoku[i].length; j++) {
                if (matrizSudoku[i][j] == numero)
                    matrizMascara[i][j] = 1;
                else
                    matrizMascara[i][j] = 0;
            }
        }
        return matrizMascara;
    }

    private static boolean verificarSudokuTamanhoeNumeros(int[][] matrizSudoku) {
        if (matrizSudoku.length != 9) {
            return false;
        }
        for (int i = 0; i < matrizSudoku.length; i++) {
            for (int j = 0; j < matrizSudoku[i].length; j++) {
                if (matrizSudoku[i].length != 9 || matrizSudoku[i][j] < 0 || matrizSudoku[i][j] > 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificarRepeticoes(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                continue;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    return false;
            }
        }
        return true;
    }

    private static boolean verificarValidadeLinhasSudoku(int[][] matrizSudoku) {
        int[] linhas = new int[9];
        for (int i = 0; i < matrizSudoku.length; i++) {
            for (int j = 0; j < matrizSudoku[i].length; j++) {
                linhas[j] = matrizSudoku[i][j];
            }
            if (!verificarRepeticoes(linhas)) {
                return false;
            }
        }
        return true;
    }

    private static boolean verificarValidadeColunasSudoku(int[][] matrizSudoku) {
        int[] colunas = new int[9];
        for (int i = 0; i < matrizSudoku.length; i++) {
            for (int j = 0; j < matrizSudoku[i].length; j++) {
                colunas[j] = matrizSudoku[j][i];
            }
            if (!verificarRepeticoes(colunas)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarValidadeQuadradosSudoku(int[][] matrizSudoku) {
        for (int avancoQuadrado = 0; avancoQuadrado < 9; avancoQuadrado++) {
            int deslocamentoLinha = (avancoQuadrado / 3) * 3;
            int deslocamentoColuna = (avancoQuadrado % 3) * 3;
            int[] quadrado = new int[9];
            int index = 0;
            for (int i = deslocamentoLinha; i < deslocamentoLinha + 3; i++) {
                for (int j = deslocamentoColuna; j < deslocamentoColuna + 3; j++) {
                    quadrado[index] = matrizSudoku[i][j];
                    index++;
                }
            }
            if (!verificarRepeticoes(quadrado)) {
                return false;
            }
        }
        return true;
    }

    public static boolean verificarValidadeSudokuNumerosRepetidos(int[][] matrizSudoku) {
        if (!verificarSudokuTamanhoeNumeros(matrizSudoku))
            return false;
        return verificarValidadeLinhasSudoku(matrizSudoku) && verificarValidadeColunasSudoku(matrizSudoku) && verificarValidadeQuadradosSudoku(matrizSudoku);
    }

    public static boolean verificarSeHaCelulasPorPreencher(int[][] matrizSudoku) {
        for (int[] linha : matrizSudoku) {
            for (int celula : linha) {
                if (celula == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean inputValidoLinhaseColunas(int linha, int coluna) {
        return linha >= 1 && linha <= 9 && coluna >= 1 && coluna <= 9;
    }

    public static boolean inputValidoNumero(int numero) {
        return numero >= 1 && numero <= 9;
    }

    public static int[][] adicionarNovoNumeroSudoku(int[][] matrizSudoku, int linha, int coluna, int numero) {
        if (!inputValidoLinhaseColunas(linha, coluna) || !inputValidoNumero(numero))
            return matrizSudoku;
        int[][] matrizSudokuCopia = new int[matrizSudoku.length][];
        for (int i = 0; i < matrizSudoku.length; i++)
            matrizSudokuCopia[i] = Arrays.copyOf(matrizSudoku[i], matrizSudoku[i].length);
        linha -= 1;
        coluna -= 1;
        if (matrizSudoku[linha][coluna] == 0) {
            matrizSudoku[linha][coluna] = numero;
            if (verificarValidadeSudokuNumerosRepetidos(matrizSudoku))
                return matrizSudoku;
        }
        return matrizSudokuCopia;
    }

    public static int[][] removerNumeroSudoku(int[][] matrizOriginal, int[][] matrizAtual, int linha, int coluna) {
        if (!inputValidoLinhaseColunas(linha, coluna))
            return matrizAtual;
        int[][] matrizBase = matrizBase(matrizOriginal, matrizAtual);
        linha -= 1;
        coluna -= 1;
        if (matrizBase[linha][coluna] != 1)
            matrizAtual[linha][coluna] = 0;
        return matrizAtual;
    }

    public static boolean verificarSudokuTerminado(int[][] matrizSudoku) {
        return !verificarSeHaCelulasPorPreencher(matrizSudoku) && verificarValidadeSudokuNumerosRepetidos(matrizSudoku);
    }
}
