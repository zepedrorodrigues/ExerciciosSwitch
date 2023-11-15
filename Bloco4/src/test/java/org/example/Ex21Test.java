package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex21Test {
    @Test
    void sopadeLetrasTesteValidadeVazio() {
        char[][] x = {};
        boolean exp = false;
        boolean res = Ex21.sopadeLetrasTesteValidade(x);
        assertEquals(exp,res);}

    @Test
    void verificarSequadradoCharactersQuadrado1x1(){
        char[][] sopa = {{1}};
        boolean exp = true;
        boolean res = Ex21.verificarSeQuadradoCharacters(sopa);
        assertEquals(exp,res);}
    @Test
    void verificarSeQuadradoCharactersRetangulo3x4(){
        char[][] sopa = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};
        boolean exp = false;
        boolean res = Ex21.verificarSeQuadradoCharacters(sopa);
        assertEquals(exp,res);}
    @Test
    void verificarSeQuadradoCharactersArrayVazio(){
        char[][] sopa = {};
        boolean exp = false;
        boolean res = Ex21.verificarSeQuadradoCharacters(sopa);
        assertEquals(exp,res);}
    @Test
    void verificarSeLinhasEColunasDeUmaMatrizLinhasTamanhoDiferente(){
        char[][] sopa = {{1,2,3},{1,2,3,4},{1,2,3}};
        int exp = -1;
        int res = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(sopa);
        assertEquals(exp,res);}
    @Test
    void verificarSeLinhaseColunasDeumaMatrizLinhasTamanhoIgual(){
        char[][] sopa = {{1,2,3},{1,2,3},{1,2,3}};
        int exp = 3;
        int res = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(sopa);
        assertEquals(exp,res);}
    @Test
    void verificarSeLinhaseColunasdeUmaMatrizLinhasZero(){
        char[][] sopa = {{}};
        int exp = 0;
        int res = Ex21.verificarSeLinhasEColunasDeUmaMatrizChar(sopa);
        assertEquals(exp,res);}
    @Test
    void sopadeLetrasTesteValidadeNaoQuadrado(){
        char[][] sopa = {{1,2},{1,2},{1,2}};
        boolean exp = false;
        boolean res = Ex21.sopadeLetrasTesteValidade(sopa);
        assertEquals(exp,res);}
    @Test
    void sopadeLetrasNaoQuadradaVazia(){
        char[][] sopa = {};
        boolean exp = false;
        boolean res = Ex21.sopadeLetrasTesteValidade(sopa);
        assertEquals(exp,res);}
    @Test
    void sopadeLetrasLinhasAssimétricas(){
        char[][] sopa = {{1,2,3},{1,2},{1,2,3}};
        boolean exp = false;
        boolean res = Ex21.verificarSeQuadradoCharacters(sopa);
        assertEquals(exp,res);}
    @Test
    void sopadeLetrasTesteValidadeNormal(){
        char[][] x = {{1,2,3},{1,2,3},{1,2,3}};
        boolean exp = true;
        boolean res = Ex21.sopadeLetrasTesteValidade(x);
        assertEquals(exp,res);}
    @Test
    void matrizMascara() {
        char a = 'A';
        char[][] sopa = {{'A','B','D'},{'C','A','J'},{'G','H','A'}};
        int[][] exp = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] res = Ex21.matrizMascara(sopa,a);
        assertArrayEquals(exp,res);}
    @Test
    void matrizMascaraSemValores(){
        char a = 'A';
        char[][]x = {{1,1,1},{1,1,1},{2,2,2}};
        int[][] exp = {{0,0,0},{0,0,0},{0,0,0}};
        int[][]res = Ex21.matrizMascara(x,a);
        assertArrayEquals(exp,res);}
    @Test
    void encontrarPalavraVazio(){
        char[][] x = {};
        String pal = "CORNETO";
        boolean exp = false;
        boolean res = Ex21.verificarDireccao(x,pal);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraHorizontalEsqDir() {
        char [][] x = {{'B','O','L','A'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraHorizontalDirEsq() {
        char [][] x = {{'A','L','O','B'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraInexistente(){
        char [][] x = {{'A','L','A','B'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        boolean exp = false;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraVerticalCimaBaixo(){
        char [][] x = {{'B','A','A','A'},{'O','A','A','A'},{'L','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraVerticalBaixoCima(){
        char [][] x = {{'A','A','A','A'},{'A','A','A','L'},{'A','A','A','O'},{'A','A','A','B'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalSecundariaBaixoCima(){
        char [][] x = {{'A','A','A','A'},{'A','A','L','A'},{'A','O','A','A'},{'B','A','A','A'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalSecundariaCimaBaixo(){
        char [][] x = {{'A','A','A','B'},{'A','A','O','A'},{'A','L','A','O'},{'A','A','A','A'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalSecundariaBaixoCima2(){
        char [][] x = {{'A','A','A','A'},{'A','A','A','B'},{'A','A','O','A'},{'A','L','A','A'}};
        String bola = "BOL";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalPrincipalCimaBaixo(){
        char [][] x = {{'A','B','A','A'},{'A','A','O','A'},{'A','A','A','L'},{'A','A','A','A'}};
        String bola = "BOL";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalPrincipalBaixoCima(){
        char [][] x = {{'A','A','A','A'},{'A','L','A','A'},{'A','A','O','A'},{'A','A','A','B'}};
        String bola = "BOLA";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraDiagonalPrincipalCimaBaixo2(){
        char [][] x = {{'A','A','A','A'},{'B','A','A','A'},{'A','O','A','A'},{'A','A','L','A'}};
        String bola = "BOL";
        boolean exp = true;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraPresenteMasDesorganizada(){
        char [][] x = {{'B','A','A','A'},{'A','A','O','A'},{'A','L','A','O'},{'A','A','A','B'}};
        String bola = "BOLA";
        boolean exp = false;
        boolean res = Ex21.verificarDireccao(x,bola);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaValidoVerticalDescendente(){
        char [][] x = {{'B','A','A','A'},{'O','A','A','A'},{'L','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA = {0,0};
        int[] pontoB = {3,0};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavrasemSequenciaValidoVerticalAscendente(){
        char [][] x = {{'A','A','A','A'},{'A','A','A','L'},{'A','A','A','O'},{'A','A','A','B'}};
        String bola = "BOLA";
        int[] pontoA = {3,3};
        int[] pontoB = {0,3};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaValidoHorizontalEsqDir(){
        char [][] x = {{'B','O','L','A'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA = {0,0};
        int[] pontoB = {0,3};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemSequenciaValidoHorizontalDirEsq(){
        char [][] x = {{'A','L','O','B'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA = {0,3};
        int[] pontoB = {0,0};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemSequenciaValidoDiagonalPrincDescendente(){
        char [][] x = {{'B','A','A','A'},{'A','O','A','A'},{'A','A','L','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={0,0};
        int[] pontoB = {3,3};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavrasemSequenciaValidoDiagonalPrincAsc(){
        char [][] x = {{'A','A','A','A'},{'A','L','A','A'},{'A','A','O','A'},{'A','A','A','B'}};
        String bola = "BOLA";
        int[] pontoA ={3,3};
        int[] pontoB = {0,0};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaValidoDiagonalSecundariaDesc(){
        char [][] x = {{'A','A','A','B'},{'A','A','O','A'},{'A','L','O','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={0,3};
        int[] pontoB = {3,0};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaValidoDiagonalSecundariaAsc(){
        char [][] x = {{'A','A','A','A'},{'A','A','L','A'},{'A','O','A','A'},{'B','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={3,0};
        int[] pontoB = {0,3};
        boolean exp = true;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaInvalido(){
        char [][] x = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={0,0};
        int[] pontoB = {3,3};
        boolean exp = false;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaValidoMaisLongaQuePalavra(){
        char [][] x = {{'B','A','A','A'},{'A','O','A','A'},{'A','A','L','A'},{'A','A','A','A'}};
        String bola = "BOL";
        int[] pontoA ={0,0}, pontoB = {3,3};
        boolean exp = true, res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarPalavraemSequenciaInvalidaLetraNova(){
        char [][] x = {{'B','A','L','A'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={0,0}, pontoB = {0,3};
        boolean exp = false, res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemSequenciaPalavraIncompleta(){
        char [][] x = {{'B','O','L','X'},{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        int[] pontoA ={0,0};
        int[] pontoB = {3,2};
        boolean exp = false;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemDdiagonalInvalida(){
        char [][] x = {{'B','A','A','A'},{'A','A','O','A'},{'A','A','A','L'},{'A','A','A','A'}};
        String bola = "BOL";
        int[] pontoA ={0,0};
        int[]pontoB = {2,3};
        boolean exp = false;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemArrayVazio(){
        char [][] x = {};
        String bola = "BOLA";
        int[] pontoA ={0,0};
        int[] pontoB = {3,3};
        boolean exp = false;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);
    }
    @Test
    void encontrarPalavraemArrayNaoQuadrado(){
        char [][] x = {{'B','A','A'},{'A','O','A','A'},{'A','A','L','A'},{'A','A','A','A'}};
        String bola = "BOL";
        int[] pontoA ={0,0};
        int[] pontoB = {2,2};
        boolean exp = false;
        boolean res = Ex21.verificarPalavraNumSegmento(x,bola,pontoA,pontoB);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasArrayVazio(){
        char [][] x = {};
        String bola = "BOLA";
        String bela = "BELA";
        boolean exp = false;
        boolean result = Ex21.verificarCruzamentos(x,bola,bela);
        assertEquals(exp,result);}
    @Test
    void encontrarCruzamentoPalavrasUmaDelasNaoExiste(){
        char [][] x = {{'B','A','A','A'},{'A','O','A','A'},{'A','A','L','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        String bala = "BALA";
        boolean exp = false;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasNaoQuadrado(){
        char [][] x = {{'B','O','L','A'},{'A','A','A'},{'L','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        String bala = "BALA";
        boolean exp = false;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);
    }
    @Test
    void encontrarCruzmentoPalavrasValido(){
        char [][] x = {{'B','O','L','A'},{'A','A','A','A'},{'L','A','A','A'},{'A','A','A','A'}};
        String bola = "BOLA";
        String bala = "BALA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasValido2(){
        char [][] x = {{'A','B','O','L'},{'A','E','A','A'},{'A','L','A','A'},{'A','A','A','A'}};
        String bol = "BOL";
        String bela = "BELA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bol,bela);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasValido3(){
        char [][] x = {{'A','B','B','A'},{'A','A','E','A'},{'A','A','A','L'},{'A','A','A','A'}};
        String bola = "ABBA";
        String bel = "BEL";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bel);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasValido4(){
        char [][] x = {{'A','B','A','A'},{'A','O','A','A'},{'A','L','A','A'},{'A','A','A','A'}};
        String bola = "ABA";
        String bala = "BOL";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasValido5(){
        char [][] x = {{'A','A','A','A'},{'A','L','A','L'},{'A','A','E','O'},{'A','A','A','B'}};
        String bola = "BOLA", bala = "BELA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasInvalido(){
        char [][] x = {{'B','O','L','A'},{'A','A','A','A'},{'B','E','L','A'},{'A','A','A','A'}};
        String bola = "BOLA", bala = "BELA";
        boolean exp = false;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavrasValido6(){
        char [][] x = {{'T','E','T','O'},{'A','A','A','A'},{'A','A','L','A'},{'A','A','A','A'}};
        String bola = "TETO";
        String bala = "TALA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavraValido7(){
        char [][] x = {{'O','T','E','T'},{'A','O','R','A'},{'A','L','V','A'},{'A','A','A','A'}};
        String bola = "TETO";
        String bala = "ERVA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,bola,bala);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavraDiagonalSecundaria(){
        char [][] x = {{'A','O','A','T'},{'A','A','E','A'},{'A','T','A','A'},{'O','A','A','A'}};
        String teto = "TETO";
        String tao = "TAO";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,teto,tao);
        assertEquals(exp,res);}
    @Test
    void encontrarCruzamentoPalavraDiagonalPrimaria(){
        char [][] x = {{'T','A','A','A'},{'A','E','A','A'},{'A','N','T','A'},{'A','A','A','O'}};
        String teto = "TETO";
        String tao = "ENA";
        boolean exp = true;
        boolean res = Ex21.verificarCruzamentos(x,teto,tao);
        assertEquals(exp,res);}

    }
