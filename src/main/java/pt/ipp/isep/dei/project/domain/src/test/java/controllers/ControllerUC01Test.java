package controllers;


import DTOs.LocationDTO;
import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class is responsible for testing the ControllerUC01 class methods.
 * It includes tests for configuring the house location with various parameters.
 * The tests include valid parameters, null location DTO, empty address, empty zip code,
 * frontier latitude and longitude, and invalid latitude and longitude.
 */
class ControllerUC01Test {
    /**
     * Instance of ControllerUC01 to be tested.
     */
    private ControllerUC01 controllerUC01;
    /**
     * Instance of House for testing.
     */
    private House myHouse;

    /**
     * Sets up the test environment before each test method.
     * It resets the singleton instance of House.
     */
    @BeforeEach
    void setUp() throws Exception{
        try {
            Field instance = House.class.getDeclaredField("myHouse");
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        myHouse = House.getInstance();
    }

    /**
     * Test if the house location is successfully configured
     * with valid parameters
     */
    @Test
    void configureHouseLocationSuccess() throws Exception{
        // Arrange
        LocationDTO validLocationDTO = new LocationDTO("Address", "ZipCode", 0, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(validLocationDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test if the house location is not configured
     * with null location DTO
     */
    @Test
    void configureHouseLocationNullLocationDTO() throws Exception {
        // Arrange
        LocationDTO nullLocationDTO = null;
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(nullLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test if the house location empty address
     */
    @Test
    void configureHouseLocationEmptyAddress() throws Exception{
        // Arrange
        LocationDTO emptyAddressLocationDTO = new LocationDTO("", "ZipCode", 0, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyAddressLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test if the house location empty zip code
     */
    @Test
    void configureHouseLocationEmptyZipCode() throws Exception{
        // Arrange
        LocationDTO emptyZipCodeLocationDTO = new LocationDTO("Address", "", 0, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyZipCodeLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test house location frontier latitude 90º
     */
    @Test
    void confiureLocationFrontierLatitude90() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 90, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test house location frontier latitude -90º
     */
    @Test
    void confiureLocationFrontierLatitudeMinus90() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", -90, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test house location frontier longitude 180º
     */
    @Test
    void confiureLocationFrontierLongitude180() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 0, 180);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test house location frontier longitude -180º
     */

    @Test
    void confiureLocationFrontierLongitudeMinus180() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 0, -180);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertTrue(result);
    }

    /**
     * Test house location invalid latitude 90.1º
     */
    @Test
    void confiureLocationInvalidLatitude90PointOne() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 90.1, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test house location invalid latitude -90.1º
     */
    @Test
    void confiureLocationInvalidLatitudeMinus90PointOne() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", -90.1, 0);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test house location invalid longitude 180.1º
     */
    @Test
    void confiureLocationInvalidLongitude180PointOne() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 0, 180.1);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertFalse(result);
    }

    /**
     * Test house location invalid longitude -180.1º
     */

    @Test
    void confiureLocationInvalidLongitudeMinus180PointOne() throws Exception{
        // Arrange
        LocationDTO emptyLatitudeLocationDTO = new LocationDTO("Address", "ZipCode", 0, -180.1);
        ControllerUC01 controllerUC01 = new ControllerUC01();
        // Act
        boolean result = controllerUC01.configureHouseLocation(emptyLatitudeLocationDTO);
        // Assert
        assertFalse(result);
    }
}