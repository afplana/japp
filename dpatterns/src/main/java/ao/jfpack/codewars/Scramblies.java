package ao.jfpack.codewars;

/**
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged
 * to match str2, otherwise returns false.
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 *
 * Input strings s1 and s2 are null terminated.
 */
public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        for (int i=0;i<str2.length();i++) {
            char current = str2.charAt(i);
            if (!str1.contains(String.valueOf(current))) {
                return false;
            }
            str1 = charRmAt(str1, str1.indexOf(current));
        }
        return true;
    }

    public static String charRmAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    public static void main(String[] args) {
        System.out.println("Fixed Tests scramble");
//        testing(Scramblies.scramble("rkqodlw","world"), true);
//        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
//        testing(Scramblies.scramble("katas","steak"),false);
//        testing(Scramblies.scramble("scriptjavx","javascript"),false);
//        testing(Scramblies.scramble("scriptingjava","javascript"),true);
//        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
//        testing(Scramblies.scramble("javscripts","javascript"),false);
//        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
//        testing(Scramblies.scramble("commas","commas"),true);
//        testing(Scramblies.scramble("sammoc","commas"),true);
        System.out.println(scramble("cedewaraaossoqqyt","codewars"));

    }
}
