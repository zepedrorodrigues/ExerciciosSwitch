package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class DeviceTest {
    @Test
    void testDeviceConstructor() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type1 = new SensorType("Temperature9", characteristicsSensor);
        Sensor sensor = new Sensor("Temperature1Room1", "Temperature9");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        //Act and Assert
        assertDoesNotThrow(() -> new Device("TemperatureRoom1", "heater", List.of(sensor), List.of(Actuator)));
    }

    @Test
    void testDeviceConstructorOnlySensor() {
        //Arrange
        SensorType type2 = new SensorType("Temperature10", List.of("Temperature", "Celsius"));
        Sensor sensor = new Sensor("Temperature1Room1", "Temperature10");
        //Act and Assert
        assertDoesNotThrow(() -> new Device("TemperatureRoom1", "heater", List.of(sensor), List.of()));
    }

    @Test
    void testDeviceConstructorNullName() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type3 = new SensorType("Temperature12", characteristicsSensor);
        List<Sensor> sensorList = List.of(new Sensor("Temperature1", "Temperature12"));
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> new Device(null, "heater", sensorList, actuatorList));
        //Assert
        assertEquals("Null value not valid", exception.getMessage());
    }

    @Test
    void testDeviceConstructorNullType() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type4 = new SensorType("Temperature11", characteristicsSensor);
        List<Sensor> sensorList = List.of(new Sensor("Temperature1", "Temperature11"));
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> new Device("Device1", null, sensorList, actuatorList));
        //Assert
        assertEquals("Null value not valid", exception.getMessage());
    }

    @Test
    void testDeviceConstructorNullSensorList() {
        //Arrange
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> new Device("Device1", "heater", null, actuatorList));
        //Assert
        assertEquals("Null value not valid", exception.getMessage());
    }

    @Test
    void testDeviceConstructorNullActuatorList() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type5 = new SensorType("Temperature100", characteristicsSensor);
        List<Sensor> sensorList = List.of(new Sensor("Temperature1", "Temperature100"));
        //Act
        Exception exception = assertThrows(NullPointerException.class, () -> new Device("Device1", "heater", sensorList, null));
        //Assert
        assertEquals("Null value not valid", exception.getMessage());
    }

    @Test
    void testDeviceConstructorEmptySensorList() {
        //Arrange
        List<Sensor> sensorList = new ArrayList<>();
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device("Device1", "heater", sensorList, actuatorList));
        //Assert
        assertEquals("Invalid or empty sensor list", exception.getMessage());
    }

    @Test
    void testDeviceConstructorEmptyName() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type6 = new SensorType("Temperature13", characteristicsSensor);
        List<Sensor> sensorList = List.of(new Sensor("Temperature1", "Temperature13"));
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device("", "heater", sensorList, actuatorList));
        //Assert
        assertEquals("Invalid device name", exception.getMessage());
    }

    @Test
    void testDeviceConstructorEmptyType() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type7 = new SensorType("Temperature14", characteristicsSensor);
        List<Sensor> sensorList = List.of(new Sensor("Temperature1", "Temperature14"));
        List<Actuator> actuatorList = List.of(new Actuator("Actuator", List.of("Actuator", "Type")));
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Device("Device1", "", sensorList, actuatorList));
        //Assert
        assertEquals("Invalid device type", exception.getMessage());
    }

    @Test
    void testGetDeviceNameValid() {
        //Arrange
        List<String> characteristicsSensor = List.of("Temperature", "Celsius");
        SensorType type8 = new SensorType("Temperature2.0", characteristicsSensor);
        Sensor sensor = new Sensor("Temperature", "Temperature2.0");
        Actuator Actuator = new Actuator("Heater", List.of("Heater", "MaxTemperature", "MinTemperature"));
        //Act and Assert
        Device myDevice = new Device("Temperature2.0Room2", "heater", List.of(sensor), List.of(Actuator));
        String exp = "Temperature2.0Room2";
        //Act
        String res = myDevice.getName();
        //Assert
        assertEquals(res, exp);
    }
}

