package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeLongQuestion extends Fragment {

    Questionare questionare;
    Question lq;

    public static TakeLongQuestion newInstance(Questionare q, Question qu) {
        TakeLongQuestion fragment = new TakeLongQuestion();
        fragment.questionare = q;
        fragment.lq = qu;
        return fragment;
    }
}
