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

    public static TakeMatchQuestion newInstance(Questionare q, Question qu) {
        TakeMatchQuestion fragment = new TakeMatchQuestion();
        fragment.questionare = q;
        fragment.maq = qu;
        return fragment;
    }
}
