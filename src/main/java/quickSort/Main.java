package quickSort;
/*
1. Write your implementation of QuickSort.
2. Use QuickSort to sort the string.
 */

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[20];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.sort(array)));

        QuickSortForString quickSortForString = new QuickSortForString();
        String str = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor? " +
                "Invidunt ut labore; et dolore: magna aliquyam!";
        System.out.println(quickSortForString.sort(str));
    }
}
