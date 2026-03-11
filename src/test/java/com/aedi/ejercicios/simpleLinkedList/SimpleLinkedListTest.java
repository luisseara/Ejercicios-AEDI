package com.aedi.ejercicios.simpleLinkedList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método reposition de SimpleLinkedList.
 */
public class SimpleLinkedListTest {

    // ── Tests de reposicionamiento válido ──────────────────────────────

    @Test
    public void testRepositionMoverAlFinal() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(9);

        lista.reposition(7, 9); // Mover 7 después de 9

        assertEquals(4, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(0).getElement());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(9, lista.getNodoEnPosicion(2).getElement());
        assertEquals(7, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testRepositionMoverPrimeroAlMedio() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(9);

        lista.reposition(3, 1); // Mover 3 después de 1

        assertEquals(4, lista.getNumberOfValues());
        assertEquals(7, lista.getNodoEnPosicion(0).getElement());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(3, lista.getNodoEnPosicion(2).getElement());
        assertEquals(9, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testRepositionMoverUltimoAlPrincipio() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(9);

        lista.reposition(9, 3); // Mover 9 después de 3

        assertEquals(4, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(0).getElement());
        assertEquals(9, lista.getNodoEnPosicion(1).getElement());
        assertEquals(7, lista.getNodoEnPosicion(2).getElement());
        assertEquals(1, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testRepositionConDosElementos() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(10);

        lista.reposition(5, 10); // Mover 5 después de 10

        assertEquals(2, lista.getNumberOfValues());
        assertEquals(10, lista.getNodoEnPosicion(0).getElement());
        assertEquals(5, lista.getNodoEnPosicion(1).getElement());
    }

    @Test
    public void testRepositionMoverAdyacenteHaciaAdelante() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reposition(1, 2); // Mover 1 después de 2

        assertEquals(3, lista.getNumberOfValues());
        assertEquals(2, lista.getNodoEnPosicion(0).getElement());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(3, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testRepositionNoSeCreanNuevosNodos() {
        SimpleLinkedList lista = new SimpleLinkedList();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(1);

        // Guardar referencia al nodo original con valor 7
        Node nodo7Original = lista.getNodoEnPosicion(1);

        lista.reposition(7, 1);

        // El nodo 7 debe ser el MISMO objeto (no uno nuevo)
        Node nodo7Despues = lista.getNodoEnPosicion(2);
        assertSame(nodo7Original, nodo7Despues);
    }

    @Test
    public void testRepositionMantieneCentinela() {
        SimpleLinkedList lista = new SimpleLinkedList();
        Node centinelaOriginal = lista.getFirst();
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(7);
        lista.insertarAlFinal(1);

        lista.reposition(3, 1);

        assertSame(centinelaOriginal, lista.getFirst());
    }
}
