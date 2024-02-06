package org.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the functionality of the SensorOfTemperature class.
 * It tests the constructor and the getType method.
 */

class SensorOfTemperatureTest {

    /**
     * Test to verify that the constructor of SensorOfTemperature class works as expected.
     * It checks if the name and type of the sensor are correctly initialized.
     */
    @Test
    void testConstructorValid() {
        // Arrange
        SensorOfTemperature sensor = new SensorOfTemperature("SensorOfTemperature1");
        // Assert
        assertEquals("SensorOfTemperature1", sensor.getName());
        assertEquals("Temperature", sensor.getType());
    }

    /**
     * Test to verify that the getType method of SensorOfTemperature class works as expected.
     * It checks if the correct type of the sensor is returned.
     */

    @Test
    void testGetType() {
        // Arrange
        SensorOfTemperature sensor = new SensorOfTemperature("SensorOfTemperature1");
        // Act
        String type = sensor.getType();
        // Assert
        assertEquals("Temperature", type);
    }
}
