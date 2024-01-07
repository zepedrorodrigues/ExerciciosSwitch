package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex9Test {

    @Test
    void testeValidoOp1() {
        //Arrange
        int cd = 1;
        String exp = "Alimento não perecível";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testeValidoOp2() {
        //Arrange
        int cd = 3;
        String exp = "Alimento perecível";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testeValidoOp3() {
        //Arrange
        int cd = 5;
        String exp = "Vestuário";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testeValidoOp4() {
        //Arrange
        int cd = 7;
        String exp = "Higiene Pessoal";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }
    @Test
    void testeValidoOp5() {
        //Arrange
        int cd = 8;
        String exp = "Limpeza e Utensílios Domésticos";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testeValidoOpInvalida() {
        //Arrange
        int cd = -1;
        String exp = "Código Inválido";
        //Act
        String res = Ex9.descricaoDeProdutos(cd);
        //Assert
        assertEquals(exp, res);
    }
}