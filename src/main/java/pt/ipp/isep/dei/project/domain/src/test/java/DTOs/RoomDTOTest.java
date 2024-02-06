package DTOs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * RoomDTOTest is a test class for RoomDTO.
 * It uses JUnit to test the functionality of RoomDTO methods.
 */
class RoomDTOTest {
    /**
     * Test method for RoomDTO.getName().
     * It verifies that the method returns the correct name of the room.
     */
    @Test
    void testGetName() {
        //Arrange
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1,1);
        //Act
        String name = roomDTO.getName();
        //Assert
        assertEquals("room", name);}
    /**
     * Test method for RoomDTO.getFloor().
     * It verifies that the method returns the correct floor of the room.
     */
    @Test
    void testGetFloor() {
        //Arrange
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1,1);
        //Act
        int floor = roomDTO.getFloor();
        //Assert
        assertEquals(1, floor);}
    /**
     * Test method for RoomDTO.getWidth().
     * It verifies that the method returns the correct width of the room.
     */
    @Test
    void testGetWidth() {
        //Arrange
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1,1);
        //Act
        double width = roomDTO.getWidth();
        //Assert
        assertEquals(1, width);}
    /**
     * Test method for RoomDTO.getLength().
     * It verifies that the method returns the correct length of the room.
     */
    @Test
    void testGetLength() {
        //Arrange
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1,1);
        //Act
        double length = roomDTO.getLength();
        //Assert
        assertEquals(1, length);
    }
    /**
     * Test method for RoomDTO.getHeight().
     * It verifies that the method returns the correct height of the room.
     */
    @Test
    void testGetHeight() {
        //Arrange
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1,1);
        //Act
        double height = roomDTO.getHeight();
        //Assert
        assertEquals(1, height);
    }
}