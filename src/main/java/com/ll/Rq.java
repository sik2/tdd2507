package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final String cmd;
    private final  Map<String, String> params;

    public Rq(String cmd) {
        this.cmd = cmd;

        params  = new HashMap<>();
        String queryString = cmd.split("\\?", 2)[1];

        String[] queryStringBits = queryString.split("&");

        for (String paramStr  : queryStringBits) {
            String[] paramBits = paramStr.split("=", 2);
            String paramName = paramBits[0];
            String paramValue = paramBits[1];

            params.put(paramName, paramValue);
        }
    }

    public String getActionName() {
        String[] cmdBits = cmd.split("\\?");
        return cmdBits[0];
    }

    public String getParam(String name, String defaultValue) {
        return params.getOrDefault(name, defaultValue);
    }
}
