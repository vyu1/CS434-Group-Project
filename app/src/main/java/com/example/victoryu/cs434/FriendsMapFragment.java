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
public class FriendsMapFragment extends Fragment {
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
            int mediumBubbleSize = getResources().getDimensionPixelSize(R.dimen.medium_map_marker_size);
            int largeBubbleSize = getResources().getDimensionPixelSize(R.dimen.large_map_marker_size);

            Bitmap blueMarkerBitmap = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(blueMarkerBitmap);
            Drawable shape = getResources().getDrawable(R.drawable.blue_bubble);
            shape.setBounds(0, 0, blueMarkerBitmap.getWidth(), blueMarkerBitmap.getHeight());
            shape.draw(canvas);

            Bitmap blueMarkerBitmap2 = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas4 = new Canvas(blueMarkerBitmap2);
            Drawable shape4 = getResources().getDrawable(R.drawable.blue_bubble);
            shape4.setBounds(0, 0, blueMarkerBitmap2.getWidth(), blueMarkerBitmap2.getHeight());
            shape4.draw(canvas4);

            Bitmap orangeMarkerBitmap = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(orangeMarkerBitmap);
            Drawable shape2 = getResources().getDrawable(R.drawable.orange_bubble);
            shape2.setBounds(0, 0, orangeMarkerBitmap.getWidth(), orangeMarkerBitmap.getHeight());
            shape2.draw(canvas2);

            Bitmap orangeMarkerBitmap2 = Bitmap.createBitmap(largeBubbleSize, largeBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas5 = new Canvas(orangeMarkerBitmap2);
            Drawable shape5 = getResources().getDrawable(R.drawable.orange_bubble);
            shape5.setBounds(0, 0, orangeMarkerBitmap2.getWidth(), orangeMarkerBitmap2.getHeight());
            shape5.draw(canvas5);

            Bitmap redMarkerBitmap = Bitmap.createBitmap(largeBubbleSize, largeBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(redMarkerBitmap);
            Drawable shape3 = getResources().getDrawable(R.drawable.red_bubble);
            shape3.setBounds(0, 0, redMarkerBitmap.getWidth(), redMarkerBitmap.getHeight());
            shape3.draw(canvas3);

            Bitmap redMarkerBitmap2 = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas6 = new Canvas(redMarkerBitmap2);
            Drawable shape6 = getResources().getDrawable(R.drawable.red_bubble);
            shape6.setBounds(0, 0, redMarkerBitmap2.getWidth(), redMarkerBitmap2.getHeight());
            shape6.draw(canvas6);

            Bitmap greenMarkerBitmap = Bitmap.createBitmap(smallBubbleSize, smallBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas7 = new Canvas(greenMarkerBitmap);
            Drawable shape7 = getResources().getDrawable(R.drawable.green_bubble);
            shape7.setBounds(0, 0, greenMarkerBitmap.getWidth(), greenMarkerBitmap.getHeight());
            shape7.draw(canvas7);

            Bitmap greenMarkerBitmap2 = Bitmap.createBitmap(mediumBubbleSize, mediumBubbleSize, Bitmap.Config.ARGB_8888);
            Canvas canvas8 = new Canvas(greenMarkerBitmap2);
            Drawable shape8 = getResources().getDrawable(R.drawable.green_bubble);
            shape8.setBounds(0, 0, greenMarkerBitmap2.getWidth(), greenMarkerBitmap2.getHeight());
            shape8.draw(canvas8);

            LatLng csi = new LatLng(38.989955, -76.936245);
            map.addMarker(new MarkerOptions().position(csi).title("Ezra Schwartz's In Class @ CSI").icon(BitmapDescriptorFactory.fromBitmap(redMarkerBitmap2)));

            LatLng csi2 = new LatLng(38.990088, -76.935921);
            map.addMarker(new MarkerOptions().position(csi2).title("Bobby Vinson's In Class @ CSI").icon(BitmapDescriptorFactory.fromBitmap(blueMarkerBitmap2)));

            LatLng mckeldin = new LatLng(38.985986, -76.945110);
            map.addMarker(new MarkerOptions().position(mckeldin).title("Cole Evans' Studying @ McKeldin").icon(BitmapDescriptorFactory.fromBitmap(greenMarkerBitmap2)));

            LatLng mckeldin2 = new LatLng(38.986162, -76.945552);
            map.addMarker(new MarkerOptions().position(mckeldin2).title("Victor Yu's Studying @ McKeldin").icon(BitmapDescriptorFactory.fromBitmap(orangeMarkerBitmap2)));

            LatLng commons5 = new LatLng(38.982411, -76.943272);
            map.addMarker(new MarkerOptions().position(commons5).title("Cole Evan's @ Commons").icon(BitmapDescriptorFactory.fromBitmap(greenMarkerBitmap)));

            LatLng commons3 = new LatLng(38.981988, -76.942932);
            map.addMarker(new MarkerOptions().position(commons3).title("Ezra Schwartz's @ Commons").icon(BitmapDescriptorFactory.fromBitmap(redMarkerBitmap)));

            LatLng commons1 = new LatLng(38.982439, -76.942584);
            map.addMarker(new MarkerOptions().position(commons1).title("Victor Yu's @ Commons").icon(BitmapDescriptorFactory.fromBitmap(orangeMarkerBitmap)));

            LatLng stamp = new LatLng(38.987969, -76.944638);
            map.addMarker(new MarkerOptions().position(stamp).title("Bobby Vinson's Eating @ Stamp").icon(BitmapDescriptorFactory.fromBitmap(blueMarkerBitmap)));

            LatLng gym = new LatLng(38.993747, -76.945167);
            map.addMarker(new MarkerOptions().position(gym).title("Victor Yu's Balling @ Eppley").icon(BitmapDescriptorFactory.fromBitmap(orangeMarkerBitmap2)));

            LatLng gym2 = new LatLng(38.993893, -76.944614);
            map.addMarker(new MarkerOptions().position(gym2).title("Cole Evan's Lifting @ Eppley").icon(BitmapDescriptorFactory.fromBitmap(greenMarkerBitmap2)));

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
