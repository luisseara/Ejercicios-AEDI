package com.aedi.ejercicios.orderedList.sinResolver;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Inserción limitada en lista ordenada ascendentemente
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Dada una estructura enlazada de modo simple OrderedList de números enteros
 * ordenados ascendentemente, que permite un número limitado de repeticiones
 * de cada valor:
 *
 * ESTRUCTURA VISUAL:
 *
 *   first → [7] → [8] → [8] → [23] → null
 *
 * Implementa el método addLimited de la clase OrderedList.
 *
 * public boolean addLimited(int number, int maxDuplicates)
 *   // Modifica: this
 *   // Produce: Si maxDuplicates <= 0 retorna false; Si el número "number"
 *   // aparece menos de "maxDuplicates" veces en la estructura, lo inserta
 *   // manteniendo el orden y devuelve "true". Si ya aparece "maxDuplicates"
 *   // o más veces, no modifica la estructura y devuelve "false".
 *   // La estructura debe conservar siempre el orden ascendente y respetar
 *   // el límite máximo de ocurrencias indicado.
 *
 * EJEMPLOS:
 * ┌─────────────────────────────────┬───────────────────────────┬───────────────────────────────────────┬──────────┐
 * │ Estado inicial                   │ Llamada                   │ Estado resultante                     │ Retorna  │
 * ├─────────────────────────────────┼───────────────────────────┼───────────────────────────────────────┼──────────┤
 * │ [7] → [8] → [8] → [23] → null  │ addLimited(8, 3)          │ [7] → [8] → [8] → [8] → [23] → null │ true     │
 * │ [7] → [8] → [8] → [23] → null  │ addLimited(8, 2)          │ (sin cambios)                         │ false    │
 * │ [7] → [8] → [8] → [23] → null  │ addLimited(8, 1)          │ (sin cambios)                         │ false    │
 * │ [7] → [8] → [8] → [23] → null  │ addLimited(10, 2)         │ [7] → [8] → [8] → [10] → [23] → null│ true     │
 * │ [7] → [23] → null              │ addLimited(5, 1)          │ [5] → [7] → [23] → null              │ true     │
 * │ null (vacía)                    │ addLimited(5, 1)          │ [5] → null                            │ true     │
 * │ [7] → [23] → null              │ addLimited(5, 0)          │ (sin cambios)                         │ false    │
 * │ [7] → [23] → null              │ addLimited(5, -1)         │ (sin cambios)                         │ false    │
 * └─────────────────────────────────┴───────────────────────────┴───────────────────────────────────────┴──────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class OrderedList {

    private Node first; // Referencia al primer nodo de datos (null si vacía)
    private int numberOfValues;

    /**
     * Constructor: crea una lista ordenada vacía.
     *
     * Estado inicial: first → null
     */
    public OrderedList() {
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
     * Si maxDuplicates <= 0, retorna false. Si el número "number" aparece
     * menos de "maxDuplicates" veces en la estructura, lo inserta manteniendo
     * el orden ascendente y devuelve true. Si ya aparece "maxDuplicates" o
     * más veces, no modifica la estructura y devuelve false.
     *
     * @param number        número a insertar
     * @param maxDuplicates número máximo de veces que puede aparecer el valor
     * @return true si se insertó, false en caso contrario
     */
    public boolean addLimited(int number, int maxDuplicates) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Inserta un valor manteniendo el orden ascendente (sin límite de duplicados).
     * Método auxiliar para construir listas en los tests.
     */
    public void insertarOrdenado(int element) {
        if (this.first == null || element <= this.first.getElement()) {
            this.first = new Node(element, this.first);
        } else {
            Node current = this.first;
            while (current.getNext() != null && current.getNext().getElement() < element) {
                current = current.getNext();
            }
            current.setNext(new Node(element, current.getNext()));
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
