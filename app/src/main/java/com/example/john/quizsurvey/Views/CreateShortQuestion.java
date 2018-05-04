package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.ShortQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Laura on 4/25/2018.
 */

public class CreateShortQuestion extends Fragment {
    Questionare questionare;
    Question sq;
    static boolean isNew;

    public CreateShortQuestion(){
    }

    public static CreateShortQuestion newInstance(Questionare q) {
        CreateShortQuestion fragment = new CreateShortQuestion();
        fragment.questionare= q;
        isNew = true;
        return fragment;
    }

    public static CreateShortQuestion newInstance(Questionare q, Question qu) {
        CreateShortQuestion fragment = new CreateShortQuestion();
        fragment.questionare= q;
        fragment.sq= qu;
        isNew = false;
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
        if(!isNew) {
            prompt.setText(sq.prompt);
            answer.setText(sq.getOptions().get(0));
        }

        final Button backbutton = view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });

        Button submit = view.findViewById(R.id.submitshort);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNew) {
                    ShortQuestion question = new ShortQuestion(prompt.getText().toString());
                    questionare.addQuestion(question);
                    questionare.asheet.addCorrectAnswer(answer.getText().toString());
                    question.setOption(answer.getText().toString());
                }else{
                    sq.prompt = prompt.getText().toString();
                    questionare.asheet.correctAnswers.set(questionare.questions.indexOf(sq), answer.getText().toString());
                }
                ((MainActivity) getActivity()).toSeeQuestionare(questionare);
            }
        });


        return view;
    }
}

