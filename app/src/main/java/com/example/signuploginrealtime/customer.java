package com.example.signuploginrealtime;

public class customer {

    String bname;
    String bday;
    String btime;
    String bphone;

    public customer() {
    }

    public customer(String bname, String bday, String btime, String bphone) {
        this.bname = bname;
        this.bday = bday;
        this.btime = btime;
        this.bphone = bphone;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }

    public String getBphone() {
        return bphone;
    }

    public void setBphone(String bphone) {this.bphone=bphone;}
}
