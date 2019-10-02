package com;

import com.examples.rabbitmq.pubsub.PublishLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApacheLogsSimpleParser {

    private static Logger logger = Logger.getLogger(ApacheLogsSimpleParser.class.getName());
    private static final Map<String, Integer> servers = new HashMap<>();
    private static final String REGEX = "^(\\S+) (\\S+) (\\S+) " +
            "\\[([\\w:/]+\\s[+\\-]\\d{4})] \"(\\S+)" +
            " (\\S+)\\s*(\\S+)?\\s*\" (\\d{3}) (\\S+)";

    static Map<String, Integer> retrieveServers(){
        return servers;
    }


    private static void parseLine(String line)
    {
        final Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String ip = matcher.group(1);
            int response = Integer.parseInt(matcher.group(8));
            if (response == 200)
                servers.put(ip, Integer.valueOf(matcher.group(9)));
        }

        for (Map.Entry entry : servers.entrySet()) {
            logger.info (entry.getKey() + " " + entry.getValue() );
        }
    }


    private static void startReadLog(String fileUrl){

        if(fileUrl.isEmpty())
            fileUrl = "src/test_logs.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileUrl))){
            String currentLine = reader.readLine();

            while (currentLine != null) {
                parseLine(currentLine);
                currentLine = reader.readLine();
            }
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            main(new String[]{""});
        }
    }

    private static void findFastResponse(){
        int minTime = Collections.min(servers.values());
        logger.info("\nMinimum time in the access log file was: " + minTime);
        servers.forEach((s, integer) -> {
            if(integer.equals(minTime))
                logger.info("\nServer with ip: " + s);
        });
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Provide Apache Logs route: ");
        startReadLog(scanner.nextLine());
        findFastResponse();
        System.out.println();
        servers
                .forEach((ip, responseTime) ->
                        {
                            try {
                                PublishLog.main(new String[]{"[!]","Server IP: " +ip, "Response Time: " +responseTime});
                            } catch (Exception ex) {
                                if(ex instanceof NullPointerException)
                                    logger.log(Level.WARNING, "Connection with broker failed...");
                                else if (ex instanceof TimeoutException)
                                    logger.log(Level.WARNING, "Server not responding...");
                                else
                                    logger.log(Level.SEVERE, ex.getLocalizedMessage());
                            }
                        }
                );

    }
}
