package com.example.navbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Filterable;
import android.widget.SearchView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tab;
    // SearchView searchView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.frame, new all_frag()).commit();
     /*  searchView=findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        }); */
        tab = findViewById(R.id.tabs);

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment frag = new all_frag();
                if (tab.getPosition()==0)
                    frag=new all_frag();
                else if (tab.getPosition()==1)
                    frag=new hackathon_frag();
                else if (tab.getPosition()==2)
                    frag=new internship_frag();
                else if (tab.getPosition()==3)
                    frag=new competition_frag();
                else if (tab.getPosition()==4)
                    frag= new quiz_frag();
                else if (tab.getPosition()==5)
                    frag= new job_frag();
                else if (tab.getPosition()==6)
                    frag= new scholarship_frag();
                else if (tab.getPosition()==7)
                    frag= new workshop_frag();
                else if (tab.getPosition()==8)
                    frag= new conference_frag();
                else if (tab.getPosition()==9)
                    frag= new festival_frag();
                getSupportFragmentManager().beginTransaction().add(R.id.frame, frag).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}