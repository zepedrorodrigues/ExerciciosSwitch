package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex21Test {
    @Test
    void matrizMascaraValida() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char letra = 'A';
        //Act
        int[][] matrizMascara = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaraVazia() {
        //Arrange
        char[][] sopa = {{}};
        char letra = 'A';
        //Act
        int[][] matrizMascara = {{}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaraNaoQuadrada() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        char letra = 'A';
        //Act
        int[][] matrizMascara = {{1, 0, 0}, {0, 0, 0}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaratodasLetrasIguais() {
        //Arrange
        char[][] sopa = {{'A', 'A', 'A'}, {'A', 'A', 'A'}, {'A', 'A', 'A'}};
        char letra = 'A';
        //Act
        int[][] matrizMascara = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaraLetraInexistente() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char letra = 'J';
        //Act
        int[][] matrizMascara = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaraLetraMinuscula() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char letra = 'a';
        //Act
        int[][] matrizMascara = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void matrizMascaraLetraMinusculaInexistente() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        char letra = 'j';
        //Act
        int[][] matrizMascara = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        //Assert
        assertArrayEquals(matrizMascara, Ex21.matrizMascara(sopa, letra));
    }

    @Test
    void verificarseQuadradoCharacterValido() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertTrue(resultado);
    }

    @Test
    void verificarseQuadradoMatrizVazia() {
        //Arrange
        char[][] arraydeArrays = {};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarseQuadradoMatrizNaoQuadrada() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarseQuadradoMatrizRetangular2x3() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarseQuadradoMatrizRetangular3x2() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B'}, {'D', 'E'}, {'G', 'H'}};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarseQuadradoUmaLinhaDiferente() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B', 'C', 'L'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        //Act
        boolean resultado = Ex21.verificarSeQuadradoCharacters(arraydeArrays);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarSeLinhaseColunasDeUmaMatrizCharValido() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B', 'C'}, {'D', 'E', 'F'}, {'G', 'H', 'I'}};
        //Act
        int resultado = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(arraydeArrays);
        //Assert
        assertEquals(3, resultado);
    }

    @Test
    void verificarSeLinhaseColunasDeUmaMatrizCharVazio() {
        //Arrange
        char[][] arraydeArrays = {};
        //Act
        int resultado = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(arraydeArrays);
        //Assert
        assertEquals(-1, resultado);
    }

    @Test
    void verificarSeLinhaseColunasDeUmaMatrizCharInvalido() {
        //Arrange
        char[][] arraydeArrays = {{'A', 'B'}, {'D', 'E', 'F'}};
        //Act
        int resultado = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(arraydeArrays);
        //Assert
        assertEquals(-1, resultado);
    }

    @Test
    void palavraemArrayValido() {
        //Arrange
        String palavra = "ABCD";
        //Act
        char[] resultado = Ex21.palavraParaArray(palavra);
        //Assert
        char[] esperado = {'A', 'B', 'C', 'D'};
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void palavraemArrayPalavraAusente() {
        //Arrange
        String palavra = "";
        //Act
        char[] resultado = Ex21.palavraParaArray(palavra);
        //Assert
        char[] esperado = {};
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void palavraemArrayPalavraEspacos() {
        //Arrange
        String palavra = "   ";
        //Act
        char[] resultado = Ex21.palavraParaArray(palavra);
        //Assert
        char[] esperado = {};
        assertArrayEquals(esperado, resultado);
    }

    @Test
    void verificarPalavraValida() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        String palavra = "ABCD";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertTrue(resultado);
    }

    @Test
    void verificarPalavraValidaVertical() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'B', 'F'}, {'G', 'B', 'I'}};
        String palavra = "BBB";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertTrue(resultado);
    }

    @Test
    void verificarPalavraValidaDiagonal() {
        //Arrange
        char[][] sopa = {{'B', 'A', 'C'}, {'D', 'B', 'F'}, {'G', 'H', 'B'}};
        String palavra = "BBB";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertTrue(resultado);
    }

    @Test
    void verificarPalavraValidaDiagonalSecundaria() {
        //Arrange
        char[][] sopa = {{'B', 'A', 'B'}, {'D', 'B', 'F'}, {'B', 'H', 'C'}};
        String palavra = "BBB";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertTrue(resultado);
    }

    @Test
    void verificarPalavraInvalida() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        String palavra = "ABCE";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarPalavraSopaVazia() {
        //Arrange
        char[][] sopa = {{}};
        String palavra = "ABCD";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertFalse(resultado);
    }

    @Test
    void verificarPalavraSopaNaoQuadrada() {
        //Arrange
        char[][] sopa = {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
        String palavra = "ABCD";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertFalse(resultado);
    }
    @Test
    void verificarPalavraSopaLetrasTodasPresentesMasDeslocadas(){
        //Arrange
        char[][] sopa = {{'B', 'D', 'C'}, {'A', 'E', 'F'}, {'G', 'H', 'I'}};
        String palavra = "CBA";
        //Act
        boolean resultado = Ex21.verificarPalavra(sopa, palavra);
        //Assert
        assertFalse(resultado);
    }
    @Test
    void verificadorValido(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'A','B','C','D'};
        int[] posicaoInicial = {0,0};
        int[] direccao = {0,1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificadorValidoVertical(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'A','D','G','K'};
        int[] posicaoInicial = {0,0};
        int[] direccao = {1,0};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificadorValidoDiagonal(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'A','E','I','N'};
        int[] posicaoInicial = {0,0};
        int[] direccao = {1,1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificadorDireccaoInvalido(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'A','B','C','D'};
        int[] posicaoInicial = {0,0};
        int[] direccao = {1,0};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificadorPosicaoInicialInvalida(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'A','B','C','D'};
        int[] posicaoInicial = {0,1};
        int[] direccao = {0,1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificadorInvalidoSaiForadaCaixa(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'B','A','B'};
        int[] posicaoInicial = {0,1};
        int[] direccao = {0,-1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificadorValidoMasAcabaemZero(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'B', 'D'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'B','B','A'};
        int[] posicaoInicial = {0,1};
        int[] direccao = {0,-1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificadorInvalidoSaiForadaCaixaTurnsAround(){
        //Arrange
        char[][] sopa = {{'A', 'B', 'C', 'B'}, {'D', 'E', 'F', 'G'}, {'G', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'B','A','B'};
        int[] posicaoInicial = {0,1};
        int[] direccao = {0,-1};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificadorValidoBatenoZero(){
        //Arrange
        char[][] sopa = {{'B', 'D', 'C', 'G'}, {'A', 'E', 'F', 'G'}, {'B', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        char[] palavra = {'B','A','B'};
        int[] posicaoInicial = {3,0};
        int[] direccao = {-1,0};
        //Act
        boolean resultado = Ex21.verificador(sopa,palavra,posicaoInicial,direccao);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarCruzamentosValidoLinha0Colunao(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'G'}, {'A', 'E', 'F', 'G'}, {'C', 'H', 'I', 'J'}, {'K', 'L', 'M', 'N'}};
        String palavra1 = "BAD";
        String palavra2 = "BAC";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificarCruzamentosValidoLinha4Coluna4(){
        //Arrange
        char[][] sopa = {{'B', 'F', 'D', 'G'}, {'A', 'E', 'F', 'C'}, {'C', 'H', 'I', 'A'}, {'K', 'D', 'A', 'B'}};
        String palavra1 = "BAD";
        String palavra2 = "BAC";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificarCruzamentosPalavra1Ausente(){
        //Arrange
        char[][] sopa = {{'B', 'E', 'D', 'B'}, {'G', 'G', 'G', 'A'}, {'G', 'G', 'G', 'C'}, {'G', 'G', 'G', 'B'}};
        String palavra1 = "BAD";
        String palavra2 = "BAC";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarCruzamentoPalavra2Ausente(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'C', 'B'}, {'G', 'G', 'G', 'A'}, {'G', 'G', 'G', 'C'}, {'G', 'G', 'G', 'B'}};
        String palavra1 = "BAC";
        String palavra2 = "BAD";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarCruzamentoPalavra1e2Ausente(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'G', 'B'}, {'G', 'G', 'G', 'A'}, {'G', 'G', 'G', 'C'}, {'G', 'G', 'G', 'B'}};
        String palavra1 = "BAD";
        String palavra2 = "BAC";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarCruzamentoPalavra1e2PresentesMasNaoCruzam(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'B'}, {'G', 'G', 'G', 'A'}, {'G', 'G', 'G', 'C'}, {'G', 'G', 'G', 'B'}};
        String palavra1 = "BAD";
        String palavra2 = "BAC";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarCruzamentopalavrasParalelasMasNaoIntersetam(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'C'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra1 = "BAD";
        String palavra2 = "GGG";
        //Act
        boolean resultado = Ex21.verificarCruzamentos(sopa,palavra1,palavra2);
        //Assert
        assertFalse(resultado);}
    @Test
    void posicoesPalavraValido(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'C'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        char[] palavra = {'B','A','D'};
        //Act
        int[][] resultado = Ex21.posicoesPalavra(sopa,palavra);
        //Assert
        int[][] esperado = {{0,0},{0,1},{0,2}};
        assertArrayEquals(esperado,resultado);}
    @Test
    void posicoesPalavraValidoincluilinha0coluna0(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'C'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        char[] palavra = {'D','A','B'};
        //Act
        int[][] resultado = Ex21.posicoesPalavra(sopa,palavra);
        //Assert
        int[][] esperado = {{0,2},{0,1},{0,0}};
        assertArrayEquals(esperado,resultado);}
    @Test
    void posicoesPalavraValidoincluilinha0coluna0VerticalAscendente(){
        //Arrange
        char[][] sopa = {{'B', 'G', 'G', 'G'}, {'A', 'G', 'G', 'G'}, {'D', 'G', 'G', 'G'}, {'T', 'T', 'T', 'T'}};
        char[] palavra = {'D','A','B'};
        //Act
        int[][] resultado = Ex21.posicoesPalavra(sopa,palavra);
        //Assert
        int[][] esperado = {{2,0},{1,0},{0,0}};
        assertArrayEquals(esperado,resultado);}

    @Test
    void verificarPalavraNumSegmentoValidoincluiLinha0Coluna0(){
        //Arrange
        char[][] sopa = {{'B', 'A', 'D', 'C'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra = "DAB";
        int[] posicaoInicial = {0,2};
        int[] posicaoFinal = {0,0};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificarPalavraNumSegmentoValidoIncluiLinha0Coluna3(){
        //Arrange
        char[][] sopa = {{'B', 'C', 'D', 'O'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra = "CDA";
        int[] posicaoInicial = {0,3};
        int[] posicaoFinal = {0,4};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarPalaveaNumSegmentoInvalido(){
        //Arrange
        char[][] sopa = {{'B', 'C', 'D', 'O'}, {'G', 'G', 'G', 'C'}, {'D', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra = "CDA";
        int[] posicaoInicial = {0,3};
        int[] posicaoFinal = {0,4};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarPalavraNumaDiagonalInvalida(){
        //Arrange
        char[][] sopa = {{'G', 'F', 'D', 'C'}, {'A', 'A', 'D', 'O'}, {'H', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra = "CDA";
        int[] posicaoInicial = {0,3};
        int[] posicaoFinal = {1,1};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarPalavraNumSegmentoSopaInvalida(){
        //Arrange
        char[][] sopa = {{'G', 'F', 'D'}, {'A', 'A', 'D', 'O'}, {'H', 'O', 'D', 'C'}, {'T', 'T', 'T', 'T'}};
        String palavra = "CDA";
        int[] posicaoInicial = {0,3};
        int[] posicaoFinal = {1,1};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarPalavraNumSegmentoSopaVazia(){
        //Arrange
        char[][] sopa = {{}};
        String palavra = "CDA";
        int[] posicaoInicial = {0,3};
        int[] posicaoFinal = {1,1};
        //Act
        boolean resultado = Ex21.verificarPalavraNumSegmento(sopa,palavra,posicaoInicial,posicaoFinal);
        //Assert
        assertFalse(resultado);}

    @Test
    void direccaoValidoHorizontalEsquerdaDireita(){
        //Arrange
        int[]pontoA = {0,0};
        int[]pontoB = {0,3};
        int[]expectedDireccao = {0,1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidoHorizontalDireitaEsquerda(){
        //Arrange
        int[]pontoA = {0,3};
        int[]pontoB = {0,0};
        int[]expectedDireccao = {0,-1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidoVerticalDescendente(){
        //Arrange
        int[]pontoA = {0,3};
        int[]pontoB = {3,3};
        int[]expectedDireccao = {1,0};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidaVerticalAscendente(){
        //Arrange
        int[]pontoA = {3,3};
        int[]pontoB = {0,3};
        int[]expectedDireccao = {-1,0};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidaDiagonalEsqDirDescentende(){
        //Arrange
        int[]pontoA = {0,0};
        int[]pontoB = {3,3};
        int[]expectedDireccao = {1,1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidaDiagonalDirEsqAscendente(){
        //Arrange
        int[]pontoA = {3,3};
        int[]pontoB = {0,0};
        int[]expectedDireccao = {-1,-1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);
    }
    @Test
    void direccaoValidaDiagonalSecundariaEsqDir(){
        //Arrange
        int[]pontoA = {3,0};
        int[]pontoB = {0,3};
        int[]expectedDireccao = {-1,1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidaDiagonalSecundiarADirEsq(){
        //Arrange
        int[]pontoA = {0,3};
        int[]pontoB = {3,0};
        int[]expectedDireccao = {1,-1};
        //Act
        int[]resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void direccaoValidaComecaeTerminanoMesmoLocal(){
        //Arrange
        int[] pontoA = {0,3};
        int[] pontoB = {0,3};
        int[] expectedDireccao = {0,0};
        //Act
        int[] resultado = Ex21.direccao(pontoA,pontoB);
        //Assert
        assertArrayEquals(expectedDireccao,resultado);}
    @Test
    void verificarValidadeDireccaoValido(){
        //Arrange
        int difX = 1;
        int difY = 1;
        //Act
        boolean resultado = Ex21.verificarValidade(difX,difY);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificarValidadeDireccaoNulo(){
        //Arrange
        int difX = 0;
        int difY = 0;
        //Act
        boolean resultado = Ex21.verificarValidade(difX,difY);
        //Assert
        assertFalse(resultado);}
    @Test
    void verificarValidadedifXNulodifYNaoNulo(){
        //Arrange
        int difX = 0;
        int difY = 1;
        //Act
        boolean resultado = Ex21.verificarValidade(difX,difY);
        //Assert
        assertTrue(resultado);}
    @Test
    void verificarValidadedifXdiferentededifY(){
        //Arrange
        int difX = 1;
        int difY = 0;
        //Act
        boolean resultado = Ex21.verificarValidade(difX,difY);
        //Assert
        assertTrue(resultado);}
    }