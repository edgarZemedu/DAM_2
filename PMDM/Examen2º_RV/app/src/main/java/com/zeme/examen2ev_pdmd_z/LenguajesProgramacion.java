package com.zeme.examen2ev_pdmd_z;

import android.net.Uri;

public class LenguajesProgramacion {

    private String nombre;
    private Uri imagen;

    public LenguajesProgramacion() {
    }

    private LenguajesProgramacion(String nombre, Uri imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static LenguajesProgramacion newInstance(String nombre, String imagen){
        return new LenguajesProgramacion(nombre, Uri.parse(imagen));
    }

    public Uri getImagen() {
        return imagen;
    }
    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }

}
