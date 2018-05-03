package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.ShortQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Laura on 4/25/2018.
 */

public class CreateShortQuestion extends Fragment {
    Questionare questionare;

    public CreateShortQuestion(){
    }

    public static CreateShortQuestion newInstance(Questionare q) {
        CreateShortQuestion fragment = new CreateShortQuestion();
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
        View view =  inflater.inflate(R.layout.fragment_create_short, container, false);
        final EditText prompt = view.findViewById(R.id.longprompt);
        final EditText answer = view.findViewById(R.id.shortanswer);
        Button submit = view.findViewById(R.id.submitshort);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortQuestion question = new ShortQuestion(prompt.getText().toString());
                questionare.addQuestion(question);
                questionare.asheet.addCorrectAnswer(answer.getText().toString());
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });


        return view;
    }
}
