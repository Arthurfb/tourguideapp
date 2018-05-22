package com.example.android.tourguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the information of the clicked on entry from the fragment.

        Intent details = getIntent();
        Entry currentEntry = details.getParcelableExtra(getResources().getString(R.string.entries));

        //Add information form the strings in the different Actvities
        // More information can be found in this tutorial: https://www.youtube.com/watch?v=WBbsvqSu0is

        int entryImage = currentEntry.getmEntryPicutreId();
        int entryName = currentEntry.getmEntryNameId();
        int entryInfo = currentEntry.getmEntryInfoId();

        //Set the image and strings from the array in the views of the layout.
        ImageView entryImageView = findViewById(R.id.entry_image);
        entryImageView.setImageResource(entryImage);

        TextView entryNameTextView = findViewById(R.id.entry_name);
        entryNameTextView.setText(entryName);

        TextView entryInfoTextView = findViewById(R.id.entry_info);
        entryInfoTextView.setText(entryInfo);
    }

    // Modify the Up-Button so that it behaves like the Back-Button includes code from:
    //https://stackoverflow.com/questions/22947713/make-the-up-button-behave-like-the-back-button-on-android
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}
