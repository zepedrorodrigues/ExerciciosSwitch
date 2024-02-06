package controllers;

import DTOs.DeviceDTO;
import Mappers.MapperToDeviceDTO;
import org.domain.Device;
import org.domain.House;
import org.domain.Room;

import java.util.List;

/**
 * ControllerGetDeviceList is a controller class responsible for fetching the list of devices in a room.
 * It interacts with the House and Room domain objects to fetch the devices.
 */
public class ControllerGetDeviceList {
    /**
     * Constructor for ControllerGetDeviceList.
     */
    public ControllerGetDeviceList() {
        // Constructor for ControllerGetDeviceList
    }

    /**
     * Gets the list of devices in a room.
     *
     * @param roomName the name of the room.
     * @return the list of devices in the room.
     */
    public List<DeviceDTO> getDeviceList(String roomName) throws Exception{
        House house = House.getInstance();
        Room room = house.getRoomByName(roomName);
        List<Device> devices = room.getDeviceList();
        return new MapperToDeviceDTO().getDeviceList(devices, roomName);
    }
}
