package org.example;
import java.util.Arrays;
public class Ex21 {
    public static int[][] matrizMascara(char[][]sopa, char letra) {
        int[][] matrizMascara = new int[sopa.length][sopa[0].length];
        letra = Character.toUpperCase(letra);
        int line = 0;
        int column = 0;
        for(char[] linha : sopa){
            column = 0;
         for(char letter : linha){
             if(letter==letra){
                matrizMascara[line][column]=1;}
             column++;}
         line++;}
     return matrizMascara;}//Devolve matriz de 0s e 1s, 1s nas posições onde a letra aparece
    public static boolean verificarSeQuadradoCharacters(char[][] arraydeArrays){if(arraydeArrays.length==0)
        return false;
     int linhas = arraydeArrays.length;
     int colunas = verificarSeLinhasEColunasDeUmaMatrizChar(arraydeArrays);
     return (linhas==colunas);}//Verifica se matriz é quadrada
    public static int verificarSeLinhasEColunasDeUmaMatrizChar(char[][] array) {
        if(array.length==0)
            return -1;
        for (int i = 0; i < array.length; i++) {
        if (array[i].length != array[0].length)
            return -1;}
     return array[0].length;}//Verifica se todas as linhas têm o mesmo comprimento
    public static char[] palavraParaArray(String palavra) {palavra = palavra.toUpperCase().strip();
     char[] palavraArray = new char[palavra.length()];
     for (int i = 0; i < palavra.length(); i++)
         palavraArray[i] = palavra.charAt(i);
     return palavraArray;}//Transforma Palavra Num Array
    public static boolean verificarPalavra(char[][]sopa, String palavra){
        if(!verificarSeQuadradoCharacters(sopa))
            return false;
        char[]palavraArray = palavraParaArray(palavra);
        int[][]posicoesIniciais = verificarPosicoesIniciais(sopa,palavraArray);
        int[][]direccoes = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int[] posicao : posicoesIniciais){
            for(int[] direccao : direccoes){
                if(verificador(sopa,palavraArray,posicao,direccao,0))
                    return true;}}
        return false;}//Coordena verificação
    // se a palavra existe na sopa
    public static boolean verificador(char[][]sopa, char[]palavra, int[] posicao, int[]direccao, int ind){
        if(ind==palavra.length)
            return true;
        int linha = posicao[0]+direccao[0]*ind;
        int coluna = posicao[1]+direccao[1]*ind;
        if(linha<0||linha>=sopa.length||coluna<0||coluna>=sopa[linha].length)
            return false;
        if(sopa[linha][coluna]!=palavra[ind])
            return false;
        ind++;
        return verificador(sopa,palavra,posicao,direccao,ind);}
    //Verifica se a palavra existe na sopa numa determinada direcção
    public static int[][] verificarPosicoesIniciais (char[][]sopa, char[] palavra){
        int[][] posicoesInicial = new int[0][2];
        for(int i=0; i<sopa.length;i++)
            for(int j=0;j<sopa[i].length;j++){
                if(sopa[i][j]==palavra[0]){
                    int[] posicaoInicial = new int[2];
                    posicaoInicial[0]=i;
                    posicaoInicial[1]=j;
                    posicoesInicial = adicionarPosicao(posicoesInicial,posicaoInicial);}}
        return posicoesInicial;}//Devolve as posições iniciais
    // da palavra na sopa
    public static int[][] adicionarPosicao(int[][]posicoesInicial, int[]posicaoInicial){
        int[][]novaMatriz = Arrays.copyOf(posicoesInicial,posicoesInicial.length+1);
        novaMatriz[novaMatriz.length-1]=posicaoInicial;
        return novaMatriz;}//Estende a Matriz
    //de posições iniciais
    public static boolean verificarCruzamentos(char[][]sopa, String palavra1, String palavra2){
        if(!verificarPalavra(sopa,palavra1)||!verificarPalavra(sopa,palavra2))
            return false;
        char[]palavra1Array = palavraParaArray(palavra1);
        char[]palavra2Array = palavraParaArray(palavra2);
        int[][]posicoesPalavra1 = posicoesPalavra(sopa,palavra1Array);
        int[][]posicoesPalavra2 = posicoesPalavra(sopa,palavra2Array);
        for(int[] posicoes : posicoesPalavra1)
            for(int[] posicoes2 : posicoesPalavra2)
                if(posicoes[0]==posicoes2[0] && posicoes[1]==posicoes2[1])
                    return true;
        return false;}//Verifica se as
    // palavras se cruzam
    public static int[][] posicoesPalavra(char[][]sopa, char[]palavra){
        int[][]posicoesIniciais = verificarPosicoesIniciais(sopa,palavra);
        int[][]direccoes = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        int[][]posicoes = new int[palavra.length][2];
        for(int[] posicao : posicoesIniciais){
            for(int[] direccao : direccoes){
                if(verificador(sopa,palavra,posicao,direccao,0)){
                    for(int i=0;i<palavra.length;i++){
                        posicoes[i][0]=posicao[0]+i*direccao[0];
                        posicoes[i][1]=posicao[1]+i*direccao[1];}}}}
        return posicoes;}//Devolve as posições que a palavra
    //ocupa na sopa
    public static boolean verificarPalavraNumSegmento(char[][]sopa, String palavra, int[]pontoA, int[]pontoB){
        if(!verificarValidade(pontoB[0]-pontoA[0],pontoB[1]-pontoA[1])||sopa.length==0||!verificarSeQuadradoCharacters(sopa))
            return false;
        int[]direccao = direccao(pontoA,pontoB);
        char[]palavraArray = palavraParaArray(palavra);
        return verificador(sopa,palavraArray,pontoA,direccao,0);}
    //Verifica se a palavra existe num segmento entre PontoA e PontoB
    public static int[] direccao(int[]pontoA, int[]pontoB){
        int[]direccao = new int[2];
        direccao[0]=pontoB[0]-pontoA[0];
        direccao[1]=pontoB[1]-pontoA[1];
        if(direccao[0]!=0)
            direccao[0]=direccao[0]/Math.abs(direccao[0]);
        if(direccao[1]!=0)
            direccao[1]=direccao[1]/Math.abs(direccao[1]);
        return direccao;}
    //Devolve vetor com direcçção de PontoA a PontoB
    public static boolean verificarValidade(int difX, int difY){
        if(difX==0 && difY!=0)
            return true;
        if(difX!=0 && difY==0)
            return true;
        return (difX==difY && difX!=0 && difY!=0);}
    //Verifica se o segmento é válido(só pode ser vertical, horizontal ou diagonais (principal/2ária)
}