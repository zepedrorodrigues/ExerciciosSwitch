package org.example;

import java.util.Arrays;

public class Array {
    private int[] array; //array de inteiros
    private static final String argumentoInvalido = "Argumento Inválido."; //mensagem de erro
    private static final String arrayNulo = "Array Nulo."; //mensagem de erro
    private static final String arrayVazio = "Array Vazio."; //mensagem de erro

    private static final String noMultiples = "Sem múltiplos."; //mensagem de erro

    /**alínea a.*/
    public Array() { //construtor vazio
        array = new int[0];
    }

    /**alínea b.*/
    public Array(int[] arr) { //construtor com argumento
        if (arr == null) //se o array for nulo
            throw new NullPointerException(arrayNulo); //lança uma exceção
        this.array = arr.clone();}//clona o array

    /** alínea c.*/
    public void add(int element) { //adiciona um elemento ao array
        int[] newArray = array.clone(); //copia o array de forma segura
        newArray = Arrays.copyOf(newArray, newArray.length + 1);
        newArray[newArray.length - 1] = element;
        array = newArray;} //array torna-se em novo array, não devolve

    /**alínea d.*/
    public void removeFirstValue(int value) throws IllegalArgumentException {
        int detectedValue = detectFirstValue(value); //deteta o primeiro valor igual a "value"
        if (detectedValue == -1) { //se o valor não existir ou Array Vazio
            throw new IllegalArgumentException(argumentoInvalido);
        } //lança uma exceção
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

    /**alínea e.*/
    public int returnElement(int position) throws IllegalArgumentException { //retorna o elemento na posição "position"
        if (position < 0 || position >= this.array.length) { //se a posição for inválida
            throw new IllegalArgumentException(argumentoInvalido);
        } //lança uma exceção
        return this.array[position];
    } //retorna o elemento na posição "position"

    /**alínea f.*/
    public int getSize() {
        return array.length;
    } //retorna o tamanho do array

    /**alínea g.*/
    public int largest() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int maior = array[0]; //menor ou maior elemento
        for (int value : array)
            maior = Math.max(maior, value);
        return maior;
    }

