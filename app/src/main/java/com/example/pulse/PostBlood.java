package com.example.pulse;

public class PostBlood {
    public String hos1;
    public String blood1;
    public String urgency1;

    public PostBlood() {
    }

    public PostBlood(String hos1, String blood1, String urgency1) {
        this.hos1 = hos1;
        this.blood1 = blood1;
        this.urgency1 = urgency1;
    }

    public String getHos1() {
        return hos1;
    }

    public String getBlood1() {
        return blood1;
    }

    public String getUrgency1() {
        return urgency1;
    }
}
