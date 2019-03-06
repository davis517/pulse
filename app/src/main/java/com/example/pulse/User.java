package com.example.pulse;
import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class User {
    public String Name;
    public String Age;
    public String Phone;


    public User() {
    }

    public User(String name, String age, String phone) {
        this.Name = name;
        this.Age = age;
        this.Phone = phone;
    }


}
