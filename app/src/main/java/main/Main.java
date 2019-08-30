package main;

import android.app.Application;
import android.os.Environment;

public class Main extends Application {
    public static final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
}
