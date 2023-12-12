package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testConstrutorValid()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][9];
        //Act and Assert
        Game g = new Game(board);}

    @Test
    void testConstructorInvalidBoardLength7()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[7][7];
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Game(board));
        assertEquals("Invalid board", exc.getMessage());}

    @Test
    void testConstructorInvalidBoardLength10()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[10][10];
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Game(board));
        assertEquals("Invalid board", exc.getMessage());}

    @Test
    void testConstructorInvalidBoardnotSquarelength9()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][7];
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Game(board));
        assertEquals("Invalid board", exc.getMessage());}

    @Test
    void testConstructorInvalidOneNegative()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=1;}}
        board[0][0] = -1;
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Game(board));
        assertEquals("Invalid board", exc.getMessage());}

    @Test
    void testConstructorValidAllZeros()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][9];
        //Act and Assert
        Game g = new Game(board);}

    @Test
    void testConstructorValidAllNines()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=9;}}
        //Act and Assert
        Game g = new Game(board);}

    @Test
    void testConstructorInvalidOneAbove9()throws IllegalArgumentException{
        //Arrange
        int[][] board = new int[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=1;}}
        board[0][0] = 10;
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Game(board));
        assertEquals("Invalid board", exc.getMessage());}

    @Test
    void checkWinTrue(){
        //Arrange
        int[][] board = new int[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=1;}}
        //Act
        Game g = new Game(board);
        //Assert
        assertTrue(g.checkWin());}

    @Test
    void checkWinFalse(){
        //Arrange
        int[][] board = new int[9][9];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=1;}}
        board[0][0] = 0;
        //Act
        Game g = new Game(board);
        //Assert
        assertFalse(g.checkWin());}
}