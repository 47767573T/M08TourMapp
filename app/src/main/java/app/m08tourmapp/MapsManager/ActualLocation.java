package app.m08tourmapp.MapsManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.Timer;

import static android.support.v4.content.PermissionChecker.checkSelfPermission;


/**
 * Created by Moises on 01/02/2016.
 */
public class ActualLocation {

    Timer timer;
    LocationManager locationManager;
    LocationResult locationResult;
    Location myLocation;
    boolean hayGps = false;
    boolean hayRed = false;


    public boolean getLocation(Context context, LocationResult result) {

        locationResult = result;
        if (locationManager == null) {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        }

        //Excepciones cuando hay fallos buscando proveedor del servicio de GPS o RED, o no es permitido
        try {
            hayGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            System.out.println("ERROR buscando proveedor de GPS: " + ex);
        }

        try {
            hayRed = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            System.out.println("ERROR buscando proveedor de GPS: " + ex);
        }

        msgToast(context, "ActualLocation_getLocation", "GPS y Red disponibles");

        //Nos aseguramos que el listener no inicialize sin un proveedor
        if (!hayGps && !hayRed) return false;

        //Nos aseguramos de los permisos
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        if (hayGps)
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (android.location.LocationListener) locationListenerGPS);

        if (hayRed)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, (android.location.LocationListener) locationListenerRED);

            timer = new Timer();
            timer.schedule(new GetLastLocation(), 10000);
            msgToast(context, "ActualLocation_getLocation", "GPS y Red disponibles");

            return true;
        }

        private int checkSelfPermission (String accessFineLocation){
        }

        LocationListener locationListenerGPS = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                myLocation = location;
                timer.cancel();
                locationResult.gotLocation(location);

                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { }

                locationManager.removeUpdates((android.location.LocationListener) locationListenerRED);

            }
            public void onProviderDisabled(String provider) {}
            public void onProviderEnabled(String provider) {}
            public void onStatusChanged(String provider, int status, Bundle extras) {}
        };

        LocationListener locationListenerRED = new LocationListener() {
            public void onLocationChanged(Location location) {
                myLocation = location;
                timer.cancel();
                locationResult.gotLocation(location);

                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { }

                locationManager.removeUpdates((android.location.LocationListener) locationListenerGPS);

            }
            public void onProviderDisabled(String provider) {}
            public void onProviderEnabled(String provider) {}
            public void onStatusChanged(String provider, int status, Bundle extras) { }
        };


        public void msgToast (Context context, String tag, String msg){
            Toast.makeText(context, tag + ": " + msg, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onLocationChanged (Location location){
            timer.cancel();
            locationResult.gotLocation(location);
            locationManager.

        }

        public static abstract class LocationResult {
            public abstract void gotLocation(Location location);
        }

        protected void startLocationUpdates () {
            LocationServices.FusedLocationApi.requestLocationUpdates().;
        }

    }