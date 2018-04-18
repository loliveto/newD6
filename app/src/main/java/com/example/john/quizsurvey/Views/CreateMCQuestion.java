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

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.mcOption1:
                if (checked)
                    questionare.asheet.addCorrectAnswer("True"); //get option 1 text
                break;
            case R.id.mcOption2:
                if (checked)
                    questionare.asheet.addCorrectAnswer("False"); //get option 2 text
                break;
            case R.id.mcOption3:
                if (checked)
                    questionare.asheet.addCorrectAnswer("False"); //get option 3 text
                break;
            case R.id.mcOption4:
                if (checked)
                    questionare.asheet.addCorrectAnswer("False"); //get option 4 text
                break;
            case R.id.mcOption5:
                if (checked)
                    questionare.asheet.addCorrectAnswer("False"); //get option 5 text
                break;
            case R.id.mcOption6:
                if (checked)
                    questionare.asheet.addCorrectAnswer("False"); //get option 6 text
                break;
        }
    }

    public void onButtonClicked(View view){
        
    }

}
