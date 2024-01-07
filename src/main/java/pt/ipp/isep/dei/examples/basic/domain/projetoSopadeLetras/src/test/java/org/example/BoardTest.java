package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BoardTest {

    @Test
    void constructorInvalidNullList()throws NullPointerException{
        //Arrange
        List<Word> wordList = null;
        //Act
        //Assert
        NullPointerException exc = assertThrows(NullPointerException.class,
                () -> new Board(wordList));
        assertTrue(exc.getMessage().contains("Wordlist is null"));}
    @Test
    void constructorValid(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(2, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{0,0},{0,3}}));
        assertTrue(board.wordCheck("ENYA", new int[][]{{0,1},{3,1}}));
        for(int i =0;i<10;i++)
            for(int j=0;j<10;j++)
                if(i==0 && j==0)
                    assertEquals('T', board.getIndexRowColumn(i,j));
                else if(i==0 && j==1)
                    assertEquals('E', board.getIndexRowColumn(i,j));
                else if(i==0 && j==2)
                    assertEquals('S', board.getIndexRowColumn(i,j));
                else if(i==0 && j==3)
                    assertEquals('T', board.getIndexRowColumn(i,j));
                else if(i==1 && j==1)
                    assertEquals('N', board.getIndexRowColumn(i,j));
                else if(i==2 && j==1)
                    assertEquals('Y', board.getIndexRowColumn(i,j));
                else if(i==3 && j==1)
                    assertEquals('A', board.getIndexRowColumn(i,j));
                else
                    assertNotEquals('\0', board.getIndexRowColumn(i,j));}

    @Test
    void constructorInvalidEmptyWordList()throws IllegalArgumentException{
        //Arrange
        List<Word> wordList = new ArrayList<>();
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(wordList));}

    @Test
    void constructorInvalidNullWordList()throws NullPointerException{
        //Arrange
        List<Word> wordList = null;
        //Act
        //Assert
        assertThrows(NullPointerException.class, () -> new Board(wordList));}

    @Test
    void constructorValidWordImpossibletoInputOverLapLetters(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        Word word3 = new Word("POSTS", new int[][]{{0,0},{0,1},{0,2},{0,3},{0,4}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        wordList.add(word3); //this word is impossible to input
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(2, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{0,0},{0,3}}));
        assertTrue(board.wordCheck("ENYA", new int[][]{{0,1},{3,1}}));
        assertFalse(board.wordCheck("POSTS", new int[][]{{0,0},{0,4}}));}

    @Test
    void constructorValidWithWordImpossibletoInputLengthOfCoordinatesDifferfromWord(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        Word word3 = new Word("POSTS", new int[][]{{0,0},{0,1},{0,2},{0,3},{0,4},{0,5}}); //length of coordinates differ from word
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        wordList.add(word3); //this word is impossible to input
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(2, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{0,0},{0,3}}));
        assertTrue(board.wordCheck("ENYA", new int[][]{{0,1},{3,1}}));
        assertFalse(board.wordCheck("POSTS", new int[][]{{0,0},{0,5}}));}

    @Test
    void constructorValidWordImpossibletoInputOverTheLimits(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{8,1},{9,1},{10,1},{11,1}}); //Out of bounds
        Word word3 = new Word("TESTS", new int[][]{{-1,6},{0,7},{0,8},{0,9},{0,10}}); //Out of bounds and Negative
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2); //this word is impossible to input
        wordList.add(word3); //this word is impossible to input
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(1, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{0,0},{0,3}}));
        assertFalse(board.wordCheck("ENYA", new int[][]{{8,1},{11,1}}));
        assertFalse(board.wordCheck("TESTS", new int[][]{{-1,6},{0,10}}));}

    @Test
    void constructorValidWordPossibleEndsinRowZeroColumnNine(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,6},{0,7},{0,8},{0,9}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        Word word3 = new Word("TESTS", new int[][]{{0,0},{0,1},{0,2},{0,3},{0,4}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        wordList.add(word3); //this word is possible to input
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(3, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{0,6},{0,9}}));
        assertTrue(board.wordCheck("ENYA", new int[][]{{0,1},{3,1}}));
        assertTrue(board.wordCheck("TESTS", new int[][]{{0,0},{0,4}}));}

    @Test
    void constructorValidWordEndsInRowNine(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{9,6},{9,7},{9,8},{9,9}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        Word word3 = new Word("TESTS", new int[][]{{0,0},{0,1},{0,2},{0,3},{0,4}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        wordList.add(word3); //this word is possible to input
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(3, board.getWordListSize());
        assertTrue(board.wordCheck("TEST", new int[][]{{9,6},{9,9}}));
        assertTrue(board.wordCheck("ENYA", new int[][]{{0,1},{3,1}}));
        assertTrue(board.wordCheck("TESTS", new int[][]{{0,0},{0,4}}));}
    @Test
    void wordCheckValid() {
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertTrue(board.wordCheck("TEST", new int[][]{{0,0},{0,3}}));}
    @Test
    void wordCheckFalseWordPresentWrongPositions() {
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("TEST", new int[][]{{0,0},{0,2}}));}

    @Test
    void wordCheckFalseWordAbsentRightPositions() {
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("REST", new int[][]{{0,0},{0,3}}));}

    @Test
    void wordCheckFalseWordGoesOutOfRange(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("TEST", new int[][]{{0,-1},{0,0},{0,1},{0,2}}));}

    @Test
    void wordCheckFalseWordGoesOutOfRangeColumn11(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,6},{0,7},{0,8},{0,9}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("TESTS", new int[][]{{0,7},{0,8},{0,9},{0,10},{0,11}}));}

    @Test
    void wordCheckFalseWordGoesOutOfRangeRowMinusOne(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,6},{0,7},{0,8},{0,9}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("TESTS", new int[][]{{-1,0},{-1,1},{-1,2},{-1,3},{-1,4}}));}

    @Test
    void wordCheckFalseWordGoesOutOfRangeRow10(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,6},{0,7},{0,8},{0,9}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertFalse(board.wordCheck("TESTS", new int[][]{{10,0},{10,1},{10,2},{10,3},{10,4}}));}

    @Test
    void getWordListSize() {
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("ENYA", new int[][]{{0,1},{1,1},{2,1},{3,1}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        wordList.add(word2);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals(2, board.getWordListSize());}

    @Test
    void getIndexRowColumnValid(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertEquals('T', board.getIndexRowColumn(0,0));
        assertEquals('E', board.getIndexRowColumn(0,1));
        assertEquals('S', board.getIndexRowColumn(0,2));
        assertEquals('T', board.getIndexRowColumn(0,3));}

    @Test
    void getIndexRowColumnInvalid(){
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertNotEquals('P', board.getIndexRowColumn(0,0));
        assertNotEquals('O', board.getIndexRowColumn(0,1));
        assertNotEquals('N', board.getIndexRowColumn(0,2));
        assertNotEquals('D', board.getIndexRowColumn(0,3));}

    @Test
    void getIndexRowColumnOverBoundsColumn11()throws IndexOutOfBoundsException{
        //Arrange
        Word word = new Word("TEST", new int[][]{{0,6},{0,7},{0,8},{0,9}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word);
        //Act
        Board board = new Board(wordList);
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () -> board.getIndexRowColumn(0,10));
        assertThrows(IndexOutOfBoundsException.class, () -> board.getIndexRowColumn(0,-1));}
}