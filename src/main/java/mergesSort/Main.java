package mergesSort;
/*
1. Write your implementation of MergeSort.
2. Sort the string using MergeSort.
3.* Find the index of a character in a string (without repeats)
4.* String[] a = {"1,2-4", "3-6", "2,5,7-11", "5"} -> Integer[] i = {1,2,3,4,3,4,5,6,2,5,7,8,9,10,11,5}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[30];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sort(array)));

        String str = "Lorem b ipsum F dolor sit amet, Consetetur sadipscing elitr, Ased Diam nonumy Beirmod tempor invidunt";
        System.out.println(MergeSortForString.sort(str));

        String str2 = "A aa b cc ddd E fff ggg K";
        notRepeat(str2);

        String[] a = {"1,2-4", "3-6", "2,5,7-11", "5"};
        System.out.println(toInt(a));

        String[] b = {"1,2-4", "3-6,2-4", "2,5,7-21", "3-6", "2,4,5-9", "5-8", "0,3-8", "3-6"};
        System.out.println(toInt(b));
    }

    private static void notRepeat(String str) {
        char[] sortStr = MergeSortForString.sort(str);
        char nr;
        for (int i = 1; i < sortStr.length - 1; i++) {
            if (sortStr[i - 1] != sortStr[i] && sortStr[i] != sortStr[i + 1]) {
                nr = sortStr[i];
                System.out.println(nr + " - " + str.indexOf(nr));
            }
        }
    }

    private static List<Integer> toInt(String[] str) {
        List<Integer> num = new ArrayList<>();
        String[] tmp;
        String[] mp;
        String[] p;
        int diff;
        for (int i = 0; i < str.length; i++) {
            tmp = str[i].split(",");
            for (int j = 0; j < tmp.length; j++) {
                mp = tmp[j].split(",");
                for (int k = 0; k < mp.length; k++) {
                    if (tmp[j].contains("-")) {
                        p = tmp[j].split("-");
                        int p1 = Integer.parseInt(String.valueOf(p[0]));
                        int p2 = Integer.parseInt(String.valueOf(p[1]));
                        diff = p2 - p1;
                        for (int n = 0; n < diff + 1; n++) {
                            num.add(p1 + n);
                        }
                    } else {
                        num.add(Integer.valueOf(tmp[j]));
                    }
                }
            }
        }
        return num;
    }
}