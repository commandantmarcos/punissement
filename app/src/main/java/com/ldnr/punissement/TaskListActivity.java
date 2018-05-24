package com.ldnr.punissement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ldnr.punissement.database.DatabaseHelper;
import com.ldnr.punissement.model.Task;
import com.ldnr.punissement.viewAdapter.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class TaskListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Task> list = new ArrayList<>();
    private DatabaseHelper dbh ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist);

            addTask();

            recyclerView = findViewById(R.id.taskRV);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(new TaskAdapter(list));
        }

        private void addTask(){
            dbh = new DatabaseHelper(getApplicationContext());
            list = dbh.getAllTasks();
        }

    public void onEditClicked(View view) {}
    }

