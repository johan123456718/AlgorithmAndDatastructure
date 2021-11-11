/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB13;

/**
 *
 * @author Johan C
 * Calculates the rot of a number
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(rot(10, 1, 0.0001));
    }
    
    /**
     * 
     * @param n represents the number that we want to take square rot of
     * @param a represents the start
     * @param e represents the accuracy 
     * @return 
     */
    public static double rot(double n, double a, double e){
        
        if(n >= 1){
            if(Math.abs(Math.pow(a, 2) - n) < e){
                return a;
            }else{
                return rot(n, (Math.pow(a, 2) + n) / (2*a), e);
            }
        }else{
            return 1;
        }
    }
    
}
