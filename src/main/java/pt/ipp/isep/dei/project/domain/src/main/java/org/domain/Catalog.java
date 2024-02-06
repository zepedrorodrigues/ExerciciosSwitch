package org.domain;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * The Catalog class is used to manage a list of sensors and their functionalities.
 * It provides methods to add new sensors and retrieve the list of sensors and functionalities.
 */
public class Catalog {
    /**
     * A list of functionalities provided by the sensors.
     */
    private List<String> functionalities = new ArrayList<>();
    /**
     * A list of sensors.
     */
    private List<Sensor> sensorList = new ArrayList<>();

    String configFilePath = "C:\\RepositorioSwitch\\switch-dev-class-assignment-2023-2024_switch-dev_g09\\src\\main\\java\\pt\\ipp\\isep\\dei\\project\\domain\\src\\main\\java\\org\\domain\\sensors.config";

    /**
     * Constructs a new Catalog object.
     */
    public Catalog() throws Exception{
        loadSensorClasses(configFilePath);
    }

    private void loadSensorClasses(String configFilePath) throws Exception {
        Properties props = new Properties();
        try {
            props.load(Files.newInputStream(Paths.get(configFilePath)));
            String[] classNames = props.getProperty("sensors").split(",");
            for (String className : classNames) {
                Class<?> cls = Class.forName(className.trim());
                Constructor<?> constructor = cls.getConstructor();
                sensorList.add((Sensor) constructor.newInstance());
                functionalities.add(className.substring("org.domain.SensorOf".length()).toUpperCase());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    /**
     * Adds a new sensor to the catalog.
     * The sensor name must start with "SensorOf" and must not already exist in the catalog.
     *
     * @param type The name of the sensor to add.
     * @return true if the sensor was added successfully, false otherwise.
     */
    public boolean addSensorType(String type) {
        if (!type.startsWith("SensorOf")) return false;
        for(Sensor sensor: this.sensorList)
            if(sensor.getType().equals(type.substring("SensorOf".length())))
                return false;
        functionalities.add(type.substring("SensorOf".length()).toUpperCase());
        return true;
    }

    /**
     * Returns the list of sensors in the catalog.
     *
     * @return A list of sensors.
     */
    public List<String> getCatalog() throws IOException {
        Properties props = new Properties();
        props.load(Files.newInputStream(Paths.get(configFilePath)));
        String[] classNames = props.getProperty("sensors").split(",");
        List<String> catalog = new ArrayList<>();
        for(String item : classNames)
            catalog.add(item.substring("org.domain.".length()));
        return catalog;}

    /**
     * Returns the list of functionalities provided by the sensors in the catalog.
     *
     * @return A list of functionalities.
     */
    public List<String> getFunctionalities() {
        return functionalities;
    }


}
