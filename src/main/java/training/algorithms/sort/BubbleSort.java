package training.algorithms.sort;
import training.algorithms.Sorter;

import java.util.Comparator;

/*
* time complexity of O(n^2)
* best-case time complexity of O(n)
*/
public class BubbleSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo); // lambda with method reference. lambda: (o1, o2) -> o1.compareTo(o2)
    }
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        boolean swapped;
        T aux;
        for(int i=0 ; i<array.length - 1; i++){
            swapped = false;
            for (int j = 0; j<array.length - i - 1; j++){ // prevent unnecessary comparisons with already sorted elements.
                if( comparator.compare(array[j],array[j + 1]) > 0) {
                    // Swap the elements if the current element is greater than the next element
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = aux;
                    swapped = true;
                }
            }
            if(!swapped){ // best case, the array is sorted.
                break;
            }
        }
    }
}
