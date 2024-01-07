package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex12Test {
    @Test
    void numeroNaoCapicuaNegativo() {
        //Arrange
        int numero = -10;
        //Act
        boolean result = Ex12.verificarSeEUmaCapicua(numero);
        //assert
        assertFalse(result);
    }

    @Test
    void numeroCapicuaUmDigito() {
        //Arrange
        int numero = 9;
        //Act
        boolean result = Ex12.verificarSeEUmaCapicua(numero);
        //assert
        assertTrue(result);
    }

    @Test
    void numeroNaoCapicua() {
        //Arrange
        int numero = 13259;
        //Act
        boolean result = Ex12.verificarSeEUmaCapicua(numero);
        //assert
        assertFalse(result);
    }

    @Test
    void numeroCapicua() {
        //Arrange
        int numero = 140041;
        //Act
        boolean result = Ex12.verificarSeEUmaCapicua(numero);
        //assert
        assertTrue(result);
    }

    @Test
    void menorCapicuaPositivo() {
        //Arrange
        int numero = 0;
        //Act
        boolean result = Ex12.verificarSeEUmaCapicua(numero);
        //assert
        assertTrue(result);
    }
}