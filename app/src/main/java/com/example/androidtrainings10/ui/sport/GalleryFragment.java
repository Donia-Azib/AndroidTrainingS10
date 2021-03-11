package com.example.androidtrainings10.ui.sport;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidtrainings10.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GalleryFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        return root;
    }
}