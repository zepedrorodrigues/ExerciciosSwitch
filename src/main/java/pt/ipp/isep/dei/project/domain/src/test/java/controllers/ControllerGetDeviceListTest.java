package controllers;

import DTOs.DeviceDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Test class for ControllerGetDeviceList.
 * This class contains test methods to verify the functionality of ControllerGetDeviceList.
 */
public class ControllerGetDeviceListTest {

    /**
     * The house instance from which the rooms are retrieved.
     */
    House myHouse;

    @BeforeEach
    void setUp()throws Exception {
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
     * The instance of ControllerGetDeviceList that is being tested.
     */
    private ControllerGetDeviceList controllerGetDeviceList;

    /**
     * Initial setup for each test.
     * Creates an instance of the house and adds a room to it.
     * Initializes the ControllerGetDeviceList.
     */
    @BeforeEach
    public void setup() {
        myHouse.addRoom("Living Room", 1, 1, 1, 1);
        controllerGetDeviceList = new ControllerGetDeviceList();
    }

    /**
     * Tests the getDeviceList method.
     * Checks if the returned device list is not null.
     */
    @Test
    public void testGetDeviceList()throws Exception{
        List<DeviceDTO> deviceList = controllerGetDeviceList.getDeviceList("Living Room");
        assertNotNull(deviceList, "The device list should not be null");
        // Add more assertions based on your expected results
    }

    /**
     * Tests the getDeviceList method when there are no devices in the room.
     * Checks if the returned device list is empty.
     */
    @Test
    public void testGetDeviceListEmpty() throws Exception{
        List<DeviceDTO> deviceList = controllerGetDeviceList.getDeviceList("Living Room");
        assertTrue(deviceList.isEmpty(), "The device list should be empty");
    }


}