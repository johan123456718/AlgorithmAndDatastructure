/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB12;

import java.util.Scanner;

/**
 *
 * @author Johan C
 * Calculates the elevated number
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Pick a base: ");
        int base = scan.nextInt();
        System.out.print("\nPick a exponent: ");
        int exponent = scan.nextInt();
        System.out.println("Result in recursive: " + recEval(base, exponent));
        System.out.println("Result in iterative: " + itrEval(base, exponent));
    }
    
    public static int recEval(int base, int exponent){
        if(exponent == 0){
            return 1;
        }else{
            return base * recEval(base, exponent - 1);
        }
    }
    
    public static int itrEval(int base, int exponent){
        int result = 1;
        while(exponent != 0){
            result *= base;
            exponent--;
        }
        return result;
    }
    
}
