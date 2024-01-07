package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {
    @Test
    void getWordValid() {
        //Arrange
        String word = "word";
        int[][] coordinates = {{0,0},{0,1},{0,2},{0,3}};
        Word wordObj = new Word(word, coordinates);
        //Act
        String result = wordObj.getWord();
        //Assert
        assertEquals(word, result);}
    @Test
    void getWordFalse(){
        //Arrange
        String word = "word";
        int[][] coordinates = {{0,0},{0,1},{0,2},{0,3}};
        Word wordObj = new Word(word, coordinates);
        //Act
        String result = wordObj.getWord();
        //Assert
        assertNotEquals("notword", result);}


    @Test
    void getCoordinates() {
        //Arrange
        String word = "word";
        int[][] coordinates = {{0,0},{0,1},{0,2},{0,3}};
        Word wordObj = new Word(word, coordinates);
        //Act
        int[][] result = wordObj.getCoordinates();
        //Assert
        assertEquals(coordinates, result);}

    @Test
    void getCoordinatesFalse() {
        //Arrange
        String word = "word";
        int[][] coordinates = {{0,0},{0,1},{0,2},{0,3}};
        int[][] coordinates2 = {{9,0},{9,1},{9,2},{9,3}};
        Word wordObj = new Word(word, coordinates);
        //Act
        int[][] result = wordObj.getCoordinates();
        //Assert
        assertNotEquals(result, coordinates2);}

}