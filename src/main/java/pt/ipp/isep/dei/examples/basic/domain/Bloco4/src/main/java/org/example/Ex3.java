package org.example;

public class Ex3 {
    public static int somaElementosVetor(int[] array) {
        int soma = 0;
        for (int i = 0; i < array.length; i++) {
            soma += array[i];
        }
        return soma;
    }
}
