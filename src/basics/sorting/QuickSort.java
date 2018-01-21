package basics.sorting;

import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quicksort(int[] a, int start, int end) {

        if (start >= end) return;

        int q = partition(a, start, end);

        quicksort(a, start, q - 1);
        quicksort(a, q + 1, end);

    }

    private static int partition(int[] a, int start, int end) {

        int pivot = a[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {

            if (a[j] <= pivot) {
                if (j != i + 1) {
                    swap(a, ++i, j);
                } else {
                    i++;
                }
            }

        }

        swap(a, i + 1, end);
        return i + 1;

    }

    public static void main(String[] args) {

        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};

        quicksort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

}
