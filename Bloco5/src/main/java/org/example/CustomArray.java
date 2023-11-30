package org.example;
import java.util.Arrays;
public class CustomArray {
    private int[] array; // = save the Array
    private static final String emptyArray = "Array is empty"; //erros messages
    private static final String nullArray = "Array is null"; //erros messages
    private static final String InvalidValue = "Invalid Value"; //erros messages

    @Override
    public boolean equals(Object o) { //equals method replaced
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false; //if o is null or not the same class
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    } //return true if the arrays are equal

    @Override
    public int hashCode() { //hashCode method replaced
        return Arrays.hashCode(array);
    }

    public CustomArray() { //constructor empty parameters
        this.array = new int[0];
    }

    public CustomArray(int[] arr) throws NullPointerException { //constructor with parameters
        if (arr == null) { //if arr is null
            throw new NullPointerException(nullArray);
        } //throw exception
        this.array = arr.clone();
    }

    public int[] getArray() { //getArray method
        return array;
    }

    public int getSize() { //getSize method
        return array.length;
    }

    public int getbyIndex(int index) throws IndexOutOfBoundsException { //getElement method
        if (index < 0 || index >= array.length) { //if index is out of bounds
            throw new IndexOutOfBoundsException(InvalidValue);
        } //throw exception
        return array[index];
    }

    public void setElement(int index, int value) throws IndexOutOfBoundsException { //setElement method
        if (index < 0 || index >= array.length) { //if index is out of bounds
            throw new IndexOutOfBoundsException(InvalidValue);
        } //throw exception
        array[index] = value;}
    public int[][] addArray(int[]addingArray){
        int[][] newArray = new int[2][];
        newArray[0] = array;
        newArray[1] = addingArray;
        return newArray;}

    public void addElement(int value) { //addElement method
        int[] newArray = array.clone();  //clone the array
        newArray = Arrays.copyOf(newArray, newArray.length + 1);//create a new array with size + 1
        newArray[newArray.length - 1] = value; //add the value
        array = newArray;
    } //replace the array

    public void removeFirstElement(int element) throws IndexOutOfBoundsException { //removeElement method
        if (detectIndexFirstNumberX(element) == -1) { //if the element is not in the array
            throw new IllegalArgumentException(InvalidValue);
        } //throw exception
        int[] newArray = new int[array.length - 1]; //create a new array with size - 1
        int detectIndex = detectIndexFirstNumberX(element); //detect the index of the element
        int counter = 0; //contador
        for (int i = 0; i < array.length; i++) {
            if (i == detectIndex)//if the index is the same as the element
                continue;
            newArray[counter] = array[i];
            counter++;
        }
        array = newArray;
    } //replace the array

    public int detectIndexFirstNumberX(int x) { //detectIndexFirstNumberX method
        for (int i = 0; i < array.length; i++) //for each element in the array
            if (array[i] == x)  //if the element is equal to x
                return i;//return the index
        return -1;
    } //return -1 if not found

    public int getBiggestSmallestNumber(boolean bigTruesmallFalse) {//getBiggestSmallestNumber method
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        int biggest = array[0]; //set the biggest
        int smallest = array[0]; //set the smallest
        for (int value : array) {
            biggest = Math.max(biggest, value);//for each value set the biggest
            smallest = Math.min(smallest, value);
        }//for each value set the smallest
        if (bigTruesmallFalse) //if request is biggest
            return biggest;
        return smallest;
    } //Else return the smallest

    public int getSum() {
        int sum = 0;
        for (int value : array)
            sum += value;
        return sum;
    }

    private int getSumWithArguments(int[] arr) {
        int sum = 0;
        for (int j : arr) sum += j;
        return sum;
    }

    private double getSumWithArgumentsDouble(double[] arr) {
        double sum = 0;
        for (double j : arr) sum += j;
        return sum;
    }

    public double getAveragenoArguments() {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        return (double) getSum() / array.length;
    }

    private double getAveragewithArguments(int[] arr) {
        return (double) getSumWithArguments(arr) / arr.length;
    }

