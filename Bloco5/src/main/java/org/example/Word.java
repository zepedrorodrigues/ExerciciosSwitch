package org.example;

public class Word {
    private String word;
    private int size;
    private int[][] positions;
    public Word(String word, int[][] positions){
        this.word = word;
        this.size = word.length();
        this.positions = positions;}

    public String getWord(){
        return word;}

    public int getSize(){
        return size;}
    public char[] getChars(){
        return word.toCharArray();}
    public char charAt(int i){
        return getChars()[i];}


    public static int[] direccao(int[]pontoA, int[]pontoB){
        int[]direccao = new int[2];
        direccao[0]=pontoB[0]-pontoA[0];
        direccao[1]=pontoB[1]-pontoA[1];
        if(direccao[0]!=0)
            direccao[0]=direccao[0]/Math.abs(direccao[0]);
        if(direccao[1]!=0)
            direccao[1]=direccao[1]/Math.abs(direccao[1]);
        return direccao;}
}