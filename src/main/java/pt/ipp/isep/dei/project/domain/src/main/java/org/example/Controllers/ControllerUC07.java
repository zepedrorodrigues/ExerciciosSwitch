package org.example.Controllers;

import org.example.DTOs.DeviceDTO;
import org.example.DTOs.SensorDTO;
import org.example.Domain.SensorType;
import org.example.Maps.MapDevices;
import org.example.Maps.MapRooms;
import org.example.Maps.MapsHouse;

public class ControllerUC07 {

    public ControllerUC07(){}

    public boolean addSensorToDevice(String houseId, DeviceDTO deviceDTO, SensorDTO sensorDTO, MapsHouse mapsHouse){
        MapRooms mapRooms = mapsHouse.housetoRoom.get(houseId);
        MapDevices mapDevices = mapRooms.roomToDevices.get(deviceDTO.getLocation());
        SensorType sensorType = mapsHouse.getSensorTypeByName(houseId,sensorDTO.getSensorType());
        return mapDevices.addSensortoDevice(deviceDTO.getName(),sensorDTO.getTypeOfSensor(),sensorType);}
}
