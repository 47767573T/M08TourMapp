package app.m08tourmapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by Moises on 30/01/2016.
 */
public class LocationController implements LocationListener {

    LocationManager locationManager;
    LocationListener locationListener;


    String latitud;
    String longitud;
    String altitud;


    /*public LocationController(Context context) {
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        //locationListener.onLocationChanged(this);
    }*/

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
