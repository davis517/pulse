package com.example.pulse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.app.ProgressDialog;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HospitalLogin extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;

    String v1,v2;
    EditText emailtyped,passtyped;
    String email,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_login);

        login=(Button)findViewById(R.id.button4);


        emailtyped=(EditText)findViewById(R.id.editText2);
        passtyped=(EditText)findViewById(R.id.editText3);

        email=emailtyped.getText().toString().trim();
        password=passtyped.getText().toString().trim();

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Hospitals");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds:dataSnapshot.getChildren()){
                            String doctorid = ds.child("hospitalid").getValue(String.class);
                            String password1 = ds.child("password").getValue(String.class);
                            if((email.equals(doctorid))&&(password.equals(password1))){
                                Intent ig = new Intent(HospitalLogin.this, HospitalMain.class);
                                startActivity(ig);

                            }


                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
