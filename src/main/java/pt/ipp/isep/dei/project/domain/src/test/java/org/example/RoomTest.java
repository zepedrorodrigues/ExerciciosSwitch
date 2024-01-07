package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testGetName() {
        // Arrange
        String expectedName = "Living Room";
        Room room = new Room(expectedName, 1, 10.0, 20.0, 30.0);
        // Act
        String actualName = room.getName();
        // Assert
        assertEquals(expectedName, actualName);
    }

    @Test
    void testAddDeviceValid() throws IllegalArgumentException {
        //Arrange
        Room room = new Room("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type1 = new SensorType("Temperature6", List.of("Temperature", "Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Temperature6");
        Actuator actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        Device device = new Device("TemperatureRoom1", "deviceType", List.of(sensor), List.of(actuator));
        // Act & Assert
        assertDoesNotThrow(() -> {
            room.addDevice(device);
        });
    }

    @Test
    void testAddDeviceOnlySensor() {
        //Arrange
        Room room = new Room("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type2 = new SensorType("Temperature7", List.of("Temperature7", "Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Temperature7");
        Device device = new Device("TemperatureRoom1", "Thermostat", List.of(sensor), List.of());
        // Act & Assert
        assertDoesNotThrow(() -> {
            room.addDevice(device);
        });
    }

    @Test
    void testAddDuplicatedDeviceName() {
        //Arrange
        Room room = new Room("Living Room", 1, 10.0, 20.0, 30.0);
        SensorType type3 = new SensorType("Temperature8", List.of("Temperature", "Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Temperature8");
        Device device = new Device("TemperatureRoom1", "heater", List.of(sensor), List.of());
        room.addDevice(device);
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> room.addDevice(device));
        //Assert
        assertEquals("Device name already exists", exception.getMessage());
    }

    @Test
    void testGetFloorValid() {
        // Arrange
        Room myRoom = new Room("Living Room", 1, 10.0, 20.0, 30.0);

        // Act
        int floor = myRoom.getFloor();

        // Assert
        assertEquals(1, floor);
    }


    @Test
    void testGetWidthValid() {
        // Arrange
        Room myRoom = new Room("Living Room", 1, 10.0, 20.0, 30.0);

        // Act
        double width = myRoom.getWidth();

        // Assert
        assertEquals(10.0, width);
    }


    @Test
    void testGetLengthValid() {
        // Arrange
        Room myRoom = new Room("Living Room", 1, 10.0, 20.0, 30.0);

        // Act
        double length = myRoom.getLength();

        // Assert
        assertEquals(20.0, length);
    }


    @Test
    void testGetHeightValid() {
        // Arrange
        Room myRoom = new Room("Living Room", 1, 10.0, 20.0, 30.0);

        // Act
        double height = myRoom.getHeight();

        // Assert
        assertEquals(30.0, height);
    }

}

