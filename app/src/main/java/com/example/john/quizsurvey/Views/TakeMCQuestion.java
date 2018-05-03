package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeMCQuestion extends Fragment {

    Questionare questionare;
    Question mcq;
    String name;

    public TakeMCQuestion() {
        // Required empty public constructor
    }
    public static TakeMCQuestion newInstance(Questionare q, Question qu, String name) {
        TakeMCQuestion fragment = new TakeMCQuestion();
        fragment.questionare = q;
        fragment.mcq = qu;
        fragment.name = name;
        return fragment;
    }
}
