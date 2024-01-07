package org.example;

public class Ex8 {
    public static int[] devolveNumerosIguaisouInferioresaY(int Y) {
        int[] numerosIguaisouInferioresaY = new int[0];
        int index = 0;
        for (int i = 0; i <= Y; i++) {
            numerosIguaisouInferioresaY = Ex2.estenderArray1lugar(numerosIguaisouInferioresaY);
            numerosIguaisouInferioresaY[index] = i;
            index++;
        }
        return numerosIguaisouInferioresaY;
    }

    public static int somaNumerosquedeemY(int[] NumerosInferioresouIguaisaX, int Y) {
        int n = 0;
        for (int value : NumerosInferioresouIguaisaX) {
            for (int value2 : NumerosInferioresouIguaisaX) {
                if (value != value2 && value < value2 && value + value2 == Y)
                    n++;
            }
        }
        return n;
    }

    public static int exercicio8(int Y) {
        if (Y < 0 || Y > 20)
            return -1;
        int[] numerosASomar = devolveNumerosIguaisouInferioresaY(10);
        if (Y < 10) {
            numerosASomar = devolveNumerosIguaisouInferioresaY(Y);
        }
        return somaNumerosquedeemY(numerosASomar, Y);


    }
}
