package com.aedi.ejercicios.circularLinkedDummy;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Mover nodo a primera posición en lista circular con centinela
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Dada la siguiente estructura enlazada circular con nodo centinela
 * CircularLinkedDummy y referencia a dicho nodo (Node last),
 *
 * se pide implementar el método moveUpPositions(int n) que se especifica
 * a continuación, donde n es un entero positivo.
 *
 * ESTRUCTURA VISUAL (circular con centinela):
 *
 *                          ┌──────────────────────────────────┐
 *                          ↓                                  │
 *   ... → [A] → [B] → [C] → [last/centinela] ───────────────→┘
 *          ↑                                                  │
 *          └──────────────────────────────────────────────────┘
 *
 * Se supone que el nodo siguiente a last ocupa la posición 1.
 *
 * Produce: Si la estructura está vacía, n == 1 o no existe la posición n
 * en la estructura (por ejemplo, si n = 5 y solo hay 4 nodos), retorna false;
 * en otro caso, elimina el nodo de la posición n y lo coloca de primero
 * en la estructura, devolviendo true.
 *
 * EJEMPLOS:
 * ┌───────────────────────────────────────────┬────────────────────────┬──────────────────────────────────────────┬──────────┐
 * │ Estado (posiciones)                        │ Llamada                │ Resultado                                │ Retorna  │
 * ├───────────────────────────────────────────┼────────────────────────┼──────────────────────────────────────────┼──────────┤
 * │ pos1=[5] pos2=[3] pos3=[8] pos4=[1]       │ moveUpPositions(3)     │ pos1=[8] pos2=[5] pos3=[3] pos4=[1]      │ true     │
 * │ pos1=[5] pos2=[3] pos3=[8]                │ moveUpPositions(1)     │ (sin cambios)                            │ false    │
 * │ pos1=[5] pos2=[3]                         │ moveUpPositions(5)     │ (sin cambios)                            │ false    │
 * │ (vacía)                                   │ moveUpPositions(1)     │ (sin cambios)                            │ false    │
 * └───────────────────────────────────────────┴────────────────────────┴──────────────────────────────────────────┴──────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class CircularLinkedDummy {

    private Node last; // Nodo centinela (último nodo de la estructura circular)
    private int numberOfValues;

    /**
     * Constructor: crea una lista circular vacía con nodo centinela.
     * El centinela apunta a sí mismo.
     *
     * Estado inicial: last → last (circular vacía)
     */
    public CircularLinkedDummy() {
        this.last = new Node(null);
        this.last.setNext(this.last); // Circular: apunta a sí mismo
        this.numberOfValues = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public Node getLast() {
        return this.last;
    }

    public int getNumberOfValues() {
        return this.numberOfValues;
    }

    // ── Método a implementar ───────────────────────────────────────────

    /**
     * Si la estructura está vacía, n == 1 o no existe la posición n,
     * retorna false. En otro caso, elimina el nodo de la posición n y
     * lo coloca de primero en la estructura, devolviendo true.
     *
     * Se supone que el nodo siguiente a last ocupa la posición 1.
     *
     * @param n posición del nodo a mover (1-indexed)
     * @return true si se realizó la operación, false en caso contrario
     */
    public boolean moveUpPositions(int n) {
        if (this.numberOfValues == 0 || n == 1 || (n > this.numberOfValues)) return false;

        Node current = this.last;

        for (int i = 0; i < n -1; i++) {
            current = current.getNext();
        }
        Node target = current.getNext();
        current.setNext(current.getNext().getNext());
        target.setNext(this.last.getNext());
        this.last.setNext(target);
        return true;
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un valor al final de la lista circular (justo antes del centinela).
     */
    public void insertarAlFinal(int element) {
        // El nodo anterior a last es el último dato
        Node current = this.last;
        // Recorrer hasta llegar al nodo justo antes de last
        while (current.getNext() != this.last) {
            current = current.getNext();
        }
        Node nuevo = new Node(element, this.last);
        current.setNext(nuevo);
        this.numberOfValues++;
    }

    /**
     * Devuelve el nodo de datos en la posición indicada (1-indexed).
     * La posición 1 es el nodo siguiente a last.
     */
    public Node getNodoEnPosicion(int posicion) {
        if (posicion < 1 || posicion > this.numberOfValues) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.numberOfValues + ")"
            );
        }
        Node current = this.last.getNext(); // posición 1
        for (int i = 1; i < posicion; i++) {
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
        Node current = this.last.getNext(); // posición 1
        for (int i = 0; i < this.numberOfValues; i++) {
            if (sb.length() > 0) sb.append(" → ");
            sb.append("[").append(current.getElement()).append("]");
            current = current.getNext();
        }
        return sb.toString();
    }
}
