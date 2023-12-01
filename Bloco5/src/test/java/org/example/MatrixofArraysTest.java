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
        Array sumLines = new Array(sumL);;
        Array sumColumns = new Array(sumC);
        assertEquals(average, matrixofArrays.average());
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));}


}