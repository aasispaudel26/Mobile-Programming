package com.example.practial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_1, container, false);

        Button button = rootView.findViewById(R.id.button1);
        button.setOnClickListener(v -> {
            EditText editText = rootView.findViewById(R.id.editTextText1);
            String userInput = editText.getText().toString();

            Bundle result = new Bundle();
            result.putString("data_from_fragment1", userInput);

            getParentFragmentManager().setFragmentResult("request_key", result);

            editText.setText("");
        });

        return rootView;
    }
}
