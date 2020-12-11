package com.example.googlemaptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {
    String[] permissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };

    GoogleMap map;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            requestPermissions(permissions, 101);
        } else {
            mapInit();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int result:grantResults) {
            if(result == PackageManager.PERMISSION_DENIED) {
                return;
            }
        }
        mapInit();
    }

    public void mapInit() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        MapReadyCallback callback = new MapReadyCallback();
        mapFragment.getMapAsync(callback);
    }

    public void currentLocation() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_DENIED) {
                return;
            }
        }

        Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        Location location2 = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if(location1 != null) {
            setLocation(location1);
        }
        else if(location2 != null) {
            setLocation(location2);
        }

        CurrentLocationListener listener = new CurrentLocationListener();
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) == true) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000, 10f, listener);
        }
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) == true) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                    1000, 10f, listener);
        }

    }

    public void setLocation(Location location) {
        Log.d("nambu", "위도 : " + location.getLatitude());
        Log.d("nambu", "경도 : " + location.getLongitude());

        LatLng position = new LatLng(location.getLatitude(), location.getLongitude());

        CameraUpdate update = CameraUpdateFactory.newLatLng(position);
        map.moveCamera(update);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15f);
        map.animateCamera(zoom);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) ==
                    PackageManager.PERMISSION_DENIED) {
                return;
            }
        }
        map.setMyLocationEnabled(true);
    }

    class CurrentLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            setLocation(location);
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }

    class MapReadyCallback implements OnMapReadyCallback {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            map = googleMap;
            currentLocation();
        }
    }
}