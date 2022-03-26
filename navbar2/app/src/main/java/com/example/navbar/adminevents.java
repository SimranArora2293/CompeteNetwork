package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class adminevents extends AppCompatActivity {
EditText eventtype,eventname,companyname,time,date,fees,lastdate;

FirebaseAuth mAuth;
FirebaseDatabase rootNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminevents);

        eventtype= findViewById(R.id.name1);
        eventname= findViewById(R.id.name2);
        companyname= findViewById(R.id.name3);
        time= findViewById(R.id.name4);
        date= findViewById(R.id.name5);
        fees= findViewById(R.id.name6);
        lastdate= findViewById(R.id.name7);

        mAuth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();
    }

    public void eventDetails(View view) {
        String eventtypetxt,eventnametxt,companynametxt,timetxt,datetxt,feestxt,lastdatetxt;

        eventtypetxt= eventtype.getText().toString();
        eventnametxt= eventname.getText().toString();
        companynametxt= companyname.getText().toString();
        timetxt= time.getText().toString();
        datetxt= date.getText().toString();
        feestxt= fees.getText().toString();
        lastdatetxt= lastdate.getText().toString();

        String userid= mAuth.getCurrentUser().getUid();
        DatabaseReference ref = rootNode.getReference("userEvents").child(userid);
        userEvents u1 = new userEvents(eventtypetxt, eventnametxt, companynametxt, timetxt, datetxt, feestxt,lastdatetxt);
        ref.setValue(u1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(adminevents.this, "Data Stored", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),approval.class));
                } else {
                    Toast.makeText(adminevents.this, "Failed in storing data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}