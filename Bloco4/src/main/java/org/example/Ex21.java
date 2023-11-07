package org.example;
import java.util.Arrays;
public class Ex21 {
    //Verificar que Sopa de Letras não vazia e Quadrada
    public static boolean sopadeLetrasTesteValidade(char[][]sopa){
        boolean vazio = sopa.length!=0;
        boolean naoQuadrado = verificarSeQuadradoCharacters(sopa);
        return (vazio&&naoQuadrado);}

    //Criar Matriz Máscara para letra "X"
    public static int[][] matrizMascara(char[][]sopa, char letra)
    {int[][] matrizMascara = new int[sopa.length][sopa.length];
     letra = Character.toUpperCase(letra);
     for(int i=0;i< sopa.length;i++)
        for(int y=0;y<sopa[i].length;y++){
            if(sopa[i][y]==letra){
                matrizMascara[i][y] = 1;
                continue;}
            matrizMascara[i][y] = 0;}
     return matrizMascara;}

    //Teste para verificarr se Array de Char é Quadrado
    public static boolean verificarSeQuadradoCharacters(char[][] arraydeArrays)
    {if(arraydeArrays.length==0)
        return false;
     int linhas = arraydeArrays.length;
     int colunas = verificarSeLinhasEColunasDeUmaMatrizChar(arraydeArrays);
     return (linhas==colunas);}

    //Teste para verificar se matriz tem linhas com mesmo comprimento
    public static int verificarSeLinhasEColunasDeUmaMatrizChar(char[][] array) {
        for (int i = 0; i < array.length; i++) {
        if (array[i].length != array[0].length)
            return -1;}
     return array[0].length;}

    //Transforma Palavra Num Array
    public static char[] palavraParaArray(String palavra) {palavra = palavra.toUpperCase().strip();
     char[] palavraArray = new char[palavra.length()];
     for (int i = 0; i < palavra.length(); i++)
         palavraArray[i] = palavra.charAt(i);
     return palavraArray;}

    //dada uma palavra e uma sopa de letras
    //verifica o início e a direção de procura da palavra na sopa
    public static boolean verificarDireccao(char[][]sopa, String palavra){
        char[]palavraArray = palavraParaArray(palavra);
        int[] posicaoInicial = new int[2];
        for(int i=0; i<sopa.length;i++)
            for(int j=0;j<sopa[i].length;j++){
                if(sopa[i][j]==palavraArray[0]){
                    posicaoInicial[0]=i;
                    posicaoInicial[1]=j;
                    for(int z=-1;z<2;z++){
                        if(z+i<0||z+i>=sopa.length)
                            continue;
                        for(int a=-1;a<2;a++){
                            if(a+j<0||a+j>=sopa.length)
                                continue;
                            int[] direccao = new int[2];
                            if(sopa[i+z][j+a]==palavraArray[1]){
                                direccao[0] = z;
                                direccao[1] = a;
                                if(verificarPalavra(sopa,palavraArray,posicaoInicial,direccao))
                                    return true;}}}}}
        return false;}

