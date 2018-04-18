package com.example.john.quizsurvey.DataModels;

/**
 * Created by Laura on 4/18/2018.
 */

public class MCQuestion extends Question{

    public MCQuestion(String p)
    {
        prompt = p;
        type = "MC";
        setOption();
    }

    @Override
    public void setOption(){
//        options.add("True");
//        options.add("False");
    }
}
