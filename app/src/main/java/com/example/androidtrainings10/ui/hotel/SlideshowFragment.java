package com.example.androidtrainings10.ui.hotel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtrainings10.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SlideshowFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        return root;
    }
}