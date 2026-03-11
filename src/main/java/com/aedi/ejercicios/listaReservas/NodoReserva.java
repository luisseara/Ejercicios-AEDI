package com.aedi.ejercicios.listaReservas;

/**
 * Nodo de una lista enlazada simple que representa una reserva de hotel.
 *
 * Cada nodo almacena el nombre del huésped, el número de habitación
 * asignada y una referencia al siguiente nodo de la lista.
 *
 * También se utiliza como nodo centinela (header/trailer) cuando se
 * construye sin datos válidos.
 */
public class NodoReserva {

    private String nombreHuesped;
    private int numHabitacion;
    private NodoReserva next;

    /**
     * Constructor completo para nodos con datos.
     *
     * @param nombreHuesped nombre del huésped
     * @param numHabitacion número de habitación asignada
     * @param next          referencia al siguiente nodo
     */
    public NodoReserva(String nombreHuesped, int numHabitacion, NodoReserva next) {
        this.nombreHuesped = nombreHuesped;
        this.numHabitacion = numHabitacion;
        this.next = next;
    }

    /**
     * Constructor para nodos centinela (sin datos válidos).
     *
     * @param next referencia al siguiente nodo
     */
    public NodoReserva(NodoReserva next) {
        this(null, -1, next);
    }

    // ── Getters y Setters ──────────────────────────────────────────────

    public String getNombreHuesped() {
        return this.nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public int getNumHabitacion() {
        return this.numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public NodoReserva getNext() {
        return this.next;
    }

    public void setNext(NodoReserva next) {
        this.next = next;
    }
}
