package org.example;

public class Ex7 {
    public static int devolvePosicaodoArray(int[] array, int num) {
        if (array.length == 0)
            return -1;
        for (int value : array)
            if (value <= 0)
                return -1;
        int n = 1, index = 0;
        while (num >= n || index < array.length) {
            n = n * array[index];
            index++;
        }
        if (num >= n)
            return -1;
        return index;
    }
}