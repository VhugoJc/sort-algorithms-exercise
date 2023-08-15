package training.algorithms.sort;
import training.algorithms.Sorter;

import java.util.Arrays;
import java.util.Comparator;
/*
* time complexity of O(N log(N))
* best-case time complexity of O(N log(N))
* Space Complexity: O(N) [aux array]
*/
public class MergeSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo); // lambda with method reference. lambda: (o1, o2) -> o1.compareTo(o2)
    }
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        mergeSort(array, 0, array.length - 1,comparator); // Call the main mergeSort method

    }
    private <T> void mergeSort(T[] array, int left, int right, Comparator<T> comparator) {
        int mid;
        if (left < right) {
            mid = left + (right - left) / 2; //middle index
            mergeSort(array, left, mid, comparator);//  Recursively sort the left sub-array
            mergeSort(array, mid + 1, right, comparator);//  Recursively sort the right sub-array

            merge(array, left, mid, right, comparator); // Merge the sorted sub-arrays
        }
    }
    private <T> void merge (T[] array, int left, int mid, int right, Comparator<T> comparator){
        // create two sub-arrays
        T[] leftArr = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) { // Merge the two sub-arrays
            if(comparator.compare(leftArr[i],rightArr[j]) <= 0){// Add the smaller element into the main array
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {// Copy any remaining elements from the left sub-array
            array[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {// Copy any remaining elements from the right sub-array
            array[k++] = rightArr[j++];
        }
    }
}
