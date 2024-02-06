package DTOs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DeviceDTOTest is a test class for DeviceDTO.
 * It uses JUnit to test the functionality of DeviceDTO methods.
 */
class DeviceDTOTest {
    /**
     * Test method for DeviceDTO.getName().
     * It verifies that the method returns the correct name of the device.
     */
    @Test
    void testGetName() {
        //Arrange
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        //Act
        String name = deviceDTO.getName();
        //Assert
        assertEquals("device", name);
    }

    /**
     * Test method for DeviceDTO.getType().
     * It verifies that the method returns the correct type of the device.
     */
    @Test
    void testGetType() {
        //Arrange
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        //Act
        String type = deviceDTO.getType();
        //Assert
        assertEquals("type", type);
    }

    /**
     * Test method for DeviceDTO.getLocation().
     * It verifies that the method returns the correct location of the device.
     */
    @Test
    void testGetLocation() {
        //Arrange
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        //Act
        String location = deviceDTO.getLocation();
        //Assert
        assertEquals("room", location);
    }
}