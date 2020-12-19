package com.example.choremanager;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class home extends Fragment {

    ArrayList dataModels;
    ListView listView;
    private CustomAdapter adapter;

    public home() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        dataModels = new ArrayList();

        dataModels.add(new DataModel("Apple Pie", false));
        dataModels.add(new DataModel("Banana Bread", false));
        dataModels.add(new DataModel("Cupcake", false));
        dataModels.add(new DataModel("Donut", true));
        dataModels.add(new DataModel("Eclair", true));
        dataModels.add(new DataModel("Froyo", true));
        dataModels.add(new DataModel("Gingerbread", true));
        dataModels.add(new DataModel("Honeycomb", false));
        dataModels.add(new DataModel("Ice Cream Sandwich", false));
        dataModels.add(new DataModel("Jelly Bean", false));
        dataModels.add(new DataModel("Kitkat", false));
        dataModels.add(new DataModel("Lollipop", false));
        dataModels.add(new DataModel("Marshmallow", false));
        dataModels.add(new DataModel("Nougat", false));

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

        /*
        String[] items = {"Do the Dishes Akash!", "drink sum Dasani"};
        ListView listView = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
         */

        return view;
    }
}