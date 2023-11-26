package org.example;

import java.util.Arrays;

public class CustomMatrix {
    private int[][] matrix; // guarda matrix
    private static final String nullMatrix = "Matrix is null"; // guarda string
    private static final String emptyArray = "Empty Array"; // mensagem Erro Array Vazio
    private static final String notSquare = "Matrix is not square"; // mensagem Erro Matrix não é quadrada
    private static final String invalid = "Invalid Argument"; // mensagem Erro Argumento Inválido
    private static final String outofBounds = "Out of Bounds"; // mensagem Erro Fora dos Limites

    @Override
    public boolean equals(Object o) { // verifica se o objeto é igual (override Arrays.equals)
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CustomMatrix that = (CustomMatrix) o;
        return Arrays.equals(matrix, that.matrix);
    } //so funciona se for instancia de CustomMatrix

    @Override
    public int hashCode() { // retorna hashcode (override Arrays.deepHashCode)
        return Arrays.deepHashCode(matrix);
    }

    public CustomMatrix() {
        this.matrix = new int[0][0];
    } // construtor sem parametros

    public CustomMatrix(int[][] mtrx) throws NullPointerException { // construtor com parametros
        if (mtrx == null)
            throw new NullPointerException(nullMatrix); // se for null, lança exceção
        this.matrix = deepCopy(mtrx);
    } // se não for null, copia a matrix

    private int[][] deepCopy(int[][] mtrx) { // copia a matrix
        int[][] copy = new int[mtrx.length][];
        for (int i = 0; i < mtrx.length; i++) {
            copy[i] = mtrx[i].clone();
        }
        return copy;
    }

    public int[][] getMatrix() { // retorna a matrix
        return matrix;
    }

    public int getSize() { // retorna o tamanho da matrix
        return matrix.length;
    }

    public void add(int element, int line) { // adiciona elemento a linha
        if (line < 0)
            throw new IllegalArgumentException(invalid);
        if (line >= matrix.length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        int[] newLine = matrix[line];
        CustomArray array = new CustomArray(newLine);
        array.addElement(element);
        matrix[line] = array.getArray();
    }

    public void remove(int element) { //
        int[][] copy = deepCopy(matrix);
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray);
        for (int i = 0; i < matrix.length; i++) {
            CustomArray array = new CustomArray(matrix[i]);
            int index = array.detectIndexFirstNumberX(element);
            if (index == -1) continue;
            array.removeFirstElement(element);
            matrix[i] = array.getArray();
        }
        if (Arrays.deepEquals(copy, matrix))
            throw new IllegalArgumentException(invalid);
    }

    public boolean isEmpty() { // verifica se a matrix está vazia
        return matrix.length == 0;
    }

    public int minMax(boolean largestTrueSmallestFalse) { // retorna o maior/menor numero da matrix
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        int largestSmallest = matrix[0][0];
        if (largestTrueSmallestFalse) { // retorna o maior numero da matrix
            for (int[] line : matrix) {
                CustomArray array = new CustomArray(line);
                largestSmallest = Math.max(array.getBiggestSmallestNumber(true), largestSmallest);
            }
            return largestSmallest;
        }
        for (int[] line : matrix) { // retorna o menor numero da matrix
            CustomArray array = new CustomArray(line);
            largestSmallest = Math.min(array.getBiggestSmallestNumber(false), largestSmallest);
        }
        return largestSmallest;
    }

    public int[] linesSum() { // retorna a soma das linhas, se vazio dá 0
        int[] sumLines = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            CustomArray array = new CustomArray(matrix[i]); // cria um array com a linha
            sumLines[i] = array.getSum();
        } // soma a linha e guarda no array
        return sumLines;
    }

    public double average() { // retorna a média das linhas, se vazio dá erro
        int contador = 0;
        for (int[] i : matrix)
            contador += i.length;
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        int[] sumLines = linesSum();
        CustomArray array = new CustomArray(sumLines);
        return (double)array.getSum() / contador;
    }

    public int[] rowsSum() throws IllegalArgumentException { // retorna Array com soma das colunas, se vazio dá erro
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyArray);
        int max = matrix[0].length;
        for (int[] line : matrix) {
            max = Math.max(max, line.length);
        } // guarda o maior tamanho de linha
        int[] sumRows = new int[max];
        for (int[] line : matrix)
            for (int j = 0; j < line.length; j++) {
                sumRows[j] += line[j];}
        // soma as colunas e guarda no array
        return sumRows;}
    public int biggestLine() throws IllegalArgumentException { // retorna a linha com maior soma, se vazio dá erro
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        int[]  sumLines = linesSum();
        int max = sumLines[0];
        int index = 0;
        for(int i=0;i<sumLines.length;i++){
            if(sumLines[i]>max){
                max = sumLines[i];
                index = i;}}
        return index;}


    }