package com.example.classwork;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Myadapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final String[] description;
    private final int[] img;
    public Myadapter(@NonNull Activity context, String[] title, String[] description, int[] img) {
        super(context,R.layout.custom_list_item,title);
        this.context=context;
        this.title=title;
        this.description=description;
        this.img=img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.custom_list_item,null);
        ImageView imgicon=view.findViewById(R.id.icon);
        TextView lblTitle=view.findViewById(R.id.lblTitle);
        TextView lbldescription=view.findViewById(R.id.lbldescription);
        lblTitle.setText(title[position]);
        lbldescription.setText(description[position]);
        imgicon.setImageResource(img[position]);
        return view;
    }
}
