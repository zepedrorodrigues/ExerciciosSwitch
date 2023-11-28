package org.example;
import java.util.List;

public class gameBoard { //definir condições do board
    private char[][] board;
    private List <String> wordList;
    public gameBoard(char[][] board, List <String> wordList) {
        this.board = deepCopy(board);
        this.wordList = wordList;}
    private char[][] deepCopy(char[][]board){
        char[][] copy = new char[board.length][];
        for(int i=0;i<board.length;i++){
            copy[i]=board[i].clone();}
        return copy;}
    public boolean checkWord(String word) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(word)) {
                return true;}}
        return false;}
    public boolean checkPositions(String word, int[]initialpos, int[]finalpos){
        word word1 = new word(word);
        if(word1.initialPosition()!=initialpos || word1.finalPosition()!=finalpos ||
                word1.getDirection()!=word1.direction(initialpos,finalpos))
            return false;
        return true;}






}
