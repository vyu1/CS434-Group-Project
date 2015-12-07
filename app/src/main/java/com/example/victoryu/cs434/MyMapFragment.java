package com.example.victoryu.cs434;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

// name was chosen to differ from Google's Java class called MapFragment
public class MyMapFragment extends Fragment {
    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflating the layout for this fragment **/
        View v = inflater.inflate(R.layout.fragment_map, container, false);
        MapsInitializer.initialize(getActivity());
        mapView = (MapView) v.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        if(mapView!=null) {
            map = mapView.getMap();
            map.getUiSettings().setMyLocationButtonEnabled(false);
            map.setMyLocationEnabled(true);

            int smallBubbleSize = getResources().getDimensionPixelSize(R.dimen.small_map_marker_size);
            Bitmap blueMarkerBitmap = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(blueMarkerBitmap);
            Drawable shape = getResources().getDrawable(R.drawable.blue_bubble);
            shape.setBounds(0, 0, blueMarkerBitmap.getWidth(), blueMarkerBitmap.getHeight());
            shape.draw(canvas);

            int mediumBubbleSize = getResources().getDimensionPixelSize(R.dimen.medium_map_marker_size);
            Bitmap orangeMarkerBitmap = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(orangeMarkerBitmap);
            Drawable shape2 = getResources().getDrawable(R.drawable.orange_bubble);
            shape2.setBounds(0, 0, orangeMarkerBitmap.getWidth(), orangeMarkerBitmap.getHeight());
            shape2.draw(canvas2);

            int largeBubbleSize = getResources().getDimensionPixelSize(R.dimen.large_map_marker_size);
            Bitmap redMarkerBitmap = Bitmap.createBitmap(largeBubbleSize, largeBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(redMarkerBitmap);
            Drawable shape3 = getResources().getDrawable(R.drawable.red_bubble);
            shape3.setBounds(0, 0, redMarkerBitmap.getWidth(), redMarkerBitmap.getHeight());
            shape3.draw(canvas3);

            LatLng mckeldin = new LatLng(38.985986, -76.945110);
            map.addMarker(new MarkerOptions().position(mckeldin).title("McKeldin").icon(BitmapDescriptorFactory.fromBitmap(redMarkerBitmap)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(mckeldin, 16.0f));

            LatLng business = new LatLng(38.983107, -76.947447);
            map.addMarker(new MarkerOptions().position(business).title("Smith").icon(BitmapDescriptorFactory.fromBitmap(blueMarkerBitmap)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(business, 16.0f));

            LatLng tydings = new LatLng(38.984758, -76.944056);
            map.addMarker(new MarkerOptions().position(tydings).title("Tydings").icon(BitmapDescriptorFactory.fromBitmap(orangeMarkerBitmap)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(tydings, 16.0f));

            LatLng home = new LatLng(38.982411, -76.943272);
            map.addMarker(new MarkerOptions().position(home).title("Home").icon(BitmapDescriptorFactory.fromBitmap(redMarkerBitmap)));

            map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    Intent intent = new Intent(getActivity(), EditActivity.class);
                    startActivity(intent);
                    return true;
                }
            });

            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        return v;
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
