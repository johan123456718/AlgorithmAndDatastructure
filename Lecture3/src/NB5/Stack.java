/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB5;

import java.util.EmptyStackException;

/**
 *
 * @author Johan C
 */
public class Stack<E> implements StackInt<E>{
    
    private E[] data;
    private int top;
    private int maxSize;
    
    public Stack(){
        maxSize = 10;
        top = -1;
        data = (E[]) new Object[maxSize];
    }
    
    public Stack(int maxSize){
        this.maxSize = maxSize;
        top = -1;
        data = (E[]) new Object[maxSize];
    }
    
    @Override
    public E push(E obj) {    
        top++;
        data[top] = obj;
        return obj;
    }

    @Override
    public E peek() {
        if(empty()){
            throw new EmptyStackException(); 
        }else{
            return data[top];
        }
    }

    @Override
    public E pop() {
        if(empty()){
            throw new EmptyStackException(); 
        }else{
            E value = data[top];
            top--;
            return value;
        }
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
    
}
