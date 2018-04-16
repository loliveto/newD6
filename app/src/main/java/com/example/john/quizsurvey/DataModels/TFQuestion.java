package com.example.john.quizsurvey.DataModels;

import com.example.john.quizsurvey.DataModels.Question;

public class TFQuestion extends Question {
    public TFQuestion(String p)
    {
        prompt = p;
        type = "TF";
    }

    @Override
    public void setOption(){
        options.add("True");
        options.add("False");
    }
}
