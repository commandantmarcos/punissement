package com.ldnr.punissement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate( saveInstanceState);
        setContentView(R.layout.activity_newgroup);
    }

    public void onAddGroupClicked(View view) {

        // on recupére les edit text
        EditText eGroupName = findViewById(R.id.add_group);

        String groupName = eGroupName.getText().toString();

        if(!groupName.isEmpty()){

        }
    }
}
