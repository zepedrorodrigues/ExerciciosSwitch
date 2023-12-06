package org.example;
public class Board {
    private int[][] board;
    private int[][] matrizMascara;
    public Board(int[][] board){
        this.board = deepCopy(board);
        this.matrizMascara = createMaskMatrix(board);}

    private int[][] deepCopy(int[][] original) {
        final int[][] result = new int[original.length][original.length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++)
                result[i][j] = original[i][j];}
        return result;}

    private int[][] createMaskMatrix(int[][] board) {
        int size = board.length;
        int[][] mask = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0)
                    mask[i][j] = 0;
                else
                    mask[i][j] = 1;}}
        return mask;}
    public void validAdd(int line, int column, int value){
        matrizMascara[line][column] = 2;
        board[line][column] = value;}
    public void validRemove(int line, int column){
        matrizMascara[line][column] = 0;
        board[line][column] = 0;}

    public int getMaskbyIndex(int line, int column){
        return matrizMascara[line][column];}

    public int getValuebyIndex(int line, int column){
        return board[line][column];}

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" -----------------------");}
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("| ");}
                System.out.print(board[i][j] == 0 ? "  " : board[i][j] + " ");}
            System.out.println("|");}
        System.out.println(" -----------------------");
    }
}



