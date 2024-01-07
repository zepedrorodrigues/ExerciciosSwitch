package org.example;

public class Ex5 {
    public static int[] elementosImparesDoVetor(int[] array) {
        int[] arrayImpares = new int[0];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayImpares = Ex4.estenderArray(arrayImpares);
                arrayImpares[j++] = array[i];
            }
        }
        return arrayImpares;
    }
}