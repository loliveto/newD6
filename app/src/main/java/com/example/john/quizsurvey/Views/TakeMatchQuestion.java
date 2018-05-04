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
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeMatchQuestion extends Fragment {

    Questionare questionare;
    Question maq;
    String name;
    int qNum;

    public TakeMatchQuestion() {
        // Required empty public constructor
    }

    public static TakeMatchQuestion newInstance(Questionare q, Question qu, String name, int qNum) {
        TakeMatchQuestion fragment = new TakeMatchQuestion();
        fragment.questionare = q;
        fragment.maq = qu;
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
        View view = inflater.inflate(R.layout.fragment_take_match, container, false);

        final TextView titleText = view.findViewById(R.id.matchprompt);
        titleText.setText(maq.prompt);

        final TextView match11 = view.findViewById(R.id.match11);
        final TextView match12 = view.findViewById(R.id.match12);
        final TextView match21 = view.findViewById(R.id.match21);
        final TextView match22 = view.findViewById(R.id.match22);
        final TextView match31 = view.findViewById(R.id.match31);
        final TextView match32 = view.findViewById(R.id.match32);
        final TextView match41 = view.findViewById(R.id.match41);
        final TextView match42 = view.findViewById(R.id.match42);
        final TextView match51 = view.findViewById(R.id.match51);
        final TextView match52 = view.findViewById(R.id.match52);
        final TextView match61 = view.findViewById(R.id.match61);
        final TextView match62 = view.findViewById(R.id.match62);


        match11.setText(maq.getOptions().get(0));
        match21.setText(maq.getOptions().get(1));
        match31.setText(maq.getOptions().get(2));
        if (!maq.getOptions().get(2).equals("")) {
            match31.setVisibility(View.VISIBLE);
            match32.setVisibility(View.VISIBLE);
        }
        match41.setText(maq.getOptions().get(3));
        if (!maq.getOptions().get(3).equals("")) {
            match41.setVisibility(View.VISIBLE);
            match42.setVisibility(View.VISIBLE);
        }
        match51.setText(maq.getOptions().get(4));
        if (!maq.getOptions().get(4).equals("")) {
            match51.setVisibility(View.VISIBLE);
            match51.setVisibility(View.VISIBLE);
        }
        match61.setText(maq.getOptions().get(5));
        if (!maq.getOptions().get(5).equals("")) {
            match61.setVisibility(View.VISIBLE);
            match61.setVisibility(View.VISIBLE);
        }



        final Button submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionare.asheet.addUserAnswer(name,"");


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
