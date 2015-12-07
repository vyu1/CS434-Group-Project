package com.example.victoryu.cs434;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// name was chosen to differ from Google's Java class called MapFragment
public class AllMapFragment extends Fragment {
    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /** Inflating the layout for this fragment **/
        View v = inflater.inflate(R.layout.fragment_friends, container, false);
        MapsInitializer.initialize(getActivity());
        mapView = (MapView) v.findViewById(R.id.map2);
        mapView.onCreate(savedInstanceState);
        if(mapView!=null) {
            map = mapView.getMap();
            map.getUiSettings().setMyLocationButtonEnabled(false);
            map.setMyLocationEnabled(true);

            int smallBubbleSize = getResources().getDimensionPixelSize(R.dimen.small_map_marker_size);
            Bitmap smallBubble = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(smallBubble);
            Drawable shape = getResources().getDrawable(R.drawable.red_bubble);
            shape.setBounds(0, 0, smallBubble.getWidth(), smallBubble.getHeight());
            shape.draw(canvas);

            int mediumBubbleSize = getResources().getDimensionPixelSize(R.dimen.medium_map_marker_size);
            Bitmap mediumBubble = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(mediumBubble);
            Drawable shape2 = getResources().getDrawable(R.drawable.red_bubble);
            shape2.setBounds(0, 0, mediumBubble.getWidth(), mediumBubble.getHeight());
            shape2.draw(canvas2);

            int largeBubbleSize = getResources().getDimensionPixelSize(R.dimen.large_map_marker_size);
            Bitmap largeBubble = Bitmap.createBitmap(largeBubbleSize, largeBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(largeBubble);
            Drawable shape3 = getResources().getDrawable(R.drawable.red_bubble);
            shape3.setBounds(0, 0, largeBubble.getWidth(), largeBubble.getHeight());
            shape3.draw(canvas3);

            LatLng csi = new LatLng(38.989955, -76.936245);
            map.addMarker(new MarkerOptions().position(csi).title("Average Population").icon(BitmapDescriptorFactory.fromBitmap(mediumBubble)));

            LatLng csi2 = new LatLng(38.990088, -76.935921);
            map.addMarker(new MarkerOptions().position(csi2).title("Average Population").icon(BitmapDescriptorFactory.fromBitmap(mediumBubble)));

            LatLng mckeldin = new LatLng(38.985986, -76.945110);
            map.addMarker(new MarkerOptions().position(mckeldin).title("Average Population").icon(BitmapDescriptorFactory.fromBitmap(mediumBubble)));

            LatLng mckeldin2 = new LatLng(38.986162, -76.945552);
            map.addMarker(new MarkerOptions().position(mckeldin2).title("Average Population").icon(BitmapDescriptorFactory.fromBitmap(mediumBubble)));

            LatLng commons5 = new LatLng(38.982411, -76.943272);
            map.addMarker(new MarkerOptions().position(commons5).title("Crowded!").icon(BitmapDescriptorFactory.fromBitmap(largeBubble)));

            LatLng commons3 = new LatLng(38.981988, -76.942932);
            map.addMarker(new MarkerOptions().position(commons3).title("Crowded!").icon(BitmapDescriptorFactory.fromBitmap(largeBubble)));

            LatLng commons1 = new LatLng(38.982439, -76.942584);
            map.addMarker(new MarkerOptions().position(commons1).title("Crowded!").icon(BitmapDescriptorFactory.fromBitmap(largeBubble)));

            LatLng stamp = new LatLng(38.987969, -76.944638);
            map.addMarker(new MarkerOptions().position(stamp).title("Lonely...").icon(BitmapDescriptorFactory.fromBitmap(smallBubble)));

            LatLng gym = new LatLng(38.993747, -76.945167);
            map.addMarker(new MarkerOptions().position(gym).title("Empty!").icon(BitmapDescriptorFactory.fromBitmap(smallBubble)));

            LatLng business = new LatLng(38.983107, -76.947447);
            map.addMarker(new MarkerOptions().position(business).title("Bored...").icon(BitmapDescriptorFactory.fromBitmap(smallBubble)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(business, 16.0f));

            LatLng tydings = new LatLng(38.984758, -76.944056);
            map.addMarker(new MarkerOptions().position(tydings).title("Bored...").icon(BitmapDescriptorFactory.fromBitmap(smallBubble)));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(tydings, 16.0f));

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.988848, -76.938092), 15.0f));
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
