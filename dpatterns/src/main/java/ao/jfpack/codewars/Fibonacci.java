package ao.jfpack.codewars;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
 * In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the
 * recurrence relation
 *
 * Fn = Fn-1 + Fn-2
 * with seed values: Fn = Fn-1 + Fn-2
 * Given a number n, print n-th Fibonacci Number.
 * Input  : n = 2
 * Output : 1
 *
 * Input  : n = 9
 * Output : 34
 */
public class Fibonacci {

    public static int fibonacci(int i) {
        return  (i <= 1) ? i : fibonacci(i - 1) + fibonacci(i - 2);
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci sequence for 2 is: " + fibonacci(2));
        System.out.println("Fibonacci sequence for 9 is: " + fibonacci(9));
        System.out.println("Fibonacci sequence for 5 is: " + fibonacci(5));
        System.out.println("Fibonacci sequence for 15 is: " + fibonacci(15));
    }
}
