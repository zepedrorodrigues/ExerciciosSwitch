package org.example.Controllers;

import org.example.DTOs.DeviceDTO;
import org.example.Maps.MapDevices;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

public class ControllerUC08 {

    public ControllerUC08(){}

    public boolean deactivateDevice(String houseId, DeviceDTO deviceDTO, MapsHouse mapsHouse){
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        MapDevices mapDevices = mapRooms.roomToDevices.get(deviceDTO.getLocation());
        return mapDevices.deactivateDevice(deviceDTO.getName());}
}
