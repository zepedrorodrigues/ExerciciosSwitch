package org.example;

import java.util.Arrays;

public class CustomMatrix {

    private static final String outofBounds = "Index out of bounds";
    private static final String invalid = "Invalid argument";
    private static final String emptyMatrix = "Empty Array";
    private static final String notRectangle = "Not a Rectangle";
    private static final String notSquare = "Matrix is not square";
    private int[][] matrix;

    /**
     * alínea a
     */
    public CustomMatrix() {
        this.matrix = new int[0][0];
    }

    /**
     * alínea b
     */
    public CustomMatrix(int[][] mtrx) {
        this.matrix = deepCopy(mtrx);
    }

    private int[][] deepCopy(int[][] mtrx) { // copia a matriz
        int[][] copy = new int[mtrx.length][];
        for (int i = 0; i < mtrx.length; i++) {
            copy[i] = new int[mtrx[i].length];
            for (int j = 0; j < mtrx[i].length; j++)
                copy[i][j] = mtrx[i][j];
        }
        return copy;
    }

    /**
     * alínea c
     */
    public void add(int value, int line) throws ArrayIndexOutOfBoundsException {
        if (line < 0 || line >= matrix.length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        int[] newMatrix = matrix[line];
        newMatrix = Arrays.copyOf(newMatrix, newMatrix.length + 1);
        newMatrix[newMatrix.length - 1] = value;
        matrix[line] = newMatrix;
    }

    /**
     * alínea d
     */
    public void remove(int value) {
        int[] position = detectValuePosition(value);
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (position[0] == -1 && position[1] == -1)
            throw new IllegalArgumentException(invalid);
        int[] line = matrix[position[0]];
        line = removeValue(line, position[1]);
        matrix[position[0]] = line;
    }

    private int[] detectValuePosition(int value) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                if (matrix[i][j] == value)
                    return new int[]{i, j};
        return new int[]{-1, -1};
    }

    private int[] removeValue(int[] line, int index) {
        int[] newArray = new int[line.length - 1];
        int contador = 0;
        for (int i = 0; i < line.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[contador++] = line[i];
        }
        return newArray;
    }

    /**
     * alínea e
     */
    public boolean isEmpty() { // verifica se a matrix está vazia
        return this.matrix.length == 0;
    }

    /**
     * alínea f
     */
    public int largest() throws IllegalArgumentException {
        if (isEmpty())
            throw new IllegalArgumentException(emptyMatrix);
        int max = matrix[0][0];
        for (int[] line : matrix) {
            for (int element : line) {
                if (element > max)
                    max = element;
            }
        }
        return max;
    }

    /**
     * alínea g
     */
    public int smallest() throws IllegalArgumentException {
        if (isEmpty())
            throw new IllegalArgumentException(emptyMatrix);
        int min = matrix[0][0];
        for (int[] line : matrix) {
            for (int element : line) {
                if (element < min)
                    min = element;
            }
        }
        return min;
    }

    /**
     * alínea h
     */
    public double average() throws IllegalArgumentException { // retorna a média dos elementos da matrix
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyMatrix);
        int sum = 0;
        int count = 0;
        for (int[] line : matrix) {
            for (int element : line) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }

