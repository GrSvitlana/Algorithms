package Mergesort;

public class MergeSort {

    public int[] sort(int[] array) {
        int length = array.length;
        int begin = 0;
        int end = length - 1;
        if (length == 1) return null;
        return mergeSort(array, begin, end);
    }

    private int[] mergeSort(int[] elements, int left, int right) {
        if (left == right) {
            return new int[]{elements[left]};
        }
        int middle = left + (right - left) / 2;
        int[] leftArray = mergeSort(elements, left, middle);
        int[] rightArray = mergeSort(elements, middle + 1, right);
        return merge(leftArray, rightArray);
    }

    private int[] merge(int[] leftArray, int[] rightArray) {
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
