package org.example;

public class Ex16 {
    public static int numeroemArray(int numero){
        if(numero<=0)
            return 2;
        int n = 0;
        for(int i=1; i<numero; i++){
            if(numero%i==0)
                n+=i;}
        if (n == numero)
            return 0;
        if (n >numero)
            return 1;
        return -1;}}
