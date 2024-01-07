package pt.ipp.isep.dei.examples.basic.domain.Bloco3.src.main.java.org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {
    @Test
    void somarParesPositivo (){
        int expected = 6;
        int result = org.example.Ex3.somaNumero(0,2,true);
        assertEquals(expected, result);
    }


}