package com.barbbecker.jtcore.parsercontent.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriterFile {

    private final static String PATH_OUT = System.getProperty("user.home") + "/data/out/";
    private final static String EXTENTION = ".dat";
    private final static String EXTENTION_TO = ".done.dat";

    public static void prepareFileToReport(List<String> contentData, String filePath) {
        String fileNamePrepared = filePath.replace(EXTENTION, EXTENTION_TO);
        String path = PATH_OUT;
        try {
            PrintWriter writer = new PrintWriter(path + fileNamePrepared, "UTF-8");
            contentData.forEach(s -> writer.println(s));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
