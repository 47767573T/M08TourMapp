package app.m08tourmapp;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.widget.ImageButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class F_Main extends Fragment
        implements View.OnClickListener, View.OnLongClickListener
        , View.OnCreateContextMenuListener {

    private ImageButton _imbtGuardar;

    private ImageButton _imbtModificar;

    private ImageButton _imbtMostrar;


    public F_Main() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.lay_f_main, container, false);
        super.onCreate(savedInstanceState);

        //Setteamos el comportamiento de cada botón.
        _imbtGuardar = (ImageButton) mainView.findViewById(R.id.imbtGuardar);

        _imbtModificar = (ImageButton) mainView.findViewById(R.id.imbtModificar);

        _imbtMostrar = (ImageButton) mainView.findViewById(R.id.imbtMostrar);
        //_imbtMostrar.setOnClickListener(this);
        Log.e("prueba1", "XXX: antes de comenzar actividad de mapa por metodo implementado");
        Intent intentMap = new Intent(getActivity().getApplication(), A_Map.class);
        startActivity(intentMap);
        _imbtMostrar.setOnLongClickListener(this);

        return mainView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.imbtGuardar:
                break;*/

            case R.id.imbtMostrar:      //Intent para mapa
                Log.e("prueba1","XXX: antes de comenzar actividad de mapa por metodo implementado");
                Intent intentMap = new Intent(getActivity().getApplication(), A_Map.class);
                startActivity(intentMap);
                break;

            /*case R.id.imbtModificar:
                break;*/

        }

    }

    @Override
    public boolean onLongClick(View v) {

        switch (v.getId()) {
            /*case R.id.imbtGuardar:
                break;*/

            case R.id.imbtMostrar:      //Intent para mapa
                Log.e("prueba1", "XXX: antes de comenzar actividad de mapa por metodo implementado");
                Intent intentMap = new Intent(getActivity().getApplication(), A_Map.class);
                startActivity(intentMap);
                return false;



        }
        return false;
    }


}


