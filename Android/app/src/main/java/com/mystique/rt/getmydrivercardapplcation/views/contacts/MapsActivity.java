package com.mystique.rt.getmydrivercardapplcation.views.contacts;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mystique.rt.getmydrivercardapplcation.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng location;
        Intent intent = getIntent();
        String office = intent.getStringExtra("name");

        switch (office) {
            case "LondonCentral":
                location = new LatLng(51.5005, -0.1242);
                break;
            case "LondonBromley":
                location = new LatLng(51.406025, 0.013156);
                break;
            case "LondonHillingdon":
                location = new LatLng(51.535183, -0.448138);
                break;
            case "Glasgow":
                location = new LatLng(55.856947, -4.24059);
                break;
            case "Leeds":
                location = new LatLng(53.800755, -1.549077);
                break;
            case "Cambridge":
                location = new LatLng(52.205337, 0.121817);
                break;
            default:
                location = new LatLng(51.5005, -0.1242);
                break;
        }


        mMap.addMarker(new MarkerOptions().position(location).title("London Central Office"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
}
