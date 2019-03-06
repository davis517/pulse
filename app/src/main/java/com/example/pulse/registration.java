package com.example.pulse;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {

    Button doctor,hospital;
    EditText hemail,hpassword;
    EditText demail,dpassword;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        doctor=(Button)findViewById(R.id.button9);
        hospital=(Button)findViewById(R.id.button8);
        hemail=(EditText)findViewById(R.id.editText14);
        hpassword=(EditText)findViewById(R.id.editText15);
        demail=(EditText)findViewById(R.id.editText16);
        dpassword=(EditText)findViewById(R.id.editText17);

        firebaseAuth=FirebaseAuth.getInstance();

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerdoctor();

            }
        });
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerhospital();

            }
        });

    }
    public void registerdoctor(){


        String Email=demail.getText().toString().trim();
        String Password=dpassword.getText().toString().trim();
        final String name="null";

        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                                }


                        else{
                            Toast.makeText(registration.this,"Registration Error",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }
    public void registerhospital(){

        final String hhemail=hemail.getText().toString().trim();
        final String hhpassword=hpassword.getText().toString().trim();
        final String name="null";
        firebaseAuth.createUserWithEmailAndPassword(hhemail,hhpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            addhos user=new addhos(name);
                            FirebaseDatabase.getInstance().getReference("Hospitals")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){


                                    }else{
                                        Toast.makeText(registration.this,"Registration Error",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });

                        }
                        else{
                            Toast.makeText(registration.this,"Registration Error",Toast.LENGTH_LONG).show();

                        }

                    }
                });

    }
}
