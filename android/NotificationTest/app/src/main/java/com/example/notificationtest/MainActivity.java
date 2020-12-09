package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager  = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("ch01", "총무부", R.mipmap.ic_launcher_round,
                        "타이틀_총무부", "알림 내용입니다.", 10);
            }
        });

        Button button2 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("ch01", "총무부", R.mipmap.ic_launcher_round,
                        "타이틀_총무부", "알림 내용입니다.", 20);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification("ch02", "영업부", R.mipmap.ic_launcher_round,
                        "타이틀_영업부", "알림 내용입니다.", 30);
            }
        });

        Button button4 = findViewById(R.id.button4); // 사진
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = getNotificationBuilder("ch03", "햄버거");
                builder.setSmallIcon(R.mipmap.ic_launcher_round);

                NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle(builder);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.the_ultimate_hamburger);
                style.bigPicture(bitmap);
                style.setBigContentTitle("햄버거");
                style.setSummaryText("Summary Text");

                Notification noti = builder.build();
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(40, noti);
            }
        });

        Button button5 = findViewById(R.id.button5); // 긴 문장
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "버거킹 맥도날드 맘스터치 롯데리아의 햄버거.\n" +
                        "햄버거의 종류는 여러가지가 있습니다.\n" +
                        "와퍼, 빅맥, 싸이버거 등이 있습니다.";
                NotificationCompat.Builder builder = getNotificationBuilder("ch04", "햄버거");
                builder.setSmallIcon(R.mipmap.ic_launcher_round);
                NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle(builder);
                style.setBigContentTitle("텍스트 타이틀입니다.");
                style.bigText(text);
                Notification noti = builder.build();
                manager.notify(90, noti);
            }
        });
    }

    private void sendNotification(String chID, String chName, int smallIcon, String title, String text, int id) {
        NotificationCompat.Builder builder = getNotificationBuilder(chID, chName);
        builder.setSmallIcon(smallIcon);
        builder.setContentTitle(title);
        builder.setContentText(text);

        Notification noti = builder.build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(id, noti);
    }

    public NotificationCompat.Builder getNotificationBuilder(String chID, String chName) {
        NotificationCompat.Builder builder;
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O) { // 채널 지원 하니? (오레오 이상)
            NotificationChannel ch = new NotificationChannel(chID, chName, NotificationManager.IMPORTANCE_DEFAULT);
            ch.enableLights(true);
            ch.enableVibration(true);

            // 안드로이드에게 요청
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(ch);

            builder = new NotificationCompat.Builder(MainActivity.this, chID);
        }
        else {
            builder = new NotificationCompat.Builder(MainActivity.this);
        }
        return builder;
    }
}