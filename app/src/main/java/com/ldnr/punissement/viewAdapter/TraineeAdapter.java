package com.ldnr.punissement.viewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Trainee;
import com.ldnr.punissement.viewHolder.TraineeViewHolder;
import java.util.List;

public class TraineeAdapter extends RecyclerView.Adapter<TraineeViewHolder> {

    List<Trainee> list;

    // constructor with an object list
    public TraineeAdapter(List<Trainee> list){
        this.list = list;
    }


    // to create viewHolder
    @Override
    public TraineeViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_traineeslist, viewGroup, false);
        return new TraineeViewHolder(view);
    }

    // to fill the cell
    @Override
    public void onBindViewHolder(TraineeViewHolder traineeVH, int position){

        Trainee trainee = list.get(position);
        traineeVH.blind(trainee);
    }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
