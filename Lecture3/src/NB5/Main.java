/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB5;

/**
 *
 * @author Johan C
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < 10; i++){
            stack.push(i + 1);
        }
        
        System.out.println(stack.peek());
        while(!stack.empty()){
            System.out.println(stack.pop());
        }
        //System.out.println(stack.peek()); //should return EmptyStackException: True
        System.out.println("");
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
    
}
