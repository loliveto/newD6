package com.example.john.quizsurvey.DataModels;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Laura on 4/16/2018.
 */

public class Answersheet {
    public ArrayList<String> correctAnswers = new ArrayList<String>();
    public HashMap<Integer, ArrayList<String>> userAnswers = new  HashMap<Integer, ArrayList<String>>();
    public int id;
    public String firebase_id = "";

//    public AnswerSheet(){;
//    }

    //add correct answers for the test
    public void addCorrectAnswer(String answer) {
        this.correctAnswers.add(answer);
    }

    //add user users for the questionaire
    public void addUserAnswer(Integer uId, String answer) {
        ArrayList<String> ans = new ArrayList<String>();
        if(userAnswers.containsKey(id)) {
            ans = userAnswers.get(id);
            ans.add(answer);
            userAnswers.put(id, ans);
        }else{
            ans.add(answer);
            userAnswers.put(id, ans);
        }
    }

    public void checkAnswers(Integer id) {
        ArrayList<String> uAns = userAnswers.get(id);
        //not done

    }

    public ArrayList<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public ArrayList<String> getUserAnswers(Integer id) {
        return userAnswers.get(id);
    }

    public void save() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //This questionare has been saved before, and this is an edit, so overwrite the current data on it in firebase
        DatabaseReference myRef = database.getReference("questionares/" + firebase_id + "/asheet");
        //Save this object at its proper location
        myRef.setValue(this);
    }
}
