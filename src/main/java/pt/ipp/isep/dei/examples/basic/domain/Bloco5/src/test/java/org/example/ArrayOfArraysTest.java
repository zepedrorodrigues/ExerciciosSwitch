package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOfArraysTest {
    /**
     * alínea a.
     */
    @Test
    void constructorTestEmpty() {
        //Act
        ArrayOfArrays myArray = new ArrayOfArrays();
        //Assert
        assertEquals(0, myArray.getSize());
    }


    /**
     * alínea b.
     */
    @Test
    void constructorTestNull() throws IllegalArgumentException {
        //Arrange
        Array[] matrix = null;
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ArrayOfArrays(matrix));
        assertEquals("Null array", exception.getMessage());
    }

    @Test
    void constructorTestNoArguments() {
        //Arrange
        Array[] matrix = new Array[0];
        //Act
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Assert
        assertEquals(0, myArray.getSize());
    }


    @Test
    void constructorTest() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        int exp = 3;
        //Act
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Assert
        assertEquals(exp, myArray.getSize());
    }

    @Test
    void constructorTestNullArguments() throws IllegalArgumentException {
        //Arrange
        int[][] matrix = null;
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new ArrayOfArrays(matrix));
        assertEquals("Null array", exception.getMessage());
    }

    @Test
    void constructorTestEmptyArray() {
        //Arrange
        int[][] matrix = {};
        int exp = 0;
        //Act
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Assert
        assertEquals(exp, myArray.getSize());
    }

    /**
     * alínea c.
     */
    @Test
    void addValueValid() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{1, 2, 1});
        matrix[1] = new Array(new int[]{1, 4, 1});
        matrix[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        int value = 1;
        int line = 0;
        int[] sumLines = {5, 6, 38};
        int[] sumColumns = {5, 12, 31, 1};
        //Act
        myArray.add(value, line);
        //Assert
        assertTrue(myArray.sumLines().equalsArray(sumLines));
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
    }

    @Test
    void addValueInvalid() throws ArrayIndexOutOfBoundsException {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{1, 2, 1});
        matrix[1] = new Array(new int[]{1, 4, 1});
        matrix[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        int value = 1;
        int line = 3;
        //Act and assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> myArray.add(value, line));
        assertEquals("Index out of bounds", exception.getMessage());
    }

    /**
     * alinea d
     */

    @Test
    void removeValueValid() {
        //Arrange
        Array[] matrix = new Array[2];
        matrix[0] = new Array(new int[]{1, 2});
        matrix[1] = new Array(new int[]{1, 4});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        int value = 2;
        int[] sumLines = {1, 5};
        int[] sumColumns = {2, 4};
        //Act
        myArray.remove(value);
        //Assert
        assertTrue(myArray.sumLines().equalsArray(sumLines));
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
    }

    @Test
    void removeValueRepeatedNumbers() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{1, 1, 1});
        matrix[1] = new Array(new int[]{2, 2, 2});
        matrix[2] = new Array(new int[]{3, 3, 3});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        int value = 2;
        int[] sumLines = {3, 4, 9};
        int[] sumColumns = {6, 6, 4};
        //Act
        myArray.remove(value);
        //Assert
        assertTrue(myArray.sumLines().equalsArray(sumLines));
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
    }

    @Test
    void removeValueNotFound() throws IllegalArgumentException {
        //Arrange
        Array[] matrix = new Array[2];
        matrix[0] = new Array(new int[]{1, 2});
        matrix[1] = new Array(new int[]{1, 4});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        int value = 3;
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> myArray.remove(value));
        assertEquals("Invalid argument", exception.getMessage());
    }

    /**
     * alínea e.
     */
    @Test
    void constructorTestEmptyTrue() {
        //Arrange
        Array[] matrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        boolean res = myArray.isEmpty();
        //Assert
        assertTrue(res);
    }

    @Test
    void constructorTestEmptyFalse() {
        //Arrange
        Array[] matrix = new Array[1];
        matrix[0] = new Array(new int[]{1, 2, 3});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        boolean res = myArray.isEmpty();
        //Assert
        assertFalse(res);
    }

    /**
     * alínea i
     */
    @Test
    void sumofLinesValid() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{1, 2, 1});
        matrix[1] = new Array(new int[]{1, 4, 1});
        matrix[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        Array sumLines = new Array(new int[]{4, 6, 38});
        //Assert
        assertTrue(sumLines.equalsArray(myArray.sumLines()));
    }

    @Test
    void sumofLinesEmptyArray() throws IllegalArgumentException {
        //Arrange
        Array[] matrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::sumLines);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void sumofLineswithNegativeValuesandZero() {
        //Arrange
        Array[] matrix = new Array[4];
        matrix[0] = new Array(new int[]{1, 2, 1});
        matrix[1] = new Array(new int[]{1, 4, 1});
        matrix[2] = new Array(new int[]{3, 6, 29});
        matrix[3] = new Array(new int[]{-1, 0, -1});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        Array sumLines = new Array(new int[]{4, 6, 38, -2});
        //Assert
        assertTrue(sumLines.equalsArray(myArray.sumLines()));
    }

    /**
     * alínea f
     */

    @Test
    void largestValid() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{1, 2, 1});
        myMatrix[1] = new Array(new int[]{1, 4, 1});
        myMatrix[2] = new Array(new int[]{3, 6, 29});
        int exp = 29;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.largest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void largestEmpty() {
        //Arrange
        Array[] myMatrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::largest);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void largestNegative() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{-1, -2, -1});
        myMatrix[1] = new Array(new int[]{-1, -4, -1});
        myMatrix[2] = new Array(new int[]{-3, -6, -29});
        int exp = -1;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.largest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void largestZero() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{0, 0, 0});
        myMatrix[1] = new Array(new int[]{0, 0, 0});
        myMatrix[2] = new Array(new int[]{0, 0, 0});
        int exp = 0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.largest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void largestOneElement() {
        //Arrange
        Array[] myMatrix = new Array[1];
        myMatrix[0] = new Array(new int[]{1});
        int exp = 1;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.largest();
        //Assert
        assertEquals(exp, res);
    }

    /**
     * alínea g.
     */
    @Test
    void smallestValid() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{1, 2, 1});
        myMatrix[1] = new Array(new int[]{1, 4, 1});
        myMatrix[2] = new Array(new int[]{3, 6, 29});
        int exp = 1;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.smallest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void smallestEmpty() {
        //Arrange
        Array[] myMatrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::smallest);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void smallestNegative() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{-1, -2, -1});
        myMatrix[1] = new Array(new int[]{-1, -4, -1});
        myMatrix[2] = new Array(new int[]{-3, -6, -29});
        int exp = -29;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.smallest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void smallestZero() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{0, 0, 0});
        myMatrix[1] = new Array(new int[]{0, 0, 0});
        myMatrix[2] = new Array(new int[]{0, 0, 0});
        int exp = 0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.smallest();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void smallestOneElement() {
        //Arrange
        Array[] myMatrix = new Array[1];
        myMatrix[0] = new Array(new int[]{1});
        int exp = 1;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        int res = myArray.smallest();
        //Assert
        assertEquals(exp, res);
    }

    /**
     * alínea h
     */
    @Test
    void averageValid() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{3, 6, 9});
        myMatrix[1] = new Array(new int[]{12, 15, 18});
        myMatrix[2] = new Array(new int[]{3, 6, 9});
        double exp = 9.0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        double res = myArray.average();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void averageEmpty() {
        //Arrange
        Array[] myMatrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::average);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void averageNegative() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{-3, -6, -9});
        myMatrix[1] = new Array(new int[]{-12, -15, -18});
        myMatrix[2] = new Array(new int[]{-3, -6, -9});
        double exp = -9.0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        double res = myArray.average();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void averageZero() {
        //Arrange
        Array[] myMatrix = new Array[3];
        myMatrix[0] = new Array(new int[]{0, 0, 0});
        myMatrix[1] = new Array(new int[]{0, 0, 0});
        myMatrix[2] = new Array(new int[]{0, 0, 0});
        double exp = 0.0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        double res = myArray.average();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void averageOneElement() {
        //Arrange
        Array[] myMatrix = new Array[1];
        myMatrix[0] = new Array(new int[]{1});
        double exp = 1.0;
        ArrayOfArrays myArray = new ArrayOfArrays(myMatrix);
        //Act
        double res = myArray.average();
        //Assert
        assertEquals(exp, res);
    }

    /**
     * alínea j.
     */
    @Test
    void sumColumnsEmpty() throws IllegalArgumentException {
        //Arrange
        int[][] matrix = {};
        Array[] sumColumns = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(sumColumns);
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::sumColumns);
        //Assert
        assertEquals("Empty array", exception.getMessage());
    }

    /**
     * alínea k.
     */
    @Test
    void lineWithLargestSumEmpty() throws IllegalArgumentException {
        Array[] matrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::lineWithLargestSum);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void lineWithLargestSumValid() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{3, 6, 9});
        matrix[1] = new Array(new int[]{12, 15, 18});
        matrix[2] = new Array(new int[]{3, 6, 9});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        int res = myArray.lineWithLargestSum();
        //Assert
        assertEquals(1, res);
    }

    /**
     * alínea l.
     */
    @Test
    void isSquareEmpty() throws IllegalArgumentException {
        Array[] matrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::isSquare);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void isSquareValid() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{3, 6, 9});
        matrix[1] = new Array(new int[]{12, 15, 18});
        matrix[2] = new Array(new int[]{3, 6, 9});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        boolean res = myArray.isSquare();
        //Assert
        assertTrue(res);
    }

    @Test
    void isSquareInvalid() {
        //Arrange
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{3, 6, 9});
        matrix[1] = new Array(new int[]{12, 15, 18});
        matrix[2] = new Array(new int[]{3, 6, 9, 10});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        //Act
        boolean res = myArray.isSquare();
        //Assert
        assertFalse(res);
    }

    @Test
    void simetricalSquareValid(){
        //Arrange
        int[][] matrix = {{2, 3, 6}, {3,4,5}, {6,5,9}};
        ArrayOfArrays a = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertTrue(a.isSimetricSquare());}
    @Test
    void simetricalSquareMatrixNotSquare()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{2, 3}, {1,2,3}, {1,2,3}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertFalse(ArrayOfArrays.isSimetricSquare());}

    @Test
    void simetricalSquareMatrixNotSimetrical()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertFalse(ArrayOfArrays.isSimetricSquare());}
    @Test
    void simetricalSquareMatrixEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ArrayOfArrays::isSimetricSquare);
        assertEquals("Empty array", exception.getMessage());}

    @Test
    void nonNullsMainDiagonalNotSquare(){
        //Arrange
        int[][] matrix = {{1, 2}, {1,2,3}, {1,2,3}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertEquals(-1, ArrayOfArrays.nonNullsMainDiagonal());}

    @Test
    void nonNullsMainDiagonalEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ArrayOfArrays::nonNullsMainDiagonal);
        assertEquals("Empty array", exception.getMessage());}
    @Test
    void nonNullsMainDiagonalValidSquare(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertEquals(3, ArrayOfArrays.nonNullsMainDiagonal());}

    @Test
    void diagonalsEqualValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}, {3,2,3}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertTrue(ArrayOfArrays.diagonalsEqual());}

    @Test
    void diagonalsEqualFalse(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}, {3,2,4}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertFalse(ArrayOfArrays.diagonalsEqual());}
    @Test
    void diagonalsEqualTrueRectangle(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        assertTrue(ArrayOfArrays.diagonalsEqual());}
    @Test
    void diagonalsEqualNotRectangle()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,1}, {3,2,4}, {3,2,4}};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ArrayOfArrays::diagonalsEqual);
        assertEquals("Not a rectangle", exception.getMessage());}
    @Test
    void diagonalsEqualEmptyMatrix()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        ArrayOfArrays ArrayOfArrays = new ArrayOfArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ArrayOfArrays::diagonalsEqual);
        assertEquals("Empty array", exception.getMessage());}


    /**
     * alínea p.
     */
    @Test
    void algarismsOverAverage() {
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{12, 23, 3});
        matrix[1] = new Array(new int[]{4, 54, 61});
        matrix[2] = new Array(new int[]{7, 8, 90});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        Array expected = new Array(new int[]{12, 23, 54, 61, 90});
        Array actual = myArray.algarismsOverAverage();
        assertTrue(expected.equalsArray(actual));
    }

    @Test
    void algarismsOverAverageAllOneDigit() {
        Array[] matrix = new Array[3];
        matrix[0] = new Array(new int[]{1, 2, 3});
        matrix[1] = new Array(new int[]{4, 5, 6});
        matrix[2] = new Array(new int[]{7, 8, 9});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        Array expected = new Array();
        Array actual = myArray.algarismsOverAverage();
        assertTrue(expected.equalsArray(actual));
    }

    @Test
    void algarismsOverAverageEmptyMatrix() {
        Array[] matrix = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, myArray::algarismsOverAverage);
        assertEquals("Empty array", exception.getMessage());
    }

    /**
     * alínea q.
     */
    @Test
    void pairAlgarismsOverAverageEmptyArray() {
        //Arrange
        ArrayOfArrays myArray = new ArrayOfArrays();
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::percentageofPairsOverAverage);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void percentageofPairsOverAverageNoPairAlgarisms() {
        //Arrange
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 3, 1});
        matrix2[1] = new Array(new int[]{1, 7, 1});
        matrix2[2] = new Array(new int[]{3, 5, 9});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        //Act
        Array noalgarismsOverAverage = new Array();
        //Assert
        assertTrue(noalgarismsOverAverage.equalsArray(myArray.percentageofPairsOverAverage()));
    }

    @Test
    void percentageofPairsOverAverageSomeOverAverage() {
        //Arrange
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        //Act
        Array algarismsOverAverage = new Array(new int[]{2, 4, 6, 29});
        //Assert
        assertTrue(algarismsOverAverage.equalsArray(myArray.percentageofPairsOverAverage()));
    }

    @Test
    void percentageofPairsOverAverageSome3DigitsandSome4DigitAlgarisms() {
        //Arrange
        Array[] matrix2 = new Array[4];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        matrix2[3] = new Array(new int[]{3000, 6, 299});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        //Act
        Array algarismsOverAverage = new Array(new int[]{2, 4, 6, 29, 3000, 6});
        //Assert
        assertTrue(algarismsOverAverage.equalsArray(myArray.percentageofPairsOverAverage()));
    }

    /**
     * alínea r.
     */
    @Test
    void reverseLinesEmptyArray() throws IllegalArgumentException {
        //Arrange
        Array[] matrix2 = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::reverseLines);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void reverseLinesValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        myArray.reverseLines();
        Array sumLines = new Array(new int[]{4, 6, 38});
        Array sumColumns = new Array(new int[]{31, 12, 5});
        //Act
        assertEquals(myArray.getSize(), matrix.length);
        assertTrue(myArray.sumLines().equalsArray(sumLines));
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
    }

    /**
     * alínea s.
     */
    @Test
    void reverseColumnsEmpty() throws IllegalArgumentException {
        //Arrange
        Array[] sumColumns = new Array[0];
        ArrayOfArrays myArray = new ArrayOfArrays(sumColumns);
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::reverseColumns);
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void reverseColumnValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        myArray.reverseColumns();
        //Act
        int[] sumofLines = {38, 6, 4};
        Array sumL = new Array(sumofLines);
        int[] sumC = {5, 12, 31};
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(myArray.getSize(), matrix.length);
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
        assertTrue(myArray.sumLines().equalsArray(sumL));
    }

    @Test
    void reverseColumnValid2() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}, {3, 6, 29}};
        Array[] matrix2 = new Array[4];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        matrix2[3] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        myArray.reverseColumns();
        //Act
        int[] sumL = {38, 38, 6, 4};
        int[] sumC = {8, 18, 60};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(myArray.getSize(), matrix.length);
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
        assertTrue(myArray.sumLines().equalsArray(sumLines));
    }

    /**
     * alínea t.
     */
    @Test
    void rotate90DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        ArrayOfArrays myArray = new ArrayOfArrays();
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::rotateMatrix90Degrees);
        //Assert
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void rotateMatrix90DegreesNonRectangle() throws IllegalArgumentException {
        //Arrange
        Array[] myArray = new Array[4];
        myArray[0] = new Array(new int[]{1, 1});
        myArray[1] = new Array(new int[]{1, 4, 1});
        myArray[2] = new Array(new int[]{3, 6, 29});
        myArray[3] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray2 = new ArrayOfArrays(myArray);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray2::rotateMatrix90Degrees);
        assertEquals("Not a rectangle", exception.getMessage());
    }

    @Test
    void rotateMatrix90DegreesValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        Array[] myArray = new Array[3];
        myArray[0] = new Array(new int[]{1, 2, 1});
        myArray[1] = new Array(new int[]{1, 4, 1});
        myArray[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray2 = new ArrayOfArrays(myArray);
        myArray2.rotateMatrix90Degrees();
        //Act
        int[] sumL = {5, 12, 31};
        int[] sumC = {38, 6, 4};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(myArray2.getSize(), matrix.length);
        assertTrue(myArray2.sumColumns().equalsArray(sumColumns));
        assertTrue(myArray2.sumLines().equalsArray(sumLines));
    }

    /**
     * alínea u.
     */
    @Test
    void rotateMatrix180DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        ArrayOfArrays myArray = new ArrayOfArrays();
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::rotateMatrix180Degrees);
        //Assert
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void rotateMatrix180DegreesNonRectangle() throws IllegalArgumentException {
        //Arrange
        Array[] myArray = new Array[4];
        myArray[0] = new Array(new int[]{1, 1});
        myArray[1] = new Array(new int[]{1, 4, 1});
        myArray[2] = new Array(new int[]{3, 6, 29});
        myArray[3] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays a2 = new ArrayOfArrays(myArray);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                a2::rotateMatrix180Degrees);
        assertEquals("Not a rectangle", exception.getMessage());
    }

    @Test
    void rotateMatrix180DegreesValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        myArray.rotateMatrix180Degrees();
        //Act
        int[] sumL = {38, 6, 4};
        int[] sumC = {31, 12, 5};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(myArray.getSize(), matrix.length);
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
        assertTrue(myArray.sumLines().equalsArray(sumLines));
    }

    /**
     * alínea v.
     */
    @Test
    void rotateMatrix270DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        ArrayOfArrays myArray = new ArrayOfArrays();
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray::rotateMatrix270Degrees);
        //Assert
        assertEquals("Empty array", exception.getMessage());
    }

    @Test
    void rotateMatrix270DegreesNonRectangle() throws IllegalArgumentException {
        //Arrange
        Array[] myArray = new Array[4];
        myArray[0] = new Array(new int[]{1, 1});
        myArray[1] = new Array(new int[]{1, 4, 1});
        myArray[2] = new Array(new int[]{3, 6, 29});
        myArray[3] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray2 = new ArrayOfArrays(myArray);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                myArray2::rotateMatrix270Degrees);
        assertEquals("Not a rectangle", exception.getMessage());
    }

    @Test
    void rotateMatrix270DegreesValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1, 4, 1}, {3, 6, 29}};
        Array[] matrix2 = new Array[3];
        matrix2[0] = new Array(new int[]{1, 2, 1});
        matrix2[1] = new Array(new int[]{1, 4, 1});
        matrix2[2] = new Array(new int[]{3, 6, 29});
        ArrayOfArrays myArray = new ArrayOfArrays(matrix2);
        myArray.rotateMatrix270Degrees();
        //Act
        int[] sumL = {31, 12, 5};
        int[] sumC = {4, 6, 38};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(myArray.getSize(), matrix.length);
        assertTrue(myArray.sumColumns().equalsArray(sumColumns));
        assertTrue(myArray.sumLines().equalsArray(sumLines));
    }
}