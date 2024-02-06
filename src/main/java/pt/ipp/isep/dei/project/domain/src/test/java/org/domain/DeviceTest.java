package org.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DeviceTest is a test class for Device.
 * It uses JUnit to test the functionality of Device methods.
 */
class DeviceTest {
    /**
     * test constructor with valid parameters
     */
    @Test
    void testConstructorValid() throws Exception{
        //Arrange
        House house = House.getInstance();
        Device device = new Device("name", "type");
        //Assert
        assertEquals("name", device.getName());
    }

    /**
     * Test method for Device constructor with an empty name.
     * It verifies that the constructor throws an IllegalArgumentException when the name is empty.
     */
    @Test
    void testConstructorEmptyName() {
        //Arrange, Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Device("", "type"));
        assertEquals("Empty parameter(s)", exc.getMessage());
    }

    /**
     * Test method for Device constructor with an empty type.
     * It verifies that the constructor throws an IllegalArgumentException when the type is empty.
     */
    @Test
    void testConstructorDeviceTypeEmpty() {
        //Arrange, Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Device("name", ""));
        assertEquals("Empty parameter(s)", exc.getMessage());
    }

    /**
     * Test method for Device.getName().
     * It verifies that the method returns the correct name of the device.
     */
    @Test
    void testGetName() throws Exception{
        //Arrange
        House house = House.getInstance();
        Device device = new Device("name", "type5");
        //Act
        String name = device.getName();
        //Assert
        assertEquals("name", name);
    }

    /**
     * Test method for Device.getType().
     * It verifies that the method returns the correct type of the device.
     */
    @Test
    void testGetType() throws Exception{
        //Arrange
        House house = House.getInstance();
        Device device = new Device("name", "type5");
        //Act
        String type = device.getType();
        //Assert
        assertEquals("type5", type);
    }

    /**
     * Test method for Device.addSensor() with an empty name.
     * It verifies that the method returns false when the name is empty.
     */
    @Test
    void testAddSensorDiferentEmptyName() {
        //Arrange
        Device device = new Device("name", "type5");
        String name = "";
        String typeOfSensor = "humidity";
        //Act
        boolean result = device.addSensor(name, typeOfSensor);
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for Device.addSensor() with an empty type of sensor.
     * It verifies that the method returns false when the type of sensor is empty.
     */
    @Test
    void testAddSensorEmptyTypeOfSensor() {
        //Arrange
        Device device = new Device("name", "type5");
        String name = "name";
        String typeOfSensor = "";
        //Act
        boolean result = device.addSensor(name, typeOfSensor);
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for Device.addSensor() with an invalid type of sensor.
     * It verifies that the method returns false when the type of sensor is invalid.
     */
    @Test
    void testAddSensorInvalidTypeOfSensor() {
        //Arrange
        Device device = new Device("name", "type5");
        String name = "name";
        String typeOfSensor = "type";
        //Act
        boolean result = device.addSensor(name, typeOfSensor);
        //Assert
        assertFalse(result);
    }

    /**
     * test setActive with true
     *
     * @returns False because device already active so it doesn't change from active to inactive
     */
    @Test
    void testSetActiveTrue() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.deactivate();
        //Assert
        assertTrue(result);
    }

    /**
     * test setActive with false
     *
     * @returns device deactivated
     */
    @Test
    void testSetActiveFalse() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.deactivate();
        //Assert
        assertTrue(result);
    }

