package controllers;
import org.domain.House;

/**
 * This class represents the controller for the user story 04
 * This controller is responsible for the creation of a new Device type */
public class ControllerUC04 {
    private House myHouse;
    /**
     * Constructor of the controller UC04
     */
    public ControllerUC04() throws Exception{
        myHouse = House.getInstance();
        //Empty constructor because it is a controller, does not require parameters saved in attributes
    }

    /**
     * This method creates a new sensorType
     * @param typeDTO DTO with the information of the new sensorType
     * @return true if the sensorType was created successfully, false if not*/
    public boolean defineSensorType(String typeDTO) {
        if(typeDTO ==null)return false;
        return myHouse.getCatalog().addSensorType(typeDTO);}
}