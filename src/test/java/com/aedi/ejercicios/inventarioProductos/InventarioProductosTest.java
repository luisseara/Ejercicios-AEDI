package com.aedi.ejercicios.inventarioProductos;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests de validación para los métodos buscarProducto y calcularValorTotal de InventarioProductos.
 */
public class InventarioProductosTest {

    // ── Tests de buscarProducto ────────────────────────────────────────

    @Test
    public void testBuscarProductoExistente() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);
        inv.insertarAlFinal("Monitor", 30, 249.99);

        NodoProducto resultado = inv.buscarProducto("Ratón");

        assertNotNull(resultado);
        assertEquals("Ratón", resultado.getNombre());
        assertEquals(120, resultado.getCantidadStock());
        assertEquals(15.50, resultado.getPrecioUnitario(), 0.001);
    }

    @Test
    public void testBuscarPrimerProducto() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);

        NodoProducto resultado = inv.buscarProducto("Teclado");

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());
    }

    @Test
    public void testBuscarUltimoProducto() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);
        inv.insertarAlFinal("Monitor", 30, 249.99);

        NodoProducto resultado = inv.buscarProducto("Monitor");

        assertNotNull(resultado);
        assertEquals("Monitor", resultado.getNombre());
    }

    @Test
    public void testBuscarProductoInexistente() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);

        NodoProducto resultado = inv.buscarProducto("Tablet");

        assertNull(resultado);
    }

    @Test
    public void testBuscarEnListaVacia() {
        InventarioProductos inv = new InventarioProductos();

        NodoProducto resultado = inv.buscarProducto("Ratón");

        assertNull(resultado);
    }

    @Test
    public void testBuscarEsCaseSensitive() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);

        assertNull(inv.buscarProducto("teclado"));
        assertNull(inv.buscarProducto("TECLADO"));
        assertNotNull(inv.buscarProducto("Teclado"));
    }

    // ── Tests de calcularValorTotal ────────────────────────────────────

    @Test
    public void testValorTotalConVariosProductos() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);

        double esperado = 50 * 29.99 + 120 * 15.50; // 1499.50 + 1860.00 = 3359.50
        assertEquals(esperado, inv.calcularValorTotal(), 0.001);
    }

    @Test
    public void testValorTotalConUnProducto() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Monitor", 10, 249.99);

        assertEquals(2499.90, inv.calcularValorTotal(), 0.001);
    }

    @Test
    public void testValorTotalListaVacia() {
        InventarioProductos inv = new InventarioProductos();

        assertEquals(0.0, inv.calcularValorTotal(), 0.001);
    }

    @Test
    public void testValorTotalConStockCero() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Agotado", 0, 99.99);
        inv.insertarAlFinal("Teclado", 10, 29.99);

        double esperado = 0 * 99.99 + 10 * 29.99; // 0.0 + 299.90 = 299.90
        assertEquals(esperado, inv.calcularValorTotal(), 0.001);
    }

    @Test
    public void testValorTotalConTresProductos() {
        InventarioProductos inv = new InventarioProductos();
        inv.insertarAlFinal("Teclado", 50, 29.99);
        inv.insertarAlFinal("Ratón", 120, 15.50);
        inv.insertarAlFinal("Monitor", 30, 249.99);

        double esperado = 50 * 29.99 + 120 * 15.50 + 30 * 249.99;
        assertEquals(esperado, inv.calcularValorTotal(), 0.001);
    }
}
