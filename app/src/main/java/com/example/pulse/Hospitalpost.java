package com.example.pulse;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hospitalpost extends AppCompatActivity {




    Button requestblood,requestdoc;
    RadioButton r1, r2, r3, r4;
    EditText hospitaltyped,bloodtyped,urgencytyped;
    EditText hospitaltyped1,bloodtyped1,urgencytyped1;
    String name, location, contact, limit;
    Double longitude,latitude;
    FirebaseAuth firebaseAuth;
    DatabaseReference dtabaseReferance;
    FirebaseUser user;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalpost);


        firebaseAuth = FirebaseAuth.getInstance();
        dtabaseReferance = FirebaseDatabase.getInstance().getReference();
        requestblood = (Button) findViewById(R.id.button10);
        hospitaltyped = (EditText) findViewById(R.id.editText61);
        bloodtyped = (EditText) findViewById(R.id.editText62);
        urgencytyped = (EditText) findViewById(R.id.editText63);


        requestdoc = (Button) findViewById(R.id.button10);
        hospitaltyped1 = (EditText) findViewById(R.id.editText61);
        bloodtyped1 = (EditText) findViewById(R.id.editText62);
        urgencytyped1 = (EditText) findViewById(R.id.editText63);

        progressDialog = new ProgressDialog(this);





        requestblood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //display some message her

                    final String hos1 = hospitaltyped.getText().toString().trim();
                    final String blood1 = bloodtyped.getText().toString().trim();
                    final String urgency1 = urgencytyped.getText().toString().trim();



                    progressDialog.setMessage("Posting your request...");
                    progressDialog.show();
                    PostBlood requestentry = new PostBlood(hos1,blood1,urgency1);
                    FirebaseDatabase.getInstance().getReference("Bloodrequest")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(requestentry).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                final Intent in = new Intent(Hospitalpost.this, HospitalMain.class);
                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressDialog.dismiss();
                                        startActivity(in);
                                    }
                                }, 10);

                            } else {
                                Toast.makeText(Hospitalpost.this, "Request Error Error", Toast.LENGTH_LONG).show();
                            }

                        }

                    });




                }


        });



        requestdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //display some message her

                final String hos2 = hospitaltyped1.getText().toString().trim();
                final String type = bloodtyped1.getText().toString().trim();
                final String ca = urgencytyped1.getText().toString().trim();



                progressDialog.setMessage("Posting your request...");
                progressDialog.show();
                PostDoctor requestentry = new PostDoctor(hos2,type,ca);
                FirebaseDatabase.getInstance().getReference("DoctorRequest")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                        .setValue(requestentry).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            final Intent in = new Intent(Hospitalpost.this, HospitalMain.class);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.dismiss();
                                    startActivity(in);
                                }
                            }, 10);

                        } else {
                            Toast.makeText(Hospitalpost.this, "Request Error Error", Toast.LENGTH_LONG).show();
                        }

                    }

                });




            }


        });
    }
}