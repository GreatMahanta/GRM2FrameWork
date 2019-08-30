package tests;

import java.io.File;
import java.io.IOException;

public class FileDownloader {

    private static final String TAG = "Pouya";

    public static void download(String url, String path) {

        try {

            String directory = path.substring(0, path.lastIndexOf("/"));
            String fileName = path.substring(path.lastIndexOf("/") + 1);

            new File(directory).mkdirs();
            new File(directory + "/" + fileName).createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}