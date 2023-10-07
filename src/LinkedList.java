/**
 * LinkedList implementation
 * @param <T> the type we want
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
     * @param id of the object
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

    /**
     * Returns the linkedList size
     * 
     * @return the size of the list
     */
    public int size() {
        int size = 0;

        Node<Seminar> current = head;

        while (current != null) {
            current = current.next;
            size++;
        }

        return size;
    }

    /**
     * Remove a certain object
     * 
     * @param object the object to remove
     * @param id the obj id to delete
     */
    public void remove(int id) {
        if (head == null) {
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

    /**
     * The toString for the list
     * 
     * @return the list of ids
     */
    public String toLinkedString() {
        String ret = "";

        Node<Seminar> current = head;

        while (current != null) {
            ret += current.id + " ";
            current = current.next;
        }
        ret = ret.substring(0, ret.length() - 1);

        return ret;
    } 

    /**
     * The toArray for the linked list
     *  
     * @return returns an array of seminars
     */
    public Seminar[] toSemArray() {
        Seminar[] retArray = new Seminar[size()];

        Node<Seminar> current = head;
        int counter = 0;
        while (current != null) {
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
