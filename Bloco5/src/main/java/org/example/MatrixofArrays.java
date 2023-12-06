package org.example;

public class MatrixofArrays {
    private Array[] matrix;
    private static final String outofBounds = "Out of bounds";
    private static final String emptyMatrix = "Empty matrix";
    private static final String notFound = "Value not found";
    private static final String notRectangle = "Matrix is not a rectangle";

    /**
     * alínea a.
     * Construtor público em que o array encapsulado fica vazio (i.e. sem valores).
     */
    public MatrixofArrays() { //construtor vazio
        this.matrix = new Array[0];
    }

    /**
     * alínea b.
     * Construtor público que permita inicializar o array encapsulado com alguns valores
     */
    public MatrixofArrays(int[][] matrix) { //construtor com parâmetros
        this.matrix = copyofArray(matrix);
    }

    private Array[] copyofArray(int[][] matrix) { //copia a matriz de inteiros para uma matriz de arrays
        Array[] copy = new Array[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = new Array();
            for (int j = 0; j < matrix[i].length; j++)
                copy[i].add(matrix[i][j]);
        }
        return copy;
    }

    private int[][] copyofArray(Array[] matrix) { //copia a matriz de arrays para uma matriz de inteiros
        int[][] copy = new int[matrix.length][matrix[0].getSize()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].getSize(); j++)
                copy[i][j] = matrix[i].returnElement(j);
        } //percorre a matriz
        return copy;
    }

    /**
     * alínea c.
     * Adicione um novo elemento (valor) ao array encapsulado numa determinada linha,
     * criando assim uma nova coluna nessa linha.
     */
    public void add(int value, int line) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (line < 0 || line >= matrix.length) //verifica se a linha está dentro dos limites
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        matrix[line].add(value);
    } //adiciona o valor à linha

    /**
     * alínea d.
     * Retire o primeiro elemento do array encapsulado com um determinado valor (percorrendo primeiramente as linhas).
     * A linha onde o elemento for retirado, ficará com menos uma coluna.
     */
    public void removeFirstValue(int value) throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        for (Array array : matrix) { //percorre a matriz
            for (int j = 0; j < array.getSize(); j++) {
                if (array.returnElement(j) == value) { //verifica se o valor existe
                    array.removeFirstValue(value); //remove o valor
                    return;
                }
            }
        }
        throw new IllegalArgumentException(notFound);
    } //caso o valor não exista, Exception

    /**
     * alínea e.
     * Retorne True caso a matriz esteja vazia e False em caso contrário
     */
    public boolean isEmpty() { //verifica se a matriz está vazia
        return matrix.length == 0;
    }

    public int getSize() { //retorna o tamanho da matriz
        return matrix.length;
    }

    /**
     * alínea h.
     * Retorne a média dos elementos do array.
     */
    public double average() throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix); //verifica se a matriz está vazia
        double sum = 0;
        int count = 0;
        for (Array array : matrix) { //percorre a matriz
            for (int j = 0; j < array.getSize(); j++) {
                sum += array.returnElement(j); //soma os valores
                count++;
            }
        }
        return sum / count;
    } //retorna a média

    /**
     * alínea i.
     * Retorne um vetor em que cada posição corresponde à soma dos elementos da linha homóloga do array encapsulado
     */
    public Array sumLines() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        int[] sum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].getSize(); j++) { //percorre a matriz
                sum[i] += matrix[i].returnElement(j);
            }
        } //soma os valores
        return new Array(sum);
    } //retorna um array com a soma das linhas

    /**
     * alínea j.
     * Retorne um vetor em que cada posição corresponde à soma dos elementos da coluna homóloga do array encapsulado.
     */
    public Array sumColumns() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        int max = matrix[0].getSize();
        for (Array array : matrix)
            max = Math.max(max, array.getSize()); //verifica o tamanho da maior linha
        int[] sum = new int[max]; //cria um array com o tamanho da maior linha
        for (Array array : matrix) { //percorre a matriz
            for (int j = 0; j < array.getSize(); j++) {
                sum[j] += array.returnElement(j);
            }
        } //soma os valores
        return new Array(sum);
    } //retorna um array com a soma das colunas

    /**
     * alínea f.
     * Retorne o maior elemento do array.
     */
    public int biggest() throws IllegalArgumentException { //retorna o maior valor da matriz
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix);
        int max = matrix[0].returnElement(0);
        for (Array array : matrix) //percorre a matriz
            for (int i = 0; i < array.getSize(); i++)
                max = Math.max(max, array.returnElement(i)); //verifica o maior valor
        return max;
    }

    /**
     * alínea g.
     * Retorne o menor elemento do array.
     */
    public int smallest() throws IllegalArgumentException { //retorna o menor valor da matriz
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix); //verifica se a matriz está vazia
        int min = matrix[0].returnElement(0);
        for (Array array : matrix)
            for (int i = 0; i < array.getSize(); i++) //percorre a matriz
                min = Math.min(min, array.returnElement(i)); //verifica o menor valor
        return min;
    }

    /**
     * alínea k.
     * Retorne o índice da linha do array com maior soma dos respetivos elementos.
     * Deve ser usado o método da alínea i).
     */
    public int biggestLine() throws IllegalArgumentException { //retorna o índice da linha com o maior valor
        if (matrix.length == 0)
            throw new IllegalArgumentException(emptyMatrix); //verifica se a matriz está vazia
        Array sum = sumLines(); //método i.
        int max = sum.returnElement(0);
        int index = 0;
        for (int i = 0; i < sum.getSize(); i++) //percorre a matriz
            if (sum.returnElement(i) > max) { //verifica a maior soma
                max = sum.returnElement(i); //guarda a maior soma
                index = i;
            }
        return index;
    } //retorna o índice da linha com a maior soma

    /**
     * alínea l.
     * Retorne True se o array encapsulado corresponde a uma matriz quadrada.
     */
    public boolean isSquare() { //verifica se a matriz é quadrada
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        for (Array array : matrix) //percorre a matriz
            if (array.getSize() != matrix.length) //verifica se o número de colunas é igual ao número de linhas
                return false;
        return true;
    }

    /**
     * alínea m.
     * Retorne True se o array encapsulado for uma matriz quadrada simétrica
     */
    public boolean isSimetricSquare() throws IllegalArgumentException { //verifica se a matriz é quadrada e simétrica
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isSquare()) //verifica se a matriz é quadrada
            return false;
        int[][] copy = copyofArray(matrix); //copia a matriz de arrays para uma matriz de inteiros
        transposeMatrix(); //transpõe a matriz
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].getSize(); i++) //percorre a matriz
                if (matrix[j].returnElement(i) != copy[j][i]) //verifica se a matriz é simétrica
                    return false;
        }
        return true;
    }

    private void transposeMatrix() { //transpõe a matriz
        int[][] transpose = copyofArray(matrix);
        for (int i = 0; i < matrix[0].getSize(); i++)
            for (int j = 0; j < matrix.length; j++) //percorre a matriz
                transpose[i][j] = matrix[j].returnElement(i); //troca as linhas pelas colunas
        matrix = copyofArray(transpose);
    }

    /**
     * alínea n.
     */
    public int nonNullsMainDiagonal() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isSquare()) //verifica se a matriz é quadrada
            return -1;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) //percorre a matriz
            if (matrix[i].returnElement(i) != 0) //verifica se o valor é diferente de 0
                count++;
        return count;
    }

    /**
     * alínea o.
     */
    public boolean diagonalsEqual() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle()) //verifica se a matriz é quadrada
            throw new IllegalArgumentException(notRectangle);
        int min = matrix.length;
        for (Array array : matrix) //percorre a matriz
            min = Math.min(min, array.getSize()); //verifica o menor valor
        for (int i = 0; i < min; i++) { //percorre a matriz
            if (matrix[i].returnElement(i) != matrix[i].returnElement(matrix[i].getSize() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isRectangle() { //verifica se a matriz é um retângulo
        int size = matrix[0].getSize();
        for (Array array : matrix) //percorre a matriz
            if (array.getSize() != size) //verifica se o número de colunas é igual ao número de linhas
                return false;
        return true;
    }

    /**
     * alínea p.
     */

    public Array algarismsOverAverage() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        double average = averageofAlgarisms(); //método q.
        Array algarisms = new Array();
        //percorre a matriz
        for (Array array : matrix)
            for (int j = 0; j < array.getSize(); j++)
                if (numberofAlgarisms(array.returnElement(j)) > average) //número dealgarismos é maior que a média
                {
                    algarisms.add(array.returnElement(j));
                } //adiciona o valor ao array
        return algarisms;
    } //retorna o array com os valores

    private double averageofAlgarisms() throws IllegalArgumentException {
        int sum = 0;
        int count = 0;
        for (Array array : matrix) //percorre a matriz
            for (int i = 0; i < array.getSize(); i++) {
                sum += numberofAlgarisms(array.returnElement(i)); //soma o número de algarismos
                count++;
            } //incrementa o contador
        return (double) sum / count;
    } //retorna a média

    private int numberofAlgarisms(int number) { //retorna o número de algarismos de um número
        int count = 1; //inicia o contador a 1
        while (number > 9) { //enquanto o número for maior que 9
            number /= 10;
            count++;
        } //incrementa o contador
        return count;
    } //retorna o número de algarismos

    /**
     * alínea q.
     */
    public Array percentageofPairsOverAverage() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        double average = averageofPairs();
        Array percentageofPairsOver = new Array();
        //percorre a matriz
        for (Array array : matrix)
            for (int j = 0; j < array.getSize(); j++)
                if (percentageofPairs(array.returnElement(j)) > average) //valor é maior que a média
                {
                    percentageofPairsOver.add(array.returnElement(j));
                } //adiciona o valor ao array
        return percentageofPairsOver;
    } //retorna o array com os valores

    private double averageofPairs() { //retorna a média de percentagem de pares
        int sum = 0;
        int count = 0;
        for (Array array : matrix) //percorre a matriz
            for (int i = 0; i < array.getSize(); i++) {
                sum += percentageofPairs(array.returnElement(i)); //soma o número de pares
                count++;
            } //incrementa o contador
        return (double) sum / count;
    } //retorna a média

    private double percentageofPairs(int number) { //retorna a percentagem de pares
        int sum = 0;
        int count = 0;
        while (number != 0) { //enquanto o número for diferente de 0
            int remnant = number % 10; //resto da divisão por 10
            if (remnant % 2 == 0) //verifica se o resto é par
                sum++;
            count++;
            number /= 10;
        } //divide o número por 10
        return (double) sum / count * 100;
    } //retorna a percentagem de pares

    /**
     * alínea r.
     */
    public void reverseLines() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        Array[] reverse = new Array[matrix.length];
        for (int i = 0; i < matrix.length; i++) //percorre a matriz
            reverse[i] = reverseLine(matrix[i]); //inverte a linha
        matrix = reverse;}

    private Array reverseLine(Array line) {
        Array reverse = new Array();
        for (int i = 0; i < line.getSize(); i++) //percorre a linha
            reverse.add(line.returnElement(line.getSize() - 1 - i)); //inverte a linha
        return reverse;
    }//cria uma nova linha com os valores invertidos

    /**alínea s.*/
    public void reverseColumns() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        int[][] reverse = copyofArray(matrix);
        for(int i=0; i<matrix.length; i++)
            matrix[i]=new Array(reverse[reverse.length-1-i]);} //inverte as colunas
    /**alínea t.*/
    public void rotateMatrix90Degrees()throws IllegalArgumentException{
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if(!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        transposeMatrix();
        reverseLines();}

    /**alínea u.*/
    public void rotateMatrix180Degrees()throws IllegalArgumentException{
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if(!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        reverseLines();
        reverseColumns();}

    /**alínea v.*/
    public void rotateMatrix270Degrees()throws IllegalArgumentException{
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if(!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        transposeMatrix();
        reverseColumns();}
}
