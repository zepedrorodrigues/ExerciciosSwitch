package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixofArraysTest {

    @Test
    void addNewValueValid() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        matrixofArrays.add(7, 0);
        double average = 4.0;
        int[] sumL = {13,15};
        int[] sumC = {5,7,9,7};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        assertEquals(average, matrixofArrays.average());
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));}

    @Test
    void removeFirstValue(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        matrixofArrays.removeFirstValue(2);
        double average = 19/5d;
        int[] sumL = {4,15};
        int[] sumC = {5,8,6};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        assertEquals(average, matrixofArrays.average());
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));}

    @Test
    void removeFirstValueinIndexZero(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        matrixofArrays.removeFirstValue(1);
        double average = 4.0;
        int[] sumL = {5,15};
        int[] sumC = {6,8,6};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        assertEquals(average, matrixofArrays.average());
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));}

    @Test
    void removeFirstValueEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> matrixofArrays.removeFirstValue(2));
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void removeFirstValueNonExistante()throws IllegalArgumentException{
//Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> matrixofArrays.removeFirstValue(7));
        //Assert
        assertEquals("Value not found", exception.getMessage());}
    }