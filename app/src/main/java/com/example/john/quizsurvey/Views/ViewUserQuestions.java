package com.example.john.quizsurvey.Views;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;

/**
 * Created by Caroline Squillante on 5/4/2018.
 */

public class ViewUserQuestions extends Fragment {


    private ListView listView;
    Questionare questionare;
    String name;
    public ViewUserQuestions() {
        // Required empty public constructor
    }

    public static ViewUserQuestions newInstance(String name, Questionare q) {
        ViewUserQuestions fragment = new ViewUserQuestions();
        fragment.name = name;
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
        final View view = inflater.inflate(R.layout.fragment_user_answers, container, false);
        final TextView titleText = view.findViewById(R.id.username);
        titleText.setText(name);

        Button home = view.findViewById(R.id.go_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toMenu();
            }
        });

        Button back = view.findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toViewAllQuestsForUser();
            }
        });



        ArrayList<String> prompts = questionare.getQuestionPrompt();
        ListView listView = view.findViewById(R.id.question_list);
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,prompts);
        listView.setAdapter(adapter);
        //check to see waht kind of question it is first
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //trying
                if(questionare.getQuestion(position).type.equals("MC")){
                    ((MainActivity)getActivity()).toCreateMC(questionare, questionare.getQuestion(position));
                }else if(questionare.getQuestion(position).type.equals("TF")){
                    ((MainActivity)getActivity()).toCreateTF(questionare, questionare.getQuestion(position));
                }else if(questionare.getQuestion(position).type.equals("SQ")){
                    ((MainActivity)getActivity()).toCreateShort(questionare, questionare.getQuestion(position));
                }else if(questionare.getQuestion(position).type.equals("RQ")){
                    ((MainActivity)getActivity()).toCreateRank(questionare, questionare.getQuestion(position));
                }else if(questionare.getQuestion(position).type.equals("MA")){
                    ((MainActivity)getActivity()).toCreateMatch(questionare, questionare.getQuestion(position));
                }
                //trying
                else {
                    ((MainActivity) getActivity()).toViewQuestion(questionare, position);
                }
            }
        });

        ArrayList<String> ans = questionare.asheet.getUserAnswers(name);
        ListView listView1 = view.findViewById(R.id.viewanswers);
        ArrayAdapter adapter1 = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,ans);
        listView1.setAdapter(adapter1);


        return view;
    }




}
