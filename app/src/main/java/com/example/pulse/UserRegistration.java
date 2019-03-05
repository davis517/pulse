package com.example.pulse;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class UserRegistration extends AppCompatActivity {


    String Name,Age,Email,Password,Phone;
    EditText Nametyped,Agetyped,Emailtyped,Passwordtyped,Phonetyped;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        Nametyped=(EditText)findViewById(R.id.editText5);
        Agetyped=(EditText)findViewById(R.id.editText6);
        Emailtyped=(EditText)findViewById(R.id.editText7);
        Passwordtyped=(EditText)findViewById(R.id.editText9);
        Phonetyped=(EditText)findViewById(R.id.editText8);

        final String Name = Nametyped.getText().toString().trim();
        final String Age = Agetyped.getText().toString().trim();
        final String Email = Emailtyped.getText().toString().trim();
        final String Password = Passwordtyped.getText().toString().trim();
        final String Phone = Phonetyped.getText().toString().trim();


        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user=new User(Name,Age,Phone);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Intent intent = new Intent(UserRegistration.this, UserLogin.class);
                                        startActivity(intent);

                                    }else{
                                        Toast.makeText(UserRegistration.this,"Registration Error",Toast.LENGTH_LONG).show();
                                    }

                                }
                            });

                        }

                    }
                });

    }
}

