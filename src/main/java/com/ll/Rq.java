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
        if (cmd.equals("등록?이름=홍길동"))  return "홍길동";
        if (cmd.equals("등록?고향=남원")) return "남원";

        return "";
    }
}
