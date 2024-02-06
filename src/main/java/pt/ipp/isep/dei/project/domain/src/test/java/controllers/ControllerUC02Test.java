package controllers;

import DTOs.RoomDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is responsible for testing the ControllerUC02 class.
 * It tests the addNewRoomToHouse method under different conditions.
 */

class ControllerUC02Test {

    /**
     * This method is executed before each test.
     * It resets the House instance to ensure that each test is independent.
     */

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = House.class.getDeclaredField("myHouse");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    /**
     * This test checks if a room can be successfully added to the house.
     */

    @Test
    void addRoomToHouse() throws Exception{
        // Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Living Room", 1, 20.0, 30.0, 40.0);
        // Act
        boolean result = controllerUS02.addNewRoomToHouse(roomDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * This test checks if the method correctly handles the case where a room with the same name already exists in the house.
     */

    @Test
    void addRoomToHouseDuplicateRoomName() throws Exception{
        // Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("Living Room", 1, 20.0, 30.0, 40.0);
        controllerUS02.addNewRoomToHouse(roomDTO);
        // Act
        boolean result = controllerUS02.addNewRoomToHouse(roomDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * This test checks if the method correctly handles the case where the room name is null.
     */

    @Test
    void addRoomToHouseNullRoomName() throws Exception{
        // Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO(null, 1, 20.0, 30.0, 40.0);
        // Act
        boolean result = controllerUS02.addNewRoomToHouse(roomDTO);
        // Assert
        assertFalse(result);
    }

}
