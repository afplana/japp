package com.examples.parse;

import java.io.Serializable;

class ApacheLog implements Serializable {

    String ip;
    String date;
    Method method;
    int status;
    int responseTime;

    ApacheLog(String ip, String date, Method method, int status, int responseTime) {
        this.ip = ip;
        this.date = date;
        this.method = method;
        this.status = status;
        this.responseTime = responseTime;
    }


    enum Method {GET, POST, PUT, DELETE, PATCH}
}
