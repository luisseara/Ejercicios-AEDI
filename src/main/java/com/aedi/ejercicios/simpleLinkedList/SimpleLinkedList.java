package com.aedi.ejercicios.simpleLinkedList;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Reposicionar un elemento en una lista enlazada con centinela
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Dada una estructura enlazada de modo simple CON centinela SimpleLinkedList
 * y referencia a dicho nodo (Node first) que almacena números enteros, se pide
 * implementar el método reposition(int x, int y).
 *
 * Dicho método recibe dos enteros x e y como parámetros y quitará el entero x
 * de su posición y lo colocará justo a continuación del entero y. Para ello,
 * NO se podrán crear nuevos nodos, sino modificar los enlaces ya existentes.
 *
 * Se puede suponer que los enteros x e y están en la estructura y que sólo
 * existe una ocurrencia de cada uno de ellos.
 *
 * ESTRUCTURA VISUAL (con centinela):
 *
 *   first(centinela) → [3] → [7] → [1] → [9] → null
 *
 * EJEMPLO:
 *   Lista: first → [3] → [7] → [1] → [9] → null
 *   reposition(7, 9)
 *   Resultado: first → [3] → [1] → [9] → [7] → null
 *   (Se quita el 7 de su posición y se coloca después del 9)
 *
 * EJEMPLO:
 *   Lista: first → [3] → [7] → [1] → [9] → null
 *   reposition(3, 1)
 *   Resultado: first → [7] → [1] → [3] → [9] → null
 *   (Se quita el 3 y se coloca después del 1)
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class SimpleLinkedList {

    private Node first; // Nodo centinela
    private int numberOfValues;

    /**
     * Constructor: crea una lista vacía con nodo centinela.
     *
     * Estado inicial: first(centinela) → null
     */
    public SimpleLinkedList() {
        this.first = new Node(null);
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
     * Quita el nodo que contiene el valor x de su posición actual y lo
     * coloca justo a continuación del nodo que contiene el valor y.
     *
     * NO se pueden crear nuevos nodos. Solo se modifican los enlaces.
     * Se asume que x e y existen en la lista y que son valores únicos.
     *
     * @param x valor del nodo a mover
     * @param y valor del nodo tras el cual se colocará x
     */
    public void reposition(int x, int y) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un valor al final de la lista.
     */
    public void insertarAlFinal(int element) {
        Node current = this.first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(element, null));
        this.numberOfValues++;
    }

    /**
     * Devuelve el nodo de datos en la posición indicada (0-indexed, sin contar centinela).
     */
    public Node getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.numberOfValues) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.numberOfValues + ")"
            );
        }
        Node current = this.first.getNext();
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
        Node current = this.first.getNext();
        while (current != null) {
            if (sb.length() > 0) sb.append(" → ");
            sb.append("[").append(current.getElement()).append("]");
            current = current.getNext();
        }
        return sb.toString();
    }
}
