package ao.jfpack.parse;

import java.io.Serializable;

public class ApacheLog implements Serializable {

    String ip;
    String date;
    String method;
    int status;
    int responseTime;

    ApacheLog(String ip, String date, String method, int status, int responseTime) {
        this.ip = ip;
        this.date = date;
        this.method = method;
        this.status = status;
        this.responseTime = responseTime;
    }
}
