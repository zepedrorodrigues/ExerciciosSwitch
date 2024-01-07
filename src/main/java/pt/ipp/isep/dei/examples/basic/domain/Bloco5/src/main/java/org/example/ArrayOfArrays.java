package org.example;

public class ArrayOfArrays {
    private static final String nullArray = "Null array";
    private static final String outofBounds = "Index out of bounds";
    private static final String emptyMatrix = "Empty array";
    private static final String notRectangle = "Not a rectangle";
    private static final String invalid = "Invalid argument";
    private Array[] matrix;

    /**
     * alínea a. construtor vazio
     */
    public ArrayOfArrays() {
        this.matrix = new Array[0];
    }

    /**
     * alínea b. construtor com argumento
     */
    public ArrayOfArrays(Array[] newMatrix) { //recebe um array de Arrays (ex1)
        if (newMatrix == null)
            throw new IllegalArgumentException(nullArray);
        this.matrix = deepCopy(newMatrix);
    }

    public ArrayOfArrays(int[][] newMatrix) { //recebe uma matriz de inteiros
        if (newMatrix == null)
            throw new IllegalArgumentException(nullArray);
        this.matrix = deepCopy(newMatrix);
    }

    private Array[] deepCopy(Array[] newMatrix) { //faz um clone do array de Arrays
        Array[] copy = new Array[newMatrix.length];
        for (int i = 0; i < newMatrix.length; i++) {
            int size = newMatrix[i].getSize();
            int[] elements = new int[size];
            for (int j = 0; j < size; j++) {
                elements[j] = newMatrix[i].returnElement(j);
            }
            copy[i] = new Array(elements);
        }
        return copy;
    }

    private Array[] deepCopy(int[][] matrix) { //copia a matriz de inteiros para uma matriz de arrays
        Array[] copy = new Array[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = new Array();
            for (int j = 0; j < matrix[i].length; j++)
                copy[i].add(matrix[i][j]);
        }
        return copy;
    }

    /**
     * alínea c. adiciona um novo elemento ao array
     */
    public void add(int value, int line) throws ArrayIndexOutOfBoundsException {
        if (line < 0 || line >= matrix.length)
            throw new ArrayIndexOutOfBoundsException(outofBounds);
        Array[] copy = deepCopy(matrix); // Faz uma cópia da matriz original
        int newSize = matrix[line].getSize() + 1; // Cria uma nova linha com espaço adicional para o novo valor
        int[] lineCopy = new int[newSize];
        for (int i = 0; i < matrix[line].getSize(); i++) // Copia os elementos existentes da linha para a nova linha
            lineCopy[i] = matrix[line].returnElement(i);
        lineCopy[newSize - 1] = value; // Adiciona o novo valor à nova linha
        copy[line] = new Array(lineCopy); // Cria um novo objeto Array com a linha modificada
        matrix = copy; // Substitui a matriz original pela cópia modificada
    }

    /**
     * alínea d. remove um elemento do array
     */
    public void remove(int value) throws IllegalArgumentException {
        Array[] copy = deepCopy(matrix); // Faz uma cópia da matriz original
        for (int i = 0; i < matrix.length; i++) {
            int index = findIndex(value, i); // Procura o valor a remover na linha i
            if (index != -1) {
                copy = removeAndCopy(i, index, copy);
                break;
            }
            if (i == matrix.length - 1) // se o i for igual ao último elemento da matriz, é porque não encontrou o valor
                throw new IllegalArgumentException(invalid);
        }
        matrix = copy; // Atualiza o atributo matrix com a cópia modificada
    }

    private Array[] removeAndCopy(int linha, int coluna, Array[] matrix) {
        Array[] copy = deepCopy(matrix); //Faz uma cópia da matriz original
        int size = matrix[linha].getSize() - 1;
        int[] lineCopy = new int[size];
        for (int j = 0; j < coluna; j++) { //Copia os elementos antes do valor a ser removido
            lineCopy[j] = matrix[linha].returnElement(j);
        }
        for (int j = coluna + 1; j < matrix[linha].getSize(); j++) {// Copia os elementos após o valor a ser removido
            lineCopy[j - 1] = matrix[linha].returnElement(j);
        }
        // Cria um novo objeto Array com a linha modificada
        copy[linha] = new Array(lineCopy);
        return copy;
    }

    private int findIndex(int value, int line) { //procura o índice do valor na linha
        for (int i = 0; i < matrix[line].getSize(); i++) {
            if (value == matrix[line].returnElement(i))
                return i;
        }
        return -1;
    }

    /**
     * alínea e. retorna true se o array está vazio
     */
    public boolean isEmpty() {
        return matrix.length == 0;
    }

    /**
     * alínea f. retorna o maior valor do array
     */

