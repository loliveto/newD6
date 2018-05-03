package com.example.john.quizsurvey;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.Views.CreateLongQuestion;
import com.example.john.quizsurvey.Views.CreateMCQuestion;
import com.example.john.quizsurvey.Views.CreateMatchQuestion;
import com.example.john.quizsurvey.Views.CreateRankQuestion;
import com.example.john.quizsurvey.Views.CreateShortQuestion;
import com.example.john.quizsurvey.Views.CreateTFQuestion;
import com.example.john.quizsurvey.Views.EditQuestion;
import com.example.john.quizsurvey.Views.Menu;
import com.example.john.quizsurvey.Views.QTypeSelect;
import com.example.john.quizsurvey.Views.TakeQuestionare;
import com.example.john.quizsurvey.Views.TakeViewAllQuestionares;
import com.example.john.quizsurvey.Views.ViewAllQuestionares;
import com.example.john.quizsurvey.Views.EditQuestionare;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toMenu();

    }

    //Note: R.id.main_activity is the id of the (only) layout in activity_main.xml, so we are displaying our freagments in that
    public void toMenu()
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Menu menu_fragment = Menu.newInstance();
        transaction.replace(R.id.main_activity,menu_fragment);
        transaction.commit();
    }

    public void toSeeQuestionare(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        EditQuestionare viewer = EditQuestionare.newInstance(q);
        transaction.replace(R.id.main_activity,viewer);
        transaction.commit();
    }

    public void toSeeQuestionare()
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        EditQuestionare viewer = EditQuestionare.newInstance();
        transaction.replace(R.id.main_activity,viewer);
        transaction.commit();
    }

    public void toCreateTF(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateTFQuestion tf = CreateTFQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,tf);
        transaction.commit();
    }

    public void toCreateShort(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateShortQuestion shortq = CreateShortQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,shortq);
        transaction.commit();
    }

    public void toLongShort(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateLongQuestion longq = CreateLongQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,longq);
        transaction.commit();
    }

    public void toCreateRank(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateRankQuestion rankq = CreateRankQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,rankq);
        transaction.commit();
    }

    public void toCreateMatch(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateMatchQuestion matchq = CreateMatchQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,matchq);
        transaction.commit();
    }

    public void toCreateLong(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateLongQuestion longq = CreateLongQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,longq);
        transaction.commit();
    }

    public void toViewQuestionares()
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ViewAllQuestionares ql = ViewAllQuestionares.newInstance();
        transaction.replace(R.id.main_activity,ql);
        transaction.commit();
    }

    public void toTakeQuestionares()
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TakeViewAllQuestionares ql = TakeViewAllQuestionares.newInstance();
        transaction.replace(R.id.main_activity,ql);
        transaction.commit();
    }

    public void toTakeQuestionare(Questionare q)
    {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TakeQuestionare ql = TakeQuestionare.newInstance(q);
        transaction.replace(R.id.main_activity,ql);
        transaction.commit();
    }

    public void toViewQuestion(Questionare q, int index){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        EditQuestion q1 = EditQuestion.newInstance(q, index);
        transaction.replace(R.id.main_activity,q1);
        transaction.commit();
    }

    public void toSelectQType(Questionare q){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        QTypeSelect q1 = QTypeSelect.newInstance(q);
        transaction.replace(R.id.main_activity,q1);
        transaction.commit();
    }

    public void toCreateMC(Questionare q){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateMCQuestion mc = CreateMCQuestion.newInstance(q);
        transaction.replace(R.id.main_activity,mc);
        transaction.commit();
    }

    public void toCreateMC(Questionare q, Question qu){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        CreateMCQuestion mc = CreateMCQuestion.newInstance(q, qu);
        transaction.replace(R.id.main_activity,mc);
        transaction.commit();
    }
}
