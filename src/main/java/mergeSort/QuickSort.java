package mergeSort;

public class QuickSort {

    public int[] sort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        return quickSort(array, begin, end);
    }

    private int[] quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);
            quickSort(array, begin, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
        return array;
    }

    private int partition(int[] array, int begin, int end) {
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

    private void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}
