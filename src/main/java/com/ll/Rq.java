package com.ll;

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
        if (cmd.equals("등록?이름=홍길동&고향=남원") && name.equals("이름")) return "홍길동";

        //"등록?이름=홍길동" -> "등록", "이름=홍길동"
        String quesryString = cmd.split("\\?", 2)[1];
        // "이름=홍길동" -> "이름", "홍길동"
        String[] paramBits = quesryString.split("=", 2);

        String paramName = paramBits[0];
        String paramValue = paramBits[1];

        if (!name.equals(paramName)) return defaultValue;

        return paramValue;
    }
}
