package com.aedi.ejercicios.linkedSimple;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método moveMinToEnd de LinkedSimple.
 */
public class LinkedSimpleTest {

    // ── Tests de operación válida ──────────────────────────────────────

    @Test
    public void testMoverMinDesdePrincipio() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(0).getElement());
        assertEquals(7, lista.getNodoEnPosicion(1).getElement());
        assertEquals(1, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testMoverMinDesdeMedio() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(7);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(0).getElement());
        assertEquals(7, lista.getNodoEnPosicion(1).getElement());
        assertEquals(1, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testMinYaEstaAlFinalRetornaTrue() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(8);
        lista.insertarAlFinal(1);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        // La lista no cambia porque 1 ya está al final
        assertEquals(4, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(0).getElement());
        assertEquals(2, lista.getNodoEnPosicion(1).getElement());
        assertEquals(8, lista.getNodoEnPosicion(2).getElement());
        assertEquals(1, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testMoverMinConCuatroElementos() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(9);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(6);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(9, lista.getNodoEnPosicion(0).getElement());
        assertEquals(6, lista.getNodoEnPosicion(1).getElement());
        assertEquals(4, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testMoverMinConDosElementos() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(2);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        assertEquals(2, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(0).getElement());
        assertEquals(2, lista.getNodoEnPosicion(1).getElement());
    }

    @Test
    public void testMoverMinConDuplicados() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(5);

        boolean resultado = lista.moveMinToEnd();

        assertTrue(resultado);
        assertEquals(4, lista.getNumberOfValues());
        // El primer mínimo (1) se mueve al final
        assertEquals(3, lista.getNodoEnPosicion(0).getElement());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(5, lista.getNodoEnPosicion(2).getElement());
        assertEquals(1, lista.getNodoEnPosicion(3).getElement());
    }

    // ── Tests de operación inválida ────────────────────────────────────

    @Test
    public void testListaVaciaRetornaFalse() {
        LinkedSimple lista = new LinkedSimple();

        boolean resultado = lista.moveMinToEnd();

        assertFalse(resultado);
        assertEquals(0, lista.getNumberOfValues());
    }

    @Test
    public void testUnSoloElementoRetornaFalse() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(5);

        boolean resultado = lista.moveMinToEnd();

        assertFalse(resultado);
        assertEquals(1, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(0).getElement());
    }

    // ── Tests de integridad ────────────────────────────────────────────

    @Test
    public void testNoSeCreanNuevosNodos() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(7);

        // Guardar referencia al nodo con valor 1
        Node nodoMinOriginal = lista.getNodoEnPosicion(1);

        lista.moveMinToEnd();

        // El nodo mínimo movido debe ser el MISMO objeto
        Node nodoMinFinal = lista.getNodoEnPosicion(2);
        assertSame(nodoMinOriginal, nodoMinFinal);
    }

    @Test
    public void testUltimoNodoApuntaANull() {
        LinkedSimple lista = new LinkedSimple();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(7);

        lista.moveMinToEnd();

        assertNull(lista.getNodoEnPosicion(2).getNext());
    }
}
