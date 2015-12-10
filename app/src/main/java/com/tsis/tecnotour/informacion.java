package com.tsis.tecnotour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 18/10/2015.
 */
public class informacion extends Fragment {

    Lugar lugar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.informacion, container, false);
        lugar = (Lugar) getArguments().get("lugar");
        TextView textViewInfo = (TextView) rootView.findViewById(R.id.text);

        textViewInfo.setText(lugar.getInfogeneral());

        return rootView;
    }
}


