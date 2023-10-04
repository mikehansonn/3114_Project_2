/**
 * LinkedList implementation
 * 
 * @author mikehanson
 * @version 10/4/23
 */
public class LinkedList<E> {
    private Node<E> head;

    /**
     * Linked List Constructor
     */
    public LinkedList() {
        head = null;
    }

    /**
     * Checks if it is empty
     * 
     * @return isempty or not
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add object to the end of the list
     * 
     * @param object new object to add
     */
    public void add(E object, int id) {
        Node<E> newNode = new Node<>(object, id);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Remove a certain object
     * 
     * @param object the object to remove
     */
    public void remove(E object, int id) {
        if(head == null) {
            return;
        }

        if (head.id() == id) {
            head = head.next;
            return;
        }

        Node<E> current = head;
        Node<E> prev = null;
        while (current != null && current.id() != id) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    public String toString() {
        String ret = "";

        Node<E> current = head;

        while(current != null) {
            ret += current.id() + "" ;
        }

        return ret;
    } 

    private static class Node<E> {
        private E data;
        private int id;
        private Node<E> next;

        public Node(E value, int id) {
            this.data = value;
            this.id = id;
        }

        public E data() {
            return data;
        }

        public int id() {
            return id;
        }

        public Node<E> next() {
            return next;
        }
    }    
}
