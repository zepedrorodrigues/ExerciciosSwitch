package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
class ActuatorTest {
    @Test
    void testConstructorandisActuatorPresentNullList() {
        //Arrange
        Actuator actuatorType = new Actuator("name", List.of("characteristics"));
        //Act and Assert
        assertEquals("name", actuatorType.getName());}
    @Test
    void testConstructornameNull()throws NullPointerException{
        //Arrange and Act
        NullPointerException exc = assertThrows(NullPointerException.class, () -> new Actuator(null, List.of("characteristics")));
        //Assert
        assertEquals("Null value not valid", exc.getMessage());}
    @Test
    void testConstructorcharacteristicsNull()throws NullPointerException{
        //Arrange and Act
        NullPointerException exc = assertThrows(NullPointerException.class, () -> new Actuator("name", null));
        //Assert
        assertEquals("Null value not valid", exc.getMessage());}
    @Test
    void testConstructornameEmpty()throws IllegalArgumentException{
        //Arrange and Act
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Actuator("", List.of("characteristics")));
        //Assert
        assertEquals("Empty name", exc.getMessage());}
    @Test
    void testConstructorcharacteristicsEmpty()throws IllegalArgumentException{
        //Arrange and Act
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Actuator("name", List.of()));
        //Assert
        assertEquals("Empty characteristics list", exc.getMessage());}
    @Test
    void getNameValid() {
        //Arrange and Act
        Actuator actuatorType1 = new Actuator("name", List.of("characteristics"));
        //Assert
        assertEquals("name", actuatorType1.getName());}
    @Test
    void getCharacteristicsValid(){
        //Arrange and Act
        Actuator actuatorType2 = new Actuator("name", List.of("characteristics"));
        //Assert
        assertEquals(List.of("characteristics"), actuatorType2.getCharacteristics());}

}