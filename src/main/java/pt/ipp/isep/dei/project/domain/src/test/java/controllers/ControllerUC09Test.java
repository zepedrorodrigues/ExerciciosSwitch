package controllers;

import DTOs.DeviceDTO;
import org.domain.Device;
import org.domain.House;
import org.domain.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class is responsible for testing the ControllerUC09 class.
 * It tests the getDeviceByFunctionality method under different conditions.
 */

class ControllerUC09Test {
    /**
     * The House instance that represents the house in the domain.
     */
    private House myHouse;
    /**
     * The ControllerUC09 instance that is used to perform operations related to use case 09.
     */
    ControllerUC09 ctrl;
    /**
     * The String instance that represents the first functionality to be tested.
     */
    String func1 = "TEMPERATURE";
    /**
     * The String instance that represents the second functionality to be tested.
     */
    String func2 = "HUMIDITY";

    /**
     * Setup method to initialize the ControllerUC09 instance before each test.
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
        ctrl = new ControllerUC09();
    }

    /**
     * This test checks if the method correctly handles the case where there is no rooms in the house.
     * The expected result is a map with two entries, with empty lists of devices.
     */
    @Test
    void getDeviceByFunctionalityEmptyList() {
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(0, result.get(func1).size()); // No devices detected for the first functionality
        assertEquals(0, result.get(func2).size()); // No devices detected for the second functionality
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with one device with no sensors.
     * The expected result is a map with two entries, with empty lists of devices.
     */
    @Test
    void getDeviceByFunctionalityOneRoomOneDeviceNoSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        Room myRoom = myHouse.getRoomByName("Kitchen");
        myRoom.createDevice("Fridge", "Fridge");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(0, result.get(func1).size()); // No devices detected for the first functionality
        assertEquals(0, result.get(func2).size()); // No devices detected for the second functionality
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with one device with one sensor.
     * The expected result is a map with two entries, with one device in the first entry.
     */
    @Test
    void getDeviceByFunctionalityOneRoomOneDeviceOneSensor() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        Room myRoom = myHouse.getRoomByName("Kitchen");
        myRoom.createDevice("Fridge", "Fridge");
        Device myDevice = myRoom.getDeviceByName("Fridge");
        myDevice.addSensor("FridgeTemperature", "Temperature");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(1, result.get(func1).size()); // One device detected for the first functionality
        assertEquals("Fridge", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals(0, result.get(func2).size()); // No devices detected for the second functionality

    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with one device with two different sensors.
     * The expected result is a map with two entries, with one device in each entry.
     */
    @Test
    void getDeviceByFunctionalityOneRoomOneDeviceTwoDifferentSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        Room myRoom = myHouse.getRoomByName("Kitchen");
        myRoom.createDevice("Fridge", "Fridge");
        Device myDevice = myRoom.getDeviceByName("Fridge");
        myDevice.addSensor("FridgeTemperature", "Temperature");
        myDevice.addSensor("FridgeHumidity", "Humidity");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(1, result.get(func1).size()); // One device detected for the first functionality
        assertEquals("Fridge", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals(1, result.get(func2).size()); // One device detected for the second functionality
        assertEquals("Fridge", result.get(func2).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func2).get(0).getLocation()); // The location is the expected one
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with one device with two equal sensors.
     * The expected result is a map with two entries, with one device in the first entry.
     */
    @Test
    void getDeviceByFunctionalityOneRoomOneDeviceTwoEqualSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        Room myRoom = myHouse.getRoomByName("Kitchen");
        myRoom.createDevice("Fridge", "Fridge");
        Device myDevice = myRoom.getDeviceByName("Fridge");
        myDevice.addSensor("FridgeTemperature", "Temperature");
        myDevice.addSensor("FridgeTemperature", "Temperature");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(1, result.get(func1).size()); // One device detected for the first functionality
        assertEquals("Fridge", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals(0, result.get(func2).size()); // No devices detected for the second functionality
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with two devices with different sensors.
     * The expected result is a map with two entries, with one device in each entry.
     */
    @Test
    void getDevicesByFunctionalityOneRoomTwoDevicesDifferentSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        Room myRoom = myHouse.getRoomByName("Kitchen");
        myRoom.createDevice("Fridge", "Fridge");
        myRoom.createDevice("Oven", "Oven");
        Device myDevice1 = myRoom.getDeviceByName("Fridge");
        myDevice1.addSensor("FridgeTemperature", "Temperature");
        Device myDevice2 = myRoom.getDeviceByName("Oven");
        myDevice2.addSensor("OvenHumidity", "Humidity");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(1, result.get(func1).size()); // One device detected for the first functionality
        assertEquals("Fridge", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals(1, result.get(func2).size()); // One device detected for the second functionality
        assertEquals("Oven", result.get(func2).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func2).get(0).getLocation()); // The location is the expected one
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with two devices with equal sensors.
     * The expected result is a map with two entries, with one device in the first entry.
     */
    @Test
    void getDevicesByFunctionalityTwoRoomsTwoDevicesSameSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        myHouse.addRoom("Bedroom", 0, 1, 2, 3);
        Room myRoom1 = myHouse.getRoomByName("Kitchen");
        myRoom1.createDevice("Fridge1", "Fridge1");
        Room myRoom2 = myHouse.getRoomByName("Bedroom");
        myRoom2.createDevice("Fridge2", "Fridge2");
        Device myDevice1 = myRoom1.getDeviceByName("Fridge1");
        myDevice1.addSensor("FridgeTemperature", "Temperature");
        Device myDevice2 = myRoom2.getDeviceByName("Fridge2");
        myDevice2.addSensor("FridgeTemperature", "Temperature");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(2, result.get(func1).size()); // Two devices detected for the first functionality
        assertEquals("Fridge1", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals("Fridge2", result.get(func1).get(1).getName()); // The device is the expected one
        assertEquals("Bedroom", result.get(func1).get(1).getLocation()); // The location is the expected one
        assertEquals(0, result.get(func2).size()); // No devices detected for the second functionality
    }

    /**
     * This test checks if the method correctly handles the case where there is one room in the house with two devices with different sensors.
     * The expected result is a map with two entries, with one device in each entry.
     */
    @Test
    void getDevicesByFunctionalityTwoRoomsTwoDevicesDifferentSensors() {
        //Arrange
        myHouse.addRoom("Kitchen", 0, 1, 2, 3);
        myHouse.addRoom("Bedroom", 0, 1, 2, 3);
        Room myRoom1 = myHouse.getRoomByName("Kitchen");
        myRoom1.createDevice("Fridge", "Fridge");
        Room myRoom2 = myHouse.getRoomByName("Bedroom");
        myRoom2.createDevice("Fridge", "Fridge");
        Device myDevice1 = myRoom1.getDeviceByName("Fridge");
        myDevice1.addSensor("FridgeTemperature", "Temperature");
        Device myDevice2 = myRoom2.getDeviceByName("Fridge");
        myDevice2.addSensor("FridgeHumidity", "Humidity");
        //Act
        Map<String, List<DeviceDTO>> result = ctrl.getDeviceByFunctionality();
        //Assert
        assertEquals(2, result.size()); // Two functionalities available
        assertEquals(1, result.get(func1).size()); // One device detected for the first functionality
        assertEquals("Fridge", result.get(func1).get(0).getName()); // The device is the expected one
        assertEquals("Kitchen", result.get(func1).get(0).getLocation()); // The location is the expected one
        assertEquals(1, result.get(func2).size()); // One device detected for the second functionality
        assertEquals("Fridge", result.get(func2).get(0).getName()); // The device is the expected one
        assertEquals("Bedroom", result.get(func2).get(0).getLocation()); // The location is the expected one
    }
}