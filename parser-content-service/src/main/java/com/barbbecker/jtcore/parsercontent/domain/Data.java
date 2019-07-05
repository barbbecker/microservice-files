package com.barbbecker.jtcore.parsercontent.domain;

import java.io.Serializable;

public class Data implements Serializable {

    private String path;
    private String content;

    public Data(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }
}
