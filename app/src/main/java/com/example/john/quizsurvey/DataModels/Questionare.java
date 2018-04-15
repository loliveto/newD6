package com.example.john.quizsurvey.DataModels;

import com.example.john.quizsurvey.DataModels.Question;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Questionare {
    public String name;
    ArrayList<Question> questions;
    String firebase_id = "";

    public Questionare()
    {
        name = "";
        questions = new ArrayList<>();
        firebase_id = "";
    }


    public ArrayList<String> getQuestionPrompt() {
        ArrayList<String> prompts = new ArrayList<>();
        for (Question question : questions)
        {
            prompts.add(question.prompt);
        }
        return prompts;
    }

    public void addQuestion(Question q)
    {
        questions.add(q);
    }

    public void save()
    {
        if (firebase_id.equals("")) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            //This questionare is new, so create a new space in firebase for questionare
            DatabaseReference myRef = database.getReference("questionares").push();
            //Save the key to use later if we need to edit
            firebase_id = myRef.getKey();
            //Save this object at the location firebase returned
            myRef.setValue(this);
        }else {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            //This questionare has been saved before, and this is an edit, so overwrite the current data on it in firebase
            DatabaseReference myRef = database.getReference("questionares/"+firebase_id);
            //Save this object at its proper location
            myRef.setValue(this);
        }
    }

}
