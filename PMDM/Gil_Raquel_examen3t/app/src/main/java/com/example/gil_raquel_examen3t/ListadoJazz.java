package com.example.gil_raquel_examen3t;

public class ListadoJazz {
    private String nombre;
    private int idImagen;

    public ListadoJazz(String nombre, int idImagen) {
        this.nombre = nombre;
        this.idImagen = idImagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
