package org.example;

public class Exercicio4 {
    public static int NumerodeValoresArray(int[] array) {
        return array.length;}
    public static int[] DividirAlgarismosNumero(int num) {
        int[] algarismos = new int[1];
        while (num != 0) {
            algarismos = EstenderArray1lugarAdiante(algarismos);
            algarismos[0] = num % 10;
            num = num / 10;
        }
        return algarismos;
    }
    public static int[] EstenderArray1Algarismo(int[] array) {
        int[] new_array = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[i];
        }
        return new_array;
    }
    public static int[] EstenderArray1lugarAdiante(int[] array) {
        int[] new_array = new int[array.length + 1];
        for (int y = 0; y < array.length; y++)
            new_array[y + 1] = array[y];
        return new_array;
    }
    public static int Exercicio4a(int num) {
        int[] array = DividirAlgarismosNumero(num);
        return NumerodeValoresArray(array);}
    public static int[] MultiplosOuNaodeX(int x, int[] array, boolean opcao) {
        int[] final_array = new int[0];
        int index = 0;
        if (opcao == true) {
            for (int value : array) {
                if (value % x == 0) {
                    final_array = EstenderArray1Algarismo(final_array);
                    final_array[index] = value;
                    index += 1;}}}
        if (opcao == false) {
            for (int value : array) {
                if (value % x != 0) {
                    final_array = EstenderArray1Algarismo(final_array);
                    final_array[index] = value;
                    index += 1;}}}
        return final_array;}
    public static int Exercicio4b(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] pares = MultiplosOuNaodeX(2,alg,true);
        return pares.length;
    }
    public static int Exercicio4c(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] impares = MultiplosOuNaodeX(2,alg,false);
        return impares.length;
    }
    public static int SomarNumerosArray(int[] array){
        int n = 0;
        for(int value:array)
            n+=value;
        return n;
    }
    public static int Exercicio4d(int num){
        int[] alg  = DividirAlgarismosNumero(num);
        return SomarNumerosArray(alg);
    }
    public static int Exercicio4e(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] pares = MultiplosOuNaodeX(2,alg,true);
        return SomarNumerosArray(pares);
    }
    public static int Exercicio4f(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] ímpares = MultiplosOuNaodeX(2,alg,false);
        return SomarNumerosArray(ímpares);
    }
    public static int MédiaArray(int[] array){
        int n = 0;
        for(int value:array)
            n+=value;
        return n/(array.length);}
    public static int Exercicio4g(int num){
        int[] alg = DividirAlgarismosNumero(num);
        return MédiaArray(alg);
    }
    public static int Exercicio4h(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] pares = MultiplosOuNaodeX(2,alg,true);
        return MédiaArray(pares);}
    public static int Exercicio4i(int num){
        int[] alg = DividirAlgarismosNumero(num);
        int[] impares = MultiplosOuNaodeX(2,alg,false);
        return MédiaArray(impares);
    }

}