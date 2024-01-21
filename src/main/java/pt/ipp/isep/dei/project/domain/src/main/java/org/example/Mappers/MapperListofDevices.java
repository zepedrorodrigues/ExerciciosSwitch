package org.example.Mappers;

import org.example.DTOs.DeviceDTO;
import org.example.Maps.MapDevices;

import java.util.ArrayList;
import java.util.List;

public class MapperListofDevices {

    public MapperListofDevices(){}

    public List<DeviceDTO> deviceIdsToDTO(MapDevices mapDevices,String roomId){
        List<DeviceDTO> newList = new ArrayList<>();
        for(String deviceId : mapDevices.deviceToSensors.keySet())
            new DeviceDTO(deviceId,mapDevices.devicetoType.get(deviceId),roomId);
        return newList;}
}
