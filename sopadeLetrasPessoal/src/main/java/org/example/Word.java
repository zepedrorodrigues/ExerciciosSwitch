package org.example;

public class Word {
    private String word; //word to be found
    private int[][] coordinates; //coordinates of start and end of word
    private int[] direction; //direction vector of word
    public Word(String word, int[][]coordinates){ //constructor
        this.word = word;
        this.coordinates = coordinates;
        this.direction = makeDirection(coordinates[1], coordinates[0]);}
    private int[] makeDirection(int[] end, int[] start){ //makes direction vector
        int[] direct = new int[2];
        direct[0] = end[0] - start[0];
        direct[1] = end[1] - start[1];
        return direct;}
    public String getWord(){ //getter String of word
        return word;}
    public int[] getDirection(){ //getter direction vector
        return direction;}
    public int[][] getCoordinates(){ //getter coordinates
        return coordinates;}

}
