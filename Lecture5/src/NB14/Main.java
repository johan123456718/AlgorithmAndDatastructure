/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB14;

import java.util.Scanner;

/**
 *
 * @author Johan C
 * Coinmachine task
 * Takes a point and calculates the minimum amount 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What point should be achieved: ");
        int goal = scan.nextInt();
        System.out.println(coinMachine(goal));
    }
    
    public static int coinMachine(int goal){
        return coinMachine(goal, 1);
    }
    
    private static int coinMachine(int goal, int start){        
        if(start > goal){
            return -1;
        }else if(start == goal){
            return 0;
        }else{

            int addFive = coinMachine(goal, start + 4);
            int addTen =  coinMachine(goal, start * 3);
            
            if(addFive == -1 && addTen == -1){
                return -1;
                
            }else if(addFive == -1){
               
                return 10 + addTen;
                
            }else if(addTen == -1){
                
                return 5 + addFive;
                
            }else{
                
                return Math.min(5 + addFive, 10 + addTen);
            }
        }
        
    }
    
}
