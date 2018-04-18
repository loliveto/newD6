package com.example.john.quizsurvey.Views;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditQuestionare#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditQuestionare extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private Questionare questionare;

    public EditQuestionare() {
        // Required empty public constructor
    }


    public static EditQuestionare newInstance(Questionare questionare) {
        EditQuestionare fragment = new EditQuestionare();
        fragment.questionare = questionare;
        return fragment;
    }

    public static EditQuestionare newInstance() {
        EditQuestionare fragment = new EditQuestionare();
        Questionare q = new Questionare();
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
        View view = inflater.inflate(R.layout.fragment_view_quest, container, false);
        final EditText titleText = view.findViewById(R.id.questionare_title);
        titleText.setText(questionare.name);
        Button addQuestion = view.findViewById(R.id.add_question);
        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionare.name = titleText.getText().toString();
                ((MainActivity)getActivity()).toSelectQType(questionare);
            }
        });
        Button save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionare.name = titleText.getText().toString();
                questionare.save();
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });
        Button home = view.findViewById(R.id.go_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toMenu();
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
                ((MainActivity)getActivity()).toViewQuestion(questionare, position);
            }
        });

//        ArrayList<String> ans = questionare.asheet.getCorrectAnswers();
//        ListView listView1 = view.findViewById(R.id.viewanswers);
//        ArrayAdapter adapter1 = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,ans);
//        listView.setAdapter(adapter1);

        return view;
    }

}
