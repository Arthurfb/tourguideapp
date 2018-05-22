package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
public class WineFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.entry_list, container, false);

        //Create an array of entries to display the village entries.
        final ArrayList<Entry> entries = new ArrayList<>();

        //Add the different entries to the ArrayList
        entries.add(new Entry(R.string.casteller_wine_name, R.drawable.casteller_wine,
                R.drawable.ic_casteller_wine, R.string.casteller_wine_info));
        entries.add(new Entry(R.string.vineyard_name, R.drawable.vineyard, R.drawable.ic_vineyard,
                R.string.vineyard_info));
        entries.add(new Entry(R.string.weinbergstulpe_name, R.drawable.weinbergstulpe,
                R.drawable.ic_weinbergstulpe, R.string.weinbergstulpe_info));

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
