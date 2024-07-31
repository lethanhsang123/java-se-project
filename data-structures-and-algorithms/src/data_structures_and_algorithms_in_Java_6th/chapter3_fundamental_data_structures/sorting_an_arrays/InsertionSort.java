package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.sorting_an_arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class InsertionSort {

    public static void insertionSort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {   // begin with second character
            char cur = data[k];         // time to insert cur=data[k]
            int j = k;                  // find correct index j for cur
            while (j > 0 && data[j-1] >cur){    // thus, data[j-1] must go after cur
                data[j] = data[j-1];    // slide data[j-1] rightward
                j--;                    // and consider previous j for cur
            }
            data[j] = cur;              // this is the proper place for cur
        }
    }

    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt();
        }
        int[] orig = Arrays.copyOf(data, data.length);
        System.out.println("Arrays equals after sort: " + Arrays.equals(data, orig));
        Arrays.sort(data);
        System.out.println("Arrays equal after sort: " + Arrays.equals(data, orig));
        System.out.println("Orig = " + Arrays.toString(orig));
        System.out.println("Data = " + Arrays.toString(data));
    }

}
