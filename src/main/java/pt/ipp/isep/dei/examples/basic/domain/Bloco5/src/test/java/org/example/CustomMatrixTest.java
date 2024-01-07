package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CustomMatrixTest {

    @Test
    void testConstructorWithNullMatrix() throws NullPointerException {
        //Arrange, Act and Assert
        assertThrows(NullPointerException.class, () -> new CustomMatrix(null));
    }

    @Test
    void addElementValid() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.add(10, 1);
        int[] expectedColunas = {5, 7, 9, 10};
        int[] expectedLinhas = {6, 25};
        //Assert
        assertArrayEquals(customMatrix1.arraySumOfLines(), expectedLinhas);
        assertArrayEquals(customMatrix1.arraySomaColunas(), expectedColunas);
    }

    @Test
    void addElementtoLineOverLimits() throws ArrayIndexOutOfBoundsException {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> customMatrix1.add(10, 3));
        assertTrue(exception.getMessage().contains("Index out of bounds"));
    }

    @Test
    void addElementtoNegativeLine() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        Exception exception = new Exception(assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> customMatrix1.add(10, -1)));
        assertTrue(exception.getMessage().contains("Index out of bounds"));
    }

    @Test
    void removeFirstInstanceofValid() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.remove(5);
        int[] expectedColunas = {5, 8, 3};
        int[] expectedLinhas = {6, 10};
        //Assert
        assertArrayEquals(customMatrix1.arraySumOfLines(), expectedLinhas);
        assertArrayEquals(customMatrix1.arraySomaColunas(), expectedColunas);
    }

    @Test
    void removeFirstInstanceofValidMatrix4x5() {
        //Arrange
        int[][] mtrx = {{1, 2, 3, 4, 5}, {4, 5, 6, 7, 8}, {7, 8, 9, 10, 11}, {12, 13, 14, 15, 16}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act
        customMatrix1.remove(5);
        int[] expectedColunas = {24, 28, 32, 36, 35};
        int[] expectedLinhas = {10, 30, 45, 70};
        //Assert
        assertArrayEquals(customMatrix1.arraySumOfLines(), expectedLinhas);
        assertArrayEquals(customMatrix1.arraySomaColunas(), expectedColunas);
    }

    @Test
    void removeFirstInstanceofEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> customMatrix1.remove(5));
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void removeFirstInstanceofInvalid() throws IllegalArgumentException {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> customMatrix1.remove(10));
        assertTrue(exception.getMessage().contains("Invalid argument"));
    }

    @Test
    void testIsEmptyWithEmptyMatrix() {
        // Arrange
        CustomMatrix matrix = new CustomMatrix();
        // Act and Assert
        assertTrue(matrix.isEmpty());
    }

    @Test
    void testIsEmptyWithNonEmptyMatrix() {
        // Arrange
        int[][] arr = {{1, 2}, {3, 4}};
        CustomMatrix matrix = new CustomMatrix(arr);
        // Act and Assert
        assertFalse(matrix.isEmpty());
    }

    @Test
    void testGetMaxElement() {
        // Arrange
        int[][] arr = {{1, 2}, {3, 4}};
        CustomMatrix matrix = new CustomMatrix(arr);
        int exp = 4;
        // Act
        int maxElement = matrix.largest();
        // Assert
        assertEquals(exp, maxElement);
    }

    @Test
    void testGetMinElement() {
        // Arrange
        int[][] arr = {{1, 2}, {3, 4}};
        CustomMatrix matrix = new CustomMatrix(arr);
        int exp = 1;
        // Act
        int minElement = matrix.smallest();
        // Assert
        assertEquals(exp, minElement);
    }

    @Test
    void testGetMaxElementWithNegativeValues() {
        // Arrange
        int[][] arr = {{-1, -2}, {-3, -4}};
        CustomMatrix matrix = new CustomMatrix(arr);
        int exp = -1;
        // Act
        int maxElement = matrix.largest();
        // Assert
        assertEquals(exp, maxElement);
    }

    @Test
    void testGetMinElementWithNegativeValues() {
        // Arrange
        int[][] arr = {{-1, -2}, {-3, -4}};
        CustomMatrix matrix = new CustomMatrix(arr);
        int exp = -4;
        // Act
        int minElement = matrix.smallest();
        // Assert
        assertEquals(exp, minElement);
    }

    @Test
    void testGetMaxOrMinElementWithEmptyMatrix() throws IllegalArgumentException {
        // Arrange
        CustomMatrix matrix = new CustomMatrix();
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> matrix.largest());
        assertThrows(IllegalArgumentException.class, () -> matrix.smallest());
    }

    @Test
    void testArraySumLines() throws IllegalArgumentException {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        int[] exp = {6, 15, 24};
        //Act
        int[] res = customMatrix1.arraySumOfLines();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void testArraySumLinesWithNegativeAndZero() throws IllegalArgumentException {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {-4, 5, 6}, {7, 8, 0}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        int[] exp = {6, 7, 15};
        //Act
        int[] res = customMatrix1.arraySumOfLines();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void testArraySumEmptyLines() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::arraySumOfLines);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }


    @Test
    void arraySomaColunasArrayVazio() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::arraySomaColunas);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void isSquareValid3x3() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertTrue(customMatrix1.isSquare());
    }

    @Test
    void isSquareEmpty() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::isSquare);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void isSquareEmpty1x1() {
        //Arrange
        int[][] mtrx = {{1}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertTrue(customMatrix1.isSquare());
    }

    @Test
    void isSquareRectangle() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.isSquare());
    }

    @Test
    void isSquareLinesdifferentLengths() {
        //Arrange
        int[][] mtrx = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.isSquare());
    }

    @Test
    void simetricSquareValid() {
        //Arrange
        int[][] mtrx = {{2, 3, 6}, {3, 4, 5}, {6, 5, 9}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertTrue(customMatrix1.simetricSquare());
    }

    @Test
    void simetricSquareFalse() {
        //Arrange
        int[][] mtrx = {{2, 3, 6}, {1, 1, 1}, {9, 8, 2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        assertFalse(customMatrix1.simetricSquare());
    }

    @Test
    void simetricSquareRectangle() {
        //Arrange
        int[][] mtrx = {{2, 3, 6, 7}, {1, 1, 1, 1}, {9, 8, 2, 3}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::simetricSquare);
        assertTrue(exception.getMessage().contains("Matrix is not square"));
    }

    @Test
    void simetricSquareLinesDifferentSizes() {
        //Arrange
        int[][] mtrx = {{2, 3, 6}, {1, 1, 1, 1}, {9, 8, 2}};
        CustomMatrix customMatrix1 = new CustomMatrix(mtrx);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::simetricSquare);
        assertTrue(exception.getMessage().contains("Matrix is not square"));
    }

    @Test
    void simetricSquareEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::simetricSquare);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }


    @Test
    void testAverageValid() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        double exp = 0.5;
        //Act
        double res = customMatrix1.average();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testAveragewithNegatives() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        double exp = 0.5;
        //Act
        double res = customMatrix1.average();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testAverageEmpty() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customMatrix1.average());
        //Assert
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void testNonZeroElementsDiagonalValid() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int exp = 3;
        //Act
        int res = customMatrix1.nonZeroElementsDiagonal();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testNonZeroElementsDiagonalValidNoElements() {
        //Arrange
        int[][] matrix = {{0, 2, 3}, {-1, 0, -2}, {0, 4, 0}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int exp = 0;
        //Act
        int res = customMatrix1.nonZeroElementsDiagonal();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void testNonZeroElementsDiagonalEmpty() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customMatrix1.nonZeroElementsDiagonal());
        //Assert
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void testNonZeroElementsDiagonalNotSquare() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int exp = -1;
        //Act
        int res = customMatrix1.nonZeroElementsDiagonal();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void biggestLineValid() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int exp = 0;
        //Act
        int res = customMatrix1.biggestLine();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void biggestLineValidLine3Biggest() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {0, 0, 4, 5}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int exp = 2;
        //Act
        int res = customMatrix1.biggestLine();
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void biggestLineEmptyArray() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::biggestLine);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void sameDiagonalsValid() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {0, -1, -2}, {4, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        assertTrue(customMatrix1.sameDiagonals());
    }

    @Test
    void sameDiagonalsValidRectangle() {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {0, -1, -2}, {4, 0, 4}, {5, 1, 5}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        assertTrue(customMatrix1.sameDiagonals());
    }

    @Test
    void sameDiagonalsEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::sameDiagonals);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void sameDiagonalNoRectangle() throws IllegalArgumentException {
        //Arrange
        int[][] matrix = {{1, 2, 1}, {0, -1, -2}, {4, 0, 4, 3}, {5, 1, 5}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::sameDiagonals);
        assertTrue(exception.getMessage().contains("Not a Rectangle"));
    }

    @Test
    void testOverAverageAlgarism() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {};
        //Act
        int[] res = customMatrix1.overAverageAlgarism();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void testOverAverageAlgarismEmpty() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::overAverageAlgarism);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void testOverAverageAlgarismValid() {
        //Arrange
        int[][] matrix = {{10, 2, 3}, {0, -1, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {10};
        //Act
        int[] res = customMatrix1.overAverageAlgarism();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void testOverAveragePercetagePairs() {
        //Arrange
        int[][] matrix = {{10, 2, 3}, {0, -1, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {2, 0, -2, 0, 0, 4};
        //Act
        int[] res = customMatrix1.overAveragePercentagePairs();
        //Assert
        assertArrayEquals(exp, res);

    }

    @Test
    void testOverAveragePercetagePairsEmpty() {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::overAveragePercentagePairs);
        assertFalse(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void testOverAveragePercetagePairsValidAllPair() {
        //Arrange
        int[][] matrix = {{2, 2, 6}, {2, -2, -2}, {0, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {};
        //Act
        int[] res = customMatrix1.overAveragePercentagePairs();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void reverseLinesValidMatrix3x3() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {5, 1, 5};
        //Act
        customMatrix1.reverseLines();
        //Assert
        assertArrayEquals(exp, customMatrix1.arraySomaColunas());
    }

    @Test
    void reverseLinesValidMatrix2x2() {
        //Arrange
        int[][] matrix = {{1, 2}, {0, -1}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {1, 1};
        //Act
        customMatrix1.reverseLines();
        //Assert
        assertArrayEquals(exp, customMatrix1.arraySomaColunas());
    }

    @Test
    void reverseLinesEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::reverseLines);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void reverseAllColumns() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {8, -3, 6};
        //Act
        customMatrix1.invertColumnOrder();
        //Assert
        assertArrayEquals(exp, customMatrix1.arraySumOfLines());
    }

    @Test
    void reverseAllColumnsRectangle3x2() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        int[] exp = {-3, 6};
        //Act
        customMatrix1.invertColumnOrder();
        //Assert
        assertArrayEquals(exp, customMatrix1.arraySumOfLines());
    }

    @Test
    void reverseAllColumnsEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::invertColumnOrder);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void reverseAllColumnsNotRectangle() throws IllegalArgumentException {
        //Arrange
        int[][] nonRectangle = {{1, 2, 3}, {0, 2}, {4, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(nonRectangle);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::invertColumnOrder);
        assertTrue(exception.getMessage().contains("Not a Rectangle"));
    }

    @Test
    void rotate90DegreesSquare() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4}};
        int[][] result = {{4, 0, 1}, {0, -1, 2}, {4, 2, 3}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotate90Degrees();
        int[] sumOfLines = {5, 1, 5};
        int[] sumOfColumns = {8, -3, 6};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate90DegreesRectangle() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotate90Degrees();
        int[] sumOfLines = {1, 1, 1};
        int[] sumOfColumns = {-3, 6};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate90DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotate90Degrees);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void rotate90DegreesNotRectangle() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4, 3}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotate90Degrees);
        assertTrue(exception.getMessage().contains("Not a Rectangle"));
    }

    @Test
    void rotate180degreesSquare3x3() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4}};
        int[][] result = {{4, 0, 4}, {-2, -1, 0}, {3, 2, 1}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotate180Degrees();
        int[] sumOfLines = {8, -3, 6};
        int[] sumOfColumns = {5, 1, 5};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate180degreesREctangle3x4() {
        //Arrange
        int[][] matrix = {{1, 2, 3, 4}, {0, -1, -2, 5}, {4, 0, 4, 6}};
        int[][] result = {{6, 4, 0, 4}, {5, -2, -1, 0}, {4, 3, 2, 1}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotate180Degrees();
        int[] sumOfLines = {14, 2, 10};
        int[] sumOfColumns = {15, 5, 1, 5};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate180DegreesnotRectangle2x3() throws IllegalArgumentException {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotate180Degrees);
        assertTrue(exception.getMessage().contains("Not a Rectangle"));
    }

    @Test
    void rotate180DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotate180Degrees);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void rotate270DegreesSquare3x3() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}, {4, 0, 4}};
        int[][] result = {{3, -2, 4}, {2, -1, 0}, {1, 0, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotateMinus90Degrees();
        int[] sumOfLines = {5, 1, 5};
        int[] sumOfColumns = {6, -3, 8};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate270DegreesRectangle3x2() {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2}};
        int[][] result = {{3, -2}, {2, -1}, {1, 0}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        customMatrix1.rotateMinus90Degrees();
        int[] sumOfLines = {1, 1, 1};
        int[] sumOfColumns = {6, -3};
        //Act
        assertArrayEquals(sumOfLines, customMatrix1.arraySumOfLines());
        assertArrayEquals(sumOfColumns, customMatrix1.arraySomaColunas());
    }

    @Test
    void rotate270DegreesEmpty() throws IllegalArgumentException {
        //Arrange
        CustomMatrix customMatrix1 = new CustomMatrix();
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotateMinus90Degrees);
        assertTrue(exception.getMessage().contains("Empty Array"));
    }

    @Test
    void rotate270DegreesNotRectangle() throws IllegalArgumentException {
        //Arrange
        int[][] matrix = {{1, 2, 3}, {0, -1, -2, 4}};
        CustomMatrix customMatrix1 = new CustomMatrix(matrix);
        //Act and Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                customMatrix1::rotateMinus90Degrees);
        assertTrue(exception.getMessage().contains("Not a Rectangle"));
    }
}

