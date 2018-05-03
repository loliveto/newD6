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

    public static TakeMCQuestion newInstance(Questionare q, Question qu) {
        TakeMCQuestion fragment = new TakeMCQuestion();
        fragment.questionare = q;
        fragment.mcq = qu;
        return fragment;
    }
}