    /**
     * test addSensor to Device with valid parameters
     */
    @Test
    void testAddSensorValid() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.addSensor("name", "temperature");
        //Assert
        assertTrue(result);
    }

    /**
     * test addSensor to Device with valid parameters Humidity
     */
    @Test
    void testAddSensorValidHumidity() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.addSensor("name", "humidity");
        //Assert
        assertTrue(result);
    }

    /**
     * test addSensor to Device with empty name
     */
    @Test
    void testAddSensorEmptyName() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.addSensor("", "temperature");
        //Assert
        assertFalse(result);
    }

    /**
     * test addSensor to Device with empty type
     */
    @Test
    void testAddSensorEmptyType() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        boolean result = device.addSensor("name", "");
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for Device.getDeviceSensors() when the device has one sensor.
     * It verifies that the method returns a list with one sensor.
     */
    @Test
    void testGetDeviceSensorTestOneDeviceOneSensor() {
        //Arrange
        Device device = new Device("name", "type");
        device.addSensor("name", "Temperature");
        //Act
        List<Sensor> result = device.getDeviceSensors();
        //Assert
        assertEquals(1, result.size());
        assertEquals("name", result.getFirst().getName());
        assertEquals("Temperature", result.getFirst().getType());
    }

    /**
     * Test method for Device.deactivate() when the device is already deactivated.
     * It verifies that the method returns false.
     */
    @Test
    void testDeactivateAlreadyDeactivatedReturnsFalse() {
        //Arrange
        Device device = new Device("name", "type");
        device.deactivate();
        //Act
        boolean result = device.deactivate();
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for Device.getFunctionalities() when the device has no functionalities.
     * It verifies that the method returns an empty set.
     */
    @Test
    void testgetFunctionalitiesDeviceEmptyNoFunctionalities() {
        //Arrange
        Device device = new Device("name", "type");
        //Act
        HashSet<String> result = device.getFunctionalities();
        //Assert
        assertEquals(0, result.size());
        assertFalse(result.contains("Temperature"));
        assertFalse(result.contains("Humidity"));
    }

    /**
     * Test method for Device.getFunctionalities() when the device has one sensor of type "Temperature".
     * It verifies that the method returns a set with one functionality "TEMPERATURE".
     */
    @Test
    void testgetFunctionalitiesDeviceOneSensorTemperature() {
        //Arrange
        Device device = new Device("name", "type");
        device.addSensor("name", "Temperature");
        //Act
        HashSet<String> result = device.getFunctionalities();
        //Assert
        assertEquals(1, result.size());
        assertTrue(result.contains("TEMPERATURE"));
        assertFalse(result.contains("HUMIDITY"));
    }

    /**
     * Test method for Device.getFunctionalities() when the device has one sensor of type "Humidity".
     * It verifies that the method returns a set with one functionality "HUMIDITY".
     */
    @Test
    void testgetFunctionalitiesDeviceOneSensorHumidity() {
        //Arrange
        Device device = new Device("name", "type");
        device.addSensor("name", "Humidity");
        //Act
        HashSet<String> result = device.getFunctionalities();
        //Assert
        assertEquals(1, result.size());
        assertFalse(result.contains("TEMPERATURE"));
        assertTrue(result.contains("HUMIDITY"));
    }

    /**
     * Test method for Device.getFunctionalities() when the device has two sensors of different types.
     * It verifies that the method returns a set with two functionalities.
     */
    @Test
    void testgetFunctionalitiesDeviceTwoSensors() {
        //Arrange
        Device device = new Device("name", "type");
        device.addSensor("name", "Humidity");
        device.addSensor("name", "Temperature");
        //Act
        HashSet<String> result = device.getFunctionalities();
        //Assert
        assertEquals(2, result.size());
        assertTrue(result.contains("TEMPERATURE"));
        assertTrue(result.contains("HUMIDITY"));
    }

    /**
     * Test method for Device.getFunctionalities() when the device has two sensors of the same type.
     * It verifies that the method returns a set with one functionality.
     */
    @Test
    void testgetFunctionalitiesDeviceTwoSensorsSameType() {
        //Arrange
        Device device = new Device("name", "type");
        device.addSensor("name", "Humidity");
        device.addSensor("name", "Humidity");
        //Act
        HashSet<String> result = device.getFunctionalities();
        //Assert
        assertEquals(1, result.size());
        assertFalse(result.contains("TEMPERATURE"));
        assertTrue(result.contains("HUMIDITY"));
    }

}
