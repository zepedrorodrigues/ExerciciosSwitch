package org.example;

import java.util.Arrays;
public class Array {
    private int[] array; //array de inteiros
    private static final String argumentoInvalido = "Argumento Inválido."; //mensagem de erro
    private static final String arrayNulo = "org.example.Array Nulo."; //mensagem de erro
    private static final String arrayVazio = "org.example.Array Vazio."; //mensagem de erro

    /**
     * OVERRIDE NOTA:
     * chamado automaticamente aquando da criação do org.example.Array(Classe Nova)
     * compara o array dado com o criado, tornando desnecessários os throws
     * e as Validações de Argumentos
     */
    @Override //"substitui" o método Arrays.equals
    public boolean equals(Object o) { //compara dois arrays
        if (this == o) return true; //se forem iguais
        if (o == null || getClass() != o.getClass()) return false; //se forem diferentes
        Array array1 = (Array) o; //cast
        return Arrays.equals(array, array1.array);
    } //compara os arrays

    @Override //"substitui" o método Arrays.hashCode
    public int hashCode() {
        return Arrays.hashCode(array);
    } //retorna o hashcode do array

    public Array() { //construtor vazio
        array = new int[0];
    }

    public Array(int[] arr) { //construtor com argumento
        this.array = arr.clone();
        if (arr == null) //se o array for nulo
            throw new NullPointerException(arrayNulo); //lança uma exceção
    }//clona o array



    public int[] getArray() {
        return array;
    } //retorna o array

    public int getSize() {
        return array.length;
    } //retorna o tamanho do array

    public void add(int element) { //adiciona um elemento ao array
        int[] newArray = array.clone(); //copia o array de forma segura
        newArray = Arrays.copyOf(newArray, newArray.length + 1);
        newArray[newArray.length - 1] = element;
        array = newArray;
    } //array torna-se em novo array, não devolve

    public void removeFirstValue(int value) throws IllegalArgumentException {
        if (detectFirstValue(value) == -1) { //se o valor não existir ou org.example.Array Vazio
            throw new IllegalArgumentException(argumentoInvalido);
        } //lança uma exceção
        int[] newArray = new int[array.length - 1]; //cria um novo array com menos um elemento
        int ind = 0;
        for (int i = 0; i < array.length; i++) { //percorre o array
            if (i == detectFirstValue(value)) //se o valor for igual ao valor a remover, continua
                continue;
            newArray[ind] = array[i];
            ind++;
        }
        array = newArray;
    } //array torna-se em novo array, não devolve

    private int detectFirstValue(int value) { //deteta o primeiro valor igual a "value"
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public int returnElement(int position) throws IllegalArgumentException { //retorna o elemento na posição "position"
        if (position < 0 || position >= this.array.length) { //se a posição for inválida
            throw new IllegalArgumentException(argumentoInvalido);
        } //lança uma exceção
        return this.array[position];
    } //retorna o elemento na posição "position"

    //retorna o maior ou menor elemento do array
    public int returnLargestSmallestElement(boolean largestTrueSmallestFalse) throws IllegalArgumentException {
        if (this.array.length == 0) { //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        } //lança uma exceção
        int menorMaior = array[0]; //menor ou maior elemento
        if (largestTrueSmallestFalse) { //se for para buscar o maior elemento
            for (int value : array) {
                menorMaior = Math.max(menorMaior, value);
            }//troca sempre pelo valor que for maior
        } else { //se for para buscar o menor elemento
            for (int value : array)
                menorMaior = Math.min(menorMaior, value);
        } //troca sempre pelo valor que for menor
        return menorMaior;
    } //retorna o menor ou maior elemento

    public double returnAverage() throws IllegalArgumentException { //média do array GERAL
        if (array.length == 0) { //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        } //lança uma exceção
        int sum = 0;
        for (int value : array) {
            sum += value;
        } //soma todos os elementos do array GERAL
        return (double) sum / array.length;
    } //retorna a média

    public double returnAverage(int[] arr) throws IllegalArgumentException { //média de um array específico
        if (arr.length == 0) { //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        } //lança uma exceção
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    } //retorna a média do array ESPECÍFICO

    private int[] extendArraytoTheRight(int[] array) { //aumenta o tamanho do array
        int[] newArray = array.clone(); //copia o array
        newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
        return newArray;
    } //retorna o array novo

    //NÃO MEXAM, PF, VAI SER ÚTIL PARA CRESCENTES E CAPICUAS
    private int[] extendArraytoTheLeft(int[] array) { //aumenta o tamanho do array RESPEITANDO A ORDEM
        int[] newArray = new int[array.length + 1]; //cria um novo array com mais um elemento
        for (int i = 1; i < array.length; i++) { //percorre o array
            newArray[i - 1] = array[i];
        } //copia o array, MOVENDO OS DÍGITOS PARA A ESQUERDA
        return newArray;
    } //retorna o array novo

    public int[] getmultiplesofNumber(int mult, boolean multiOrNot) throws IllegalArgumentException {//multiplos de mult
        if (mult == 0 || array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] multiplesArray = new int[0];
        int counter = 0;
        if (multiOrNot) { //se for para buscar os múltiplos
            for (int value : array) {
                if (value % mult == 0) {
                    multiplesArray = extendArraytoTheRight(multiplesArray); //aumenta o tamanho do array
                    multiplesArray[counter] = value; //adiciona o valor ao array
                    counter++;
                }}} else { //se for para buscar os não múltiplos
            multiplesArray = new int[0];
            for (int value : array) {
                if (value % mult != 0) {
                    multiplesArray = extendArraytoTheRight(multiplesArray);
                    multiplesArray[counter] = value;
                    counter++;}}}
        return multiplesArray;} //retorna o array

    private void swapElements(int[] array, int i, int j) { //troca os elementos de posição
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;}

    public int[] returnArrayOrder(boolean ascending) throws IllegalArgumentException {
        if (this.array.length == 0) {
            throw new IllegalArgumentException(arrayVazio);} //excepção
        int[] newArray = array.clone(); //copia o array
        for (int i = 1; i < newArray.length; i++) {
            if(ascending){{
                    if (newArray[i] <= newArray[i-1]) { //se o elemento da esquerda for maior que o da direita
                        swapElements(newArray, i, i-1);}}//troca os elementos de posição
                return newArray;}
            if (newArray[i] >= newArray[i-1]) { //se o elemento da esquerda for menor que o da direita
                swapElements(newArray, i, i-1);}}//troca os elementos de posição
        return newArray;} //retorna o array

    public boolean lengthTester(int testingLength) { //testa se tem este tamanho
        return array.length == testingLength;}

    private boolean isPair(int value) { //testa se é par
        return value % 2 == 0;}

    public boolean isAllEvenorOdds(boolean evenTrueOddFalse) throws IllegalArgumentException {//tudo par ou impar ??
        if (array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        if (evenTrueOddFalse) { //se for para buscar os pares
            for (int value : array) {
                if (!isPair(value)) //se um valor não for par
                    return false;
            }
        } //retorna falso
        else { //se for para buscar os ímpares
            for (int value : array) {
                if (isPair(value)) //se um valor não for ímpar
                    return false;
            }
        } //retorna falso
        return true;
    } //retorna verdadeiro
}