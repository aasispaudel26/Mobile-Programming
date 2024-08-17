package com.example.practial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class Fragment2 extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_2, container, false);

        Button button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            getParentFragmentManager().setFragmentResultListener("request_key", getViewLifecycleOwner(), (requestKey, result) -> {
                String data = result.getString("data_from_fragment1");
                TextView textView = rootView.findViewById(R.id.changeTxtView);
                textView.setText(data);
            });
        });

        return rootView;
    }
}
