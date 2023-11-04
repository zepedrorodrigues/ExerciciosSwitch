package org.example;

public class Ex15 {
    public static int verificarSeLinhasTemMesmoNumeroDeColunas(int[][] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != array[0].length)
                return -1;
        }
        return array[0].length;
    }
}
