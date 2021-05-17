package com.example.trabajocm;

import android.net.Uri;
import android.widget.ImageView;

public class Datos {
    private static ImageView imagen;
    private static String tamaño;
    private static String raza;
    private static String alineamiento;
    private static String velocidad;
    private static String nombre;
    private static String competencias;
    private static Uri imagenUri;
    //Getters
    public static ImageView getImagen() {
        return imagen;
    }

    public static String getTamaño() {
        return tamaño;
    }

    public static Uri getUri() {
        return imagenUri;
    }

    public static String getRaza() {
        return raza;
    }

    public static String getAlineamiento() {
        return alineamiento;
    }

    public static String getVelocidad() {
        return velocidad;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getCompetencias() {
        return competencias;
    }


    //Setters

    public static void setImagen(ImageView imagen) {
        Datos.imagen = imagen;
    }

    public static void setUri(Uri imagenUri) {
        Datos.imagenUri = imagenUri;
    }

    public static void setTamaño(String tamaño) {
        Datos.tamaño = tamaño;
    }

    public static void setRaza(String raza) {
        Datos.raza = raza;
    }

    public static void setAlineamiento(String alineamiento) {
        Datos.alineamiento = alineamiento;
    }

    public static void setVelocidad(String velocidad) {
        Datos.velocidad = velocidad;
    }

    public static void setNombre(String nombre) {
        Datos.nombre = nombre;
    }

    public static void setCompetencias(String competencias) {
        Datos.competencias = competencias;
    }
}
