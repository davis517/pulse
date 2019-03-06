package com.example.pulse;

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

import java.util.ArrayList;
import  java.util.List;

public class Usernoti extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference ref;
    String blood,hospital,urgency1;
    private ProgressDialog progressDialog;

    FirebaseUser user;



    ArrayList<PostBlood> dataModelsName,dataModelsPhone;
    ListView listView;
    private static CustomAdapter1 adapter;
    Button buttonaccept;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usernoti);

        progressDialog = new ProgressDialog(this);

        listView=(ListView)findViewById(R.id.listview2);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Bloodrequest");

        dataModelsName= new ArrayList<>();
        dataModelsPhone=new ArrayList<>();

        progressDialog.setMessage("1 Sec...Let me grab the new entries also for you!!!");
        progressDialog.show();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    blood = ds.child("blood1").getValue(String.class);
                    hospital = ds.child("hos1").getValue(String.class);
                    urgency1 = ds.child("urgency1").getValue(String.class);




                    dataModelsName.add(new PostBlood(blood,hospital,urgency1));
                    adapter= new CustomAdapter1(dataModelsName,getApplicationContext());
                    listView.setAdapter(adapter);



                }
                progressDialog.dismiss();



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });













    }
}
