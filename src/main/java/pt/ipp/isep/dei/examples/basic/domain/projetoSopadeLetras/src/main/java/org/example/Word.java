package org.example;
public class Word {
    private String word;
    private int[][] coordinates;
    public Word(String word, int[][]coordinates){
        this.word = word;
        this.coordinates = coordinates;}
    public String getWord(){
        return word;}
    public int[][] getCoordinates(){
        return coordinates;}}