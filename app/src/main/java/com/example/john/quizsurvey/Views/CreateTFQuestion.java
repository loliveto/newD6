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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.TFQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;


public class CreateTFQuestion extends Fragment {

    Questionare questionare;
    Question tfq;
    static boolean isNew;

    public CreateTFQuestion() {
        // Required empty public constructor
    }

    public static CreateTFQuestion newInstance(Questionare q) {
        CreateTFQuestion fragment = new CreateTFQuestion();
        fragment.questionare = q;
        isNew = true;
        return fragment;
    }
    public static CreateTFQuestion newInstance(Questionare q, Question qu) {
        CreateTFQuestion fragment = new CreateTFQuestion();
        fragment.questionare = q;
        fragment.tfq = qu;
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
        View view =  inflater.inflate(R.layout.fragment_create_tfquestion, container, false);

        final EditText prompt = view.findViewById(R.id.TFQuestionPrompt);
        if(!isNew) {
            prompt.setText(tfq.prompt);
        }

        Button submit = view.findViewById(R.id.submitTF);
        final RadioButton tbutton = view.findViewById(R.id.TrueButton);
        final RadioButton fbutton = view.findViewById(R.id.FalseButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean optSelected = true;

                if(isNew) {
//                    TFQuestion question = new TFQuestion(prompt.getText().toString());
//                    questionare.addQuestion(question);
                    if (tbutton.isChecked()&& !prompt.getText().toString().isEmpty()) {
                        questionare.asheet.addCorrectAnswer("True");
                    }else if (fbutton.isChecked()&&!prompt.getText().toString().isEmpty()) {
                        questionare.asheet.addCorrectAnswer("False");
                    }
                    else if(tbutton.isChecked() || fbutton.isChecked()){
                        optSelected = true;
                    }
                    else{
                        optSelected = false;
                    }
                }else{
                    tfq.prompt = prompt.getText().toString();
                    if (tbutton.isChecked()&&!prompt.getText().toString().isEmpty()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(tfq), "True");
                    }else if (fbutton.isChecked()&&!prompt.getText().toString().isEmpty()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(tfq), "False");
                    }
                    else if(tbutton.isChecked() || fbutton.isChecked()){
                        optSelected = true;
                    }
                    else{
                        optSelected = false;
                    }
                }
                if(optSelected==false && questionare.isATest()==true){
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage("You must select a correct answer");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else if(prompt.getText().toString().isEmpty()){
                        AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("You must enter a prompt");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                else{
                    if(isNew){
                        TFQuestion question = new TFQuestion(prompt.getText().toString());
                        questionare.addQuestion(question);
                    }
                    ((MainActivity) getActivity()).toSeeQuestionare(questionare);

                }


            }
        });


        return view;
    }

}
