package com.aedi.ejercicios.colaPedidos;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método insertarEnPosicion de ColaPedidos.
 */
public class ColaPedidosTest {

    // ── Tests de inserción válida ──────────────────────────────────────

    @Test
    public void testInsertarEnListaVacia() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("PED-001", 3, 0);

        assertEquals(1, cola.getSize());
        assertEquals("PED-001", cola.getNodoEnPosicion(0).getCodigoPedido());
        assertEquals(3, cola.getNodoEnPosicion(0).getPrioridad());

        // Verificar que los centinelas están correctamente enlazados
        assertSame(cola.getNodoEnPosicion(0), cola.getHeader().getNext());
        assertSame(cola.getTrailer(), cola.getNodoEnPosicion(0).getNext());
    }

    @Test
    public void testInsertarAlPrincipio() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("PED-002", 1, 0);
        cola.insertarEnPosicion("PED-001", 3, 0); // Se inserta antes de PED-002

        assertEquals(2, cola.getSize());
        assertEquals("PED-001", cola.getNodoEnPosicion(0).getCodigoPedido());
        assertEquals("PED-002", cola.getNodoEnPosicion(1).getCodigoPedido());
    }

    @Test
    public void testInsertarEnMedio() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("A", 1, 0);
        cola.insertarEnPosicion("C", 3, 1);
        cola.insertarEnPosicion("B", 2, 1); // Se inserta entre A y C

        assertEquals(3, cola.getSize());
        assertEquals("A", cola.getNodoEnPosicion(0).getCodigoPedido());
        assertEquals("B", cola.getNodoEnPosicion(1).getCodigoPedido());
        assertEquals("C", cola.getNodoEnPosicion(2).getCodigoPedido());
    }

    @Test
    public void testInsertarAlFinal() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("A", 1, 0);
        cola.insertarEnPosicion("B", 2, 1);
        cola.insertarEnPosicion("C", 3, 2); // Se inserta al final

        assertEquals(3, cola.getSize());
        assertEquals("A", cola.getNodoEnPosicion(0).getCodigoPedido());
        assertEquals("B", cola.getNodoEnPosicion(1).getCodigoPedido());
        assertEquals("C", cola.getNodoEnPosicion(2).getCodigoPedido());

        // Verificar que el último nodo apunta al trailer
        assertSame(cola.getTrailer(), cola.getNodoEnPosicion(2).getNext());
    }

    @Test
    public void testInsertarVariosElementosEnOrden() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("PED-001", 3, 0);
        cola.insertarEnPosicion("PED-002", 1, 1);
        cola.insertarEnPosicion("PED-003", 2, 2);

        assertEquals(3, cola.getSize());
        assertEquals("PED-001", cola.getNodoEnPosicion(0).getCodigoPedido());
        assertEquals(3, cola.getNodoEnPosicion(0).getPrioridad());
        assertEquals("PED-002", cola.getNodoEnPosicion(1).getCodigoPedido());
        assertEquals(1, cola.getNodoEnPosicion(1).getPrioridad());
        assertEquals("PED-003", cola.getNodoEnPosicion(2).getCodigoPedido());
        assertEquals(2, cola.getNodoEnPosicion(2).getPrioridad());
    }

    @Test
    public void testInsertarMantieneCentinelas() {
        ColaPedidos cola = new ColaPedidos();
        NodoPedido headerOriginal = cola.getHeader();
        NodoPedido trailerOriginal = cola.getTrailer();

        cola.insertarEnPosicion("A", 1, 0);
        cola.insertarEnPosicion("B", 2, 1);
        cola.insertarEnPosicion("C", 3, 1);

        // Los centinelas no deben cambiar
        assertSame(headerOriginal, cola.getHeader());
        assertSame(trailerOriginal, cola.getTrailer());

        // El header debe seguir apuntando al primer nodo real
        assertEquals("A", cola.getHeader().getNext().getCodigoPedido());

        // El último nodo real debe apuntar al trailer
        assertSame(cola.getTrailer(), cola.getNodoEnPosicion(2).getNext());
    }

    // ── Tests de posición inválida ─────────────────────────────────────

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPosicionNegativa() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("X", 1, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPosicionMayorQueSize() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("A", 1, 0);
        cola.insertarEnPosicion("X", 1, 5); // size es 1, posición 5 es inválida
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPosicionIgualASizeMasUno() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("A", 1, 0);
        cola.insertarEnPosicion("B", 2, 1);
        cola.insertarEnPosicion("X", 1, 3); // size es 2, posición 3 es inválida
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPosicionEnListaVaciaDistintaDeCero() {
        ColaPedidos cola = new ColaPedidos();
        cola.insertarEnPosicion("X", 1, 1); // lista vacía, solo posición 0 es válida
    }

    // ── Tests del tamaño ────────────────────────────────────────────────

    @Test
    public void testSizeSeIncrementaCorrectamente() {
        ColaPedidos cola = new ColaPedidos();
        assertEquals(0, cola.getSize());

        cola.insertarEnPosicion("A", 1, 0);
        assertEquals(1, cola.getSize());

        cola.insertarEnPosicion("B", 2, 0);
        assertEquals(2, cola.getSize());

        cola.insertarEnPosicion("C", 3, 1);
        assertEquals(3, cola.getSize());

        cola.insertarEnPosicion("D", 4, 3);
        assertEquals(4, cola.getSize());
    }
}
