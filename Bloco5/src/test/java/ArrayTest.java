import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ArrayTest {
    @Test
    void arrayValidConstructorArgument() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array a = new Array(array);
        /*Assert não necessário, só desejamos ver se dá erro*/}

    @Test
    void arrayInvalidConstructorArgument() throws InstantiationException {
        //Arrange and Act
        int[] array = null;
        //Assert
        assertThrows(InstantiationException.class, () -> {new Array(array);});}

    @Test
    void arrayVazioConstrutorSemParametros() throws InstantiationException {
        //Arrange, Act and Assert - tudo o mesmo porque chamamos construtor sem parâmetros
        Array a = new Array();}

    @Test
    void arrayVazionoConstrutorcomParametro() throws InstantiationException {
        int[] array = {};
        Array a = new Array(array);}

    @Test
    void getArrayWithValueXArrayNull() throws InstantiationException {
        //Arrange
        int[] array = null;
        //Assert
        assertThrows(InstantiationException.class, () ->{new Array(array);});}
    
    @Test
    void getMenorElementoValid() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getMenorElemento();
        //Assert
        assertEquals(1, result);}
    
    @Test
    void getMenorElementoInvalid() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        //Act
        Exception exception = assertThrows(InstantiationException.class,()->{newArray.getMenorElemento();});
        //Assert
        String expectedMessage = "Invalid Argument";
        assertEquals(expectedMessage, exception.getMessage());}
    @Test
    void addElementValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int[] expected = {1,2,3,4};
        int[] result = a.addElement(4);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void addElementInvalido()throws InstantiationException {
        //Arrange
        int[] array = null;
        //Assert
        Exception exception = assertThrows(InstantiationException.class,()->
        {new Array(array);});
        assertEquals("Invalid Argument", exception.getMessage());}

    @Test
    void getMaiorElementoValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getMaiorElemento();
        //Assert
        assertEquals(3, result);}
    @Test
    void getMaiorElementoInvalido() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array newArray = new Array(array);
        //Act
        Exception exception = assertThrows(InstantiationException.class,()->{newArray.getMaiorElemento();});
        //Assert
        String expectedMessage = "Invalid Argument";
        assertEquals(expectedMessage, exception.getMessage());}

    @Test
    void getSizeValido() throws InstantiationException {
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getSize();
        //Assert
        assertEquals(3, result);}
    @Test
    void getSizeArrayVazio() throws InstantiationException {
        //Arrange
        int[] array = {};
        Array a = new Array(array);
        //Act
        int result = a.getSize();
        //Assert
        assertEquals(0, result);}
    @Test
    void removeElementValid()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int[] expected = {1,2};
        int[] result = a.removeElement(3);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void removeElementInvalid()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int[] expected = {1,2,3};
        int[] result = a.removeElement(4);
        //Assert
        assertArrayEquals(expected,result);}
    @Test
    void getElementbyIndexValid()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(2);
        //Assert
        assertEquals(3,result);}
    @Test
    void getElementbyIndexInvalid()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(3);
        //Assert
        assertEquals(-1,result);}
    @Test
    void getElementbyIndex0()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(0);
        //Assert
        assertEquals(1,result);}
    @Test
    void getElementbyIndexNegative()throws InstantiationException{
        //Arrange
        int[] array = {1, 2, 3};
        Array a = new Array(array);
        //Act
        int result = a.getElementbyIndex(-1);
        //Assert
        assertEquals(-1,result);}
    }