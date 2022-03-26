package com.example.navbar.ui.rate;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.navbar.R;
import com.example.navbar.databinding.FragmentHomeBinding;
import com.example.navbar.databinding.FragmentRateBinding;
import com.example.navbar.ui.home.HomeViewModel;

public class RateFragment extends Fragment {

    private RateViewModel rateViewModel;
    private FragmentRateBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        rateViewModel =
                new ViewModelProvider(this).get(RateViewModel.class);

        binding = FragmentRateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.text;
        rateViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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