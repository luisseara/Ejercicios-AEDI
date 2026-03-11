package com.aedi.ejercicios.inventarioProductos.sinResolver;

/**
 * Nodo de una lista enlazada simple que representa un producto en el inventario.
 *
 * Cada nodo almacena el nombre del producto, la cantidad en stock, el precio
 * unitario y una referencia al siguiente nodo de la lista.
 *
 * También se utiliza como nodo centinela (header/trailer) cuando se
 * construye sin datos válidos.
 */
public class NodoProducto {

    private String nombre;
    private int cantidadStock;
    private double precioUnitario;
    private NodoProducto next;

    /**
     * Constructor completo para nodos con datos.
     *
     * @param nombre         nombre del producto
     * @param cantidadStock  cantidad disponible en stock
     * @param precioUnitario precio por unidad
     * @param next           referencia al siguiente nodo
     */
    public NodoProducto(String nombre, int cantidadStock, double precioUnitario, NodoProducto next) {
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precioUnitario = precioUnitario;
        this.next = next;
    }

    /**
     * Constructor para nodos centinela (sin datos válidos).
     *
     * @param next referencia al siguiente nodo
     */
    public NodoProducto(NodoProducto next) {
        this(null, 0, 0.0, next);
    }

    // ── Getters y Setters ──────────────────────────────────────────────

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return this.cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public NodoProducto getNext() {
        return this.next;
    }

    public void setNext(NodoProducto next) {
        this.next = next;
    }
}
