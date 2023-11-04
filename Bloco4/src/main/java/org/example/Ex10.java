package org.example;

public class Ex10 {
    public static int[] devolverMultiplosDeUmNumeroNmIntervalo(int min, int max, int num) {
        int[] multiplos = new int[0];
        if (num == 0) {
            return multiplos;
        }
        int index = 0;
        for (int i = min; i <= max; i++) {
            if (i % num == 0) {
                multiplos = Ex4.estenderArray(multiplos);
                multiplos[index++] = i;
            }
        }
        return multiplos;
    }
}
