/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB7;

/**
 *
 * @author Johan C
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         LinkedStack<Integer> stack = new LinkedStack();
        
        for(int i = 0; i < 10; i++){
            stack.push(i + 1);
        }
        
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek(3));
        System.out.println(stack.flush());
        System.out.println(stack.empty());
        
    }
    
}
