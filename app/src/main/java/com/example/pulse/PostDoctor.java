package com.example.pulse;

public class PostDoctor {
    public String hos2;
    public String type;
    public  String ca;

    public PostDoctor() {
    }

    public PostDoctor(String hos2, String type, String ca) {
        this.hos2 = hos2;
        this.type = type;
        this.ca = ca;
    }

    public String getHos2() {
        return hos2;
    }

    public String getType() {
        return type;
    }

    public String getCa() {
        return ca;
    }
}
