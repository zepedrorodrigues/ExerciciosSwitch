package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex6Test {
    @Test
    void salárioCOMHorasExtra() {
        int salário = 600, horasXTRA = 5;
        double exp = 660, res = Ex6.salárioCOMHorasExtra(salário,horasXTRA);
        assertEquals(exp,res,0.01);
    }
    @Test
    void salárioCOMHorasExtraInválido(){
        int sal = 500, horas = -1;
        double exp = -1, res = Ex6.salárioCOMHorasExtra(sal,horas);
        assertEquals(exp,res);
    }
    @Test
    void saláriosemHorasExtra(){
        int salário = 800, horas = 0;
        double exp = 800, res = Ex6.salárioCOMHorasExtra(salário,horas);
        assertEquals(exp,res);
    }
}