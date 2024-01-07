package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class SensorTypeTest {
    @Test
    void testConstructorValid() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        //Act
        SensorType st = new SensorType("name99", characteristics);
        //Assert
        assertNotNull(st);}

    @Test
    void getNameValid() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        SensorType st = new SensorType("name3", characteristics);
        //Act and Assert
        assertEquals("name3", st.getName());}

    @Test
    void getCharacteristicsValid(){
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        SensorType st = new SensorType("name1", characteristics);
        //Act and Assert
        assertEquals(characteristics, st.getCharacteristics());}

    @Test
    void testConstructorNullName() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        //Act and Assert
        NullPointerException exc = assertThrows(NullPointerException.class, () -> new SensorType(null, characteristics));
        assertTrue(exc.getMessage().contains("Null value"));}

    @Test
    void testConstructorNullCharacteristics() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        //Act and Assert
        NullPointerException exc = assertThrows(NullPointerException.class, () -> new SensorType("name2", null));
        assertTrue(exc.getMessage().contains("Null value"));}

    @Test
    void testConstructorEmptyName() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new SensorType("", characteristics));
        assertTrue(exc.getMessage().contains("Empty value"));}

    @Test
    void testConstructorEmptyCharacteristics() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new SensorType("name4", characteristics));
        assertTrue(exc.getMessage().contains("Empty value"));}

    @Test
    void testConstructorAlreadyExists() {
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        SensorType st = new SensorType("name5", characteristics);
        //Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new SensorType("name5", characteristics));
        assertTrue(exc.getMessage().contains("SensorType already exists"));}
   @Test
   void isSensorTypeAvailableTypeNull(){
         //Arrange
         List<String> characteristics = new ArrayList<>();
         characteristics.add("charac");
         SensorType st = new SensorType("name6", characteristics);
         //Act and Assert
         NullPointerException exc = assertThrows(NullPointerException.class, () -> SensorType.isSensorTypeAvailable(null));
         assertTrue(exc.getMessage().contains("Null value"));}
    @Test
    void isSensorTypeAvailableTypeNotAvailable(){
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        SensorType st = new SensorType("name7", characteristics);
        //Act and Assert
        assertNull(SensorType.isSensorTypeAvailable("name8"));}
    @Test
    void isSensorTypeAvailableTypeAvailable(){
        //Arrange
        List<String> characteristics = new ArrayList<>();
        characteristics.add("charac");
        SensorType st = new SensorType("name9", characteristics);
        //Act and Assert
        assertEquals(st, SensorType.isSensorTypeAvailable("name9"));}
}