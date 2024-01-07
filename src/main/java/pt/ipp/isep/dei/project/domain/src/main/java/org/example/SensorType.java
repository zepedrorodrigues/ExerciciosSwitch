package org.example;
import java.util.ArrayList;
import java.util.List;
/**Class SensorType to be instantiated by SensorTypeManager in order to create Sensors
 * when instantiated a new SensorType, it will add it to List<SensorType> validSensorTypes in class SensorTypeManager*/
public class SensorType {
    /**the name of the SensorType*/
    private String name;
    /**the List of valid SensorTypes*/
    private static List<SensorType> validSensorTypes = new ArrayList<>();
    /**the List of characteristics to be inputted by SensorTypeManager*/
    private List<String> characteristics;

    /**constructor that instantiates a SensorType
     * @param name the name to be inputted and saved
     * @param characteristics the List<String> to be inputted and saved, deepcopy to ensure encapsulation
     * saves name as a String and a copy of the List<String> characteristics
     * no throws because verifications are handled by SensorTypeManager*/
    public SensorType(String name, List<String>characteristics){
        if (name == null || characteristics == null)
            throw new NullPointerException("Null value");
        if (name.isEmpty() || characteristics.isEmpty())
            throw new IllegalArgumentException("Empty value");
        for (SensorType sensorType : validSensorTypes) {
            if (sensorType.getName().equals(name))
                throw new IllegalArgumentException("SensorType already exists");}
        this.name = name;
        this.characteristics=deepCopy(characteristics);
        validSensorTypes.add(this);}

    /**deepCopy of the List<String> characteristics, not shallow copy to assure encapsulation
     * @param characteristics list of Characteristics to be copied*/
    private List<String> deepCopy(List<String>characteristics){
        List<String> copy = new ArrayList<>();
        for(String charac : characteristics){
            copy.add(charac);}
        return copy;}

    /**retrieve the String name in order to instantiate a SensorType distantly(SensorTypeManager)*/
    public String getName(){
        return name;}
    /**retrieve the List<String> characteristics in order to instantiate a SensorType distantly(Sensor)*/
    public List<String> getCharacteristics(){
        return deepCopy(characteristics);}

    public static SensorType isSensorTypeAvailable(String type){
        if (type == null)
            throw new NullPointerException("Null value");
        for(SensorType sensorType : validSensorTypes){
            if(sensorType.getName().equals(type))
                return sensorType;}
        return null;}
}