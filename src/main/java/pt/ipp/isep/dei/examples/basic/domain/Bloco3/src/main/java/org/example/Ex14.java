package org.example;

public class Ex14 {
    public static int[] devolvernumerodumarray(int num, int numeroDireita) {
        int[] new_Array = new int[1];
        new_Array[0] = numeroDireita;
        while (num != 0) {
            int alg = num % 10;
            new_Array = estenderArrayUmaCasaDireita(new_Array);
            new_Array[0] = alg;
            num = num / 10;
        }
        return new_Array;
    }

    public static int[] estenderArrayUmaCasaDireita(int[] num_final) {
        int[] new_Array = new int[num_final.length + 1];
        for (int i = num_final.length - 1; i >= 0; i--)
            new_Array[i + 1] = num_final[i];
        return new_Array;
    }

    public static boolean testarValidade(int num, int numeroDireita) {
        if (num <= 0)
            return false;
        int[] num_final = devolvernumerodumarray(num, numeroDireita);
        int n = 0, index = num_final.length;
        for (int value : num_final) {
            n += (value * index);
            index--;
        }
        return n % 11 == 0;
    }
}
