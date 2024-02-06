package DTOs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SensorDTOTest is a test class for SensorDTO.
 * It uses JUnit to test the functionality of SensorDTO methods.
 */
class SensorDTOTest {
    /**
     * Test method for SensorDTO.getSensorName().
     * It verifies that the method returns the correct name of the sensor.
     */
    @Test
    void testGetSensorName() {
        //Arrange
        SensorDTO sensorDTO = new SensorDTO("sensor", "type");
        //Act
        String name = sensorDTO.getSensorName();
        //Assert
        assertEquals("sensor", name);
    }

    /**
     * Test method for SensorDTO.getTypeOfSensor().
     * It verifies that the method returns the correct type of the sensor.
     */
    @Test
    void testGetTypeOfSensor() {
        //Arrange
        SensorDTO sensorDTO = new SensorDTO("sensor", "type");
        //Act
        String type = sensorDTO.getTypeOfSensor();
        //Assert
        assertEquals("type", type);
    }
}