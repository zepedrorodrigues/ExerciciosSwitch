package org.example;

public class Ex5 {
    //a)
    public static boolean verificarSeEUmaCapicua(long numero) {
        if (numero < 0) {
            return false;
        }
        long original = numero;
        long reverso = 0;

        while (numero != 0) {
            reverso = reverso * 10 + numero % 10;
            numero = numero / 10;
        }
        return original == reverso;
    }

    //b)
    public static int quantosAlgarismosTemUmNumero(int numero) {
        int contador = 0;
        while (numero != 0) {
            numero = numero / 10;
            contador++;
        }
        return contador;
    }

    public static boolean numeroArmstrong(int numero) {
        if (numero < 0) {
            return false;
        }
        int numeroOriginal = numero;
        int soma = 0;
        int numeroDeAlgarismos = quantosAlgarismosTemUmNumero(numero);

        while (numero != 0) {
            soma = (int) (soma + Math.pow(numero % 10, numeroDeAlgarismos));
            numero = numero / 10;
        }
        return soma == numeroOriginal;
    }

    //c)
    public static int primeiraCapicuaNumIntervalo(int min, int max) {
        if (min >= 0 && min <= max) {
            while (min <= max) {
                if (verificarSeEUmaCapicua(min)) {
                    return min;
                }
                min++;
            }
        }
        return -1;
    }

    //d)
    public static int aMaiorCapicuaNumIntervalo(int min, int max) {
        if (min >= 0 && min <= max) {
            while (min <= max) {
                if (verificarSeEUmaCapicua(max)) {
                    return max;
                }
                max--;
            }
        }
        return -1;
    }

    //e)
    public static int oNumeroDeCapicuaNumIntervalo(int min, int max) {
        if (min < 0 || min > max) {
            return -1;
        }
        int contador = 0;
        while (min <= max) {
            if (verificarSeEUmaCapicua(min)) {
                contador++;
            }
            min++;
        }
        return contador;
    }

    //f)
    public static int primeiroNumeroArmstrongNumIntervalo(int min, int max) {
        if (min >= 0 && min <= max)
            while (min <= max) {
                if (numeroArmstrong(min)) {
                    return min;
                }
                min++;
            }
        return -1;
    }

    //g)
    public static int oNumeroDeNumerosArmstrongNumIntervalo(int min, int max) {
        if (min < 0 || min > max) {
            return -1;
        }
        int contador = 0;
        while (min <= max) {
            if (numeroArmstrong(min)) {
                contador++;
            }
            min++;
        }
        return contador;
    }
}
