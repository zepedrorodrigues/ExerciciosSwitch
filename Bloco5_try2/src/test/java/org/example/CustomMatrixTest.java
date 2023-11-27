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
        CustomArray result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result.getArray());}
    @Test
    void rowSumMatrix5x5() {
        //Arrange
        int[][] mtrx = {{1,2,3,4,5},{4,5,6,7,8},{7,8,9,10,11},{10,11,12,13,14},{13,14,15,16,17}};
        int[] exp = {35,40,45,50,55};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        CustomArray result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result.getArray());}
    @Test
    void rowSumNonSquareMatrix(){
        //Arrange
        int[][] mtrx = {{1,2,3,4,5},{4,5,6,7,8},{7,8,9,10,11},{10,11,12,13,14},{13,14,15,16,17},{13,14,15,16,17}};
        int[] exp = {48,54,60,66,72};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        CustomArray result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result.getArray());}
    @Test
    void rowSumMatrix3x2(){
        //Arrange
        int[][] mtrx = {{1,2},{4,5},{7,8}};
        int[] exp = {12,15};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        CustomArray result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result.getArray());}

    @Test
    void rowSumAssymetricalLinesMatrix4x3(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5},{9},{10,11,12}};
        int[] exp = {24,18,15};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        CustomArray result = customMatrix1.rowsSum();
        //Assert
        assertArrayEquals(exp,result.getArray());}


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
    @Test
    void isSquareValid(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        boolean exp = true;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        boolean result = customMatrix1.isSquare();
        //Assert
        assertEquals(exp,result);}
    @Test
    void isSquareEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::isSquare);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void isSquareFalse(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6}};
        boolean exp = false;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        boolean result = customMatrix1.isSquare();
        //Assert
        assertEquals(exp,result);}
    @Test
    void isSquareRectangle5x4(){
        //Arrange
        int[][] mtrx = {{1,2,3,4,6},{4,5,6,7,6},{7,8,9,10,6},{10,11,12,6}};
        boolean exp = false;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        boolean result = customMatrix1.isSquare();
        //Assert
        assertEquals(exp,result);}
    @Test
    void isSquareLines2345(){
        //Arrange
        int[][] mtrx = {{1,2,5,6,7},{4},{7,8},{10,11,12},{13,14}};
        boolean exp = false;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        boolean result = customMatrix1.isSquare();
        //Assert
        assertEquals(exp,result);}
    @Test
    void simetricSquareValid(){
        //Arrange
        int[][] mtrx = {{2,3,6},{3,4,5},{6,5,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertTrue(customMatrix1.simetricSquare());}
    @Test
    void simetricSquareFalse(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1},{9,8,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.simetricSquare());}
    @Test
    void simetricSquareRectangle(){
        //Arrange
        int[][] mtrx = {{2,3,6,7},{1,1,1,1},{9,8,2,3}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.simetricSquare());}
     @Test
     void simetricSquareLinesDifferentSizes(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1,1},{9,8,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::simetricSquare);
        assertTrue(exception.getMessage().contains("Invalid Argument"));}
    @Test
    void simetricSquareEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::simetricSquare);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void elementsDiagonalSquare(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1},{9,8,2}};
        int exp = 3;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int result = customMatrix1.elementsDiagonal();
        //Assert
        assertEquals(exp,result);}
    @Test
    void elementsDiagonalEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::elementsDiagonal);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void elementsDiagonalRectangle(){
        //Arrange
        int[][] mtrx = {{2,3,6,7},{1,1,1,1},{9,8,2,3}};
        int exp = -1;
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        //Assert
        assertEquals(exp,customMatrix1.elementsDiagonal());}
    @Test
    void elementsDiagonalLinesDifferentSizes(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1,1},{9,8,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertEquals(-1,customMatrix1.elementsDiagonal());}
    @Test
    void elementsDiagonalNotSquare(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1},{9,8,2},{1,2,3}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertEquals(-1,customMatrix1.elementsDiagonal());}
    @Test
    void elementsDiagonalEmptyArray()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::elementsDiagonal);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void equalDiagonalsDifferent(){
        //Arrange
        int[][] mtrx = {{2,3,6},{1,1,1},{9,8,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.equalDiagonals());}
    @Test
    void equalDiagonalsEqual(){
        //Arrange
        int[][] mtrx = {{2,3,2},{1,1,1},{2,8,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Assert
        assertTrue(customMatrix1.equalDiagonals());}
    @Test
    void equalDiagonalsEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::equalDiagonals);
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void equalDiagonalsNotRectangle(){
        //Arrange
        int[][] mtrx = {{2,3},{1,1,1},{2,8,2},{2,2,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::equalDiagonals);
        assertTrue(exception.getMessage().contains("Matrix is not rectangle"));}
    @Test
    void equalDiagonalsNotSquare(){
        //Arrange
        int[][] mtrx = {{2,3,2},{1,1,1},{2,8,2},{2,2,2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertTrue(customMatrix1.equalDiagonals());}
    @Test
    void digitsOverAverage(){
        //Arrange
        int[][] mtrx = {{22,3,2},{1,13,1},{2,8,2}};
        int[][] exp =  {{22},{13},{}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.digitsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void digitsOoverAverageMatrix4x4(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,2,1},{1,1,1,1}};
        int[][] exp =  {{22},{13},{},{}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.digitsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void digitsOverAverageEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.digitsOverAverage());
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void digitsOverAverageSome4DigitNumbers(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        int[][] exp =  {{22},{13},{211},{11111}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.digitsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void pairsOverAverageValid(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        int[][] exp =  {{22,2},{},{2,8,211},{}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.pairsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void pairsOverAverageEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.pairsOverAverage());
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void pairsOverAverageAll100percentPairs(){
        //Arrange
        int[][] mtrx = {{22,2,2,4},{6,22,44,66},{2,8,246,2},{8,66,88,2}};
        int[][] exp =  {{},{},{},{}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.pairsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void pairsOVerAverageSome4DigitNumbers(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        int[][] exp =  {{22,2},{},{2,8,211},{}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        int[][] result = customMatrix1.pairsOverAverage();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void reverseLineValid(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        int[][] exp =  {{1,2,3,22},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.reverseLine(0);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void reverseLineEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.reverseLine(0));
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void reverseLineInvalidLine(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,() -> customMatrix1.reverseLine(4));
        assertTrue(exception.getMessage().contains("Out of Bounds"));}
    @Test
    void reverseLineInvalidNegativeLine(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,() -> customMatrix1.reverseLine(-1));
        assertTrue(exception.getMessage().contains("Out of Bounds"));}

    @Test
    void reverseColumnValid(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        int[][] exp =  {{1,3,2,1},{2,13,1,1},{1,8,211,1},{22,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.reverseColumn(0);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void reverseColumnEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.reverseColumn(0));
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void reverseColumnInvalidColumn(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,() -> customMatrix1.reverseColumn(4));
        assertTrue(exception.getMessage().contains("Out of Bounds"));}
    @Test
    void reverseColumnInvalidNegativeColumn(){
        //Arrange
        int[][] mtrx = {{22,3,2,1},{1,13,1,1},{2,8,211,1},{1,11111,1,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,() -> customMatrix1.reverseColumn(-1));
        assertTrue(exception.getMessage().contains("Out of Bounds"));}
    @Test
    void rotate90DegreesClockwiseValid(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{3,6,9},{2,5,8},{1,4,7}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(90);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotate180Degrees(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{9,8,7},{6,5,4},{3,2,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(180);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotate270Degrees(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{7,4,1},{8,5,2},{9,6,3}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(270);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotate360Degrees(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{1,2,3},{4,5,6},{7,8,9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(360);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotate450Degrees(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{3,6,9},{2,5,8},{1,4,7}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(450);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotate540Degrees(){
        //Arrange
        int[][] mtrx = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] exp =  {{9,8,7},{6,5,4},{3,2,1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.rotateMatrix(540);
        int[][] result = customMatrix1.getMatrix();
        //Assert
        assertArrayEquals(exp,result);}
    @Test
    void rotateEmpty()throws IllegalArgumentException{
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.rotateMatrix(90));
        assertTrue(exception.getMessage().contains("Empty Array"));}
    @Test
    void rotateNonSquareMatrix(){
        //Arrange
        int[][] mtrx = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.rotateMatrix(90));
        assertTrue(exception.getMessage().contains("Matrix is not square"));}
    @Test
    void rotateInvalidAngle(){
        //Arrange
        int[][] mtrx = {{1,2,3,4},{4,5,6,7},{7,8,9,10},{11,12,13,14}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,() -> customMatrix1.rotateMatrix(95));
        assertTrue(exception.getMessage().contains("Invalid Argument"));}
    }



