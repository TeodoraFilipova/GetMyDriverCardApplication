package com.mystique.rt.getmydrivercardapplcation.views.contacts;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mystique.rt.getmydrivercardapplcation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mystique.rt.getmydrivercardapplcation.apputils.Constants.LONDON;
import static com.mystique.rt.getmydrivercardapplcation.apputils.Constants.LONDON_CENTRAL_LATITUDE;


public class MapActivity extends AppCompatActivity {

        public GoogleMap mGoogleMap;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_map);

            ButterKnife.bind(this);

            Intent intent = getIntent();
            String officename = intent.getStringExtra("name");
            LatLng coordinates = null;
            if(officename.equals(LONDON)) {}
                coordinates = new LatLng(LONDON_CENTRAL_LATITUDE, LONDON_CENTRAL_LATITUDE);

            try {
                initializeMap(coordinates);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    private void initializeMap(LatLng coordinates) {
        if (mGoogleMap == null) {
            ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMapAsync(googleMap1 -> {
                        mGoogleMap = googleMap1;
                        if (mGoogleMap == null) {
                            Toast.makeText(getApplicationContext(),
                                    "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            MarkerOptions marker = new MarkerOptions().position(coordinates).title("Your best Store location");
                            mGoogleMap.addMarker(marker);

                            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                                    coordinates).zoom(16).build();

                            mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                        }
                    });
        }
    }
}
