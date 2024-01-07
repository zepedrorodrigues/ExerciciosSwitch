package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void checkWinValid() {
        //Arrange
        Word word1 = new Word("word", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("world", new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word1);
        wordList.add(word2);
        Game game = new Game(wordList);
        game.findWord("word", new int[][]{{0,0},{0,3}});
        game.findWord("world", new int[][]{{0,0},{4,0}});
        assertTrue(game.checkWin());}
    @Test
    void checkWinFalse() {
        //Arrange
        Word word1 = new Word("word", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("world", new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word1);
        wordList.add(word2);
        Game game = new Game(wordList);
        game.findWord("word", new int[][]{{0,0},{0,3}});
        assertFalse(game.checkWin());}

    @Test
    void findWordValid() {
        //Arrange
        Word word1 = new Word("word", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("world", new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word1);
        wordList.add(word2);
        Game game = new Game(wordList);
        assertTrue(game.findWord("word", new int[][]{{0,0},{0,3}}));}

    @Test
    void findWordNotPresent(){
        //Arrange
        Word word1 = new Word("word", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("world", new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word1);
        wordList.add(word2);
        Game game = new Game(wordList);
        assertFalse(game.findWord("notpresent", new int[][]{{0,0},{0,3}}));}

    @Test
    void findWordAfterBeingRemoved(){
        //Arrange
        Word word1 = new Word("word", new int[][]{{0,0},{0,1},{0,2},{0,3}});
        Word word2 = new Word("world", new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}});
        List<Word> wordList = new ArrayList<>();
        wordList.add(word1);
        wordList.add(word2);
        Game game = new Game(wordList);
        game.findWord("word", new int[][]{{0,0},{0,3}});
        assertFalse(game.findWord("word", new int[][]{{0,0},{0,3}}));}
}