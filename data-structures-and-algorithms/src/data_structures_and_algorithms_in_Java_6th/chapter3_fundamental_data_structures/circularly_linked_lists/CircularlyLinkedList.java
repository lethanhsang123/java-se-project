package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.circularly_linked_lists;

public class CircularlyLinkedList<E> {

    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList() {}

    // Access methods
    public int size() {return size;}

    public boolean isEmpty() {return size == 0;}

    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Update methods

    /**
     * adds element e to the front of the list
     * @param e
     */
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size ++;
    }

    /**
     *  Rotate the first element to the back of the list
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /**
     * adds element e to the end of the list
     * @param e
     */
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();
        if (head == tail) tail = null;
        else tail.setNext(head.getNext());
        size --;
        return head.getElement();
    }



    // Nested node
    private static class Node<E> {
        private E element;
        private CircularlyLinkedList.Node<E> next;

        public Node(E e, CircularlyLinkedList.Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {return element;}

        public CircularlyLinkedList.Node<E> getNext() {return next;};

        public void setNext(CircularlyLinkedList.Node<E> n) { next = n; }
    }
}
