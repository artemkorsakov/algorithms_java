package com.github.artemkorsakov.sort;

public class Sort {
    /**
     * @see <a href="https://en.wikipedia.org/wiki/Insertion_sort">Insertion sort</a>
     * О(n^2) comparisons and swaps
     */
    public static void insertion(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * {@link Sort#insertion(int[])} Reverse Insertion sort algorithm
     */
    public static void insertionReverse(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] < key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection sort</a>
     * О(n^2) comparisons, О(n) swaps
     */
    public static void selection(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int jMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[jMin]) {
                    jMin = j;
                }
            }

            if (jMin != i) {
                int temp = array[jMin];
                array[jMin] = array[i];
                array[i] = temp;
            }
        }
    }

    /**
     * {@link Sort#selection(int[])} Reverse Selection sort algorithm
     */
    public static void selectionReverse(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int jMax = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[jMax]) {
                    jMax = j;
                }
            }

            if (jMax != i) {
                int temp = array[jMax];
                array[jMax] = array[i];
                array[i] = temp;
            }
        }
    }

}
