package com.example.navbar.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navbar.NavbarActivity;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentGalleryBinding;
import com.example.navbar.updateprofile;
import com.example.navbar.userTests;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class GalleryFragment extends Fragment {
    EditText email, name, username, mobile, organisation;
    Button btn;
    FirebaseAuth auth;
    DatabaseReference reference;
    DrawerLayout drawerLayout;
    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        View v= inflater.inflate(R.layout.fragment_gallery,container,false);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        name = root.findViewById(R.id.edit1);

        name.setEnabled(false);
        username = root.findViewById(R.id.edit2);
        username.setEnabled(false);
        email = root.findViewById(R.id.edit3);
        email.setEnabled(false);
        mobile = root.findViewById(R.id.edit4);
        mobile.setEnabled(false);
        organisation = root.findViewById(R.id.edit5);
        organisation.setEnabled(false);
        btn= root.findViewById(R.id.update);
        auth = FirebaseAuth.getInstance();

        drawerLayout= root.findViewById(R.id.drawer_layout);

        String uid= auth.getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("userTests").child(uid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userTests u= snapshot.getValue(userTests.class);

                name.setText(u.getName());
                username.setText(u.getUsername());
                email.setText(u.getEmail());
                mobile.setText(u.getMobile());
                organisation.setText(u.getOrganisation());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Not working"+error, Toast.LENGTH_SHORT).show();
            }

        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),updateprofile.class));
            }
        });

        final TextView textView = binding.textHome;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}