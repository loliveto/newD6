package com.example.john.quizsurvey.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menu extends Fragment {


    public Menu() {
        // Required empty public constructor
    }


    public static Menu newInstance() {
        Menu fragment = new Menu();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Button create = view.findViewById(R.id.createButton);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSeeQuestionare();
            }
        });
        Button editQ = view.findViewById(R.id.ViewQuest);
        editQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toViewQuestionares();
            }
        });
        Button takeQ = view.findViewById(R.id.TakeQuest);
        takeQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toTakeQuestionares();
            }
        });
        return view;
    }

}
