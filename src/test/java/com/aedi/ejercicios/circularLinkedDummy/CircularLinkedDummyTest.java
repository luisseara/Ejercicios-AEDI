package com.aedi.ejercicios.circularLinkedDummy;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método moveUpPositions de CircularLinkedDummy.
 */
public class CircularLinkedDummyTest {

    @Test
    public void testMoveUpDesdeUltimaPosicion() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(8);
        lista.insertarAlFinal(1);

        boolean resultado = lista.moveUpPositions(4); // Mover pos 4 (1) a pos 1

        assertTrue(resultado);
        assertEquals(4, lista.getNumberOfValues());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(5, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
        assertEquals(8, lista.getNodoEnPosicion(4).getElement());
    }

    @Test
    public void testMoveUpDesdePosicionMedia() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(8);
        lista.insertarAlFinal(1);

        boolean resultado = lista.moveUpPositions(3); // Mover pos 3 (8) a pos 1

        assertTrue(resultado);
        assertEquals(4, lista.getNumberOfValues());
        assertEquals(8, lista.getNodoEnPosicion(1).getElement());
        assertEquals(5, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
        assertEquals(1, lista.getNodoEnPosicion(4).getElement());
    }

    @Test
    public void testMoveUpDesdePosicion2() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(8);

        boolean resultado = lista.moveUpPositions(2); // Mover pos 2 (3) a pos 1

        assertTrue(resultado);
        assertEquals(3, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(1).getElement());
        assertEquals(5, lista.getNodoEnPosicion(2).getElement());
        assertEquals(8, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testMoveUpPosicion1RetornaFalse() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);

        boolean resultado = lista.moveUpPositions(1);

        assertFalse(resultado);
        // La lista no debe cambiar
        assertEquals(5, lista.getNodoEnPosicion(1).getElement());
        assertEquals(3, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testMoveUpPosicionInexistenteRetornaFalse() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);

        boolean resultado = lista.moveUpPositions(5); // Solo hay 2 elementos

        assertFalse(resultado);
        assertEquals(2, lista.getNumberOfValues());
    }

    @Test
    public void testMoveUpListaVaciaRetornaFalse() {
        CircularLinkedDummy lista = new CircularLinkedDummy();

        boolean resultado = lista.moveUpPositions(1);

        assertFalse(resultado);
        assertEquals(0, lista.getNumberOfValues());
    }

    @Test
    public void testMoveUpConDosElementos() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);

        boolean resultado = lista.moveUpPositions(2); // Mover 3 a pos 1

        assertTrue(resultado);
        assertEquals(2, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(1).getElement());
        assertEquals(5, lista.getNodoEnPosicion(2).getElement());
    }

    @Test
    public void testMoveUpMantieneCentinela() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        Node centinelaOriginal = lista.getLast();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(8);

        lista.moveUpPositions(3);

        assertSame(centinelaOriginal, lista.getLast());
    }

    @Test
    public void testMoveUpMantieneCircularidad() {
        CircularLinkedDummy lista = new CircularLinkedDummy();
        lista.insertarAlFinal(5);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(8);

        lista.moveUpPositions(3);

        // Verificar que la estructura sigue siendo circular
        Node current = lista.getLast();
        for (int i = 0; i <= lista.getNumberOfValues(); i++) {
            current = current.getNext();
        }
        // Después de recorrer numberOfValues + 1 veces, debemos volver al centinela
        assertSame(lista.getLast(), current);
    }
}