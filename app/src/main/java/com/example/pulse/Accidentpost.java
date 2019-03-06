package com.example.pulse;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Accidentpost {
    public String type;
    public String location;
    public String urgency;

    public Accidentpost() {
    }

    public Accidentpost(String type, String location, String urgency) {
        this.type = type;
        this.location = location;
        this.urgency = urgency;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getUrgency() {
        return urgency;
    }
}



