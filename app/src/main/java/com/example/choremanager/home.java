package com.example.choremanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class home extends Fragment {

    ArrayList<DataModel> dataModels;
    ListView listView;
    private CustomAdapter adapter;

    public home() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = view.findViewById(R.id.listView);

        dataModels = new ArrayList<>();

        dataModels.add(new DataModel("Eat Apple Pie Eat Apple Pie Eat Apple Pie Eat Apple Pie Eat Apple Pie Eat Apple Pie Eat Apple Pie Eat Apple Pie ", false));
        dataModels.add(new DataModel("Eat Banana Bread", false));
        dataModels.add(new DataModel("Eat Cupcake", false));
        dataModels.add(new DataModel("Eat Donut", false));
        dataModels.add(new DataModel("Lick Honeycomb", false));
        dataModels.add(new DataModel("Consume Ice Cream Sandwich", false));
        dataModels.add(new DataModel("Pop a Jelly Bean", false));

        adapter = new CustomAdapter(dataModels, getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();


            }
        });
        return view;
    }
}