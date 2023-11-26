package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomMatrixTest {

    @Test
    void testEquals(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        CustomMatrix customMatrix2 = new CustomMatrix();
        //Act and Assert
        assertTrue(customMatrix1.equals(customMatrix2));}
    @Test
    void testEqualsValidExternalized(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        int[][] exp = {};
        int[][] result = customMatrix1.getMatrix();
        //Act and Assert
        assertArrayEquals(exp,result);}
    @Test
    void testEqualsNull(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        assertFalse(customMatrix1.equals(null));}
    @Test
    void testConstructorNoParameter(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        int[][] exp = {};
        int[][] result = customMatrix1.getMatrix();
        //Act and Assert
        assertArrayEquals(exp,result);}
    @Test
    void testConstructorwithParameters(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        int[][] exp = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = customMatrix1.getMatrix();
        //Act and Assert
        assertArrayEquals(exp,result);}
    @Test
    void testconstructorwithParametersNull()throws NullPointerException{
        // Arrange Act and Assert
        Exception exception = new Exception(assertThrows(NullPointerException.class,
                ()->new CustomMatrix(null)));
        assertTrue(exception.getMessage().contains("Matrix is null"));}
    @Test
    void getMatrix() {
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        int[][] exp = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] result = customMatrix1.getMatrix();
        //Act and Assert
        assertArrayEquals(exp,result);}
    @Test
    void getMatrixEmpty(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        int[][] exp = {};
        int[][] result = customMatrix1.getMatrix();
        //Act and Assert
        assertArrayEquals(exp,result);}
    @Test
    void testgetSize() {
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        int exp = 3;
        int result = customMatrix1.getSize();
        //Act and Assert
        assertEquals(exp,result);}
    @Test
    void testgetSizeEmpty(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        int exp = 0;
        int result = customMatrix1.getSize();
        //Act and Assert
        assertEquals(exp,result);}

    @Test
    void addElementtoLineValid() {
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.add(10,0);
        int[][] exp = {{1,2,3,10},{4,5,6},{7,8,9}};
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void addElementtoLineOverLimits()throws ArrayIndexOutOfBoundsException{
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
       ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                ()->customMatrix1.add(10,3));
       assertTrue(exception.getMessage().contains("Out of Bounds"));}

    @Test
    void addElementtoNegativeLine(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        Exception exception = new Exception(assertThrows(IllegalArgumentException.class,
                ()->customMatrix1.add(10,-1)));
        assertTrue(exception.getMessage().contains("Invalid Argument"));}

    @Test
    void removeFirstInstanceof() {
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.remove(5);
        int[][] exp = {{1,2,3},{4,6},{7,8,9}};
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void removeFirstInstanceofEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->customMatrix1.remove(5));
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void removeFirstInstanceofInvalid()throws IllegalArgumentException{
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->customMatrix1.remove(10));
        assertTrue(exception.getMessage().contains("Invalid Argument"));}

    @Test
    void testisEmptyTrue(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act
        boolean result = customMatrix1.isEmpty();
        //Assert
        assertTrue(result);}
    @Test
    void testisEmptyFalse(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        boolean result = customMatrix1.isEmpty();
        //Assert
        assertFalse(result);}
    @Test
    void testgetLargestSmallestNumberLargest(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.minMax(true);
        //Assert
        assertEquals(9,result);}
    @Test
    void testgetLargestSmallestNumberSmallest(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.minMax(false);
        //Assert
        assertEquals(1,result);}
    @Test
    void testgetLargestSmallestNumberEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                ()->customMatrix1.minMax(true));
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void testgetLargestSmallestNumberallEqual(){
        //Arrange
        int[][] mtrx = {{1,1,1},{1,1,1},{1,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.minMax(true);
        //Assert
        assertEquals(1,result);}

    @Test
    void linesSum(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[] exp = {6,15,24};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.linesSum();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void linesSumEmpty(){
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        int[] exp = {};
        //Act
        int[] result = customMatrix1.linesSum();
        //Assert
        assertArrayEquals(exp,result);}

    @Test
    void average(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        double exp = 5;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        double result = customMatrix1.average();
        //Assert
        assertEquals(exp,result);}
    @Test
    void averageAllNegatives(){
        //Arrange
        int[][] mtrx = {{-1,-2,-3},{-4,-5,-6},{-7,-8,-9}};
        double exp = -5;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        double result = customMatrix1.average();
        //Assert
        assertEquals(exp,result);}
    @Test
    void averageEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::average);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void rowsSum() {
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[] exp = {12,15,18};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rowSumMatrix5x5() {
        //Arrange
        int[][] mtrx = {{1,2,3,4,5},{4,5,6,7,8},{7,8,9,10,11},{10,11,12,13,14},{13,14,15,16,17}};
        int[] exp = {35,40,45,50,55};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rowSumNonSquareMatrix(){
        //Arrange
        int[][] mtrx = {{1,2,3,4,5},{4,5,6,7,8},{7,8,9,10,11},{10,11,12,13,14},{13,14,15,16,17},{13,14,15,16,17}};
        int[] exp = {48,54,60,66,72};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rowSumMatrix3x2(){
        //Arrange
        int[][] mtrx = {{1,2},{4,5},{7,8}};
        int[] exp = {12,15};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result);}

    @Test
    void rowSumAssymetricalLinesMatrix4x3(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5},{9},{10,11,12}};
        int[] exp = {24,18,15};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[] result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result);}


    @Test
    void rowsSumEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rowsSum);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void biggestLineSum(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int exp = 2;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.biggestLine();
        //Assert
        assertEquals(exp,result);}
    @Test
    void biggestLineSumEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::biggestLine);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void biggestLineSumAllNegatives(){
        //Arrange
        int[][] mtrx = {{-1,-2,-3},{-4,-5,-6},{-7,-8,-9}};
        int exp = 0;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.biggestLine();
        //Assert
        assertEquals(exp,result);}
    @Test
    void biggestLineSumAllEqual(){
        //Arrange
        int[][] mtrx = {{1,1,1},{1,1,1},{1,1,1}};
        int exp = 0;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.biggestLine();
        //Assert
        assertEquals(exp,result);}



    }