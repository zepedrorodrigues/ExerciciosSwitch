package org.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ActuatorTest is a test class for Actuator.
 * It uses JUnit to test the functionality of Actuator methods.
 */
class ActuatorTest {
    /**
     * Test method for Actuator constructor with valid parameters.
     * It verifies that the constructor creates an Actuator with the correct name and type.
     */
    @Test
    void testConstructorValid() {
        //Arrange
        Actuator actuator = new Actuator("name", "type");
        //Assert
        assertEquals("name", actuator.getName());
    }

    /**
     * Test method for Actuator constructor with an empty name.
     * It verifies that the constructor throws an IllegalArgumentException when the name is empty.
     */
    @Test
    void testConstructorNameEmptyThrowsIllegalArgumentException() {
        //Arrange, Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Actuator("", "type"));
        assertEquals("Name or type must not be empty.", exc.getMessage());
    }

    /**
     * Test method for Actuator constructor with an empty type.
     * It verifies that the constructor throws an IllegalArgumentException when the type is empty.
     */
    @Test
    void testConstructorTypeEmptyThrowsIllegalArgumentException() {
        //Arrange, Act and Assert
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> new Actuator("name", ""));
        assertEquals("Name or type must not be empty.", exc.getMessage());
    }

    /**
     * Test method for Actuator.getName().
     * It verifies that the method returns the correct name of the actuator.
     */
    @Test
    void testGetName() {
        //Arrange
        Actuator actuator = new Actuator("name", "type");
        //Act
        String name = actuator.getName();
        //Assert
        assertEquals("name", name);
    }

    /**
     * Test method for Actuator.getType().
     * It verifies that the method returns the correct type of the actuator.
     */
    @Test
    void testGetType() {
        //Arrange
        Actuator actuator = new Actuator("name", "type");
        //Act
        String type = actuator.getType();
        //Assert
        assertEquals("type", type);
    }
}