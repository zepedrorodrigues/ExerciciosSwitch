package org.example;

public class Ex6 {

    public static double salarioMensalEmpregado(int nrHorasExtraOrdinarias, double salarioBaseFuncionario) {
        if (salarioBaseFuncionario <= 0 || nrHorasExtraOrdinarias < 0) { //O salário base e o nr de horas extra não podem ser negativos.
            return -1;
        }
        return (((salarioBaseFuncionario + nrHorasExtraOrdinarias * (salarioBaseFuncionario * 0.02)) * 100) / 100.00);
    }
}
