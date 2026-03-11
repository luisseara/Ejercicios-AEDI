package com.aedi.ejercicios.linkedSimple;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Mover el mínimo al final de una lista enlazada simple
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Se tiene una estructura enlazada simple que almacena números enteros y que
 * dispone de una única referencia externa (Node first).
 *
 * Se pide implementar el método moveMinToEnd() que localiza el nodo que
 * contiene el valor mínimo de la estructura, lo elimina de su posición actual
 * y lo inserta al final de la estructura.
 *
 * ESTRUCTURA VISUAL:
 *
 *   first → [3] → [1] → [7] → null
 *
 * Produce: Si la estructura está vacía o contiene un único nodo, devuelve
 * false. En otro caso, localiza el nodo que contiene el valor mínimo de la
 * estructura, lo elimina de su posición actual y lo inserta al final de la
 * lista. Devuelve true si la operación se realiza o si el mínimo ya está
 * al final.
 *
 * EJEMPLOS:
 * ┌──────────────────────────────┬──────────────────────────────────┬──────────┐
 * │ Estado inicial                │ Resultado tras moveMinToEnd()    │ Retorna  │
 * ├──────────────────────────────┼──────────────────────────────────┼──────────┤
 * │ [3] → [1] → [7] → null      │ [3] → [7] → [1] → null          │ true     │
 * │ [5] → [2] → [8] → [1] → null│ [5] → [2] → [8] → [1] → null   │ true     │
 * │ (min=1 ya está al final)     │ (sin cambios)                    │          │
 * │ [9] → [4] → [6] → null      │ [9] → [6] → [4] → null          │ true     │
 * │ [5] → null (un solo nodo)   │ (sin cambios)                    │ false    │
 * │ null (vacía)                 │ (sin cambios)                    │ false    │
 * └──────────────────────────────┴──────────────────────────────────┴──────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class LinkedSimple {

    private Node first; // Referencia al primer nodo (null si vacía)
    private int numberOfValues;

    /**
     * Constructor: crea una lista vacía.
     *
     * Estado inicial: first → null
     */
    public LinkedSimple() {
        this.first = null;
        this.numberOfValues = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public Node getFirst() {
        return this.first;
    }

    public int getNumberOfValues() {
        return this.numberOfValues;
    }

    // ── Método a implementar ───────────────────────────────────────────

    /**
     * Si la estructura está vacía o contiene un único nodo, devuelve false.
     * En otro caso, localiza el nodo con el valor mínimo, lo elimina de
     * su posición actual y lo inserta al final de la lista.
     * Devuelve true si la operación se realiza o si el mínimo ya está al final.
     *
     * @return true si la operación se realizó o el mínimo ya estaba al final,
     *         false si la lista está vacía o tiene un solo elemento
     */
    public boolean moveMinToEnd() {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un valor al final de la lista.
     */
    public void insertarAlFinal(int element) {
        Node nuevo = new Node(element, null);
        if (this.first == null) {
            this.first = nuevo;
        } else {
            Node current = this.first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nuevo);
        }
        this.numberOfValues++;
    }

    /**
     * Devuelve el nodo en la posición indicada (0-indexed).
     */
    public Node getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.numberOfValues) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.numberOfValues + ")"
            );
        }
        Node current = this.first;
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        if (this.numberOfValues == 0) {
            return "(vacía)";
        }
        StringBuilder sb = new StringBuilder();
        Node current = this.first;
        while (current != null) {
            if (sb.length() > 0) sb.append(" → ");
            sb.append("[").append(current.getElement()).append("]");
            current = current.getNext();
        }
        return sb.toString();
    }
}
