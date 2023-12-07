package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void validAdd() {
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        board1.validAdd(0,0,1);
        //Assert
        assertEquals(1, board1.getValuebyIndex(0,0));
        assertEquals(2, board1.getMaskbyIndex(0,0));}
    @Test
    void validAddInvalidLineoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(-1,0,1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validAddInvalidLineoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(9,0,1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validAddInvalidColumnoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(0,-1,1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validAddInvalidColumnoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(0,9,1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validAddInvalidValueoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(0,0,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validAddInvalidValueoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validAdd(0,0,10));
        assertTrue(exc.getMessage().contains("Invalid move"));}


    @org.junit.jupiter.api.Test
    void validRemove() {
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0},
                {0, 8, 0, 0, 0, 7, 0, 9, 0},
                {6, 0, 2, 0, 0, 0, 5, 0, 0},
                {0, 7, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 4, 0},
                {0, 0, 5, 0, 0, 0, 6, 0, 3},
                {0, 9, 0, 4, 0, 0, 0, 7, 0},
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};
        Board board1 = new Board(board);
        board1.validAdd(0,0,1);
        board1.validRemove(0,0);
        //Assert
        assertEquals(0, board1.getValuebyIndex(0,0));
        assertEquals(0, board1.getMaskbyIndex(0,0));}
    @Test
    void validRemoveInvalidLineoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0}, //0
                {0, 8, 0, 0, 0, 7, 0, 9, 0}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validRemove(-1,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validRemoveInvalidLineoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0}, //0
                {0, 8, 0, 0, 0, 7, 0, 9, 0}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validRemove(9,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validRemoveInvalidColumnoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0}, //0
                {0, 8, 0, 0, 0, 7, 0, 9, 0}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validRemove(0,-1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void validRemoveInvalidColumnoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 2, 0}, //0
                {0, 8, 0, 0, 0, 7, 0, 9, 0}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.validRemove(0,9));
        assertTrue(exc.getMessage().contains("Invalid move"));}


    @Test
    void getMaskbyIndexValid() {
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 2, 3}, //0
                {0, 8, 0, 0, 0, 7, 4, 9, 5}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        assertEquals(1, board1.getMaskbyIndex(0,6));
        assertEquals(1, board1.getMaskbyIndex(1,6));
        assertEquals(1, board1.getMaskbyIndex(2,6));
        assertEquals(0, board1.getMaskbyIndex(1,0));
        assertEquals(1, board1.getMaskbyIndex(1,8));}

    @Test
    void getMaskbyIndexInvalidLineoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 2, 3}, //0
                {0, 8, 0, 0, 0, 7, 4, 9, 5}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getMaskbyIndex(-1,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void getMaskbyIndexInvalidLineoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 2, 3}, //0
                {0, 8, 0, 0, 0, 7, 4, 9, 5}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getMaskbyIndex(9,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}

    @Test
    void getMaskbyIndexInvalidColumnoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 2, 3}, //0
                {0, 8, 0, 0, 0, 7, 4, 9, 5}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getMaskbyIndex(0,-1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void getMaskbyIndexInvalidColumnoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 2, 3}, //0
                {0, 8, 0, 0, 0, 7, 4, 9, 5}, //1
                {6, 0, 2, 0, 0, 0, 5, 0, 0}, //2
                {0, 7, 0, 0, 6, 0, 0, 0, 0}, //3
                {0, 0, 0, 9, 0, 1, 0, 0, 0}, //4
                {0, 0, 0, 0, 2, 0, 0, 4, 0}, //5
                {0, 0, 5, 0, 0, 0, 6, 0, 3}, //6
                {0, 9, 0, 4, 0, 0, 0, 7, 0}, //7
                {0, 4, 0, 0, 0, 0, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getMaskbyIndex(0,9));
        assertTrue(exc.getMessage().contains("Invalid move"));}


    @Test
    void getValuebyIndex() {
        //Arrange
        int[][] board = new int[][]{
                {1, 2, 3, 4, 5, 6, 0, 0, 0}, //0
                {4, 5, 6, 7, 8, 9, 0, 0, 0}, //1
                {7, 8, 9, 1, 2, 3, 0, 0, 0}, //2
                {2, 3, 1, 5, 6, 4, 0, 0, 0}, //3
                {5, 6, 4, 8, 9, 7, 0, 0, 0}, //4
                {8, 9, 7, 2, 3, 1, 0, 0, 0}, //5
                {3, 1, 2, 6, 4, 5, 0, 0, 0}, //6
                {6, 4, 5, 9, 7, 8, 0, 0, 0}, //7
                {9, 7, 8, 3, 1, 2, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        assertEquals(1, board1.getValuebyIndex(0,0));
        assertEquals(2, board1.getValuebyIndex(0,1));
        assertEquals(3, board1.getValuebyIndex(0,2));
        assertEquals(4, board1.getValuebyIndex(0,3));
        assertEquals(5, board1.getValuebyIndex(0,4));
        assertEquals(6, board1.getValuebyIndex(0,5));
        assertEquals(0, board1.getValuebyIndex(0,6));
        assertEquals(0, board1.getValuebyIndex(0,7));
        assertEquals(0, board1.getValuebyIndex(0,8));
        assertEquals(4, board1.getValuebyIndex(1,0));
        assertEquals(5, board1.getValuebyIndex(1,1));
        assertEquals(6, board1.getValuebyIndex(1,2));
        assertEquals(7, board1.getValuebyIndex(1,3));}

    @Test
    void getValuebyIndexInvalidLineoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {1, 2, 3, 4, 5, 6, 0, 0, 0}, //0
                {4, 5, 6, 7, 8, 9, 0, 0, 0}, //1
                {7, 8, 9, 1, 2, 3, 0, 0, 0}, //2
                {2, 3, 1, 5, 6, 4, 0, 0, 0}, //3
                {5, 6, 4, 8, 9, 7, 0, 0, 0}, //4
                {8, 9, 7, 2, 3, 1, 0, 0, 0}, //5
                {3, 1, 2, 6, 4, 5, 0, 0, 0}, //6
                {6, 4, 5, 9, 7, 8, 0, 0, 0}, //7
                {9, 7, 8, 3, 1, 2, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getValuebyIndex(-1,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void getValuebyIndexInvalidLineoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {1, 2, 3, 4, 5, 6, 0, 0, 0}, //0
                {4, 5, 6, 7, 8, 9, 0, 0, 0}, //1
                {7, 8, 9, 1, 2, 3, 0, 0, 0}, //2
                {2, 3, 1, 5, 6, 4, 0, 0, 0}, //3
                {5, 6, 4, 8, 9, 7, 0, 0, 0}, //4
                {8, 9, 7, 2, 3, 1, 0, 0, 0}, //5
                {3, 1, 2, 6, 4, 5, 0, 0, 0}, //6
                {6, 4, 5, 9, 7, 8, 0, 0, 0}, //7
                {9, 7, 8, 3, 1, 2, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getValuebyIndex(9,0));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void getValuebyIndexInvalidColumnoutofRange(){
        //Arrange
        int[][] board = new int[][]{
                {1, 2, 3, 4, 5, 6, 0, 0, 0}, //0
                {4, 5, 6, 7, 8, 9, 0, 0, 0}, //1
                {7, 8, 9, 1, 2, 3, 0, 0, 0}, //2
                {2, 3, 1, 5, 6, 4, 0, 0, 0}, //3
                {5, 6, 4, 8, 9, 7, 0, 0, 0}, //4
                {8, 9, 7, 2, 3, 1, 0, 0, 0}, //5
                {3, 1, 2, 6, 4, 5, 0, 0, 0}, //6
                {6, 4, 5, 9, 7, 8, 0, 0, 0}, //7
                {9, 7, 8, 3, 1, 2, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getValuebyIndex(0,-1));
        assertTrue(exc.getMessage().contains("Invalid move"));}
    @Test
    void getValuebyIndexInvalidColumnoutofRange2(){
        //Arrange
        int[][] board = new int[][]{
                {1, 2, 3, 4, 5, 6, 0, 0, 0}, //0
                {4, 5, 6, 7, 8, 9, 0, 0, 0}, //1
                {7, 8, 9, 1, 2, 3, 0, 0, 0}, //2
                {2, 3, 1, 5, 6, 4, 0, 0, 0}, //3
                {5, 6, 4, 8, 9, 7, 0, 0, 0}, //4
                {8, 9, 7, 2, 3, 1, 0, 0, 0}, //5
                {3, 1, 2, 6, 4, 5, 0, 0, 0}, //6
                {6, 4, 5, 9, 7, 8, 0, 0, 0}, //7
                {9, 7, 8, 3, 1, 2, 0, 0, 0}};//8
        Board board1 = new Board(board);
        //Act
        //Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () ->
                board1.getValuebyIndex(0,9));
        assertTrue(exc.getMessage().contains("Invalid move"));}
}