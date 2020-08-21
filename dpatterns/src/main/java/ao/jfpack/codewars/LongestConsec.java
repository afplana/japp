package ao.jfpack.codewars;

/**
 * You are given an array(list) strarr of strings and an integer k.
 * Your task is to return the first longest string
 * consisting of k consecutive strings taken in the array.
 *
 * Ex:
 * longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2)
 * --> "abigailtheta"
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 */
public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        // your code
        String longest = "";
        int n = strarr.length;
        if (k > n || k <= 0) return "";
        if (k == n) return String.join("", strarr);

        for (int i = 0; i < n-k+1; i++) {
            String current = "";
            for (int j=0; j<k; j++) {
                current = current.concat(strarr[i+j]);
            }

            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        String[] srtarr = new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"};
        System.out.println(longestConsec(srtarr, 3)); // ixoyx3452zzzzzzzzzzzz
    }
}
