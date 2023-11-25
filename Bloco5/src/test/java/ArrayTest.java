import org.example.Array;
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
        assertArrayEquals(array.getArray(), exp);
    }

    @Test
    void testConstructorWithArray() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array array1 = new Array(array);
        //Assert
        assertArrayEquals(array1.getArray(), array);
    }

    @Test
    void testConstructorWithNullArray() throws NullPointerException {
        //Arrange, Act and Assert
        assertThrows(NullPointerException.class, () -> new Array(null));}

    @Test
    void testgetArrayVazio() throws InstantiationException {
        //Arrange
        int[] array = new int[0];
        //Act
        Array myArray = new Array(array);
        //Assert
        assertArrayEquals(myArray.getArray(), array);
    }

    @Test
    void testConstructorWithNewElement(){
        //Arrange
        int[] array = {1, 2, 3};
        Array myArray = new Array(array);
        myArray.add(4);
        int[] result = myArray.getArray();
        int[] expected = {1, 2, 3, 4};
        //Act
        //Assert
        assertArrayEquals(expected, result);
    }

    @Test
    void removeFirstValueValid() {
        //Arrange
        int[] array = {1, 2, 3};
        Array myArray = new Array(array);
        int value = 2;
        myArray.removeFirstValue(value);
        //Act
        int[] expected = {1, 3};
        int[] result = myArray.getArray();
        assertArrayEquals(expected, result);
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

    @Test
    void returnElement() {
        //Arrange
        int[] Array = {1, 2, 3};
        Array myArray = new Array(Array);
        int exp = 2;
        //Act
        int res = myArray.returnElement(1);
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myArray.returnElement(-3));
        //Assert
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

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
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(0, myArray.getSize());
    }

    @Test
    void getSizeArrayValido() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(3, myArray.getSize());
    }

    @Test
    void getSizeArrayNull() throws NullPointerException {
        assertThrows(NullPointerException.class, () -> new Array(null));
    }

    @Test
    void testReturnBiggestElement() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(3, myArray.returnLargestSmallestElement(true));
    }

    @Test
    void testReturnBiggestElementArrayVazio() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                myArray.returnLargestSmallestElement(true));
    }

    @Test
    void testReturnSmallestElement(){
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(1, myArray.returnLargestSmallestElement(false));
    }

    @Test
    void testReturnSmallestElementAllEqual() {
        //Arrange
        int[] array = {1, 1, 1};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(1, myArray.returnLargestSmallestElement(false));
    }

    @Test
    void testReturnAverageValid() {
        //Arrange
        int[] array = {-5, 0, 5};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(0, myArray.returnAverage(array));
    }

    @Test
    void testReturnAverageEmpty() throws IllegalArgumentException {
        // Arrange
        int[] array = {};
        // Act
        Array myArray = new Array(array);
        // Assert
        assertThrows(IllegalArgumentException.class, () ->
                myArray.returnAverage(myArray.getArray()));
    }

    @Test
    void returnAverageOfEvenElementsValid() {
        //Arrange
        int[] array = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(3, myArray.returnAverage(myArray.getmultiplesofNumber(2, true)));
    }

    @Test
    void returnAveragedOfEvenElementsEmpty() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                myArray.returnAverage(myArray.getmultiplesofNumber(2, true)));
    }

    @Test
    void returnAverageOfOddElements(){
        //Arrange
        int[] array = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(2, myArray.returnAverage(myArray.getmultiplesofNumber(2, false)));
    }

    @Test
    void getMultiplesOfNumber(){
        //Arrange
        int[] array = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertArrayEquals(new int[]{2, 4}, myArray.getmultiplesofNumber(2, true));
    }

    @Test
    void getNotMulitplesofNumber() {
        //Arrange
        int[] array = {1, 2, 3, 4};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertArrayEquals(new int[]{1, 3}, myArray.getmultiplesofNumber(2, false));
    }

    @Test
    void getNotMultiplesofNumberEmptyArray() throws IllegalArgumentException{
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.getmultiplesofNumber(2, false));
    }

    @Test
    void getMultiplesofNumberMultiplesofZero() throws IllegalArgumentException{
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () -> myArray.getmultiplesofNumber(0, true));
    }

    @Test
    void getMultiplesofNumber1() {
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertArrayEquals(new int[]{1, 2, 3}, myArray.getmultiplesofNumber(1, true));
    }

    @Test
    void returnAverageMultiplesof3() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(9 / 2d, myArray.returnAverage(myArray.getmultiplesofNumber(3, true)));
    }

    @Test
    void returnAverageNotMultiplesof7() {
        //Arrange
        int[] array = {1, 2, 3, 4, 5, 6};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(21 / 6d, myArray.returnAverage(myArray.getmultiplesofNumber(7, false)));
    }

    @Test
    void returnAverageofMultiplesof3NoMultiples() throws IllegalArgumentException {
        //Arrange
        int[] array = {1, 2, 7, 4, 5, 11};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
                myArray.returnAverage(myArray.getmultiplesofNumber(3, true)));
    }

    @Test
    void returnAverageNoArgumentsInvalid() throws IllegalArgumentException {
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertThrows(IllegalArgumentException.class, myArray::returnAverage);
    }

    @Test
    void returnAverageNoArgumentsValid(){
        //Arrange
        int[] array = {1, 2, 3};
        //Act
        Array myArray = new Array(array);
        //Assert
        assertEquals(2, myArray.returnAverage());
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
        assertArrayEquals(exp, res);}

    @Test
    void lengthTesterLength1(){
        //Arrange
        int[] array = {1};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.lengthTester(1));}
    @Test
    void lengthTesterVazio(){
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.lengthTester(0));}
    @Test
    void isAllEvenorOddsAllEven(){
        //Arrange
        int[] array = {2, 4, 6};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.isAllEvenorOdds(true));}
    @Test
    void isAllEvenorOddsAllOdd(){
        //Arrange
        int[] array = {1, 3, 5};
        //Act
        Array myArray = new Array(array);
        //Act
        assertTrue(myArray.isAllEvenorOdds(false));}
    @Test
    void isAllEvenorOddsAllEvenFalse(){
        //Arrange
        int[] array = {2, 5, 6};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllEvenorOdds(false));}
    @Test
    void isAllEvenCheckEvenSomeAreOdds(){
        //Arrange
        int[] array = {2, 5, 6};
        //Act
        Array myArray = new Array(array);
        //Act
        assertFalse(myArray.isAllEvenorOdds(true));}
    @Test
    void isAllEvenorOddsEmptyArray()throws IllegalArgumentException{
        //Arrange
        int[] array = {};
        //Act
        Array myArray = new Array(array);
        //Act
        assertThrows(IllegalArgumentException.class, () -> myArray.isAllEvenorOdds(true));}
}