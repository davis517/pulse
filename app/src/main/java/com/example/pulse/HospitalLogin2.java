package com.example.pulse;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HospitalLogin2 extends AppCompatActivity {

    Button login3;
    TextView email2,password2;
    private FirebaseAuth auth;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login2);

        auth=FirebaseAuth.getInstance();

        login3=(Button)findViewById(R.id.button11);
        email2=(TextView)findViewById(R.id.editText13);
        password2=(TextView)findViewById(R.id.editText20);



        login3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=email2.getText().toString().trim();
                final String password=password2.getText().toString().trim();
                auth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(HospitalLogin2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent na=new Intent(HospitalLogin2.this,HospitalMain.class);
                                    startActivity(na);
                                }
                                else {
                                    Toast.makeText(HospitalLogin2.this," Not DONE ", Toast.LENGTH_LONG).show();

                                }

                            }
                        });

            }
        });

    }
}
