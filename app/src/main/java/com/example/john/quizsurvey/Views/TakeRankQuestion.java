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

    public static TakeRankQuestion newInstance(Questionare q, Question qu) {
        TakeRankQuestion fragment = new TakeRankQuestion();
        fragment.questionare = q;
        fragment.raq = qu;
        return fragment;
    }
}
