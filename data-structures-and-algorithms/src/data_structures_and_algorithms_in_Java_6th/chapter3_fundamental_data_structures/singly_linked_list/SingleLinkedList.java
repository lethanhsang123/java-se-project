package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.singly_linked_list;

public class SingleLinkedList<E> {

    // Instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SingleLinkedList() {}

    // Access methods
    public int size() {return size; }

    public boolean isEmpty() { return size == 0; }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size ++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size --;
        if (size == 0) tail = null;
        return answer;
    }


    // Nested node
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {return element;}

        public Node<E> getNext() {return next;};

        public void setNext(Node<E> n) { next = n; }
    }
}
