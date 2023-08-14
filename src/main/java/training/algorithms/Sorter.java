package training.algorithms;

import java.util.Comparator;

public interface Sorter {

    <T extends Comparable<T>> void sort(T[] array); // Comparable: This interface imposes a total ordering on the objects of each class that implements it [a.compareTo(b)]

    <T> void sort(T[] array, Comparator<T> comparator);// comparator = an interface that is used to rearrange the ArrayList in a sorted manner [compare(a,b)].
}
