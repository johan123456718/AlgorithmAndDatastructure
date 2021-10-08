/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uppgift6;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Print your n: ");
        int n = scan.nextInt();
        
        QueenSolver solver = new QueenSolver(n);
        solver.solveResult();
       // System.out.println("Size: " + solver.getSize());
        System.out.println("Number of solutions: " + solver.getNrOfSolutions());
    }
    
}
