package com.barbbecker.jtcore.readfiles.file;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.File;

public class ConfigFileTest {

    @Test
    public void testCreateFolders() {
        ConfigFile.createFiles();

        File fileIn = new File(System.getProperty("user.home") + "/data/in");
        File fileOut = new File(System.getProperty("user.home") + "/data/out");

        assertTrue(fileIn.isDirectory());
        assertTrue(fileOut.isDirectory());
    }
}
