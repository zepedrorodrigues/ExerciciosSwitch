package DTOs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SensorTypeDTOTest is a test class for SensorTypeDTO.
 * It uses JUnit to test the functionality of SensorTypeDTO methods.
 */
class SensorTypeDTOTest {
    /**
     * Test method for SensorTypeDTO.getSensorTypes().
     * It verifies that the method returns the correct types of the sensor.
     */
    @Test
    void testGetSensorTypes() {
        //Arrange
        SensorTypeDTO sensorTypeDTO = new SensorTypeDTO(Arrays.asList("type", "unit"));
        //Act
        List<String> type = sensorTypeDTO.getSensorTypes();
        //Assert
        assertEquals("type", type.getFirst());
        assertEquals("unit", type.getLast());
    }
}