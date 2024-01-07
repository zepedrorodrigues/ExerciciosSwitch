package org.example;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Actuator to be instantiated when creating a new Device
 * Before construction of a New Actuator inside a Device, Device checks
 * if the Actuator Type is a Valid Addition (using the List validActuators)*/
public class Actuator {
    /**The name of the Actuator*/
    private String name;
    /**characterisics of the Actuator*/
    private List<String> characteristics;
    private static String nullValue = "Null value not valid";

    /**constructor that inputs a new Actuator Type
     * @param name the name to be inputted and saver
     * @param characteristics a list of the characteristics
     * @throws NullPointerException for Null values in the @params
     * @throws IllegalArgumentException for empty @param name or @param characteristics
     * saves name as a String and a copy of the List<String> characteristics*/
    public Actuator(String name, List<String> characteristics) {
        if (name == null || characteristics == null)
            throw new NullPointerException(nullValue);
        if (name.isEmpty())
            throw new IllegalArgumentException("Empty name");
        if (characteristics.isEmpty())
            throw new IllegalArgumentException("Empty characteristics list");
        this.name = name;
        this.characteristics = deepCopyList(characteristics);}
    /**deepCopy of the characteristics to ensure not shallow copy of characteristics
     * @param list to copy the List of the Characteristics in a non-shallow way*/
    private List<String> deepCopyList(List<String> list) {
        List<String> copy = new ArrayList<>();
        for (String element : list) {
            copy.add(element);}
        return copy;}
    /**Returns the name of the Actuator*/
    public String getName() {
        return name;}
    /**Returns a deepCopy of the characteristics of the Actuator*/
    public List<String> getCharacteristics() {
        return deepCopyList(characteristics);}
}
