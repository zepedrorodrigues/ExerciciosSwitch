package controllers;

import DTOs.*;
import org.domain.*;

import java.util.List;

/**
 * Represents the controller of the US05:
 * "As a Power User [or Administrator], I want to add a new Device to a room from the
 * list of available sensor types, in order to configure it."
 */
public class ControllerUC05 {
    /**
     * The name of the house.
     */
    private House house;

    /**
     * Constructor of the controller UC05
     * Initializes the house instance
     */
    public ControllerUC05() throws Exception {
        this.house = House.getInstance();
    }

    /**
     * Fetches a list of RoomDTO objects by using ControllerGetRoomList.
     *
     * @return a list of RoomDTO objects representing the rooms in the house.
     */

    public List<RoomDTO> getRoomList() throws Exception{
        ControllerGetRoomList controllerGetRoomList = new ControllerGetRoomList();
        return controllerGetRoomList.getRoomList();
    }

    /**
     * method to add a device to a room.
     *
     * @return true if the device was added to the room, false otherwise
     */
    public boolean addDeviceToRoom(DeviceDTO deviceDTO) {
        Room room = house.getRoomByName(deviceDTO.getLocation());
        return room.createDevice(deviceDTO.getName(), deviceDTO.getType());
    }
}