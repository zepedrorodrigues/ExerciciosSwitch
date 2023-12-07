package org.example;
import java.util.List;
public class Board {
    private Player player; //player
    private char[][] board; //board of letters
    private List<Word> wordList; //list of words to be found
    public Board(List<Word> wordList, char[][] board){ //constructor
        for (char[] chars : board)
            if (chars.length != board.length)
                throw new IllegalArgumentException("Board must be square.");
        //check if board is square
        this.board = deepClone(board);
        this.wordList = wordList;
        this.player = new Player();}
    private char[][] deepClone(char[][] board){
        char[][] clone = new char[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            System.arraycopy(board[i], 0, clone[i], 0, board[0].length);
        }
        return clone;}

    public boolean checkWordCoordinator(String word){
        String wordNew = word.toUpperCase();
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
                        wrdCoordinates[wrdCoordinates.length - 1][1] == playerInput[1][1];
                    //check if second to last coordinate of word is the same as second to last coordinate of player
    }

}
