package ao.jfpack.codewars;

import java.util.Arrays;

public class RemoveFromIntArray {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (elements.length == 0 || maxOccurrences == 0) {
            return new int[]{};
        }

        int[] aux = new int[elements.length];
        Arrays.fill(aux, -1);

        int j = 0;

        for (int element : elements) {
            if (!overMaxOccurrences(aux, element, maxOccurrences)) {
                aux[j] = element;
                j++;
            }
        }

        int[] result = new int[sizeOf(aux)];
        if (result.length >= 0) System.arraycopy(aux, 0, result, 0, result.length);
        return result;
    }

    private static int sizeOf(int[] aux) {
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == -1) {
                return i;
            }
        }
        return aux.length;
    }
    private static boolean overMaxOccurrences(int[] aux, int element, int maxOccurrences) {
        int occurrences = 0;
        for (int value : aux) {
            if (value == element) {
                occurrences++;
            }
        }
        return occurrences >= maxOccurrences;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 1, 1, 1, 1};
        int[] result = deleteNth(arr, 5);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
