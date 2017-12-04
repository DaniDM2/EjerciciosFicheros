package com.example.dm2.ejerciciosficheros;

/**
 * Created by dm2 on 20/10/2017.
 */

public class Web {
    private String nombre,url,imagen;
    private int id;

    public Web(String nombre, String url, String imagen, int id) {
        this.nombre = nombre;
        this.url = url;
        this.imagen = imagen;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public String getImagen() {
        return imagen;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  nombre + '\'' +
                ", url='" + url + '\'' +
                ", imagen='" + imagen + '\'' +
                ", id=" + id ;
    }
}
