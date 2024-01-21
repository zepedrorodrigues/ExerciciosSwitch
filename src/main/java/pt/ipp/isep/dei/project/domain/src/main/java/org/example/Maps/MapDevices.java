package org.example.Maps;

import org.example.Domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDevices {
    public Map<String,String> devicetoType;
    public Map<String, List<Sensor>> deviceToSensors;
    public Map<String,List<Actuator>> deviceToActuators;
    public MapDevices() {
        devicetoType = new HashMap<>();
        deviceToSensors = new HashMap<>();
        deviceToActuators = new HashMap<>();}
    public boolean createDevice(String deviceId,String type) {
        if (deviceToSensors.containsKey(deviceId))
            return false;
        try{devicetoType.put(deviceId,type);
            deviceToSensors.put(deviceId, new ArrayList<>());
            deviceToActuators.put(deviceId, new ArrayList<>());
            return true;}
        catch (Exception e) {return false;}}
    public boolean addSensortoDevice(String deviceId, String typeOfSensor, SensorType sensorType ) {
        if (!deviceToSensors.containsKey(deviceId))
            return false;
        try{
            if(typeOfSensor.equalsIgnoreCase("Temperature")){
                deviceToSensors.get(deviceId).add(new TemperatureSensor(deviceId,sensorType));
                return true;}
            if(typeOfSensor.equalsIgnoreCase("Humidity")){
                deviceToSensors.get(deviceId).add(new HumiditySensor(deviceId,sensorType));
                return true;}
            return false;}
        catch (Exception e) {return false;}}
}
