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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {
    EditText mail, pass, name;
    Button btn,btn1;
    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name1);
        mail = findViewById(R.id.mail1);
        pass = findViewById(R.id.pass1);
        btn = findViewById(R.id.loginopen1);
        btn1= findViewById(R.id.organize);
        mAuth = FirebaseAuth.getInstance();
        rootNode = FirebaseDatabase.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),adminevents.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });
    }
        public void registerUsers (View view){
            String mailtxt, passtxt, nametxt;
            nametxt = name.getText().toString();
            mailtxt = mail.getText().toString();
            passtxt = pass.getText().toString();


            mAuth.createUserWithEmailAndPassword(mailtxt, passtxt)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                savetodatabase();
                            } else {
                                Toast.makeText(signup.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

        void savetodatabase() {
            String mailtxt, passtxt, nametxt;
            mailtxt = mail.getText().toString();
            passtxt = pass.getText().toString();
            nametxt= name.getText().toString();


            String userid = mAuth.getCurrentUser().getUid();
            DatabaseReference ref = rootNode.getReference("userTests").child(userid);
            userTests u = new userTests(mailtxt, passtxt, nametxt, "", "", "");
            ref.setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(signup.this, "Data Stored", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),NavbarActivity.class));
                    } else {
                        Toast.makeText(signup.this, "Failed in storing data", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
}