package ao.jfpack.Utils;

public class ComparableUtils {

    private ComparableUtils(){}

    public static <T> void print(Comparable<T>[] arr){
        for (Comparable<T> c : arr) System.out.print(c + " ");
    }

    public static <T> boolean isSorted(Comparable<T>[] a, int lo, int hi) {
        Comparable<T> aux = a[lo];
        for (int k = lo; k < hi - 1; k++) {
            if (less(a[k + 1], a[k]))
                return false;
        }
        return true;
    }

    public static <T> boolean less(Comparable<T> comparable, Comparable<T> comparable1) {
        return comparable.compareTo((T) comparable1) <= 0;
    }

    public static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
