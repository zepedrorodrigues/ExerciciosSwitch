package org.example;

public class Ex4 {
    public static int[] guardarAlgarismosNumArray(long numero) {
        int[] arrayComAlgarismos = new int[0];
        if (numero < 0)
            numero *= -1;
        if (numero == 0) {
            arrayComAlgarismos = Ex2.estenderArray1lugar(arrayComAlgarismos);
            arrayComAlgarismos[0] = 0;
        }
        for (int i = 0; numero >= 1; i++) {
            int algarismo = (int) numero % 10;
            arrayComAlgarismos = Ex2.estenderArray1lugar(arrayComAlgarismos);
            numero /= 10;
            arrayComAlgarismos[i] = algarismo;
        }
        return arrayComAlgarismos;
    }

    public static int[] guardarArrayAlgarismosParesImpares(int[] array, boolean opcao) {
        int[] arrayComAlgarismosParesOuImpares = new int[0];
        if (opcao == true) {
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    arrayComAlgarismosParesOuImpares = Ex2.estenderArray1lugar(arrayComAlgarismosParesOuImpares);
                    arrayComAlgarismosParesOuImpares[j] = array[i];
                    j++;
                }
            }
            return arrayComAlgarismosParesOuImpares;
        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                arrayComAlgarismosParesOuImpares = Ex2.estenderArray1lugar(arrayComAlgarismosParesOuImpares);
                arrayComAlgarismosParesOuImpares[j++] = array[i];
            }
        }
        return arrayComAlgarismosParesOuImpares;
    }

    public static int algarismosDeUmNumero(long numero) {
        int[] arrayComAlgarismos = guardarAlgarismosNumArray(numero);
        return arrayComAlgarismos.length;
    }

    public static int numerosDeAlgarismosPares(long numero, boolean opcaoPar) {
        int[] arrayComAlgarismosPares = guardarArrayAlgarismosParesImpares(guardarAlgarismosNumArray(numero), opcaoPar);
        return arrayComAlgarismosPares.length;
    }

    public static int somaAlgarismosArray(int[] array) {
        int n = 0;
        for (int value : array)
            n += value;
        return n;
    }

    public static int somaDeAlgarismosNumero(long numero) {
        int[] arrayComAlgarismos = guardarAlgarismosNumArray(numero);
        int soma = somaAlgarismosArray(arrayComAlgarismos);
        return soma;
    }

    public static int somaDeAlgarismosPares(long numero, boolean opcao) {
        int[] arrayComAlgarismosPares = guardarArrayAlgarismosParesImpares(guardarAlgarismosNumArray(numero), opcao);
        int soma = somaAlgarismosArray(arrayComAlgarismosPares);
        return soma;
    }

    public static float mediaDeAlgarismosNumero(long numero) {
        return (float) somaDeAlgarismosNumero(numero) / algarismosDeUmNumero(numero);
    }

    public static float mediadeAlgarismosParesNumero(long numero) {
        int[] novo = guardarAlgarismosNumArray(numero);
        int[] pares = guardarArrayAlgarismosParesImpares(novo, true);
        if (pares.length == 0)
            return -1;
        return somaAlgarismosArray(pares) / (pares.length);
    }

    public static float mediaDeAlgarismosImpares(long numero) {
        int[] novo = guardarAlgarismosNumArray(numero);
        int[] impares = guardarArrayAlgarismosParesImpares(novo, false);
        if (impares.length == 0)
            return -1;
        return somaAlgarismosArray(impares) / (impares.length);
    }

    public static int devolverNumeroInverso(long numero) {
        long num = numero;
        if (numero < 0)
            num = numero * -1;
        if (numero == 0)
            return 0;
        int n = 0, numero_final = 0;
        int[] novo = guardarAlgarismosNumArray(num);
        for (int i = (novo.length) - 1; i >= 0; i--) {
            numero_final += novo[n++] * (int) Math.pow(10, i);
        }
        if (numero < 0)
            return numero_final * -1;
        return numero_final;
    }
}