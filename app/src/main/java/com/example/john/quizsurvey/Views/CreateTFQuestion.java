package com.example.john.quizsurvey.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.TFQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;


public class CreateTFQuestion extends Fragment {

    Questionare questionare;

    public CreateTFQuestion() {
        // Required empty public constructor
    }


    public static CreateTFQuestion newInstance(Questionare q) {
        CreateTFQuestion fragment = new CreateTFQuestion();
        fragment.questionare = q;
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
        View view =  inflater.inflate(R.layout.fragment_create_tfquestion, container, false);

        final EditText prompt = view.findViewById(R.id.TFQuestionPrompt);

        Button submit = view.findViewById(R.id.submitTF);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TFQuestion question = new TFQuestion(prompt.getText().toString());
                questionare.addQuestion(question);
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });

        return view;
    }

}
