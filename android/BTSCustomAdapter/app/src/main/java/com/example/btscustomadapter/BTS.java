package com.example.btscustomadapter;

import java.io.Serializable;

public class BTS implements Serializable {
    String nick;
    String name;
    int image;

    public BTS(String nick, String name, int image) {
        this.nick = nick;
        this.name = name;
        this.image = image;
    }
}
