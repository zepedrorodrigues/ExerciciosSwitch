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
    void getMenorElementoInvalid() throws InstantiationException, IllegalArgumentException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        assertThrows(IllegalArgumentException.class,()->{newArray.getMenorElemento();});}

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
    void getMaiorElementoInvalido() throws InstantiationException, IllegalArgumentException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, newArray::getMaiorElemento);}

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
    void averageArrayInvalid() throws InstantiationException, IllegalArgumentException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> a.averageArray(array));}

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
        assertArrayEquals(expected, result);}
}