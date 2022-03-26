package com.example.navbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/* *
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class hackathon_frag extends Fragment {
    SearchView searchView;
    RecyclerView recycle;
    MyAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    ArrayList<listLoad> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_all_frag, container, false);
        recycle=v.findViewById(R.id.recycler);
        list=new ArrayList<>();
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getContext());
        recycle.setLayoutManager(manager);
        list = new ArrayList<>();
        loadlist();
        adapter = new MyAdapter(list, getContext());
        recycle.setAdapter(adapter);
        searchView=v.findViewById(R.id.search);






        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                getAdapter().getFilter().filter(newText);
                return false;
            }
        });
        return v;
    }
    private void loadlist() {
        list.add(new listLoad("Aircraft Design Competition", "MIT", "5th Aug, 2021", "Free", "6th Aug, 2021", "11:59 pm", R.mipmap.competiton_1));
        list.add(new listLoad("Ideathon 2021", "BITS, Pilani", "18th Aug, 2021", "Free", "11th Aug, 2021", "11:59 pm", R.mipmap.competition_2));
        list.add(new listLoad("Know Your Galaxy", "Quizzy", "11th Aug, 2021", "Free", "12th Aug, 2021", "11:59 pm", R.mipmap.hackathon_1));
        list.add(new listLoad("ASEAN Green Research", "SCI, Singapore", "31st Aug, 2021", "Free", "1st Sept, 2021", "11:59 pm", R.mipmap.competiton_1));
        list.add(new listLoad("Marketing", "MIT", "8th Aug, 2021", "Free", "8th Aug, 2021", "11:59 pm", R.mipmap.internship_1));
    }

    private MyAdapter getAdapter() {
        return adapter;
    }
    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        MenuItem searchItem= menu.findItem(R.id.search);
        SearchView searchView= (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            });
        } */
}