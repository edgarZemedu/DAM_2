package com.example.gil_raquel_examen3t;

public class Album {
    //2 atributos
    private String nombre;
    private String autor;
    private int idImagen;
    private String bio;


    public Album(String nombre, String autor, int idImagen, String bio) {
        this.nombre = nombre;
        this.autor = autor;
        this.idImagen = idImagen;
        this.bio = bio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

