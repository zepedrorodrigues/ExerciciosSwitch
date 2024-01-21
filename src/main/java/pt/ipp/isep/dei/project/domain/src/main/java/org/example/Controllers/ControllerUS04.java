package org.example.Controllers;

import org.example.DTOs.SensorTypeDTO;
import org.example.Maps.MapsHouse;

public class ControllerUS04 {

    public ControllerUS04() {
        //Empty constructor, is a Controller
    }

    public boolean defineSensorType(String houseId, MapsHouse mapsHouse, SensorTypeDTO sensorTypeDTO){
        if(sensorTypeDTO==null||sensorTypeDTO.getType()==null||sensorTypeDTO.getUnit()==null)
            return false;
        return mapsHouse.addSensorType(houseId, sensorTypeDTO.getType(), sensorTypeDTO.getUnit());}
}
