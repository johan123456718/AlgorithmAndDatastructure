/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB11;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Johan C
 * Finds the biggest number of a array with a recursion function
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        int[] a = new int[10];
        
        for(int i = 0; i < a.length; i++){
            a[i] = r.nextInt(100);
        }
        System.out.print(Arrays.toString(a));
        System.out.println("");
        System.out.println(maxValue(a));
    }
    
    public static int maxValue(int [] a){
        return maxValue(a, 0, 0);
    }
    
    private static int maxValue(int [] a, int index, int max){      
        if(index == a.length){
            return max;
        }else{
            
            if(max < a[index]){
                max = a[index];
                return maxValue(a, index+1, max);
            }else{
                return maxValue(a, index+1, max);
            }
        }
    }
    
}
