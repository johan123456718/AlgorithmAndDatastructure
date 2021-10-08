package uppgift3;

import java.util.Random;

/**
 *
 * @author Johan Challita
 */
public class Sort {
    
    public static void init(int[] input, int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            input[i] = rand.nextInt(size) + 1;
        }
    }
    
    //Sorts the array
    public static int[] radixSort(int[] input, int size) {
        for (int i = 1; i <= size; i *= 10) {
            input = countSort(input, i);
        }
        return input;
    }
    
    // counts how many we have of every possible value
    private static int[] countSort(int[] input, int index) {
        int[] output = new int[input.length];
        int[] count = new int[10];

        //store count of occurrences
        for (int i = 0; i < input.length; i++) {
            int digit = (input[i] / index) % 10;    //Formula: Where position is the nth digit starting with 0
            count[digit] += 1;
        }
        //Changes the count[i] to the current position in output[]
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        //Build output array
        for (int i = input.length - 1; i >= 0; i--) {
            int digit = (input[i] / index) % 10;
            output[count[digit] - 1] = input[i];
            count[digit]--;
        }
        return output;
    }
    
    //Checks if the array is sorted
    public static boolean isSorted(int[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] > input[i + 1]) {
                return false;
            }
        }
        return true;
    }
}