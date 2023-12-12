package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void createMaskMatrixValue9() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        Board b = new Board(board);
        //Act
        int[][] mask = b.createMaskMatrixValue(9);
        //Assert
        assertEquals(1, mask[0][0]);
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if(i==0&&j==0)
                    continue;
                assertEquals(0, mask[i][j]);}}}

    @Test
    void createMaskMartrixValue3NonExistant(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        int[][] mask = b.createMaskMatrixValue(3);
        //Assert
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                assertEquals(0, mask[i][j]);}}}

    @Test
    void createMatrixMaskValue1(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 1;
        Board b = new Board(board);
        //Act
        int[][] mask = b.createMaskMatrixValue(1);
        //Assert
        assertEquals(1, mask[0][0]);
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if(i==0&&j==0)
                    continue;
                assertEquals(0, mask[i][j]);}}}

    @Test
    void createMatrixMaskValue9(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        Board b = new Board(board);
        //Act
        int[][] mask = b.createMaskMatrixValue(9);
        //Assert
        assertEquals(1, mask[0][0]);
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if(i==0&&j==0)
                    continue;
                assertEquals(0, mask[i][j]);}}}

    @Test
    void createMaskMatrixValueInvalid0(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> b.createMaskMatrixValue(0));}

    @Test
    void createMaskMatrixValueInvalid10(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> b.createMaskMatrixValue(10));}

    @Test
    void getMaskMatrixValid() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][2] = 3;
        board[3][5] = 6;
        //Act
        Board b = new Board(board);
        int[][] mask = b.getMaskMatrix();
        //Assert
        assertEquals(1, mask[0][0]);
        assertEquals(1, mask[0][2]);
        assertEquals(1, mask[3][5]);
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                if((i==0&&j==0)||(i==0&&j==2)||(i==3&&j==5))
                    continue;
                assertEquals(0, mask[i][j]);}}}

    @Test
    void addValueValid() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertTrue(b.addValue(0,1,3));}

    @Test
    void addValueValidValue1(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertTrue(b.addValue(0,1,1));}

    @Test
    void addValueValidValue9(){
        //Arrange
        int[][] board = new int[9][9];
        //Act
        Board b = new Board(board);
        //Assert
        assertTrue(b.addValue(0,1,9));}

    @Test
    void addValueValidinLine0ColumnZero(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertTrue(b.addValue(0,0,6));}

    @Test
    void addValueValidLine8Column8(){
        //Arrange
        int[][] board = new int[9][9];
        //Act
        Board b = new Board(board);
        //Assert
        assertTrue(b.addValue(8,8,3));}

    @Test
    void addValueInvalidColumn12(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,12,3));}

    @Test
    void addValueInvalidColumnMinus1(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,-1,3));}

    @Test
    void addValueInvalidLineMinus1(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(-1,0,3));}

    @Test
    void addValueInvalidLine11(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(11,0,3));}

    @Test
    void addValueInvalid12(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,0,12));}

    @Test
    void addValueInvalid0(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,0,0));}

    @Test
    void addValueNotEmpty(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        b.addValue(0,2,6);
        //Assert
        assertFalse(b.addValue(0,2,5));}

    @Test
    void addValueNotEmptyVaueFromOriginalMatrix(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,0,6));}

    @Test
    void addValueInvalidValueAlreadyExistsInLine(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[1][0] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(1,1,3));}

    @Test
    void addValueInvalidValueAlreadyExistsInLine0Column0(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,0,3));}

    @Test
    void addValueInvalidValueAlreadyExistsInLine8Column8(){
        //Arrange
        int[][] board = new int[9][9];
        board[8][7] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(8,8,3));}

    @Test
    void addValueInvalidValueAlreadyExistsinColumnLine8Column8(){
        //Arrange
        int[][] board = new int[9][9];
        board[7][8] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(8,8,3));}

    @Test
    void addValueInvalidValueAlreadyExistisInSquareLine0Column0(){
        //Arrange
        int[][] board = new int[9][9];
        board[1][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(0,0,3));}

    @Test
    void addValueInvalidValueAlreadyExistsInSquareLine8Column8(){
        //Arrange
        int[][] board = new int[9][9];
        board[7][7] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(8,8,3));}

    @Test
    void addValueInvalidValueAlreadyExistsInColumn(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(1,1,9));}

    @Test
    void addValueInvalidValueAlreadyExistsInSquare(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[1][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.addValue(2,2,3));}

    @Test
    void removeValueValid() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        b.addValue(0,2,4);
        //Assert
        assertTrue(b.removeValue(0,2));}

    @Test
    void removeValueValidLine8Column8(){
        //Arrange
        int[][] board = new int[9][9];
        //Act
        Board b = new Board(board);
        b.addValue(8,8,4);
        //Assert
        assertTrue(b.removeValue(8,8));}

    @Test
    void removeValueValueLine0Column0(){
        //Arrange
        int[][] board = new int[9][9];
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        b.addValue(0,0,4);
        //Assert
        assertTrue(b.removeValue(0,0));}
    @Test
    void removeValueInvalidEmptySpace() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(0,2));}

    @Test
    void removeValueInvalidInitialMatrixValue() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(0,1));}

    @Test
    void removeValueInvalidColumn12() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(0,12));}
    @Test
    void removeValueInvalidColumnMinus1() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(0,-1));}
    @Test
    void removeValueInvalidLineMinus1() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(-1,1));
    }

    @Test
    void removeValueInvalidLine11() {
        //Arrange
        int[][] board = new int[9][9];
        board[0][0] = 9;
        board[0][1] = 3;
        //Act
        Board b = new Board(board);
        //Assert
        assertFalse(b.removeValue(11,1));}
}