package com.aedi.ejercicios.rankingJugadores;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Inserción ordenada en una lista enlazada con nodos centinela
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * CONTEXTO:
 * Una plataforma de videojuegos mantiene un ranking de jugadores ordenado
 * por puntuación de mayor a menor. Cada jugador se representa como un nodo
 * que almacena su gamertag (String) y su puntuación (int).
 *
 * La lista utiliza dos nodos centinela (nodos de control):
 *   - Un nodo cabecera (header) al principio, que no contiene datos válidos
 *     y cuyo enlace next apunta al primer nodo real (o al trailer si está vacía).
 *   - Un nodo cola (trailer) al final, que no contiene datos válidos y al que
 *     apunta el último nodo real de la lista.
 *
 * ESTRUCTURA VISUAL (ranking con 3 jugadores, ordenados de mayor a menor):
 *
 *   [header] → [xShadow, 9500] → [NeonByte, 7200] → [StarDust, 4100] → [trailer]
 *
 * ─────────────────────────────────────────────────────────────────────────
 *
 * SE PIDE:
 * Implementar el método insertarOrdenado(String gamertag, int puntuacion)
 * que inserte un nuevo jugador en la posición correcta para mantener la
 * lista ordenada de MAYOR a MENOR puntuación.
 *
 * REGLAS:
 * 1. ORDEN: La lista debe mantenerse siempre ordenada de mayor a menor
 *    puntuación. El nuevo nodo se inserta ANTES del primer nodo cuya
 *    puntuación sea MENOR que la del nuevo jugador.
 *
 * 2. EMPATE: Si hay jugadores con la misma puntuación, el nuevo jugador
 *    se inserta DESPUÉS de todos los que tengan la misma puntuación
 *    (es decir, se mantiene el orden de llegada para empates).
 *
 * 3. ACTUALIZACIÓN DEL TAMAÑO: Tras una inserción exitosa, el atributo size
 *    debe incrementarse en 1.
 *
 * 4. NO se permite usar estructuras auxiliares (arrays, ArrayList, etc.).
 *    La inserción debe realizarse manipulando únicamente los enlaces next.
 *
 * EJEMPLOS:
 * ┌──────────────────────────────────────────────────────────────────────┬─────────────────────────────────────────┬─────────────────────────────────────────────────────────────────────────────────┐
 * │ Estado inicial                                                       │ Llamada                                 │ Estado resultante                                                               │
 * ├──────────────────────────────────────────────────────────────────────┼─────────────────────────────────────────┼─────────────────────────────────────────────────────────────────────────────────┤
 * │ [header] → [trailer] (vacía)                                         │ insertarOrdenado("xShadow", 9500)       │ [header] → [xShadow, 9500] → [trailer]                                         │
 * │ [header] → [xShadow, 9500] → [trailer]                              │ insertarOrdenado("StarDust", 4100)      │ [header] → [xShadow, 9500] → [StarDust, 4100] → [trailer]                      │
 * │ [header] → [xShadow, 9500] → [StarDust, 4100] → [trailer]           │ insertarOrdenado("NeonByte", 7200)      │ [header] → [xShadow, 9500] → [NeonByte, 7200] → [StarDust, 4100] → [trailer]   │
 * │ [header] → [A, 100] → [B, 100] → [trailer]                          │ insertarOrdenado("C", 100)              │ [header] → [A, 100] → [B, 100] → [C, 100] → [trailer]  (empate: al final)      │
 * │ [header] → [A, 500] → [B, 300] → [C, 100] → [trailer]               │ insertarOrdenado("D", 800)              │ [header] → [D, 800] → [A, 500] → [B, 300] → [C, 100] → [trailer]               │
 * └──────────────────────────────────────────────────────────────────────┴─────────────────────────────────────────┴─────────────────────────────────────────────────────────────────────────────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class RankingJugadores {

    private NodoJugador header;  // Nodo centinela inicial
    private NodoJugador trailer; // Nodo centinela final
    private int size;            // Número de elementos reales (sin contar centinelas)

    /**
     * Constructor: crea un ranking vacío con los dos nodos centinela enlazados.
     *
     * Estado inicial: [header] → [trailer]
     */
    public RankingJugadores() {
        this.trailer = new NodoJugador(null);
        this.header = new NodoJugador(this.trailer);
        this.size = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public int getSize() {
        return this.size;
    }

    public NodoJugador getHeader() {
        return this.header;
    }

    public NodoJugador getTrailer() {
        return this.trailer;
    }

    // ── Método a implementar por el alumno ─────────────────────────────

    /**
     * Inserta un nuevo jugador en la posición correcta para mantener
     * la lista ordenada de MAYOR a MENOR puntuación.
     * En caso de empate, el nuevo jugador se inserta después de los
     * que tengan la misma puntuación.
     *
     * @param gamertag   nombre del jugador
     * @param puntuacion puntuación del jugador
     */
    public void insertarOrdenado(String gamertag, int puntuacion) {
        NodoJugador current = this.header;
        
        while (current.getNext() != this.trailer && current.getNext().getPuntuacion() >= puntuacion) {
            current = current.getNext();
        }

        NodoJugador nuevo = new NodoJugador(gamertag, puntuacion, current.getNext());
        current.setNext(nuevo);

        this.size++;
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Devuelve el nodo real en la posición indicada (sin contar centinelas).
     *
     * @param posicion índice del nodo (0-indexed)
     * @return el nodo en la posición dada
     * @throws IndexOutOfBoundsException si la posición no es válida
     */
    public NodoJugador getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.size + ")"
            );
        }

        NodoJugador current = this.header.getNext();
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Devuelve una representación en texto del ranking (sin centinelas).
     * Ejemplo: "[xShadow, 9500] → [NeonByte, 7200] → [StarDust, 4100]"
     *
     * @return representación textual del ranking
     */
    @Override
    public String toString() {
        if (this.size == 0) {
            return "(vacío)";
        }

        StringBuilder sb = new StringBuilder();
        NodoJugador current = this.header.getNext();

        while (current != this.trailer) {
            if (sb.length() > 0) {
                sb.append(" → ");
            }
            sb.append("[")
              .append(current.getGamertag())
              .append(", ")
              .append(current.getPuntuacion())
              .append("]");
            current = current.getNext();
        }

        return sb.toString();
    }
}
