package com.barbbecker.jtcore.parsercontent.dto;

public class DataDto {

    private String path;
    private String content;

    public DataDto(String path, String content) {
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
