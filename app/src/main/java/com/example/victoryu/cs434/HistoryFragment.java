package com.example.victoryu.cs434;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by victoryu on 12/7/15.
 */
public class HistoryFragment extends Fragment {
    String[] times = {"Time", "9-10 AM", "10AM-12PM", "12-4 PM",
            "4-5 PM", "5-8 PM", "8-11 PM"};
    String[] activities = {"Activity", "Washing Up", "Econ. Class", "Studying",
            "Group Meeting", "Studying", "Chilling"};
    String[] locations = {"Location", "Home", "Tydings", "McKeldin",
            "Smith School", "Library", "Home"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_history, container, false);

        ArrayAdapter timeAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_list, times);
        ListView timeListView = (ListView) v.findViewById(R.id.timeList);
        timeListView.setAdapter(timeAdapter);

        ArrayAdapter locationAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_list, activities);
        ListView locationListView = (ListView) v.findViewById(R.id.locationList);
        locationListView.setAdapter(locationAdapter);

        ArrayAdapter activityAdapter = new ArrayAdapter<String>(getActivity(), R.layout.activity_list, locations);
        ListView activityListView = (ListView) v.findViewById(R.id.activityList);
        activityListView.setAdapter(activityAdapter);

        return v;
    }

}