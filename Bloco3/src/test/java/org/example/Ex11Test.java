package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex11Test {
    @Test
    void estenderArraycomStrings() {
        String[] new_array = new String[0], expected = {null}, result = Ex11.estenderArraycomStrings(new_array);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotas() {
        int[] notas = {10, 9, -1};
        String[] expected = {"1. Suficiente", "2. Medíocre"}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotasDeVariosTipos() {
        int[] notas = {3, 14, 19};
        String[] expected = {"1. Mau", "2. Bom", "3. Muito Bom"}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotasDeVariosTiposDeNotas() {
        int[] notas = {12, 12, 0};
        String[] expected = {"1. Suficiente", "2. Suficiente", "3. Mau"}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotasInvalidas() {
        int[] notas = {-3, -14, -19};
        String[] expected = {}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotaMeioInvalida() {
        int[] notas = {19, -5, 8};
        String[] expected = {"1. Muito Bom"}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }

    @Test
    void devolveArraycomNotasDeVariosTiposDeNotasInvalidasAcimaDeVinte() {
        int[] notas = {21, 22, 23};
        String[] expected = {}, result = Ex11.devolveArraycomNotas(notas);
        assertArrayEquals(expected, result);
    }
}