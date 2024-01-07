package org.example;

public class Ex7 {
    public static int devolverSomaDosImpares(int num) {
        if (num <= 0)
            return -1;
        int[] numeroArray = Ex2.devolverUmVetorComNumerosDeDigitos(num);
        int[] impares = Ex5.elementosImparesDoVetor(numeroArray);
        return somaDosValoresDumArray(impares);
    }

    public static int somaDosValoresDumArray(int[] array) {
        int num = 0;
        for (int value : array)
            num += value;
        return num;
    }
}