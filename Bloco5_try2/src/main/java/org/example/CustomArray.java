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
        if (o == null || getClass() != o.getClass()) return false; //if o is null or not the same class
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
        array[index] = value;
    }

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

    private int detectIndexFirstNumberX(int x) { //detectIndexFirstNumberX method
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

    private int getSum() {
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

    public double getAveragenoArguments() {
        if (array.length == 0)
            throw new IllegalArgumentException(emptyArray); //throw exception
        return (double) getSum() / array.length;
    }

    private double getAveragewithArguments(int[] arr) {
        return (double) getSumWithArguments(arr) / arr.length;
    }

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
        return getAveragewithArguments(getMultiplesNonMultiples(numberTested, multiples));}

    public void sortAscendingDescending(boolean ascending) throws IllegalArgumentException {
        if (this.array.length == 0) {
            throw new IllegalArgumentException(emptyArray);
        } //excepção
        int[] newArray = array.clone(); //copia o array
        Arrays.sort(newArray);
        if (!ascending) {
            int[] newArray2 = new int[newArray.length];
            for (int i = 0; i < newArray.length; i++) {
                newArray2[i] = newArray[newArray.length - 1 - i];}
            newArray = newArray2;}
        array = newArray;}//ordena o array
}