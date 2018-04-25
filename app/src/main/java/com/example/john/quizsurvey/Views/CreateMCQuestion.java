package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    public CreateMCQuestion() {
        // Required empty public constructor
    }

    public static CreateMCQuestion newInstance(Questionare q) {
        CreateMCQuestion fragment = new CreateMCQuestion();
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
        View view =  inflater.inflate(R.layout.create_mcquestion, container, false);

        final EditText prompt = view.findViewById(R.id.mcprompt);

        Button submit = view.findViewById(R.id.submitMC);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MCQuestion question = new MCQuestion(prompt.getText().toString());
                questionare.addQuestion(question);
                ((MainActivity)getActivity()).toSeeQuestionare(questionare);
            }
        });
        return view;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        final EditText mcText1 = view.findViewById(R.id.mcText1);
        final EditText mcText2 = view.findViewById(R.id.mcText2);
        final EditText mcText3 = view.findViewById(R.id.mcText3);
        final EditText mcText4 = view.findViewById(R.id.mcText4);
        final EditText mcText5 = view.findViewById(R.id.mcText5);
        final EditText mcText6 = view.findViewById(R.id.mcText6);


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mcOption1:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText1.getText().toString()); //get option 1 text
                break;
            case R.id.mcOption2:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText2.getText().toString()); //get option 2 text
                break;
            case R.id.mcOption3:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText3.getText().toString()); //get option 3 text
                break;
            case R.id.mcOption4:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText4.getText().toString()); //get option 4 text
                break;
            case R.id.mcOption5:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText5.getText().toString()); //get option 5 text
                break;
            case R.id.mcOption6:
                if (checked)
                    questionare.asheet.addCorrectAnswer(mcText6.getText().toString()); //get option 6 text
                break;
        }
    }

    int count = 2;

    public void onButtonClicked(View view){

        //onButtonClicked(View view);
        /*
        donebutton = (Button) findViewById(R.id.done);
    donebutton.setOnClickListener(this);
    donebutton.setVisibility(View.INVISIBLE);

    @Override
     public void onClick(View v) {
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
         */
        Button option = (Button) view.findViewById(R.id.addOption);
        //final int count = 2;


       // final EditText mcText1 = view.findViewById(R.id.mcText1);
       // final EditText mcText2 = view.findViewById(R.id.mcText2);


        option.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 EditText mcText3 = v.findViewById(R.id.mcText3);
                 EditText mcText4 = v.findViewById(R.id.mcText4);
                 EditText mcText5 = v.findViewById(R.id.mcText5);
                 EditText mcText6 = v.findViewById(R.id.mcText6);
                 Button mcOption3 = v.findViewById(R.id.mcOption3);
                Button mcOption4 = v.findViewById(R.id.mcOption4);
                Button mcOption5 = v.findViewById(R.id.mcOption5);
                Button mcOption6 = v.findViewById(R.id.mcOption6);


                if (count == 2) {
                    //final EditText mcText3 = view.findViewById(R.id.mcText3);
                    mcText3.setVisibility(View.VISIBLE);
                    mcOption3.setVisibility(View.VISIBLE);
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
            }
        });
    }
}
