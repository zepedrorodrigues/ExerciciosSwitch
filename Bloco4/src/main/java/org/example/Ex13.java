package org.example;

import java.util.LinkedHashSet;

public class Ex13 {
    public static int devolverMenorValordeArray(int[] array) {
        int menorValor = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < menorValor)
                menorValor = value;
        }
        return menorValor;
    }

    public static int devolverMaiorValordeArray(int[] array) {
        int maiorValor = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maiorValor)
                maiorValor = value;
        }
        return maiorValor;
    }

    public static double mediaArray(int[] array) {
        if (array.length == 0)
            return Integer.MIN_VALUE;
        int soma = Ex3.somaElementosVetor(array);
        return (double) soma / (array.length);
    }

    public static int produtoNumerosArray(int[] array) {
        if (array.length == 0)
            return Integer.MIN_VALUE;
        int produto = 1;
        for (int value : array)
            produto = produto * value;
        return produto;
    }

    public static int[] arraysValoresUnicos(int[] array) {
        LinkedHashSet<Integer> newHash = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++)
            newHash.add(array[i]);
        int[] newArray = new int[newHash.size()];
        int ind = 0;
        for (int value : newHash) {
            newArray[ind] = value;
            ind++;
        }
        return newArray;
    }

    public static int[] arrayInvertido(int[] array) {
        int[] arrayFinal = new int[array.length];
        for (int i = 0; i < array.length; i++)
            arrayFinal[array.length - 1 - i] = array[i];
        return arrayFinal;
    }

    public static boolean verificarSeNumeroPrimo(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static int[] numerosPrimosDoVetor(int[] array) {
        int[] arrayNumerosTodos = new int[array.length];
        int ind = 0;
        for (int value : array) {
            if (verificarSeNumeroPrimo(value))
                arrayNumerosTodos[ind++] = value;
        }
        int[] arrayPrimos = new int[ind];
        for (int i = 0; i < ind; i++)
            arrayPrimos[i] = arrayNumerosTodos[i];
        return arrayPrimos;
    }
}
