package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuBoardTest {

    @Test
    void testConstructor() {
        // Arrange
        int[][] matrix = new int[9][9];
        // Act
        SudokuBoard board = new SudokuBoard(matrix);
        // Assert
        assertNotNull(board);
    }

    @Test
    void testConstructorWithFilledMatrix() {
        // Arrange
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        int[][] result = board.getBoard();
        // Assert
        assertArrayEquals(matrix, result);
    }

    @Test
    void testConstructorWithInvalidMatrixLinesOver() {
        // Arrange
        int[][] matrix = new int[10][9];
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new SudokuBoard(matrix));
    }

    @Test
    void testConstructorWithInvalidMatrixColumnsOver() {
        // Arrange
        int[][] matrix = new int[9][10];
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new SudokuBoard(matrix));
    }

    @Test
    void testGetBoard() {
        // Arrange
        int[][] matrix = new int[9][9];
        // Act
        SudokuBoard board = new SudokuBoard(matrix);
        // Assert
        assertNotNull(board.getBoard());
    }

    @Test
    void testGetCellValue() {
        // Arrange
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        int exp = 1;
        // Act
        int res = board.getCellValue(0, 0);
        // Assert
        assertEquals(exp, res);
    }

    @Test
    void testSetCellValueValid() {
        // Arrange
        int[][] matrix = {{0, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.setCellValue(0, 0, 1);
        // Assert
        assertTrue(res);
    }

    @Test
    void testSetCellValueInvalid() {
        // Arrange
        int[][] matrix = {{0, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.setCellValue(0, 2, 1);
        // Assert
        assertFalse(res);
    }

    @Test
    void testIsValidMoveValid() {
        // Arrange
        int[][] matrix = {{0, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isValidMove(0, 0, 1);
        // Assert
        assertTrue(res);
    }

    @Test
    void testIsValidMoveInvalidRow() {
        // Arrange
        int[][] matrix = {{0, 0, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 0, 1, 0, 3},
                {0, 0, 0, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {0, 0, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {0, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isValidMove(0, 0, 9);
        // Assert
        assertFalse(res);
    }

    @Test
    void testIsValidMoveInvalidColumn() {
        // Arrange
        int[][] matrix = {{0, 0, 3, 4, 5, 6, 7, 8, 0},
                {4, 1, 6, 7, 8, 9, 0, 0, 3},
                {0, 8, 0, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 0, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isValidMove(0, 0, 9);
        // Assert
        assertFalse(res);
    }

    @Test
    void testIsValidMoveInvalidSubGrid() {
        // Arrange
        int[][] matrix = {{0, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 0},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {1, 0, 2, 3, 0, 5, 6, 7, 0}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isValidMove(8, 8, 4);
        // Assert
        assertFalse(res);
    }

    @Test
    void testIsBoardFullFalse() {
        // Arrange
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 0, 3},
                {0, 8, 9, 0, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 0, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 0, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isBoardFull();
        // Assert
        assertFalse(res);
    }

    @Test
    void testIsBoardFullTrue() {
        // Arrange
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9},
                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7, 8, 9, 1},
                {5, 6, 7, 8, 9, 1, 2, 3, 4},
                {8, 9, 1, 2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8, 9, 1, 2},
                {6, 7, 8, 9, 1, 2, 3, 4, 5},
                {9, 1, 2, 3, 4, 5, 6, 7, 8}};
        SudokuBoard board = new SudokuBoard(matrix);
        // Act
        boolean res = board.isBoardFull();
        // Assert
        assertTrue(res);
    }
}
