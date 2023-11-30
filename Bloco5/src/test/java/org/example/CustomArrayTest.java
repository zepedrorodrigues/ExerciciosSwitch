package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {
    @Test
    void testConstructor() {
        //Arrange
        Array array = new Array();
        //Act
        int[] exp = new int[0];
        //Assert
        assertEquals(exp.length, array.getSize());
    }


    @Test
    void testConstructorWithNullArray() throws NullPointerException {
        //Arrange, Act and Assert
        assertThrows(NullPointerException.class, () -> new Array(null));
    }

    @Test
    void removeFirstValueValid() {
        //Arrange
        int[] array = {1, 2, 3};
        int value = 2;
        //Act
        Array myArray = new Array(array);
        int[] exp = {1, 3};
        myArray.removeFirstValue(value);
        //Assert
        assertEquals(myArray.getSize(), exp.length);
        assertEquals(2,myArray.average());}

    @Test
    void removeFirstValueInexistant() throws IllegalArgumentException {
        //Arrange
        int[] array = {1, 2, 3};
        int value = 4;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.removeFirstValue(value));}

    @Test
    void removeFirstValueArrayVazio() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        int value = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.removeFirstValue(value));
    }

    @Test
    void returnElement() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        int exp = 2;
        //Act
        int res = myArray.returnElement(1);
        //Assert
        assertEquals(exp, res);}
    @Test
    void returnElementpositionZero(){
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        int exp = 1;
        //Act
        int res = myArray.returnElement(0);
        //Assert
        assertEquals(exp, res);}

    @Test
    void returnElementNegativePosition() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        String expectedMessage = "Argumento Inválido.";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(-3));
        //Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));}
    @Test
    void returnElementPositionEqualsLength()throws IllegalArgumentException{
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        String expectedMessage = "Argumento Inválido.";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(3));
        //Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));}

    @Test
    void returnElementOutsideArray() throws IllegalArgumentException {
        //Arrange
        int[] array1 = {1, 2, 3};
        //Act
        Array myArray = new Array(array1);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(4));
    }

    @Test
    void getsizeArrayVazio() {
        //Arrange
        int[] array = {};
        int exp = 0;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.getSize());
    }

    @Test
    void getSizeArrayValido() {
        //Arrange
        int[] array = {1, 2, 3};
        int exp = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.getSize());
    }

    @Test
    void getSizeArrayNull() throws NullPointerException {
        assertThrows(NullPointerException.class, () -> new Array(null));
    }

    @Test
    void testReturnBiggestElement() {
        //Arrange
        int[] array = {1, 2, 3};
        int exp = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.largest());
    }

    @Test
    void testReturnBiggestElementArrayVazio() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::largest);
    }

    @Test
    void testReturnSmallestElement() {
        //Arrange
        int[] array = {1, 2, 3};
        int exp = 1;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.smallest());
    }

    @Test
    void testReturnSmallestElementAllEqual() {
        //Arrange
        int[] array = {1, 1, 1};
        int exp = 1;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.smallest());
    }

    @Test
    void testReturnAverageValid() {
        //Arrange
        int[] array = {-5, 0, 5};
        int exp = 0;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.average(), 0.01);
    }

    @Test
    void testReturnAverageEmpty() throws IllegalArgumentException {
        // Arrange
        int[] array = {};
        // Act
        Array myArray = new Array(array);
        // Assert
        assertThrows(IllegalArgumentException.class, myArray::average);
    }

    @Test
    void returnAverageOfEvenElementsValid() {
        //Arrange
        int[] array = {1, 2, 3, 4};
        int multiplo = 2;
        int exp = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.averageEvens());
    }

    @Test
    void returnAveragedOfEvenElementsEmpty() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        int multiplo = 2;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::averageOdds);
    }

    @Test
    void returnAverageOfOddElements() {
        //Arrange
        int[] array = {1, 2, 3, 4};
        int multiplo = 2;
        int exp = 2;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.averageOdds());
    }

    @Test
    void returnAverageMultiplesof3() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        int multiplo = 3;
        double exp = 9 / 2d;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.averageMultiples(multiplo));
    }


    @Test
    void returnAverageofMultiplesof3NoMultiples() throws IllegalArgumentException {
        //Arrange
        int[] array = {1, 2, 7, 4, 5, 11};
        int multiplo = 3;
        //Act
        Array myArray = new Array(array);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                myArray.averageMultiples(3));
        //Assert
        assertTrue(exception.getMessage().contains("Sem múltiplos"));
    }

    @Test
    void returnAverageNoArgumentsInvalid() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::average);
    }

    @Test
    void returnAverageNoArgumentsValid() {
        //Arrange
        int[] array = {1, 2, 3};
        int exp = 2;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.average());
    }

    @Test
    void testReturnArrayOrder() {
        //Arrange
        int[] array = {3, 2, 1};
        Array myArray = new Array(array);
        int[] exp = {1, 2, 3};
        //Act
        int[] res = myArray.returnArrayOrder(true);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void returnArrayOrderRepeatedNumbers() {
        //Arrange
        int[] array = {3, 2, 1, 1, 2, 3};
        Array myArray = new Array(array);
        int[] exp = {1, 1, 2, 2, 3, 3};
        //Act
        int[] res = myArray.returnArrayOrder(true);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void returnArrayOrderEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        Array myArray = new Array(array);
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.returnArrayOrder(true));
    }

    @Test
    void testReturnArrayReverseOrder() {
        //Arrange
        int[] array = {1, 2, 3};
        Array myArray = new Array(array);
        int[] exp = {3, 2, 1};
        //Act
        int[] res = myArray.returnArrayOrder(false);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void returnArrayReverseOrderRepeatedNumbers() {
        //Arrange
        int[] array = {3, 2, 1, 1, 2, 3};
        Array myArray = new Array(array);
        int[] exp = {3, 3, 2, 2, 1, 1};
        //Act
        int[] res = myArray.returnArrayOrder(false);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void overAverageAlgarisms() {
        //Arrange
        int[] array = {1, 24, 32, 4, 5, 63};
        //Act
        Array myArray = new Array(array);
        int[] exp = {24, 32, 63};
        int[] res = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAverageAlgarismsSome4DigitAlgarisms() {
        //Arrange
        int[] array = {1, 2, 342, 4, 5, 63, 1000};
        //Act
        Array myArray = new Array(array);
        int[] exp = {342, 63, 1000};
        int[] res = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAverageAlgarismsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::overAverageAlgarisms);
    }

    @Test
    void overAverageAlgarismsAllEqual() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAveragePairAlgarisms() {
        //Arrange
        int[] array = {1, 2, 342, 4, 5, 63, 1000};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2, 342, 4, 1000};
        int[] res = myArray.overAveragePairs();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAveragePairAlgarismsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::overAveragePairs);
    }

    @Test
    void overAveragePAirAlgarismsAllEqual100Pair() {
        //Arrange
        int[] array = {2, 2, 2};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.overAveragePairs();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAveragePairAlgarismsAllEqual0PercentPair() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.overAveragePairs();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAveragePairAlgarismsAllEqual50PercentPair() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2};
        int[] res = myArray.overAveragePairs();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void hasDuplicatesZero() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 10};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.hasDuplicates());
    }

    @Test
    void hasDuplicatesOne() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 10, 10};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.hasDuplicates());
    }

    @Test
    void hasDuplicatesAll() {
        //Arrange
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.hasDuplicates());
    }

    @Test
    void elementsWithOnlyEvenDigits() {
        //Arrange
        int[] array = {2, 4, 6, 8, 20};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2, 4, 6, 8, 20};
        int[] res = myArray.elementsWithOnlyEvenDigits();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void elementsWithOnlyEvenDigitsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::elementsWithOnlyEvenDigits);
    }

    @Test
    void elementsWithOnlyEvenDigitsAllOdd() {
        //Arrange
        int[] array = {1, 3, 5, 7, 9};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.elementsWithOnlyEvenDigits();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void elementsWithOnlyEvenDigitsSomeEven() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 10};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2, 4, 6};
        int[] res = myArray.elementsWithOnlyEvenDigits();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void noArmstrongNumbers() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 10, 10};
        //Act
        Array myArray = new Array(array);
        int[] exp = {10, 10};
        int[] res = myArray.noArmstrongNumbers();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void noArmstrongNumbersEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::noArmstrongNumbers);
    }

    @Test
    void noArmstrongNumbersAllArmstrong() {
        //Arrange
        int[] array = {153, 370, 371, 407};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.noArmstrongNumbers();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void findCapicuasValid() throws IllegalArgumentException {
        //Arrange
        int[] array = {-1, 0, 1, 10, 11, 100, 111, 998, 999};
        //Act
        Array myArray = new Array(array);
        int[] exp = {0, 1, 11, 111, 999};
        int[] res = myArray.findCapicuas();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void findCapicuasEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::findCapicuas);
    }

    @Test
    void findCapicuasNoCapicuas() {
        //Arrange
        int[] array = {12, 23, 34};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.findCapicuas();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void sameDigitsValid() {
        //Arrange
        int[] array = {1, 11, 121, 1111};
        //Act
        Array myArray = new Array(array);
        int[] exp = {1, 11, 1111};
        int[] res = myArray.sameDigits();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void sameDigitsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, myArray::sameDigits);
    }

    @Test
    void sameDigitsNoSameDigits() {
        //Arrange
        int[] array = {21, 23, 34, 45};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.sameDigits();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void crescentsAllOneDigitNumbers() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.crescents();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void crescentsEmptyArray() {
        //Arrange
        int[] array = {};
        Array myArray = new Array(array);
        //Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, myArray::crescents);
        //Assert
        String expectedMessage = "Array Vazio.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void crescentsValid() {
        //Arrange
        int[] array = {21, 12, 123, 1234, 12345};
        //Act
        Array myArray = new Array(array);
        int[] exp = {12, 123, 1234, 12345};
        int[] res = myArray.crescents();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void isAllEvenAllEven() {
        //Arrange
        int[] array = {2, 4, 6, 8, 20};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.isAllEven());
    }

    @Test
    void isAllEvenEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, () -> myArray.isAllEven());
    }

    @Test
    void isAllEvenSomeOdd() {
        //Arrange
        int[] array = {2, 4, 6, 8, 21};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllEven());
    }

    @Test
    void isAllEvenAllOdds() {
        //Arrange
        int[] array = {1, 3, 5, 7, 9};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllEven());
    }

    @Test
    void isAllOdds() {
        //Arrange
        int[] array = {1, 3, 5, 7, 9};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.isAllOdds());
    }

    @Test
    void isAllOddsEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, () -> myArray.isAllOdds());
    }

    @Test
    void isAllOddsSomeEven() {
        //Arrange
        int[] array = {1, 3, 5, 7, 8};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllOdds());
    }

    @Test
    void isAllOddsAllEven() {
        //Arrange
        int[] array = {2, 4, 6, 8, 20};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllOdds());
    }

    @Test
    void equalsArray() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertTrue(myArray.equalsArray(array1));
    }

    @Test
    void equalsArrayDifferentSize() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.equalsArray(array1));
    }

    @Test
    void averageMultiplesEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> myArray.averageMultiples(3));
        assertTrue(exception.getMessage().contains("Array Vazio."));
    }

    @Test
    void isEmptyTrue() {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertTrue(myArray.isEmpty());
    }

    @Test
    void isEmptyFalse() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.isEmpty());
    }

    @Test
    void onlyOneelement() {
        //Arrange
        int[] array = {1};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertTrue(myArray.onlyOneElement());
    }

    @Test
    void onlyOneElementFalse() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.onlyOneElement());
    }

    @Test
    void crescentForMin3Valid() {
        //Arrange
        int[] array = {123, 245, 311, 42, 51};
        //Act
        Array myArray = new Array(array);
        int[] expected = {123, 245};
        int[] result = myArray.crescentforMin(3);
        //Assert
        assertArrayEquals(expected, result);}
    @Test
    void crescentforMin1AllAre(){
        //Arrange
        int[] array = {123, 245, 311, 42, 51};
        //Act
        Array myArray = new Array(array);
        int[] expected = {123, 245, 311, 42, 51};
        int[] result = myArray.crescentforMin(1);
        //Assert
        assertArrayEquals(expected, result);}

    @Test
    void crescentforMinZero(){
        //Arrange
        int[] array = {123, 245, 311, 42, 51};
        //Act
        Array myArray = new Array(array);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> myArray.crescentforMin(0));
        //Assert
        assertTrue(exception.getMessage().contains("Argumento Inválido."));}


    @Test
    void crescentForMin2NoONe() {
        //Arrange
        int[] array = {100, 211, 311, 42, 51};
        //Act
        Array myArray = new Array(array);
        int[] expected = {};
        int[] result = myArray.crescentforMin(2);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void crescentForMin3EmptyArray() {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.crescentforMin(3));
    }

    @Test
    void equalsArrays() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertTrue(myArray.equalsArray(array1));
    }

    @Test
    void equalsArraysFalse() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.equalsArray(array1));
    }

    @Test
    void equalsArraysDifferentSize() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.equalsArray(array1));
    }

    @Test
    void equalsArraysDifferentElements() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.equalsArray(array1));
    }

    @Test
    void equalsArraysNull() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = null;
        //Act
        Array myArray = new Array(array);
        //Assert
        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> myArray.equalsArray(array1));
        assertTrue(exception.getMessage().contains("Array Nulo."));
    }
    @Test
    void smallestEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::smallest);}

    @Test
    void averageEvensEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::averageEvens);}

    @Test
    void removeFirstValueValidValueinIndex0(){
        //Arrange
        int[] array = {1,2,3};
        int value = 1;
        //Act
        Array myArray = new Array(array);
        int[] exp = {2,3};
        myArray.removeFirstValue(value);
        //Assert
        assertEquals(myArray.getSize(), exp.length);}
    @Test
    void removeFirstValueLastIndex(){
        //Arrange
        int[] array = {1,2,3};
        int value = 3;
        //Act
        Array myArray = new Array(array);
        int[] exp = {1,2};
        myArray.removeFirstValue(value);
        //Assert
        assertEquals(myArray.getSize(), exp.length);}
    @Test
    void removeFirstValueIndexEqualsLength()throws IllegalArgumentException{
        //Arrange
        int[] array = {1,2,3};
        int value = 4;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.removeFirstValue(value));}
    @Test
    void removeFirstValueEmptyArray(){
        //Arrange
        int[] array = {};
        int value = 4;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(myArray.getSize(),array.length);}
    }
