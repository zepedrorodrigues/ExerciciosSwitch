package controllers;

import DTOs.RoomDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ControllerUC03Test is a test class for ControllerUC03.
 * It uses JUnit to test the functionality of ControllerUC03 methods.
 */
public class ControllerUC03Test {

    /**
     * An instance of ControllerUC03 which is the class under test.
     */
    private ControllerUC03 controllerUC03;
    /**
     * The singleton instance of the House class.
     */
    private House myHouse;

    /**
     * Setup method to initialize the ControllerUC03 instance before each test.
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
        controllerUC03 = new ControllerUC03();
    }

    /**
     * Test method for ControllerUC03.getRoomList().
     * It verifies that the method returns a non-null list.
     */
    @Test
    public void testGetRoomList() throws Exception{
        List<RoomDTO> roomList = controllerUC03.getRoomList();
        assertNotNull(roomList, "The room list should not be null");
        // Add more assertions based on your expected results
    }

    /**
     * Test method for ControllerUC03.getRoomList().
     * It verifies that the method returns an empty list when there are no rooms.
     */
    @Test
    public void testGetRoomListEmpty() throws Exception{
        List<RoomDTO> roomList = controllerUC03.getRoomList();
        assertTrue(roomList.isEmpty(), "The room list should be empty");
    }

    /**
     * Test method for ControllerUC03.getRoomList(). Room list should have one room.
     */
    @Test
    public void testGetRoomListSizeOne() throws Exception{
        myHouse.addRoom("Room1", 1, 1, 1, 1);
        List<RoomDTO> roomList = controllerUC03.getRoomList();
        assertTrue(roomList.size() == 1, "The room list should have one room");
    }

    /**
     * Test method for ControllerUC03.getRoomList(). Room list should have two rooms.
     */
    @Test
    public void testGetRoomListSizeTwo() throws Exception{
        myHouse.addRoom("Room1", 1, 1, 1, 1);
        myHouse.addRoom("Room2", 1, 1, 1, 1);
        List<RoomDTO> roomList = controllerUC03.getRoomList();
        assertTrue(roomList.size() == 2, "The room list should have two rooms");
    }


}