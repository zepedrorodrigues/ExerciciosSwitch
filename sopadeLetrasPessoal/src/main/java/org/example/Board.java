package org.example;
import java.util.List;
import java.util.Random;

public class Board {
    private List<Word> words; //list of words
    private char[][] board; //board of letters 10x10 (default)

    /**Constructor*/
    public Board(List<Word>wordlist){
       this.words = checkList(wordlist); //Edits the WordList regarding if the words are possible to add to the board
       this.board = finalBoard(wordlist);} //Creates the final board

    /**These 3 methods initialize a Board*/

    //passes every word in the list to check if it is possible to add (checkIfWordPossible)
    //if so, creates a replica of the board with the word added
    //if not, removes the word from the list
    private List<Word> checkList(List<Word>wordList){
        char[][] brd = new char[10][10]; //board of letters 10x10 (default)
        for(Word w: wordList){
            if(!checkIfWordPossible(brd, w)){ //if word is not possible, remove from list
                wordList.remove(w);}
            else{
                int[][] coordinates = w.getCoordinates();
                for(int i=0; i<coordinates.length; i++){
                    brd[coordinates[i][0]][coordinates[i][1]] = w.getWord().charAt(i);}}}
        return wordList;}

    //Creates an empty 10x10 board and adds all the characters of the words in their positions
    //fills the rest of the board with random letters
    private char[][] finalBoard (List<Word>wordList){
        char[][] brd = new char[10][10]; //board of letters 10x10 (default)
        for(Word w: wordList){
            int[][] coordinates = w.getCoordinates(); //get coordinates of word
            for(int i=0; i<coordinates.length; i++){
                brd[coordinates[i][0]][coordinates[i][1]] = w.getWord().charAt(i);}} //fill board with words
        for(int i=0; i< brd.length;i++)
            for (int j=0; j<brd[0].length;j++)
                if(brd[i][j] == '\0') { //if board is empty, fill with random capitalized letters
                    brd[i][j] = (char) ('A' + new Random().nextInt(26));} //random letter
        return brd;}

    //checks if word is possible to add to board, helping method checkList
    private boolean checkIfWordPossible(char[][] board, Word w){ //check if word is possible
            int[][] coordinates = w.getCoordinates();
            for(int[] coordinate: coordinates){ //check if coordinates are inside board
                if(coordinate[0] < 0 || coordinate[0] >= board.length ||
                        coordinate[1] < 0 || coordinate[1] >= board[0].length)
                    return false;}
            for(int i=0; i<coordinates.length; i++){ //check if coordinates are empty or have the same letter
                if(board[coordinates[i][0]][coordinates[i][1]] != ' ' &&
                        board[coordinates[i][0]][coordinates[i][1]] != w.getWord().charAt(i))
                    return false;}
            return true;}

    /**These 6 methods check for the word
     * if it is present, removes the word from the wordlist and returns true
     * Else, returns false*/

    //Main coordinator method
    //checks if word is present in the board
    //if so, removes the word from the list and returns true
    public boolean wordCheck(String word, int[][] positions){
        if(checkWordCoordinator(word,positions)){
            words.remove(checkWordPresent(word));
            return true;}
        return false;}

    //checks if the word is present in the matrix of the board
    //respecting every position of the word
    //if so, return true
    private boolean checkWordCoordinator(String word, int[][] positions){
        int[] direction = makeDirection(positions[1], positions[0]);
        positions = makePositions(positions[0], direction, word.length());
        Word wrd = checkWordPresent(word);
        return checkWordPositions(wrd, positions);}

    //checks if word is present in the wordlist
    //if so, return the word itself
    public Word checkWordPresent(String word){
        for(Word w: words){
            if(w.getWord().equals(word)){
                return w;}}
        return null;}

    //given the word and its coordinates, checks if the coordinates are the same as the word's
    private boolean checkWordPositions(Word word, int[][] positions){
        int[][] coordinates = word.getCoordinates();
        for(int i=0; i<coordinates.length; i++){
            if(coordinates[i][0] != positions[i][0] || coordinates[i][1] != positions[i][1])
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

    /**Print Board*/
    public void printBoard(){
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + " ");}
            System.out.println();}}



}
