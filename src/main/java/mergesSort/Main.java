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
        toInt(a);
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

    private static void toInt(String[] str) {
        List<Character> num = new ArrayList<>();
        char[] tmp;
        int[] t;
        int diff;
        for (int i = 0; i < str.length; i++) {
            tmp = str[i].toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == ',') {
                    continue;
                }
                if (tmp[j] == '-') {

                    if ((j + 2) < tmp.length && tmp[j + 2] == '1') {
                        int d = 11;
                        diff = (int) ((tmp[j + 1] - tmp[j - 1]) - 1) + d;
                        for (int k = 0; k < diff; k++) {
                            num.add((char) (tmp[j - 1] + k + 1));
                        }
                        j += diff;
                    } else {
                        diff = (int) ((tmp[j + 1] - tmp[j - 1]) - 1);
                        for (int k = 0; k < diff; k++) {
                            num.add((char) (tmp[j - 1] + k + 1));
                        }
                    }
                } else {
                    num.add((char) tmp[j]);
                }
            }
        }
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i) == ':') {
                System.out.print(10 + ",");
            } else if (num.get(i) == ';') {
                System.out.print(11 + ",");
            } else if (i == num.size() - 1) {
                System.out.print(num.get(i));
            } else {
                System.out.print(num.get(i) + ",");
            }
        }
    }
}
