package com.ldnr.punissement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.ldnr.punissement.database.DatabaseHelper;
import com.ldnr.punissement.model.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupListActivity extends AppCompatActivity {

    private Button buttonAdmin;
    private Button buttonConcep;
    private Button buttonDevS;
    private Button buttonDevR;
    private Button buttonSupp;
    private Button buttonNewGroup;
    private List<Group> list = new ArrayList<>();
    private DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouplist);
    }

    private void addGroup(){
        dbh = new DatabaseHelper(getApplicationContext());
        list = dbh.getAllGroups();
    }
}
