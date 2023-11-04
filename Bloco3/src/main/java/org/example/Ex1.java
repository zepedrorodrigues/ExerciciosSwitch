package org.example;

public class Ex1 {
    static public long numeroFatorial(int numero) {
        if (numero < 0 || numero > 20)
            return -1;
        if (numero == 0)
            return 1;
        long resultado = 1;
        for (int i = numero; i > 1; i--)
            resultado = resultado * i;
        return resultado;
    }
}
