package com.barbbecker.jtcore.readfiles.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigFile {

    private final static String HOME_PATH = "user.home";
    private final static String PATH_IN = "/data/in";
    private final static String PATH_OUT = "/data/out";

    public static void createFiles() {
        String homepath = System.getProperty(HOME_PATH);
        try {
            Files.createDirectories(Paths.get(homepath.concat(PATH_IN)));
            Files.createDirectories(Paths.get(homepath.concat(PATH_OUT)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
