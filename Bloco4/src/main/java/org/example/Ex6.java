package org.example;

public class Ex6 {
    public static int devolverSomaDosPares(int num) {
        if (num <= 0)
            return -1;
        int[] numeroArray = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        int[] pares = Ex4.devolverArraySoComPares(numeroArray);
        return somadosValoresDumArray(pares);
    }

    public static int somadosValoresDumArray(int[] array) {
        int num = 0;
        for (int value : array)
            num += value;
        return num;
    }
}
