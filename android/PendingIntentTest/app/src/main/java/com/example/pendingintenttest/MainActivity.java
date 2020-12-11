package com.example.pendingintenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = getNotificationBuilder("ch01", "총무부");
                builder.setSmallIcon(android.R.drawable.btn_star);
                builder.setContentTitle("이것은 펜딩인텐트 테스트1입니다.");
                builder.setContentText("이 알림을 터치하면 SubActivity1이 열립니다.");

                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                        101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                Notification noti = builder.build();
                manager.notify(10, noti);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = getNotificationBuilder("ch02", "인사부");
                builder.setSmallIcon(android.R.drawable.btn_star);
                builder.setContentTitle("이것은 펜딩인텐트 테스트2입니다.");
                builder.setContentText("이 알림을 터치하면 SubActivit2가 열립니다.");

                Intent intent = new Intent(getApplicationContext(), SubActivity2.class);
                intent.putExtra("num1", 3);
                intent.putExtra("num2", 4);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                        101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                Notification noti = builder.build();
                manager.notify(20, noti);



            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = getNotificationBuilder("ch03", "영업부");
                builder.setSmallIcon(android.R.drawable.btn_star);
                builder.setContentTitle("이것은 펜딩인텐트 액션 테스트입니다.");
                builder.setContentText("이 알림을 터치하면 SubActivity1이 열립니다.");
//                builder.setAutoCancel(true);

                // 기존의 Pending Intent
                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                        101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                // Intent -> Pending Intent -> Action -> builder.add
                Intent actionIntent = new Intent(getApplicationContext(), SubActivity1.class);
                PendingIntent actPIntent = PendingIntent.getActivity(getApplicationContext(),
                        101, actionIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Action.Builder actionBuilder =
                        new NotificationCompat.Action.Builder(android.R.drawable.btn_star,
                                "Action1", actPIntent);
                NotificationCompat.Action action = actionBuilder.build();
                builder.addAction(action);

                Notification noti = builder.build();
                manager.notify(30, noti);
            }
        });
    }

    public NotificationCompat.Builder getNotificationBuilder(String chId, String chName) {
        NotificationCompat.Builder builder;
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(chId, chName,  NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableVibration(true);
            manager.createNotificationChannel(channel);
            builder = new NotificationCompat.Builder(this, chId);
        } else {
           builder = new NotificationCompat.Builder(this);
        }
        return builder;
    }
}