package ao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class App {
    private static Logger logger = Logger.getLogger(App.class.getName());
    private static Map<String, Integer> numbers = new HashMap<>();

    static {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int indexOf_ = line.indexOf('-');
        int lastIndexOf_ = line.lastIndexOf('-');
        int indexOf = line.indexOf(' ');

        try {
            int n1 = indexOf_ != -1 ?
                    numbers.get(line.substring(0, indexOf_)) + numbers.get(line.substring(indexOf_ + 1, indexOf)) :
                    numbers.get(line.substring(0, indexOf));
            int n2 = lastIndexOf_ != -1 ?
                    numbers.get(line.substring(indexOf + 1, lastIndexOf_)) + numbers.get(line.substring(lastIndexOf_ + 1)) :
                    numbers.get(line.substring(indexOf + 1));

            System.out.println(n1 * n2);
        } catch (NullPointerException npe) {
            logger.info("Please type the numbers correctly");
            main(new String[]{});
        }
    }

}
