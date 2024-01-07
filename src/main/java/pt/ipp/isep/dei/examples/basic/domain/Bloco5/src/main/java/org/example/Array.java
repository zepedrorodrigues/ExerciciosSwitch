package org.example;

import java.util.Arrays;

public class Array {
    private static final String argumentoInvalido = "Argumento Inválido."; //mensagem de erro
    private static final String arrayNulo = "Array Nulo."; //mensagem de erro
    private static final String arrayVazio = "Array Vazio."; //mensagem de erro
    private static final String noMultiples = "Sem múltiplos."; //mensagem de erro
    private int[] array; //array de inteiros

    /**
     * alínea a. construtor vazio
     */
    public Array() {
        array = new int[0];
    }

    /**
     * alínea b. construtor com argumento
     */
    public Array(int[] arr) {
        if (arr == null) //se o array for nulo
            throw new NullPointerException(arrayNulo); //lança uma exceção
        this.array = arr.clone();
    }//clona o array

    private static int getReversed(int number) { //inverte um número
        int reversed = 0;
        while (number != 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number /= 10;
        }
        return reversed;
    }

    /**
     * alínea c. adiciona um elemento ao array
     */
    public void add(int element) {
        int[] newArray = array.clone(); //copia o array de forma segura
        newArray = Arrays.copyOf(newArray, newArray.length + 1);
        newArray[newArray.length - 1] = element;
        array = newArray;
    } //array torna-se em novo array, não devolve

    /**
     * alínea d. remove o primeiro elemento igual a "value"
     */
    public void removeFirstValue(int value) throws IllegalArgumentException {
        int detectedValue = detectFirstValue(value); //deteta o primeiro valor igual a "value"
        if (detectedValue == -1) { //se o valor não existir ou Array Vazio
            throw new IllegalArgumentException(argumentoInvalido); //lança uma exceção
        }
        int[] newArray = new int[array.length];
        newArray = Arrays.copyOf(newArray, newArray.length - 1);
        int ind = 0;
        for (int i = 0; i < array.length; i++) { //percorre o array
            if (i == detectedValue) //se o valor for igual ao valor a remover, continua
                continue;
            newArray[ind] = array[i];
            ind++;
        }
        this.array = newArray;
    } //array torna-se em novo array, não devolve

    private int detectFirstValue(int value) { //deteta o primeiro valor igual a "value"
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    /**
     * alínea e. retorna o elemento na posição "position"
     */
    public int returnElement(int position) throws IllegalArgumentException {
        if (position < 0 || position >= this.array.length) { //se a posição for inválida
            throw new IllegalArgumentException(argumentoInvalido);
        } //lança uma exceção
        return this.array[position];
    } //retorna o elemento na posição "position"

    /**
     * alínea f. retorna o tamanho do array
     */
    public int getSize() {
        return array.length;
    } //retorna o tamanho do array

    /**
     * alínea g. retorna o maior elemento do array
     */
    public int largest() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int maior = array[0]; //menor ou maior elemento
        for (int value : array)
            maior = Math.max(maior, value);
        return maior;
    }

