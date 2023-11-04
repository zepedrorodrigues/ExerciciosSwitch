package org.example;

public class Ex8 {
    public static int[] devolverVetorComXElementos(int[] array, int num) {
        if (num < 0) {
            num = 0;
        } else {
            if (num > array.length) {
                num = array.length;
            }
        }
        int[] novo_array = new int[num];
        for (int i = 0; i < num; i++)
            novo_array[i] = array[i];
        return novo_array;
    }
}