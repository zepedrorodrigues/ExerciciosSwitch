package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {
    @Test
    void multiplosde2De2a5() {
        int min = 2, max = 5, mult = 2;
        boolean opcao = true;
        int[] expected = {2, 4}, result = Ex2.multiplosOuNaodeXnumIntervalo(min, max, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void multiplosde0de3a10() {
        int min = 3, max = 10, mult = 0;
        boolean opcao = true;
        int[] expected = {-1}, result = Ex2.multiplosOuNaodeXnumIntervalo(min, max, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void multiplosdeNegativo3de5a9() {
        int min = 5, max = 9, mult = -3;
        boolean opcao = true;
        int[] expected = {6, 9}, result = Ex2.multiplosOuNaodeXnumIntervalo(min, max, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void loopEstenderArraycomOutroArrayMultiplosde2de0a10() {
        int[] arrayminmax = {0, 10}, arrayfinal = {};
        int index = 0, mult = 2;
        boolean opcao = true;
        int[] expected = {0, 2, 4, 6, 8, 10}, result = Ex2.loopEstenderArraycomOutroArrayMultiploOuNao(arrayminmax, arrayfinal, index, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void loopEstenderArraycomOutroArrayMultiplosdeNegativo3de0a10() {
        int[] arrayminmax = {0, 10}, arrayfinal = {};
        int index = 0, mult = -3;
        boolean opcao = true;
        int[] expected = {0, 3, 6, 9}, result = Ex2.loopEstenderArraycomOutroArrayMultiploOuNao(arrayminmax, arrayfinal, index, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void loopEstenderArrayscomOutroArrayMultiplosdeZerode4a12() {
        int[] arrayfinal = {0}, arrayminmax = {4, 12};
        int index = 0, mult = 0;
        boolean opcao = true;
        int[] expected = {-1}, result = Ex2.loopEstenderArraycomOutroArrayMultiploOuNao(arrayminmax, arrayfinal, index, mult, opcao);
        assertArrayEquals(expected, result);
    }

    @Test
    void numerosImparesDe0a10() {
        int min = 0, max = 10, mult = 2;
        boolean opcao = false;
        int exp = 5, res = Ex2.numeroMultiplosdeX(min, max, mult, opcao);
        assertEquals(exp, res);
    }

    @Test
    void estenderArray1lugar() {
        int[] array = {}, expected = {0}, result = Ex2.estenderArray1lugar(array);
        assertArrayEquals(expected, result);
    }

    @Test
    void arrayInvalido() {
        int[] exp = {-1}, result = Ex2.arrayInvalido();
        assertArrayEquals(exp, result);
    }

    @Test
    void somadeNumerosdeumArray() {
        int[] array = {2, -3, 4, 7};
        int expected = 10, result = Ex2.somadeNumerosdeumArray(array);
        assertEquals(expected, result);
    }

    @Test
    void somadeNumerosdeumArrayVazio() {
        int[] array = {};
        int expected = 0, result = Ex2.somadeNumerosdeumArray(array);
        assertEquals(expected, result);
    }

    @Test
    void valoresComuns2Arrays() {
        int[] array1 = {2, 3, 7, 6}, array2 = {4, 5, 7, 1}, expected = {7}, result = Ex2.valoresComuns2Arrays(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test
    void valoresComuns2ArraysSemValoresComuns() {
        int[] array1 = {2, 3, 4}, array2 = {5, 6, 7}, expected = {}, result = Ex2.valoresComuns2Arrays(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test
    void multiplosde3e4NumIntervalode2a10() {
        int min = 2, max = 10, mult = 3, mult2 = 4;
        int[] exp = {}, result = Ex2.multiplosde2NumerosNumIntervalo(min, max, mult, mult2);
        assertArrayEquals(exp, result);
    }

    @Test
    void multiplosde2e3NumIntervalode2a10() {
        int min = 2, max = 10, m1 = 2, m2 = 3;
        int[] exp = {6}, res = Ex2.multiplosde2NumerosNumIntervalo(min, max, m1, m2);
        assertArrayEquals(exp, res);
    }

    @Test
    void multiplosde0e4NumIntervalode2a10Invalido() {
        int min = 2, max = 10, m1 = 0, m2 = 4;
        int[] exp = {-1}, res = Ex2.multiplosde2NumerosNumIntervalo(min, max, m1, m2);
        assertArrayEquals(exp, res);
    }

    @Test
    void maiorde2Numeros() {
        int x = 3, y = 5;
        int[] expected = {3, 5}, result = Ex2.maiorde2Numeros(x, y);
        assertArrayEquals(expected, result);
    }

    @Test
    void maiorde2NumerosIguais() {
        int x = 3, y = 3;
        int[] expected = {3, 3}, result = Ex2.maiorde2Numeros(x, y);
        assertArrayEquals(expected, result);
    }

    @Test
    void numeroMultiplosde2e3NumIntervaloDe0a10() {
        int min = 0, max = 10, x = 2, y = 3;
        int expected = 2, result = Ex2.numeroMultiplosdeXeY(min, max, x, y);
        assertEquals(expected, result);
    }

    @Test
    void numerosMultiplosde2e3NumIntervaloDe7a8Zero() {
        int min = 7, max = 8, m1 = 2, m2 = 3;
        int exp = 0, res = Ex2.numeroMultiplosdeXeY(min, max, m1, m2);
        assertEquals(exp, res);
    }

    @Test
    void numerosMultiplosde0e3NumIntervaloDe7a8Invalido() {
        int min = 7, max = 8, m1 = 0, m2 = 3;
        int exp = 0, result = Ex2.numeroMultiplosdeXeY(min, max, m1, m2);
        assertEquals(exp, result);
    }

    @Test
    void somaNumerosMultiplosde2e3NumIntervaloDe0a20() {
        int min = 0, max = 20, m1 = 2, m2 = 3;
        int exp = 36, result = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, m1, m2);
        assertEquals(exp, result);
    }

    @Test
    void somaNumerosMultiplosde5e6NumIntervaloDe2a2IntervaloVazio() {
        int min = 2, max = 2, m1 = 5, m2 = 6;
        int exp = 0, res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, m1, m2);
        assertEquals(exp, res);
    }

    @Test
    void somaNumerosMultiplosde0e3NumIntervaloDe5a10Invalido() {
        int min = 5, max = 10, m1 = 0, m2 = 3;
        int exp = 0, res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, m1, m2);
        assertEquals(exp, res);
    }

    @Test
    void testeAlineaAValoresNegativos() {
        int min = 0, max = -5, multi = 3;
        boolean opcao = true;
        int[] expected = {-3, 0};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaAValoresNegativos2() {
        int min = -20, max = 20, multi = 3;
        boolean opcao = true;
        int[] expected = {-18, -15, -12, -9, -6, -3, 0, 3, 6, 9, 12, 15, 18};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaASemMultiplos() {
        int min = 1, max = 2, multi = 3;
        boolean opcao = true;
        int[] expected = {};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaAValoresAoContrario() {
        int min = 5, max = 0, multi = 3;
        boolean opcao = true;
        int[] expected = {0, 3};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaBMultiploDeZero() {
        int min = 1, max = 2, multi = 0;
        boolean opcao = true;
        int[] expected = {-1};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaBMultiplo1e1() {
        int min = 1, max = 1, multi = 1;
        boolean opcao = true;
        int[] expected = {1};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaBMultiplo1Vazio() {
        int min = 1, max = 1, multi = 2;
        boolean opcao = true;
        int[] expected = {};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaBMultiplo1() {
        int min = 0, max = 10, multi = 1;
        boolean opcao = true;
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] res = Ex2.multiplosOuNaodeXnumIntervalo(min, max, multi, opcao);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaCMultiploDe3e5Simples() {
        int min = 0, max = 15, x = 3, y = 5;
        int[] expected = {0, 15};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaCMultiploDe3e5NumerosNegativos() {
        int min = -15, max = 15, x = 3, y = 5;
        int[] expected = {-15, 0, 15};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaCMultiploDe3e5Vazio() {
        int min = -14, max = -1, x = 3, y = 5;
        int[] expected = {};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaCMultiploDe3e5NumerosTrocados() {
        int min = 15, max = -15, x = 3, y = 5;
        int[] expected = {-15, 0, 15};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDMultiploDe3e5Invalido() {
        int min = 15, max = -15, x = 0, y = 1;
        int[] expected = {-1};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDSimples() {
        int min = 0, max = 15, x = 1, y = 5;
        int[] expected = {0, 5, 10, 15};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDNumerosIguais() {
        int min = 0, max = 15, x = 4, y = 4;
        int[] expected = {0, 4, 8, 12};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDNumerosIguaisIntervaloZero() {
        int min = 0, max = 0, x = 4, y = 4;
        int[] expected = {0};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDNumerosTrocados() {
        int min = -10, max = -15, x = 3, y = -2;
        int[] expected = {-12};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaDInvalido() {
        int min = -10, max = -15, x = 0, y = -2;
        int[] expected = {-1};
        int[] res = Ex2.multiplosde2NumerosNumIntervalo(min, max, x, y);
        assertArrayEquals(expected, res);
    }

    @Test
    void testeAlineaSomaSimples() {
        int min = 10, max = 15, x = 3, y = 2;
        int expected = 12;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void testeAlineaESomaZero() {
        int min = 0, max = 0, x = 3, y = 2;
        int expected = 0;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void testeAlineaESomaNegativa() {
        int min = -10, max = 0, x = 2, y = 4;
        int expected = -12;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void testeAlineaEInvalido() {
        int min = -10, max = 0, x = 0, y = 4;
        int expected = 0;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void testeAlineaEInverso() {
        int min = 5, max = -5, x = 1, y = 2;
        int expected = 0;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void testeAlineaEMesmoNum() {
        int min = 2, max = 2, x = 2, y = 2;
        int expected = 2;
        int res = Ex2.somaNumerosMultiplosdeXeYnumintervalo(min, max, x, y);
        assertEquals(expected, res);
    }

    @Test
    void numerosMultiplosDeXNormal() {
        int min = 2, max = 20, mult = 2;
        boolean opcao = true;
        int exp = 10, res = Ex2.numeroMultiplosdeX(min, max, mult, opcao);
        assertEquals(exp, res);
    }

    @Test
    void numerosMultiplosdeXInvalido() {
        int min = 2, max = 5, mult = 0;
        boolean opcao = true;
        int exp = -1, res = Ex2.numeroMultiplosdeX(min, max, mult, opcao);
        assertEquals(exp, res);
    }
}