package org.example;

public class Ex6 {
    public static double salárioCOMHorasExtra(int salárioBase, int horasExtra){
        if(horasExtra<0||salárioBase<=0)
            return -1;
        return salárioBase+(horasExtra*(0.02*salárioBase));}
}
