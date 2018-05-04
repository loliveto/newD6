package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.TFQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeTFQuestion extends Fragment {

    Questionare questionare;
    Question tfq;
    String name;
    int qNum;

    public TakeTFQuestion() {
        // Required empty public constructor
    }

    public static TakeTFQuestion newInstance(Questionare q, Question qu, String name, int qNum) {
        TakeTFQuestion fragment = new TakeTFQuestion();
        fragment.questionare = q;
        fragment.tfq = qu;
        fragment.name = name;
        fragment.qNum = qNum;
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
        View view = inflater.inflate(R.layout.fragment_take_tf, container, false);

        final TextView titleText = view.findViewById(R.id.QuestionPrompt);
        titleText.setText(tfq.prompt);

        Button submit = view.findViewById(R.id.submitTF);
        final RadioButton tbutton = view.findViewById(R.id.TrueButton);
        final RadioButton fbutton = view.findViewById(R.id.FalseButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbutton.isChecked()) {
                    questionare.asheet.addUserAnswer(name, "True");
                } else if (fbutton.isChecked()) {
                    questionare.asheet.addUserAnswer(name, "False");
                }
                if (questionare.getSize() == qNum + 1) {
                    ((MainActivity) getActivity()).toFinish();
                } else {
                    if (questionare.getQuestion(qNum + 1).type.equals("MC")) {
                        ((MainActivity) getActivity()).toTakeMC(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    } else if (questionare.getQuestion(qNum + 1).type.equals("LQ")) {
                        ((MainActivity) getActivity()).toTakeLQ(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    } else if (questionare.getQuestion(qNum + 1).type.equals("MA")) {
                        ((MainActivity) getActivity()).toTakeMA(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    } else if (questionare.getQuestion(qNum + 1).type.equals("RQ")) {
                        ((MainActivity) getActivity()).toTakeRQ(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    } else if (questionare.getQuestion(qNum + 1).type.equals("SQ")) {
                        ((MainActivity) getActivity()).toTakeSQ(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    } else if (questionare.getQuestion(qNum + 1).type.equals("TF")) {
                        ((MainActivity) getActivity()).toTakeTF(questionare, questionare.getQuestion(qNum + 1), name, qNum + 1);
                    }

                }
            }
        });

        return view;
    }
}
