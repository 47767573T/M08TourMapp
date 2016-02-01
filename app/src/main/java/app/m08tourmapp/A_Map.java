package app.m08tourmapp;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class A_Map extends FragmentActivity implements OnMapReadyCallback, LocationSource.OnLocationChangedListener {

    public LatLng actualCoord = new LatLng (41.39834,2.20318);
    static final LatLng ecaibCoord =  new LatLng (41.39834,2.20318);
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    public LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("prueba2", "Creado mapa actividad");

        setContentView(R.layout.lay_a_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                //setUpMap();
            }
        }
    }

    private void setUpMap(String name, int latitud, int longitud) {
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitud, longitud)).title("name"));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(ecaibCoord).title("ECAIB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ecaibCoord));
    }


    @Override
    public void onLocationChanged(Location location) {

    }
}
