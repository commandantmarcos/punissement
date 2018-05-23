package com.ldnr.punissement.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldnr.punissement.R;
import com.ldnr.punissement.model.Trainee;
import com.squareup.picasso.Picasso;

public class TraineeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView_id;
    private TextView textView_firstName;
    private TextView textView_lastName;
    private TextView textView_phone;
    private TextView textView_mail;
    private ImageView imageView_pic;


    // (constructor) recover from the view to fill a cell
    public TraineeViewHolder(View itemView){
        super(itemView);

        //textView_id = itemView.findViewById(R.id.id);

        //imageView_pic = (ImageView) itemView.findViewsWithText(R.id.picture);
        textView_firstName = itemView.findViewById(R.id.firstName);
        textView_lastName = itemView.findViewById(R.id.lastName);
        textView_phone = itemView.findViewById(R.id.phone);
        textView_mail = itemView.findViewById(R.id.email);
    }



    // recover from an object to fill a cell
    public void blind (Trainee trainee){

        textView_id.setText(trainee.getId());
        textView_firstName.setText(trainee.getFirstName());
        textView_lastName.setText(trainee.getLastName());
        textView_phone.setText(trainee.getPhoneNum());
        textView_mail.setText(trainee.getEmail());

        //Picasso.with(imageView_pic.getContext()).load(trainee.getImageUrl()).centerCrop().fit().into(imageView_pic);
    }
}