    /**alínea h.*/
    public int smallest() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int menor = array[0]; //menor ou maior elemento
        for (int value : array)
            menor = Math.min(menor, value);
        return menor;
    }

    /**alínea i.*/
    public double average() {
        if (this.array.length == 0)  //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);
        int sum = 0;
        for (int value : array) {
            sum += value;
        } //soma todos os elementos do array GERAL
        return (double) sum / array.length;
    }

    /**alínea j.*/
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
        //soma todos os elementos do array GERAL
        return (double) sum / counter;
    }

    /**alínea k.*/
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
        //soma todos os elementos do array GERAL
        return (double) sum / counter;
    }

    /**alínea l.*/
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

    /**alínea m.*/
    public int[] returnArrayOrder(boolean ascending) throws IllegalArgumentException {
        if (this.array == null || this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio);
        int[] newArray = array.clone(); //copia o array
        Arrays.sort(newArray); //ordena o array
        if(!ascending){
            int[] newArray2 = newArray.clone();
            for(int i = 0; i < newArray.length; i++){
                newArray[i] = newArray2[newArray.length - 1 - i];}}
        return newArray;}

    /**alínea n.*/
    public boolean isEmpty() {
        return array.length == 0;}

    /**alínea o.*/
    public boolean onlyOneElement() {
        return array.length == 1;}

    /**alínea p.*/
    public boolean isAllEven() throws IllegalArgumentException {//tudo par ou impar ??
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

    /** alínea q.*/
    public boolean isAllOdds() throws IllegalArgumentException {//tudo par ou impar ??
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        for (int value : array) {
            if (isPair(value)) //se um valor não for ímpar
                return false; //retorna falso
        }
        return true; //retorna verdadeiro
    }

    /**alínea r.*/
    public boolean hasDuplicates() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return true; // Vetor tem elementos duplicados.
                }
            }
        }

        return false; // Vetor não tem elementos duplicados.
    }

    /**alínea s.*/
    public int[] overAverageAlgarisms() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        double[] algarismsArray = arrayofNumberstoArrayofDigits(); //array de algarismos
        double averageAlgarisms = returnAverage(algarismsArray); //média de algarismos
        for (int i = 0; i < array.length; i++) {
            if (algarismsArray[i] > averageAlgarisms) { //se o número de algarismos for maior que a média
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = array[i];
            }
        } //adiciona o valor ao array
        return newArray;
    }

    private double returnAverage(double[] arr) throws IllegalArgumentException { //média de um array específico
        double sum = 0;
        for (double value : arr) {
            sum += value;
        }
        return sum / arr.length;
    } //retorna a média do array ESPECÍFICO

    private double[] arrayofNumberstoArrayofDigits() { //converte um array de números num array de dígitos
        double[] newArray = new double[0];
        for (int value : array) {
            int numberArray = numberToArray(value).length;
            newArray = extendArraytoTheRightDouble(newArray);
            newArray[newArray.length - 1] = numberArray;
        }
        return newArray;
    }

    private int[] extendArraytoTheRight(int[] array) { //aumenta o tamanho do array
        int[] newArray = array.clone(); //copia o array
        newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
        return newArray;
    } //retorna o array novo

    private double[] extendArraytoTheRightDouble(double[] array) {
        double[] newArray = array.clone(); //copia o array
        newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
        return newArray;
    } //retorna o array novo

    /**alínea t.*/
    public int[] overAveragePairs() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        double[] pairsArray = arrayofNumberstoArrayofPercentageofPairs(); //array de percentagens de pares
        double averagePairs = returnAverage(pairsArray);
        for (int i = 0; i < array.length; i++) { //percorre o array
            if (pairsArray[i] > averagePairs) { //se a percentagem de pares for maior que a média
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = array[i];
            }
        } //adiciona o valor ao array
        return newArray;
    }

    private double[] arrayofNumberstoArrayofPercentageofPairs() { //converte um array de números num array de pares
        double[] newArray = new double[0];
        for (int value : array) {
            double percentageOfPairs = pecentageOfPairs(value);
            newArray = extendArraytoTheRightDouble(newArray);
            newArray[newArray.length - 1] = percentageOfPairs;
        }
        return newArray;
    }

    private double pecentageOfPairs(int value) { //converte um número na percentagem de pares
        int[] numberArray = numberToArray(value);
        int contador = 0;
        for (int j : numberArray) {
            if (isPair(j))
                contador++;
        }
        return ((double) contador / numberArray.length) * 100;
    }

    /**alínea u.*/
    public int[] elementsWithOnlyEvenDigits() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); // exceção
        int[] newArray = new int[0];
        for (int value : array) { // percorre o array
            if (hasOnlyEvenDigits(value)) { // se o valor tiver apenas dígitos pares
                newArray = extendArraytoTheRight(newArray); // aumenta o tamanho do array
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

    /**alínea v.*/
    public int[] crescents() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        for (int value : array) { //percorre o array
            if (isCrescent(value)) { //verifica se número é crescente
                newArray = extendArraytoTheRight(newArray); //aumenta o tamanho do array
                newArray[newArray.length - 1] = value;
            }
        } //adiciona o valor ao array
        return newArray;
    }

    private boolean isCrescent(int value) {
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

    /**alínea w.*/
    public int[] findCapicuas() throws IllegalArgumentException { //devolve as capicuas de um array
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

    private static int getReversed(int number) { //inverte um número
        int reversed = 0;
        while (number != 0) {
            int remainder = number % 10;
            reversed = reversed * 10 + remainder;
            number /= 10;
        }
        return reversed;
    }

    private int[] getArray() {
        return array;
    } //retorna o array

    /**alínea x.*/
    public int[] sameDigits() throws IllegalArgumentException {
        if (this.array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        int[] newArray = new int[0];
        for (int value : array) { //percorre o array
            if (hasSameDigits(value)) { //se o valor tiver apenas dígitos pares
                newArray = extendArraytoTheRight(newArray); //aumenta o tamanho do array
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

    /**alínea y.*/
    public int[] noArmstrongNumbers() throws IllegalArgumentException {   //retorna os números que não são armstrong
        if (this.array.length == 0) {                                                //se o array estiver vazio
            throw new IllegalArgumentException(arrayVazio);             //lança uma exceção
        }
        int[] newArray = new int[0];                           //cria um novo array
        for (int value : array) {                              //percorre o array
            if (!isArmstrongNumber(value)) {                   //se o valor não for armstrong
                newArray = extendArraytoTheRight(newArray);    //aumenta o tamanho do array
                newArray[newArray.length - 1] = value;         //adiciona o valor ao array
            }
        }
        return newArray;
    }

    private boolean isArmstrongNumber(int value) {             //testa se um valor é armstrong
        int[] digits = numberToArray(value);                   //converte o valor num array de dígitos
        int numDigits = digits.length;                         //número de dígitos
        int sum = 0;                                           //soma dos dígitos

        for (int digit : digits) {                             //percorre o array de dígitos
            sum += Math.pow(digit, numDigits);                 //soma os dígitos elevados ao número de dígitos
        }
        return sum == value;                                   //retorna se a soma é igual ao valor
    }

    /**alínea z.*/
    public int[] crescentforMin(int min) {
        if (array.length == 0)
            throw new IllegalArgumentException(arrayVazio); //excepção
        if(min<1)
            throw new IllegalArgumentException(argumentoInvalido); //excepção
        if(min==1)
            return array;
        int[] newArray = new int[0];
        for (int value : array) {
            if (crescentforMin(min, value)) {
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = value;
            }
        }
        return newArray;
    }

    private boolean crescentforMin(int min, int number) {
        int[] numbertoArray = numberToArray(number);
        if(numbertoArray.length < min)
            return false;
        int counter = 1;
        for (int i = 1; i < numbertoArray.length; i++) {
            if (numbertoArray[i] > numbertoArray[i - 1]) {
                counter++;
                if (counter == min)
                    return true;
            } else
                counter = 1;
        }
        return false;
    }

    /**alínea aa.*/
    public boolean equalsArray(int[] arr) throws NullPointerException {
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
}