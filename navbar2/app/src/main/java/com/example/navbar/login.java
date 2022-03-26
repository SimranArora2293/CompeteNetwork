package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {
    EditText mail, pass;
    FirebaseAuth mAuth;
    FirebaseDatabase rootNode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mail= findViewById(R.id.mail1);
        pass= findViewById(R.id.pass1);
        mAuth = FirebaseAuth.getInstance();
        rootNode= FirebaseDatabase.getInstance();
    }
    public void loginusers(View view) {
        String mailtxt, passtxt;
        mailtxt= mail.getText().toString();
        passtxt= pass.getText().toString();

        mAuth.signInWithEmailAndPassword(mailtxt, passtxt)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(),NavbarActivity.class));

                        } else {
                            Toast.makeText(login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}