package org.example.Controllers;

import org.example.DTOs.DeviceDTOfunc;
import org.example.Mappers.MapperListofDevicesHouse;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

import java.util.List;
import java.util.Map;

public class ControllerUC09 {
    public ControllerUC09(){}

    public Map<String, List<DeviceDTOfunc>> getListOfDevices(String houseId, MapsHouse mapsHouse){
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        return new MapperListofDevicesHouse(mapRooms).getListOfDevices();}
}
