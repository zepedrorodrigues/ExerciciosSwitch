package controllers;

import DTOs.DeviceDTO;
import DTOs.RoomDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the ControllerUC08 class.
 * Each test case corresponds to a different scenario of deactivating a device in a room.
 */
class ControllerUC08Test {
    /**
     * The House instance that represents the house in the domain.
     */
    private House myHouse;
    /**
     * The ControllerUC08 instance that is used to perform operations related to use case 08.
     */
    private ControllerUC08 controllerUC08;
    /**
     * The RoomDTO instance that represents the data transfer object of a room.
     */
    private RoomDTO myRoomDTO;
    /**
     * The DeviceDTO instance that represents the data transfer object of a device.
     */
    private DeviceDTO myDeviceDTO;

    /**
     * This method sets up the testing environment before each test.
     * It resets the singleton instance of the House class to ensure each test is independent.
     */
    @BeforeEach
    void setUp() throws Exception{
        try {
            Field instance = House.class.getDeclaredField("myHouse");
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        myHouse = House.getInstance();
        controllerUC08 = new ControllerUC08();
        myRoomDTO = new RoomDTO("Room", 1, 1, 1, 1);
        new ControllerUC02().addNewRoomToHouse(myRoomDTO);
        myDeviceDTO = new DeviceDTO("Device", "Type", "Room");
        new ControllerUC05().addDeviceToRoom(myDeviceDTO);
    }

    /**
     * Test if the room list is returned.
     */
    @Test
    void testGetRoomList() throws Exception{
        // Arrange & Act
        controllerUC08.getRoomList();
        // Assert
        assertEquals(1, controllerUC08.getRoomList().size());
    }

    /**
     * Test if the device list is returned.
     */
    @Test
    void testGetDeviceList() throws Exception{
        // Arrange & Act
        controllerUC08.getDeviceList("Room");
        // Assert
        assertEquals(1, controllerUC08.getDeviceList("Room").size());
    }

    /**
     * Test if the device is deactivated.
     */
    @Test
    void testDeativateDevice() {
        // Arrange & Act
        boolean result = controllerUC08.deactivateDevice(myDeviceDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test if the device is deactivated when the device is already deactivated.
     */
    @Test
    void testDeactivateDeviceAgain() {
        // Arrange & Act
        controllerUC08.deactivateDevice(myDeviceDTO);
        boolean result = controllerUC08.deactivateDevice(myDeviceDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test if the device is deactivated when the device is null.
     */
    @Test
    void testDeativateDeviceNull() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> controllerUC08.deactivateDevice(null));
    }

    /**
     * Test if the device is deactivated when the room is null.
     */
    @Test
    void testDeativateDeviceRoomNotFound() {
        // Arrange
        DeviceDTO myDeviceDTO2 = new DeviceDTO("Device", "Type", null);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> controllerUC08.deactivateDevice(myDeviceDTO2));
    }

    /**
     * Test if the device is deactivated when the device is null.
     */
    @Test
    void testDeactivateDeviceNameNull() {
        // Arrange
        DeviceDTO myDeviceDTO3 = new DeviceDTO(null, "Type", "Room");
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> controllerUC08.deactivateDevice(myDeviceDTO3));
    }
}


