package ao.jfpack.codewars;

import static ao.jfpack.Utils.ComparableUtils.*;

/**
 * QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 *
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 *
 * The key process in quickSort is partition().
 * Target of partitions is, given an array and an element x of array as pivot,
 * put x at its correct position in sorted array and put all smaller elements
 * (smaller than x) before x, and put all greater elements (greater than x) after x.
 * All this should be done in linear time.
 *
 */
public class QuickSort {

    public static <T> void sort(Comparable<T>[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <T> void sort(Comparable<T>[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static <T> int partition(Comparable<T>[] a, int lo, int hi) {
        Comparable<T> pivot = a[hi];
        int i = (lo-1);

        for (int j=lo; j < hi; j++) {
            if (less(a[j], pivot)) {
                i++;
                exch(a, i, j);
            }
        }

        exch(a, i+1, hi);
        return i+1;
    }

    public static void main(String[] args) {
        Integer[] toSort = new Integer[]{15, 10, 3, 1, 7, 14, 8};
        sort(toSort);
        print(toSort);
    }
}
