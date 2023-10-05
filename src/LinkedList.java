/**
 * LinkedList implementation
 * 
 * @author mikehanson
 * @version 10/4/23
 */
public class LinkedList<T> {
    private Node<Seminar> head;

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
    public void add(Seminar object, int id) {
        Node<Seminar> newNode = new Node<>(object, id);
        if (head == null) {
            head = newNode;
            return;
        }

        Node<Seminar> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Get the data to check coords
     * 
     * @return the data
     */
    public Seminar getData() {
        return head.data;
    }

    private int size() {
        int size = 0;

        Node<Seminar> current = head;

        while(current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    /**
     * Remove a certain object
     * 
     * @param object the object to remove
     */
    public void remove(Seminar object, int id) {
        if(head == null) {
            return;
        }

        if (head.id == id) {
            head = head.next;
            return;
        }

        Node<Seminar> current = head;
        Node<Seminar> prev = null;
        while (current != null && current.id != id) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
        }
    }

    public String toString() {
        String ret = "";

        Node<Seminar> current = head;

        while(current != null) {
            ret += current.id + " ";
            current = current.next;
        }
        ret = ret.substring(0, ret.length() - 1);

        return ret;
    } 

    public Seminar[] toSemArray() {
        Seminar[] retArray = new Seminar[size()];

        Node<Seminar> current = head;
        int counter = 0;
        while(current != null) {
            retArray[counter] = current.data;
            current = current.next;
            counter++;
        }

        return retArray;
    }

    private static class Node<E> {
        private E data;
        private int id;
        private Node<E> next;

        public Node(E value, int id) {
            this.data = value;
            this.id = id;
        }
    }    
}
