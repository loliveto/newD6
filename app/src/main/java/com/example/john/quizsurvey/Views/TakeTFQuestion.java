package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeTFQuestion extends Fragment {

    Questionare questionare;
    Question tfq;

    public static TakeTFQuestion newInstance(Questionare q, Question qu) {
        TakeTFQuestion fragment = new TakeTFQuestion();
        fragment.questionare = q;
        fragment.tfq = qu;
        return fragment;
    }
}
