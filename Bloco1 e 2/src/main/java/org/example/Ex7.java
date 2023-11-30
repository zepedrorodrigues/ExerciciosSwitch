package org.example;

public class Ex7 {
    public static int multiplicacaoValoresdoArrayDevolveXSuperioraValor (int[] array, int Valor) {
        if(Valor < 0 || array.length == 0)
            return -1;
        for(int valor : array)
            if(valor < 0)
                return -1;
        int resultado = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < Valor) {
                resultado *= array[i];}}
        return resultado;}
}