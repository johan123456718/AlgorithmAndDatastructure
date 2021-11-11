/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB14_1;

/**
 *
 * @author Johan C
 * Calculates the number of combination of color balls
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nrOfBlue = 5;
        int nrOfWhite = 1;
        int nrOfRed = 3;
        System.out.println(nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
        
        nrOfBlue = 2;
        nrOfWhite = 1;
        nrOfRed = 3;
        System.out.println(nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
        
        nrOfBlue = 22;
        nrOfWhite = 22;
        nrOfRed = 13;
        System.out.println(nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
    }
    
    public static int nrOfSwitches(int nrOfBlue, int nrOfWhite, int nrOfRed){
        return nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed, 0);
    }
    
    private static int nrOfSwitches(int nrOfBlue, int nrOfWhite, int nrOfRed, int nrOfSwitches){
        if(nrOfBlue == nrOfWhite && nrOfBlue == nrOfRed){
            return nrOfSwitches;
        }else if(nrOfSwitches > 15){
            return -1;
        }else{
            
            int switchBlue = nrOfSwitches(nrOfBlue - 1, nrOfWhite + 3, nrOfRed + 1, nrOfSwitches + 1);
            int switchWhite = nrOfSwitches(nrOfBlue + 3, nrOfWhite - 1, nrOfRed + 4, nrOfSwitches + 1);
            int switchRed = nrOfSwitches(nrOfBlue + 2, nrOfWhite + 1, nrOfRed - 1, nrOfSwitches + 1);
            
            if(nrOfBlue >= nrOfWhite && nrOfBlue >= nrOfRed){
                
                if(nrOfBlue >= 1)
                    return switchBlue;
            }else if(nrOfWhite >= nrOfBlue && nrOfWhite >= nrOfRed){
                
                if(nrOfWhite >= 1)
                    return switchWhite;
                
            }else if(nrOfRed >= nrOfBlue && nrOfRed >= nrOfWhite){
                
                if(nrOfRed >= 1)
                    return switchRed;
            }
            return Math.min(Math.min(switchBlue, switchWhite), switchRed);
        }
    }
    
}
