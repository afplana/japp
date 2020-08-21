package ao.jfpack.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Move the first letter of each word to the end of it, then add "ay" to the end of the word.
 * Leave punctuation marks untouched.
 *
 * Ex:
 * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 * pigIt('Hello world !');     // elloHay orldway !
 */
public class PigLatin {
    public static String pigIt(String str) {
        // Write code here
        return Arrays.stream(str.split(" "))
                .map(s -> {
                    String i = String.valueOf(s.charAt(0));
                    if (!i.matches("[a-zA-Z]")) return s;
                    return s.substring(1)
                            .concat(i)
                            .concat("ay");
                })
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
//        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        System.out.println(pigIt("Pig latin is cool ! < > .."));
    }
}
