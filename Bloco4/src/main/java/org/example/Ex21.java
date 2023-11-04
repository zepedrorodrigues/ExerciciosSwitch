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

    //Verificar se palavra existe na sopa de Letras
    public static boolean encontrarPalavra(char[][]sopa, String palavra) {
        if(!sopadeLetrasTesteValidade(sopa))
            return false;
        char[] palavraArray = palavraParaArray(palavra.toUpperCase().strip());
        int[][] posicoesInicio = new int[0][2];
        int[][] matrizMascara = matrizMascara(sopa,palavraArray[0]);
        for(int i = 0; i< sopa.length;i++)
            for(int y = 0; y<sopa[i].length;y++){
                if(matrizMascara[i][y]==1){
                    int[] x = new int[2];
                    x[0] = i;
                    x[1] = y;
                    posicoesInicio= estenderMatrizSemAlteracoes(posicoesInicio);
                    posicoesInicio[posicoesInicio.length-1]=x;}}
        return testarVariasDireccoes(sopa,palavraArray,posicoesInicio);}

    //Estender matriz para acomodar +1 Array com a mesma extensão (2)
    public static int[][]estenderMatrizSemAlteracoes(int[][]matriz) {
        int[][]newMatriz = new int[matriz.length+1][2];
        for(int i=0;i<matriz.length;i++)
            newMatriz[i] = matriz[i];
        return newMatriz;}

    //Procurar se em algum sentido a partir do Ponto Inicial
    //É possível escrever a palavra
    public static boolean testarVariasDireccoes(char[][]sopa, char[] palavra, int[][]posicoesinicio){
        //Teste para verificar se em alguma direção
        // A partir do Ponto inicial se consegue encontrar a palavra
        for(int[] value:posicoesinicio){
            char[] linha = sopa[value[0]];
            char[] coluna = devolverSegmentoColuna(sopa,0,sopa.length-1,value[1]);
            char[] diagonalPrincipal = devolverDiagonalPrincipal(sopa,value);
            char[] diagonalSecundaria = devolverDiagonalSecundaria(sopa,value);
            boolean[] arraydeboleanas = new boolean[4];
            arraydeboleanas[0] = testarDireccoes(linha,palavra);
            arraydeboleanas[1] = testarDireccoes(coluna,palavra);
            arraydeboleanas[2] = testarDireccoes(diagonalPrincipal,palavra);
            arraydeboleanas[3] = testarDireccoes(diagonalSecundaria,palavra);
            for(boolean v: arraydeboleanas)
                if(v)
                    return true;}
        return false;}

    //Dada uma linha(Array) com Chars vê se num sentido ou no outro conseguimos encontrar
    //A palavra em questão
    public static boolean testarDireccoes(char[]linha, char[] palavra)
    {for(int i=0;i<linha.length;i++){
        if(linha[i] == palavra[0] && verificarEsqDir(linha,palavra,i) || linha[i]==palavra[0] && verificarDirEsq(linha,palavra,i))
            return true;}
     return false;}
    //Método que dado um array de letras possíveis, procura a palavra X num sentido EsqDir
    public static boolean verificarEsqDir(char[]linha,char[]palavra,int i){
        for(int y=0;y+i<linha.length;y++){
            if(linha[i+y]!=palavra[y])
                break;
            if(y==palavra.length-1){
                return true;}}
        return false;}
    //Método que avalia no sentido DirEsq
    public static boolean verificarDirEsq(char[]linha,char[]palavra, int i){
        for(int y=0,ind=0;y+i>=0;y--,ind++){
            if(linha[i+y]!=palavra[ind])
                break;
            if(y== -1*(palavra.length-1)){
                return true;}}
        return false;}

    //diagonal principal ou paralela à principal da Matriz
    //Que inclui a posição inicial
    public static char[] devolverDiagonalPrincipal(char[][]sopa, int[] pos){
        char[] diagonal = new char[0];
        if(pos[0]==pos[1]){
            for(int i = 0; i<sopa.length;i++){
                diagonal = estenderArrayCharacters(diagonal);
                diagonal[diagonal.length-1]=sopa[i][i];}}
        if(pos[0]>pos[1]){
            for(int i =pos[0]-pos[1], y=0; i< sopa.length&&y<sopa[i].length;i++,y++){
                diagonal=estenderArrayCharacters(diagonal);
                diagonal[y] = sopa[i][y];}}
        if(pos[0]<pos[1]){
            int ind = 0;
            for(int i = pos[1]-pos[0]; i< sopa.length;i++){
                diagonal=estenderArrayCharacters(diagonal);
                diagonal[ind] = sopa[ind][i];
                ind++;}}
        return diagonal;}

    //diagonal secundária ou paralela à secundária da Matriz
    //Que inclui a posição inicial
    public static char[] devolverDiagonalSecundaria(char[][]sopa,int[]pos) {   int lines = sopa.length;
        int ind = 0;
        char[] diagonalSecundaria = new char[0];
        if(pos[0]<lines-1-pos[1]){
            for(int i = 0,j=pos[1]+pos[0];i<lines && j>=0;i++,j--){
                diagonalSecundaria = estenderArrayCharacters(diagonalSecundaria);
                diagonalSecundaria[ind] =sopa [i][j];
                ind++;}}
        if(lines-1-pos[1]<pos[0]){
            for(int i = pos[0]-(lines-1-pos[1]), j = lines-1; i<lines && j>=0;i++,j--){
                diagonalSecundaria = estenderArrayCharacters(diagonalSecundaria);
                diagonalSecundaria[ind] =sopa [i][j];
                ind++;}}
        if(pos[0]== lines-1-pos[1]){
            for(int i = 0, j= lines-1; i< lines && j>=0; i++,j--){
                diagonalSecundaria = estenderArrayCharacters(diagonalSecundaria);
                diagonalSecundaria[ind] =sopa [i][j];
                ind++;}}
        return diagonalSecundaria;}

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

    //Específico para estender Array de Chars
    public static char[] estenderArrayCharacters(char[]array)
    {return Arrays.copyOf(array,array.length+1);}
    public static boolean verificarPalavraemSequencia(char[][]sopa, String palavra, int[]pontoA,int[]pontoB) {
        boolean testValidade = verificarCondicoesAdequadas(sopa,palavra,pontoA,pontoB);
        boolean testQuadrado = verificarSeQuadradoCharacters(sopa);
        if(!testValidade || !testQuadrado)
            return false;
        //Transformar palavra em Array
        char[] palavraArray = palavraParaArray(palavra);
        //Verificar se a Linha/Diagonal é válida
        if(!verificarseLinhaouDiagonalValida(pontoA,pontoB))
            return false;
        char[] linha = new char[0];
        if(pontoA[0]==pontoB[0]&&pontoA[1]!=pontoB[1])
            linha = devolverSegmentoHorizontal(sopa[pontoA[0]],pontoA[1],pontoB[1]);
        if(pontoA[1]==pontoB[1]&&pontoA[0]!=pontoB[0])
            linha = devolverSegmentoColuna(sopa,pontoA[0],pontoB[0],pontoA[1]);
        if(pontoA[0]!=pontoB[0]&&pontoA[1]!=pontoB[1])
            linha = devolverSegmentoDiagonal(sopa,pontoA,pontoB);
        return testarDireccoes(linha,palavraArray);}
    public static boolean verificarCondicoesAdequadas(char[][]sopa, String palavra, int[]pontoA,int[]pontoB)
    {boolean pontoAnosLimites = (pontoA[0]>=0 && pontoA[0]<sopa.length && pontoA[1]>=0 && pontoA[1]<sopa.length);
     boolean pontoBnosLimites = (pontoB[0]>=0 && pontoB[0]<sopa.length && pontoB[1]>=0 && pontoB[1]<sopa.length);
     return(palavra.length()>0 && pontoBnosLimites && pontoAnosLimites);}
    //Ver se do ponto A ao ponto B a linha feita é válida
    // se horizontal, válido, se vertical válido, se diagonal, só pode
    // ter declive 1 (mover-se 1 casa na vertical e 1 na horizontal)
    public static boolean verificarseLinhaouDiagonalValida(int[]pontoA,int[]pontoB){
        int minX = Math.min(pontoA[0],pontoB[0]);
        int maxX = Math.max(pontoA[0],pontoB[0]);
        int minY = Math.min(pontoA[1],pontoB[1]);
        int maxY = Math.max(pontoA[1],pontoB[1]);
        int difX = maxX-minX;
        int difY = maxY-minY;
        return (difX!=0 && difY/difX == 1||difX!=0 && difY/difX==0|| difY!=0 && difX/difY == 1||difY!=0 && difX/difY == 0);}
    public static char[] devolverSegmentoHorizontal(char[]sopaLinha,int pontoA,int pontoB) {char[] linhaFinal = new char[0];
     int min = pontoA;
     int max = pontoB;
     if(pontoA>pontoB){
         min = pontoB;
         max = pontoA;}
     for(int i = min;i<=max;i++){
         linhaFinal = estenderArrayCharacters(linhaFinal);
         linhaFinal[linhaFinal.length-1] = sopaLinha[i];}
     return linhaFinal;}
    //devolver Segmento da Coluna onde estão os pontos
    //mas só do Ponto A ao B
    public static char[] devolverSegmentoColuna (char[][]sopa, int pontoA, int pontoB, int yColuna) {char[] linhaFinal = new char[0];
     int min = pontoA;
     int max = pontoB;
     if(pontoA>pontoB){
         min = pontoB;
         max = pontoA;}
     for(int i = min; i<=max;i++){
         linhaFinal = estenderArrayCharacters(linhaFinal);
         linhaFinal[linhaFinal.length-1] = sopa[i][yColuna];}
     return linhaFinal;}
    //avaliar qual diagonal estamos a tratar
    //E devolver o segmento entre ponto A e ponto B
    public static char[] devolverSegmentoDiagonal(char[][]sopa, int[]pontoA, int[]pontoB) {
        char[]diagonalPrincipal = devolverDiagonalPrincipal(sopa,pontoA);
        char[]diagonalSecundaria = devolverDiagonalSecundaria(sopa,pontoA);
        char[]linhaFinal = new char[0];
        if(pontoA[0]<pontoB[0]&&pontoA[1]<pontoB[1]||pontoA[0] > pontoB[0] && pontoA[1] > pontoB[1])
            linhaFinal = segmentoDiagonalPrincipal(diagonalPrincipal,pontoA,pontoB);
        if(pontoA[0] > pontoB[0] && pontoA[1] < pontoB[1]|| pontoA[0] < pontoB [0]&& pontoA[1] > pontoB[1])
            linhaFinal = segmentoDiagonalSecundaria(diagonalSecundaria,pontoA,pontoB);
        return linhaFinal;}
    //devolve um Segmento da Diagonal Principal ou Segmento paralelo a este
    //Que passe pela palavra/letra em estudo
    public static char[] segmentoDiagonalPrincipal(char[]diagPrincipal,int[] pontoA,int[] pontoB)
    {char[] linhaFinal = new char[0];
     if(pontoA[0]<pontoB[0]&&pontoA[1]<pontoB[1]){
         for(int i = pontoA[1];i<diagPrincipal.length;i++){
             linhaFinal = estenderArrayCharacters(linhaFinal);
             linhaFinal[linhaFinal.length-1] = diagPrincipal[i];}}
     if(pontoA[0] > pontoB[0] && pontoA[1] > pontoB[1]){
         for(int i = pontoB[1];i<diagPrincipal.length;i++){
             linhaFinal = estenderArrayCharacters(linhaFinal);
             linhaFinal[linhaFinal.length-1] = diagPrincipal[i];}}
     return linhaFinal;}
    //devolve um Segmento da Diagonal Secundaria ou Segmento paralelo a este
    //Que passe pela palavra/letra em estudo
    public static char[] segmentoDiagonalSecundaria(char[]diagSecundaria, int[]pontoA,int[]pontoB) {
        char[] linhaFinal = new char[0];
        if(pontoA[0] > pontoB[0] && pontoA[1] < pontoB[1]){
            for(int i = pontoA[1];i<diagSecundaria.length;i++){
                linhaFinal = estenderArrayCharacters(linhaFinal);
                linhaFinal[linhaFinal.length-1] = diagSecundaria[i];}}
        if(pontoA[0] < pontoB[0]&& pontoA[1] > pontoB[1]){
            for(int i = pontoB[1];i<diagSecundaria.length;i++){
                linhaFinal = estenderArrayCharacters(linhaFinal);
                linhaFinal[linhaFinal.length-1] = diagSecundaria[i];}}
        return linhaFinal;}
    //Avaliar se as palavras na sopa de letras
    //1. Existem
    //2. A sopa de letras é válida
    //3. avalia e busca as posições da palavra
    //4. Envia-as para comparação
    public static boolean obterCruzamentosdePalavras(char[][]sopa, String palavra1,String palavra2){
        if(sopa.length==0||palavra1.length()==0||palavra2.length()==0||!verificarSeQuadradoCharacters(sopa))
            return false;
        if(!encontrarPalavra(sopa,palavra1)||!encontrarPalavra(sopa,palavra2))
            return false;
        int[][]posicoesIniciaiseFinaisPalavra1= verificaPosicoesIniciaiseFinaisPalavra(sopa,palavra1);
        int[][]posicoesIniciaiseFinaisPalavra2 = verificaPosicoesIniciaiseFinaisPalavra(sopa,palavra2);
        int[][]posicoesTotaisPalavra1 = emQueSentidoVaiaPalavra(posicoesIniciaiseFinaisPalavra1);
        int[][]posicoesTotaisPalavra2 = emQueSentidoVaiaPalavra(posicoesIniciaiseFinaisPalavra2);
        return compararPosicoesPalavra(posicoesTotaisPalavra1,posicoesTotaisPalavra2);}
    //tendo em conta o Ponto A e B e a Matriz Máscara, devolve uma Matriz
    //com 2 Arrays: posição inicial e final, respetivamente
    public static int[][] verificaPosicoesIniciaiseFinaisPalavra(char[][]sopa, String palavra){
        int[][]posicaoInicialeFinal = {{0,0},{0,0}};
        boolean verificarValidade = encontrarPalavra(sopa,palavra);
        if(!verificarValidade)
            return posicaoInicialeFinal;
        char[]palavraArray = palavraParaArray(palavra);
        int[][]matrizMascaraInicial = matrizMascara(sopa,palavraArray[0]);
        int[][]matrizMascaraFinal = matrizMascara(sopa,palavraArray[palavraArray.length-1]);
        int[][]posicoesIniciais = posicoesIniciaisouFinais(matrizMascaraInicial);
        int[][]posicoesFinais = posicoesIniciaisouFinais(matrizMascaraFinal);
        for(int[]value:posicoesIniciais)
            for(int[]valor:posicoesFinais)
                if(verificarPalavraemSequencia(sopa,palavra,value,valor)){
                    posicaoInicialeFinal[0] = value;
                    posicaoInicialeFinal[1] = valor;}
        return posicaoInicialeFinal;}
    //Avalia o conjunto de posições iniciais/finais onde se encontra
    // a 1ª e a última letras duma palavra
    public static int[][] posicoesIniciaisouFinais(int[][]matrizMascara){
        int[][]posicoes = new int[0][2];
        for(int i=0;i<matrizMascara.length; i++)
            for(int j=0; j<matrizMascara.length;j++)
                if(matrizMascara[i][j]==1){
                    posicoes = estenderMatrizSemAlteracoes(posicoes);
                    int[] x = {i,j};
                    posicoes[posicoes.length-1]=x;}
        return posicoes;}
    //Avalia dentro das várias possibilidades em que sentido se desloca a palavra
    //E envia-a para os métodos que devolvem os segmentos paralelos a esta
    public static int[][] emQueSentidoVaiaPalavra(int[][]posicoesIniciaiseFinais){
        if(posicoesIniciaiseFinais[0][0]==posicoesIniciaiseFinais[1][0])
            return devolverPosicoesSegmentoHorizontal(posicoesIniciaiseFinais[0],posicoesIniciaiseFinais[1]);
        if(posicoesIniciaiseFinais[0][1]==posicoesIniciaiseFinais[1][1])
            return devolverPosicoesSegmentoVertical(posicoesIniciaiseFinais[0],posicoesIniciaiseFinais[1]);
        return devolverPosicoesSegmentoDiagonal(posicoesIniciaiseFinais[0],posicoesIniciaiseFinais[1]);}
    //Verifica se nos arrays de posição das palavras há posições em comum
    public static boolean compararPosicoesPalavra(int[][]posicoesPalavraA, int[][]posicoesPalavraB){
        for(int[] value:posicoesPalavraA)
            for(int[] letra:posicoesPalavraB)
                if(letra[0]==value[0]&&letra[1]==value[1])
                    return true;
        return false;}
    //Devolve Matriz com Arrays que contêm coordenadas
    //Dos pontos onde a palavra se encontra (caso seja horizontal)
    public static int[][] devolverPosicoesSegmentoHorizontal(int[]pontoA,int[]pontoB){
        int[][] posicoesFinais = new int[0][2];
        int min = pontoA[1];
        int max = pontoB[1];
        if(pontoA[1]>pontoB[1]){
            min = pontoB[1];
            max = pontoA[1];}
        for(int i = min;i<=max;i++){
            posicoesFinais = estenderMatrizSemAlteracoes(posicoesFinais);
            int[] x = {pontoA[0],i};
            posicoesFinais[posicoesFinais.length-1] = x;}
        return posicoesFinais;}
    //Devolve Matriz com Arrays que contêm coordenadas
    //Dos pontos onde a palavra se encontra (caso seja vertical)
    public static int[][] devolverPosicoesSegmentoVertical(int[]pontoA,int[]pontoB){
        int[][] posicoesFinais = new int[0][2];
        int min = pontoA[0];
        int max = pontoB[0];
        if(pontoA[0]>pontoB[0]){
            min = pontoB[0];
            max = pontoA[0];}
        for(int i = min;i<=max;i++){
            posicoesFinais = estenderMatrizSemAlteracoes(posicoesFinais);
            int[] x = {i,pontoA[1]};
            posicoesFinais[posicoesFinais.length-1] = x;}
        return posicoesFinais;}
    //Recebe Segmento, avalia se diagonal principal ou 2ária e envia para
    //1 dos 2 métodos abaixo
    public static int[][] devolverPosicoesSegmentoDiagonal(int[]pontoA, int[]pontoB) {
        int[][] posicoesSegmentoDiagonal = new int[0][2];
        //diagonal principal
        if(pontoA[0]<pontoB[0]&&pontoA[1]<pontoB[1]||pontoA[0] > pontoB[0] && pontoA[1] > pontoB[1])
            posicoesSegmentoDiagonal = posicoesSegmentoDiagonalPrincipal(pontoA,pontoB) ;
        //diagonal secundária
        if(pontoA[0] > pontoB[0] && pontoA[1] < pontoB[1]|| pontoA[0] < pontoB [0]&& pontoA[1] > pontoB[1])
            posicoesSegmentoDiagonal = posicoesSegmentoDiagonalSecundaria(pontoA,pontoB);
        return posicoesSegmentoDiagonal;}
    //Caso seja orientada paralelamente a diagonal secundaria
    //devolve matriz de posicoes da palavra
    public static int[][] posicoesSegmentoDiagonalPrincipal(int[]pontoA, int[]pontoB){
        int[][] posicoesFinais = new int[0][2];
        if(pontoA[0]<pontoB[0]&&pontoA[1]<pontoB[1]){
            for(int i = pontoA[1];i<=pontoB[1];i++){
                posicoesFinais = estenderMatrizSemAlteracoes(posicoesFinais);
                int[] x = {i,i};
                posicoesFinais[posicoesFinais.length-1] = x;}}
        if(pontoA[0] > pontoB[0] && pontoA[1] > pontoB[1]){
            for(int i = pontoB[1];i<=pontoA[1];i++){
                posicoesFinais = estenderMatrizSemAlteracoes(posicoesFinais);
                int[] x = {i,i};
                posicoesFinais[posicoesFinais.length-1] = x;}}
        return posicoesFinais;}
    //Caso seja orientada paralelamente a diagonal secundaria
    //devolve matriz de posicoes da palavra
    public static int[][] posicoesSegmentoDiagonalSecundaria(int[]pontoA,int[]pontoB){
        int[][] posicoesFinal = new int[0][2];
        if(pontoA[0] > pontoB[0] && pontoA[1] < pontoB[1]){
            for(int i = pontoA[1], j = pontoA[0];i<=pontoB[1] && j>=pontoB[0];i++,j--){
                posicoesFinal = estenderMatrizSemAlteracoes(posicoesFinal);
                int[] x = {j,i};
                posicoesFinal[posicoesFinal.length-1] = x;}}
        if(pontoA[0] < pontoB [0]&& pontoA[1] > pontoB[1]){
            for(int i = pontoB[1], j = pontoB[0];i<=pontoA[1] && j>=pontoA[0];i++,j--){
                posicoesFinal = estenderMatrizSemAlteracoes(posicoesFinal);
                int[] x = {j,i};
                posicoesFinal[posicoesFinal.length-1] = x;}}
        return posicoesFinal;}
}