package org.example;

public class word {
    String word;
    int[][] positions;
    int[] direction;
    int size;
    public word(String word) {
        this.word = word;
        this.size = word.length();
        this.direction = direction(initialPosition(),finalPosition());
        this.positions = createPositions(initialPosition(),finalPosition(),direction);}
    public int[] initialPosition() {
        return positions[0];}
    public int[] finalPosition() {
        return positions[positions.length - 1];}
    public String getWord() {
        return word;}
    public int getSize() {
        return size;}
    public int[] getDirection() {
        return direction;}
    public int[] direction(int[] posA, int[] posB) {
            int[]direction = {posB[0]-posA[0],posB[1]-posA[1]};
            if(direction[0]!=0)
                direction[0]=direction[0]/Math.abs(direction[0]);
            if(direction[1]!=0)
                direction[1]=direction[1]/Math.abs(direction[1]);
            return direction;}
    private int[][] createPositions(int[] initialpos, int[] finalpos, int[] direction) {
        int[][] positions = new int[size][2];
        positions[0] = initialpos;
        for (int i = 1; i < size; i++) {
            positions[i][0] = positions[i - 1][0] + direction[0];
            positions[i][1] = positions[i - 1][1] + direction[1];}
        return positions;}
    private char[] wordtoChar() {
        char[] wordtoChar = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordtoChar[i] = word.charAt(i);}
        return wordtoChar;}

    }