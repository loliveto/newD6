package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeRankQuestion extends Fragment {

    Questionare questionare;
    Question raq;
    String name;

    public TakeRankQuestion() {
        // Required empty public constructor
    }

    public static TakeRankQuestion newInstance(Questionare q, Question qu, String name) {
        TakeRankQuestion fragment = new TakeRankQuestion();
        fragment.questionare = q;
        fragment.raq = qu;
        fragment.name = name;
        return fragment;
    }
}
