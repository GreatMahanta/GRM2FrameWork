package tests;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.greatmahanta.grm2framework.R;

import androidx.appcompat.app.AppCompatActivity;

public class DialogTest {

    private static final String TAG = "Pouya";

    static AppCompatActivity appCompatActivity;
    static String[] chooses;


    public static void myDialog(AppCompatActivity activity) {
        chooses = new String[] {"A", "B", "C"};

        appCompatActivity = activity;
        new AlertDialog.Builder(appCompatActivity)
            .setTitle("Hello")
//            .setMessage("This is the \"Test Dialog\"")
            .setIcon(R.drawable.ic_android_black_24dp)
            .setPositiveButton("HEY YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(appCompatActivity, "You Clicked On Positive Button", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("HEY NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(appCompatActivity, "You Clicked On Negative Button", Toast.LENGTH_SHORT).show();
                }
            })
            .setSingleChoiceItems(chooses, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(appCompatActivity, "You Clicked On Item: " + chooses[i], Toast.LENGTH_SHORT).show();
                }
            })
            .setSingleChoiceItems(chooses, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(appCompatActivity, "You Clicked On Item: " + chooses[i], Toast.LENGTH_SHORT).show();
                }
            })
            .create()
            .show();

    }
}
