package Mergesort;
// Применить метод "Разделяй и властвуй" и разработать алгоритм поиска наименьшего значения массива.

import java.util.Arrays;

public class Mergesort {

    public static void main(String[] args) {
        int[] array = {72, 44, 48, 42, 32, 108, 10, 19, 11};
        System.out.println(Arrays.toString(sort(array)));
        System.out.println("Min element is " + array[0]);
    }

    public static int[] sort(int[] elements) {
        int length = elements.length;
        if (length == 1) return null;
        int[] sorted = mergeSort(elements, 0, length - 1);
        System.arraycopy(sorted, 0, elements, 0, length);
        return sorted;
    }

    private static int[] mergeSort(int[] elements, int left, int right) {
        if (left == right) {
            return new int[]{elements[left]};
        }
        int middle = left + (right - left) / 2;
        int[] leftArray = mergeSort(elements, left, middle);
        int[] rightArray = mergeSort(elements, middle + 1, right);
        return merge(leftArray, rightArray);
    }

    static int[] merge(int[] leftArray, int[] rightArray) {
        int leftLen = leftArray.length;
        int rightLen = rightArray.length;

        int[] target = new int[leftLen + rightLen];
        int targetPos = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (leftPos < leftLen && rightPos < rightLen) {
            int leftValue = leftArray[leftPos];
            int rightValue = rightArray[rightPos];
            if (leftValue <= rightValue) {
                target[targetPos++] = leftValue;
                leftPos++;
            } else {
                target[targetPos++] = rightValue;
                rightPos++;
            }
        }

        while (leftPos < leftLen) {
            target[targetPos++] = leftArray[leftPos++];
        }
        while (rightPos < rightLen) {
            target[targetPos++] = rightArray[rightPos++];
        }
        return target;
    }
}