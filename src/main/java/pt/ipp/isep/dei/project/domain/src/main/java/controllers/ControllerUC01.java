package controllers;

import DTOs.LocationDTO;
import org.domain.House;

/**
 * ControllerUC01
 * "As an Administrator, I want to configure the location of the house."
 */
public class ControllerUC01 {
    private final House house;
    /**
     * Constructor of the controller US01
     * Initializes the house instance
     */
    public ControllerUC01() throws Exception {
        this.house = House.getInstance();
    }

    /**
     * Method that configures the location of the house
     * @param locationDTO the location DTO
     * @return true if the location is valid, false otherwise*/
    public boolean configureHouseLocation(LocationDTO locationDTO) {
        if (locationDTO == null)return false;
        return house.configLocation(locationDTO.getAddress(), locationDTO.getZipCode(),
                        locationDTO.getLatitude(),
                        locationDTO.getLongitude());}}