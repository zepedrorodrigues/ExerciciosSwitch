package org.example;

public class Ex16 {
    public static int classificacaoNumeros(int numero) {
        if (numero <= 0)
            return 2; // invalido
        int somaDivisores = 0;
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0)
                somaDivisores += i;
        }
        if (somaDivisores == numero)
            return 0;
        if (somaDivisores > numero)
            return 1;
        return -1;
    }
}
