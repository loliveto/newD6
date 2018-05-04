package com.example.john.quizsurvey.Views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.john.quizsurvey.DataModels.Questionare;
import com.example.john.quizsurvey.MainActivity;
import com.example.john.quizsurvey.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Caroline Squillante on 5/4/2018.
 */

public class ViewAllQuestForUser extends Fragment {


    private ListView listView;
    ArrayList<Questionare> questionares;
    public ViewAllQuestForUser() {
        // Required empty public constructor
    }

    public static ViewAllQuestForUser newInstance() {
        ViewAllQuestForUser fragment = new ViewAllQuestForUser();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void updateListView(ArrayList<Questionare> questionaresList)
    {
        ArrayList<String> names = new ArrayList<>();
        for (Questionare questionare: questionaresList)
        {
            names.add(questionare.name);
        }
        System.out.println(names.size());
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quest_list_for_users, container, false);
        listView = view.findViewById(R.id.questionareList);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getReference("questionares");
        questionares = new ArrayList<>();
        final ChildEventListener listener = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Questionare questionare = dataSnapshot.getValue(Questionare.class);
                questionares.add(questionare);
                updateListView(questionares);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        ref.addChildEventListener(listener);
        Button back = view.findViewById(R.id.backToMain);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VERY IMPORTANT- App will eventually crash if listener not detached before leave fragment
                ref.removeEventListener(listener);
                ((MainActivity)getActivity()).toMenu();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //VERY IMPORTANT- App will eventually crash if listener not detached before leave fragment
                ref.removeEventListener(listener);
                Questionare selectedQuestionare = questionares.get(position);
                ((MainActivity)getActivity()).toViewUsers(selectedQuestionare);
            }
        });
        return view;
    }

}
