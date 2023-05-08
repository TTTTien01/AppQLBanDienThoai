package com.manager.appbanhang.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.manager.appbanhang.R;

public class MapAPIActivity extends AppCompatActivity implements OnMapReadyCallback {
GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_api_activity);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng syLatLng = new com.google.android.gms.maps.model.LatLng(10.0196911, 105.7382611);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(syLatLng,17));
        map.addMarker(new MarkerOptions()
                .title("Four_T Shop")
                .snippet("Nguyễn Văn Cừ nối dài")
                .position(syLatLng));


    }
}