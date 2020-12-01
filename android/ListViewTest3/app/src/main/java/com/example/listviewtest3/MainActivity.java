package com.example.listviewtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] nicks = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ListView listView;
    ArrayList<HashMap<String, Object>> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ArrayList<HashMap<String, Object>>
        members = new ArrayList<>();
        for(int i=0; i<nicks.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("nicks", nicks[i]);
            map.put("names", names[i]);
            map.put("images", images[i]);
            members.add(map);
        }

        String[] keys = {"nicks", "names", "images"};
        int[] values = {R.id.text_nick_item, R.id.text_name_item, R.id.image_item};
        listView = findViewById(R.id.listview);
        SimpleAdapter adapter = new SimpleAdapter(this, members, R.layout.layout_item, keys, values);
        listView.setAdapter(adapter);
        ItemClickListener itemClickListener = new ItemClickListener();
        listView.setOnItemClickListener(itemClickListener);
    }

    class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(MainActivity.this, members.get(position).get("nicks").toString(), Toast.LENGTH_SHORT).show();
            HashMap<String, Object> memberInfoMap = members.get(position);
            String nick = memberInfoMap.get("nicks").toString();
            String name = memberInfoMap.get("names").toString();
            int image = (Integer) memberInfoMap.get("images");

            Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
            detailIntent.putExtra("nicks", nick);
            detailIntent.putExtra("names", name);
            detailIntent.putExtra("images", image);
            startActivity(detailIntent);
        }
    }
}