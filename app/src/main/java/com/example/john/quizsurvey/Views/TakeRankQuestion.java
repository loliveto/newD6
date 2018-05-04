package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeRankQuestion extends Fragment {

    Questionare questionare;
    Question raq;
    String name;
    int qNum;
    ArrayList<String> anslist = new ArrayList<>();

    public TakeRankQuestion() {
        // Required empty public constructor
    }

    public static TakeRankQuestion newInstance(Questionare q, Question qu, String name, int qNum) {
        TakeRankQuestion fragment = new TakeRankQuestion();
        fragment.questionare = q;
        fragment.raq = qu;
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
        View view = inflater.inflate(R.layout.fragment_take_rank, container, false);

        final TextView titleText = view.findViewById(R.id.rankprompt);
        titleText.setText(raq.prompt);

        final TextView rank1 = view.findViewById(R.id.rank1);
        final TextView rank2 = view.findViewById(R.id.rank2);
        final TextView rank3 = view.findViewById(R.id.rank3);
        final TextView rank4 = view.findViewById(R.id.rank4);
        final TextView rank5 = view.findViewById(R.id.rank5);
        final TextView rank6 = view.findViewById(R.id.rank6);
        final EditText ranktx1 = view.findViewById(R.id.ranktx1);
        final EditText ranktx2 = view.findViewById(R.id.ranktx2);
        final EditText ranktx3 = view.findViewById(R.id.ranktx3);
        final EditText ranktx4 = view.findViewById(R.id.ranktx4);
        final EditText ranktx5 = view.findViewById(R.id.ranktx5);
        final EditText ranktx6 = view.findViewById(R.id.ranktx6);


        rank1.setText(raq.getOptions().get(0));
        rank2.setText(raq.getOptions().get(1));
        rank3.setText(raq.getOptions().get(2));
        if (!raq.getOptions().get(2).equals("")) {
            rank3.setVisibility(View.VISIBLE);
            ranktx3.setVisibility(View.VISIBLE);
        }
        rank4.setText(raq.getOptions().get(3));
        if (!raq.getOptions().get(3).equals("")) {
            rank4.setVisibility(View.VISIBLE);
            ranktx4.setVisibility(View.VISIBLE);
        }
        rank5.setText(raq.getOptions().get(4));
        if (!raq.getOptions().get(4).equals("")) {
            rank5.setVisibility(View.VISIBLE);
            ranktx5.setVisibility(View.VISIBLE);
        }
        rank6.setText(raq.getOptions().get(5));
        if (!raq.getOptions().get(5).equals("")) {
            rank6.setVisibility(View.VISIBLE);
            ranktx6.setVisibility(View.VISIBLE);
        }

        final Button submit = view.findViewById(R.id.submitMC);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                anslist.add(ranktx1.getText().toString());
                anslist.add(ranktx2.getText().toString());
                anslist.add(ranktx3.getText().toString());
                anslist.add(ranktx4.getText().toString());
                anslist.add(ranktx5.getText().toString());
                anslist.add(ranktx6.getText().toString());

                String ans = "";
                for(String a:anslist){
                    if(a!="") {
                        ans = a + ", " + ans;
                    }
                }
                questionare.asheet.addCorrectAnswer(ans);
                questionare.asheet.addUserAnswer(name, ans);

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
