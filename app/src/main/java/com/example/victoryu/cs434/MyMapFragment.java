package com.example.victoryu.cs434;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// name was chosen to differ from Google's Java class called MapFragment
public class MyMapFragment extends Fragment implements OnMapReadyCallback {
    private FragmentActivity myContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflating the layout for this fragment **/
        View v = inflater.inflate(R.layout.fragment_map, null);
        SupportMapFragment mapFragment = (SupportMapFragment) myContext.getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        int smallBubbleSize = getResources().getDimensionPixelSize(R.dimen.small_map_marker_size);
        Bitmap blueMarkerBitmap = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(blueMarkerBitmap);
        Drawable shape = getResources().getDrawable(R.drawable.blue_bubble);
        shape.setBounds(0, 0, blueMarkerBitmap.getWidth(), blueMarkerBitmap.getHeight());
        shape.draw(canvas);

        int mediumBubbleSize = getResources().getDimensionPixelSize(R.dimen.medium_map_marker_size);
        Bitmap yellowMarkerBitmap = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(yellowMarkerBitmap);
        Drawable shape2 = getResources().getDrawable(R.drawable.yellow_bubble);
        shape2.setBounds(0, 0, yellowMarkerBitmap.getWidth(), yellowMarkerBitmap.getHeight());
        shape2.draw(canvas2);

        int largeBubbleSize = getResources().getDimensionPixelSize(R.dimen.large_map_marker_size);
        Bitmap redMarkerBitmap = Bitmap.createBitmap(largeBubbleSize, largeBubbleSize, Bitmap.Config.ARGB_8888);
        Canvas canvas3 = new Canvas(redMarkerBitmap);
        Drawable shape3 = getResources().getDrawable(R.drawable.red_bubble);
        shape3.setBounds(0, 0, redMarkerBitmap.getWidth(), redMarkerBitmap.getHeight());
        shape3.draw(canvas3);

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng mckeldin = new LatLng(38.985986, -76.945110);
        map.addMarker(new MarkerOptions().position(mckeldin).title("Marker at McKeldin").icon(BitmapDescriptorFactory.fromBitmap(redMarkerBitmap)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mckeldin, 16.0f));

        LatLng business = new LatLng(38.983107, -76.947447);
        map.addMarker(new MarkerOptions().position(business).title("Marker at Smith School").icon(BitmapDescriptorFactory.fromBitmap(blueMarkerBitmap)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(business, 16.0f));

        LatLng tydings = new LatLng(38.984758, -76.944056);
        map.addMarker(new MarkerOptions().position(tydings).title("Marker at Tydings Hall").icon(BitmapDescriptorFactory.fromBitmap(yellowMarkerBitmap)));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(tydings, 16.0f));

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
