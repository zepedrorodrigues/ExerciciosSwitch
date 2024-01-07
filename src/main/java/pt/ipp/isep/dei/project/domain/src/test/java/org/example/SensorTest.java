package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SensorTest {

        @Test
        void testConstructor() {
            //Arrange
            SensorType n = new SensorType("Temperature1000", List.of("Celsius"));
            Sensor sensor = new Sensor("Sensor", "Temperature1000");
            //Act and Assert
            assertEquals("Sensor", sensor.getName());
            assertEquals(n.getName(), sensor.getType());}

        @Test
        void testConstructorNullName() {
            //Arrange
            SensorType o = new SensorType("Temperature1", List.of("Celsius"));
            //Act
            NullPointerException exc = assertThrows(NullPointerException.class, () -> new Sensor(null, o.getName()));
            //Assert
            assertEquals("Null value not valid", exc.getMessage());}

        @Test
        void testConstructorNullSensorType() {
            //Arrange and Act
            NullPointerException exc = assertThrows(NullPointerException.class, () -> new Sensor("Sensor", null));
            //Assert
            assertEquals("Null value not valid", exc.getMessage());}

        @Test
        void testConstructorEmptyName() {
            //Arange and Act
            SensorType st = new SensorType("Temperature", List.of("Celsius"));
            //Assert
            IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Sensor("", st.getName()));
            assertTrue(exc.getMessage().contains("Empty name or type"));}

        @Test
        void testConstructorEmptySensorType() {
            //Arrange and Act
            SensorType st = new SensorType("Temperature111", List.of("Celsius"));
            //Assert
            IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Sensor("Sensor", ""));
            assertTrue(exc.getMessage().contains("Empty name or type"));}

        @Test
        void testConstructorInvalidSensorType() {
            IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Sensor("Sensor", "Temperature99"));
            assertTrue(exc.getMessage().contains("Sensor type not available"));}
}