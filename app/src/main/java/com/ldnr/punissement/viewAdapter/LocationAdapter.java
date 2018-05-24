package com.ldnr.punissement.viewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Location;
import com.ldnr.punissement.viewHolder.LocationViewHolder;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {

    List<Location> list;

    // constructor with an object list
    public LocationAdapter(List<Location> list){
        this.list = list;
    }


    // to create viewHolder
    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_location_list, viewGroup, false);
        return new LocationViewHolder(view);
    }

    // to fill the cell
    @Override
    public void onBindViewHolder(LocationViewHolder locVH, int position){

        Location loc = list.get(position);
        locVH.blind(loc);
    }

    //com vide
    @Override
    public int getItemCount(){
        return list.size();
    }

}
