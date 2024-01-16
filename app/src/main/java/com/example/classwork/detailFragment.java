package com.example.classwork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link detailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class detailFragment extends Fragment {

    TextView lblCourse,lblDes;
    public detailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        lblCourse=view.findViewById(R.id.lblCourse);
        lblDes=view.findViewById(R.id.lblDes);
        return view;

    }
    public void ChangeData(String Course,String Des){
        lblCourse.setText(Course);
        lblDes.setText(Des);

    }
}