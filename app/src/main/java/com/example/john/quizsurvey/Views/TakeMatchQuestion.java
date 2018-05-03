package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeMatchQuestion extends Fragment {

    Questionare questionare;
    Question maq;
    String name;

    public TakeMatchQuestion() {
        // Required empty public constructor
    }

    public static TakeMatchQuestion newInstance(Questionare q, Question qu, String name) {
        TakeMatchQuestion fragment = new TakeMatchQuestion();
        fragment.questionare = q;
        fragment.maq = qu;
        fragment.name = name;
        return fragment;
    }
}
