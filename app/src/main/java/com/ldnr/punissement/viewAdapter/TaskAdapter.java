package com.ldnr.punissement.viewAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Task;
import com.ldnr.punissement.viewHolder.TaskViewHolder;

import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    List<Task> list;

    // constructor with an object list
    public TaskAdapter(List<Task> list){
        this.list = list;
    }


    // to create viewHolder
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_task_list, viewGroup, false);
        return new TaskViewHolder(view);
    }

    // to fill the cell
    @Override
    public void onBindViewHolder(TaskViewHolder taskVH, int position){

        Task task = list.get(position);
        taskVH.blind(task);
    }

    //com vide
    @Override
    public int getItemCount(){
        return list.size();
    }
}
