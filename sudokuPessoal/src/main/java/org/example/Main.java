package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {1, 3, 4, 5, 6, 7, 8, 2, 9},
                {5, 8, 6, 1, 3, 2, 7, 9, 4},
                {6, 7, 2, 8, 9, 4, 5, 3, 1},
                {0, 7, 0, 0, 6, 0, 0, 0, 8},
                {0, 0, 0, 9, 0, 1, 0, 0, 5},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 1},
                {0, 4, 0, 0, 1, 3, 2, 5, 6}};
        GameLogics game = new GameLogics(board);
        game.play();}

}