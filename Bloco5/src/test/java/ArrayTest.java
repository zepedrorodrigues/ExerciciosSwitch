import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ArrayTest {
    @Test
    void arrayValidConstructorArgument() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array a = new Array(array);
        /*Assert não necessário, só desejamos ver se dá erro*/
    }

    @Test
    void arrayInvalidConstructorArgument() throws InstantiationException {
        //Arrange and Act
        int[] array = null;
        //Assert
        assertThrows(InstantiationException.class, () -> new Array(null));
    }

    @Test
    void arrayVazioConstrutorSemParametros() throws InstantiationException {
        //Arrange, Act and Assert - tudo o mesmo porque chamamos construtor sem parâmetros
        Array a = new Array();
    }

    @Test
    void arrayVazionoConstrutorcomParametro() throws InstantiationException {
        int[] array = {};
        Array a = new Array(array);
    }

    @Test
    void getArrayWithValueXArrayNull() throws InstantiationException {
        //Arrange
        int[] array = null;
        //Assert
        assertThrows(InstantiationException.class, () -> new Array(null));
    }

    @Test
    void getMenorElementoValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getMenorElemento();
        //Assert
        assertEquals(1, result);
    }

    @Test
    void getMenorElementoInvalid() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        //Act
        Exception exception = assertThrows(InstantiationException.class, newArray::getMenorElemento);
        //Assert
        String expectedMessage = "Invalid Argument";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void addElementValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act & Assert (if no Throw everything went ok
        a.addElement(4);
    }

    @Test
    void addElementInvalido() throws InstantiationException {
        //Arrange
        int[] array = null;
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                new Array(null));
        assertEquals("Invalid Argument", exception.getMessage());
    }

    @Test
    void getMaiorElementoValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getMaiorElemento();
        //Assert
        assertEquals(3, result);
    }

    @Test
    void getMaiorElementoInvalido() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        //Act
        Exception exception = assertThrows(InstantiationException.class, newArray::getMaiorElemento);
        //Assert
        String expectedMessage = "Invalid Argument";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getSizeValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getSize();
        //Assert
        assertEquals(3, result);
    }

    @Test
    void getSizeArrayVazio() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Act
        int result = a.getSize();
        //Assert
        assertEquals(0, result);
    }

    @Test
    void removeElementValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        a.removeElement(3);
        //Assert
    }

    @Test
    void removeElementInvalid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class,()->{a.removeElement(4);});
    }

    @Test
    void getElementbyIndexValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(2);
        //Assert
        assertEquals(3, result);
    }

    @Test
    void getElementbyIndexInvalid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(3);
        //Assert
        assertEquals(-1, result);
    }

    @Test
    void avertageArrayValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Act
        int result = a.averageArray(array);
        //Assert
        assertEquals(3, result);
    }

    @Test
    void averageArrayInvalid() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                a.averageArray(array));
        assertEquals("Invalid Argument", exception.getMessage());
    }

    @Test
    void averageArrayOneDigit() throws InstantiationException {
        //Arrange
        int[] array = {1};
        Array a = new Array(array);
        //Act
        int result = a.averageArray(array);
        //Assert
        assertEquals(1, result);
    }

    @Test
    void averagerrayAllZeros() throws InstantiationException {
        //Arrange
        int[] array = {0, 0, 0, 0, 0, 0};
        Array a = new Array(array);
        //Act
        int result = a.averageArray(array);
        //Assert
        assertEquals(0, result);
    }

    @Test
    void sumofArrayValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Act
        int result = a.sumOfArray(array);
        //Assert
        assertEquals(21, result);
    }

    @Test
    void getmultiplesofNummbervalid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expected = {2, 4, 6};
        Array a = new Array(array);
        //Act
        int[] result = a.getmultiplesofNumber(2, true);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void getmultiplesofNumberZero() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                a.getmultiplesofNumber(0, true));
        assertEquals("Invalid Argument", exception.getMessage());
    }

    @Test
    void getMultiplesofNumber1AllNumbers() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Act
        int[] result = a.getmultiplesofNumber(1, true);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void getMultiplesofNumber3NoMultiples() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        int[] expected = {};
        Array a = new Array(array);
        //Act
        int[] result = a.getmultiplesofNumber(3, true);
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void getNotMultiplesof3() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        int[] expected = {7, 2, 8, 4, 5, 11};
        Array a = new Array(array);
        //Act
        int[] result = a.getmultiplesofNumber(3, false);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void getNotMultiplesofNumber0() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                a.getmultiplesofNumber(0, false));
        assertEquals("Invalid Argument", exception.getMessage());
    }
    @Test
    void getNotMultiplesof1AllNumbers() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        int[] expected = {};
        Array a = new Array(array);
        //Act
        int[] result = a.getmultiplesofNumber(1, false);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void getSortedArrayValid() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        int[] expected = {2, 4, 5, 7, 8, 11};
        Array a = new Array(array);
        //Act
        int[] result = a.getSortedArray(true);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void getSortedArrayVazio() throws InstantiationException {
        //Arrange
        int[] array = {};
        int[] expected = {};
        Array a = new Array(array);
        //Act
        int[] result = a.getSortedArray(true);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void getSortedArrayDescendente() throws InstantiationException {
        //Arrange
        int[] array = {7, 2, 8, 4, 5, 11};
        int[] expected = {11, 8, 7, 5, 4, 2};
        Array a = new Array(array);
        //Act
        int[] result = a.getSortedArray(false);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void getSortedArrayAscendenteTodosIguais() throws InstantiationException {
        //Arrange
        int[] array = {1, 1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1, 1};
        Array a = new Array(array);
        //Act
        int[] result = a.getSortedArray(true);
        //Assert
        assertArrayEquals(expected, result);
    }
    @Test
    void hasXElementsValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 1, 1, 1, 1, 1};
        Array a = new Array(array);
        //Act
        boolean result = a.hasXElements(6);
        //Assert
        assertTrue(result);}
    @Test
    void hasXElementsZeroElements() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Act
        boolean result = a.hasXElements(0);
        //Assert
        assertTrue(result);}
    @Test
    void hasXElementsInvalid() throws InstantiationException {
        //Arrange
        int[] array = {1, 1, 1, 1, 1, 1};
        Array a = new Array(array);
        //Act
        boolean result = a.hasXElements(7);
        //Assert
        assertFalse(result);}
    @Test
    void hasXElementsXequalsNegative()throws InstantiationException{
        //Arrange
        int[] array = {1, 1, 1, 1, 1, 1};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                a.hasXElements(-1));
        assertEquals("Invalid Argument", exception.getMessage());}
    @Test
    void isAllEvensorOddsValid() throws InstantiationException {
        //Arrange
        int[] array = {2, 4, 6, 8, 10, 12};
        Array a = new Array(array);
        //Act
        boolean result = a.isAllEvensorOdds(true);
        //Assert
        assertTrue(result);}
    @Test
    void isAllEvensorOddsInvalid() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, () ->
                a.isAllEvensorOdds(true));
        assertEquals("Invalid Argument", exception.getMessage());}
    @Test
    void isAllEvensorOddsAllOdds() throws InstantiationException {
        //Arrange
        int[] array = {1, 3, 5, 7, 9, 11};
        Array a = new Array(array);
        //Act
        boolean result = a.isAllEvensorOdds(false);
        //Assert
        assertTrue(result);}
    @Test
    void isAllEvensorOdds() throws InstantiationException {
        //Arrange
        int[] array = {2, 4,6, 8, 10, 12};
        Array a = new Array(array);
        //Act
        boolean result = a.isAllEvensorOdds(false);
        //Assert
        assertFalse(result);}
    @Test
    void isAllOddsSomeAre() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Act
        boolean result = a.isAllEvensorOdds(false);
        //Assert
        assertFalse(result);}
    @Test
    void valoresRepetidosSemRepeticoesFalso() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        Array a = new Array(array);
        //Act
        boolean result = a.valoresRepetidos();
        //Assert
        assertFalse(result);}
    @Test
    void valoresRepetidoscomRepeticoesVerdadeiro() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 5};
        Array a = new Array(array);
        //Act
        boolean result = a.valoresRepetidos();
        //Assert
        assertTrue(result);}
    @Test
    void valoresRepetidosArrayVazio() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Act
        boolean result = a.valoresRepetidos();
        //Assert
        assertFalse(result);}

    @Test
    void getElementsWithMoreDigitsThanAverageValid() throws InstantiationException {
        //Arrange
        int[] array = {12, 23, 34, 47, 519, 6};
        int[] expected = {519};
        Array a = new Array(array);
        //Act
        int[] result = a.getElementsWithMoreDigitsThanAverage();
        //Assert
        assertArrayEquals(expected, result);}
    @Test
    void getElementsWithMoreDigitsThanAvgInvalid()throws InstantiationException{
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, a::getElementsWithMoreDigitsThanAverage);
        assertEquals("Invalid Argument", exception.getMessage());}
    @Test
    void getElementsWithMoreDigitsThanAvgAllinAverage()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] expected = {};
        Array a = new Array(array);
        //Act
        int[] result = a.getElementsWithMoreDigitsThanAverage();
        //Assert
        assertArrayEquals(expected, result);}

    @Test
    void getElementsMoreEvenAlgarismsThanAverage()throws InstantiationException{
        //Arrange
        int[] array = {12, 23, 34, 47, 519, 6};
        int[] expected = {6};
        Array a = new Array(array);
        //Act
        int[] result = a.getElementsMoreEvenAlgarismsThanAverage();
        //Assert
        assertArrayEquals(expected, result);}
    @Test
    void getElementsMoreEvenAlgarismsThanAverageInvalid()throws InstantiationException{
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Assert
        Exception exception = assertThrows(InstantiationException.class, a::getElementsMoreEvenAlgarismsThanAverage);
        assertEquals("Invalid Argument", exception.getMessage());}
    @Test
    void getElementsMoreEvenAlgarismsThanAverageAllinAverage()throws InstantiationException{
        //Arrange
        int[] array = {1, 11, 3, 9, 5, 7};
        int[] expected = {};
        Array a = new Array(array);
        //Act
        int[] result = a.getElementsMoreEvenAlgarismsThanAverage();
        //Assert
        assertArrayEquals(expected, result);}
}

