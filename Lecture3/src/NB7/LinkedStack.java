/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7;

import java.util.EmptyStackException;

/**
 *
 * @author Johan C
 */
public class LinkedStack<E> implements StackInt<E> {
    
    private class Node<E>{
        private Node<E> next;
        private E data;
        
        public Node(Node<E> next, E value){
            this.next = next;
            this.data = value;
        }
        
        @Override
        public String toString(){
            return this.next + " " + this.data;
        }
    }
    
    private Node<E> top;
    
    public LinkedStack(){
        this.top = null;
    }

    @Override
    public E push(E obj) {
        top = new Node<E>(top, obj);
        return obj;
    }

    @Override
    public E peek() {
        if(empty()){
            throw new EmptyStackException();
        }else{
            return top.data;
        }
    }

    @Override
    public E pop() {
        if(empty()){
            throw new EmptyStackException();
        }else{
            E value = top.data;
            top = top.next;
            return value;
        }
    }
    
    public int size(){
        int counter = 0;
        Node<E> node = top;
        
        while(node != null){
            counter++;
            node = node.next;
        }
        return counter;
    }
    
    public E peek(int index){
        Node<E> node = getNode(index);
        return node.data;
    }
    
    public E flush(){
        E value = null;
        
        while(!empty()){
            value = pop();
        }
        return value;
    }
    
    private Node<E> getNode(int index){
        Node<E> node = top;
        for(int i = 0; i < index && node != null; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public boolean empty() {
        
        return top == null;
    }
    
}
