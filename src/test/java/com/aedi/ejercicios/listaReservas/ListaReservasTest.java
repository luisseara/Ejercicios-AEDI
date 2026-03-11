package com.aedi.ejercicios.listaReservas;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para el método eliminarEnPosicion de ListaReservas.
 */
public class ListaReservasTest {

    // ── Tests de eliminación válida ────────────────────────────────────

    @Test
    public void testEliminarUnicoElemento() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);

        String eliminado = lista.eliminarEnPosicion(0);

        assertEquals("Ana", eliminado);
        assertEquals(0, lista.getSize());
        // Verificar que header apunta directamente al trailer
        assertSame(lista.getTrailer(), lista.getHeader().getNext());
    }

    @Test
    public void testEliminarPrimerElemento() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);
        lista.insertarAlFinal("Marta", 312);

        String eliminado = lista.eliminarEnPosicion(0);

        assertEquals("Ana", eliminado);
        assertEquals(2, lista.getSize());
        assertEquals("Luis", lista.getNodoEnPosicion(0).getNombreHuesped());
        assertEquals("Marta", lista.getNodoEnPosicion(1).getNombreHuesped());
    }

    @Test
    public void testEliminarElementoEnMedio() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);
        lista.insertarAlFinal("Marta", 312);

        String eliminado = lista.eliminarEnPosicion(1);

        assertEquals("Luis", eliminado);
        assertEquals(2, lista.getSize());
        assertEquals("Ana", lista.getNodoEnPosicion(0).getNombreHuesped());
        assertEquals("Marta", lista.getNodoEnPosicion(1).getNombreHuesped());
    }

    @Test
    public void testEliminarUltimoElemento() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);
        lista.insertarAlFinal("Marta", 312);

        String eliminado = lista.eliminarEnPosicion(2);

        assertEquals("Marta", eliminado);
        assertEquals(2, lista.getSize());
        assertEquals("Ana", lista.getNodoEnPosicion(0).getNombreHuesped());
        assertEquals("Luis", lista.getNodoEnPosicion(1).getNombreHuesped());
        // Verificar que el último nodo ahora apunta al trailer
        assertSame(lista.getTrailer(), lista.getNodoEnPosicion(1).getNext());
    }

    @Test
    public void testEliminarMantieneCentinelas() {
        ListaReservas lista = new ListaReservas();
        NodoReserva headerOriginal = lista.getHeader();
        NodoReserva trailerOriginal = lista.getTrailer();

        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);

        lista.eliminarEnPosicion(0);

        // Los centinelas no deben cambiar
        assertSame(headerOriginal, lista.getHeader());
        assertSame(trailerOriginal, lista.getTrailer());
    }

    @Test
    public void testEliminarTodosLosElementos() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);

        lista.eliminarEnPosicion(0); // Eliminar "Ana"
        assertEquals(1, lista.getSize());
        assertEquals("Luis", lista.getNodoEnPosicion(0).getNombreHuesped());

        lista.eliminarEnPosicion(0); // Eliminar "Luis"
        assertEquals(0, lista.getSize());
        assertSame(lista.getTrailer(), lista.getHeader().getNext());
    }

    // ── Tests de posición inválida ─────────────────────────────────────

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEliminarEnListaVacia() {
        ListaReservas lista = new ListaReservas();
        lista.eliminarEnPosicion(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEliminarPosicionNegativa() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.eliminarEnPosicion(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEliminarPosicionIgualASize() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);
        lista.eliminarEnPosicion(2); // size es 2, posición 2 es inválida
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEliminarPosicionMayorQueSize() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.eliminarEnPosicion(5);
    }

    // ── Tests del tamaño ────────────────────────────────────────────────

    @Test
    public void testSizeSeDecrementaCorrectamente() {
        ListaReservas lista = new ListaReservas();
        lista.insertarAlFinal("Ana", 101);
        lista.insertarAlFinal("Luis", 205);
        lista.insertarAlFinal("Marta", 312);
        assertEquals(3, lista.getSize());

        lista.eliminarEnPosicion(1);
        assertEquals(2, lista.getSize());

        lista.eliminarEnPosicion(0);
        assertEquals(1, lista.getSize());

        lista.eliminarEnPosicion(0);
        assertEquals(0, lista.getSize());
    }
}
