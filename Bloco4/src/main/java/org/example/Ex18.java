package org.example;

import java.util.LinkedHashSet;

public class Ex18 {
    public static int menorNumerodeArraydeArrays(int[][] arraydeArrays) {
        if (arraydeArrays.length == 0)
            return Integer.MIN_VALUE;
        int x = Integer.MAX_VALUE;
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                if (arraydeArrays[i][y] < x)
                    x = arraydeArrays[i][y];
        return x;
    }
    public static int maiorNumerodeArraydeArrays(int[][] arraydeArrays) {
        if (arraydeArrays.length == 0)
            return Integer.MAX_VALUE;
        int x = Integer.MIN_VALUE;
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                if (arraydeArrays[i][y] > x)
                    x = arraydeArrays[i][y];
        return x;}
    public static double mediavaloresArraydeArrays(int[][] arraydeArrays) {
        double x = 0;
        int size = 0;
        for (int i = 0; i < arraydeArrays.length; i++)
            size += arraydeArrays[i].length;
        if (size == 0)
            return 0;
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                x += arraydeArrays[i][y];
        return x / size;}
    public static int produtodeValoresdeArraydeArrays(int[][] arraydeArrays) {
        if (arraydeArrays.length == 0)
            return 0;
        int x = 1;
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                x *= arraydeArrays[i][y];
        return x;}
    public static int[] conjuntoElementosNaoRepetidosArraydeArrays(int[][] arraydeArrays) {
        LinkedHashSet<Integer> hash = new LinkedHashSet<>();
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                hash.add(arraydeArrays[i][y]);
        int[] newArray = new int[hash.size()];
        int ind = 0;
        for (int value : hash) {
            newArray[ind] = value;
            ind++;
        }
        return newArray;}
    public static int[] conjuntodePrimosdeArraydeArrays(int[][] arraydeArrays) {
        LinkedHashSet<Integer> hash = new LinkedHashSet<>();
        for (int i = 0; i < arraydeArrays.length; i++)
            for (int y = 0; y < arraydeArrays[i].length; y++)
                if (testarPrimo(arraydeArrays[i][y]))
                    hash.add(arraydeArrays[i][y]);
        int[] newArray = new int[hash.size()];
        int n = 0;
        for (int value : hash) {
            newArray[n] = value;
            n++;
        }
        return newArray;}
    public static int[] diagonalPrincipalMatriz(int[][] matriz) {
        if (matriz.length == 0 || Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(matriz) == -1)
            return new int[0];
        int size = matriz.length;
        if (matriz.length > matriz[0].length)
            size = matriz[0].length;
        int[] diagonal = new int[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = matriz[i][i];
        }
        return diagonal;}
    public static int[] diagonalSecundariaMatriz(int[][] matriz) {
        if (matriz.length == 0 || Ex15.verificarSeLinhasTemMesmoNumeroDeColunas(matriz) == -1)
            return new int[0];
        int size = matriz.length;
        if (matriz.length > matriz[0].length)
            size = matriz[0].length;
        int endIndex = matriz[0].length - 1;
        int[] diagonalSecundaria = new int[size];
        for (int i = 0; i < size; i++) {
            diagonalSecundaria[i] = matriz[i][endIndex--];
        }
        return diagonalSecundaria;}
    public static boolean testarPrimo(int n) {
        if (n < 2)
            return false;
        for (int i = n - 1; i > 1; i--)
            if (n % i == 0)
                return false;
        return true;}
    public static boolean testarMatrizIdentidade(int[][] matriz) {
        if (matriz.length == 0 || !Ex16.verificarSeQuadrado(matriz))
            return false;
        for (int i = 0; i < matriz.length; i++)
            for (int y = 0; y < matriz[i].length; y++) {
                if (i == y && matriz[i][y] != 1)
                    return false;
                if (i != y && matriz[i][y] != 0)
                    return false;}
        return true;}
    public static double[][] matrizInvertida(double[][] matriz) {
        if (matriz.length == 0 || matriz.length != matriz[0].length || verificarDeterminanteLaplace(matriz) == 0)
            return new double[0][0];
        if (matriz.length == 1 && matriz[0].length == 1 || matriz.length == 2 && matriz[0].length == 2)
            return returnMatrizInversa1x1ou2x2(matriz);
        double det = verificarDeterminanteLaplace(matriz);
        double[][] newMatrix = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz.length; j++){
                int[] pos = {i, j};
                double[][] submatriz = verificarSubMatriz(matriz, pos);
                newMatrix[i][j] = coFatordeX(submatriz, pos);}
        double[][] matrizInversa = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz[i].length; j++)
                matrizInversa[i][j] = (newMatrix[j][i]) / det;
        return matrizInversa;}
    public static double[][] matrizTranspostaDoubleQuadrada(double[][] matriz) {
        if (matriz.length == 0)
            return new double[0][0];
        for (int i = 1; i < matriz.length; i++)
            if (matriz[i].length != matriz[i - 1].length)
                return new double[0][0];
        double[][] newArray = new double[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz[0].length; i++)
            for (int y = 0; y < matriz.length; y++)
                newArray[i][y] = matriz[y][i];
        return newArray;}
    public static double[][] returnMatrizInversa1x1ou2x2(double[][] matriz) {
        if (matriz.length == 1) {
            matriz[0][0] = (1d / matriz[0][0]);
            return matriz;}
        double det = verificarDeterminanteLaplace(matriz);
        double[][] matrizNova = devolverMatrizaDividirporDeterminante(matriz, det);
        double[][] copiaMatriz = devolverCopiadaMatriz(matrizNova);
        matrizNova = diagonalPrincipalAlterarPosicoesdiagonalSecundariaSimetrico(matrizNova, copiaMatriz);
        return matrizNova;}
    public static double verificarDeterminanteLaplace(double[][] matriz) {
        if (matriz.length == 0)
            return Integer.MIN_VALUE;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i].length != matriz.length)
                return Integer.MIN_VALUE;}
        if (matriz.length == 2)
            return (matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0]);
        if (matriz.length == 1)
            return matriz[0][0];
        if(matriz.length ==3)
            return determinanteRegraSarrus(matriz);
        double determinante = 0;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i] == 0)
                continue;
            int[] pos = {0, i};
            double[][] subMatriz = verificarSubMatriz(matriz, pos);
            determinante += Math.pow(-1, i + 2d) * matriz[0][i] * verificarDeterminanteLaplace(subMatriz);
        }
        return determinante;}
    public static double[][] verificarSubMatriz(double[][] matriz, int[] i) {
        if (i[0]<0 || i[0] > matriz.length - 1 || i[1] < 0 || i[1] > matriz.length || matriz.length == 0)
            return new double[0][0];
        int subLinha = 0;
        int subColuna = 0;
        double[][]subMatriz = new double[matriz.length - 1][matriz.length - 1];
        for(int linha=0;linha<matriz.length;linha++){
            if(linha==i[0])
                continue;
            subColuna=0;
            for(int coluna=0;coluna<matriz.length&& subLinha<subMatriz.length && subColuna<subMatriz.length;coluna++){
                if(coluna==i[1])
                    continue;
                subMatriz[subLinha][subColuna]=matriz[linha][coluna];
                subColuna++;}
            subLinha++;}
        return subMatriz;}
    public static double[][] devolverMatrizaDividirporDeterminante(double[][] matriz, double det) {
        double[][] matrizNova = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int y = 0; y < matriz[i].length; y++) {
                matrizNova[i][y] = (matriz[i][y]) / (det);
            }
        return matrizNova;}
    public static double[][] devolverCopiadaMatriz(double[][] matriz) {
        double[][] copiaMatriz = new double[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++)
            for (int j = 0; j < matriz.length; j++)
                copiaMatriz[i][j] = matriz[i][j];
        return copiaMatriz;
    }
    public static double[][] diagonalPrincipalAlterarPosicoesdiagonalSecundariaSimetrico(double[][] matriz, double[][] copiaMatriz) {
        for (int i = 0; i < matriz.length; i++)
            for (int y = 0; y < matriz.length; y++) {
                if (i == y) {
                    matriz[i][y] = copiaMatriz[matriz.length - 1 - i][matriz.length - 1 - y];
                }
                if (i + y == matriz.length - 1)
                    matriz[i][y] = matriz[i][y] * (-1);
            }
        return matriz;
    }
    public static double coFatordeX(double[][] matriz, int[] pos) {
        if (matriz.length == 2)
            return Math.pow(-1, pos[0] + pos[1]) * ((matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]));
        if(matriz.length==3)
            return Math.pow(-1, pos[0]+pos[1])*determinanteRegraSarrus(matriz);
        return Math.pow(-1,pos[0]+pos[1])*verificarDeterminanteLaplace(verificarSubMatriz(matriz,pos));}
    public static double determinanteRegraSarrus(double[][]matriz){
        double[][]newMatriz = new double[matriz.length][matriz.length+2];
        for(int i=0;i<matriz.length;i++)
            for(int j=0;j<newMatriz[i].length;j++){
                if(j==3){
                    newMatriz[i][j]=matriz[i][0];
                    continue;}
                if(j==4){
                    newMatriz[i][j]=matriz[i][1];
                    continue;}
                newMatriz[i][j]=matriz[i][j];}
        double diagonaisPrincipais = somaDiagonaisPrincipais(newMatriz);
        double diagonaisSecundarias = somaDiagonaisSecundarias(newMatriz);
        return diagonaisSecundarias+diagonaisPrincipais;}
    public static double somaDiagonaisPrincipais(double[][]matriz){
        double diagonal1 = 1;
        double diagonal2 = 1;
        double diagonal3 = 1;
        for(int i =0;i<matriz.length;i++)
            diagonal1=diagonal1*matriz[i][i];
        for(int i=0,j=1;i<matriz.length && j<matriz.length+1;j++,i++)
            diagonal2=diagonal2*matriz[i][j];
        for(int i=0,j=2;i<matriz.length && j<matriz.length+2;j++,i++)
            diagonal3=diagonal3*matriz[i][j];
        return  diagonal2+diagonal1+diagonal3;}
    public static double somaDiagonaisSecundarias(double[][]matriz){
        double diagonal1 = 1;
        double diagonal2 = 1;
        double diagonal3 = 1;
        for(int i=0,j=4;i<matriz.length && j>=0;j--,i++)
            diagonal1=diagonal1*matriz[i][j];
        for(int i=0,j=3;i<matriz.length && j>=0;j--,i++)
            diagonal2=diagonal2*matriz[i][j];
        for(int i=0,j=2;i<matriz.length && j>=0;j--,i++)
            diagonal3=diagonal3*matriz[i][j];
        return (-1)*(diagonal1+diagonal2+diagonal3);
    }}