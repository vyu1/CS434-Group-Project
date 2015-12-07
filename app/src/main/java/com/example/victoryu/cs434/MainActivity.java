package com.example.victoryu.cs434;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MyMapFragment personal = new MyMapFragment();
        fragmentTransaction.add(R.id.fragment_container, personal, "PERSONAL");
        fragmentTransaction.commit();
    }

    public void showFriendsMap(View friendsButton) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FriendsMapFragment friends = new FriendsMapFragment();
        fragmentTransaction.replace(R.id.fragment_container, friends, "FRIENDS");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void showPersonalMap(View personalButton) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MyMapFragment personal = new MyMapFragment();
        fragmentTransaction.replace(R.id.fragment_container, personal, "PERSONAL");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void showHistoryMap(View historyButton) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HistoryFragment history = new HistoryFragment();
        fragmentTransaction.replace(R.id.fragment_container, history, "HISTORY");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void showAllMap(View allButton) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AllMapFragment all = new AllMapFragment();
        fragmentTransaction.replace(R.id.fragment_container, all, "ALL");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
