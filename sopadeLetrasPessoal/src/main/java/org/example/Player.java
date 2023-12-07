package org.example;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
public class Player {
    List<Word> wordList;
    Scanner n = new Scanner(System.in); //Scanner to get user input
    // Initializes an instante n of the Class Scanner
    public Player(){
        this.wordList = new ArrayList<Word>();}
        // Empty Constructor because we don't need to initialize anything
        //We just need the player to have methods to make plays

    public int[][] playerInput() {//retrieves player input to make the plays
        int[][] playerInput = new int[2][2];
        for(int i=0;i<2;i++) {
            System.out.println("Column: ");
            try {
                int start = n.nextInt();
                playerInput[i][0] = start;
                return getRow(playerInput, i);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                n.next();
            }} // discard the invalid input
        return playerInput;}

    private int[][] getRow (int[][]playerInput ,int i){
        System.out.println("Row: ");
        try {
            int end = n.nextInt();
            playerInput[i][1] = end;
            return playerInput;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            n.next();} // discard the invalid input
        return playerInput;}
    public void addWord(Word word){
        wordList.add(word);}

    public List<Word> returnWordList(){
        return wordList;}

}
