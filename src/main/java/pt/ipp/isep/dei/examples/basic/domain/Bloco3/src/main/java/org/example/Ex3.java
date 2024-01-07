package org.example;

public class Ex3 {

    public static int[] aumentarArray1(int[] array) {
        int[] novoArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            novoArray[i] = array[i];
        }
        return novoArray;
    }

    public static int[] guardarNumeros(int min, int max) {
        int[] arrayComNumeros = new int[max - min + 1];
        for (int i = 0; min <= max; i++) {
            arrayComNumeros[i] = min++;
        }
        return arrayComNumeros;
    }

    public static int[] guardarNumerosParesOuImpares(int[] array, boolean opcao) {
        int[] arrayParesOuImpares = new int[0];
        if (opcao == true) {
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    arrayParesOuImpares = aumentarArray1(arrayParesOuImpares);
                    arrayParesOuImpares[j] = array[i];
                    j++;
                }
            }
            return arrayParesOuImpares;
        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayParesOuImpares = aumentarArray1(arrayParesOuImpares);
                arrayParesOuImpares[j] = array[i];
                j++;
            }
        }
        return arrayParesOuImpares;
    }

    public static int somaNumero(int min, int max, boolean opcao) {
        int[] arrayNumeros = guardarNumeros(min, max);
        int soma = 0;
        if (opcao == true) {
            int[] arrayPares = guardarNumerosParesOuImpares(arrayNumeros, opcao);
            for (int i = 0; i < arrayPares.length; i++) {
                soma += arrayPares[i];
            }
            return soma;
        }
        int[] arrayImpares = guardarNumerosParesOuImpares(arrayNumeros, opcao);
        for (int i = 0; i < arrayImpares.length; i++) {
            soma += arrayImpares[i];
        }
        return soma;
    }

    public static int[] guardarNumerosMultiplos(int[] array, int num) {
        int[] arrayMultiplos = new int[0];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % num == 0) {
                arrayMultiplos = aumentarArray1(arrayMultiplos);
                arrayMultiplos[j] = array[i];
                j++;
            }
        }
        return arrayMultiplos;
    }

    public static int somaMultiplos(int min, int max, int num) {
        if (num == 0)
            return -1;
        int[] arrayMultiplos = guardarNumeros(min, max);
        int soma = 0;
        int[] multiplos = guardarNumerosMultiplos(arrayMultiplos, num);
        for (int i = 0; i < multiplos.length; i++) {
            soma += multiplos[i];
        }
        return soma;
    }

    public static int produtoMultiplos(int min, int max, int num) {
        if (num == 0)
            return -1;
        int[] arrayMultiplos = guardarNumeros(min, max);
        int produto = 1;
        int[] multiplos = guardarNumerosMultiplos(arrayMultiplos, num);
        for (int i = 0; i < multiplos.length; i++) {
            produto *= multiplos[i];
        }
        if (multiplos.length == 0)
            return 0;
        return produto;
    }

    public static int mediaMultiplos1numero(int min, int max, int num) {
        int somaMultiplos = somaMultiplos(min, max, num);
        int media = somaMultiplos / quantidadeMultiplos(min, max, num);
        return media;
    }

    public static int quantidadeMultiplos(int min, int max, int num) {
        if (num == 0)
            return -1;
        int[] arrayNumeros = guardarNumeros(min, max);
        int[] arrayImpares = guardarNumerosMultiplos(arrayNumeros, num);
        return arrayImpares.length;
    }

    public static int quantidadeNumeros(int min, int max, boolean opcao) {
        int[] arrayNumeros = guardarNumeros(min, max);
        if (opcao == true) {
            int[] arrayPares = guardarNumerosParesOuImpares(arrayNumeros, opcao);
            return arrayPares.length;
        }
        int[] arrayImpares = guardarNumerosParesOuImpares(arrayNumeros, opcao);
        return arrayImpares.length;
    }
}
