package activity;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


@SuppressLint("Registered")
public class GRM2AppCompatActivity extends AppCompatActivity {


    private static final String TAG = "Pouya";

    Action action;

    public interface Action {
        void go();
    }

    public void requestDangerousPermission(String permission, Action action) {
        this.action = action;
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), permission) == PackageManager.PERMISSION_GRANTED) {
            action.go();
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, 100);
            Log.i(TAG, "requestDangerousPermission: More Time");
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, 100);
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "onRequestPermissionsResult: granted");
                action.go();
            } else {
                Log.i(TAG, "onRequestPermissionsResult: Not granted");
            }
        }
    }


}


