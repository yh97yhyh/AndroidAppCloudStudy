package com.example.permissiontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String[] permissions = {
            Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.SEND_SMS,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        checkPermissions();
    }

    public void checkPermissions() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        int check = 0;
        for(String permission:permissions) {
            check = checkCallingOrSelfPermission(permission);
            if(check == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissions, 101);
                break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode != 101) {
            return;
        }
        textView.setText("");
        for(int i=0; i<grantResults.length; i++) {
            if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                String result = permissions[i] + " : 허가 \n";
                textView.append(result);
            }
            else {
                String result = permissions[i] + " : 거부 \n";
                textView.append(result);
            }
        }

    }
}