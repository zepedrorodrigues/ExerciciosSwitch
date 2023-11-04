package org.example;

public class Ex12 {
    public static boolean verificarSeEUmaCapicua(int numero) {
        if (numero < 0) {
            return false;
        }
        int original = numero;
        int reverso = 0;

        while (numero != 0) {
            reverso = reverso * 10 + numero % 10;
            numero = numero / 10;
        }
        return original == reverso;
    }
}
