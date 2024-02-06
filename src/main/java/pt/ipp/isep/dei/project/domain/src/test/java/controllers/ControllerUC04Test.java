package controllers;

import org.domain.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ControllerUC04Test is a test class for ControllerUC04.
 * It uses JUnit to test the functionality of ControllerUC04 methods.
 */
class ControllerUC04Test {
    /**
     * The singleton instance of the House class.
     */
    House myHouse;

    /**
     * Setup method to initialize the House instance before each test.
     */
    @BeforeEach
    //ver
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
     * Test method for ControllerUC04.defineSensorType().
     * It verifies that the method returns true when a valid sensor type is defined.
     */
    @Test
    void testDefineDSensorType() throws Exception{
        //Arrange
        ControllerUC04 controllerUS04 = new ControllerUC04();
        String type = "SensorOfLight";
        //Act
        boolean result = controllerUS04.defineSensorType(type);
        //Assert
        assertTrue(result);
    }

    /**
     * Test method for ControllerUC04.defineSensorType().
     * It verifies that the method returns false when null is passed as sensor type.
     */

    @Test
    void testDefineSensorTypeNullData()throws Exception{
        //Arrange
        ControllerUC04 controllerUS04 = new ControllerUC04();
        //Act and Assert
        assertFalse(controllerUS04.defineSensorType(null));
    }

    /**
     * Test method for ControllerUC04.defineSensorType().
     * It verifies that the method returns false when null is passed as sensor type name.
     */
    @Test
    void testDefineSensorTypeNullName() throws Exception{
        //Arrange
        ControllerUC04 controllerUS04 = new ControllerUC04();
        String type = null;
        //Act and Assert
        assertFalse(controllerUS04.defineSensorType(type));
    }

    /**
     * Test method for ControllerUC04.defineSensorType().
     * It verifies that the method returns false when an empty string is passed as sensor type name.
     */
    @Test
    void testDefineSensorTypeEmptyNameReturnsFalse() throws Exception{
        //Arrange
        ControllerUC04 controllerUS04 = new ControllerUC04();
        String type = "";
        //Act
        boolean result = controllerUS04.defineSensorType(type);
        //Assert
        assertFalse(result);
    }

    /**
     * Test method for ControllerUC04.defineSensorType().
     * It verifies that the method returns false when the sensor type already exists.
     */
    @Test
    void testDefineSensorTypeAlreadyExistsReturnsFalse() throws Exception{
        //Arrange
        ControllerUC04 controllerUS04 = new ControllerUC04();
        String type = "type";
        House.getInstance().getCatalog().addSensorType("type");
        //Act
        boolean result = controllerUS04.defineSensorType(type);
        //Assert
        assertFalse(result);
    }
}