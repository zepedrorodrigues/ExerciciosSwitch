package org.example;
import java.util.List;
public class Game {
    private Board board;
    public Game(List<Word> wordList){
        this.board = new Board(wordList);}
    //check if all words are found
    //if so, return true
    public boolean checkWin(){
        return board.getWordListSize() == 0;}
    //check if word is in the board
    //if so, remove word from list
    //if not, return false
    public boolean findWord(String word, int[][] positions){
        return board.wordCheck(word,positions);}
}
