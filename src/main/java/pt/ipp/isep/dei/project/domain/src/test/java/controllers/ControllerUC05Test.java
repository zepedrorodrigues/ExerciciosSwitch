package controllers;

import DTOs.DeviceDTO;
import DTOs.RoomDTO;
import org.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ControllerUC05Test is a test class for ControllerUC05.
 * It uses JUnit to test the functionality of ControllerUC05 methods.
 */
class ControllerUC05Test {
    /**
     * The singleton instance of the House class.
     */
    private House myHouse;

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
     * Test method for ControllerUC05 constructor.
     * It verifies that the House instance is not null after the ControllerUC05 is instantiated.
     */
    @Test
    void testConstructor() throws Exception{
        //Arrange
        ControllerUC05 controller = new ControllerUC05();
        //Act and Assert
        assertNotNull(House.getInstance());
    }

    /**
     * Test method for ControllerUC05.getRoomList().
     * It verifies that the method returns an empty list when there are no rooms.
     */
    @Test
    void testGetRoomListZeroRooms() throws Exception{
        //Arrange
        myHouse = House.getInstance();
        ControllerUC05 controller5 = new ControllerUC05();
        //Act
        List<RoomDTO> result = controller5.getRoomList();
        //Assert
        assertEquals(0, result.size());
    }

    /**
     * Test method for ControllerUC05.getRoomList().
     * It verifies that the method returns a list with one room when there is one room in the house.
     */
    @Test
    void testGetRoomListOneRoom() throws Exception{
        //Arrange
        myHouse = House.getInstance();
        ControllerUC02 controller2 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO);
        ControllerUC05 controller5 = new ControllerUC05();
        //Act
        List<RoomDTO> result = controller5.getRoomList();
        //Assert
        assertEquals(1, result.size());
    }

    /**
     * Test method for ControllerUC05.getRoomList().
     * It verifies that the method returns a list with two rooms when there are two rooms in the house.
     */
    @Test
    void testGetRoomListTwoRooms() throws Exception{
        //Arrange
        myHouse = House.getInstance();
        ControllerUC02 controller2 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO);
        RoomDTO roomDTO2 = new RoomDTO("Bedroom", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO2);
        ControllerUC05 controller5 = new ControllerUC05();
        //Act
        List<RoomDTO> result = controller5.getRoomList();
        //Assert
        assertEquals(2, result.size());
    }

    /**
     * Test method for ControllerUC05.addDeviceToRoom().
     * It verifies that the method returns true when a device is successfully added to a room.
     */
    @Test
    void testAddDeviceToRoomOneRoom() throws Exception{
        //Arrange
        myHouse = House.getInstance();
        ControllerUC02 controller2 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO);
        ControllerUC05 controller5 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        //Act
        boolean result = controller5.addDeviceToRoom(deviceDTO);
        //Assert
        assertTrue(result);
    }

    /**
     * Test method for ControllerUC05.addDeviceToRoom().
     * It verifies that the method returns false when a device with the same name already exists in the room.
     */
    @Test
    void testAddDeviceToRoomOneRoomHasDeviceWithSameName() throws Exception {
        //Arrange
        myHouse = House.getInstance();
        ControllerUC02 controller2 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO);
        ControllerUC05 controller5 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        controller5.addDeviceToRoom(deviceDTO);
        //Act
        boolean result = controller5.addDeviceToRoom(deviceDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for ControllerUC05.addDeviceToRoom().
     * It verifies that the method adds the device to the correct room when there are multiple rooms.
     */
    @Test
    void testAddDeviceToRoomTwoRoomsAddsInTheCorrectRoom() throws Exception {
        //Arrange
        myHouse = House.getInstance();
        ControllerUC02 controller2 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO);
        RoomDTO roomDTO2 = new RoomDTO("Bedroom", 1, 20, 20, 20);
        controller2.addNewRoomToHouse(roomDTO2);
        ControllerUC05 controller5 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        //Act
        boolean result = controller5.addDeviceToRoom(deviceDTO);
        //Assert
        assertTrue(result);
        assertEquals(1, myHouse.getRoomList().get(0).getDeviceList().size());
        assertEquals(0, myHouse.getRoomList().get(1).getDeviceList().size());
    }


}