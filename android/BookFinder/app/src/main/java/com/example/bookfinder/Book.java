package com.example.bookfinder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

public class Book implements Serializable {
    String title;
    String contents;
    String url;
    String isbn;
    String dateTime;
    String authors;
    String publisher;
    String translators;
    int price;
    int salePrice;
    String thumbnail;
    String status;

    public Book(String title, String contents, String url, String isbn, String dateTime,
                String authors, String publisher, String translators, int price,
                int salePrice, String thumbnail, String status) {
        this.title = title;
        this.contents = contents;
        this.url = url;
        this.isbn = isbn;
        this.dateTime = dateTime;
        this.authors = authors;
        this.publisher = publisher;
        this.translators = translators;
        this.price = price;
        this.salePrice = salePrice;
        this.thumbnail = thumbnail;
        this.status = status;
    }

}
