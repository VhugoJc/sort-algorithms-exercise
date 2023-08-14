package training.algorithms.sort;
import training.algorithms.Sorter;

import java.util.Comparator;

/*
* time complexity of O(n^2)
* best-case time complexity of O(n)
*/
public class InsertionSort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo); // lambda with method reference. lambda: (o1, o2) -> o1.compareTo(o2)
    }
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator) {
        T key;
        for(int i = 1; i < array.length; i++){
           key = array[i];
           int j = i-1;
           // best case 'comparator.compare(array[j], key) > 0' is always false
           while (j >= 0 && comparator.compare(array[j], key) > 0){ // Shift elements greater than the key to the right
               array[j+1] = array[j];// Move elements one position right
               j--;
           }
           array[j+1]=key;
       }
    }
}
