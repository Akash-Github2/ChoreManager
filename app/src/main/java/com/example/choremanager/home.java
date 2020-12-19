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

    public home() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String[] items = {"Hello", "hi"};

        ListView listView = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, items);

        listView.setAdapter(itemsAdapter);

        return view;
    }
}