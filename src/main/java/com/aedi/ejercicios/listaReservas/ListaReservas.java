package com.aedi.ejercicios.listaReservas;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Eliminación en posición en una lista enlazada con nodos centinela
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * CONTEXTO:
 * Un hotel de lujo gestiona sus reservas activas mediante una estructura
 * enlazada simple. Cada reserva se representa como un nodo que almacena
 * el nombre del huésped (String) y el número de habitación asignada (int).
 *
 * La lista utiliza dos nodos centinela (nodos de control):
 *   - Un nodo cabecera (header) al principio, que no contiene datos válidos
 *     y cuyo enlace next apunta al primer nodo real (o al trailer si está vacía).
 *   - Un nodo cola (trailer) al final, que no contiene datos válidos y al que
 *     apunta el último nodo real de la lista.
 *
 * ESTRUCTURA VISUAL (con 3 reservas):
 *
 *   [header] → [Ana, 101] → [Luis, 205] → [Marta, 312] → [trailer]
 *
 * ─────────────────────────────────────────────────────────────────────────
 *
 * SE PIDE:
 * Implementar el método eliminarEnPosicion(int posicion) que elimine el nodo
 * que se encuentra en la posición indicada (indexada desde 0), devolviendo
 * el nombre del huésped cuya reserva fue eliminada.
 *
 * REGLAS:
 * 1. POSICIONES VÁLIDAS: La posición debe estar en el rango [0, size-1].
 *
 * 2. POSICIÓN INVÁLIDA: Si la posición está fuera del rango válido, lanzar
 *    una excepción IndexOutOfBoundsException con el mensaje:
 *    "Posición inválida: X (tamaño actual: Y)"
 *
 * 3. LISTA VACÍA: Si la lista está vacía, lanzar IndexOutOfBoundsException.
 *
 * 4. ACTUALIZACIÓN DEL TAMAÑO: Tras una eliminación exitosa, el atributo
 *    size debe decrementarse en 1.
 *
 * 5. VALOR DE RETORNO: El método debe devolver el nombre del huésped
 *    cuya reserva fue eliminada.
 *
 * 6. NO se permite usar estructuras auxiliares (arrays, ArrayList, etc.).
 *    La eliminación debe realizarse manipulando únicamente los enlaces next.
 *
 * EJEMPLOS:
 * ┌──────────────────────────────────────────────────────────────┬────────────────────────┬───────────────────────────────────────────────────┬──────────────┐
 * │ Estado inicial                                               │ Llamada                │ Estado resultante                                  │ Retorna      │
 * ├──────────────────────────────────────────────────────────────┼────────────────────────┼───────────────────────────────────────────────────┼──────────────┤
 * │ [header] → [Ana, 101] → [Luis, 205] → [Marta, 312] → [trailer] │ eliminarEnPosicion(0) │ [header] → [Luis, 205] → [Marta, 312] → [trailer] │ "Ana"        │
 * │ [header] → [Ana, 101] → [Luis, 205] → [Marta, 312] → [trailer] │ eliminarEnPosicion(1) │ [header] → [Ana, 101] → [Marta, 312] → [trailer]  │ "Luis"       │
 * │ [header] → [Ana, 101] → [Luis, 205] → [Marta, 312] → [trailer] │ eliminarEnPosicion(2) │ [header] → [Ana, 101] → [Luis, 205] → [trailer]   │ "Marta"      │
 * │ [header] → [Ana, 101] → [trailer]                               │ eliminarEnPosicion(0) │ [header] → [trailer]                               │ "Ana"        │
 * │ [header] → [trailer] (vacía)                                     │ eliminarEnPosicion(0) │ Lanza IndexOutOfBoundsException                    │              │
 * └──────────────────────────────────────────────────────────────┴────────────────────────┴───────────────────────────────────────────────────┴──────────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class ListaReservas {

    private NodoReserva header;  // Nodo centinela inicial
    private NodoReserva trailer; // Nodo centinela final
    private int size;            // Número de elementos reales (sin contar centinelas)

    /**
     * Constructor: crea una lista vacía con los dos nodos centinela enlazados.
     *
     * Estado inicial: [header] → [trailer]
     */
    public ListaReservas() {
        this.trailer = new NodoReserva(null);
        this.header = new NodoReserva(this.trailer);
        this.size = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public int getSize() {
        return this.size;
    }

    public NodoReserva getHeader() {
        return this.header;
    }

    public NodoReserva getTrailer() {
        return this.trailer;
    }

    // ── Método a implementar por el alumno ─────────────────────────────

    /**
     * Elimina el nodo en la posición indicada y devuelve el nombre del
     * huésped cuya reserva fue eliminada.
     *
     * @param posicion posición del nodo a eliminar (0-indexed, rango [0, size-1])
     * @return el nombre del huésped eliminado
     * @throws IndexOutOfBoundsException si la posición está fuera del rango válido
     */
    public String eliminarEnPosicion(int posicion) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un nuevo nodo al final de la lista (justo antes del trailer).
     *
     * @param nombreHuesped nombre del huésped
     * @param numHabitacion número de habitación
     */
    public void insertarAlFinal(String nombreHuesped, int numHabitacion) {
        NodoReserva current = this.header;
        while (current.getNext() != this.trailer) {
            current = current.getNext();
        }
        NodoReserva nuevo = new NodoReserva(nombreHuesped, numHabitacion, this.trailer);
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
    public NodoReserva getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.size + ")"
            );
        }

        NodoReserva current = this.header.getNext();
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Devuelve una representación en texto de la lista (sin centinelas).
     * Ejemplo: "[Ana, 101] → [Luis, 205] → [Marta, 312]"
     *
     * @return representación textual de la lista
     */
    @Override
    public String toString() {
        if (this.size == 0) {
            return "(vacía)";
        }

        StringBuilder sb = new StringBuilder();
        NodoReserva current = this.header.getNext();

        while (current != this.trailer) {
            if (sb.length() > 0) {
                sb.append(" → ");
            }
            sb.append("[")
              .append(current.getNombreHuesped())
              .append(", ")
              .append(current.getNumHabitacion())
              .append("]");
            current = current.getNext();
        }

        return sb.toString();
    }
}
