package com.example.btscustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    String[] nicks = {"RM", "진", "슈가", "제이홉", "지민", "뷔", "정국"};
    String[] names = {"김남준", "김석진", "민윤기", "정호석", "박지민", "김태형", "전정국"};
    int[] images = {R.drawable.bts1, R.drawable.bts2, R.drawable.bts3, R.drawable.bts4, R.drawable.bts5, R.drawable.bts6, R.drawable.bts7};
    ListView listView;
    ArrayList<BTS> members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // ArrayList<HashMap<String, Object>>
//        members = new ArrayList<>();
//        for(int i=0; i<nicks.length; i++) {
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("nicks", nicks[i]);
//            map.put("names", names[i]);
//            map.put("images", images[i]);
//            members.add(map);
//        }

        members = new ArrayList<>();
        for (int i=0; i<nicks.length; i++) {
            BTS member = new BTS(nicks[i], names[i], images[i]);
            members.add(member);
        }

        BTSAdapter adapter = new BTSAdapter(this, members, R.layout.layout_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mainToDetailIntent = new Intent(getApplicationContext(), DetailActivity.class);
                BTS member = members.get(position);
                mainToDetailIntent.putExtra("member", member); // Serializable
                startActivity(mainToDetailIntent);
            }
        });
    }
}