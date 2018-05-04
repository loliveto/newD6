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

import com.example.john.quizsurvey.DataModels.MCQuestion;
import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeMCQuestion extends Fragment {

    Questionare questionare;
    Question mcq;
    String name;
    int qNum;

    public TakeMCQuestion() {
        // Required empty public constructor
    }

    public static TakeMCQuestion newInstance(Questionare q, Question qu, String name, int qNum) {
        TakeMCQuestion fragment = new TakeMCQuestion();
        fragment.questionare = q;
        fragment.mcq = qu;
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
        View view = inflater.inflate(R.layout.fragment_take_mc, container, false);

        final TextView titleText = view.findViewById(R.id.mcPrompt);
        titleText.setText(mcq.prompt);

        final RadioButton mcOption1 = view.findViewById(R.id.mcOption1);
        final RadioButton mcOption2 = view.findViewById(R.id.mcOption2);
        final RadioButton mcOption3 = view.findViewById(R.id.mcOption3);
        final RadioButton mcOption4 = view.findViewById(R.id.mcOption4);
        final RadioButton mcOption5 = view.findViewById(R.id.mcOption5);
        final RadioButton mcOption6 = view.findViewById(R.id.mcOption6);
        final EditText mcText1 = view.findViewById(R.id.mcText1);
        final EditText mcText2 = view.findViewById(R.id.mcText2);
        final EditText mcText3 = view.findViewById(R.id.mcText3);
        final EditText mcText4 = view.findViewById(R.id.mcText4);
        final EditText mcText5 = view.findViewById(R.id.mcText5);
        final EditText mcText6 = view.findViewById(R.id.mcText6);


            mcText1.setText(mcq.getOptions().get(0));
            mcText2.setText(mcq.getOptions().get(1));
            mcText3.setText(mcq.getOptions().get(2));
            if (!mcq.getOptions().get(2).equals("")) {
                mcOption3.setVisibility(View.VISIBLE);
                mcText3.setVisibility(View.VISIBLE);
            }
            mcText4.setText(mcq.getOptions().get(3));
            if (!mcq.getOptions().get(3).equals("")) {
                mcOption4.setVisibility(View.VISIBLE);
                mcText4.setVisibility(View.VISIBLE);
            }
            mcText5.setText(mcq.getOptions().get(4));
            if (!mcq.getOptions().get(4).equals("")) {
                mcOption5.setVisibility(View.VISIBLE);
                mcText5.setVisibility(View.VISIBLE);
            }
            mcText6.setText(mcq.getOptions().get(5));
            if (!mcq.getOptions().get(5).equals("")) {
                mcOption6.setVisibility(View.VISIBLE);
                mcText6.setVisibility(View.VISIBLE);
            }



        final Button submit = view.findViewById(R.id.submitMC);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mcOption1.isChecked()) {
                    questionare.asheet.addUserAnswer(name, mcText1.getText().toString());
                } else if (mcOption2.isChecked()) {
                    questionare.asheet.addUserAnswer(name, mcText2.getText().toString());
                } else if (mcOption3.isChecked()) {
                    questionare.asheet.addUserAnswer(name, mcText3.getText().toString());
                } else if (mcOption4.isChecked()) {
                    questionare.asheet.addUserAnswer(name, mcText4.getText().toString());
                } else if (mcOption5.isChecked()) {
                    questionare.asheet.addUserAnswer(name, mcText5.getText().toString());
                } else if (mcOption6.isChecked()) {
                    questionare.asheet.addUserAnswer(name,mcText6.getText().toString());
                }

                if (questionare.getSize() == qNum + 1) {
                    questionare.save();
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
