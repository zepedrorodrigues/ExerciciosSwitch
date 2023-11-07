package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class SudokuFunction {
    public static void main(String[] args) {
        int[][] matrizSudoku = {
                {4, 3, 5, 2, 6, 9, 7, 8, 1},
                {6, 8, 2, 5, 7, 1, 4, 9, 3},
                {1, 9, 7, 8, 3, 4, 5,6, 2},
                {8, 2, 6, 1, 9, 5, 3, 4, 7},
                {3, 7, 4, 6, 8, 2, 9, 1, 5},
                {9, 5, 1, 7, 4, 3, 6, 2, 8},
                {5, 1, 9, 3, 2, 6, 8, 7, 4},
                {2, 4, 8, 9, 5, 7, 1, 3, 6},
                {7, 6, 3, 4, 1, 8, 2, 0, 9}
        };
        sudokuBase(matrizSudoku);
    }

    public static void sudokuBase(int[][] matrizSudoku) {
        Scanner scanner = new Scanner(System.in);
        int[][] sudokuCopia = new int[matrizSudoku.length][matrizSudoku.length];
        for (int i = 0; i < matrizSudoku.length; i++)
            sudokuCopia[i] = Arrays.copyOf(matrizSudoku[i], matrizSudoku[i].length);
        int[][] base = Ex22.matrizBase(matrizSudoku);
        while (Ex22.verificarSudokuTerminado(matrizSudoku)) {
            printMatrix(matrizSudoku);
            System.out.println("Escolha uma opção: \n1 - Inserir número\n2 - Remover número");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                matrizSudoku = inserirNumeroMatrizSudoku(matrizSudoku);
                base = Ex22.alterarBase(matrizSudoku, base);}
            if (opcao == 2) {
                matrizSudoku = removerNumeroMatrizSudoku(base, matrizSudoku);
                base = Ex22.alterarBase(matrizSudoku, base);}
            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida.");}}}

    public static int[][] inserirNumeroMatrizSudoku(int[][] matrizSudoku) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a linha: ");
        int linha = scanner.nextInt();
        System.out.println("Insira a coluna: ");
        int coluna = scanner.nextInt();
        System.out.println("Insira o número: ");
        int numero = scanner.nextInt();
        return Ex22.adicionarNovoNumeroSudoku(matrizSudoku, linha, coluna, numero);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();}}

    public static int[][] removerNumeroMatrizSudoku(int[][] base, int[][] matrizSudoku) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a linha: ");
        int linha = scanner.nextInt();
        System.out.println("Insira a coluna: ");
        int coluna = scanner.nextInt();
        return Ex22.removerNumeroSudoku(matrizSudoku, base, linha, coluna);
    }
}