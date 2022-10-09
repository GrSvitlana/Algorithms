package mergesSort;

import java.util.Locale;

public class MergeSortForString {
    public static char[] sort(String str) {
        char[] charStr = str.toCharArray();
        int length = charStr.length;
        int begin = 0;
        int end = length - 1;
        if (length == 1) return null;
        return mergeSort(charStr, begin, end);
    }

    private static char[] mergeSort(char[] elements, int left, int right) {
        if (left == right) {
            return new char[]{elements[left]};
        }
        int middle = left + (right - left) / 2;
        char[] leftArray = mergeSort(elements, left, middle);
        char[] rightArray = mergeSort(elements, middle + 1, right);
        return merge(leftArray, rightArray);
    }

    private static char[] merge(char[] leftArray, char[] rightArray) {
        int leftLen = leftArray.length;
        int rightLen = rightArray.length;

        char[] target = new char[leftLen + rightLen];
        int targetPos = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (leftPos < leftLen && rightPos < rightLen) {
            char leftValue = leftArray[leftPos];
            char rightValue = rightArray[rightPos];
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
