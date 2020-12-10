package com.example.evchargingstationtest;

public class Station {
    String stName;
    String addr;
    String chargeTp;
    String cpNm;
    String cpTp;
    String cpStat;

    public Station(String stName, String addr, String chargeTp, String cpNm, String cpTp, String cpStat) {
        this.stName = stName;
        this.addr = addr;
        this.chargeTp = chargeTp;
        this.cpNm = cpNm;
        this.cpTp = cpTp;
        this.cpStat = cpStat;
    }
}
