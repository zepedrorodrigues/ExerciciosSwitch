package org.example;

public class Ex2 {
    public static int[] devolverUmVetorComNumerosDeDigitos(int num) {
        int tamanho = Ex1.devolverNumeroDeAlgarismos(num);
        if (tamanho < 1)
            return new int[0];
        int[] newArray = new int[tamanho];
        for (int i = tamanho - 1; i >= 0; i--) {
            newArray[i] = num % 10;
            num = num / 10;
        }
        return newArray;
    }
}