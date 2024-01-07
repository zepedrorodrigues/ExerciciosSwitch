package org.example;

import java.util.Arrays;

public class Ex8 {
    public static int[] devolverVetorComXElementos(int[] array, int num) {
        if (num < 1 || num > array.length)
            return new int[0];
        return Arrays.copyOf(array,num);
    }
}