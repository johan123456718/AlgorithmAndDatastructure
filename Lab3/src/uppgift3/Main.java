package uppgift3;

import java.util.Arrays;

/**
 *
 * @author Johan Challita
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 1000000;
        int[] numbers = new int[size];
        Sort.init(numbers, size);
    
        double start = System.currentTimeMillis();
        Sort.radixSort(numbers, size);    
        double end = System.currentTimeMillis();
        
        System.out.println("Size: " + numbers.length);
        System.out.println("Sorted? " + Sort.isSorted(Sort.radixSort(numbers, size)));
      
        System.out.println("Time: " + (end - start) + " milisek");
    }

}

  //  System.out.println(Arrays.toString(numbers));
        //System.out.println("");
//System.out.println(Arrays.toString());
  //System.out.println("");
//System.out.println(Arrays.toString(Sort.radixSort(numbers, size)));    
