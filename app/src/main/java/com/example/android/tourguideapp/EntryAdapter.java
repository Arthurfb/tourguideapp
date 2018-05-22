package com.example.android.tourguideapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


//The EntryAdapter modifies how the objects stored in the ArrayAdapter<Entry> are displayed in the
//entry_item layout.

public class EntryAdapter extends ArrayAdapter<Entry> {

    public EntryAdapter(Activity context, ArrayList<Entry> entries) {
        super(context, 0, entries);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.entry_item, parent,
                    false);
        }

        Entry currentEntry = getItem(position);

        // Get the name and image for the respective entry and set them into the respective
        // view in the entry_item entry_list ListView
        TextView entryNameTextView = listItemView.findViewById(R.id.entry_name);
        entryNameTextView.setText(currentEntry.getmEntryNameId());

        ImageView entryImageView = listItemView.findViewById(R.id.entry_image);
        entryImageView.setImageResource(currentEntry.getmEntryIconId());

        return listItemView;
    }

}