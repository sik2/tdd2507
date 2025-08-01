package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private final String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }

    public String getActionName() {
        String[] cmdBits = cmd.split("\\?");
        return cmdBits[0];
    }

    public String getParam(String name, String defaultValue) {
        //"등록?이름=홍길동&고향=남원" -> "등록", "이름=홍길동&고향=남원"
        String queryString = cmd.split("\\?", 2)[1];

        Map<String, String> params = new HashMap<>();

        //이름=홍길동&고향=남원
        String[] queryStringBits = queryString.split("&");

        // [이름=홍길동, 고향=남원]
        for (String paramStr  : queryStringBits) {
            // "이름=홍길동" -> "이름", "홍길동"
            // "고향=남원" -> "고향", "남원"
            String[] paramBits = paramStr.split("=", 2);
            String paramName = paramBits[0];
            String paramValue = paramBits[1];

            params.put(paramName, paramValue);
        }

        return params.getOrDefault(name, defaultValue);
    }
}
