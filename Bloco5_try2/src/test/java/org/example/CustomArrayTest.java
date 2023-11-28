package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomArrayTest {
    @Test
    void testEqualsValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        CustomArray customArray2 = new CustomArray(arr1);
        //Assert
        assertTrue(customArray2.equals(customArray1));
    }

    @Test
    void testEqualsInvalid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        CustomArray customArray2 = new CustomArray(arr2);
        //Assert
        assertNotEquals(customArray1.getArray(), customArray2.getArray());}
    @Test
    void testEqualsInvalidDifferentType() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        String arr2 = "1, 2, 3";
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertNotEquals(customArray1.getArray(), arr2);}
    @Test
    void testEqualsValidbutDifferent() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3,4};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertFalse(customArray1.equals(arr2));}

    @Test
    void testHashValue() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertNotEquals(customArray1.hashCode(), arr1.hashCode());
    }

    @Test
    void testEqualsNull() throws NullPointerException {
        assertThrows(NullPointerException.class, () ->
                new CustomArray(null));
    } //throw exception

    @Test
    void testEqualsSame() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1, customArray1);
    }

    @Test
    void testEqualsDifferent() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        CustomArray customArray2 = new CustomArray(arr2);
        //Assert
        assertNotEquals(customArray1, customArray2);
    }

    @Test
    void testConstructorNoParameters() {
        //Arrange
        int[] arr1 = new int[0];
        //Act
        CustomArray customArray1 = new CustomArray();
        //Assert
        assertArrayEquals(customArray1.getArray(), arr1);
    }

    @Test
    void testConstructorWithParameters() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertArrayEquals(customArray1.getArray(), arr1);
    }

    @Test
    void testConstructorWithParametersNull() throws NullPointerException {
        assertThrows(NullPointerException.class, () ->
                new CustomArray(null));
    } //throw exception

    @Test
    void testGetArray() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertArrayEquals(customArray1.getArray(), arr1);
    }

    @Test
    void testGetSize() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getSize(), arr1.length);
    }

    @Test
    void testGetSizeEmpty() {
        //Arrange
        int[] arr1 = new int[0];
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getSize(), arr1.length);
    }

    @Test
    void getbyIndexValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getbyIndex(0), arr1[0]);
    }

    @Test
    void getbyIndexInvalid() throws IndexOutOfBoundsException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () ->
                customArray1.getbyIndex(3));
    } //throw exception

    @Test
    void getbyIndexInvalidNegative() throws IndexOutOfBoundsException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () ->
                customArray1.getbyIndex(-1));
    } //throw exception

    @Test
    void setElementValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 4;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        customArray1.setElement(0, value);
        //Assert
        assertEquals(customArray1.getbyIndex(0), value);
    }

    @Test
    void setElementInvalid() throws IndexOutOfBoundsException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 4;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () ->
                customArray1.setElement(3, value));
    } //throw exception

    @Test
    void setElementInvalidNegative() throws IndexOutOfBoundsException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 4;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IndexOutOfBoundsException.class, () ->
                customArray1.setElement(-1, value));
    } //throw exception

    @Test
    void addElementValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 4;
        int[] arr2 = {1, 2, 3, 4};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        customArray1.addElement(value);
        //Assert
        assertArrayEquals(customArray1.getArray(), arr2);
    }

    @Test
    void removeFirstElementValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 1;
        int[] arr2 = {2, 3};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        customArray1.removeFirstElement(value);
        //Assert
        assertArrayEquals(customArray1.getArray(), arr2);
    }

    @Test
    void removeFirstElementInvalid() throws IndexOutOfBoundsException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 4;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.removeFirstElement(value));
    } //throw exception

    @Test
    void removeFirstElementInvalidNegative() throws IllegalArgumentException {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = -1;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.removeFirstElement(value));
    } //throw exception

    @Test
    void getBiggestSmallestNumberValidBiggest() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 3;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getBiggestSmallestNumber(true), value);
    }

    @Test
    void getBiggestSmallestNumberValidSmallest() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        int value = 1;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getBiggestSmallestNumber(false), value);
    }

    @Test
    void getBiggestSmallestNumberInvalid() throws IllegalArgumentException {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.getBiggestSmallestNumber(true));
    } //throw exception

    @Test
    void getBiggestSmallestNumberInvalidSmallest() throws IllegalArgumentException {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.getBiggestSmallestNumber(false));
    } //throw exception

    @Test
    void getBiggestSmallestAllSame() {
        //Arrange
        int[] arr1 = {1, 1, 1};
        int value = 1;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getBiggestSmallestNumber(true), value);
        assertEquals(customArray1.getBiggestSmallestNumber(false), value);
    }

    @Test
    void getAverageValid() {
        //Arrange
        int[] arr1 = {1, 2, 3};
        double value = 2;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getAveragenoArguments(), value);
    }

    @Test
    void getAverageInvalid() throws IllegalArgumentException {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, customArray1::getAveragenoArguments);
    } //throw exception

    @Test
    void getAverageAllSame() {
        //Arrange
        int[] arr1 = {1, 1, 1};
        double value = 1;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getAveragenoArguments(), value);
    }

    @Test
    void getAverageNegative() {
        //Arrange
        int[] arr1 = {-1, -1, -1};
        double value = -1;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(customArray1.getAveragenoArguments(), value);
    }

    @Test
    void averageMultiplesof3() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 6;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(value, customArray1.averagemultiplesNonMultiples(3, true));
    }

    @Test
    void averageNonMultiplesof5() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 5;
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertEquals(value, customArray1.averagemultiplesNonMultiples(5, false));
    }

    @Test
    void averageMultiplesof3Empty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.averagemultiplesNonMultiples(3, true));
    } //throw exception

    @Test
    void averageNonMultiplesof5Empty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.averagemultiplesNonMultiples(5, false));
    } //throw exception

    @Test
    void averageMultiplesof0() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        CustomArray customArray1 = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                customArray1.averagemultiplesNonMultiples(0, true));
    } //throw exception

    @Test
    void sortAscendingDescendingascending() {
        //Arrange
        int[] arr1 = {3, 7, 1, 2, 0, 9, 11};
        int[] arr2 = {0, 1, 2, 3, 7, 9, 11};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(true);
        //Assert
        assertArrayEquals(arr2, array.getArray());
    }

    @Test
    void sortAscendingDescendingDescending() {
        //Arrange
        int[] arr1 = {3, 7, 1, 2, 0, 9, 11};
        int[] arr2 = {11, 9, 7, 3, 2, 1, 0};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(false);
        //Assert
        assertArrayEquals(arr2, array.getArray());
    }

    @Test
    void sortAscendingDescendingEmpty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                array.sortAscendingDescending(true));
    } //throw exception

    @Test
    void sortAscendingDescendingEmptyDescending() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                array.sortAscendingDescending(false));
    } //throw exception

    @Test
    void sortAscendingDescendingAllSame() {
        //Arrange
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 1, 1};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(true);
        //Assert
        assertArrayEquals(arr2, array.getArray());
    }

    @Test
    void sortAscendingDescendingAllSameDescending() {
        //Arrange
        int[] arr1 = {1, 1, 1};
        int[] arr2 = {1, 1, 1};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(false);
        //Assert
        assertArrayEquals(arr2, array.getArray());
    }

    @Test
    void sortAscendingDescendingNegative() {
        //Arrange
        int[] arr1 = {-1, -2, -3};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(false);
        //Assert
        assertArrayEquals(arr1, array.getArray());
    }

    @Test
    void sortAscendingDescendingNegativeAscending() {
        //Arrange
        int[] arr1 = {-1, -2, -3};
        int[] arr2 = {-3, -2, -1};
        //Act
        CustomArray array = new CustomArray(arr1);
        array.sortAscendingDescending(true);
        //Assert
        assertArrayEquals(arr2, array.getArray());
    }

    @Test
    void duplicatesCheckTrue() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.duplicatesCheck());
    }

    @Test
    void duplicatesCheckFalse() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertFalse(array.duplicatesCheck());
    }

    @Test
    void duplicatesCheckEmpty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, array::duplicatesCheck);
    } //throw exception

    @Test
    void duplicatesCheckAllSame() {
        //Arrange
        int[] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.duplicatesCheck());
    }

    @Test
    void isSizeTrue() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.isSize(9));
    }

    @Test
    void isSizeFalse() {
        //Arrange
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertFalse(array.isSize(10));
    }

    @Test
    void isOnlyEvenNumbersTrue() {
        //Arrange
        int[] arr1 = {2, 4, 6, 8, 10};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.isOnlyEvenNumbers(true));
    }

    @Test
    void isOnlyEvenNumbersFalse() {
        //Arrange
        int[] arr1 = {2, 4, 6, 8, 10, 11};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertFalse(array.isOnlyEvenNumbers(true));
    }

    @Test
    void isOnlyEvenNumbersEmpty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> array.isOnlyEvenNumbers(true));
    } //throw exception

    @Test
    void isOnlyOddsNumbersTrue() {
        //Arrange
        int[] arr1 = {1, 3, 5, 7, 9};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.isOnlyEvenNumbers(false));
    }

    @Test
    void isOnlyOddsNumbersFalse() {
        //Arrange
        int[] arr1 = {1, 3, 5, 7, 9, 10};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertFalse(array.isOnlyEvenNumbers(false));
    }

    @Test
    void isOnlyOddsNumbersEmpty() {
        //Arrange
        int[] arr1 = {};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> array.isOnlyEvenNumbers(false));
    } //throw exception

    @Test
    void isOnlyEvenNumbersAllSame() {
        //Arrange
        int[] arr1 = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.isOnlyEvenNumbers(true));
    }

    @Test
    void isOnlyOddsNumbersAllSame() {
        //Arrange
        int[] arr1 = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        //Act
        CustomArray array = new CustomArray(arr1);
        //Assert
        assertTrue(array.isOnlyEvenNumbers(false));
    }

    @Test
    void overAverageAlgarisms() {
        //Arrange
        int[] array = {1, 24, 32, 4, 5, 63};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {24, 32, 63};
        int[] result = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAverageAlgarismsSome4DigitAlgarisms() {
        //Arrange
        int[] array = {1, 2, 342, 4, 5, 63, 1000};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {342, 63, 1000};
        int[] result = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAverageAlgarismsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::overAverageAlgarisms);
    }

    @Test
    void overAverageAlgarismsAllEqual() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAveragePairAlgarisms() {
        //Arrange
        int[] array = {1, 2, 342, 4, 5, 63, 1000};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {2, 342, 4, 1000};
        int[] result = myArray.overAveragePairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAveragePairAlgarismsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::overAveragePairs);
    }

    @Test
    void overAveragePAirAlgarismsAllEqual100Pair() {
        //Arrange
        int[] array = {2, 2, 2};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.overAveragePairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAveragePairAlgarismsAllEqual0PercentPair() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.overAveragePairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void overAveragePairAlgarismsAllEqual50PercentPair() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {2};
        int[] result = myArray.overAveragePairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void numbersPerfectPairsEmpty() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::numbersPerfectPairs);
    }

    @Test
    void numbersPerfectPairsAllNonPairs() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.numbersPerfectPairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void numbersPerfectPairsAllPairs() {
        //Arrange
        int[] array = {2, 2, 2};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {2, 2, 2};
        int[] result = myArray.numbersPerfectPairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void numbersPerfectPairsSomePairs() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {2, 4, 6, 8};
        int[] result = myArray.numbersPerfectPairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void numbersPerfectPairsSomeAreAnd4Digits() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 4246};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {2, 4, 6, 8, 4246};
        int[] result = myArray.numbersPerfectPairs();
        //Act
        assertArrayEquals(expected, result);
    }

    @Test
    void getCrescentNumbersValid() {
        //Arrange
        int[] array = {12, 243, 367, 42, 5, 6, 7, 8, 9};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {12, 367};
            int[] result = myArray.crescentNumbers();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getCrescentsNoCrescents(){
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.crescentNumbers();
        //Act
        assertArrayEquals(expected, result);
    }
    @Test
    void getCrescentsEmptyArray(){
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::crescentNumbers);} //throw exception

    @Test
    void getCapicuas(){
        //Arrange
        int[] array = {12, 243, 367, 42, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {5,6,7,8,9,11, 22, 33, 44, 55};
        int[] result = myArray.getCapicuas();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getCapicuasEmptyArray(){
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::getCapicuas);} //throw exception

    @Test
    void getCapicuasNoCapicuas(){
        //Arrange
        int[] array = {12, 243, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.getCapicuas();
        //Act
        assertArrayEquals(expected, result);
    }
    @Test
    void getNumbersSameAlgarism(){
        //Arrange
        int[] array = {1,2,3,12, 222, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {1,2,3,222};
        int[] result = myArray.getNumbersSameAlgarism();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getNumbersSameAlgarismEmptyArray(){
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::getNumbersSameAlgarism);} //throw exception
    @Test
    void getNumbersSameAlgarismAllSameAlgarism(){
        //Arrange
        int[] array = {1,1,1,1,1,1,1,1,1,1,1,1,1};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] result = myArray.getNumbersSameAlgarism();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getNonArmstrongs(){
        //Arrange
        int[] array = {1,2,3,12, 222, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {12, 222, 367, 42, 51, 61, 74, 81, 91};
        int[] result = myArray.getNonArmstrongs();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getNonArmstrongsEmptyArray(){
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::getNonArmstrongs);} //throw exception
    @Test
    void getNonArmstrongsAllArmstrongs(){
        //Arrange
        int[] array = {1,153,370,371,407};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.getNonArmstrongs();
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getNumbersCrescentatLeastSequenceX(){
        //Arrange
        int[] array = {1,2,3,12, 222, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {367};
        int[] result = myArray.getNumbersCrescentatLeastXSequence(3);
        //Act
        assertArrayEquals(expected, result);}
    @Test
    void getNumbersCrescentatLeastSequenceXEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[] array = {};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        Exception exception = new Exception(assertThrows(IllegalArgumentException.class, () ->
                myArray.getNumbersCrescentatLeastXSequence(3)));
        //Assert
        assertTrue(exception.getMessage().contains("Array is empty"));}
    @Test
    void getNumbersCrescentatLeastSequenceNegativeInvalid()throws IllegalArgumentException{
        //Arrange
        int[] array = {1,2,3,12, 222, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        Exception exception = new Exception(assertThrows(IllegalArgumentException.class, () ->
                myArray.getNumbersCrescentatLeastXSequence(-1)));
        //Assert
        assertTrue(exception.getMessage().contains("Invalid Value"));}
    @Test
    void getNumbersCrescentatLeastSequence1Invalid()throws IllegalArgumentException{
        //Arrange
        int[] array = {1,2,3,12, 222, 367, 42, 51, 61, 74, 81, 91};
        //Act
        CustomArray myArray = new CustomArray(array);
        //Act
        Exception exception = new Exception(assertThrows(IllegalArgumentException.class, () ->
                myArray.getNumbersCrescentatLeastXSequence(1)));
        //Assert
        assertTrue(exception.getMessage().contains("Invalid Value"));}
    @Test
    void getNumbersCrescentatLeastSequenceXNoSequence(){
        //Arrange
        int[] array = {1,2,3,12, 222, 364, 42, 51, 61, 743, 811, 912};
        //Act
        CustomArray myArray = new CustomArray(array);
        int[] expected = {};
        int[] result = myArray.getNumbersCrescentatLeastXSequence(3);
        //Act
        assertArrayEquals(expected, result);}

    }
