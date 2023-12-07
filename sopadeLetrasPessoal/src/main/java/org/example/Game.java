package org.example;
import java.util.ArrayList;
import java.util.List;
public class Game {
    private Board board;
    private List<Word> wordList;
    private Player player;
    public Game(char[][] board, List<Word> wordList){
        this.board = new Board(board, wordList); //ALTERA DE BOARD DE FORMA A QUE RECEBA A LISTA DE WORDS
        this.wordList = deepClone(wordList);
        this.player = new Player();}

    private List<Word> deepClone(List<Word> wordList){
        List<Word> clone = new ArrayList<>();
        clone.addAll(wordList);
        return clone;}
    public boolean checkWordCoordinator(){
        String wordNew = player.playerAskWord();
        if(checkWord(wordNew)!= null) {
            Word wrd = checkWord(wordNew);
            int[][] wrdCoordinates = wrd.getCoordinates(); //get coordinates of word
            int[] direction = wrd.getDirection(); //get direction vector
            int[][] playerInput = player.playerInput(); //get player input
            int[] directionPlayer = makeDirection(playerInput);//get direction vector
            return checkConditions(wrdCoordinates, direction, playerInput, directionPlayer);}
        return false;}
    private Word checkWord(String word){
        for(Word w: wordList){
            if(w.getWord().equals(word)){
                return w;}}
        return null;}
    private int[] makeDirection(int[][] playerInput){
        int[] direction = new int[2];
        direction[0] = playerInput[1][0] - playerInput[0][0];
        direction[1] = playerInput[1][1] - playerInput[0][1];
        if(direction[0] !=0)
            direction[0] = direction[0]/Math.abs(direction[0]);
        if(direction[1] !=0)
            direction[1] = direction[1]/Math.abs(direction[1]);
        return direction;}
    private boolean checkConditions(int[][] wrdCoordinates, int[] direction, int[][] playerInput, int[] directionPlayer){
        return direction[0] == directionPlayer[0] && direction[1] == directionPlayer[1] &&
                //check if direction of word is the same as direction of player input
                wrdCoordinates[0][0]==playerInput[0][0] &&
                //check if first coordinate of word is the same as first coordinate of player
                wrdCoordinates[0][1]==playerInput[0][1] &&
                //check if second coordinate of word is the same as second coordinate of player
                wrdCoordinates[wrdCoordinates.length - 1][0] == playerInput[1][0] &&
                //check if last coordinate of word is the same as last coordinate of player
                wrdCoordinates[wrdCoordinates.length - 1][1] == playerInput[1][1];}
    //check if second to last coordinate of word is the same as second to last coordinate of player

    public void newgame(){
        while(List<Word>.length>0)

    }

}
