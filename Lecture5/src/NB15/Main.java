/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB15;

import java.util.Scanner;

/**
 *
 * @author Johan C
 * Convert a binary digit to decimal and opposite. 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Binary to Decimal");
        System.out.println("2. Decimal to Binary");
        int choice = Integer.parseInt(scan.nextLine());
        
        switch(choice){
            
            case 1:
                String binary = scan.nextLine();
                System.out.println(convertBinaryToDecimal(binary));
            break;
            
            case 2:
                int decimal = Integer.parseInt(scan.nextLine());
                System.out.println(convertDecimalToBinary(decimal));
            break;
        }
    }
    
    private static int convertBinaryToDecimal(String binary){
        if(binary.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder(binary);
        return convertBinaryToDecimal(sb.reverse().toString(),0, 0);
    }
    
    private static int convertBinaryToDecimal(String binary, int index, int result){
        
        if(index == binary.length()){
            return result;
        }else{
           
            if(binary.charAt(index) == '1'){
                result += Math.pow(2, index);
                return convertBinaryToDecimal(binary, index + 1, result);
            }else{
                return convertBinaryToDecimal(binary, index + 1, result);
            }
        }
    }
    
    public static String convertDecimalToBinary(int decimal){
        if(decimal == 0){
            return "0";
        }
        
        return convertDecimalToBinary(decimal, new StringBuilder());
    }
    
    private static String convertDecimalToBinary(int decimal, StringBuilder sb){
        if(decimal == 0){
            return sb.reverse().toString();
        }
        
        return convertDecimalToBinary(decimal / 2, sb.append(decimal % 2));
    }
    
}
