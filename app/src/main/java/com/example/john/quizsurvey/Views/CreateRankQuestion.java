package com.example.john.quizsurvey.Views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.MCQuestion;
import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.RankQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;

/**
 * Created by Laura on 4/25/2018.
 */

public class CreateRankQuestion extends Fragment {
    Questionare questionare;
    Question rq;
    int count = 2;
    String ans = "";
    ArrayList<String> anslist = new ArrayList<>();
    static boolean isNew;

    public CreateRankQuestion() {
        // Required empty public constructor
    }

    public static CreateRankQuestion newInstance(Questionare q) {
        CreateRankQuestion fragment = new CreateRankQuestion();
        fragment.questionare = q;
        isNew = true;
        return fragment;
    }
    public static CreateRankQuestion newInstance(Questionare q, Question qu) {
        CreateRankQuestion fragment = new CreateRankQuestion();
        fragment.questionare = q;
        fragment.rq = qu;
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
        View view =  inflater.inflate(R.layout.fragment_create_rank, container, false);
        final EditText prompt = view.findViewById(R.id.rankprompt);
        if (!isNew) {
            prompt.setText(rq.prompt);
        }

        final Button option = (Button) view.findViewById(R.id.rankadd);
        final Button removeOpt = view.findViewById(R.id.rankremove);
        final EditText rank1 = view.findViewById(R.id.rank1);
        final EditText rank2 = view.findViewById(R.id.rank2);
        final EditText rank3 = view.findViewById(R.id.rank3);
        final EditText rank4 = view.findViewById(R.id.rank4);
        final EditText rank5 = view.findViewById(R.id.rank5);
        final EditText rank6 = view.findViewById(R.id.rank6);

        if (!isNew) {
            rank1.setText(rq.getOptions().get(0));
            rank2.setText(rq.getOptions().get(1));
            rank3.setText(rq.getOptions().get(2));
            if (!rq.getOptions().get(2).equals("")) {
                rank3.setVisibility(View.VISIBLE);
                removeOpt.setVisibility(View.VISIBLE);
                count = 3;
            }
            rank4.setText(rq.getOptions().get(3));
            if (!rq.getOptions().get(3).equals("")) {
                rank4.setVisibility(View.VISIBLE);
                count = 4;
            }
            rank5.setText(rq.getOptions().get(4));
            if (!rq.getOptions().get(4).equals("")) {
                rank5.setVisibility(View.VISIBLE);
                rank5.setVisibility(View.VISIBLE);
                count = 5;
            }
            rank6.setText(rq.getOptions().get(5));
            if (!rq.getOptions().get(5).equals("")) {
                rank6.setVisibility(View.VISIBLE);
                option.setVisibility(View.INVISIBLE);
                count = 6;
            }
        }

        final Button backbutton = view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });

        final Button submit = view.findViewById(R.id.ranksubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RankQuestion question = new RankQuestion(prompt.getText().toString());
                if (isNew) {
                    questionare.addQuestion(question);
                } else {
                    rq.prompt = prompt.getText().toString();
                }
                if (isNew) {
                    anslist.add(rank6.getText().toString());
                    anslist.add(rank5.getText().toString());
                    anslist.add(rank4.getText().toString());
                    anslist.add(rank3.getText().toString());
                    anslist.add(rank2.getText().toString());
                    anslist.add(rank1.getText().toString());

                    question.setOption(rank1.getText().toString());
                    question.setOption(rank2.getText().toString());
                    question.setOption(rank3.getText().toString());
                    question.setOption(rank4.getText().toString());
                    question.setOption(rank5.getText().toString());
                    question.setOption(rank6.getText().toString());
                } else {
                    anslist.clear();
                    anslist.add(rank6.getText().toString());
                    anslist.add(rank5.getText().toString());
                    anslist.add(rank4.getText().toString());
                    anslist.add(rank3.getText().toString());
                    anslist.add(rank2.getText().toString());
                    anslist.add(rank1.getText().toString());

                    question.options.clear();
                    question.setOption(rank1.getText().toString());
                    question.setOption(rank2.getText().toString());
                    question.setOption(rank3.getText().toString());
                    question.setOption(rank4.getText().toString());
                    question.setOption(rank5.getText().toString());
                    question.setOption(rank6.getText().toString());
                }

                for(String a:anslist){
                    if(a!="") {
                        ans = a + ", " + ans;
                    }
                }

                if(isNew){
                    questionare.asheet.addCorrectAnswer(ans);
                }else {
                    questionare.asheet.correctAnswers.set(questionare.questions.indexOf(rq), ans);
                }
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);

            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==2){
                    rank3.setVisibility(View.VISIBLE);
                    removeOpt.setVisibility(View.VISIBLE);
                    count=3;
                }
                else if(count==3){
                    rank4.setVisibility(View.VISIBLE);
                    count=4;
                }
                else if(count==4){
                    rank5.setVisibility(View.VISIBLE);
                    count=5;
                }
                else if(count==5){
                    rank6.setVisibility(View.VISIBLE);
                    option.setVisibility(View.INVISIBLE);
                    count=6;
                }
            }
        });
        removeOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==3){
                    rank3.setVisibility(View.INVISIBLE);
                    rank3.setText("");
                    removeOpt.setVisibility(View.INVISIBLE);
                    count=2;
                }
                else if(count==4){
                    rank4.setVisibility(View.INVISIBLE);
                    rank4.setText("");
                    count=3;
                }
                else if(count==5){
                    rank5.setVisibility(View.INVISIBLE);
                    rank5.setText("");
                    count=4;
                }
                else if(count==6){
                    rank6.setVisibility(View.INVISIBLE);
                    rank6.setText("");
                    option.setVisibility(View.VISIBLE);
                    count=5;
                }
            }
        });
        return view;
    }
}
