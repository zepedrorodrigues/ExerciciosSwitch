package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex6Test {

    //salario base 900 | preço horaextra = 18 | 20horas extra
    @Test
    void salarioMensalHorasExtraPositivas() {
        int nHorasExtraordinarios = 20;
        double expected = 1260, salarioBase = 900;
        double returned = Ex6.salarioMensalEmpregado(nHorasExtraordinarios, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

    //salario 921.07 para testar o arredondamento + meia hora
    @Test
    void salarioMensalHorasExtraUmaHora() {
        int nrHorasExtra = 1;
        double salarioBase = 921.07, expected = 939.491;
        double returned = Ex6.salarioMensalEmpregado(nrHorasExtra, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

    @Test
    void salarioMensalHorasExtraNeg() {
        int nHorasExtra = -20;
        double salarioBase = 900;
        double expected = -1;
        double returned = Ex6.salarioMensalEmpregado(nHorasExtra, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

    @Test
    void salarioMensalHorasExtraZero() {
        int nrHorasExtra = 0;
        double salarioBase = 900;
        double expected = 900;
        double returned = Ex6.salarioMensalEmpregado(nrHorasExtra, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

    @Test
    void salarioBaseNeg() {
        int nrHorasExtra = 1;
        double salarioBase = -200;
        double expected = -1;
        double returned = Ex6.salarioMensalEmpregado(nrHorasExtra, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

    @Test
    void salarioBaseZero() {
        int nrHorasExtra = 1;
        double salarioBase = 0;
        double expected = -1;
        double returned = Ex6.salarioMensalEmpregado(nrHorasExtra, salarioBase);
        assertEquals(expected, returned, 0.01);
    }

}