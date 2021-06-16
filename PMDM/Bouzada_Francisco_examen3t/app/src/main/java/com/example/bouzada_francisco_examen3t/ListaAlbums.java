package com.example.bouzada_francisco_examen3t;

import android.media.Image;
import android.net.Uri;
import android.view.View;


public class ListaAlbums {

    public final String titulo;
    public final String grupo;
    public final int Imagen;
    public final String Descripcion;


    private ListaAlbums(String titulo, String grupo, int Imagen, String Descripcion) {
        this.titulo = titulo;
        this.grupo = grupo;
        this.Imagen = Imagen;
        this.Descripcion = Descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGrupo() {
        return grupo;
    }

    public int getImagen() {
        return Imagen;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    @Override
    public String toString() {
        return "ListaAlbums{" +
                "titulo='" + titulo + '\'' +
                ", grupo='" + grupo + '\'' +
                ", Imagen=" + Imagen + '\'' +
                ", Descripcion =" + Descripcion +
                '}';
    }

    public void addElemento(View view) {
    }

    /* Método factoría, para convertir el string en Uri */
    public static ListaAlbums newInstance(String titulo, String grupo, int Imagen, String Descripcion) {
        return new ListaAlbums(titulo, grupo, Imagen, Descripcion);
    }
}
