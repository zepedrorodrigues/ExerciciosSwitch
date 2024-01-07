package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void newHouseWithValidLocation() throws InstantiationException {
        // Arrange & Act
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Assert
        assertNotNull(myHouse);
    }

    @Test
    void newHouseWithInvalidLocation() {
        // Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House(null, "ZipCode", "GPS"));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void newHouseWithInvalidZipCode() {
        //Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House("Address", null, "GPS"));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void newHouseWithInvalidGPS() {
        // Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House("Address", "ZipCode", null));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void newHouseWithEmptyAddress() {
        // Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House("", "ZipCode", "GPS"));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void newHouseWithEmptyZipCode() {
        // Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House("Address", "", "GPS"));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void newHouseWithEmptyGPS() {
        // Arrange
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> new House("Address", "ZipCode", ""));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }


    @Test
    void configLocationInvalid() throws InstantiationException {
        // Arrange
        String oldAddress = "OldAddress";
        String oldZipCode = "OldZipCode";
        String oldGPS = "OldGPS";
        House myHouse = new House(oldAddress, oldZipCode, oldGPS);
        String expected = "Invalid Address, ZipCode or GPS Location";
        // Act
        Exception exception = assertThrows(InstantiationException.class, () -> myHouse.configLocation(null, null, null));
        String actual = exception.getMessage();
        // Assert
        assertTrue(actual.contains(expected));
    }

    @Test
    void configLocationValid() throws InstantiationException {
        // Arrange
        String oldAddress = "OldAddress";
        String oldZipCode = "OldZipCode";
        String oldGPS = "OldGPS";
        House myHouse = new House(oldAddress, oldZipCode, oldGPS);
        // Act
        boolean actual = myHouse.configLocation("NewAddress", "NewZipCode", "NewGPS");
        // Assert
        assertTrue(actual);
    }

    @Test
    void testAddRoom() throws InstantiationException {
//Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        //Act
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        //Assert
        assertEquals(1, myHouse.getRoomList().size());
    }

    @Test
    void testAddRoomNull() throws InstantiationException {
        //Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom(null, 1, 10.0, 20.0, 30.0));
        //Assert
        assertEquals("Room name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testAddRoomEmpty() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("", 1, 10.0, 20.0, 30.0));
        // Assert
        assertEquals("Room name cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testAddRoomWithSameName() throws InstantiationException {
        //Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        //Act
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0));
        //Assert
        assertEquals("A room with this name already exists", exception.getMessage());
    }

    @Test
    void testAddRoomNegativeWidth() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, -10.0, 20.0, 30.0));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());
    }

    @Test
    void testAddRoomNegativeLenght() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, 10.0, -20.0, 30.0));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());
    }

    @Test
    void testAddRoomNegativeHeight() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, 10.0, 20.0, -30.0));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());
    }

    @Test
    void testAddRoomZeroWidth() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, 0, 20.0, 30.0));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());
    }

    @Test
    void testAddRoomZeroLenght() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addRoom("Living Room", 1, 10.0, 0, 30.0));
        // Assert
        assertEquals("Invalid dimensions", exception.getMessage());
    }


    @Test
    void testGetRoomListValid() throws InstantiationException {
        // Arrange
        String oldAddress = "OldAddress";
        String oldZipCode = "OldZipCode";
        String oldGPS = "OldGPS";
        House myHouse = new House(oldAddress, oldZipCode, oldGPS);
        ArrayList<Room> expected = new ArrayList<>();
        // Act
        ArrayList<Room> actual = (ArrayList<Room>) myHouse.getRoomList();
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testRoomListInitializedEmpty() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        // Act
        List<Room> roomList = myHouse.getRoomList();
        // Assert
        assertTrue(roomList.isEmpty());
    }

    @Test
    void testRoomList() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        myHouse.addRoom("Bedroom", 2, 15.0, 25.0, 35.0);
        // Act
        List<Room> roomListCopy = myHouse.getRoomList();
        // Assert
        assertEquals(2, roomListCopy.size()); //
    }

    @Test
    void testGetRoomListNewInstance() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        myHouse.addRoom("Bedroom", 2, 15.0, 25.0, 35.0);
        // Act
        List<Room> roomListCopy = myHouse.getRoomList();
        // Assert
        assertEquals(2, roomListCopy.size());
    }

    @Test
    void testAddDeviceToRoomValid() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type1 = new SensorType("Humidity1", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity1");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        // Act and Assert
        assertDoesNotThrow(() -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity1", List.of(sensor), List.of(Actuator), "Living Room"));
    }

    @Test
    void testAddDeviceToRoomValidListOfRooms() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        myHouse.addRoom("Bedroom", 2, 15.0, 25.0, 35.0);
        myHouse.addRoom("Kitchen", 3, 20.0, 30.0, 40.0);
        //Act
        SensorType type2 = new SensorType("Humidity2", List.of("Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Humidity2");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        //Assert
        assertDoesNotThrow(() -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity2", List.of(sensor), List.of(Actuator), "Kitchen"));
    }


    @Test
    void testAddDevicetoRoomNullRoom() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        SensorType type3 = new SensorType("Humidity3", List.of("Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Humidity3");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity3", List.of(sensor), List.of(Actuator), null));
        // Assert
        assertEquals("Invalid room name", exception.getMessage());
    }

    @Test
    void testAddDeviceToRoomRoomNotFound() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        SensorType type5 = new SensorType("Humidity4", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity4");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity4", List.of(sensor), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Room not found", exception.getMessage());
    }

    @Test
    void testAddDeviceToRoomDeviceAlreadyExists() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type8 = new SensorType("Humidity5", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity5");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        Device device = new Device("TemperatureRoom1", "Humidity5", List.of(sensor), List.of(Actuator));
        myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity5", List.of(sensor), List.of(Actuator), "Living Room");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity5", List.of(sensor), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Device name already exists", exception.getMessage());
    }

    @Test
    void testAddDeviceCatchInvalidDeviceName() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type4 = new SensorType("Humidity6", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity6");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity6", List.of(sensor), List.of(Actuator), "Living Room");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("", "Humidity6", List.of(sensor), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Invalid device name", exception.getMessage());
    }

    @Test
    void testAddDeviceCatchInvalidDeviceType() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type3 = new SensorType("Humidity7", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity7");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity7", List.of(sensor), List.of(Actuator), "Living Room");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("TemperatureRoom1", "", List.of(sensor), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Invalid device type", exception.getMessage());
    }

    @Test
    void testAddDeviceCatchEmptySensorList() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        myHouse.addRoom("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type1 = new SensorType("Humidity8", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity8");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity8", List.of(sensor), List.of(Actuator), "Living Room");
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom("TemperatureRoom1", "Humidity8", new ArrayList<>(), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Invalid or empty sensor list", exception.getMessage());
    }

    @Test
    void testAddDeviceCatchNullDeviceName() throws InstantiationException {
        // Arrange
        House myHouse = new House("Address", "ZipCode", "GPS");
        SensorType type2 = new SensorType("Humidity9", List.of("volume"));
        Sensor sensor = new Sensor("Humidity1Room1", "Humidity9");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> myHouse.addDeviceToRoom(null, "Humidity9", List.of(sensor), List.of(Actuator), "Living Room"));
        // Assert
        assertEquals("Null value not valid", exception.getMessage());
    }
}