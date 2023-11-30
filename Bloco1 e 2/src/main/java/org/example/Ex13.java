package org.example;

public class Ex13 {
    public static int classePesoCão(int peso){
        if(peso<=0)
            return -1;
        if(peso<=10)
            return 100;
        if(peso<=25)
            return 250;
        if(peso<=45)
            return 300;
        return 500;}
    public static int comidaQtdComparativa(int peso, int racao){
        int qtdcertaracao = classePesoCão(peso);
        if(racao>qtdcertaracao)
            return 1;
        if(racao==qtdcertaracao)
            return 0;
        return -1;}
    public static int[] comidaQtdComparativaArray(int[]arraypesos, int[] racao){
        int[] new_array = new int [0];
        for(int i =0; i< arraypesos.length;i++){
            if(arraypesos[i]<0)
                return new_array;
            new_array= new int[new_array.length+1];
            new_array[i] = comidaQtdComparativa(arraypesos[i],racao[i]);}
        return new_array;}
}