    /**
     * alínea i
     */
    public int[] arraySumOfLines() throws IllegalArgumentException {
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyMatrix);
        int[] sumLine = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            sumLine[i] = sumLine(matrix[i]);
        return sumLine;
    }

    private int sumLine(int[] linhas) {
        int sum = 0;
        for (int i = 0; i < linhas.length; i++) {
            sum += linhas[i];
        }
        return sum;
    }

    /**
     * alínea j
     */
    public int[] arraySomaColunas() throws IllegalArgumentException {
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyMatrix);
        int max = matrix[0].length;
        for (int[] line : matrix) {
            max = Math.max(max, line.length);
        }
        int[] sumColumn = new int[max];
        for (int i = 0; i < max; i++)
            sumColumn[i] = somadorColuna(matrix, i);
        return sumColumn;
    }

    private int somadorColuna(int[][] matriz, int coluna) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (coluna >= matriz[i].length)
                continue;
            soma += matriz[i][coluna];
        }
        return soma;
    }

    /**
     * alínea k
     */
    public int biggestLine() {
        int[] arraySoma = arraySumOfLines();
        int indexMax = 0;
        int max = arraySoma[0];
        for (int i = 1; i < arraySoma.length; i++) {
            if (arraySoma[i] > max) {
                max = arraySoma[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    /**
     * alínea l
     */
    public boolean isSquare() throws IllegalArgumentException { // verifica se a matriz é quadrada, se vazio dá erro
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        for (int[] line : matrix) {
            if (line.length != matrix.length)
                return false;
        }
        return true;
    }

    /**
     * alínea m
     */
    public boolean simetricSquare() throws IllegalArgumentException { // verifica se a matriz é simétrica, se vazio dá erro
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (!isSquare())
            throw new IllegalArgumentException(notSquare);
        int[][] transposedMAtrix = deepCopy(matrix);
        CustomMatrix transposed = new CustomMatrix(transposedMAtrix);
        transposed.transposeMatrix();
        return (Arrays.deepEquals(getMatrix(), transposed.getMatrix()));
    }

    private void transposeMatrix() throws IllegalArgumentException { // retorna a matrix transposta, se vazio dá erro
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length]; // cria array com tamanho da matrix
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        matrix = transposedMatrix;
    }// transpõe a matrix

    private int[][] getMatrix() { // retorna a matriz
        return matrix;
    }

    /**
     * alínea n
     */
    public int nonZeroElementsDiagonal() throws IllegalArgumentException { // retorna o número de elementos não nulos da diagonal principal
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyMatrix);
        if (matrix.length != matrix[0].length) // se não for quadrada devolve -1
            return -1;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) { // percorre a diagonal princial
            if (matrix[i][i] != 0)
                count++;
        }
        return count;
    }

    /**
     * alínea o
     */
    public boolean sameDiagonals() {
        if (matrix.length == 0) // se vazio dá erro
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        int[] diagonalPrincipal = returnDiagonalPrincipal();
        int[] diagonalSecundaria = returnDiagonalSecundaria();
        return Arrays.equals(diagonalPrincipal, diagonalSecundaria);
    }

    private int[] returnDiagonalPrincipal() {
        int min = matrix.length;
        for (int[] line : matrix)
            min = Math.min(min, line.length);
        int[] diagonalPrincipal = new int[min];
        for (int i = 0; i < min; i++)
            diagonalPrincipal[i] = matrix[i][i];
        return diagonalPrincipal;
    }

    private int[] returnDiagonalSecundaria() {
        int min = matrix.length;
        for (int[] line : matrix)
            min = Math.min(min, line.length);
        int[] diagonalSecundaria = new int[min];
        for (int i = 0; i < min; i++)
            diagonalSecundaria[i] = matrix[i][matrix[i].length - 1 - i];
        return diagonalSecundaria;
    }

    private boolean isRectangle() {
        int lines = matrix[0].length;
        for (int[] line : matrix) {
            if (line.length != lines)
                return false;
        }
        return true;
    }

    /**
     * alinea p
     */
    public int[] overAverageAlgarism() throws IllegalArgumentException {
        if (this.matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        double media = averageOfDigits(matrix);
        int[] array = new int[0];
        for (int[] element : matrix) {
            for (int number : element) {
                if (numberOfDigits(number) > media) {
                    array = Arrays.copyOf(array, array.length + 1);
                    array[array.length - 1] = number;
                }
            }


        }
        return array;
    }

    private int numberOfDigits(int number) {
        int count = 0;
        if (number == 0)
            return 1;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    private double averageOfDigits(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] element : matrix) {
            for (int number : element) {
                sum += numberOfDigits(number);
                count++;
            }

        }
        return (double) sum / count;
    }

    /**
     * alinea q
     */
    public int[] overAveragePercentagePairs() throws IllegalArgumentException {
        if (this.matrix.length == 0)
            throw new IllegalArgumentException("vazio");

        int[] newArray = new int[0];
        double averagePairs = averagePairs();

        for (int[] row : matrix) {
            for (int value : row) {
                if (percentageOfPairs(value) > averagePairs) {
                    newArray = Arrays.copyOf(newArray, newArray.length + 1);
                    newArray[newArray.length - 1] = value;
                }
            }
        }

        return newArray;
    }

    private double percentageOfPairs(int value) {
        int digitCount = 0;
        int pairsCount = 0;

        if (value == 0) {
            // Quando o valor é zero, considera-se 100% de dígitos pares.
            return 100;
        }

        while (value != 0) {
            int remainder = value % 10;
            if (remainder % 2 == 0) {
                pairsCount++;
            }
            digitCount++;
            value /= 10;
        }

        return (digitCount > 0) ? ((double) pairsCount / digitCount * 100) : 0;            //(condição) ? valor_se_verdadeiro : valor_se_falso
    }

    private double averagePairs() {
        double sum = 0;
        int count = 0;

        for (int[] row : matrix) {
            for (int value : row) {
                sum += percentageOfPairs(value);
                count++;
            }
        }

        return (count > 0) ? (sum / count) : 0;                      //(condição) ? valor_se_verdadeiro : valor_se_falso
    }

    /**
     * alínea r
     */
    public void reverseLines() { // inverte cada linha da matriz
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        for (int i = 0; i < matrix.length; i++) // percorre cada linha da matriz
            matrix[i] = reverseEachLine(this.matrix[i]);
    } // inverte a linha

    private int[] reverseEachLine(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    /**
     * alínea s
     */
    public void invertColumnOrder() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        for (int j = 0; j < matrix[0].length; j++) {
            int i = 0;
            int k = matrix.length - 1;
            while (i < k) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[k][j];
                matrix[k][j] = temp;
                i++;
                k--;
            }
        }
    }


    /**
     * alínea t
     */
    public void rotate90Degrees() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        if (isSquare()) {
            transposeMatrix();
            reverseLines();
            return;
        }
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                newMatrix[j][i] = matrix[i][j];
        for (int i = 0; i < newMatrix.length; i++)
            newMatrix[i] = reverseEachLine(newMatrix[i]);
        matrix = newMatrix;
    }


    /**
     * alínea u
     */
    public void rotate180Degrees() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        rotate90Degrees();
        rotate90Degrees();
    }

    /**
     * alínea v
     */
    public void rotateMinus90Degrees() throws IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        rotate90Degrees();
        rotate90Degrees();
        rotate90Degrees();
    }


}
