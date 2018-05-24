package com.ldnr.punissement;

import android.support.v7.app.AppCompatActivity;

import com.ldnr.punissement.database.DatabaseHelper;
import com.ldnr.punissement.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupListActivity extends AppCompatActivity {

    private List<Group> list = new ArrayList<>();
    private DatabaseHelper dbh;

    private void addGroup(){
        dbh = new DatabaseHelper(getApplicationContext());
        list = dbh.getAllGroups();
    }
}
