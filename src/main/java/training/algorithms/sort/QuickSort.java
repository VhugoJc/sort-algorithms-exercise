package training.algorithms.sort;
import training.algorithms.Sorter;

import java.util.Comparator;

/*
* time complexity of O(n log n)
* best-case time complexity of O(n log n)
* Space complexity of O(log n)
*/
public class QuickSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo); // lambda with method reference. lambda: (o1, o2) -> o1.compareTo(o2)
    }
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        quickSort(array, 0, array.length - 1, comparator); // Call the main quickSort method
    }
    // Recursive sort sub-arrays
    private <T> void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int partitionIndex = partition(array, low, high, comparator);
            quickSort(array, low, partitionIndex - 1, comparator);
            quickSort(array, partitionIndex + 1, high, comparator);
        }
    }
    // Partition the array into two parts based on a pivot
    private <T> int partition(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private <T> void swap(T[] array, int i, int j) { // swap two elements by positions
        T aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
