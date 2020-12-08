package com.example.optionmenutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.searchBar);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                textView.setText(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        MenuItem switchItem = menu.findItem(R.id.switchBar);
//        Switch sw = (Switch) switchItem.getActionView();
//        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked == true) {
//                    textView.setText("체크되었습니다.");
//                }
//                else {
//                    textView.setText("체크가 해제되었습니다.");
//                }
//            }
//        });

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu1:
                textView.setText("메뉴1");
                break;
            case R.id.menu2:
                textView.setText("메뉴2");
                break;
            case R.id.menu3_1:
                textView.setText("메뉴3-1");
                break;
            case R.id.menu3_2:
                textView.setText("메뉴3-2");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}