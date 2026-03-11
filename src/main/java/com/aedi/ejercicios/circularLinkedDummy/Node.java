package com.aedi.ejercicios.circularLinkedDummy;

/**
 * Nodo de una lista enlazada circular que almacena un entero.
 */
public class Node {

    private int element;
    private Node next;

    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
    }

    /** Constructor para nodo centinela. */
    public Node(Node next) {
        this(0, next);
    }

    public int getElement() {
        return this.element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