    private double getAveragewithArgumentsDouble(double[] arr) {
        return getSumWithArgumentsDouble(arr) / arr.length;
    }

    public int[] extendArraytoTheRightNoArguments(){
        return extendArraytoTheRight(array);}
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

    public int[] extendArraytoTheLeft(int[] array) { //aumenta o tamanho do array RESPEITANDO A ORDEM
        int[] newArray = new int[array.length];
        newArray = Arrays.copyOf(newArray, newArray.length + 1); //aumenta o tamanho do array
        //percorre o array
        //copia o array, MOVENDO OS DÍGITOS PARA A ESQUERDA
        if (newArray.length - 1 >= 0) System.arraycopy(array, 0, newArray, 1, newArray.length - 1);
        return newArray;
    } //retorna o array novo

    private int[] getMultiplesNonMultiples(int mult, boolean yesOrNo) {
        if (mult == 0 || array.length == 0)
            throw new IllegalArgumentException(InvalidValue);
        int[] multiples = new int[0];
        int[] nonMultiples = new int[0];
        int counterMultiples = 0;
        int counterNonMultiples = 0;
        for (int j : array) {
            if (j % mult == 0) {
                multiples = Arrays.copyOf(multiples, multiples.length + 1);
                multiples[counterMultiples] = j;
                counterMultiples++;
            } else {
                nonMultiples = Arrays.copyOf(nonMultiples, nonMultiples.length + 1);
                nonMultiples[counterNonMultiples] = j;
                counterNonMultiples++;
            }
        }
        if (yesOrNo)
            return multiples;
        return nonMultiples;
    }

