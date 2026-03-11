package com.aedi.ejercicios.reverseList.sinResolver;

/**
 * Nodo de una lista doblemente enlazada que almacena un entero.
 */
public class DoubleNode {

    private int element;
    private DoubleNode prev;
    private DoubleNode next;

    public DoubleNode(int element, DoubleNode prev, DoubleNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /** Constructor para nodo centinela. */
    public DoubleNode(DoubleNode prev, DoubleNode next) {
        this(0, prev, next);
    }

    public int getElement() {
        return this.element;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public DoubleNode getPrev() {
        return this.prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}
