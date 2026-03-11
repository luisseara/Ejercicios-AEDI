package com.aedi.ejercicios.colaPedidos.sinResolver;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * EJERCICIO: Inserción en posición en una lista enlazada con nodos centinela
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * CONTEXTO:
 * Una cadena de tiendas de electrónica gestiona la cola de pedidos pendientes
 * de cada sucursal mediante una estructura enlazada simple. Cada pedido se
 * representa como un nodo que almacena un código de pedido (String) y una
 * prioridad (int, donde 1 es la más alta).
 *
 * La lista utiliza dos nodos centinela (nodos de control):
 *   - Un nodo cabecera (header) al principio, que no contiene datos válidos
 *     y cuyo enlace next apunta al primer nodo real (o al trailer si está vacía).
 *   - Un nodo cola (trailer) al final, que no contiene datos válidos y al que
 *     apunta el último nodo real de la lista.
 *
 * ESTRUCTURA VISUAL (con 3 pedidos):
 *
 *   [header] → [PED-001, 3] → [PED-002, 1] → [PED-003, 2] → [trailer]
 *
 * ─────────────────────────────────────────────────────────────────────────
 *
 * SE PIDE:
 * Implementar el método insertarEnPosicion(String codigoPedido, int prioridad,
 * int posicion) que inserte un nuevo nodo con los datos proporcionados en la
 * posición indicada (indexada desde 0), desplazando todos los nodos que se
 * encuentren en esa posición y posteriores una posición hacia adelante.
 *
 * REGLAS:
 * 1. POSICIONES VÁLIDAS: La posición debe estar en el rango [0, size].
 *    - Si la posición es 0, el nuevo nodo se convierte en el primer elemento
 *      real (justo después del header).
 *    - Si la posición es igual a size, el nuevo nodo se inserta al final
 *      (justo antes del trailer).
 *
 * 2. POSICIÓN INVÁLIDA: Si la posición está fuera del rango válido, lanzar
 *    una excepción IndexOutOfBoundsException con el mensaje:
 *    "Posición inválida: X (tamaño actual: Y)"
 *
 * 3. ACTUALIZACIÓN DEL TAMAÑO: Tras una inserción exitosa, el atributo size
 *    debe incrementarse en 1.
 *
 * 4. NO se permite usar estructuras auxiliares (arrays, ArrayList, etc.).
 *    La inserción debe realizarse manipulando únicamente los enlaces next.
 *
 * EJEMPLOS:
 * ┌─────────────────────────────────────────────────────────┬───────────────────────────────────────┬─────────────────────────────────────────────────────────────────────┐
 * │ Estado inicial                                          │ Llamada                               │ Estado resultante                                                   │
 * ├─────────────────────────────────────────────────────────┼───────────────────────────────────────┼─────────────────────────────────────────────────────────────────────┤
 * │ [header] → [trailer] (vacía)                            │  insertarEnPosicion("PED-001", 3, 0)  │  [header] → [PED-001, 3] → [trailer]                                │
 * │ [header] → [PED-001, 3] → [PED-003, 2] → [trailer]      │   insertarEnPosicion("PED-002", 1, 1) │   [header] → [PED-001, 3] → [PED-002, 1] → [PED-003, 2] → [trailer] │
 * │ [header] → [A, 1] → [B, 2] → [C, 3] → [trailer]         │    insertarEnPosicion("D", 4, 3)      │    [header] → [A, 1] → [B, 2] → [C, 3] → [D, 4] → [trailer]         │
 * │ [header] → [A, 1] → [trailer]                           │ insertarEnPosicion("X", 5, 3)         │     Lanza IndexOutOfBoundsException                                 │
 * └─────────────────────────────────────────────────────────┴───────────────────────────────────────┴─────────────────────────────────────────────────────────────────────┘
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
public class ColaPedidos {

    private NodoPedido header;  // Nodo centinela inicial
    private NodoPedido trailer; // Nodo centinela final
    private int size;           // Número de elementos reales (sin contar centinelas)

    /**
     * Constructor: crea una cola vacía con los dos nodos centinela enlazados.
     *
     * Estado inicial: [header] → [trailer]
     */
    public ColaPedidos() {
        this.trailer = new NodoPedido(null);
        this.header = new NodoPedido(this.trailer);
        this.size = 0;
    }

    // ── Getters ────────────────────────────────────────────────────────

    public int getSize() {
        return this.size;
    }

    public NodoPedido getHeader() {
        return this.header;
    }

    public NodoPedido getTrailer() {
        return this.trailer;
    }

    // ── Método a implementar por el alumno ─────────────────────────────

    /**
     * Inserta un nuevo nodo con los datos proporcionados en la posición
     * indicada, desplazando los nodos existentes en esa posición y
     * posteriores una posición hacia adelante.
     *
     * @param codigoPedido código del nuevo pedido
     * @param prioridad    prioridad del nuevo pedido
     * @param posicion     posición donde insertar (0-indexed, rango [0, size])
     * @throws IndexOutOfBoundsException si la posición está fuera del rango válido
     */
    public void insertarEnPosicion(String codigoPedido, int prioridad, int posicion) {
        // TODO: Implementar este método
        throw new UnsupportedOperationException("Método no implementado");
    }

    // ── Métodos auxiliares (ya implementados) ──────────────────────────

    /**
     * Devuelve el nodo real en la posición indicada (sin contar centinelas).
     *
     * @param posicion índice del nodo (0-indexed)
     * @return el nodo en la posición dada
     * @throws IndexOutOfBoundsException si la posición no es válida
     */
    public NodoPedido getNodoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= this.size) {
            throw new IndexOutOfBoundsException(
                "Posición inválida: " + posicion + " (tamaño actual: " + this.size + ")"
            );
        }

        NodoPedido current = this.header.getNext();
        for (int i = 0; i < posicion; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Devuelve una representación en texto de la cola (sin centinelas).
     * Ejemplo: "[PED-001, 3] → [PED-002, 1] → [PED-003, 2]"
     *
     * @return representación textual de la cola
     */
    @Override
    public String toString() {
        if (this.size == 0) {
            return "(vacía)";
        }

        StringBuilder sb = new StringBuilder();
        NodoPedido current = this.header.getNext();

        while (current != this.trailer) {
            if (sb.length() > 0) {
                sb.append(" → ");
            }
            sb.append("[")
              .append(current.getCodigoPedido())
              .append(", ")
              .append(current.getPrioridad())
              .append("]");
            current = current.getNext();
        }

        return sb.toString();
    }
}
