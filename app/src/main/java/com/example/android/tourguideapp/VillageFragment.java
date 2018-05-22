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
public class VillageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        //Create an array of entries to display the village entries.
        final ArrayList<Entry> entries = new ArrayList<>();

        //Add the different entries to the ArrayList
        entries.add(new Entry(R.string.new_castle_name, R.drawable.new_castle,
                R.drawable.ic_new_castle, R.string.new_castle_info));
        entries.add(new Entry(R.string.town_hall_name, R.drawable.town_hall,
                R.drawable.ic_town_hall, R.string.town_hall_info));
        entries.add(new Entry(R.string.castle_tower_name, R.drawable.castle_tower,
                R.drawable.ic_castle_tower, R.string.castle_tower_info));
        entries.add(new Entry(R.string.church_name, R.drawable.church,
                R.drawable.ic_church, R.string.church_info));
        entries.add(new Entry(R.string.castell_bank_name, R.drawable.castell_bank,
                R.drawable.ic_castell_bank, R.string.castell_bank_info));
        entries.add(new Entry(R.string.archive_name, R.drawable.archive,
                R.drawable.ic_archive, R.string.archive_info));

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
