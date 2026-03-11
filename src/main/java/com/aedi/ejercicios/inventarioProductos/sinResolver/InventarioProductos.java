package com.aedi.ejercicios.inventarioProductos.sinResolver;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Búsqueda y cálculo del valor total del inventario
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * CONTEXTO:
 * Un almacén gestiona su inventario de productos mediante una estructura
 * enlazada simple. Cada producto se representa como un nodo que almacena
 * el nombre del producto (String), la cantidad en stock (int) y el precio
 * unitario (double).
 *
 * La lista utiliza dos nodos centinela (nodos de control):
 *   - Un nodo cabecera (header) al principio, que no contiene datos válidos
 *     y cuyo enlace next apunta al primer nodo real (o al trailer si está vacía).
 *   - Un nodo cola (trailer) al final, que no contiene datos válidos y al que
 *     apunta el último nodo real de la lista.
 *
 * ESTRUCTURA VISUAL (con 3 productos):
 *
 *   [header] → [Teclado, 50, 29.99] → [Ratón, 120, 15.50] → [Monitor, 30, 249.99] → [trailer]
 *
 * ─────────────────────────────────────────────────────────────────────────
 *
 * SE PIDE:
 * Implementar DOS métodos:
 *
 * 1. buscarProducto(String nombre):
 *    Busca un producto por su nombre (comparación exacta, case-sensitive)
 *    y devuelve el nodo correspondiente. Si no se encuentra, devuelve null.
 *
 * 2. calcularValorTotal():
 *    Calcula el valor total del inventario sumando (cantidadStock * precioUnitario)
 *    para cada producto. Si la lista está vacía, devuelve 0.0.
 *
 * REGLAS:
 * 1. NO se permite usar estructuras auxiliares (arrays, ArrayList, etc.).
 * 2. La búsqueda y el cálculo deben realizarse recorriendo los enlaces next.
 * 3. No se deben contar ni procesar los nodos centinela.
 *
 * EJEMPLOS buscarProducto:
 * ┌───────────────────────────────────────────────────────────────────────────┬──────────────────────────┬──────────────────────────────────┐
 * │ Estado de la lista                                                        │ Llamada                  │ Resultado                        │
 * ├───────────────────────────────────────────────────────────────────────────┼──────────────────────────┼──────────────────────────────────┤
 * │ [header] → [Teclado, 50, 29.99] → [Ratón, 120, 15.50] → [trailer]        │ buscarProducto("Ratón")  │ NodoProducto[Ratón, 120, 15.50]  │
 * │ [header] → [Teclado, 50, 29.99] → [Ratón, 120, 15.50] → [trailer]        │ buscarProducto("Tablet") │ null                             │
 * │ [header] → [trailer] (vacía)                                              │ buscarProducto("Ratón")  │ null                             │
 * └───────────────────────────────────────────────────────────────────────────┴──────────────────────────┴──────────────────────────────────┘
 *
 * EJEMPLOS calcularValorTotal:
 * ┌───────────────────────────────────────────────────────────────────────────┬──────────────────────┐
 * │ Estado de la lista                                                        │ Resultado             │
 * ├───────────────────────────────────────────────────────────────────────────┼──────────────────────┤
 * │ [header] → [Teclado, 50, 29.99] → [Ratón, 120, 15.50] → [trailer]        │ 50*29.99 + 120*15.50 │
 * │                                                                           │ = 1499.50 + 1860.00  │
 * │                                                                           │ = 3359.50            │
 * │ [header] → [Monitor, 10, 249.99] → [trailer]                             │ 10*249.99 = 2499.90  │
 * │ [header] → [trailer] (vacía)                                              │ 0.0                  │
 * └───────────────────────────────────────────────────────────────────────────┴──────────────────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class InventarioProductos {

    private NodoProducto header;  // Nodo centinela inicial
    private NodoProducto trailer; // Nodo centinela final
    private int size;             // Número de elementos reales (sin contar centinelas)

    /**
     * Constructor: crea un inventario vacío con los dos nodos centinela enlazados.
     *
     * Estado inicial: [header] → [trailer]
     */
    public InventarioProductos() {
        this.trailer = new NodoProducto(null);
        this.header = new NodoProducto(this.trailer);
        this.size = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public int getSize() {
        return this.size;
    }

    public NodoProducto getHeader() {
        return this.header;
    }

    public NodoProducto getTrailer() {
        return this.trailer;
    }

    // ── Métodos a implementar por el alumno ────────────────────────────

    /**
     * Busca un producto por su nombre (comparación exacta, case-sensitive).
     *
     * @param nombre nombre del producto a buscar
     * @return el nodo del producto encontrado, o null si no existe
     */
    public NodoProducto buscarProducto(String nombre) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    /**
     * Calcula el valor total del inventario sumando
     * (cantidadStock * precioUnitario) de cada producto.
     *
     * @return el valor total del inventario, o 0.0 si está vacío
     */
    public double calcularValorTotal() {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un nuevo producto al final del inventario (justo antes del trailer).
     *
     * @param nombre         nombre del producto
     * @param cantidadStock  cantidad en stock
     * @param precioUnitario precio por unidad
     */
    public void insertarAlFinal(String nombre, int cantidadStock, double precioUnitario) {
        NodoProducto current = this.header;
        while (current.getNext() != this.trailer) {
            current = current.getNext();
        }
        NodoProducto nuevo = new NodoProducto(nombre, cantidadStock, precioUnitario, this.trailer);
        current.setNext(nuevo);
        this.size++;
    }

    /**
     * Devuelve el nodo real en la posición indicada (sin contar centinelas).
     *
     * @param posicion índice del nodo (0-indexed)
     * @return el nodo en la posición dada
     * @throws IndexOutOfBoundsException si la posición no es válida
     */
    public NodoProducto getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.size + ")"
            );
        }

        NodoProducto current = this.header.getNext();
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Devuelve una representación en texto del inventario (sin centinelas).
     * Ejemplo: "[Teclado, 50, 29.99] → [Ratón, 120, 15.50]"
     *
     * @return representación textual del inventario
     */
    @Override
    public String toString() {
        if (this.size == 0) {
            return "(vacío)";
        }

        StringBuilder sb = new StringBuilder();
        NodoProducto current = this.header.getNext();

        while (current != this.trailer) {
            if (sb.length() > 0) {
                sb.append(" → ");
            }
            sb.append("[")
              .append(current.getNombre())
              .append(", ")
              .append(current.getCantidadStock())
              .append(", ")
              .append(current.getPrecioUnitario())
              .append("]");
            current = current.getNext();
        }

        return sb.toString();
    }
}
