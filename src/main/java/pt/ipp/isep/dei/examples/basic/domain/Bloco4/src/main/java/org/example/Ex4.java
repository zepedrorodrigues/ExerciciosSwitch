package org.example;

public class Ex4 {
    public static int[] devolverArraySoComPares(int[] array) {
        int[] newArray = new int[0];
        for (int value : array) {
            if (value % 2 == 0) {
                newArray = estenderArray(newArray);
                newArray[newArray.length - 1] = value;
            }
        }
        return newArray;
    }

    public static int[] estenderArray(int[] array) {
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++)
            newArray[i] = array[i];
        return newArray;
    }
}
