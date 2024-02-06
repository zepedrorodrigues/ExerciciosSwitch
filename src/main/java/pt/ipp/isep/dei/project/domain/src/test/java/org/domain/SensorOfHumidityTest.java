package org.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * This class tests the functionality of the SensorOfHumidity class.
 * It tests the constructor and the getType method.
 */
class SensorOfHumidityTest {

    /**
     * Test to verify that the constructor of SensorOfHumidity class works as expected.
     * It checks if the name and type of the sensor are correctly initialized.
     */
    @Test
    void testConstructorValid() {
        // Arrange
        SensorOfHumidity sensor = new SensorOfHumidity("SensorOfHumidity1");
        // Assert
        assertEquals("SensorOfHumidity1", sensor.getName());
        assertEquals( "Humidity", sensor.getType());
    }

    /**
     * Test to verify that the getType method of SensorOfHumidity class works as expected.
     * It checks if the correct type of the sensor is returned.
     */

    @Test
    void testGetType() {
        // Arrange
        SensorOfHumidity sensor = new SensorOfHumidity("SensorOfHumidity1");
        // Act
        String type = sensor.getType();
        // Assert
        assertEquals("Humidity", type);
    }
}