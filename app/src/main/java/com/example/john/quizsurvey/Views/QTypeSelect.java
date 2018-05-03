package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Laura on 4/18/2018.
 */

public class QTypeSelect extends Fragment{
    Questionare q;

    public QTypeSelect() {
        // Required empty public constructor
    }


    public static QTypeSelect newInstance(Questionare q) {
        QTypeSelect fragment = new QTypeSelect();
        fragment.q = q;
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
        View view = inflater.inflate(R.layout.fragment_selectqtype, container, false);

        Button mcbutton = view.findViewById(R.id.mcbutton);
        mcbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toCreateMC(q);
            }
        });

        Button tfbutton = view.findViewById(R.id.tfbutton);
        tfbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toCreateTF(q);
            }
        });

        Button shortbutton = view.findViewById(R.id.shortansbutton);
        shortbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toCreateShort(q);
            }
        });

        Button rankbutton = view.findViewById(R.id.rankbutton);
        rankbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toCreateRank(q);
            }
        });

        Button matchbutton = view.findViewById(R.id.matchbutton);
        matchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toCreateMatch(q);
            }
        });

        return view;
    }
}
