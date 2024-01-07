package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    /**
     * alínea c.
     */

    @Test
    void testAddValid() {
        //Arrange
        int[] array = {1, 2, 3};
        int value = 4;
        int[] exp = {1, 2, 3, 4};
        Array myArray = new Array(array);
        //Act
        myArray.add(value);
        //Assert
        assertEquals(myArray.getSize(), exp.length);
    }

    @Test
    void testAddEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        int value = 3;
        int[] exp = {3};
        Array myArray = new Array(array);
        //Act
        myArray.add(value);
        //Assert
        assertEquals(myArray.getSize(), exp.length);
    }

    /**
     * alínea d.
     */

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
    }

    @Test
    void removeFirstValueInexistant() throws IllegalArgumentException {
        //Arrange
        int[] array = {1, 2, 3};
        int value = 4;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.removeFirstValue(value));
    }

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

    /**
     * alínea e.
     */
    @Test
    void returnElementLowerBoundary() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        int exp = 1;
        //Act
        int res = myArray.returnElement(0);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void returnElementNegativePosition() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        String expectedMessage = "Argumento Inválido.";
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(-1));
        //Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void returnElementUpperBoundary() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        int exp = 3;
        //Act
        int res = myArray.returnElement(2);
        //Assert
        assertEquals(exp, res);
    }

    @Test
    void returnElementOutsideArray() throws IllegalArgumentException {
        //Arrange
        int[] array1 = {1, 2, 3};
        //Act
        Array myArray = new Array(array1);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(3));
    }

    /**
     * alínea f.
     */
    @Test
    void getSizeArrayEmpty() {
        //Arrange
        int[] array = {};
        int exp = 0;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.getSize());
    }

    @Test
    void getSizeArrayValid() {
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

    /**
     * alínea g.
     */
    @Test
    void testReturnLargestElement() {
        //Arrange
        int[] array = {1, 2, 3};
        int exp = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(exp, myArray.largest());
    }

    @Test
    void testReturnLargestElementArrayVazio() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::largest);
    }

    /**
     * alínea h.
     */
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
    void returnSmallestEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, myArray::smallest);
        assertTrue(exception.getMessage().contains("Array Vazio."));
    }

    /**
     * alínea i.
     */
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

    /**
     * alínea j.
     */
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
    void returnAverageEvensEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, myArray::averageEvens);
        assertTrue(exception.getMessage().contains("Array Vazio."));
    }

    @Test
    void mediaParesSemPares() {
        // Arrange
        int[] array = {1, 1, 1};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::averageEvens);
    }

    /**
     * alínea k.
     */
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
    void returnAveragedOfOddsElementsEmpty() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::averageOdds);
    }

    @Test
    void returnAverageOfOddsWithoutOdds() {
        // Arrange
        int[] array = {2, 2, 2};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::averageOdds);
    }

    /**
     * alínea l.
     */
    @Test
    void returnAverageMultiplesValid() {
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
    void returnAverageMultiplesEmpty() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        int multiplo = 3;
        //Act
        Array myArray = new Array(array);
        //Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> myArray.averageMultiples(multiplo));
        assertTrue(exception.getMessage().contains("Array Vazio."));
    }

    @Test
    void returnAverageOfMultiplesNoMultiples() throws IllegalArgumentException {
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
        assertThrows(IllegalArgumentException.class, () -> myArray.average());
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

    /**
     * alínea m.
     */
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

    /**
     * alínea n.
     */
    @Test
    void isEmptyArrayValid() {
        //Arrange
        int[] array = {};
        Array myArray = new Array(array);
        //Act
        boolean res = myArray.isEmpty();
        //Assert
        assertTrue(res);
    }

    @Test
    void isEmptyArrayInvalid() {
        //Arrange
        int[] array = {1, 2, 3};
        Array myArray = new Array(array);
        //Act
        boolean res = myArray.isEmpty();
        //Assert
        assertFalse(res);
    }

    /**
     * alínea o.
     */
    @Test
    void onlyOneElementValid() {
        //Arrange
        int[] array = {1};
        Array myArray = new Array(array);
        //Act
        boolean res = myArray.onlyOneElement();
        //Assert
        assertTrue(res);
    }

    @Test
    void onlyOneElementMoreElements() {
        //Arrange
        int[] array = {1, 2, 3};
        Array myArray = new Array(array);
        //Act
        boolean res = myArray.onlyOneElement();
        //Assert
        assertFalse(res);
    }

    @Test
    void onlyOneElementEmptyArray() {
        //Arrange
        int[] array = {};
        Array myArray = new Array(array);
        //Act
        boolean res = myArray.onlyOneElement();
        //Assert
        assertFalse(res);
    }

    /**
     * alínea p.
     */
    @Test
    void isAllEvenValid() {
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
    void isAllEvenFalse() {
        //Arrange
        int[] array = {2, 4, 6, 8, 21};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllEven());
    }


    /**
     * alínea q.
     */
    @Test
    void isAllOddsTrue() {
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
    void isAllOddsFalse() {
        //Arrange
        int[] array = {1, 3, 5, 7, 8};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllOdds());
    }

    /**
     * alínea r.
     */
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
    void hasDuplicatesEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, () -> myArray.hasDuplicates());
    }

    /**
     * alínea s.
     */

    @Test
    void overAverageAlgarisms() {
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
    void overAverageAlgarismsAllinAverage1Digit() {
        //Arrange
        int[] array = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.overAverageAlgarisms();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAverageAlgarismsNegativesAndZero() {
        //Arrange
        int[] array = {1, 2, 3, 4, 0, -12};
        //Act
        Array myArray = new Array(array);
        int[] exp = {-12};
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

    /**
     * alínea t.
     */
    @Test
    void overAveragePairAlgarisms() {
        //Arrange
        int[] array = {1, 2, 342, -4, 5, 63, 1000};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2, 342, -4, 1000};
        int[] res = myArray.overAveragePercentagePairs();
        //Act
        assertArrayEquals(exp, res);
    }

    @Test
    void overAveragePairAlgarismswithZero() {
        //Arrange
        int[] array = {1, 2, 342, 0, 5, 63, 1000};
        //Act
        Array myArray = new Array(array);
        int[] exp = {2, 342, 0, 1000};
        int[] res = myArray.overAveragePercentagePairs();
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
        assertThrows(IllegalArgumentException.class, myArray::overAveragePercentagePairs);
    }

    @Test
    void overAveragePAirAlgarismsAllEqual100Pair() {
        //Arrange
        int[] array = {2, 2, 2};
        //Act
        Array myArray = new Array(array);
        int[] exp = {};
        int[] res = myArray.overAveragePercentagePairs();
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
        int[] res = myArray.overAveragePercentagePairs();
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
        int[] res = myArray.overAveragePercentagePairs();
        //Act
        assertArrayEquals(exp, res);
    }


    /**
     * alínea u.
     */
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

    /**
     * alínea v.
     */
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

    /**
     * alínea w.
     */
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

    /**
     * alínea x.
     */
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


    /**
     * alínea y.
     */
    @Test
    void noArmstrongNumbers() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6, 10, 10};
        //Act
        Array myArray = new Array(array);
        int[] exp = {10, 10};
        int[] res = myArray.noArmstrongNumbers();
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void noArmstrongNumbersEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
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
        //Assert
        assertArrayEquals(exp, res);
    }

    /**
     * alínea z.
     */
    @Test
    void crescentForMinValid() {
        //Arrange
        int[] array = {123, 122, 1234};
        int number = 3;
        int[] exp = {123, 1234};
        Array myArray = new Array(array);
        //Act
        int[] res = myArray.crescentForMin(number);
        //Assert
        assertArrayEquals(exp, res);
    }

    @Test
    void crescentForMinEmptyArray() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        int number = 5;
        Array myArray = new Array(array);
        //Act
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.crescentForMin(number));
    }

    @Test
    void crescentForMinNoResults() {
        //Arrange
        int[] array = {543, 955, 9873};
        int number = 2;
        int[] exp = {};
        Array myArray = new Array(array);
        //Act
        int[] res = myArray.crescentForMin(number);
        //Assert
        assertArrayEquals(exp, res);

    }

    /**
     * alínea aa.
     */
    @Test
    void equalsArrayValid() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertTrue(myArray.equalsArray(array1));
    }

    @Test
    void equalsArrayWithDifferentValues() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 9, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertFalse(myArray.equalsArray(array1));
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
    void equalsArrayinputNull() throws NullPointerException {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = null;
        //Act
        Array myArray = new Array(array);
        //Assert
        NullPointerException exception = assertThrows(NullPointerException.class, () -> myArray.equalsArray(array1));
        assertTrue(exception.getMessage().contains("Array Nulo."));
    }

    @Test
    void equalsArrayEmptyArray() {
        //Arrange
        int[] array = {};
        int[] array1 = {};
        //Act
        Array myArray = new Array(array);
        Array myArray1 = new Array(array1);
        //Assert
        assertTrue(myArray.equalsArray(myArray1));
    }

    @Test
    void equalsArrayDifferentArrayFalsE() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        Array myArray1 = new Array(array1);
        //Assert
        assertFalse(myArray.equalsArray(myArray1));
    }

    @Test
    void equalsArrayDifferentNumbersSameSize() {
        //Arrange
        int[] array = {1, 2, 3};
        int[] array1 = {1, 2, 4};
        //Act
        Array myArray = new Array(array);
        Array myArray1 = new Array(array1);
        //Assert
        assertFalse(myArray.equalsArray(myArray1));
    }
}




