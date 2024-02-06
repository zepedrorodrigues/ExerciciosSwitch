package org.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the Catalog class.
 * Each test case corresponds to a different scenario of adding a sensor to the catalog and retrieving the catalog.
 */
class CatalogTest {
    /**
     * Test case for adding a valid sensor to the catalog.
     * The test is supposed to be true if the sensor is added successfully.
     */
    @Test
    void testAddSensorValid() throws Exception{
        // Arrange
        Catalog catalog = new Catalog();
        // Act
        boolean result = catalog.addSensorType("SensorOfTempy");
        // Assert
        assertTrue(result);
    }

    /**
     * Test case for adding a sensor with an empty name to the catalog.
     * The test is supposed to be false if the sensor name is empty.
     */
    @Test
    void testAddSensorEmptyString() throws Exception{
        // Arrange
        Catalog catalog = new Catalog();
        // Act
        boolean result = catalog.addSensorType("");
        // Assert
        assertFalse(result);
    }

    /**
     * Test case for adding a sensor that already exists in the catalog.
     * The test is supposed to be false if the sensor already exists.
     */
    @Test
    void testAddSensorAlreadyExists() throws Exception{
        // Arrange
        Catalog catalog = new Catalog();
        // Act
        boolean result = catalog.addSensorType("SensorOfTemperature");
        // Assert
        assertFalse(result);
    }

    /**
     * Test case for getting the catalog after adding a sensor.
     * The test checks if the catalog contains the added sensor.
     */
    @Test
    void testGetCatalog() throws Exception{
        // Arrange
        Catalog catalog = new Catalog();
        catalog.addSensorType("SensorOfClarity");
        // Act and Assert
        assertEquals("SensorOfTemperature", catalog.getCatalog().get(0));
        assertEquals("SensorOfHumidity", catalog.getCatalog().get(1));
        assertEquals("CLARITY", catalog.getFunctionalities().get(2));
    }

    /**
     * Test case for getting the functionalities of the sensors in the catalog.
     * The test checks if the functionalities of the sensors are correct.
     */
    @Test
    void testGetFunctionalities() throws Exception{
        // Arrange
        Catalog catalog = new Catalog();
        catalog.addSensorType("SensorOfClarity");
        // Assert
        assertEquals("TEMPERATURE", catalog.getFunctionalities().get(0));
        assertEquals("HUMIDITY", catalog.getFunctionalities().get(1));
        assertEquals("CLARITY", catalog.getFunctionalities().get(2));
    }
}