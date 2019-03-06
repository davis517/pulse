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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestPost extends AppCompatActivity {




    Button request;
    RadioButton r1, r2, r3, r4;
    EditText nametyped, locationtyped, contacttyped;
    String name, location, contact, limit;
    Double longitude,latitude;
    FirebaseAuth firebaseAuth;
    DatabaseReference dtabaseReferance;


    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_post);


        firebaseAuth = FirebaseAuth.getInstance();
        dtabaseReferance = FirebaseDatabase.getInstance().getReference();
        request = (Button) findViewById(R.id.button10);
        nametyped = (EditText) findViewById(R.id.editText50);
        locationtyped = (EditText) findViewById(R.id.editText51);
        r1 = (RadioButton) findViewById(R.id.radioButton);
        r2 = (RadioButton) findViewById(R.id.radioButton2);
        progressDialog = new ProgressDialog(this);








        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent r = new Intent(RequestPost.this, UserMain2.class);
                startActivity(r);

                if (r1.isChecked()) {
                    limit = "Immediate";
                } else if (r2.isChecked()) {
                    limit = "Moderate";
                }



                //display some message her



                    final String type = nametyped.getText().toString().trim();
                    final String location = locationtyped.getText().toString().trim();
                    final String urgency = limit;







                    progressDialog.setMessage("Posting your request...");
                    progressDialog.show();
                    Accidentpost requestentry = new Accidentpost(type,location,urgency);
                    FirebaseDatabase.getInstance().getReference("Requestentry")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(requestentry).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                final Intent in = new Intent(RequestPost.this, UserMain2.class);

                                final Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressDialog.dismiss();
                                        startActivity(in);
                                    }
                                }, 10);

                            } else {
                                Toast.makeText(RequestPost.this, "Request Error Error", Toast.LENGTH_LONG).show();
                            }

                        }

                    });










            }
        });
    }
}