package com.tsis.tecnotour;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * Created by TOSHIBA on 18/10/2015.
 */
public class localizacion extends Fragment {

    View rootView;
    Lugar lugar;
    private GoogleMap googleMap;
    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.localizacion, container, false);
        try {

            /*
            mapView = (MapView) rootView.findViewById(R.id.mapView);
            mapView.onCreate(savedInstanceState);

            googleMap = mapView.getMap();
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.setMyLocationEnabled(true);

            MapsInitializer.initialize(this.getActivity());
            lugar = (Lugar) getArguments().get("lugar");

            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(lugar.getLatitud(), lugar.getLongitud())).zoom(18).bearing(45).tilt(70).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            googleMap.animateCamera(cameraUpdate);

            googleMap.addMarker(new MarkerOptions().position(new LatLng(lugar.getLatitud(), lugar.getLongitud())).title(lugar.getNombre()));
*/

            mapView = (MapView) rootView.findViewById(R.id.mapView);
            mapView.onCreate(savedInstanceState);

            googleMap = mapView.getMap();
            googleMap.getUiSettings().setMyLocationButtonEnabled(false);
            googleMap.setMyLocationEnabled(true);

            MapsInitializer.initialize(this.getActivity());
            lugar = (Lugar) getArguments().get("lugar");

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(lugar.getLatitud(), lugar.getLongitud()), 10);
            googleMap.animateCamera(cameraUpdate);
            googleMap.addMarker(new MarkerOptions().position(new LatLng(lugar.getLatitud(), lugar.getLongitud())).title(lugar.getNombre()));


        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;

    }


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }

}