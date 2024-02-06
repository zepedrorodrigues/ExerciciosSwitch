package org.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the House class.
 * Each test case corresponds to a different scenario of adding a room to a house.
 */

class HouseTest {
    private House myHouse;
    private List<Room> roomList;


    /**
     * This method sets up the testing environment before each test.
     * It resets the singleton instance of the House class to ensure each test is independent.
     */
    @BeforeEach
    //ver
    void setUp() throws Exception{
        try {
            Field instance = House.class.getDeclaredField("myHouse");
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        myHouse = House.getInstance();
    }

    /**
     * test new House with valid parameters
     * supposed to be true if the house is created
     */
    @Test
    void testHouseConstructorNotNull() {
        // Arrange & Act & Assert
        assertNotNull(myHouse);
    }

    /**
     * test configLocation method with valid parameters
     * supposed to be true if the location is valid
     */
    @Test
    void testConfigLocation() {
        // Arrange
        Location location2 = new Location("Address2", "ZipCode2", 2, 2);
        // Act
        boolean result = myHouse.configLocation(location2.getAddress(),
                location2.getZipCode(),
                location2.getGpsLocation().getLatitude(),
                location2.getGpsLocation().getLongitude());
        // Assert
        assertTrue(result);
    }

    /**
     * test configLocation method with empty address
     */
    @Test
    void testConfigLocationEmptyAddress() {
        // Arrange & Act
        boolean result = myHouse.configLocation("", "ZipCode2", 2, 2);
        // Assert
        assertFalse(result);
    }

    /**
     * test configLocation method with empty zip code
     */
    @Test
    void testConfigLocationEmptyZipCode() {
        // Arrange & Act
        boolean result = myHouse.configLocation("Address2", "", 2, 2);
        // Assert
        assertFalse(result);
    }

    /**
     * test configLocation method with latitude under -90
     */
    @Test
    void testConfigLocationInvalidLatitudeNegativeUnderMinus90() {
        // Arrange & Act
        boolean option = myHouse.configLocation("Address2", "ZipCode2", -91, 2);
        // Assert
        assertFalse(option);
    }

    /**
     * test configLocation method with latitude over 90
     */
    @Test
    void testConfigLocationInvalidDataLatitudePositiveOver90() {
        // Arrange & Act
        boolean option = myHouse.configLocation("Address2", "ZipCode2", 91, 2);
        // Assert
        assertFalse(option);
    }

    /**
     * test configLocation method with longitude under -180
     */
    @Test
    void testConfigLocationInvalidLongitudeUnderMinus180() {
        // Arrange & Act
        boolean option = myHouse.configLocation("Address2", "ZipCode2", 2, -181);
        // Assert
        assertFalse(option);
    }

    /**
     * test configLocation method with longitude over 180
     */
    @Test
    void testConfigLocationInvalidLongitudeOver180() {
        // Arrange & Act
        boolean option = myHouse.configLocation("Address2", "ZipCode2", 2, 181);
        // Assert
        assertFalse(option);
    }

    /**
     * Test case for creating a room in the house.
     */
    @Test
    void testIsDeviceTypeAvailableValidTrue() {
        // Arrange & Act
        myHouse.getCatalog().addSensorType("Light");
        // Assert
        assertFalse(myHouse.getCatalog().addSensorType("Light"));
    }

    /**
     * Test to check getLocation method with valid parameters.
     */
    @Test
    void testGetLocationValid() {
        // Arrange
        myHouse.configLocation("Address2", "ZipCode2", 2, 2);
        // Act
        Location result = myHouse.getLocation();
        // Assert
        assertEquals("Address2", result.getAddress());
        assertEquals("ZipCode2", result.getZipCode());
        assertEquals(2, result.getGpsLocation().getLatitude());
        assertEquals(2, result.getGpsLocation().getLongitude());
    }

    /**
     * Test for the getRoomList method
     * Test if the room list is empty when created
     */
    @Test
    void testGetRoomListEmpty() {
        // Arrange & Act
        List<Room> rooms = myHouse.getRoomList();
        // Assert
        assertTrue(rooms.isEmpty());
    }

    /**
     * Test for the getRoomList method
     * Test if the room list contains the rooms that were added
     * Test if the rooms are in the correct order
     */
    @Test
    void testGetRoomListWithRooms() {
        // Arrange
        myHouse.addRoom("Living Room", 1, 10, 10, 10);
        myHouse.addRoom("Kitchen", 1, 10, 10, 10);
        // Act
        List<Room> rooms = myHouse.getRoomList();
        // Assert
        assertEquals(2, rooms.size());
        assertEquals("Living Room", rooms.get(0).getName());
        assertEquals("Kitchen", rooms.get(1).getName());
    }

    /**
     * test addRoom method when already has room with Same Name
     */
    @Test
    void testAddRoomWithSameName() {
        //Arrange
        String name = "Living Room";
        int floor = 1;
        double height = 10.0;
        double width = 20.0;
        double length = 30.0;
        // Act
        boolean result1 = myHouse.addRoom(name, floor, width, length, height);
        boolean result2 = myHouse.addRoom(name, floor, width, length, height);
        // Assert
        assertTrue(result1);
        assertFalse(result2);
    }

    /**
     * test getRoomByName with existing name
     */
    @Test
    void testGetRoomByNameValidName() {
        // Arrange
        myHouse.addRoom("Living Room", 1, 10, 10, 10);
        myHouse.addRoom("Kitchen", 1, 10, 10, 10);
        // Act
        Room room = myHouse.getRoomByName("Living Room");
        // Assert
        assertEquals("Living Room", room.getName());
    }

    /**
     * Test case for getting a room by an invalid name.
     */
    @Test
    void testGetRoomByNameInvalidName() {
        // Arrange
        myHouse.addRoom("Living Room", 1, 10, 10, 10);
        // Act
        Room result = myHouse.getRoomByName("Kitchen");
        // Assert
        assertNull(result);
    }

    /**
     * Test to get the catalog of the house
     */
    @Test
    void testGetCatalog() {
        // Act
        Catalog catalog = myHouse.getCatalog();
        // Assert
        assertNotNull(catalog);
    }

    /**
     * Test to get the devices grouped by room
     * Test if the map is empty when there are no rooms
     */
    @Test
    void testGetDevicesGroupedByRoomEmpty() {
        // Act
        Map<String, List<Device>> result = myHouse.getDevicesGroupedByRoom();
        // Assert
        assertTrue(result.isEmpty());
    }

    /**
     * Test to get the devices grouped by room
     * Test if the map has 1 entry with an empty list
     */
    @Test
    void testGetDevicesGroupedByRoomWithEmptyRoom() {
        // Arrange
        myHouse.addRoom("Living Room", 1, 10, 10, 10);
        // Act
        Map<String, List<Device>> result = myHouse.getDevicesGroupedByRoom();
        // Assert
        assertEquals(1, result.size());
        assertTrue(result.get("Living Room").isEmpty());
    }

    /**
     * Test to get the devices grouped by room
     * Test if the map has 2 entries, each with a list of 1 device
     */
    @Test
    void testGetDevicesGroupedByRoom() {
        // Arrange
        myHouse.addRoom("Living Room", 1, 10, 10, 10);
        myHouse.addRoom("Kitchen", 1, 10, 10, 10);
        Room myRoom1 = myHouse.getRoomByName("Living Room");
        Room myRoom2 = myHouse.getRoomByName("Kitchen");
        myRoom1.createDevice("HumiditySensor", "Humidity");
        myRoom2.createDevice("TemperatureSensor", "Temperature");
        // Act
        Map<String, List<Device>> result = myHouse.getDevicesGroupedByRoom();
        // Assert
        assertEquals(2, result.size());
        assertEquals(1, result.get("Living Room").size());
        assertEquals(1, result.get("Kitchen").size());
    }
}
