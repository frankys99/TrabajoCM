package com.example.trabajocm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Clase {

    //Atributos
    public String nombre;
    public String doc_info;
    public HashMap<String, List<String>> proficiencias;
    public List<String>equipo;
    public Double dinero;

    //Constructor
    public Clase (String nombre, String doc,  HashMap<String, List<String>>profi, List<String>equipo, Double dinero){
        this.nombre = nombre;
        this.doc_info = doc;
        this.proficiencias = profi;
        this.equipo = equipo;
        this.dinero = dinero;
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDoc_info() {
        return doc_info;
    }

    public void setDoc_info(String doc_info) {
        this.doc_info = doc_info;
    }

    public HashMap<String, List<String>> getProficiencias() {
        return proficiencias;
    }

    public void setProficiencias(HashMap<String, List<String>> proficiencias) {
        this.proficiencias = proficiencias;
    }

    public List<String> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<String> equipo) {
        this.equipo = equipo;
    }

    public Double getDinero() {
        return dinero;
    }

    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "nombre='" + nombre + '\'' +
                ", doc_info='" + doc_info + '\'' +
                ", proficiencias=" + proficiencias +
                ", equipo=" + equipo +
                ", dinero=" + dinero +
                '}';
    }
}
