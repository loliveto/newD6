package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.john.quizsurvey.DataModels.MatchQuestion;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;

/**
 * Created by Laura on 4/26/2018.
 */

public class CreateMatchQuestion extends Fragment{
    Questionare questionare;
    int count = 2;
    String ans = "";
    ArrayList<String> match1list = new ArrayList<>();
    ArrayList<String> match2list = new ArrayList<>();

    public CreateMatchQuestion() {
        // Required empty public constructor
    }

    public static CreateMatchQuestion newInstance(Questionare q) {
        CreateMatchQuestion fragment = new CreateMatchQuestion();
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
        View view =  inflater.inflate(R.layout.fragment_create_match, container, false);
        final EditText prompt = view.findViewById(R.id.matchprompt);

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

        final Button submit = view.findViewById(R.id.submitmatch);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatchQuestion question = new MatchQuestion(prompt.getText().toString());
                questionare.addQuestion(question);
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

                int i = 0;
                for(String a:match1list){
                    ans = ans + a + "-" + match2list.get(i) + ", ";
                    i++;
                }
                questionare.asheet.addCorrectAnswer(ans);
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
