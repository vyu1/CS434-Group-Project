package com.example.victoryu.cs434;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
}
