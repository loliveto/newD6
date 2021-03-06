package com.example.john.quizsurvey.Views;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
 * A simple {@link Fragment} subclass.
 * Use the {@link EditQuestionare#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditQuestionare extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    private Questionare questionare;
    static boolean isNew;

    public EditQuestionare() {
        // Required empty public constructor
    }


    public static EditQuestionare newInstance(Questionare questionare) {
        EditQuestionare fragment = new EditQuestionare();
        fragment.questionare = questionare;
        isNew = false;
        return fragment;
    }

    public static EditQuestionare newInstance() {
        EditQuestionare fragment = new EditQuestionare();
        Questionare q = new Questionare();
        fragment.questionare = q;
        isNew = true;
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
        final View view = inflater.inflate(R.layout.fragment_view_quest, container, false);
        final EditText titleText = view.findViewById(R.id.questionare_title);
        titleText.setText(questionare.name);

        if(isNew) {
            AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
            alertDialog.setTitle("Create a Questionnaire");
            alertDialog.setMessage("Would you like to create a test or a survey?");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Test",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            questionare.setIsATest(true);
                            dialog.dismiss();
                            TextView answertext = view.findViewById(R.id.answersText);
                            answertext.setVisibility(View.VISIBLE);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Survey",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            questionare.setIsATest(false);

                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
//        if(questionare.isATest()==true){
//            TextView answertext = view.findViewById(R.id.answersText);
//            answertext.setVisibility(View.VISIBLE);
//        }
//        else if(questionare.isATest()==false){
//            TextView answertext = view.findViewById(R.id.answersText);
//            answertext.setVisibility(View.INVISIBLE);
//        }

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
                AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                alertDialog.setTitle("Saved!");
                alertDialog.setMessage("Your questionnaire has been saved!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
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

        ArrayList<String> ans = questionare.asheet.getCorrectAnswers();
        ListView listView1 = view.findViewById(R.id.viewanswers);
        ArrayAdapter adapter1 = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,ans);
        listView1.setAdapter(adapter1);

        if(!questionare.isATest()){
            listView1.setVisibility(View.INVISIBLE);
        }

        return view;
    }

}
