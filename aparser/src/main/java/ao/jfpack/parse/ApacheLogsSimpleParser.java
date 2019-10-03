package ao.jfpack.parse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class ApacheLogsSimpleParser {

    private static Logger logger = Logger.getLogger(ApacheLogsSimpleParser.class.getName());

    private static final List<ApacheLog> APACHE_LOGS = new ArrayList<>();
    private static final String APACHE_LOG_REGEX = "^(\\S+) (\\S+) (\\S+) " +
            "\\[([\\w:/]+\\s[+\\-]\\d{4})] \"(\\S+)" +
            " (\\S+)\\s*(\\S+)?\\s*\" (\\d{3}) (\\S+)";


    public static List<ApacheLog> retrieveApacheLogs() {
        return APACHE_LOGS;
    }


    private static void parseApacheLogLine(String line) {
        final Pattern pattern = Pattern.compile(APACHE_LOG_REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            try {
                APACHE_LOGS.add(new ApacheLog(
                        matcher.group(1),
                        matcher.group(4),
                        ApacheLog.Method.valueOf(matcher.group(5)),
                        parseInt(matcher.group(8)),
                        parseInt(matcher.group(9))
                ));
            } catch (NumberFormatException ex) {
                break;
            }

        }
    }

    private static void startReadLog(String fileUrl) {

        if (fileUrl.isEmpty())
            fileUrl = "test_logs.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileUrl))) {
            String currentLine = reader.readLine();

            while (currentLine != null) {
                parseApacheLogLine(currentLine);
                currentLine = reader.readLine();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getLocalizedMessage());
            main(new String[]{""});
        }
    }

    private static List<ApacheLog> findFastResponse() {
        OptionalInt minResponseTime = APACHE_LOGS.stream().mapToInt(log -> log.responseTime).min();
        return !minResponseTime.isPresent() ?
                Collections.emptyList() :
                APACHE_LOGS.stream()
                        .filter(apacheLog -> apacheLog.responseTime <= minResponseTime.getAsInt())
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        logger.log(Level.OFF, "Provide Apache Logs route or else default logs will be read: ");
        startReadLog(scanner.nextLine());

        logger.info("[!] Fastest responses are for servers:");
        findFastResponse()
                .forEach(apacheLog -> logger.info("-> " + apacheLog.ip + " _ on date: " + apacheLog.date + " _ Request Type: " + apacheLog.method + " _ Status: " + apacheLog.status + ""));
    }
}
