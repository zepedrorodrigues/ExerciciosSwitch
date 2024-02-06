package org.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class contains test cases for the Room class.
 * Each test case corresponds to a different scenario of creating a Room instance and its operations.
 */
class RoomTest {

    /**
     * Test to assess the Room constructor with valid parameters.
     * The test should pass if the Room object is successfully created.
     */
    @Test
    void testRoomConstructorValidParameters() throws Exception{
        // Arrange & Act
        House house = House.getInstance();
        house.getRoomList();
        house.addRoom("Living Room", 1, 10, 20, 30);
        // Assert
        assertNotNull(house.getRoomByName("Living Room"));
    }

    /**
     * Test to assess the Room constructor with an empty name parameter.
     * The test should pass if an IllegalArgumentException is thrown.
     */
    @Test
    void testRoomConstructorInvalidEmptyName() {
        // Arrange
        String expectedName = "";
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Room(expectedName, 1, 10, 20, 30));
        // Assert
        assertEquals("Empty name", exception.getMessage());
    }

    /**
     * Test to verify that the getName method returns the correct name of the room.
     */
    @Test
    void testGetName() throws Exception{
        // Arrange
        House house = House.getInstance();
        house.getRoomList();
        house.addRoom("Living Room", 1, 10, 20, 30);
        // Act
        Room result = house.getRoomByName("Living Room");
        // Assert
        assertNotNull(result);
        assertEquals("Living Room", result.getName());
    }


    @Test
    void testGetFloorValid() throws Exception{
        // Arrange
        House myHouse = House.getInstance();
        myHouse.getRoomList();
        myHouse.addRoom("Living Room", 1, 10, 20, 30);
        // Act
        int floor = myHouse.getRoomByName("Living Room").getFloor();
        // Assert
        assertEquals(1, floor);
    }

    /**
     * Test to verify that the getDeviceList method returns the correct device list.
     */
    @Test
    void testGetDeviceListReturnsCorrectDeviceList() throws Exception{
        // Arrange
        House myHouse = House.getInstance();
        myHouse.getRoomList();
        myHouse.addRoom("Living Room", 1, 10, 20, 30);
        Room room1 = myHouse.getRoomByName("Living Room");
        room1.createDevice("Device1", "Type1");
        room1.createDevice("Device2", "Type2");
        // Act
        List<Device> deviceList = room1.getDeviceList();
        // Assert
        assertEquals(2, deviceList.size()); // Check if the size of the list is correct
        assertEquals("Device1", deviceList.get(0).getName()); // Check if the name of the first device is correct
        assertEquals("Device2", deviceList.get(1).getName()); // Check if the name of the second device is correct
    }

    /**
     * Test to check if the GetDimensions method returns the correct dimensions.
     */
    @Test
    void testGetDimensions() throws Exception{
        // Arrange
        House myHouse = House.getInstance();
        myHouse.getRoomList();
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        // Act
        Dimensions actualDimensions = myHouse.getRoomByName("Living Room").getDimensions();
        // Assert
        assertEquals(10, actualDimensions.getWidth());
        assertEquals(20, actualDimensions.getLength());
        assertEquals(30, actualDimensions.getHeight());
    }

    /**
     * This test verifies that the getDeviceByName method of the Room class returns the correct device when it exists.
     */

    @Test
    void testGetDeviceByName() {
        // Arrange
        Room room = new Room("Living Room", 1, 10, 20, 30);
        room.createDevice("Device1", "Type1");
        // Act
        Device result = room.getDeviceByName("Device1");
        // Assert
        assertNotNull(result);
        assertEquals("Device1", result.getName());
    }

    /**
     * This test verifies that the getDeviceByName method of the Room class returns null when the device does not exist.
     */
    @Test
    void testGetDeviceByName_NotFound() {
        // Arrange
        Room room = new Room("Living Room", 1, 10, 20, 30);
        room.createDevice("Device1", "Type1");
        // Act
        Device result = room.getDeviceByName("Device2");
        // Assert
        assertNull(result);}
    /**
     * Test to verify that the Room constructor with invalid dimensions throws an IllegalArgumentException.
     */
    @Test
    void testConstructorInvalidDimensions() {
        // Arrange
        String expectedName = "Living Room";
        int expectedFloor = 1;
        double expectedWidth = -10;
        double expectedLength = -20;
        double expectedHeight = -30;
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Room(expectedName, expectedFloor, expectedWidth, expectedLength, expectedHeight));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());}
    /**
     * Test to verify that the createDevice method of the Room class returns false when the device name is empty.
     */
    @Test
    void testcreateDeviceDeviceNameEmpty() {
        // Arrange
        Room room = new Room("Living Room", 1, 10, 20, 30);
        String expectedName = "";
        String expectedDeviceType = "Type1";
        // Act
        assertFalse(room.createDevice(expectedName, expectedDeviceType));}
    /**
     * Test to verify that the createDevice method of the Room class returns false when the device type is empty.
     */
    @Test
    void testcreateDeviceDeviceTypeEmpty() {
        // Arrange
        Room room = new Room("Living Room", 1, 10, 20, 30);
        String expectedName = "Device1";
        String expectedDeviceType = "";
        // Act and Assert
        assertFalse(room.createDevice(expectedName, expectedDeviceType));}
}


