package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.MatchQuestion;
import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;

/**
 * Created by Laura on 4/26/2018.
 */

public class CreateMatchQuestion extends Fragment{
    Questionare questionare;
    Question mq;
    int count = 2;
    String ans = "";
    ArrayList<String> match1list = new ArrayList<>();
    ArrayList<String> match2list = new ArrayList<>();
    static boolean isNew;

    public CreateMatchQuestion() {
        // Required empty public constructor
    }

    public static CreateMatchQuestion newInstance(Questionare q) {
        CreateMatchQuestion fragment = new CreateMatchQuestion();
        fragment.questionare = q;
        isNew = true;
        return fragment;
    }

    public static CreateMatchQuestion newInstance(Questionare q, Question qu) {
        CreateMatchQuestion fragment = new CreateMatchQuestion();
        fragment.questionare = q;
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
        View view =  inflater.inflate(R.layout.fragment_create_match, container, false);
        final EditText prompt = view.findViewById(R.id.matchprompt);
        if (!isNew) {
            prompt.setText(mq.prompt);
        }

        final Button option = view.findViewById(R.id.addmatch);
        final Button removeOpt = view.findViewById(R.id.removematch);
        final EditText match11 = view.findViewById(R.id.match11);
        final EditText match12 = view.findViewById(R.id.match12);
        final EditText match21 = view.findViewById(R.id.match21);
        final EditText match22 = view.findViewById(R.id.match22);
        final EditText match31 = view.findViewById(R.id.match31);
        final EditText match32 = view.findViewById(R.id.match32);
        final EditText match41 = view.findViewById(R.id.match41);
        final EditText match42 = view.findViewById(R.id.match42);
        final EditText match51 = view.findViewById(R.id.match51);
        final EditText match52 = view.findViewById(R.id.match52);
        final EditText match61 = view.findViewById(R.id.match61);
        final EditText match62 = view.findViewById(R.id.match62);

        final Button backbutton = view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });

        if (!isNew) {
            String[] temp;
            temp = mq.getOptions().get(0).split("-");
            match11.setText(temp[0]);
            match12.setText(temp[1]);

            temp = mq.getOptions().get(1).split("-");
            match21.setText(temp[0]);
            match22.setText(temp[1]);

            temp = mq.getOptions().get(2).split("-");
            match31.setText(temp[0]);
            match32.setText(temp[1]);
            if (!mq.getOptions().get(2).equals("-")) {
                match31.setVisibility(View.VISIBLE);
                match32.setVisibility(View.VISIBLE);
                removeOpt.setVisibility(View.VISIBLE);
                count = 3;
            }
            temp = mq.getOptions().get(3).split("-");
            match41.setText(temp[0]);
            match42.setText(temp[1]);
            if (!mq.getOptions().get(3).equals("-")) {
                match41.setVisibility(View.VISIBLE);
                match42.setVisibility(View.VISIBLE);
                count = 4;
            }
            temp = mq.getOptions().get(4).split("-");
            match51.setText(temp[0]);
            match52.setText(temp[1]);
            if (!mq.getOptions().get(4).equals("-")) {
                match51.setVisibility(View.VISIBLE);
                match52.setVisibility(View.VISIBLE);
                count = 5;
            }
            temp = mq.getOptions().get(5).split("-");
            match61.setText(temp[0]);
            match62.setText(temp[1]);
            if (!mq.getOptions().get(5).equals("-")) {
                match61.setVisibility(View.VISIBLE);
                match62.setVisibility(View.VISIBLE);
                count = 6;
            }
        }

        final Button submit = view.findViewById(R.id.submitmatch);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchQuestion question = new MatchQuestion(prompt.getText().toString());
                if(isNew) {
                    questionare.addQuestion(question);
                }else{
                    mq.prompt = prompt.getText().toString();
                }

                if(isNew) {
                    match1list.add(match11.getText().toString());
                    match1list.add(match21.getText().toString());
                    match1list.add(match31.getText().toString());
                    match1list.add(match41.getText().toString());
                    match1list.add(match51.getText().toString());
                    match1list.add(match61.getText().toString());
                    match2list.add(match12.getText().toString());
                    match2list.add(match22.getText().toString());
                    match2list.add(match32.getText().toString());
                    match2list.add(match42.getText().toString());
                    match2list.add(match52.getText().toString());
                    match2list.add(match62.getText().toString());
                }else{
                    match1list.clear();
                    match2list.clear();
                    match1list.add(match11.getText().toString());
                    match1list.add(match21.getText().toString());
                    match1list.add(match31.getText().toString());
                    match1list.add(match41.getText().toString());
                    match1list.add(match51.getText().toString());
                    match1list.add(match61.getText().toString());
                    match2list.add(match12.getText().toString());
                    match2list.add(match22.getText().toString());
                    match2list.add(match32.getText().toString());
                    match2list.add(match42.getText().toString());
                    match2list.add(match52.getText().toString());
                    match2list.add(match62.getText().toString());
                }

                int i = 0;
                for(String a:match1list){
                    ans = ans + a + "-" + match2list.get(i) + ", ";
                    question.setOption(a + "-" + match2list.get(i));
                    i++;
                }
                if(isNew) {
                    questionare.asheet.addCorrectAnswer(ans);
                }else{
                    questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mq), ans);
                }
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);

            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==2){
                    match31.setVisibility(View.VISIBLE);
                    match32.setVisibility(View.VISIBLE);
                    removeOpt.setVisibility(View.VISIBLE);
                    count=3;
                }
                else if(count==3){
                    match41.setVisibility(View.VISIBLE);
                    match42.setVisibility(View.VISIBLE);
                    count=4;
                }
                else if(count==4){
                    match51.setVisibility(View.VISIBLE);
                    match52.setVisibility(View.VISIBLE);
                    count=5;
                }
                else if(count==5){
                    match61.setVisibility(View.VISIBLE);
                    match62.setVisibility(View.VISIBLE);
                    option.setVisibility(View.INVISIBLE);
                    count=6;
                }
            }
        });
        removeOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==3){
                    match31.setVisibility(View.INVISIBLE);
                    match31.setText("");
                    match32.setVisibility(View.INVISIBLE);
                    match32.setText("");
                    removeOpt.setVisibility(View.INVISIBLE);
                    count=2;
                }
                else if(count==4){
                    match41.setVisibility(View.INVISIBLE);
                    match41.setText("");
                    match42.setVisibility(View.INVISIBLE);
                    match42.setText("");
                    count=3;
                }
                else if(count==5){
                    match51.setVisibility(View.INVISIBLE);
                    match51.setText("");
                    match52.setVisibility(View.INVISIBLE);
                    match52.setText("");
                    count=4;
                }
                else if(count==6){
                    match61.setVisibility(View.INVISIBLE);
                    match61.setText("");
                    match62.setVisibility(View.INVISIBLE);
                    match62.setText("");
                    option.setVisibility(View.VISIBLE);
                    count=5;
                }
            }
        });
        return view;
    }

}
