package org.example;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Word> words; //list of words
    private char[][] board; //board of letters 10x10 (default)

    /**Constructor*/
    public Board(List<Word>wordlist)throws IllegalArgumentException, NullPointerException{
        if(wordlist.size() == 0)
            throw new IllegalArgumentException("Wordlist is empty");
        if(wordlist==null)
            throw new NullPointerException("Wordlist is null");
        this.board = new char[10][10]; //board of letters 10x10 (default)
        this.words = List.copyOf(wordlist);
        for(Word word: words){
            if(checkPossibleCoordinates(word.getCoordinates(), word.getWord())){
                addWordtoBoard(word);}
            else {removeWordFromList(word.getWord());}}
        fillBoardwithRandomLetters();}
    private boolean checkPossibleCoordinates(int[][] coordinates, String word){
        if(coordinates.length != word.length())
            return false;
        for (int[] coordinate : coordinates) {
            if (coordinate[0] < 0 || coordinate[0] > 9 || coordinate[1] < 0 || coordinate[1] > 9)
                return false;}
        for(int i=0; i<coordinates.length; i++){
            if(board[coordinates[i][0]][coordinates[i][1]] != '\0' &&
                    board[coordinates[i][0]][coordinates[i][1]] != word.charAt(i))
                return false;}
        return true;}

    private void removeWordFromList(String word){
        List<Word> newWords = new ArrayList<>();
        for(Word w: words){
            if(!w.getWord().equals(word)){
                newWords.add(w);}}
        words = newWords;}

    private void addWordtoBoard(Word word){
        int[][] coordinates = word.getCoordinates();
        for(int i=0;i<coordinates.length;i++){
            board[coordinates[i][0]][coordinates[i][1]] = word.getWord().charAt(i);}}
    private void fillBoardwithRandomLetters(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j] == '\0'){
                    board[i][j] = (char) (Math.random() * 26 + 'A');}}}}

    /**These 6 methods check for the word
     * if it is present, removes the word from the wordlist and returns true
     * Else, returns false*/

    //Main coordinator method
    //checks if word is present in the board
    //if so, removes the word from the list and returns true
    public boolean wordCheck(String word, int[][] positions){
        if(checkWordCoordinator(word,positions)){
            removeWordFromList(word);
            return true;}
        return false;}

    //checks if the word is present in the matrix of the board
    //respecting every position of the word
    //if so, return true
    private boolean checkWordCoordinator(String word, int[][] positions){
        Word wrd = checkWordPresent(word);
        if(wrd == null)
            return false;
        int[] direction = makeDirection(positions[1], positions[0]);
        positions = makePositions(positions[0], direction,Math.max(Math.abs(positions[1][0] - positions[0][0]),
                Math.abs(positions[1][1] - positions[0][1]))+1);
        return checkWordPositions(wrd, positions);}

    private Word checkWordPresent(String word)
    {for(Word w: words){
            if(w.getWord().equals(word)){
                return w;}}
        return null;}

    //given the word and its coordinates, checks if the coordinates are the same as the word's
    private boolean checkWordPositions(Word word, int[][] positions){
        int[][] coordinates = word.getCoordinates();
        for(int i=0; i<positions.length; i++){
            if(coordinates[i][0] != positions[i][0] || coordinates[i][1] != positions[i][1] ||
            positions.length != coordinates.length)
                return false;}
        return true;}

    //given the end and start coordinates, makes the direction vector
    private int[] makeDirection(int[] end, int[] start){ //makes direction vector
        int[] direct = new int[2];
        direct[0] = end[0] - start[0];
        direct[1] = end[1] - start[1];
        if(direct[0] !=0){
            direct[0] = direct[0]/Math.abs(direct[0]);}
        if(direct[1] !=0){
            direct[1] = direct[1]/Math.abs(direct[1]);}
        return direct;}

    //given the start coordinates, direction vector and length of word, makes the coordinates of the word
    private int[][] makePositions(int[] start, int[] direction, int length){
        int[][] positions = new int[length][2];
        positions[0] = start;
        for(int i=1; i<length; i++){
            positions[i][0] = positions[i-1][0] + direction[0];
            positions[i][1] = positions[i-1][1] + direction[1];}
        return positions;}

    /**Return List Size(important to determine if Won)*/
    public int getWordListSize(){
        return words.size();}

    public char getIndexRowColumn(int row, int column)throws ArrayIndexOutOfBoundsException{
        if(row<0 || row>9 || column<0 || column>9)
            throw new ArrayIndexOutOfBoundsException();
        return board[row][column];}



}
