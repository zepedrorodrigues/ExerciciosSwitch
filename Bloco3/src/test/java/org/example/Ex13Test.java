package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex13Test {
    @Test
    void verificarRacaoAdequadaRacaPequena() {
        int peso = 5;
        int expected = 100;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void verificarRacaoAdequadaRacaMedia() {
        int peso = 20;
        int expected = 250;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void verificarRacaoAdequadaRacaGrande() {
        int peso = 30;
        int expected = 300;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void verificarRacaoAdequadaRacaGigante() {
        int peso = 50;
        int expected = 500;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void verificarRacaoAdequadaZero() {
        int peso = 0;
        int expected = -1;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void verificarRacaoAdequadaNegativo() {
        int peso = -5;
        int expected = -1;
        int res = Ex13.verificarRacaoAdequada(peso);
        assertEquals(expected, res);}
    @Test
    void compararRacaoAcimaDoEsperado() {
        double peso = 23.5;
        double racao = 350;
        int expected = 1;
        int res = Ex13.compararRacao(peso, racao);
        assertEquals(expected, res);}
    @Test
    void compararRacaoAbaixoDoEsperado() {
        double peso = 5;
        double racao = 50;
        int expected = -1;
        int res = Ex13.compararRacao(peso, racao);
        assertEquals(expected, res);}
    @Test
    void compararRacaoIgualAoEsperado() {
        double peso = 40;
        double racao = 300;
        int expected = 0;
        int res = Ex13.compararRacao(peso, racao);
        assertEquals(expected, res);}

    @Test
    void compararRacaoPesoNegativo(){
        double peso = -4, racao = 300;
        int expected = 2, res = Ex13.compararRacao(peso,racao);
        assertEquals(expected,res);
    }
    @Test
    void compararRacaoDados() {
        double[] pesoAnimal = {5, 20, 40, 50};
        double[] pesoRacao = {50, 250, 350, 500};
        int[] expected = {-1, 0, 1, 0};
        int[] res = Ex13.compararRacaoDadosVariaveis(pesoAnimal, pesoRacao);
        assertArrayEquals(expected, res);}
    @Test
    void compararRacaoNumeroNegativo() {
        double[] pesoAnimal = {5, 20, -40, 50};
        double[] pesoRacao = {50, 250, 350, 500};
        int[] expected = {-1, 0};
        int[] res = Ex13.compararRacaoDadosVariaveis(pesoAnimal, pesoRacao);
        assertArrayEquals(expected, res);}
}