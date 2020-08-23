package ao.jfpack.codewars;

import static ao.jfpack.Utils.ComparableUtils.*;

/**
 * Merge Sort is a Divide and Conquer algorithm.
 * It divides input array in two halves, calls itself for the two
 * halves and then merges the two sorted halves. The merge() function
 * is used for merging two halves. The merge(arr, l, m, r) is key process
 * that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the
 * two sorted sub-arrays into one. See following C implementation for details.
 *
 * MergeSort(arr[], l,  r)
 * If r > l
 *      1. Find the middle point to divide the array into two halves:
 *              middle m = (l+r)/2
 *      2. Call mergeSort for first half:
 *              Call mergeSort(arr, l, m)
 *      3. Call mergeSort for second half:
 *              Call mergeSort(arr, m+1, r)
 *      4. Merge the two halves sorted in step 2 and 3:
 *              Call merge(arr, l, m, r)
 */
public class MergeSort {
    static <T> void merge(Comparable<T>[] arr, int lo, int mid, int hi) {
        assert isSorted(arr, lo, mid);
        assert isSorted(arr, mid + 1, hi);

        int fhSize = mid - lo + 1;
        int shSize = hi - mid;
        Comparable<T>[] fh = new Comparable[fhSize];
        Comparable<T>[] sh = new Comparable[shSize];

        System.arraycopy(arr, lo, fh, 0, fhSize);
        System.arraycopy(arr, mid+1, sh, 0, shSize);


        int i = 0, j = 0;
        int k = lo;
        while (i < fhSize && j < shSize) {
            if (less(fh[i], sh[j])) {
                arr[k] = fh[i];
                i++;
            } else {
                arr[k] = sh[j];
                j++;
            }
            k++;
        }

        for (;i < fhSize; i++, k++) arr[k] = fh[i];
        for (;j < shSize; j++, k++) arr[k] = sh[j];

        assert isSorted(arr, lo, hi);
    }

    static <T> void sort(Comparable<T>[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int m = (lo + hi) / 2;
        sort(arr, lo, m);
        sort(arr, m + 1, hi);
        merge(arr, lo, m, hi);
    }


    public static <T> void sort(Comparable<T>[] a) {
        Comparable<T>[] aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] toSort = new Integer[]{15, 10, 3, 1, 7, 14, 8};
        sort(toSort);
        print(toSort);
    }
}
