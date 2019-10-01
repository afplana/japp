package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ParseLogTest {

    @Test
    public void startReadLog_WhenCorrectAddress_ReturnsLogs() {
        InputStream in = new ByteArrayInputStream("src/test_logs.txt".getBytes());
        String line = "46.72.184.174 - - [12/Dec/2015:18:51:08 +0100] \"POST /administrator/index.php HTTP/1.1\" 200 4494";
        System.setIn(in);
        ApacheLogsSimpleParser.main(new String[]{""});
        assertEquals(ApacheLogsSimpleParser.retrieveServers().get("46.72.184.174"), Integer.valueOf(4494));
    }

}