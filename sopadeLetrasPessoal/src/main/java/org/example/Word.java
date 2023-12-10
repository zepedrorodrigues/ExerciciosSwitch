package org.example;

public class Word {
    private String word; //word to be found
    private int[][] coordinates; //coordinates of start and end of word

    /***/
    public Word(String word, int[][]coordinates){ //constructor
        this.word = word;
        this.coordinates = coordinates;}
    public String getWord(){ //getter String of word
        return word;}
    public int[][] getCoordinates(){ //getter coordinates
        return coordinates;}

}
