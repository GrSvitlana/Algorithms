package quickSort;

public class QuickSortForString {
    public char[] sort(String str) {
        char[] charStr = str.replaceAll("[.,-:;?!()<>/+*'\"\\ ]", "").toUpperCase().toCharArray();
        int begin = 0;
        int end = charStr.length - 1;
        return quickSort(charStr, begin, end);
    }

    private char[] quickSort(char[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
        return array;
    }

    private int partition(char[] array, int begin, int end) {
        int pivot = array[end];
        int pivotIndex = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(char[] array, int first, int second) {
        char tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
