package com.aedi.ejercicios.orderedList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método addLimited de OrderedList.
 */
public class OrderedListTest {

    // ── Tests de inserción válida ──────────────────────────────────────

    @Test
    public void testInsertarEnListaVacia() {
        OrderedList lista = new OrderedList();

        boolean resultado = lista.addLimited(5, 1);

        assertTrue(resultado);
        assertEquals(1, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(0).getElement());
    }

    @Test
    public void testInsertarMenorAlPrincipio() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(5, 1);

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(0).getElement());
        assertEquals(7, lista.getNodoEnPosicion(1).getElement());
        assertEquals(23, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testInsertarEnMedio() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(10, 2);

        assertTrue(resultado);
        assertEquals(5, lista.getNumberOfValues());
        assertEquals(7, lista.getNodoEnPosicion(0).getElement());
        assertEquals(8, lista.getNodoEnPosicion(1).getElement());
        assertEquals(8, lista.getNodoEnPosicion(2).getElement());
        assertEquals(10, lista.getNodoEnPosicion(3).getElement());
        assertEquals(23, lista.getNodoEnPosicion(4).getElement());
    }

    @Test
    public void testInsertarDuplicadoDentroDelLimite() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(8, 3); // Hay 2 ochos, maxDuplicates=3

        assertTrue(resultado);
        assertEquals(5, lista.getNumberOfValues());
        // Verificar que hay 3 ochos
        assertEquals(8, lista.getNodoEnPosicion(1).getElement());
        assertEquals(8, lista.getNodoEnPosicion(2).getElement());
        assertEquals(8, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testInsertarAlFinal() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(50, 1);

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(50, lista.getNodoEnPosicion(2).getElement());
    }

    // ── Tests de inserción rechazada ───────────────────────────────────

    @Test
    public void testMaxDuplicatesCeroRetornaFalse() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);

        boolean resultado = lista.addLimited(5, 0);

        assertFalse(resultado);
        assertEquals(1, lista.getNumberOfValues());
    }

    @Test
    public void testMaxDuplicatesNegativoRetornaFalse() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);

        boolean resultado = lista.addLimited(5, -1);

        assertFalse(resultado);
        assertEquals(1, lista.getNumberOfValues());
    }

    @Test
    public void testDuplicadoExcedeMaximo() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(8, 2); // Ya hay 2 ochos

        assertFalse(resultado);
        assertEquals(4, lista.getNumberOfValues());
    }

    @Test
    public void testDuplicadoExcedeMaximoConUno() {
        OrderedList lista = new OrderedList();
        lista.insertarOrdenado(7);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(8);
        lista.insertarOrdenado(23);

        boolean resultado = lista.addLimited(8, 1);

        assertFalse(resultado);
        assertEquals(4, lista.getNumberOfValues());
    }

    // ── Tests de mantenimiento del orden ───────────────────────────────

    @Test
    public void testOrdenSeMantieneTrasMúltiplesInserciones() {
        OrderedList lista = new OrderedList();

        lista.addLimited(10, 2);
        lista.addLimited(5, 2);
        lista.addLimited(20, 2);
        lista.addLimited(10, 2);
        lista.addLimited(1, 2);

        assertEquals(5, lista.getNumberOfValues());
        assertEquals(1, lista.getNodoEnPosicion(0).getElement());
        assertEquals(5, lista.getNodoEnPosicion(1).getElement());
        assertEquals(10, lista.getNodoEnPosicion(2).getElement());
        assertEquals(10, lista.getNodoEnPosicion(3).getElement());
        assertEquals(20, lista.getNodoEnPosicion(4).getElement());
    }

    @Test
    public void testInsertarEnListaVaciaConMaxDuplicatesCero() {
        OrderedList lista = new OrderedList();

        boolean resultado = lista.addLimited(5, 0);

        assertFalse(resultado);
        assertEquals(0, lista.getNumberOfValues());
    }
}
