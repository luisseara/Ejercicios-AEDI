package com.aedi.ejercicios.reverseList;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Invertir un subsegmento en una lista doblemente enlazada
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Dada una lista doblemente enlazada con nodos centinela al principio y
 * al final ReverseList que tiene dos referencias, first y last, a dichos
 * nodos centinela:
 *
 * ESTRUCTURA VISUAL:
 *
 *   first(centinela) ↔ [A] ↔ [B] ↔ [C] ↔ [D] ↔ [E] ↔ last(centinela)
 *
 * Implementa el método reverseBetween que se especifica a continuación:
 *
 * public void reverseBetween(int startPos, int endPos)
 *   // Modifica: this
 *   // Produce: Invierte el orden de los nodos entre las posiciones
 *   // "startPos" y "endPos" (1-indexadas). Si las posiciones son
 *   // inválidas, no modifica la lista. Debe funcionar para cualquier
 *   // subsegmento (incluyendo el primero o el último nodo).
 *
 * EJEMPLOS:
 * ┌──────────────────────────────┬────────────────────────────┬──────────────────────────────┐
 * │ Estado inicial                │ Llamada                    │ Resultado                    │
 * ├──────────────────────────────┼────────────────────────────┼──────────────────────────────┤
 * │ [A] ↔ [B] ↔ [C] ↔ [D] ↔ [E]│ reverseBetween(2, 4)       │ [A] ↔ [D] ↔ [C] ↔ [B] ↔ [E]│
 * │ [A] ↔ [B] ↔ [C] ↔ [D] ↔ [E]│ reverseBetween(1, 5)       │ [E] ↔ [D] ↔ [C] ↔ [B] ↔ [A]│
 * │ [A] ↔ [B] ↔ [C] ↔ [D] ↔ [E]│ reverseBetween(1, 3)       │ [C] ↔ [B] ↔ [A] ↔ [D] ↔ [E]│
 * │ [A] ↔ [B] ↔ [C] ↔ [D] ↔ [E]│ reverseBetween(3, 5)       │ [A] ↔ [B] ↔ [E] ↔ [D] ↔ [C]│
 * │ [A] ↔ [B] ↔ [C]             │ reverseBetween(2, 2)       │ [A] ↔ [B] ↔ [C] (sin cambio)│
 * │ [A] ↔ [B] ↔ [C]             │ reverseBetween(0, 2)       │ (sin cambio, pos inválida)   │
 * │ [A] ↔ [B] ↔ [C]             │ reverseBetween(2, 5)       │ (sin cambio, pos inválida)   │
 * │ [A] ↔ [B] ↔ [C]             │ reverseBetween(3, 1)       │ (sin cambio, start > end)    │
 * └──────────────────────────────┴────────────────────────────┴──────────────────────────────┘
 *
 * NOTA: Los valores A=1, B=2, C=3, D=4, E=5 se usan en los tests como
 * enteros. En la tabla se muestran como letras para mayor claridad.
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class ReverseList {

    private DoubleNode first; // Nodo centinela al principio
    private DoubleNode last;  // Nodo centinela al final
    private int numberOfValues;

    /**
     * Constructor: crea una lista vacía con los dos nodos centinela enlazados.
     *
     * Estado inicial: first(centinela) ↔ last(centinela)
     */
    public ReverseList() {
        this.first = new DoubleNode(null, null);
        this.last = new DoubleNode(this.first, null);
        this.first.setNext(this.last);
        this.numberOfValues = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public DoubleNode getFirst() {
        return this.first;
    }

    public DoubleNode getLast() {
        return this.last;
    }

    public int getNumberOfValues() {
        return this.numberOfValues;
    }

    // ── Método a implementar ───────────────────────────────────────────

    /**
     * Invierte el orden de los nodos entre las posiciones startPos y endPos
     * (1-indexadas). Si las posiciones son inválidas (fuera de rango,
     * startPos > endPos, etc.), no modifica la lista.
     *
     * @param startPos posición inicial del rango a invertir (1-indexed)
     * @param endPos   posición final del rango a invertir (1-indexed)
     */
    public void reverseBetween(int startPos, int endPos) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un valor al final de la lista (justo antes del centinela last).
     */
    public void insertarAlFinal(int element) {
        DoubleNode anterior = this.last.getPrev();
        DoubleNode nuevo = new DoubleNode(element, anterior, this.last);
        anterior.setNext(nuevo);
        this.last.setPrev(nuevo);
        this.numberOfValues++;
    }

    /**
     * Devuelve el nodo de datos en la posición indicada (1-indexed).
     */
    public DoubleNode getNodoEnPosicion(int posicion) {
        if (posicion < 1 || posicion > this.numberOfValues) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.numberOfValues + ")"
            );
        }
        DoubleNode current = this.first.getNext();
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
        DoubleNode current = this.first.getNext();
        while (current != this.last) {
            if (sb.length() > 0) sb.append(" ↔ ");
            sb.append("[").append(current.getElement()).append("]");
            current = current.getNext();
        }
        return sb.toString();
    }
}
