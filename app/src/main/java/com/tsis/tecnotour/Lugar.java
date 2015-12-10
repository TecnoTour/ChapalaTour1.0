package com.tsis.tecnotour;

import java.io.Serializable;

/**
 * Created by Daniel on 01/10/15.
 */
public class Lugar implements Serializable{

    private int id;
    private String nombre;
    private String linkImagen;
    private float latitud;
    private float longitud;
    private String infogeneral;
    private String actividades;

    public Lugar(int id, String nombre, String linkImagen, float latitud, float longitud, String infogeneral, String actividades) {
        this.id = id;
        this.nombre = nombre;
        this.linkImagen = linkImagen;
        this.latitud = latitud;
        this.longitud = longitud;
        this.infogeneral = infogeneral;
        this.actividades = actividades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public String getInfogeneral() {
        return infogeneral;
    }

    public void setInfogeneral(String infogeneral) {
        this.infogeneral = infogeneral;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
}
