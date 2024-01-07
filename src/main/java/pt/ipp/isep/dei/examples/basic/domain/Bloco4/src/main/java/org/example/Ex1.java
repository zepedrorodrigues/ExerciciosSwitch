package org.example;

public class Ex1 {
    public static int devolverNumeroDeAlgarismos(int num) {
        if (num <= 0)
            return -1;
        int index = 0;
        while (num != 0) {
            num = num / 10;
            index++;
        }
        return index;
    }
}
