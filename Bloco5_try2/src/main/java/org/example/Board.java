package org.example;
public class Board {
    private char[][] board;
    String[] words;
    public Board (char[][] board, String[] words){
        this.board = board;
        this.words = words;
        for(String word : words){
            int[][]positions = getPositions(word);
            Word w = new Word(word, positions);}}
    public char[][] getBoard(){
        return board;}

    public String[] getWords(){
        return words;}
    public void removeWordfromWords(Word word){
        String[] newWords = new String[words.length-1];
        int i = 0;
        for(String w : words){
            if(!w.equals(word.getWord())){
                newWords[i] = w;
                i++;}}
        words = newWords;}

    /**FUNÇÕES DE ATRIBUIÇÃO DE POSICÕES ÀS PALAVRAS*/
    private int[][] getPositions(String word){ //retorna as posições de uma palavra
        int[][] firstPositions = matrizMascara(words[0].charAt(0)); //todas as posições da primeira letra da palavra
        int[][] directions = {{0,1},{1,0},{1,1},{-1,0},{0,-1},{-1,-1},{1,-1},{-1,1}}; //todas as direções possíveis
        int[][] positions = new int[word.length()][2];
        for(int[] position : firstPositions){
            for(int[] direction : directions){
                if(checkWordSaidDirection(position, direction, words[0].toCharArray())){//se palavra existir na direção
                    positions = addPositions(position,direction,word.length());}}}
        return positions;} //retorna as posições da palavra
    private boolean checkWordSaidDirection(int[]startingPosition, int[]direction, char[]word){ //verifica se a palavra
        // existe numa direção
        int line = startingPosition[0];
        int column = startingPosition[1];
        for(int i = 0; i < word.length; i++){ //
            if(board[line][column] != word[i]) //se a letra não for igual à letra da palavra
                return false;
            line += direction[0];
            column += direction[1];
            if(line < 0 || line >= board.length || column < 0 || column >= board[0].length)
                return false;
            if(i == word.length-1)
                return true;}
        return false;}
    private int[][] addPositions(int[]startingPosition, int[]direction, int wordLength){
        int[][] positions = new int[wordLength][2]; //matriz de posições
        int line = startingPosition[0]; //linha inicial
        int column = startingPosition[1]; //coluna inicial
        for(int i = 0; i < wordLength; i++){
            positions[i][0] = line;
            positions[i][1] = column;
            line += direction[0]; //avança na direção
            column += direction[1];} //avança na direção
        return positions;} //retorna as posições da palavra

    private int[][] matrizMascara(char firstLetter){ //retorna uma matriz com 1's
                                                    // nas posições da primeira letra da palavra
        int[][] matrizMascara = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == firstLetter)
                    matrizMascara[i][j]=1;
                matrizMascara[i][j]=0;}}
        return matrizMascara;}
}
