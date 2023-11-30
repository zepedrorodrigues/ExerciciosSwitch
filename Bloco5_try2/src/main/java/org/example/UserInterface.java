package org.example;
import java.util.Arrays;
import java.util.Scanner;
public class UserInterface {
    private Board board;
    private String[] wordsFound;
    private int score;
    public UserInterface(Board board){
        this.board = board;
        this.wordsFound = new String[0];
        this.score = 0;}

    public void foundWord(Word word){
        this.score += word.getSize();
        this.wordsFound = addWord(this.wordsFound, word.getWord());
        board.removeWordfromWords(word);}

    private String[] addWord(String[] words, String word){
        words = Arrays.copyOf(words, words.length+1);
        words[words.length-1] = word;
        return words;}

    public String askWord(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a word: ");
        String word = scanner.nextLine();
        return word;}
}

    /** public void printBoard(){
        char[][] board = this.board.getBoard();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();}} */