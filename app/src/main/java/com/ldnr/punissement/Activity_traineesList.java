package com.ldnr.punissement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ldnr.punissement.model.Trainee;
import com.ldnr.punissement.viewAdapter.TraineeAdapter;

import java.util.ArrayList;
import java.util.List;

public class Activity_traineesList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Trainee> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traineeslist);

        addTrainees();

        recyclerView = findViewById(R.id.traineesRV);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setAdapter(new TraineeAdapter(list));
    }

    private void addTrainees(){
       // list.add(new Trainee(getId(),))
    }
}
