package org.example;
public class Ex22 {
    public static int[][] matrizBase(int[][] matrizSudoku) {
        if (!verificarSudokuTamanhoeNumeros(matrizSudoku))
            return new int[0][0];
        int[][] base = new int[9][9];
        for (int i = 0; i < matrizSudoku.length; i++) {
            for (int j = 0; j < matrizSudoku.length; j++) {
                if (matrizSudoku[i][j] == 0){
                    base[i][j] = 0;
                    continue;}
                if (matrizSudoku[i][j] != 0)
                    base[i][j] = 1;}}
        return base;}
    public static int[][]alterarBase(int[][]matrizSudokuNova,int[][]base){
        for(int i=0;i<matrizSudokuNova.length;i++)
            for(int j=0;j<matrizSudokuNova[i].length;j++){
                if(matrizSudokuNova[i][j]!=0&&base[i][j]==0)
                    base[i][j]=2;
                if(matrizSudokuNova[i][j]==0&&base[i][j]==2)
                    base[i][j]=0;}
        return base;}
    private static boolean testarLinha(int[][]matrizSudoku,int linha,int numero){
        int[]line = matrizSudoku[linha-1];
        for(int i=0;i<matrizSudoku.length;i++){
            if(line[i]==numero)
                return false;}
        return true;}
    private static boolean testarColuna(int[][]matrizSudoku,int coluna, int numero){
        for(int[]value:matrizSudoku)
            if (value[coluna-1] == numero)
                return false;
        return true;}
    private static int escolherQuadrado(int linha,int coluna){
        return(((linha-1)/3)*3)+((coluna-1)/3);}
    private static boolean testarNumeroRepetiroQuadrado(int[][]matrizSudoku,int quadrado,int numero){
        int[]quadradoEscolhido = new int[9];
        int contador=0;
        for(int i=0;i<matrizSudoku.length;i++){
            for(int j=0;j<matrizSudoku[i].length;j++){
                if(escolherQuadrado(i+1,j+1)==quadrado){
                    quadradoEscolhido[contador]=matrizSudoku[i][j];
                    contador++;}}}
        for(int value:quadradoEscolhido){
            if(value==numero)
                return false;}
        return true;}
    private static boolean verificarSudokuTamanhoeNumeros(int[][] matrizSudoku) {
        if (matrizSudoku.length != 9) {
            return false;}
        for (int[] value:matrizSudoku){
                if (value.length != 9 || value[0] < 0 || value[0] > 9 || value[1] < 0 || value[1] > 9) {
                    return false;}}
        return true;}
    public static int[][] adicionarNovoNumeroSudoku(int[][] matrizSudoku, int linha, int coluna, int numero) {
        if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9 || numero < 1 || numero > 9){
            System.out.println("Número/Posição Inválido.");
            return matrizSudoku;}
        if(testarColuna(matrizSudoku,coluna,numero)&&
                testarLinha(matrizSudoku,linha,numero)&&
                testarNumeroRepetiroQuadrado(matrizSudoku,escolherQuadrado(linha,coluna),numero)){
            System.out.println("Número adicionado.");
            matrizSudoku[linha-1][coluna-1]=numero;
            return matrizSudoku;}
        System.out.println("Número inválido.");
        return matrizSudoku;}

    public static int[][] removerNumeroSudoku(int[][] matrizOriginal, int[][]base, int linha, int coluna) {
        if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9||base[linha-1][coluna-1]==0||base[linha-1][coluna-1]==1){
            System.out.println("Posição Inválida.");
            return matrizOriginal;}
        base[linha-1][coluna-1]=0;
        matrizOriginal[linha-1][coluna-1]=0;
        System.out.println("Número removido.");
        return matrizOriginal;}

    public static boolean verificarSudokuTerminado(int[][] matrizSudoku) {
        for(int[] value: matrizSudoku)
            for(int valor:value)
                if(valor==0){
                    return true;}
        System.out.println("Jogo terminado!");
        SudokuFunction.printMatrix(matrizSudoku);
        return false;}
}