    //dada a direção, a posição inicial, a palavra e a sopa, verificar se temos palavra na sopa na direção
    public static boolean verificarPalavra(char[][]sopa, char[] palavra, int[]posicaoInicial, int[]direccao){
        int linha = posicaoInicial[0];
        int coluna = posicaoInicial[1];
        for(int i=0;i<palavra.length && linha>=0 && linha< sopa.length && coluna>=0 && coluna< sopa.length;i++){
            if(palavra[i]!=sopa[linha][coluna])
                return false;
            if(palavra[i]==sopa[linha][coluna]&&linha< sopa.length&&coluna< sopa.length){
                linha+=direccao[0];
                coluna+=direccao[1];
                if(i==palavra.length-1)
                    return true;}}
        return false;}
//dadas 2 palavras na sopa verificar se existem e cruzam
    public static boolean verificarCruzamentos(char[][]sopa, String palavra1, String palavra2){
        if(!verificarDireccao(sopa,palavra1)||!verificarDireccao(sopa,palavra2)||!verificarSeQuadradoCharacters(sopa))
            return false;
        char[]palavra1Array = palavraParaArray(palavra1);
        char[]palavra2Array = palavraParaArray(palavra2);
        int[][]matrizNova= new int[sopa.length][sopa.length];
        int[][]posicoesPalavra1 = posicoesPalavra(sopa,palavra1Array);
        int[][]posicoesPalavra2 = posicoesPalavra(sopa,palavra2Array);
        for(int i=0;i<posicoesPalavra1.length ;i++)
            matrizNova[posicoesPalavra1[i][0]][posicoesPalavra1[i][1]] +=1;
        for(int i=0;i<posicoesPalavra2.length;i++)
            matrizNova[posicoesPalavra2[i][0]][posicoesPalavra2[i][1]] +=1;
        for(int j=0;j<matrizNova.length;j++)
            for (int k=0; k<matrizNova.length;k++){
                if(matrizNova[j][k]==2)
                    return true;}
        return false;}
    //dada uma palavra, procurar todas as posições dos seus carateres na sopa
    public static int[][] posicoesPalavra(char[][]sopa, char[]palavra){
        int[]posicaoInicial = new int[2];
        int[]direccao = new int[2];
        int[][]posicoes = new int[palavra.length][2];
        for(int i =0; i<sopa.length;i++)
            for(int j=0;j<sopa[i].length;j++){
                posicaoInicial[0]=i;
                posicaoInicial[1]=j;
                    for(int z=-1;z<2;z++)
                        for(int a=-1;a<2;a++){
                            direccao[0]=z;
                            direccao[1]=a;
                            if(verificarPalavra(sopa,palavra,posicaoInicial,direccao)){
                                for(int l=0;l<palavra.length;l++){
                                    posicoes[l][0]=posicaoInicial[0]+l*direccao[0];
                                    posicoes[l][1]=posicaoInicial[1]+l*direccao[1];}}}}
        return posicoes;}

    //Dada uma palavra, um ssegmento A-B e a sopa
    //Verificar se de A a B existe a palavra
    public static boolean verificarPalavraNumSegmento(char[][]sopa, String palavra, int[]pontoA, int[]pontoB){
        if(!verificarseLinhaouDiagonalValida(pontoA,pontoB)||sopa.length==0||!verificarSeQuadradoCharacters(sopa))
            return false;
        int[]direccao = new int[2];
        char[]palavraArray = palavraParaArray(palavra);
        if(pontoB[1]-pontoA[1]!=0 && pontoB[0]-pontoA[0]!=0 ){
            direccao[0]=(pontoB[0]-pontoA[0])/Math.abs(pontoB[1]-pontoA[1]);
            direccao[1]= (pontoB[1]-pontoA[1])/Math.abs(pontoB[0]-pontoA[0]);}
        if(pontoA[0]==pontoB[0]){
            direccao[0]=0;
            direccao[1]=(pontoB[1]-pontoA[1])/(Math.abs(pontoB[1]-pontoA[1]));}
        if(pontoA[1]==pontoB[1]){
            direccao[1]=0;
            direccao[0]=(pontoB[0]-pontoA[0])/Math.abs(pontoB[0]-pontoA[0]);}
        for(int i =0;i<palavraArray.length;i++){
            int linha = pontoA[0]+i*direccao[0];
            int coluna = pontoA[1]+i*direccao[1];
            if(palavraArray[i]!=sopa[linha][coluna])
                return false;}
        return true;}
    //Verifica se o segmento entre A e B é válido (horizontal, vertical ou diagonal com declive 1)
    public static boolean verificarseLinhaouDiagonalValida(int[]pontoA,int[]pontoB){
        int minX = Math.min(pontoA[0],pontoB[0]);
        int maxX = Math.max(pontoA[0],pontoB[0]);
        int minY = Math.min(pontoA[1],pontoB[1]);
        int maxY = Math.max(pontoA[1],pontoB[1]);
        int difX = maxX-minX;
        int difY = maxY-minY;
        return (difX!=0 && difY/difX == 1||difX!=0 && difY/difX==0|| difY!=0 && difX/difY == 1||difY!=0 && difX/difY == 0);}
}