    public int largest() throws IllegalArgumentException { //retorna o maior valor
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);//mensagem de erro
        int largest = matrix[0].returnElement(0); //inicia o maior valor com o primeiro elemento
        for (int i = 0; i < matrix.length; i++) { //percorre a matriz
            largest = Math.max(largest, matrix[i].largest());//verifica se o maior valor é maior que o elemento
        }
        return largest; //retorna o maior valor
    }

    /**
     * alínea g. retorna o menor valor do array
     */

    public int smallest() throws IllegalArgumentException { //retorna o menor valor
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);//mensagem de erro
        int smallest = matrix[0].returnElement(0); //inicia o menor valor com o primeiro elemento
        for (int i = 0; i < matrix.length; i++) { //percorre a matriz
            smallest = Math.min(smallest, matrix[i].smallest());//verifica se o menor valor é menor que o elemento
        }
        return smallest; //retorna o menor valor
    }

    /**
     * alínea h. retorna a média dos valores do array
     */

    public double average() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);//mensagem de erro
        int sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) { //percorre a matriz
            for (int j = 0; j < matrix[i].getSize(); j++) {
                sum += matrix[i].returnElement(j); //soma os valores
                count++; //incrementa o contador
            }
        }
        return (double) sum / count; //retorna a média
    }


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

    public int getSize() {
        return matrix.length;
    }

    /**
     * alínea k.
     * Retorne o índice da linha do array com maior soma dos respetivos elementos.
     */
    public int lineWithLargestSum() {
        Array arraySum = sumLines();
        int max = arraySum.returnElement(0);
        int indexMax = 0;
        for (int i = 1; i < arraySum.getSize(); i++) {
            if (arraySum.returnElement(i) > max) {
                max = arraySum.returnElement(i);
                indexMax = i;
            }
        }
        return indexMax;
    }

    /**
     * alínea l.
     * Retorne True se o array encapsulado corresponde a uma matriz quadrada.
     */
    public boolean isSquare() {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        for (Array array : matrix)
            if (array.getSize() != matrix.length)
                return false;
        return true;
    }

    /**
     * alínea m.
     * Retorne True se o array encapsulado corresponde a uma matriz quadrada simétrica.
     */

    public boolean isSimetricSquare() throws IllegalArgumentException { //verifica se a matriz é quadrada e simétrica
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isSquare()) //verifica se a matriz é quadrada
            return false;
        Array[] copy = deepCopy(matrix); //copia a matriz de arrays para uma matriz de inteiros
        transposeMatrix(); //transpõe a matriz
        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix[j].getSize(); i++) //percorre a matriz
                if (matrix[j].returnElement(i) != copy[j].returnElement(i)) //verifica se a matriz é simétrica
                    return false;}
        return true;}

    private void transposeMatrix() { //transpõe a matriz
        Array[] transpose = deepCopy(matrix);
        for (int i = 0; i < matrix[0].getSize(); i++){
            Array line = new Array();
            for (int j = 0; j < matrix.length; j++){ //percorre a matriz
                line.add(matrix[j].returnElement(i));}
            transpose[i] = line;}//troca as linhas pelas colunas
        matrix = transpose;}

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
                return false;}}
        return true;}



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
        matrix = reverse;
    }

    private Array reverseLine(Array line) {
        Array reverse = new Array();
        for (int i = 0; i < line.getSize(); i++) //percorre a linha
            reverse.add(line.returnElement(line.getSize() - 1 - i)); //inverte a linha
        return reverse;
    }//cria uma nova linha com os valores invertidos

    private boolean isRectangle() {
        int size = matrix[0].getSize();
        for (int i = 1; i < matrix.length; i++)
            if (matrix[i].getSize() != size)
                return false;
        return true;
    }

    /**
     * alínea s.
     */
    public void reverseColumns() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        Array[] reverse = new Array[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            reverse[i] = new Array();
            for (int j = 0; j < matrix[i].getSize(); j++)
                reverse[i].add(matrix[matrix.length - 1 - i].returnElement(j));
        }
        matrix = reverse;
    }

    /**
     * alínea t.
     */
    public void rotateMatrix90Degrees() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        transposeMatrix();
        reverseLines();}

    /**
     * alínea u.
     */
    public void rotateMatrix180Degrees() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        reverseLines();
        reverseColumns();
    }

    /**
     * alínea v.
     */
    public void rotateMatrix270Degrees() throws IllegalArgumentException {
        if (matrix.length == 0) //verifica se a matriz está vazia
            throw new IllegalArgumentException(emptyMatrix);
        if (!isRectangle())
            throw new IllegalArgumentException(notRectangle);
        transposeMatrix();
        reverseColumns();
    }

}
