package com.example.classwork;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends androidx.fragment.app.ListFragment {
    ListView lstCourse;
    String[] Course={"Master in Android"," Master in Flutter","MAster in kotlin"};
    String[] Des={"Android","Flutter","Kotlin"};
//    private void Initializecomponent()
//    {
//        lstCourse=findViewById(R.id.lstCourse);
//    }


    public ListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list, container, false);
//        ListView lstCourse=view.findViewById(R.id.lstCourse);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,Course);
//        lstCourse.setAdapter(adapter);
//        lstCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                detailFragment obj=(detailFragment) getFragmentManager().findFragmentById(R.id.detailfragment);
//                obj.ChangeData(Course[position],Des[position]);
//
//                lstCourse.setSelector(android.R.color.holo_blue_dark);
////                lstCourse.setSelector(R.); Ma'am ne nahi karaya, mat likho
//            }
//        });
        setListAdapter(adapter);
        return view;

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        detailFragment obj=(detailFragment) getFragmentManager().findFragmentById(R.id.detailfragment);
                obj.ChangeData(Course[position],Des[position]);

                getListView().setSelector(android.R.color.holo_blue_dark);
    }
}