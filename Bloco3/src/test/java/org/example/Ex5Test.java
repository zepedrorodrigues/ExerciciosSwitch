package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex5Test {
    @Test
    void ex5NumeroNegativo() {
        //Arrange
        long numero = -1;
        boolean expected = false;
        //Act
        boolean result = Ex5.verificarSeEUmaCapicua(numero);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5NumeroLongNaoCapicua() {
        //Arrange
        long numero = 4455;
        boolean expected = false;
        //Act
        boolean result = Ex5.verificarSeEUmaCapicua(numero);
        //assert
        assertEquals(expected, result);

    }

    @Test
    void ex5NumeroLongCapicua() {
        //Arrange
        long numero = 4480844;
        boolean expected = true;
        //Act
        boolean result = Ex5.verificarSeEUmaCapicua(numero);
        //assert
        assertEquals(expected, result);

    }

    @Test
    void ex5NumeroFronteiraCapicua() {
        //Arrange
        long numero = 0;
        boolean expected = true;
        //Act
        boolean result = Ex5.verificarSeEUmaCapicua(numero);
        //assert
        assertEquals(expected, result);

    }

    @Test
    void ex5NumeroArmstrong() {
        //Arrange
        int numero = 153;
        boolean expected = true;
        //Act
        boolean result = Ex5.numeroArmstrong(numero);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5NaoEArmstrong() {
        //Arrange
        int numero = 1543;
        boolean expected = false;
        //Act
        boolean result = Ex5.numeroArmstrong(numero);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5ArmstronNegativo() {
        //Arrange
        int numero = -153;
        boolean expected = false;
        //Act
        boolean result = Ex5.numeroArmstrong(numero);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5ArmstronUmAlgarismo() {
        //Arrange
        int numero = 5;
        boolean expected = true;
        //Act
        boolean result = Ex5.numeroArmstrong(numero);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5PrimeiraCapicuaNumIntervaloNaoEPossivel() {
        //Arrange
        int numeroMinimo = -1;
        int numeroMaximo = 20;
        int expected = -1;
        //Act
        int result = Ex5.primeiraCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5PrimeiraCapicuaNumIntervaloDeFronteira() {
        //Arrange
        int numeroMinimo = 0;
        int numeroMaximo = 20;
        int expected = 0;
        //Act
        int result = Ex5.primeiraCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5PrimeiraCapicuaNumIntervaloGrande() {
        //Arrange
        int numeroMinimo = 10;
        int numeroMaximo = 1000;
        int expected = 11;
        //Act
        int result = Ex5.primeiraCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5PrimeiraCapicuaNumIntervaloDeMinimoMaiorQueOMaximo() {
        //Arrange
        int numeroMinimo = 20;
        int numeroMaximo = 10;
        int expected = -1;
        //Act
        int result = Ex5.primeiraCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5MaiorCapicuaNumIntervaloImpossivel() {
        //Arrange
        int numeroMinimo = -1;
        int numeroMaximo = 10;
        int expected = -1;
        //Act
        int result = Ex5.aMaiorCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5MaiorCapicuaNumIntervaloDeFronteira() {
        //Arrange
        int numeroMinimo = 0;
        int numeroMaximo = 10;
        int expected = 9;
        //Act
        int result = Ex5.aMaiorCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5MaiorCapicuaNumIntervaloGrande() {
        //Arrange
        int numeroMinimo = 10;
        int numeroMaximo = 100;
        int expected = 99;
        //Act
        int result = Ex5.aMaiorCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5MaiorCapicuaNumIntervaloMaximoMenorQueOMinimo() {
        //Arrange
        int numeroMinimo = 50;
        int numeroMaximo = 10;
        int expected = -1;
        //Act
        int result = Ex5.aMaiorCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5NumeroDeCapicuaNumIntervaloImpossivel() {
        //Arrange
        int numeroMinimo = -50;
        int numeroMaximo = 10;
        int expected = -1;
        //Act
        int result = Ex5.oNumeroDeCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5NumeroDeCapicuaNumIntervaloDeFronteira() {
        //Arrange
        int numeroMinimo = 0;
        int numeroMaximo = 10;
        int expected = 10;
        //Act
        int result = Ex5.oNumeroDeCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5NumeroDeCapicuaNumIntervaloGrande() {
        //Arrange
        int numeroMinimo = 0;
        int numeroMaximo = 20;
        int expected = 11;
        //Act
        int result = Ex5.oNumeroDeCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5NumeroDeCapicuaNumIntervaloMaximoMenorQueOMinimo() {
        //Arrange
        int numeroMinimo = 5;
        int numeroMaximo = 2;
        int expected = -1;
        //Act
        int result = Ex5.oNumeroDeCapicuaNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void ex5PrimeiroNumeroArmstrongNumIntervaloInvalido() {
        //Arrange
        int numeroMaximo = 10;
        int numeroMinimo = -10;
        int expected = -1;
        //Act
        int result = Ex5.primeiroNumeroArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5PrimeiroNumeroArmstrongNumIntervaloDeFronteira() {
        //Arrange
        int numeroMaximo = 10;
        int numeroMinimo = 0;
        int expected = 0;
        //Act
        int result = Ex5.primeiroNumeroArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5PrimeiroNumeroArmstrongNumIntervaloGrande() {
        //Arrange
        int numeroMaximo = 2000;
        int numeroMinimo = 100;
        int expected = 153;
        //Act
        int result = Ex5.primeiroNumeroArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5PrimeiroNumeroArmstrongNumIntervaloMaximoMaiorQueOMinimo() {
        //Arrange
        int numeroMaximo = 20;
        int numeroMinimo = 1000;
        int expected = -1;
        //Act
        int result = Ex5.primeiroNumeroArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5oNumeroDeNumerosArmstrongNumIntervaloInvalido() {
        //Arrange
        int numeroMaximo = 20;
        int numeroMinimo = -1;
        int expected = -1;
        //Act
        int result = Ex5.oNumeroDeNumerosArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5oNumeroDeNumerosArmstrongNumIntervaloFronteira() {
        //Arrange
        int numeroMaximo = 20;
        int numeroMinimo = 0;
        int expected = 10;
        //Act
        int result = Ex5.oNumeroDeNumerosArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

    @Test
    void ex5oNumeroDeNumerosArmstrongNumIntervaloGrande() {
        //Arrange
        int numeroMaximo = 200;
        int numeroMinimo = 15;
        int expected = 1;
        //Act
        int result = Ex5.oNumeroDeNumerosArmstrongNumIntervalo(numeroMinimo, numeroMaximo);
        //assert
        assertEquals(expected, result);
    }

}