package com.example.trabajocm.entidades;

import java.util.List;

public class personaje {
    private Integer id;
    private String nombre;
    private String clase;
    private String raza;
    private String salvaciones;
    private String secundarias;
    private String dotes;
    private String equipo;
    private String stats;
    private String stats_generales;
    private String hechizos;

    public personaje(Integer id, String nombre, String clase, String raza, String salvaciones, String secundarias, String dotes, String equipo, String stats, String stats_generales, String hechizos) {
        this.id = id;
        this.nombre = nombre;
        this.clase = clase;
        this.raza = raza;
        this.salvaciones = salvaciones;
        this.secundarias = secundarias;
        this.dotes = dotes;
        this.equipo = equipo;
        this.stats = stats;
        this.stats_generales = stats_generales;
        this.hechizos = hechizos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSalvaciones() {
        return salvaciones;
    }

    public void setSalvaciones(String salvaciones) {
        this.salvaciones = salvaciones;
    }

    public String getSecundarias() {
        return secundarias;
    }

    public void setSecundarias(String secundarias) {
        this.secundarias = secundarias;
    }

    public String getDotes() {
        return dotes;
    }

    public void setDotes(String dotes) {
        this.dotes = dotes;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getStats_generales() {
        return stats_generales;
    }

    public void setStats_generales(String stats_generales) {
        this.stats_generales = stats_generales;
    }

    public String getHechizos() {
        return hechizos;
    }

    public void setHechizos(String hechizos) {
        this.hechizos = hechizos;
    }
}
