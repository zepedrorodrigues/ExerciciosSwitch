package controllers;

import DTOs.DeviceDTO;
import DTOs.RoomDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ControllerUC06Test is a test class for ControllerUC06.
 * It uses JUnit to test the functionality of ControllerUC06 methods.
 */
class ControllerUC06Test {
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
     * Test method for ControllerUC06.getRoomList().
     * It verifies that the method returns an empty list when there are no rooms.
     */
    @Test
    void getRoomListEmpty() throws Exception{
        ControllerUC06 ctrl = new ControllerUC06();
        assertEquals(0, ctrl.getRoomList().size());
    }

    /**
     * Test method for ControllerUC06.getRoomList().
     * It verifies that the method returns a list with one room when there is one room in the house.
     */
    @Test
    void getRoomListOneRoom() throws Exception{
        ControllerUC02 ctrl = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO);
        ControllerUC06 ctrl2 = new ControllerUC06();
        assertEquals(1, ctrl2.getRoomList().size());
    }

    /**
     * Test method for ControllerUC06.getDeviceList().
     * It verifies that the method returns an empty list when there are no devices in the room.
     */
    @Test
    void getDeviceListOneRoomNoDevices() throws Exception{
        ControllerUC02 ctrl = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO);
        ControllerUC06 ctrl1 = new ControllerUC06();
        assertEquals(0, ctrl1.getDeviceList("Kitchen").size());
    }

    /**
     * Test method for ControllerUC06.getDeviceList().
     * It verifies that the method returns a list with one device when there is one device in the room.
     */
    @Test
    void getDeviceListOneRoomOneDevice() throws Exception{
        ControllerUC02 ctrl = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO);
        ControllerUC05 ctrl2 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        ctrl2.addDeviceToRoom(deviceDTO);
        ControllerUC06 ctrl3 = new ControllerUC06();
        assertEquals(1, ctrl3.getDeviceList("Kitchen").size());
    }

    /**
     * Test method for ControllerUC06.getDeviceList().
     * It verifies that the method returns a list with two devices when there are two devices in the room.
     */
    @Test
    void getDeviceListOneRoomTwoDevices() throws Exception{
        ControllerUC02 ctrl = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO);
        ControllerUC05 ctrl2 = new ControllerUC05();
        DeviceDTO deviceDTO2 = new DeviceDTO("Oven", "Oven", "Kitchen");
        ctrl2.addDeviceToRoom(deviceDTO2);
        DeviceDTO deviceDTO3 = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        ctrl2.addDeviceToRoom(deviceDTO3);
        ControllerUC06 ctrl3 = new ControllerUC06();
        assertEquals(2, ctrl3.getDeviceList("Kitchen").size());
    }

    /**
     * Test method for ControllerUC06.getDeviceList().
     * It verifies that the method returns a list with one device when there is one device in one room and no devices in the other room.
     */
    @Test
    void getDeviceListTwoRoomsOneDevice() throws Exception{
        ControllerUC02 ctrl = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Kitchen", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO);
        RoomDTO roomDTO2 = new RoomDTO("Bedroom", 0, 1, 2, 3);
        ctrl.addNewRoomToHouse(roomDTO2);
        ControllerUC05 ctrl2 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("Fridge", "Fridge", "Kitchen");
        ctrl2.addDeviceToRoom(deviceDTO);
        ControllerUC06 ctrl3 = new ControllerUC06();
        assertEquals(1, ctrl3.getDeviceList("Kitchen").size());
        assertEquals(0, ctrl3.getDeviceList("Bedroom").size());
    }

    /**
     * Test method for ControllerUC06.getDeviceList().
     * It verifies that the method throws an IllegalArgumentException when null is passed as the room name.
     */
    @Test
    void getDeviceListRoomNameNull() throws Exception{
        ControllerUC06 ctrl = new ControllerUC06();
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> ctrl.getDeviceList(null));
        assertEquals("Room name cannot be empty or null.", exc.getMessage());
    }

}