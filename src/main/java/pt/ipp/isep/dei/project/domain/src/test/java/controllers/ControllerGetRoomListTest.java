package controllers;

import DTOs.RoomDTO;
import org.domain.House;
import org.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class tests the ControllerUC3_5_6Common class.
 * It verifies the functionality provided by ControllerUC3_5_6Common to get a list of all rooms in a house.
 */
class ControllerGetRoomListTest {
    /**
     * The house instance from which the rooms are retrieved.
     */
    House myHouse;

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
    }

    /**
     * Test for the getRoomList method of ControllerUC3_5_6Common.
     * This test verifies that the getRoomList method returns a non-null list of RoomDTOs,
     * and that the size of the returned list matches the size of the room list in the house.
     */
    @Test
    void getRoomListValidHouseReturnsRoomDTOList() throws Exception{
        // Arrange
        List<Room> rooms = myHouse.getRoomList();
        ControllerGetRoomList controller = new ControllerGetRoomList();
        // Act
        List<RoomDTO> roomDTOList = controller.getRoomList();

        // Assert
        assertNotNull(roomDTOList, "Returned RoomDTO list should not be null");
        assertEquals(rooms.size(), roomDTOList.size(), "The size of the returned RoomDTO list should match the size of the room list in the house");
    }

    /**
     * Test for the getRoomList method of ControllerUC3_5_6Common.
     * This test verifies that the size of the RoomDTO list returned by the getRoomList method
     * increases by 1 after adding a room to the house, and that the name of the last RoomDTO in the list
     * matches the name of the last added room.
     */
    @Test
    void getRoomListUpdatesWhenNewRoomIsAdded() throws Exception{
        // Arrange
        myHouse.addRoom("Living Room", 1, 5, 5, 5);
        // Act
        ControllerGetRoomList controller = new ControllerGetRoomList();
        List<RoomDTO> roomDTOListBeforeAddingRoom = controller.getRoomList();
        myHouse.addRoom("Kitchen", 1, 5, 5, 5);
        List<RoomDTO> roomDTOListAfterAddingRoom = controller.getRoomList();

        // Assert
        assertEquals(roomDTOListBeforeAddingRoom.size() + 1, roomDTOListAfterAddingRoom.size(), "The size of the RoomDTO list should increase by 1 after adding a room");
        assertEquals("Kitchen", roomDTOListAfterAddingRoom.getLast().getName(), "The name of the last RoomDTO should match the name of the last added Room");
    }

}