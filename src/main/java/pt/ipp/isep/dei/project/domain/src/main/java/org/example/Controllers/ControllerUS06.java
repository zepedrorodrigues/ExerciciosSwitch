package org.example.Controllers;

import org.example.DTOs.DeviceDTO;
import org.example.DTOs.RoomDTO;
import org.example.Mappers.MapperListofDevices;
import org.example.Maps.MapDevices;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

import java.util.List;

public class ControllerUS06 {
    public ControllerUS06(){}

    public List<DeviceDTO> getListOfDevices(String houseId, RoomDTO roomDTO, MapsHouse mapsHouse){
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        MapDevices mapDevices = mapRooms.roomToDevices.get(roomDTO.getRoomId());
        return new MapperListofDevices().deviceIdsToDTO(mapDevices,roomDTO.getRoomId());}
}
