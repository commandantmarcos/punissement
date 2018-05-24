package com.ldnr.punissement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ldnr.punissement.database.DatabaseHelper;
import com.ldnr.punissement.model.Location;
import com.ldnr.punissement.viewAdapter.LocationAdapter;

import java.util.ArrayList;
import java.util.List;


public class LocationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Location> list = new ArrayList<>();
    private DatabaseHelper dbh ;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        addTask();

        recyclerView = findViewById(R.id.locRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new LocationAdapter(list));
    }

    private void addTask(){
        dbh = new DatabaseHelper(getApplicationContext());
        list = dbh.getAllLocations();
    }

    public void onEditClicked(View view) {}
}
