package com.example.freiria_zamedu_examen3t;

public class Album {
    private String nombre;
    private String grupo;
    private int imagen;
    private String descripcion;

    public Album() {
    }

    public Album(String nombre, String grupo, int imagen) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.imagen = imagen;
    }

    public Album(String nombre, String grupo, int imagen, String descripcion) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Album{" +
                "nombre='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", imagen=" + imagen +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