    public double averagemultiplesNonMultiples(int numberTested, boolean multiples) throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        return getAveragewithArguments(getMultiplesNonMultiples(numberTested, multiples));
    }

    public void sortAscendingDescending(boolean ascending) throws IllegalArgumentException {
        if (this.array.length == 0) {
            throw new IllegalArgumentException(emptyArray);
        } //excepção
        int[] newArray = array.clone(); //copia o array
        Arrays.sort(newArray);
        if (!ascending) {
            int[] newArray2 = new int[newArray.length];
            for (int i = 0; i < newArray.length; i++) {
                newArray2[i] = newArray[newArray.length - 1 - i];
            }
            newArray = newArray2;
        }
        array = newArray;
    }//ordena o array

    public boolean isSize(int x) {
        return array.length == x;}

    public boolean isOnlyEvenNumbers(boolean evensTrueoddsFalse) throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        if (evensTrueoddsFalse) {
            for (int j : array) {
                if (j % 2 != 0)
                    return false;
            }
            return true;
        }
        for (int j : array) {
            if (j % 2 == 0)
                return false;
        }
        return true;
    }

    public boolean duplicatesCheck() throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        int[] newArray = array.clone();
        Arrays.sort(newArray);
        for (int i = 1; i < newArray.length; i++) {
            if (newArray[i] == newArray[i - 1])
                return true;
        }
        return false;
    }

    private int[] numberToArray(int value) { //converte um número num array
        int[] newArray = new int[0];
        while (value > 0) {
            newArray = extendArraytoTheLeft(newArray);
            newArray[0] = value % 10;
            value /= 10;}
        return newArray;}

    public int[] arrayofNumberstoArrayofDigits() { //converte um array de números num array de dígitos
        int[] newArray = new int[0];
        for (int value : array) {
            int numberArray = numberToArray(value).length;
            newArray = extendArraytoTheRight(newArray);
            newArray[newArray.length - 1] = numberArray;
        }
        return newArray;
    }

    public double[] arrayofNumberstoArrayofPercentageofPairs() { //converte um array de números num array de pares
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
            if (j % 2 == 0)
                contador++;
        }
        return ((double) contador / numberArray.length) * 100;
    }

    public int[] overAverageAlgarisms() throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        int[] newArray = new int[0];
        int[] algarismsArray = arrayofNumberstoArrayofDigits(); //array de algarismos
        double averageAlgarisms = getAveragewithArguments(algarismsArray); //média de algarismos
        for (int i = 0; i < array.length; i++) {
            if (algarismsArray[i] > averageAlgarisms) { //se o número de algarismos for maior que a média
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = array[i];
            }
        } //adiciona o valor ao array
        return newArray;
    }

    public int[] overAveragePairs() throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        int[] newArray = new int[0];
        double[] pairsArray = arrayofNumberstoArrayofPercentageofPairs(); //array de percentagens de pares
        double averagePairs = getAveragewithArgumentsDouble(pairsArray);
        for (int i = 0; i < array.length; i++) { //percorre o array
            if (pairsArray[i] > averagePairs) { //se a percentagem de pares for maior que a média
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = array[i];
            }
        } //adiciona o valor ao array
        return newArray;
    }

    public int[] numbersPerfectPairs() throws IllegalArgumentException {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        int[] newArray = new int[0];
        double[] percentageofPairs = arrayofNumberstoArrayofPercentageofPairs(); //array de percentagens de pares
        for (int i = 0; i < array.length; i++) { //percorre o array
            if (percentageofPairs[i] == 100) {
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = array[i];}
        } //adiciona o valor ao array
        return newArray;}

    public int[] crescentNumbers() throws IllegalArgumentException {
        int[] newArray = new int[0];
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        for(int i: array){
            int[] numberArray = numberToArray(i);
            if(isCrescent(numberArray)){
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = i;}}
        return newArray;}
    public int[] getCapicuas()throws IllegalArgumentException{
        int[] newArray = new int[0];
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        for(int i: array){
            int[] numberArray = numberToArray(i);
            if(isCapicua(numberArray)){
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = i;}}
        return newArray;}

    public int[] getNumbersSameAlgarism()throws IllegalArgumentException{
        int[] newArray = new int[0];
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        for(int i: array){
            int[] numberArray = numberToArray(i);
            for(int j=0;j<numberArray.length;j++){
                if(numberArray[j]!=numberArray[0]){
                    break;}
                if(j==numberArray.length-1){ //se o número for igual tendo percorrido o array
                    newArray = extendArraytoTheRight(newArray);
                    newArray[newArray.length - 1] = i;}}}
        return newArray;}
    public int[] getNonArmstrongs()throws IllegalArgumentException{
        int[] newArray = new int[0];
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        for(int i: array){
            if(!isArmstrong(i)){
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = i;}}
        return newArray;}
    public int[] getNumbersCrescentatLeastXSequence(int x)throws IllegalArgumentException{
        int[] newArray = new int[0];
        if(x<2)
            throw new IllegalArgumentException(InvalidValue); //excepção
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //excepção
        for(int i: array){
            if(isCrescentatLeastXSequence(i,x)){
                newArray = extendArraytoTheRight(newArray);
                newArray[newArray.length - 1] = i;}}
        return newArray;}
    private boolean isCrescent(int[] array) {
        if(array.length == 1)
            return false; //excepção
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1])
                return false;}
        return true;}
    private boolean isCapicua(int[] array) {
        if(array.length == 1)
            return true; //excepção
        for (int i = 0; i < array.length; i++) {
            if (array[i] != array[array.length - i - 1])
                return false;}
        return true;}
    private boolean isArmstrong(int number) {
        int[] numberArray = numberToArray(number);
        int sum = 0;
        for (int j : numberArray) {
            sum += Math.pow(j, numberArray.length);}
        return sum == number;}

    private boolean isCrescentatLeastXSequence(int number, int x){
        int[] numbertoArray = numberToArray(number);
        int counter = 1;
        for(int i=1;i<numbertoArray.length;i++){
            if(numbertoArray[i]>numbertoArray[i-1]){
                counter++;
                if(counter==x)
                    return true;}
            else
                counter=1;}
        return false;}

    public void reverse(){
        int[] newArray = new int[array.length];
        for(int i=0;i<array.length;i++){
            newArray[i] = array[array.length-i-1];}
        array=newArray;}
    }