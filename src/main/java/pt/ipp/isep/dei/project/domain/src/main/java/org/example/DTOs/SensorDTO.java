package org.example.DTOs;

public class SensorDTO {

    private String sensorName;
    private String typeOfSensor;
    private String sensorType;

    public SensorDTO(String sensorName, String typeOfSensor, String sensorTypeName) {
        this.sensorName = sensorName;
        this.typeOfSensor = typeOfSensor;
        this.sensorType = sensorTypeName;
    }

    public String getSensorName() {
        return sensorName;}

    public String getTypeOfSensor() {
        return typeOfSensor;}

    public String getSensorType() {
        return sensorType;}
}