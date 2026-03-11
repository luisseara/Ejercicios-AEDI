package com.aedi.ejercicios.colaPedidos.sinResolver;

/**
 * Nodo de una lista enlazada simple que representa un pedido en la cola.
 *
 * Cada nodo almacena un código de pedido, una prioridad y una referencia
 * al siguiente nodo de la lista.
 *
 * También se utiliza como nodo centinela (header/trailer) cuando se
 * construye sin datos válidos.
 */
public class NodoPedido {

    private String codigoPedido;
    private int prioridad;
    private NodoPedido next;

    /**
     * Constructor completo para nodos con datos.
     *
     * @param codigoPedido código identificador del pedido
     * @param prioridad    prioridad del pedido (1 = más alta)
     * @param next         referencia al siguiente nodo
     */
    public NodoPedido(String codigoPedido, int prioridad, NodoPedido next) {
        this.codigoPedido = codigoPedido;
        this.prioridad = prioridad;
        this.next = next;
    }

    /**
     * Constructor para nodos centinela (sin datos válidos).
     *
     * @param next referencia al siguiente nodo
     */
    public NodoPedido(NodoPedido next) {
        this(null, -1, next);
    }

    // ── Getters y Setters ──────────────────────────────────────────────

    public String getCodigoPedido() {
        return this.codigoPedido;
    }

    public void setCodigoPedido(String codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public NodoPedido getNext() {
        return this.next;
    }

    public void setNext(NodoPedido next) {
        this.next = next;
    }
}
