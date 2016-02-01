package app.m08tourmapp.MapsManager;

import android.content.Context;
import android.location.LocationManager;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

import java.util.Timer;

/**
 * Created by Moises on 01/02/2016.
 */
public class ActualLocation {

    Timer timerCero;
    LocationManager locationManager;
    LocationResult locationResult;
    boolean hayGps = false;
    boolean hayRed = false;


    public boolean getLocation(Context context, LocationResult result){

        locationResult = result;
        if(locationManager == null) {
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        }

        //Excepciones cuando hay fallos buscando proveedor del servicio de GPS o RED, o no es permitido
        try {hayGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);}
        catch(Exception ex){System.out.println("ERROR buscando proveedor de GPS: "+ex);}

        try {hayRed = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);}
        catch (Exception ex){System.out.println("ERROR buscando proveedor de GPS: "+ex);}

        msgToast(context, "ActualLocation_getLocation", "GPS y Red disponibles");

        //Nos aseguramos que el listener no inicialize sin un proveedor
        if(!hayGps && !hayRed) return false;

        if(hayGps) locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListenerGps);

        if(hayRed) locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,0, locationListenerRed);

        timerCero = new Timer();
        timerCero.schedule(new GetLastLocation(), 10000);
        msgToast(context, "ActualLocation_getLocation", "GPS y Red disponibles");

        return true;
    }

    public void msgToast (Context context, String tag, String msg){
        Toast.makeText(context, tag+": "+msg, Toast.LENGTH_LONG).show();

    }

}