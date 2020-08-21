package ao.jfpack.codewars;

import java.util.Scanner;

public class Palindrome {
    private static boolean isPalindrome(String word) {

        int wordLength = word.length();

        if (wordLength < 2)
            return true;
        else if (word.charAt(0) != word.charAt(wordLength - 1))
            return false;

        isPalindrome(word.substring(1, wordLength - 1));
        return true;
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrome(scanner.nextLine()));
    }
}
