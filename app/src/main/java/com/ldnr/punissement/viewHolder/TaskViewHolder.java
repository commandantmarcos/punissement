package com.ldnr.punissement.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private TextView textView_id;
    private TextView textView_type;
    private TextView textView_taskName;
    private TextView textView_date;
    private TextView textView_loc;



    // (constructor) recover from the view to fill a cell
    public TaskViewHolder(View itemView){
        super(itemView);

        //textView_id = itemView.findViewById(R.id.id);
        //textView_loc = itemView.findViewById(R.id.loc);

        textView_type = itemView.findViewById(R.id.type);
        textView_taskName = itemView.findViewById(R.id.taskName);
        textView_date = itemView.findViewById(R.id.date);

    }



    // recover from an object to fill a cell
    public void blind (Task task){

        textView_id.setText(task.getId());
        textView_loc.setText(task.getLoc());

        textView_type.setText(task.getType());
        textView_taskName.setText(task.getTaskName());
        textView_date.setText(task.getDate().toString());
    }
}
