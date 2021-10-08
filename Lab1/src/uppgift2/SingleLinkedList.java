package uppgift2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Johan Challita
 */
public class SingleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
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
    public SingleLinkedList() { //Tom enkelriktad lista
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * add a node at the last position
     * @param item
     * @return 
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     * add a node with a item in a given index
     * @param index
     * @param item 
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size && size > 0) {
            addLast(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
        if (size == 1) {
            createTail();
        }
    }

    /**
     * A help method to create tail
     */
    private void createTail() {
        tail = getNode(size - 1);
    }

    /**
     * A help method to add a element at the first node
     * @param item 
     */
    private void addFirst(E item) {
        this.head = new Node<E>(item, head);
        size++;
    }

    /**
     * Gets a node
     * @param index
     * @return 
     */
    public Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Adds a item in the last node
     * @param item 
     */
    private void addLast(E item) {
        if (head == null) {
            head = tail = null;
        } else {
            Node<E> node = new Node<E>(item, null);
            tail.next = node;
            tail = node;
            size++;
        }
    }
    
    /**
     * Adds a item after the head
     * @param node
     * @param item 
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }

    /**
     * Gets the node's data
     * @param index
     * @return 
     */
    public E getData(int index) {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * Removes a node
     * @param index 
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size && size > 0) {
            removeLast();
        } else {
            Node<E> node = getNode(index - 1);
            removeAfter(node);
        }
    }
    /**
     * Removes the header node
     */
    private void removeFirst() {
        if (head == null) {
            throw new NullPointerException("Nothing to remove. The list is empty");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                size--;
            }
        }
    }
    /**
     * Removes the tail
     */
    private void removeLast() {
        if (tail == null) {
            throw new NullPointerException("Can't remove a null node");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node<E> previousTail = head;
                //System.out.println(previousTail.data);
                
                while (previousTail.next != tail) {
                    previousTail = previousTail.next;
                    //System.out.println(previousTail.data);
                }
                tail = previousTail;
                tail.next = null;
                size--;
            }
        }
    }
    
    /**
     * Removes a node in the middle of the list
     * @param previousTail 
     */
    private void removeAfter(Node<E> previousTail) {
        if (previousTail == null) {
            removeFirst();
        } else if (previousTail.next == tail) {
            tail = previousTail;
            tail.next = null;
        } else {
            previousTail.next = previousTail.next.next;
        }
        size--;
    }

    /**
     * Gets the current list size
     * @return 
     */
    public int getSize() {
        return size;
    }

    /**
     * Clears the list
     */
    public void clear() {
        head = null;
    }

    /**
     * Gets the head
     * @return 
     */
    public E getHead() {
        return head.data;
    }

    /**
     * Gets the tail
     * @return 
     */
    public E getTail() {
        return tail.data;
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

    private class Itr implements Iterator<E> {

        Node<E> current;

        public Itr(Node<E> start) {
            this.current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }
}
