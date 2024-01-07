package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex12Test {

    @Test
    void salarioFinal0Invalido() {
        int salariobruto = 0;
        double expected = -1, result = Ex12.salarioFinal(salariobruto);
        assertEquals(expected,result);
    }
    @Test
    void salarioFinal100(){
        int salarioBruto =100;
        double expected = 90, result = Ex12.salarioFinal(salarioBruto);
        assertEquals(expected,result);
    }
    @Test
    void salarioFinal500Fronteira(){
        int salarioBruto = 500;
        double exp = 450, res = Ex12.salarioFinal(salarioBruto);
        assertEquals(exp,res);}
    @Test
    void salarioFinal750Brutos(){
        int salarioBruto = 750;
        double exp = 637.5, res = Ex12.salarioFinal(salarioBruto);
        assertEquals(exp,res);
    }
    @Test
    void salarioFinal1000BrutosFronteira(){
        int salario = 1000;
        double exp = 850, res = Ex12.salarioFinal(salario);
        assertEquals(exp,res);
    }
    @Test
    void salarioFinal1000NegativosInválido(){
        int salario = -1000;
        double exp = -1, res = Ex12.salarioFinal(salario);
        assertEquals(exp,res);
    }
    @Test
    void salarioFinal2000(){
        int salario = 2000;
        double exp = 1600, res = Ex12.salarioFinal(salario);
        assertEquals(exp,res);
    }
}