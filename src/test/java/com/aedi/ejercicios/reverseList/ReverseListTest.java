package com.aedi.ejercicios.reverseList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método reverseBetween de ReverseList.
 */
public class ReverseListTest {

    // ── Tests de inversión válida ──────────────────────────────────────

    @Test
    public void testInvertirSegmentoMedio() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1); // A
        lista.insertarAlFinal(2); // B
        lista.insertarAlFinal(3); // C
        lista.insertarAlFinal(4); // D
        lista.insertarAlFinal(5); // E

        lista.reverseBetween(2, 4); // Invertir B,C,D → D,C,B

        assertEquals(5, lista.getNumberOfValues());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement()); // A
        assertEquals(4, lista.getNodoEnPosicion(2).getElement()); // D
        assertEquals(3, lista.getNodoEnPosicion(3).getElement()); // C
        assertEquals(2, lista.getNodoEnPosicion(4).getElement()); // B
        assertEquals(5, lista.getNodoEnPosicion(5).getElement()); // E
    }

    @Test
    public void testInvertirTodaLaLista() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(5);

        lista.reverseBetween(1, 5);

        assertEquals(5, lista.getNumberOfValues());
        assertEquals(5, lista.getNodoEnPosicion(1).getElement());
        assertEquals(4, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
        assertEquals(2, lista.getNodoEnPosicion(4).getElement());
        assertEquals(1, lista.getNodoEnPosicion(5).getElement());
    }

    @Test
    public void testInvertirDesdePrincipio() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(5);

        lista.reverseBetween(1, 3); // Invertir 1,2,3 → 3,2,1

        assertEquals(5, lista.getNumberOfValues());
        assertEquals(3, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(1, lista.getNodoEnPosicion(3).getElement());
        assertEquals(4, lista.getNodoEnPosicion(4).getElement());
        assertEquals(5, lista.getNodoEnPosicion(5).getElement());
    }

    @Test
    public void testInvertirHastaFinal() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(5);

        lista.reverseBetween(3, 5); // Invertir 3,4,5 → 5,4,3

        assertEquals(5, lista.getNumberOfValues());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(5, lista.getNodoEnPosicion(3).getElement());
        assertEquals(4, lista.getNodoEnPosicion(4).getElement());
        assertEquals(3, lista.getNodoEnPosicion(5).getElement());
    }

    @Test
    public void testInvertirDosElementos() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(1, 2);

        assertEquals(3, lista.getNumberOfValues());
        assertEquals(2, lista.getNodoEnPosicion(1).getElement());
        assertEquals(1, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testInvertirUnSoloElementoNoCambia() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(2, 2); // Un solo elemento, no cambia

        assertEquals(3, lista.getNumberOfValues());
        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
    }

    // ── Tests de posiciones inválidas ──────────────────────────────────

    @Test
    public void testStartPosEsCeroNoCambia() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(0, 2); // Posición 0 inválida

        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testEndPosMayorQueSizeNoCambia() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(2, 5); // endPos fuera de rango

        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testStartMayorQueEndNoCambia() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(3, 1); // start > end

        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
    }

    @Test
    public void testStartNegativoNoCambia() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);

        lista.reverseBetween(-1, 2);

        assertEquals(1, lista.getNodoEnPosicion(1).getElement());
        assertEquals(2, lista.getNodoEnPosicion(2).getElement());
    }

    // ── Tests de integridad de la lista doble ──────────────────────────

    @Test
    public void testEnlacesPrevCorrectosTrasInversion() {
        ReverseList lista = new ReverseList();
        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(5);

        lista.reverseBetween(2, 4);

        // Verificar enlaces next
        assertEquals(4, lista.getNodoEnPosicion(2).getElement());
        assertEquals(3, lista.getNodoEnPosicion(3).getElement());
        assertEquals(2, lista.getNodoEnPosicion(4).getElement());

        // Verificar enlaces prev
        assertSame(lista.getNodoEnPosicion(1), lista.getNodoEnPosicion(2).getPrev());
        assertSame(lista.getNodoEnPosicion(2), lista.getNodoEnPosicion(3).getPrev());
        assertSame(lista.getNodoEnPosicion(3), lista.getNodoEnPosicion(4).getPrev());
        assertSame(lista.getNodoEnPosicion(4), lista.getNodoEnPosicion(5).getPrev());
    }

    @Test
    public void testCentinelasNoSeModifican() {
        ReverseList lista = new ReverseList();
        DoubleNode firstOriginal = lista.getFirst();
        DoubleNode lastOriginal = lista.getLast();

        lista.insertarAlFinal(1);
        lista.insertarAlFinal(2);
        lista.insertarAlFinal(3);

        lista.reverseBetween(1, 3);

        assertSame(firstOriginal, lista.getFirst());
        assertSame(lastOriginal, lista.getLast());
        // El centinela first debe apuntar al nuevo primer nodo
        assertEquals(3, lista.getFirst().getNext().getElement());
        // El centinela last debe ser apuntado por el nuevo último nodo
        assertSame(lista.getLast(), lista.getNodoEnPosicion(3).getNext());
    }
}
