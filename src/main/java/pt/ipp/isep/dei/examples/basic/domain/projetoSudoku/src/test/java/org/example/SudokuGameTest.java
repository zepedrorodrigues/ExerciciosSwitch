package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuGameTest {
    @Test
    void testConstructor() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        // Act
        SudokuGame game = new SudokuGame(initialBoard);
        // Assert
        assertNotNull(game);
    }

    @Test
    void testMakeMoveSuccessLimitDown() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 0, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {0, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        boolean result = game.makeMove(0, 0, 1);
        // Assert
        assertTrue(result);
    }

    @Test
    void testMakeMoveSuccessLimitUp() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 0}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        boolean result = game.makeMove(8, 8, 9);
        // Assert
        assertTrue(result);
    }

    @Test
    void testMakeMoveFailure() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(0, 0, 0);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidRowOver() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(9, 0, 1);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidRowUnder() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(-1, 0, 1);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidColumnOver() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(8, 9, 1);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidColumnUnder() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(0, -1, 1);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidValueOver() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(0, 0, 10);
        // Assert
        assertFalse(result);
    }

    @Test
    void testMakeMoveFailureInvalidValueUnder() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5);
        // Act
        boolean result = game.makeMove(0, 0, 0);
        // Assert
        assertFalse(result);
    }

    @Test
    void testEraseCellSuccess() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        game.makeMove(0, 0, 5); // Altera o valor da célula (0,0) para 5
        // Act
        boolean res = game.eraseCell(0, 0); // Apaga o valor da célula (0,0)
        // Assert
        assertTrue(res); // Verifica se o valor da célula (0,0) voltou a ser 0
    }

    @Test
    void testEraseCellNotEditable() {
        // Arrange
        int[][] initialBoard = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        boolean res = game.eraseCell(0, 0); // Tenta apagar o valor da célula (0,0)
        // Assert
        assertFalse(res); // Verifica se o valor da célula (0,0) ainda é 5
    }


    @Test
    void testIsGameFinishedYes() {
        // Arrange
        int[][] initialBoard = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        boolean res = game.isGameFinished();
        // Assert
        assertTrue(res);
    }

    @Test
    void testIsGameFinishedNo() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        boolean res = game.isGameFinished();
        // Assert
        assertFalse(res);
    }

    @Test
    void testGetBoard() {
        // Arrange
        int[][] initialBoard = new int[9][9];
        SudokuGame game = new SudokuGame(initialBoard);
        // Act
        int[][] res = game.getBoard();
        // Assert
        assertNotNull(res);
    }

    @Test
    void testGetCellValue() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 0},
                {1, 9, 8, 3, 4, 0, 5, 6, 7},
                {8, 5, 9, 0, 6, 1, 4, 0, 3},
                {0, 2, 0, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 0, 8, 4},
                {2, 0, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 0, 2, 8, 0, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        int exp = 7;
        // Act
        int res = game.getCellValue(1, 1);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void testGetCellValueEmpty() {
        // Arrange
        int[][] initialBoard = {
                {0, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 0},
                {1, 9, 8, 3, 4, 0, 5, 6, 7},
                {8, 5, 9, 0, 6, 1, 4, 0, 3},
                {0, 2, 0, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 0, 8, 4},
                {2, 0, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 0, 2, 8, 0, 1, 7, 9}
        };
        SudokuGame game = new SudokuGame(initialBoard);
        int exp = 0;
        // Act
        int res = game.getCellValue(0, 0);
        // Assert
        assertEquals(exp, res);
    }
}