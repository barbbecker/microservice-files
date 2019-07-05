package com.barbbecker.jtcore.readfiles.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ReaderFile {

    public static String readStringFile(Path filePath) {
        String fileContent = "";

        Scanner file = null;
        try {
            file = new Scanner(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (file.hasNext()) {
            String line = " " + file.nextLine() + " ";
            fileContent = fileContent.concat(line);
        }

        return fileContent;
    }
}
