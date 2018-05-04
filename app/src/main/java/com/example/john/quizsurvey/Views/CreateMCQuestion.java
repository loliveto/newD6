package com.example.john.quizsurvey.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.DataModels.MCQuestion;
import com.example.john.quizsurvey.DataModels.TFQuestion;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

/**
 * Created by Test on 4/18/2018.
 */

public class CreateMCQuestion extends Fragment {

    Questionare questionare;
    Question mcq;
    int count = 2;
    static boolean isNew;

    public CreateMCQuestion() {
        // Required empty public constructor
    }

    public static CreateMCQuestion newInstance(Questionare q) {
        CreateMCQuestion fragment = new CreateMCQuestion();
        fragment.questionare = q;
        isNew = true;
        return fragment;
    }

    public static CreateMCQuestion newInstance(Questionare q, Question qu) {
        CreateMCQuestion fragment = new CreateMCQuestion();
        fragment.questionare = q;
        fragment.mcq = qu;
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
        View view = inflater.inflate(R.layout.create_mcquestion, container, false);

        final EditText prompt = view.findViewById(R.id.mcprompt);
        if (!isNew) {
            prompt.setText(mcq.prompt);
        }

        final Button backbutton = view.findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });

        final Button option = (Button) view.findViewById(R.id.addOption);
        final Button removeOpt = view.findViewById(R.id.removeOption);
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

        if (!isNew) {
            mcText1.setText(mcq.getOptions().get(0));
            mcText2.setText(mcq.getOptions().get(1));
            mcText3.setText(mcq.getOptions().get(2));
            if (!mcq.getOptions().get(2).equals("")) {
                mcOption3.setVisibility(View.VISIBLE);
                mcText3.setVisibility(View.VISIBLE);
                removeOpt.setVisibility(View.VISIBLE);
                count = 3;
            }
            mcText4.setText(mcq.getOptions().get(3));
            if (!mcq.getOptions().get(3).equals("")) {
                mcOption4.setVisibility(View.VISIBLE);
                mcText4.setVisibility(View.VISIBLE);
                count = 4;
            }
            mcText5.setText(mcq.getOptions().get(4));
            if (!mcq.getOptions().get(4).equals("")) {
                mcOption5.setVisibility(View.VISIBLE);
                mcText5.setVisibility(View.VISIBLE);
                count = 5;
            }
            mcText6.setText(mcq.getOptions().get(5));
            if (!mcq.getOptions().get(5).equals("")) {
                mcOption6.setVisibility(View.VISIBLE);
                mcText6.setVisibility(View.VISIBLE);
                option.setVisibility(View.INVISIBLE);
                count = 6;
            }
        }

        final Button submit = view.findViewById(R.id.submitMC);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MCQuestion question = new MCQuestion(prompt.getText().toString());
                if (isNew) {
                    questionare.addQuestion(question);
                } else {
                    mcq.prompt = prompt.getText().toString();
                }

                if (isNew) {
                    if (mcOption1.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText1.getText().toString());
                    } else if (mcOption2.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText2.getText().toString());
                    } else if (mcOption3.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText3.getText().toString());
                    } else if (mcOption4.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText4.getText().toString());
                    } else if (mcOption5.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText5.getText().toString());
                    } else if (mcOption6.isChecked()) {
                        questionare.asheet.addCorrectAnswer(mcText6.getText().toString());
                    }
                } else {
                    if (mcOption1.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText1.getText().toString());
                    } else if (mcOption2.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText2.getText().toString());
                    } else if (mcOption3.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText3.getText().toString());
                    } else if (mcOption4.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText4.getText().toString());
                    } else if (mcOption5.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText5.getText().toString());
                    } else if (mcOption6.isChecked()) {
                        questionare.asheet.correctAnswers.set(questionare.questions.indexOf(mcq), mcText6.getText().toString());
                    }
                }

                if (!isNew) {
                    mcq.options.clear();
                    mcq.setOption(mcText1.getText().toString());
                    mcq.setOption(mcText2.getText().toString());
                    mcq.setOption(mcText3.getText().toString());
                    mcq.setOption(mcText4.getText().toString());
                    mcq.setOption(mcText5.getText().toString());
                    mcq.setOption(mcText6.getText().toString());
                } else {
                    question.setOption(mcText1.getText().toString());
                    question.setOption(mcText2.getText().toString());
                    question.setOption(mcText3.getText().toString());
                    question.setOption(mcText4.getText().toString());
                    question.setOption(mcText5.getText().toString());
                    question.setOption(mcText6.getText().toString());
                }

                ((MainActivity) getActivity()).toSeeQuestionare(questionare);

            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 2) {
                    mcOption3.setVisibility(View.VISIBLE);
                    mcText3.setVisibility(View.VISIBLE);
                    removeOpt.setVisibility(View.VISIBLE);
                    count = 3;
                } else if (count == 3) {
                    mcOption4.setVisibility(View.VISIBLE);
                    mcText4.setVisibility(View.VISIBLE);
                    count = 4;
                } else if (count == 4) {
                    mcOption5.setVisibility(View.VISIBLE);
                    mcText5.setVisibility(View.VISIBLE);
                    count = 5;
                } else if (count == 5) {
                    mcOption6.setVisibility(View.VISIBLE);
                    mcText6.setVisibility(View.VISIBLE);
                    option.setVisibility(View.INVISIBLE);
                    count = 6;
                }
            }
        });
        removeOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count == 3) {
                    mcOption3.setVisibility(View.INVISIBLE);
                    mcText3.setVisibility(View.INVISIBLE);
                    mcText3.setText("");
                    removeOpt.setVisibility(View.INVISIBLE);
                    count = 2;
                } else if (count == 4) {
                    mcOption4.setVisibility(View.INVISIBLE);
                    mcText4.setVisibility(View.INVISIBLE);
                    mcText4.setText("");
                    count = 3;
                } else if (count == 5) {
                    mcOption5.setVisibility(View.INVISIBLE);
                    mcText5.setVisibility(View.INVISIBLE);
                    mcText5.setText("");
                    count = 4;
                } else if (count == 6) {
                    mcOption6.setVisibility(View.INVISIBLE);
                    mcText6.setVisibility(View.INVISIBLE);
                    mcText6.setText("");
                    option.setVisibility(View.VISIBLE);
                    count = 5;
                }
            }
        });
        return view;
    }

