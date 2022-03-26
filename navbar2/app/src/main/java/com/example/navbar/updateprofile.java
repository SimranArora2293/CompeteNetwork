package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class updateprofile extends AppCompatActivity {
    EditText name, username, mobile, organisation;
    Button btn;
    RadioButton male, female, disclose;
    FirebaseAuth auth;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);
        name= findViewById(R.id.edit1);
        username= findViewById(R.id.edit2);
        mobile= findViewById(R.id.edit4);
        organisation= findViewById(R.id.edit4);
        btn= findViewById(R.id.update);
        auth= FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        reference= database.getReference();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametxt,usernametxt,mobiletxt,organisationtxt;
                nametxt= name.getText().toString();
                usernametxt= username.getText().toString();
                mobiletxt= mobile.getText().toString();
                organisationtxt= organisation.getText().toString();
                String uid= auth.getCurrentUser().getUid();

                reference = reference.child("userTests").child(uid);
                reference.child("name").setValue(nametxt);
                reference.child("username").setValue(usernametxt);
                reference.child("mobile").setValue(mobiletxt);
                reference.child("organisation").setValue(organisationtxt).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(updateprofile.this, "Updated", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),NavbarActivity.class));
                        }
                        else{
                            Toast.makeText(updateprofile.this, "Not updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
    }

}