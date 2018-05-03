package com.example.john.quizsurvey.Views;

import android.support.v4.app.Fragment;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;

/**
 * Created by Caroline Squillante on 5/3/2018.
 */

public class TakeShortQuestion extends Fragment {

    Questionare questionare;
    Question saq;

    public static TakeShortQuestion newInstance(Questionare q, Question qu) {
        TakeShortQuestion fragment = new TakeShortQuestion();
        fragment.questionare = q;
        fragment.saq = qu;
        return fragment;
    }
}
