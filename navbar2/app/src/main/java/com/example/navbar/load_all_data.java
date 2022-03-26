package com.example.navbar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class load_all_data extends AppCompatActivity {
String name, comp, dead, fees, date, tym;
int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_all_data);
        name = getIntent().getExtras().getString("key2");
        comp = getIntent().getExtras().getString("key3");
        img = getIntent().getExtras().getInt("key10");
        dead = getIntent().getExtras().getString("key4");
        fees = getIntent().getExtras().getString("key6");
        date = getIntent().getExtras().getString("key8");
        tym = getIntent().getExtras().getString("key9");
    }
}