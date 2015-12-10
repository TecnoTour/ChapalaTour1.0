package com.tsis.tecnotour;

import android.app.Application;

import java.util.List;

/**
 * Created by Daniel on 15/10/2015.
 */
public class Global extends Application {
private List<Lugar> lugarList;

    public List<Lugar> getLugarList() {
        return lugarList;
    }

    public void setLugarList(List<Lugar> lugarList) {
        this.lugarList = lugarList;
    }
}
