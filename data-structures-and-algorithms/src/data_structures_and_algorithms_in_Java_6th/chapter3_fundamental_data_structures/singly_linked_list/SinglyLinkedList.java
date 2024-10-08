package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.singly_linked_list;

public class SinglyLinkedList<E> implements Cloneable {

    // Instance variables of the SinglyLinkedList
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

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

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size != other.size) return false;
        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    @Override
    protected SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // Always use inherited Object.clone() to create the initial copy
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();    // safe cast
        if (size > 0) {     // We need independent chain of nodes
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();                          // Walk through remainder of original list
            Node<E> otherTail = other.head;                         // Remember most recently created node
            while (walk != null) {                                  // Make a new node storing same element
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);                          // Link previous node to this one
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
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
