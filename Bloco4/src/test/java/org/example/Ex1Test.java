package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {
    @Test
    void devolverNumeroDeAlgarismosPositivo() {
        //Arrange
        int num = 789;
        int exp = 3;
        //Act
        int res = Ex1.devolverNumeroDeAlgarismos(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverNumeroDeAlgarismosNegativo() {
        //Arrange
        int num = -789;
        int exp = -1;
        //Act
        int res = Ex1.devolverNumeroDeAlgarismos(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverNumeroDeAlgarismosZero() {
        //Arrange
        int num = 0;
        int exp = -1;
        //Act
        int res = Ex1.devolverNumeroDeAlgarismos(num);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void devolverNumeroDeAlgarismoUnico() {
        //Arrange
        int num = 1;
        int exp = 1;
        //Act
        int res = Ex1.devolverNumeroDeAlgarismos(num);
        //Assert
        assertEquals(exp, res);
    }
}
