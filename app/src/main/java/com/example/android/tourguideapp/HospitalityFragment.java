package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalityFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        //Create an array of entries to display the village entries.
        final ArrayList<Entry> entries = new ArrayList<>();

        //Add the different entries to the ArrayList
        entries.add(new Entry(R.string.schwan_name, R.drawable.schwan, R.drawable.ic_schwan,
                R.string.schwan_info));
        entries.add(new Entry(R.string.weinstall_name, R.drawable.weinstall,
                R.drawable.ic_weinstall, R.string.weinstall_info));
        entries.add(new Entry(R.string.kniebrecher_name, R.drawable.kniebrecher,
                R.drawable.ic_kniebrecher, R.string.kniebrecher_info));
        entries.add(new Entry(R.string.gruener_baum_name, R.drawable.gruener_baum,
                R.drawable.ic_gruener_baum, R.string.gruener_baum_info));

        //Create a new Entryadapter
        EntryAdapter adapter = new EntryAdapter(getActivity(), entries);

        //Display the objects of the array in the ListView
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Set an on ItemClickListener on the views which display the entries.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // The code in this method will be executed when an entry is clicked on.
                Intent details = new Intent(getActivity(), DetailActivity.class);
                // This line will send information from the entry to the Details.Activity
                details.putExtra(getResources().getString(R.string.entries), entries.get(position));
                startActivity(details);
            }
        });

        return rootView;
    }
}
