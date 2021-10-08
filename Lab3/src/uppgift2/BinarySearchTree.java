/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift2;

/**
 *
 * @author user
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private E deletedData;

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    private Node<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<E>(data);
                return true;
            } else {
                return add(data, node.right);
            }
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    /*private E find(E target, Node<E> current) {
        if (current == null) {
            return null;
        }
        if (target.compareTo(current.data) == 0) {
            return current.data;
        }
        if (target.compareTo(current.data) < 0) {
            return find(target, current.left);
        }
        return find(target, current.right);
    }

    public E find(E target) {
        return find(target, root);
    }*/
    public E find(E key) {
        Node<E> current = root;
        while (current != null) {
            int result = key.compareTo(current.data);
            if (result < 0) {
                current = current.left;
            } else if (result > 0) {
                current = current.right;
            } else {
                return current.data;
            }
        }
        return null;
    }

    public E maxIt() {
        Node<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public E maxRec() { //wrapper
        if (root == null) {
            return null;
        }
        return maxRec(root);
    }

    private E maxRec(Node<E> node) {
        if (node.right == null) {
            return node.data;
        }
        return maxRec(node.right);

    }

    private Node<E> delete(E target, Node<E> node) {
        if (node == null) { //finns ej
            deletedData = null;
            return null;
        } else {
            if (target.compareTo(node.data) < 0) {
                node.left = delete(target, node.left);
                return node;
            } else if (target.compareTo(node.data) > 0) {
                node.right = delete(target, node.right);
                return node;
            } else {
                deletedData = node.data; // lagrar data att returnera
                if (node.left == null) { //noden som ska bort saknar vänster träd.
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {  //noden vi ska ta bort har två barn
                    Node<E> nodeToMove = node.right, parentNodeToMove = node;
                    if (nodeToMove.left == null) {
                        nodeToMove.left = node.left;
                        return nodeToMove;
                    }

                    while (nodeToMove.left != null) {
                        parentNodeToMove = nodeToMove;
                        nodeToMove = nodeToMove.left;
                    }
                    parentNodeToMove.left = nodeToMove.right;
                    node.data = nodeToMove.data;
                    return node;
                }
            }
        }
    }

    public E getRoot() {
        return root.data;
    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }
}
