package com.aedi.ejercicios.rankingJugadores.sinResolver;

/**
 * Nodo de una lista enlazada simple que representa un jugador en el ranking.
 *
 * Cada nodo almacena el nombre del jugador (gamertag), su puntuación
 * y una referencia al siguiente nodo de la lista.
 *
 * También se utiliza como nodo centinela (header/trailer) cuando se
 * construye sin datos válidos.
 */
public class NodoJugador {

    private String gamertag;
    private int puntuacion;
    private NodoJugador next;

    /**
     * Constructor completo para nodos con datos.
     *
     * @param gamertag   nombre del jugador
     * @param puntuacion puntuación del jugador
     * @param next       referencia al siguiente nodo
     */
    public NodoJugador(String gamertag, int puntuacion, NodoJugador next) {
        this.gamertag = gamertag;
        this.puntuacion = puntuacion;
        this.next = next;
    }

    /**
     * Constructor para nodos centinela (sin datos válidos).
     *
     * @param next referencia al siguiente nodo
     */
    public NodoJugador(NodoJugador next) {
        this(null, -1, next);
    }

    // ── Getters y Setters ──────────────────────────────────────────────

    public String getGamertag() {
        return this.gamertag;
    }

    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public NodoJugador getNext() {
        return this.next;
    }

    public void setNext(NodoJugador next) {
        this.next = next;
    }
}
