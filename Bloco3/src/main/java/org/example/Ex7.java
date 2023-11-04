package org.example;

public class Ex7 {
    public static int arrayPositivos(int[] array, int num) {
        if (array.length == 0)
            return -1;
        int produto = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return -1;
            } else {
                produto *= array[i];
                if (produto > num)
                    return i;
            }
        }
        return -1;
    }
}
