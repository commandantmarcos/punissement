package com.ldnr.punissement.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Location;

public class LocationViewHolder extends RecyclerView.ViewHolder {

    private TextView textView_id;
    private TextView textView_locName;


    // (constructor) recover from the view to fill a cell
    public LocationViewHolder(View itemView){
        super(itemView);

        //textView_id = itemView.findViewById(R.id.id);

        textView_locName = itemView.findViewById(R.id.locName);

    }


    // recover from an object to fill a cell
    public void blind (Location loc){

        textView_id.setText(loc.getId());
        textView_locName.setText(loc.getLocName());
    }
}
