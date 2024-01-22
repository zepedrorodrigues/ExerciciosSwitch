package org.example.Controllers;

import org.example.DTOs.DeviceDTO;
import org.example.Maps.MapDevices;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

public class ControllerUC05 {
    public ControllerUC05(){}

    public boolean addDeviceToRoom(String houseId, DeviceDTO deviceDTO, MapsHouse mapsHouse){
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        MapDevices mapDevices = mapRooms.roomToDevices.get(deviceDTO.getLocation());
        return mapDevices.createDevice(deviceDTO.getName(), deviceDTO.getType());
    }



}
