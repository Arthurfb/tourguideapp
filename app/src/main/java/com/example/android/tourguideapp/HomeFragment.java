package com.example.android.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        TextView welcomeMessage = rootView.findViewById(R.id.welcome_message);
        welcomeMessage.setText(R.string.welcome_message);

        ImageView villageView = rootView.findViewById(R.id.village_view);
        villageView.setImageDrawable(getResources().getDrawable(R.drawable.castell_view));

        TextView generalInformation = rootView.findViewById(R.id.general_information);
        generalInformation.setText(R.string.general_info);

        return rootView;
    }
}
