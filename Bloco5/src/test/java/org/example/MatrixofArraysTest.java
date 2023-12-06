package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixofArraysTest {
    @Test
    void testConstructorNoParameters(){
        //Arrange
        MatrixofArrays matrixofArrays = new MatrixofArrays();
        //Act
        int[][] matrix = {};
        //Assert
        assertEquals(matrix.length,matrixofArrays.getSize());}

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
    void addNewValueinLineNegativa(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> matrixofArrays.add(7, -1));
        assertEquals("Out of bounds", exception.getMessage());}
    @Test
    void addNewValueLineOutOfBounds(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> matrixofArrays.add(7, 2));
        assertEquals("Out of bounds", exception.getMessage());}
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

    @Test
    void averageValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        double average = 3.5;
        //Assert
        assertEquals(average, matrixofArrays.average());}

    @Test
    void averageEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::average);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void sumofLinesEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::sumLines);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void sumColumnsEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::sumColumns);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void sumColumnsValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        Array sumColumns = new Array(new int[]{5,7,9});
        //Act
        //Assert
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));}

    @Test
    void getsizeValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int size = 2;
        //Assert
        assertEquals(size, matrixofArrays.getSize());}

    @Test
    void getsizeEmpty(){
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int size = 0;
        //Assert
        assertEquals(size, matrixofArrays.getSize());}

    @Test
    void biggestEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::biggest);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void biggestValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int biggest = 6;
        //Assert
        assertEquals(biggest, matrixofArrays.biggest());}

    @Test
    void smallestEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::smallest);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void smallestValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int smallest = 1;
        //Assert
        assertEquals(smallest, matrixofArrays.smallest());}
    @Test
    void smallestValidSmallestinIndexEqualsLength()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, -6}, {7, 8}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int smallest = -6;
        //Assert
        assertEquals(smallest, matrixofArrays.smallest());}

    @Test
    void biggestLineValid(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int biggestLine = 2;
        //Assert
        assertEquals(biggestLine, matrixofArrays.biggestLine());}

    @Test
    void biggestLineValidZero(){
        //Arrange
        int[][] matrix = {{100, 2, 3}, {4, 5, 6}, {7, 9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int biggestLine = 0;
        //Assert
        assertEquals(biggestLine, matrixofArrays.biggestLine());}

    @Test
    void biggestLineValidMiddle(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {400, 5, 6}, {7, 9, 100}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int biggestLine = 1;
        //Assert
        assertEquals(biggestLine, matrixofArrays.biggestLine());}

    @Test
    void biggestLineEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::biggestLine);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void biggestLineAllLinesSameSum(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        int biggestLine = 0;
        //Assert
        assertEquals(biggestLine, matrixofArrays.biggestLine());}

    @Test
    void isEmptyValid(){
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        boolean empty = true;
        //Assert
        assertEquals(empty, matrixofArrays.isEmpty());}

    @Test
    void isEmptyFalse(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        boolean empty = false;
        //Assert
        assertEquals(empty, matrixofArrays.isEmpty());}

    @Test
    void isSquareValid(){
        //Arrange
        int[][] matrix = {{2, 3, 6}, {3,4,5}, {6,5,9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertTrue(matrixofArrays.isSquare());}

    @Test
    void isSquareRectangle(){
        //Arrange
        int[][] matrix = {{2, 3, 6}, {3,4,5}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertFalse(matrixofArrays.isSquare());}

    @Test
    void isSquareFalseNotRectangle(){
        //Arrange
        int[][] matrix = {{2, 3}, {3,4,5}, {6,5,9}, {6,5,9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertFalse(matrixofArrays.isSquare());
    }

    @Test
    void isSquareEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::isSquare);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void simetricalSquareValid(){
        //Arrange
        int[][] matrix = {{2, 3, 6}, {3,4,5}, {6,5,9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertTrue(matrixofArrays.isSimetricSquare());}
    @Test
        void simetricalSquareMatrixNotSquare()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{2, 3}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertFalse(matrixofArrays.isSimetricSquare());}

    @Test
    void simetricalSquareMatrixNotSimetrical()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertFalse(matrixofArrays.isSimetricSquare());}
    @Test
    void simetricalSquareMatrixEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::isSimetricSquare);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void nonNullsMainDiagonalNotSquare(){
        //Arrange
        int[][] matrix = {{1, 2}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertEquals(-1, matrixofArrays.nonNullsMainDiagonal());}

    @Test
    void nonNullsMainDiagonalEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::nonNullsMainDiagonal);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void nonNullsMainDiagonalValidSquare(){
        //Arrange
        int[][] matrix = {{1, 2, 3}, {1,2,3}, {1,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertEquals(3, matrixofArrays.nonNullsMainDiagonal());}

    @Test
    void diagonalsEqualValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}, {3,2,3}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertTrue(matrixofArrays.diagonalsEqual());}

    @Test
    void diagonalsEqualFalse(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}, {3,2,4}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertFalse(matrixofArrays.diagonalsEqual());}
    @Test
    void diagonalsEqualTrueRectangle(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        assertTrue(matrixofArrays.diagonalsEqual());}
    @Test
    void diagonalsEqualNotRectangle()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,1}, {3,2,4}, {3,2,4}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::diagonalsEqual);
        assertEquals("Matrix is not a rectangle", exception.getMessage());}
    @Test
    void diagonalsEqualEmptyMatrix()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::diagonalsEqual);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void algarismsOverAveragsValid(){
        //Arrange
        int[][] matrix = {{1, 23, 1}, {1,24,1}, {3,21,4}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        Array algarismsOverAverage = new Array(new int[]{23,24,21});
        //Act
        //Assert
        assertTrue(matrixofArrays.algarismsOverAverage().equalsArray(algarismsOverAverage));}
    @Test
    void algarismsOverAverageAllOneDigit(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,2,1}, {3,2,4}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        Array algarismsOverAverage = new Array();
        //Act
        //Assert
        assertTrue(matrixofArrays.algarismsOverAverage().equalsArray(algarismsOverAverage));}
    @Test
    void algarismsOverAverageEmptyArray(){
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::algarismsOverAverage);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void pairAlgarismsOverAverageEmptyArray(){
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::percentageofPairsOverAverage);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void percentageofPairsOverAverageNoPairAlgarisms(){
        //Arrange
        int[][] matrix = {{1, 3, 1}, {1,7,1}, {3,5,9}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        Array algarismsOverAverage = new Array();
        //Assert
        assertTrue(algarismsOverAverage.equalsArray(matrixofArrays.percentageofPairsOverAverage()));}
    @Test
    void percentageofPairsOverAverageSomeOverAverage(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        Array algarismsOverAverage = new Array(new int[]{2,4,6,29});
        //Assert
        assertTrue(algarismsOverAverage.equalsArray(matrixofArrays.percentageofPairsOverAverage()));}
    @Test
    void percentageofPairsOverAverageSome3DigitsandSome4DigitAlgarisms(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}, {3000,6,299}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        Array algarismsOverAverage = new Array(new int[]{2,4,6,29,3000,6});
        //Assert
        assertTrue(algarismsOverAverage.equalsArray(matrixofArrays.percentageofPairsOverAverage()));}

    @Test
    void reverseLinesEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::reverseLines);
        assertEquals("Empty matrix", exception.getMessage());}

    @Test
    void reverseLinesValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.reverseLines();
        //Act
        int[] sumL = {4,6,38};
        int[] sumC = {31,12,5};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}

    @Test
    void reverseColumnsEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::reverseColumns);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void reverseColumnValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.reverseColumns();
        //Act
        int[] sumL = {38,6,4};
        int[] sumC = {5,12,31};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}
    @Test
    void reverseColumnValid2(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.reverseColumns();
        //Act
        int[] sumL = {38,38,6,4};
        int[] sumC = {8,18,60};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}

    @Test
    void rotate90DegreesEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix90Degrees);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void rotateMatrix180DegreesEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix180Degrees);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void rotateMatrix270DegreesEmpty()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix270Degrees);
        assertEquals("Empty matrix", exception.getMessage());}
    @Test
    void rotateMatrix90DegreesNonRectangle()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 1}, {1,4,1}, {3,6,29}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix90Degrees);
        assertEquals("Matrix is not a rectangle", exception.getMessage());}
    @Test
    void rotateMatrix180DegreesNonRectangle()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4}, {3,6,29}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix180Degrees);
        assertEquals("Matrix is not a rectangle", exception.getMessage());}
    @Test
    void rotateMatrix270DegreesNonRectangle()throws IllegalArgumentException{
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        //Act
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                matrixofArrays::rotateMatrix270Degrees);
        assertEquals("Matrix is not a rectangle", exception.getMessage());}

    @Test
    void rotateMatrix90DegreesValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.rotateMatrix90Degrees();
        //Act
        int[] sumL = {5,12,31};
        int[] sumC = {38,6,4};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}
    @Test
    void rotateMatrix180DegreesValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.rotateMatrix180Degrees();
        //Act
        int[] sumL = {38,6,4};
        int[] sumC = {31,12,5};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}
    @Test
    void rotateMatrix270DegreesValid(){
        //Arrange
        int[][] matrix = {{1, 2, 1}, {1,4,1}, {3,6,29}};
        MatrixofArrays matrixofArrays = new MatrixofArrays(matrix);
        matrixofArrays.rotateMatrix270Degrees();
        //Act
        int[] sumL = {31,12,5};
        int[] sumC = {4,6,38};
        Array sumLines = new Array(sumL);
        Array sumColumns = new Array(sumC);
        //Assert
        assertEquals(matrixofArrays.getSize(),matrix.length);
        assertTrue(matrixofArrays.sumColumns().equalsArray(sumColumns));
        assertTrue(matrixofArrays.sumLines().equalsArray(sumLines));}
    }