package com.example.bookfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private static final String END_POINT = "https://dapi.kakao.com/v3/search/book?query=%s&page=%d";
    private static final String API_KEY = "664fd8e249303d5990b0bf0d6f3b1fc7"; //REST API KEY
    SearchView searchView;
    RecyclerView recyclerView;
    BookAdapter adapter;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        adapter = new BookAdapter(this, R.layout.layout_item);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);

        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int totalItemCount = manager.getItemCount();
                int lastVisible = manager.findLastCompletelyVisibleItemPosition();
                if(lastVisible >= totalItemCount-1) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            page++;
                            String json = search(searchView.getQuery().toString());
                            parsing(json);
                        }
                    });
                    thread.start();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("검색어를 입력하세요.");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        String json = search(query);
                        parsing(json);
//                        System.out.println(json);
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

    public String search(String query) {
        // 어디에 접속할 것인가, 카카오 서버에 요청
        String strURL = String.format(END_POINT, query, page);
        String str;
        String result = null;
        try {
            // Request
            URL url = new URL(strURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", "KakaoAK " + API_KEY);
            con.connect();
            // Response
            if(con.getResponseCode() == con.HTTP_OK) {
                InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuffer buffer = new StringBuffer(); // 임시 저장공간
                while((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                result = buffer.toString();
            }
        } catch(IOException e) { //IOException > MalformedException 포함
            System.out.println("예외 발생");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public void parsing(String json) {
        try {
            JSONObject root = new JSONObject(json);
            JSONObject meta = root.getJSONObject("meta");
            JSONArray documents = root.getJSONArray("documents");
            for(int i=0; i<documents.length(); i++) {
                JSONObject book = documents.getJSONObject(i);
                String title = book.getString("title");
                JSONArray tempAuthor = book.getJSONArray("authors");
                String authors = "";
                for(int j=0; j<tempAuthor.length(); j++) {
                    authors = authors + tempAuthor.getString(j);
                    if(j < tempAuthor.length()-1) { authors = authors + ", "; }
                }
                String publisher = book.getString("publisher");
                String contents = book.getString("contents");
                String url = book.getString("url");
                String isbn = book.getString("isbn");
                String dateTime = book.getString("datetime");
                JSONArray tempTranslator = book.getJSONArray("translators");
                String translators = "";
                for(int j=0; j<tempTranslator.length(); j++) {
                    translators = translators + tempTranslator.getString(j);
                    if(j < tempTranslator.length()-1) { translators = translators + ", "; }
                }
                int price = book.getInt("price");
                int salePrice = book.getInt("sale_price");
                String thumbnail = book.getString("thumbnail");
                String status = book.getString("status");

                Book newBook = new Book(title, contents, url, isbn, dateTime, authors, publisher,
                        translators, price, salePrice, thumbnail, status);
                adapter.addItem(newBook);
            }
            recyclerView.post(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyDataSetChanged();
                }
            });
        } catch(JSONException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}