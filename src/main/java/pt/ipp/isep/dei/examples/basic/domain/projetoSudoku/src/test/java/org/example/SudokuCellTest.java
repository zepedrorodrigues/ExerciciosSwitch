package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuCellTest {
    @Test
    void testSudokuCell() {
        //Arrange and Act
        SudokuCell cell = new SudokuCell();
        //Assert
        assertEquals(0, cell.getValue());
        assertTrue(cell.isEditable());
    }

    @Test
    void testSetNotEditable() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        //Act
        cell.setNotEditable();
        //Assert
        assertFalse(cell.isEditable());
    }

    @Test
    void testIsEditableTrue() {
        //Arrange and Act
        SudokuCell cell = new SudokuCell();
        //Assert
        assertTrue(cell.isEditable());
    }

    @Test
    void testIsEditableFalse() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        //Act
        cell.setNotEditable();
        //Assert
        assertFalse(cell.isEditable());
    }

    @Test
    void testSetAndGetValueZero() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        int exp = 0;
        //Act
        cell.setValue(0);
        int res = cell.getValue();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testSetAndGetValueOne() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        int exp = 1;
        //Act
        cell.setValue(1);
        int res = cell.getValue();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testIsEmptyTrue() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        //Act
        boolean res = cell.isEmpty();
        //Assert
        assertTrue(res);
    }

    @Test
    void testIsEmptyFalse() {
        //Arrange
        SudokuCell cell = new SudokuCell();
        //Act
        cell.setValue(1);
        boolean res = cell.isEmpty();
        //Assert
        assertFalse(res);
    }
}