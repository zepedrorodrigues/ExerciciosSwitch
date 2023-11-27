package org.example;

import java.util.Arrays;

public class CustomMatrix {
    private int[][] matrix; // guarda matrix
    private static final String nullMatrix = "Matrix is null"; // guarda string
    private static final String emptyArray = "Empty Array"; // mensagem Erro Array Vazio
    private static final String notSquare = "Matrix is not square"; // mensagem Erro Matrix não é quadrada
    private static final String notRectangle = "Matrix is not rectangle"; // mensagem Erro Matrix não é retangular
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

    private CustomArray getColumn(int column) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int[] columnArray = new int[matrix.length];
        for (int i = 0; i < matrix.length && column < matrix[i].length; i++) {
            columnArray[i] = matrix[i][column];}
        return new CustomArray(columnArray);}

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

    public CustomArray linesSum() {
        int[] sumLines = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            CustomArray arr = new CustomArray(matrix[i]);
            sumLines[i] = arr.getSum();}
        return new CustomArray(sumLines);}

    public double average() { // retorna a média das linhas, se vazio dá erro
        int contador = 0;
        for (int[] i : matrix)
            contador += i.length;
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        CustomArray sum = linesSum();
        return (double) sum.getSum() / contador;
    }

    public CustomArray rowsSum() throws IllegalArgumentException { // retorna Array com soma das colunas, se vazio dá erro
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyArray);
        int max = matrix[0].length;
        for (int[] line : matrix) {
            max = Math.max(max, line.length);
        } // guarda o maior tamanho de linha
        int[] sumRows = new int[max];
        for (int[] line : matrix)
            for (int j = 0; j < line.length; j++) {
                sumRows[j] += line[j];
            }
        // soma as colunas e guarda no array
        return new CustomArray(sumRows);
    }

    public int biggestLine() throws IllegalArgumentException { // retorna a linha com maior soma, se vazio dá erro
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        CustomArray sumLines = linesSum();
        int max = sumLines.getbyIndex(0);
        int index = 0;
        for (int i = 0; i < sumLines.getSize(); i++) {
            if (sumLines.getbyIndex(i) > max) {
                max = sumLines.getbyIndex(i);
                index = i;
            }
        }
        return index;
    }

    public boolean isSquare() throws IllegalArgumentException { // verifica se a matrix é quadrada, se vazio dá erro
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        for (int[] line : matrix) {
            if (line.length != matrix.length)
                return false;
        }
        return true;
    }

    private boolean isRectangle() {
        for (int[] line : matrix) {
            if (line.length != matrix[0].length)
                return false;
        }
        return true;
    }

    public boolean simetricSquare() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray);
        if (!isRectangle())
            throw new IllegalArgumentException(invalid);
        int[][] transposedMAtrix = deepCopy(matrix);
        CustomMatrix transposed = new CustomMatrix(transposedMAtrix);
        transposed.transposeMatrix();
        return (Arrays.deepEquals(getMatrix(), transposed.getMatrix()));
    }

    private void transposeMatrix() throws IllegalArgumentException { // retorna a matrix transposta, se vazio dá erro
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length]; // cria array com tamanho da matrix
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++) {
                transposedMatrix[i][j] = matrix[j][i];}
        matrix = transposedMatrix;
    }// transpõe a matrix

    public int elementsDiagonal() {
        if (!isSquare())
            return -1;
        CustomArray mainDiagonal = mainDiagonal();
        int contador = 0;
        for (int i = 0; i < mainDiagonal.getSize(); i++) {
            if (mainDiagonal.getbyIndex(i) != 0)
                contador++;
        }
        return contador;
    }

    public boolean equalDiagonals() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        CustomArray mainDiagonal = mainDiagonal();
        CustomArray secondaryDiagonal = secondaryDiagonal();
        return Arrays.equals(mainDiagonal.getArray(), secondaryDiagonal.getArray());
    }

    private CustomArray mainDiagonal() { // retorna a diagonal principal
        int min = Math.min(matrix.length, matrix[0].length);
        int[] mainDiagonal = new int[min];
        for (int i = 0; i < min; i++) {
            mainDiagonal[i] = matrix[i][i];
        } // guarda a diagonal principal
        return new CustomArray(mainDiagonal);
    }

    private CustomArray secondaryDiagonal() { // retorna a diagonal secundaria
        int min = Math.min(matrix.length, matrix[0].length);
        int[] secondaryDiagonal = new int[min];
        for (int i = 0; i < min; i++) {
            secondaryDiagonal[i] = matrix[i][matrix[i].length - 1 - i];
        } // guarda a diagonal secundaria
        return new CustomArray(secondaryDiagonal);
    }

    private int[][] matrixofNumberstoMatrixofDigits() {
        int[][] matrixofDigits = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            CustomArray array = new CustomArray(matrix[i]);
            matrixofDigits[i] = array.arrayofNumberstoArrayofDigits();
        }
        return matrixofDigits;
    }

    private double[][] matrixofNumberstoMatrixofPairs() {
        double[][] matrixofPercentageofPairs = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            CustomArray array = new CustomArray(matrix[i]);
            matrixofPercentageofPairs[i] = array.arrayofNumberstoArrayofPercentageofPairs();
        }
        return matrixofPercentageofPairs;
    }

    private double average(boolean digitTruePairsFalse) {
        int[][] matrixofDigits = matrixofNumberstoMatrixofDigits();
        double[][] matrixofPercentageofPairs = matrixofNumberstoMatrixofPairs();
        int sumDigits = 0;
        int contador = 0;
        if (digitTruePairsFalse) {
            for (int[] matrixofDigit : matrixofDigits) {
                for (int i : matrixofDigit) {
                    sumDigits += i;
                    contador++;
                }
            }
        } else {
            for (double[] matrixofPercentageofPair : matrixofPercentageofPairs) {
                for (double v : matrixofPercentageofPair) {
                    sumDigits += v;
                    contador++;
                }
            }
        }
        return (double) sumDigits / contador;
    }

    public int[][] digitsOverAverage() { // retorna a matrix com os digitos acima da média
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        int maxLength = matrix[0].length;
        for (int[] line : matrix) {
            maxLength = Math.max(maxLength, line.length);
        } // guarda o maior tamanho de linha ou matriz  length
        int[][] matrixofDigits = matrixofNumberstoMatrixofDigits(); // cria matrix de digitos
        double average = average(true); // calcula a média dos digitos
        int[][] matrixofDigitsOverAverage = new int[matrix.length][maxLength];// cria matrix de digitos acima da média
        int line = 0;
        int coluna;
        for (int i = 0; i < matrix.length; i++) {
            int[] finalLine = new int[0]; // cria linha vazia
            coluna = 0;
            for (int j = 0; j < getMatrix()[i].length; j++) {
                if (matrixofDigits[i][j] > average) { // se o no de digitos for maior que a média
                    finalLine = Arrays.copyOf(finalLine, finalLine.length + 1);
                    finalLine[coluna] = matrix[i][j];
                    coluna++;
                }
            } // adiciona o digito a linha
            //adiciona 1 a coluna
            matrixofDigitsOverAverage[line] = finalLine; // troca a linha a matrix
            line++;
        } // adiciona a linha a matrix
        return matrixofDigitsOverAverage;
    }

    public int[][] pairsOverAverage() { // retorna a matrix com os pares acima da média
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray); // se vazio dá erro
        int maxLength = matrix[0].length;
        for (int[] line : matrix) {
            maxLength = Math.max(maxLength, line.length);
        } // guarda o maior tamanho de linha ou matriz  length
        double average = average(false); // calcula a média dos pares
        double[][] matrixofPercentageofPairs = matrixofNumberstoMatrixofPairs(); // cria matrix de pares
        int[][] matrixofPairsOverAverage = new int[matrix.length][maxLength];// cria matrix de pares acima da média
        int line = 0;
        int coluna;
        for (int i = 0; i < matrix.length; i++) {
            CustomArray array = new CustomArray(); // cria linha vazia
            coluna = 0;
            for (int j = 0; j < getMatrix()[i].length; j++) {
                if (matrixofPercentageofPairs[i][j] > average) { // se o no de pares for maior que a média
                    array.addElement(matrix[i][j]);
                    coluna++;
                }
            } // adiciona o par a linha
            //adiciona 1 a coluna
            matrixofPairsOverAverage[line] = array.getArray(); // troca a linha a matrix
            line++;
        } // adiciona a linha a matrix
        return matrixofPairsOverAverage;
    }

    public void reverseLine(int line) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray);
        if (line < 0 || line >= matrix.length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        CustomArray array = new CustomArray(matrix[line]);
        array.reverse();
        matrix[line] = array.getArray();}

    private void reverseAlllines(){
        for (int i = 0; i < matrix.length; i++) {
            reverseLine(i);}}
    private void reverseAllColumns(){
        for (int i = 0; i < matrix[0].length; i++) {
            reverseColumn(i);}}

    public void reverseColumn(int column) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyArray);
        if (column < 0 || column >= matrix[0].length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        CustomArray columnArray = getColumn(column);
        columnArray.reverse();
        int[] column1 = columnArray.getArray();
        for (int i = 0; i < matrix.length && column < matrix[i].length; i++) {
            matrix[i][column] = column1[i];}}

    public void rotateMatrix(int angle) throws IllegalArgumentException {
        if (matrix.length == 0 || matrix[0].length == 0)
            throw new IllegalArgumentException(emptyArray);
        if(!isSquare())
            throw new IllegalArgumentException(notSquare);
        if (angle % 90 != 0)
            throw new IllegalArgumentException(invalid);
        angle = ((angle % 360) + 360) % 360;
        int rotations = angle / 90;
        if (rotations==0) return;
        int[][]newCustomMatrix = deepCopy(matrix);
        CustomMatrix newCustomMatrix1 = new CustomMatrix(newCustomMatrix);
        switch (rotations) {
            case 1: // 90 degrees
                newCustomMatrix1.transposeMatrix();
                newCustomMatrix1.reverseAllColumns();
                matrix = newCustomMatrix1.getMatrix();
                break;
            case 2: // 180 degrees
                newCustomMatrix1.reverseAlllines();
                newCustomMatrix1.reverseAllColumns();
                matrix= newCustomMatrix1.getMatrix();
                break;
            default: // 270 degrees
                newCustomMatrix1.transposeMatrix();
                newCustomMatrix1.reverseAlllines();
                matrix = newCustomMatrix1.getMatrix();
                break;}
    }
}