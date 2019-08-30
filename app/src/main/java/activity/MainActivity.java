package activity;

import android.Manifest;
import android.os.Bundle;

import com.greatmahanta.grm2framework.R;

import main.Main;
import tests.FileDownloader;

public class MainActivity extends GRM2AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestDangerousPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, new Action() {
            @Override
            public void go() {
                FileDownloader.download("", Main.SDCARD +"/POUYA/ mypicture.png");
            }
        });
    }
}
