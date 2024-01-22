package org.example.Mappers;

import org.example.DTOs.DeviceDTO;
import org.example.DTOs.DeviceDTOfunc;
import org.example.Domain.Actuator;
import org.example.Domain.Sensor;
import org.example.Maps.MapDevices;
import org.example.Maps.MapRooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapperListofDevicesHouse {
    private MapRooms mapRooms;
    public MapperListofDevicesHouse(MapRooms mapRooms){
        this.mapRooms = mapRooms;}

    public Map<String,List<DeviceDTOfunc>> getListOfDevices(){
        List<DeviceDTOfunc> newList = new ArrayList<>();
        for(String roomId : mapRooms.roomToDevices.keySet()){
            MapDevices mapDevices = mapRooms.roomToDevices.get(roomId);
            for(String deviceID : mapDevices.deviceToSensors.keySet()){
                List<String> functionalities = new ArrayList<>();
                List<Actuator> actuators= mapDevices.deviceToActuators.get(deviceID);
                List<Sensor> sensors = mapDevices.deviceToSensors.get(deviceID);
                for(Actuator actuator : actuators) functionalities.add(actuator.getFunctionality());
                for(Sensor sensor : sensors) functionalities.add(sensor.getFunctionality());
                newList.add(new DeviceDTOfunc(deviceID,functionalities,roomId));}}
        return ordered(newList);}

    private Map<String, List<DeviceDTOfunc>> ordered(List<DeviceDTOfunc>list){
        Map<String,List<DeviceDTOfunc>> map = new java.util.HashMap<>();
        map.put("Temperature",new ArrayList<>());
        map.put("Humidity",new ArrayList<>());
        map.put("Hybrid",new ArrayList<>());
        map.put("Others",new ArrayList<>());
        for(DeviceDTOfunc device : list){
            if(device.getFunctionalities().contains("Temperature") && device.getFunctionalities().contains("Humidity"))
                map.get("Hybrid").add(device);
            else if(device.getFunctionalities().contains("Temperature"))
                map.get("Temperature").add(device);
            else if(device.getFunctionalities().contains("Humidity"))
                map.get("Humidity").add(device);}
        return map;}
}
