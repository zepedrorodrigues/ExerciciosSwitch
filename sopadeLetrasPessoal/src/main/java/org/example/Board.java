package org.example;
public class Board {
    private char[][] board; //board of letters
    public Board(char[][] board){ //constructor
        for (char[] chars : board)
            if (chars.length != board.length)
                throw new IllegalArgumentException("Board must be square.");
        //check if board is square
        this.board = deepClone(board);}
    private char[][] deepClone(char[][] board){ //deep clone of board
        char[][] clone = new char[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            System.arraycopy(board[i], 0, clone[i], 0, board[0].length);}
        return clone;}
    public String toString(){

    }

}
