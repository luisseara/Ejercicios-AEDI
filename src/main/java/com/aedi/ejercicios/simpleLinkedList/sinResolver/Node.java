package com.aedi.ejercicios.simpleLinkedList.sinResolver;

/**
 * Nodo de una lista enlazada simple que almacena un entero.
 */
public class Node {

    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    /** Constructor para nodo centinela. */
    public Node(Node next) {
        this(0, next);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean hasValue(int value) {
        return getValue() == value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