//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//        final EditText mcText1 = view.findViewById(R.id.mcText1);
//        final EditText mcText2 = view.findViewById(R.id.mcText2);
//        final EditText mcText3 = view.findViewById(R.id.mcText3);
//        final EditText mcText4 = view.findViewById(R.id.mcText4);
//        final EditText mcText5 = view.findViewById(R.id.mcText5);
//        final EditText mcText6 = view.findViewById(R.id.mcText6);
//
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.mcOption1:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText1.getText().toString()); //get option 1 text
//                break;
//            case R.id.mcOption2:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText2.getText().toString()); //get option 2 text
//                break;
//            case R.id.mcOption3:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText3.getText().toString()); //get option 3 text
//                break;
//            case R.id.mcOption4:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText4.getText().toString()); //get option 4 text
//                break;
//            case R.id.mcOption5:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText5.getText().toString()); //get option 5 text
//                break;
//            case R.id.mcOption6:
//                if (checked)
//                    questionare.asheet.addCorrectAnswer(mcText6.getText().toString()); //get option 6 text
//                break;
//        }
//    }


/**
 public void onButtonClicked(View view){

 //onButtonClicked(View view);
 /*
 donebutton = (Button) findViewById(R.id.done);
 donebutton.setOnClickListener(this);
 donebutton.setVisibility(View.INVISIBLE);

 @Override public void onClick(View v) {
 // TODO Auto-generated method stub
 if(v.equals(remove))
 {
 donebutton.setVisibility(View.VISIBLE);
 }
 if(v.equals(donebutton))
 {
 Intent i=new Intent(One.this,Second.class);
 startActivity(i);
 finish();
 donebutton.setVisibility(View.INVISIBLE);
 }

 }

 // Button option = (Button) view.findViewById(R.id.addOption);
 //final int count = 2;


 // final EditText mcText1 = view.findViewById(R.id.mcText1);
 // final EditText mcText2 = view.findViewById(R.id.mcText2);


 //        option.setOnClickListener(new View.OnClickListener() {
 //            public void onClick(View v) {
 EditText mcText3 = view.findViewById(R.id.mcText3);
 EditText mcText4 = view.findViewById(R.id.mcText4);
 EditText mcText5 = view.findViewById(R.id.mcText5);
 EditText mcText6 = view.findViewById(R.id.mcText6);
 Button mcOption3 = view.findViewById(R.id.mcOption3);
 Button mcOption4 = view.findViewById(R.id.mcOption4);
 Button mcOption5 = view.findViewById(R.id.mcOption5);
 Button mcOption6 = view.findViewById(R.id.mcOption6);


 if (count == 2) {
 //final EditText mcText3 = view.findViewById(R.id.mcText3);
 mcText3.setVisibility(view.VISIBLE);
 mcOption3.setVisibility(view.VISIBLE);
 count = 3;
 } else if (count == 3) {
 // final EditText mcText4 = view.findViewById(R.id.mcText4);
 mcText4.setVisibility(View.VISIBLE);
 mcOption4.setVisibility(View.VISIBLE);

 count = 4;
 } else if (count == 4) {
 // final EditText mcText5 = view.findViewById(R.id.mcText5);
 mcText5.setVisibility(View.VISIBLE);
 mcOption5.setVisibility(View.VISIBLE);

 count = 5;
 } else if (count == 5) {
 //final EditText mcText6 = view.findViewById(R.id.mcText6);
 mcText6.setVisibility(View.VISIBLE);
 mcOption6.setVisibility(View.VISIBLE);

 count = 6;
 }
 //   }
 // });
 }*/
}
