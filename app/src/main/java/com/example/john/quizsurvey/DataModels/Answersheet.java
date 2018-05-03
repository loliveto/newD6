package com.example.john.quizsurvey.DataModels;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Laura on 4/16/2018.
 */

public class Answersheet {
    public ArrayList<String> correctAnswers = new ArrayList<String>();
    public ArrayList<String> userList = new ArrayList<String>();
    public HashMap<String, ArrayList<String>> userAnswers = new  HashMap<String, ArrayList<String>>();
    public int id;

//    public AnswerSheet(){;
//    }

    //add correct answers for the test
    public void addCorrectAnswer(String answer) {
        this.correctAnswers.add(answer);
    }

    //add user users for the questionaire
    public void addUserAnswer(String name, String answer) {
        ArrayList<String> ans = new ArrayList<String>();
        if(userAnswers.containsKey(name)) {
            ans = userAnswers.get(name);
            ans.add(answer);
            userAnswers.put(name, ans);
        }else{
            ans.add(answer);
            userAnswers.put(name, ans);
        }
    }

    public void checkAnswers(Integer id) {
        ArrayList<String> uAns = userAnswers.get(id);
        //not done

    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public ArrayList<String> getUserAnswers(String name) {
        return userAnswers.get(name);
    }
}
