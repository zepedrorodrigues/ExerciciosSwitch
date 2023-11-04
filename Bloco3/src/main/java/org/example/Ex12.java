package org.example;

public class Ex12 {
    public static double salarioFinal(int salarioBruto) {
        if (salarioBruto <= 0)
            return -1;
        if (salarioBruto <= 500)
            return salarioBruto * 0.9;
        if (salarioBruto <= 1000)
            return salarioBruto * 0.85;
        return salarioBruto * 0.8;
    }
}
