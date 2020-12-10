package com.example.evchargingstationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private static final String END_POINT = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?addr=%s&pageNo=%d&numOfRows=10&ServiceKey=%s";
    private String SERVICE_KEY = "Co8IcSHCxMh9AFCs3ArF7jzX28TZg3qjdEc3vds3WBPSowRz0hsSVGwClfPA7OrTWrS25LRHohv4iyC9lJ%2B%2FPA%3D%3D";
    XmlPullParser xpp;
    SearchView searchView;
    RecyclerView recyclerView;
    StationAdapter adapter;
    int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        adapter = new StationAdapter(this, R.layout.layout_item);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("위치를 입력하세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        pageNo = 1;
                        adapter.clear();
                        String xml = search(query);
                        System.out.println("result : " + xml);
                    }
                });
                thread.start();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public  String search(String query)  {
        try {
            query = URLEncoder.encode(query, "UTF-8");
            SERVICE_KEY = URLDecoder.decode(SERVICE_KEY, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String strURL = String.format(END_POINT, query, pageNo, SERVICE_KEY);
        String str;
        String result = null;
//        try {
//            StringBuilder urlBuilder = new StringBuilder(END_POINT2); /*URL*/
//            String serviceKeyDecoded = URLDecoder.decode(SERVICE_KEY, "UTF-8");
//            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /*공공데이터포털에서 받은 인증키*/
//            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//            urlBuilder.append("&" + URLEncoder.encode("addr", "UTF-8") + "=" + URLEncoder.encode(query, "UTF-8")); /*주소*/
//            strURL = urlBuilder.toString();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println("2 : " + strURL);
        try {
            // Request
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            //Response
            if(con.getResponseCode() == con.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuffer buffer = new StringBuffer();
                while((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                System.out.println("Response : " + con.getResponseCode());
                result = buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void parsing(String xml) {

    }
}