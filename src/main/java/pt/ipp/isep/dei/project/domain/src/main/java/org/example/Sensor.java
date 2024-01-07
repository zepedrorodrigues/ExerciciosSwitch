package org.example;

/**Class Sensor to be instantiated in order to create Devices*/
public class Sensor {
    /**the name of the Sensor - different from type*/
    private String name;
    /**the type of the Sensor (derived from SensorType)*/
    private SensorType type;
    /**the value to be used in case of Null values*/
    private static String nullValue = "Null value not valid";

    /**constructor that inputs a new Sensor
     * @param name the name to be inputted and saver
     * @param type the String referring to the name of the SensorType. The SensorType
     *             must be available in the SensorTypeManager, if so, the characteristics are saved to the Sensor
     * @throws NullPointerException for Null values in the @params
     * @throws IllegalArgumentException for empty @param name, empty @param characteristics
     * or if the SensorType is not available in the SensorTypeManager
     * saves name as a String and a copy of the List<String> characteristics*/
    public Sensor(String name, String type) {
        if (name == null || type == null)
            throw new NullPointerException(nullValue);
        if (name.isEmpty()||type.isEmpty())
            throw new IllegalArgumentException("Empty name or type");
        if(SensorType.isSensorTypeAvailable(type)==null)
            throw new IllegalArgumentException("Sensor type not available");
        this.name = name;
        this.type = SensorType.isSensorTypeAvailable(type);}
    /**retrieve the String type in order to instantiate a Sensor distantly (Device)*/
    public String getType(){
        return type.getName();}
    /**retrieve the String name in order to instantiate a Sensor distantly(Device)*/
    public String getName(){
        return name;}

}
