package controllers;

import DTOs.DeviceDTO;
import DTOs.RoomDTO;
import DTOs.SensorDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ControllerUC07Test is a test class for ControllerUC07.
 * It uses JUnit to test the functionality of ControllerUC07 methods.
 */
class ControllerUC07Test {
    /**
     * The singleton instance of the House class.
     */
    House myHouse;

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
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null deviceDTO)
     */
    @Test
    void testAddSensorToExistingDeviceNullDeviceDTO()throws Exception {
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        SensorDTO sensorDTO = new SensorDTO("sensor", "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(null, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null sensorDTO)
     */
    @Test
    void testAddSensorToExistingDeviceNullSensorDTO()throws Exception {
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, null);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null deviceDTO.getName())
     */
    @Test
    void testAddSensorToExistingDeviceNullDeviceDTOName()throws Exception {
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        DeviceDTO deviceDTO = new DeviceDTO(null, "type", "room");
        SensorDTO sensorDTO = new SensorDTO("sensor", "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null deviceDTO.getRoomName())
     */
    @Test
    void testAddSensorToExistingDeviceNullDeviceDTORoomName()throws Exception {
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", null);
        SensorDTO sensorDTO = new SensorDTO("sensor", "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null sensorDTO.getTypeOfSensor())
     */
    @Test
    void testAddSensorToExistingDeviceNullSensorDTOTypeOfSensor()throws Exception {
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        SensorDTO sensorDTO = new SensorDTO("sensor", null);
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( null sensorDTO.getSensorName())
     */
    @Test
    void testAddSensorToExistingDeviceNullSensorDTOSensorName() throws Exception{
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        SensorDTO sensorDTO = new SensorDTO(null, "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters( typeOfSensor not valid)
     */
    @Test
    void testAddSensorToExistingDeviceInvalidTypeOfSensor() throws Exception{
        //Arrange
        House house = House.getInstance();
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC05 controllerUS05 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        controllerUS05.addDeviceToRoom(deviceDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        SensorDTO sensorDTO = new SensorDTO("sensor", "temperature1");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters (sensorName empty)
     */
    @Test
    void testAddSensorToExistingDeviceEmptySensorName() throws Exception{
        //Arrange
        House house = House.getInstance();
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC05 controllerUS05 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        controllerUS05.addDeviceToRoom(deviceDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        SensorDTO sensorDTO = new SensorDTO("", "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test addSensorToExistingDevice method from ControllerUC07
     * invalid parameters (typeOfSensor Empty)
     */
    @Test
    void testAddSensorToExistingDeviceEmptyTypeOfSensor() throws Exception{
        //Arrange
        House house = House.getInstance();
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC05 controllerUS05 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room");
        controllerUS05.addDeviceToRoom(deviceDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        SensorDTO sensorDTO = new SensorDTO("sensor", "");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for ControllerUC07.addSensorToExistingDevice().
     * It verifies that the method returns false when null is passed as deviceDTO.
     */
    @Test
    void testGetRoomListTestValid() throws Exception{
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        //Act
        List<RoomDTO> result = controllerUS07.getRoomList();
        //Assert
        assertEquals(1, result.size());
        assertEquals("room", result.getFirst().getName());
        assertEquals(1, result.getFirst().getFloor());
        assertEquals(1, result.getFirst().getLength());
        assertEquals(1, result.getFirst().getWidth());
        assertEquals(1, result.getFirst().getHeight());
    }

    /**
     * Test method for ControllerUC07.getRoomList().
     * It verifies that the method returns an empty list when there are no rooms.
     */
    @Test
    void testGetRoomListTestEmpty() throws Exception{
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        //Act
        boolean result = (controllerUS07.getRoomList().isEmpty());
        //Assert
        assertTrue(result);
    }

    /**
     * Test method for ControllerUC07.getDeviceList().
     * It verifies that the method returns an empty list when there are no devices in the room.
     */
    @Test
    void testGetDeviceListTestEmpty() throws Exception{
        //Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        //Act
        boolean result = controllerUS07.getDeviceList("room").isEmpty();
        //Assert
        assertTrue(result);
    }

    /**
     * Test method for ControllerUC07.getDeviceList().
     * It verifies that the method returns a list with one device when there is one device in the room.
     */
    @Test
    void testGetDeviceListTestValid() throws Exception{
        //Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room1", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC05 controllerUS05 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room1");
        controllerUS05.addDeviceToRoom(deviceDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        //Act
        List<DeviceDTO> result = controllerUS07.getDeviceList("room1");
        //Assert
        assertSame("device", result.getFirst().getName());
        assertSame("type", result.getFirst().getType());
        assertSame("room1", result.getFirst().getLocation());
    }

    /**
     * Test method for ControllerUC07.addSensorToExistingDevice().
     * It verifies that the method returns true when a sensor is successfully added to a device.
     */
    @Test
    void testAddSensorToExistingDeviceValid() throws Exception{
        //Arrange
        ControllerUC02 controllerUS02 = new ControllerUC02();
        RoomDTO roomDTO = new RoomDTO("room1", 1, 1, 1, 1);
        controllerUS02.addNewRoomToHouse(roomDTO);
        ControllerUC05 controllerUS05 = new ControllerUC05();
        DeviceDTO deviceDTO = new DeviceDTO("device", "type", "room1");
        controllerUS05.addDeviceToRoom(deviceDTO);
        ControllerUC07 controllerUS07 = new ControllerUC07();
        SensorDTO sensorDTO = new SensorDTO("sensor", "temperature");
        //Act
        boolean result = controllerUS07.addSensorToExistingDevice(deviceDTO, sensorDTO);
        //Assert
        assertTrue(result);
    }

    /**
     * Test method for ControllerUC07.getSensorTypeDTO().
     * It verifies that the method returns a list with the types of sensors.
     */
    @Test
    void testGetSensorTypeDTOValid() throws Exception{
        //Arrange
        ControllerUC07 controllerUS07 = new ControllerUC07();
        //Act
        boolean result = controllerUS07.getSensorTypeDTO().getSensorTypes().contains("SensorOfTemperature");
        boolean result1 = controllerUS07.getSensorTypeDTO().getSensorTypes().contains("SensorOfHumidity");
        //Assert
        assertTrue(result && result1);
    }

}