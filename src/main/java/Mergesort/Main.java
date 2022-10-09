package Mergesort;
// Apply the Divide and Conquer method and develop an algorithm for finding the smallest value of an array.

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array1 = new int[20];
        for(int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(100);
        }
        int[] array2 = new int[20];
        for(int i = 0; i < array2.length; i++) {
            array2[i] = random.nextInt(100);
        }

        QuickSort quickSort = new QuickSort();
        long startTime1 = System.nanoTime();
        int[] msortedArray = quickSort.sort(array1);
        long stopTime1 = System.nanoTime();
        System.out.println("Quick sorts time is " + (stopTime1 - startTime1));
        System.out.println(Arrays.toString(msortedArray));
        System.out.println("Min element is " + msortedArray[0]);

        MergeSort mergeSort = new MergeSort();
        long startTime2 = System.nanoTime();
        int[] qsortedArray = mergeSort.sort(array2);
        long stopTime2 = System.nanoTime();
        System.out.println("Merge sorts time is " + (stopTime2 - startTime2));
        System.out.println(Arrays.toString(qsortedArray));
        System.out.println("Min element is " + qsortedArray[0]);
    }
}