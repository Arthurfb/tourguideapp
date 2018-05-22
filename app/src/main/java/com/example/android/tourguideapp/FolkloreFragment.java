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
public class FolkloreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        //Create an array of entries to display the village entries.
        final ArrayList<Entry> entries = new ArrayList<>();

        //Add the different entries to the ArrayList
        entries.add(new Entry(R.string.kerm_name, R.drawable.kerm, R.drawable.ic_kerm,
                R.string.kerm_info));
        entries.add(new Entry(R.string.may_tree_name, R.drawable.maibaum, R.drawable.ic_maibaum,
                R.string.may_tree_info));
        entries.add(new Entry(R.string.spectaculum_name, R.drawable.spectaculum,
                R.drawable.ic_spectaculum, R.string.spectaculum_info));
        entries.add(new Entry(R.string.gruendleinsloch_name, R.drawable.gruendleinsloch,
                R.drawable.ic_gruendleinsloch, R.string.gruendleinsloch_info));
        entries.add(new Entry(R.string.blue_woman_name, R.drawable.castle_tower,
                R.drawable.ic_castle_tower, R.string.blue_woman_info));

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
