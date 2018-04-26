package com.example.john.quizsurvey.Views;

import com.example.john.quizsurvey.DataModels.Questionare;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.LongQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Nicole on 4/26/2018.
 */

public class CreateLongQuestion extends Fragment{

        Questionare questionare;

    public CreateLongQuestion(){
    }

    public static CreateLongQuestion newInstance(Questionare q) {
        CreateLongQuestion fragment = new CreateLongQuestion();
        fragment.questionare= q;
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
        View view =  inflater.inflate(R.layout.fragment_create_long, container, false);
        final EditText prompt = view.findViewById(R.id.prompt);
       // final EditText answer = view.findViewById(R.id.shortanswer);
        Button submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LongQuestion question = new LongQuestion(prompt.getText().toString());
                questionare.addQuestion(question);
                //questionare.asheet.addCorrectAnswer(answer.getText().toString());
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });


        return view;
    }
}
