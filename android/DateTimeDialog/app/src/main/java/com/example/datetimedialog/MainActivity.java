package com.example.datetimedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button buttonDatePicker, buttonTimePicker;
    final String tag = "DateTime";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonDatePicker = findViewById(R.id.button);
        buttonTimePicker = findViewById(R.id.button2);

        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance(); // 싱글톤 객체
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
//                String[] dayOfWeeks = {"일", "월", "화", "수", "목", "금", "토"};
//                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 요일 (일요일1~토요일7)
                DPDListener listener = new DPDListener();
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        listener, year, month, day);
                datePickerDialog.show();
            }
        });

        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR);
                int min = calendar.get(Calendar.MINUTE);
                TPDListener listener = new TPDListener();
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        listener, hour, min, true);
                timePickerDialog.show();
            }
        });
    }

    class DPDListener implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Log.d(tag, "DatePicker OnDateSet");
            Log.d(tag, year + "-" + (month+1) + "-" + dayOfMonth);
            textView.setText(year + "-" + (month+1) + "-" + dayOfMonth);
        }
    }

    class TPDListener implements TimePickerDialog.OnTimeSetListener {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            textView.setText(hourOfDay + ":" + minute);
        }
    }
}