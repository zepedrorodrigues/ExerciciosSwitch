package controllers;

import java.util.List;

import DTOs.DeviceDTO;
import DTOs.RoomDTO;
import DTOs.SensorDTO;
import DTOs.SensorTypeDTO;
import org.domain.*;
import Mappers.MapperSensorTypeDTO;

/**
 * ControllerUC07 is a controller class for User Story 07.
 * It provides functionality to add a sensor to an existing device in a room.
 * The ControllerUC07 class includes methods to get a list of rooms, choose a room, get a list of devices in the chosen room, and get the sensor types.
 */
public class ControllerUC07 {
    /**
     * The house instance to which the room is to be added.
     */
    private House house;

    /**
     * Constructor for ControllerUC07.
     * Initializes the house instance.
     */
    public ControllerUC07() throws Exception{
        this.house = House.getInstance();
        // Controller for US07 - as a Power User/Administrator, I want to add a Sensor to an Existing Device in a Room
        // This controller will be used to add a sensor to an existing device
    }

    /**
     * Gets the list of rooms in the house.
     *
     * @return the list of rooms in the house.
     */
    public List<RoomDTO> getRoomList() throws Exception{
        ControllerGetRoomList controllerGetRoomList = new ControllerGetRoomList();
        return controllerGetRoomList.getRoomList();

    }

    /**
     * Gets the list of devices in a room.
     *
     * @param roomName the name of the room.
     * @return the list of devices in the room.
     */
    public List<DeviceDTO> getDeviceList(String roomName) throws Exception{
        ControllerGetDeviceList controllerGetDeviceList = new ControllerGetDeviceList();
        return controllerGetDeviceList.getDeviceList(roomName);
    }

    /**
     * Gets the list of sensor types.
     *
     * @return the list of sensor types.
     */
    public SensorTypeDTO getSensorTypeDTO() throws Exception{
        List<String> sensors = house.getCatalog().getCatalog();
        return new MapperSensorTypeDTO().getSensorTypes(sensors);
    }

    /**
     * Adds a sensor to an existing device in a room.
     *
     * @param deviceDTO the DTO of the device to which the sensor is to be added.
     * @param sensorDTO the DTO of the sensor to be added.
     * @return true if the sensor was successfully added, false otherwise.
     * @throws IllegalArgumentException if the deviceDTO, sensorDTO, device name, device location, sensor type, or sensor name is null.
     */
    public boolean addSensorToExistingDevice(DeviceDTO deviceDTO, SensorDTO sensorDTO) {
        if (deviceDTO == null || sensorDTO == null || deviceDTO.getName() == null ||
                deviceDTO.getLocation() == null || sensorDTO.getTypeOfSensor() == null ||
                sensorDTO.getSensorName() == null) return false;
        Room room = this.house.getRoomByName(deviceDTO.getLocation());
        Device device = room.getDeviceByName(deviceDTO.getName());
        return device.addSensor(sensorDTO.getSensorName(), sensorDTO.getTypeOfSensor());
    }


}
