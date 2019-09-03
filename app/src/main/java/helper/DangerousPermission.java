package tests;

import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import interfaces.Action;



public class DangerousPermission implements ActivityCompat.OnRequestPermissionsResultCallback {


    private static final String TAG = "Pouya";

    static Action action;
    static AppCompatActivity appCompatActivity;

    public static void request(AppCompatActivity activity, String permission, Action thisAction) {
        appCompatActivity = activity;
        action = thisAction;
        if (ActivityCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
            action.action();
            Log.i(TAG, "request: Done!");
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(appCompatActivity, permission)) {
            ActivityCompat.requestPermissions(appCompatActivity, new String[]{permission}, 100);
            Log.i(TAG, "request: More Time");
        } else {
            ActivityCompat.requestPermissions(appCompatActivity, new String[]{permission}, 100);
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "onRequestPermissionsResult: granted");
                Toast.makeText(appCompatActivity, "Done!", Toast.LENGTH_SHORT).show();
                action.action();
            } else {
                Log.i(TAG, "onRequestPermissionsResult: Not granted");
            }
        }
    }

}


