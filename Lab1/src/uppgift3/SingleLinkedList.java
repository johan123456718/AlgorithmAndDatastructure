package uppgift3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Johan Challita
 */
public class SingleLinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> { //inre klass för att visa hur den ska se ut

        private E data;
        private Node<E> next;

        /**
         * Node constructor
         * @param data
         * @param next 
         */
        public Node(E data, Node<E> next) { //Skapa en nod
            this.data = data;
            this.next = next;
        }
    }
    
    /**
     * A constructor for initializing the list
     */
    public SingleLinkedList() { 
        this.head = null;
        this.size = 0;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private void addFirst(E item) {
        this.head = new Node<E>(item, head);
        size++;
    }

    public Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }
    
    public void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public int getSize(){
        return size;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append("==>");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * A iterator that can check the list and remove
     */
    private class Itr implements Iterator<E> {

        private Node<E> current;
        private Node<E> previous;
        private Node<E> previous2;
        private boolean removeAllowed;
        
        public Itr(Node<E> start) {
            this.current = start;   //current = head
            this.previous = null;
            this.previous2 = null;
            this.removeAllowed = false;
        }

        /**
         * A checker if the current has reached the end of the tail.
         * @return 
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Gets the next node
         * @return 
         */
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            previous2 = previous;
            previous = current;
            current = current.next;
            removeAllowed = true;
            return returnValue;
        }

        
        /**
         * Removes a node and sorts the list
         */
        @Override
        public void remove() {
            if(previous == null || removeAllowed == false){
                throw new IllegalStateException();
            }
            if(previous2 == null){
                head = current;
                previous = null;
            }else{
                previous2.next = current;
                previous = previous2;
            }
            size--;
            removeAllowed = false;
        }
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }
}
