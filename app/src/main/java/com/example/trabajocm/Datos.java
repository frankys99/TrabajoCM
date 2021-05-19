package com.example.trabajocm;

import android.net.Uri;
import android.widget.ImageView;

import com.example.trabajocm.modelos.Clase;
import com.example.trabajocm.modelos.Raza;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    //- DATOS DEL PERSONAJE
    //-- Pantalla_1
    private static String nombre;
    private static Uri imagenUri;
    private static ImageView imagen;
    private static String alineamiento;

    //--- Variables derivadas de ls<Raza> => Se puede proporcionar la raza seleccionada de la ls<Raza>
    private static String tamaño;
    private static String raza;
    private static String velocidad;
    private static String competencias;

    private static Raza raza_selecionada;

    //-- Pantalla_2

    //-- Pantalla_3
    private static Clase clase_seleccionada;
    private static List<String> habilidades; //Habilidades habilidades = hab secundarias != habiliades especiales

    public static void initClaseSelec(Clase c){
        clase_seleccionada = c;
    }
    public static void initHabsClase(List<String>ls){
        habilidades = ls;
    }


    ////========================================    DATOS OBTENIDOS POR LA API    ========================================//

    private static List<Clase> ls_clases;
    private static List<Raza> ls_razas;

    public static void iniDatosClases(List<Clase>cl){
        ls_clases = cl;
    }
    public static void initDatosRazas(List<Raza>rl){ls_razas = rl;}

    public static List<Clase> getLs_clases() {
        return ls_clases;
    }
    public static List<Raza> getLs_razas(){
        return ls_razas;
    }


    //========================================    GETTERS & SETTERS : Pantalla_1    ========================================//
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

    //========================================    GETTERS & SETTERS : Pantalla_2    ========================================//
    //Getters
    //Setters

    //========================================    GETTERS & SETTERS : Pantalla_3    ========================================//
    //Getters

    public static Clase getClase_seleccionada() {
        return clase_seleccionada;
    }

    public static List<String> getHabilidades() {
        return habilidades;
    }


    //========================================    METODOS AUXILIARES : formatear datos  ========================================//

    public static String formatListaTexto(List<String>ls){
        String res = "";
        for(int i = 0; i<ls.size();i++){
            if(ls.get(i).contains(".")){
                String aux = ls.get(i).replace(".",".\n");
                res += aux;
            }else{
                res += ls.get(i) + " ";
            }
        }
        return  res;
    }

    public static String formatListaElem(List<String>ls){
        String res = "";
        for(int i = 0; i<ls.size();i++){
            String aux = ls.get(i);
            res += aux + "\n";
        }
        return  res;
    }

}
