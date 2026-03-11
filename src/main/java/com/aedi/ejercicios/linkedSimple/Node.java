package com.aedi.ejercicios.linkedSimple;

/**
 * Nodo de una lista enlazada simple que almacena un entero.
 */
public class Node {

    private int element;
    private Node next;

    public Node(int element, Node next) {
        this.element = element;
        this.next = next;
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
