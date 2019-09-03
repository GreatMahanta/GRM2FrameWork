package activity;

import android.Manifest;
import android.os.Bundle;

import com.greatmahanta.grm2framework.R;

import androidx.appcompat.app.AppCompatActivity;
import interfaces.Action;
import main.Main;
import tests.DangerousPermission;
import tests.DialogTest;
import tests.FileDownloader;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Pouya";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestTest();
//        dialogTest();


    }

    protected void requestTest() {
        DangerousPermission.request(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, new Action() {
            @Override
            public void action() {
                FileDownloader.download("", Main.SDCARD + "/POUYA/ mypicture.png");
            }
        });
//        DangerousPermission.request(this, Manifest.permission.SEND_SMS ,new Action() {
//            @Override
//            public void action() {
//                FileDownloader.download("", Main.SDCARD + "/POUYA/ mypicture.mp3");
//            }
//        });
    }

    void dialogTest() {
        DialogTest.myDialog(this);
    }


}
