package org.example;

public class Ex9 {
    public static int[] devolverMultiplosDe3DeUmIntervalo(int min, int max) {
        int[] multiplosDeTres = new int[0];
        int index = 0;
        for (int i = min; i <= max; i++) {
            if (i % 3 == 0) {
                multiplosDeTres = Ex4.estenderArray(multiplosDeTres);
                multiplosDeTres[index++] = i;
            }
        }
        return multiplosDeTres;
    }
}