    /**
     * alínea h. retorna o menor elemento do array
     */
    public int smallest() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int menor = array[0]; //menor ou maior elemento
        for (int value : array)
            menor = Math.min(menor, value);
        return menor;
    }

    /**
     * alínea i. retorna a média dos elementos do array
     */
    public double average() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int sum = 0;
        for (int value : array) {
            sum += value;
        } //soma todos os elementos do array GERAL
        return (double) sum / array.length;
    }

    /**
     * alínea j. retorna a média dos elementos pares do array
     */
    public double averageEvens() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int sum = 0;
        int counter = 0;
        for (int value : array) {
            if (value % 2 == 0) {
                sum += value;
                counter++;
            }
        }
        if (counter == 0)
            throw new IllegalArgumentException(noMultiples); // se não houver pares
        //soma todos os elementos do array GERAL
        return (double) sum / counter;
    }

    /**
     * alínea k. retorna a média dos elementos ímpares do array
     */
    public double averageOdds() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int sum = 0;
        int counter = 0;
        for (int value : array) {
            if (value % 2 != 0) {
                sum += value;
                counter++;
            }
        }
        if (counter == 0)
            throw new IllegalArgumentException(noMultiples); // se não houver impares
        //soma todos os elementos do array GERAL
        return (double) sum / counter;
    }

    /**
     * alínea l. retorna a média dos elementos múltiplos de "multiple"
     */
    public double averageMultiples(int multiple) {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int sum = 0;
        int counter = 0;
        for (int value : array) {
            if (value % multiple == 0) {
                sum += value;
                counter++;
            }
        }
        if (counter == 0)
            throw new IllegalArgumentException(noMultiples);
        //soma todos os elementos do array GERAL
        return (double) sum / counter;
    }

    /**
     * alínea m. retorna o array ordenado de forma ascendente (true) ou descendente (false)
     */
    public int[] returnArrayOrder(boolean ascending) throws IllegalArgumentException {
        if (this.array == null || this.array.length == 0) {
            throw new IllegalArgumentException(arrayVazio);
        } //excepção
        int[] newArray = array.clone(); //copia o array
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                if (ascending) { //se for para ordenar de forma ascendente
                    if (newArray[i] > newArray[j]) { //se o elemento da esquerda for maior que o da direita
                        swapElements(newArray, i, j);
                    } //troca os elementos
                } else { //se for para ordenar de forma descendente
                    if (newArray[i] < newArray[j]) { //se o elemento da esquerda for menor que o da direita
                        swapElements(newArray, i, j);
                    }
                }
            }
        } //troca os elementos
        return newArray;
    } //retorna o array ordenado

    private void swapElements(int[] array, int i, int j) { //troca os elementos de posição
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * alínea n. verifica se o array está vazio
     */
    public boolean isEmpty() {
        return array.length == 0;
    }

    /**
     * alínea o. verifica se o array tem apenas um elemento
     */
    public boolean onlyOneElement() {
        return array.length == 1;
    }

    /**
     * alínea p. verifica se todos os elementos do array são pares
     */
    public boolean isAllEven() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        for (int value : array) {
            if (!isPair(value)) //se um valor não for par, retorna falso
                return false;
        }
        return true;  //retorna verdadeiro
    }

    private boolean isPair(int value) { //testa se é par
        return value % 2 == 0;
    }

    /**
     * alínea q. verifica se todos os elementos do array são ímpares
     */
    public boolean isAllOdds() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        for (int value : array) {
            if (isPair(value)) //se um valor não for ímpar
                return false; //retorna falso
        }
        return true; //retorna verdadeiro
    }

    /**
     * alínea r. verifica se o array tem elementos duplicados
     */
    public boolean hasDuplicates() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true; // Vetor tem elementos duplicados.
                }
            }
        }

        return false; // Vetor não tem elementos duplicados.
    }

    /**
     * alínea s. retorna os números com mais algarismos que a média
     */
    public int[] overAverageAlgarisms() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        double averageAlgarism = averageAlgarisms(array); //média de algarismos
        for (int value : array) //percorre o array
            if (numberofAlgarisms(value) > averageAlgarism) { //se o número de algarismos for maior que a média
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = value;
            } //adiciona o valor ao array
        return newArray;
    }

    private int numberofAlgarisms(int number) {
        int counter = 0;
        if (number == 0)
            return 1;
        while (number != 0) {
            counter++;
            number /= 10;
        }
        return counter; //retorna o número de algarismos de um número
    }

    private double averageAlgarisms(int[] arr) { //média de um array específico
        double sum = 0;
        for (int value : arr) {
            sum += numberofAlgarisms(value);
        }
        return sum / arr.length; //retorna a média do array ESPECÍFICO
    }

    /**
     * alínea t. retorna os números com mais dígitos pares do que a média
     */
    public int[] overAveragePercentagePairs() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        double averagePairs = avgPairs();
        for (int value : array) { //percorre o array
            if (percentageOfPairs(value) > averagePairs) { //se a percentagem de pares for maior que a média
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = value; //adiciona o valor ao array
            }
        }
        return newArray;
    }

    private double percentageOfPairs(int value) { //converte um número na percentagem de pares
        int contadorDigitos = 0;
        int contadorPares = 0;
        if (value == 0)
            return 1;
        while (value != 0) {
            int remainder = value % 10;
            if (remainder % 2 == 0)
                contadorPares++;
            contadorDigitos++;
            value /= 10;
        }
        return (double) contadorPares / contadorDigitos;
    }

    private double avgPairs() {
        double sum = 0;
        for (int value : array) {
            sum += percentageOfPairs(value);
        }
        return sum / array.length;
    }

    /**
     * alínea u. retorna os números com apenas dígitos pares
     */
    public int[] elementsWithOnlyEvenDigits() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); // exceção
        int[] newArray = new int[0];
        for (int value : array) { // percorre o array
            if (hasOnlyEvenDigits(value)) { // se o valor tiver apenas dígitos pares
                newArray = Arrays.copyOf(newArray, newArray.length + 1); // aumenta o tamanho do array
                newArray[newArray.length - 1] = value; // adiciona o valor ao array
            }
        }
        return newArray;
    }

    private boolean hasOnlyEvenDigits(int value) { // testa se um valor tem apenas dígitos pares
        int[] numberArray = numberToArray(value); // converte o valor num array de dígitos
        for (int digit : numberArray) { // percorre o array de dígitos
            if (!isPair(digit)) { // se um dígito não for par
                return false;
            }
        }
        return true;
    }

    /**
     * alínea v. retorna os números com dígitos em ordem crescente
     */
    public int[] crescents() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        for (int value : array) { //percorre o array
            if (isCrescent(value)) { //verifica se número é crescente
                newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
                newArray[newArray.length - 1] = value;
            }
        } //adiciona o valor ao array
        return newArray;
    }

    private boolean isCrescent(int value) { //verifica se um número é crescente
        int[] numberArray = numberToArray(value); //converte o valor num array de dígitos
        if (numberArray.length == 1) //se o número tiver apenas um dígito
            return false;
        for (int i = 1; i < numberArray.length; i++) { //percorre o array de dígitos
            if (numberArray[i] <= numberArray[i - 1]) { //se um dígito não for maior que o anterior
                return false;
            }
        }
        return true;
    }

    /**
     * alínea w. devolve as capicuas de um array
     */
    public int[] findCapicuas() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //exceção
        Array result = new Array(); // é criado um novo array onde se vai adicionar o elementos que forem capicuas
        for (int i = 0; i < this.getSize(); i++) {
            int number = this.returnElement(i); //retorna o elemento na posição "i"
            if (number < 0) //se o número for negativo não é capicua, segue para o próximo elemento
                continue;
            int reversed = getReversed(number); //chama a função que inverte o número
            if (number == reversed) //verifica se o número é igual ao número invertido
                result.add(number); //se for capicua, adiciona ao array
        }
        return result.getArray(); //retorna o array
    }

    private int[] getArray() { //retorna o array
        return array;
    }

    /**
     * alínea x. devolve os números com dígitos iguais
     */
    public int[] sameDigits() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        for (int value : array) { //percorre o array
            if (hasSameDigits(value)) { //se o valor tiver apenas dígitos pares
                newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
                newArray[newArray.length - 1] = value;
            }
        } //adiciona o valor ao array
        return newArray;
    }

    private boolean hasSameDigits(int value) { //testa se um valor tem apenas dígitos pares
        int[] numberArray = numberToArray(value); //converte o valor num array de dígitos
        if (numberArray.length == 1) //se o número tiver apenas um dígito
            return true;
        for (int i = 1; i < numberArray.length; i++) { //percorre o array de dígitos
            if (numberArray[i] != numberArray[0]) { //se um dígito não for igual ao primeiro
                return false;
            }
        }
        return true;
    }

    private int[] numberToArray(int value) { //converte um número num array
        int[] newArray = new int[0];
        while (value > 0) {
            newArray = extendArraytoTheLeft(newArray);
            newArray[0] = value % 10;
            value /= 10;
        }
        return newArray;
    }

    private int[] extendArraytoTheLeft(int[] array) { //aumenta o tamanho do array RESPEITANDO A ORDEM
        int[] newArray = new int[array.length];
        newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
        for (int i = 1; i < newArray.length; i++) { //percorre o array
            newArray[i] = array[i - 1];
        } //copia o array, MOVENDO OS DÍGITOS PARA A ESQUERDA
        return newArray;
    } //retorna o array novo

    /**
     * alínea y. devolve os números que não são armstrong
     */
    public int[] noArmstrongNumbers() throws IllegalArgumentException {
        if (this.array.length == 0) //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio); //lança uma exceção
        int[] newArray = new int[0]; //cria um novo array
        for (int value : array) { //percorre o array
            if (!isArmstrongNumber(value)) { //se o valor não for armstrong
                newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
                newArray[newArray.length - 1] = value; //adiciona o valor ao array
            }
        }
        return newArray;
    }

    private boolean isArmstrongNumber(int value) { //testa se um valor é armstrong
        int[] digits = numberToArray(value); //converte o valor num array de dígitos
        int numDigits = digits.length; //número de dígitos
        int sum = 0; //soma dos dígitos
        for (int digit : digits) //percorre o array de dígitos
            sum += Math.pow(digit, numDigits); //soma os dígitos elevados ao número de dígitos
        return sum == value; //retorna se a soma é igual ao valor
    }

    /**
     * alínea z. devolve os números com uma sequência crescente de pelo menos "min" dígitos
     */
    public int[] crescentForMin(int min) {
        if (array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        for (int value : array) {
            if (verifyCrescentForMin(min, value)) {
                newArray = Arrays.copyOf(newArray, newArray.length + 1);
                newArray[newArray.length - 1] = value;
            }
        }
        return newArray;
    }

    private boolean verifyCrescentForMin(int min, int number) { //verifica se um número tem uma sequência crescente de pelo menos "min" dígitos
        int[] numbertoArray = numberToArray(number); //converte o valor num array de dígitos
        int counter = 1;
        for (int i = 1; i < numbertoArray.length; i++) { //percorre o array de dígitos
            if (numbertoArray[i] > numbertoArray[i - 1]) { //se o dígito for maior que o anterior, acrescenta 1 ao contador
                counter++;
                if (counter == min)
                    return true;
            } else
                counter = 1;
        }
        return false;
    }

    /**
     * alínea aa. verifica se dois arrays são iguais
     */
    public boolean equalsArray(int[] arr) throws IllegalArgumentException {
        if (arr == null) //se o array for nulo
            throw new NullPointerException(arrayNulo); //lança uma exceção
        if (this.array.length != arr.length) //se os arrays tiverem tamanhos diferentes
            return false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != arr[i]) //se os arrays tiverem elementos diferentes
                return false;
        }
        return true;
    }

    public boolean equalsArray(Array arr) throws IllegalArgumentException {
        if (this.array.length != arr.getSize()) //se os arrays tiverem tamanhos diferentes
            return false;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] != arr.returnElement(i)) //se os arrays tiverem elementos diferentes
                return false;
        }
        return true;
    }
}