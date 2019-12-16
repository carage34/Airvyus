package com.example.airvyus.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.airvyus.R;

public class SampleTwo extends Fragment {
    public static SampleTwo newInstance() {
        SampleTwo frag = new SampleTwo();
        return(frag);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_simple_two, container, false);
        return result;
    }
}

