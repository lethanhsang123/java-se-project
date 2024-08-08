package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.double_linked_lists;

/**
 * A basic doubly linked list implementation.
 * @param <E>
 */
public class DoublyLinkedList<E> {

    /**
     * Nested Node class
     * @param <E>
     */
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list

        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }

        public Node<E> getPrev() { return prev; }

        public Node<E> getNext() { return next; }

        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }

    }

    private Node<E> header; // header sentinel

    private Node<E> trailer;    // trailer sentinel

    private int size = 0;       // Number of elements in the list

    public DoublyLinkedList( ) {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, null, null);
        header.setNext(trailer);
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return header.getNext().element;
    }

    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().element;
    }

    // public update methods
    public void addFirst(E e) {
        addBetween(e, header, header.getNext( ));
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev( ), trailer);
    }

    public E removeFirst( ) {
        if (isEmpty( )) return null;
        return remove(header.getNext( ));
    }

    public E removeLast( ) {
        if (isEmpty( )) return null;
        return remove(trailer.getPrev( ));
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev( );
        Node<E> successor = node.getNext( );
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement( );
    }

}
