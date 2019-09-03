package helper;

import java.io.File;
import java.io.IOException;

public class CreateDir {

    public static void creat(String path) {
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
