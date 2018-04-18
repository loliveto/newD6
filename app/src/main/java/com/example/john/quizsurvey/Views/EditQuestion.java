package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.example.john.quizsurvey.DataModels.Question;
import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;

import java.util.ArrayList;
/**
 * Created by Laura on 4/16/2018.
 */

public class EditQuestion extends Fragment{
    private Question q;
    private Questionare qu;
    private int index;

    public EditQuestion() {
        // Required empty public constructor
    }

    public static EditQuestion newInstance(Questionare qu, int index) {
        EditQuestion fragment = new EditQuestion();
        fragment.qu = qu;
        fragment.index = index;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_ans, container, false);
        final EditText titleText = view.findViewById(R.id.questionprompt);
        q = qu.getQuestion(index);

        titleText.setText(q.prompt);
        Button save = view.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q.prompt = titleText.getText().toString();
                q.save();//to do
                ((MainActivity)getActivity()).toSeeQuestionare(qu);
            }
        });
        Button home = view.findViewById(R.id.go_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).toMenu();
            }
        });

        ArrayList<String> opts = q.getOptions();
        ListView listView = view.findViewById(R.id.answerlist);
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,opts);
        listView.setAdapter(adapter);

        return view;
    }
}

