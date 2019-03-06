package com.example.pulse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button user,doctor,hospital;
    TextView simple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hospital=(Button)findViewById(R.id.button);
        doctor=(Button)findViewById(R.id.button2);
        user=(Button)findViewById(R.id.button3);
        simple=(TextView)findViewById(R.id.textView9);

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(MainActivity.this,registration.class);
                startActivity(u);
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(MainActivity.this,HospitalLogin2.class);
                startActivity(u);
            }
        });
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(MainActivity.this,DonorLogin2.class);
                startActivity(u);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u=new Intent(MainActivity.this,UserLogin.class);
                startActivity(u);
            }
        });
    }
}
