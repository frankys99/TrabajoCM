package com.example.trabajocm.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class Clase {
    private int id;
    private String nombre;

    //Se necesita crear un objeto de la clase proficiencias!!
    // ya que es un JSON nested
    private Proficiencias proficiencias;

    //Lo mismo con habilidad_esp
    private Habilidad_esp habilidad_esp;

    private List<String> equipo_inicial;
    private int dinero_inicial;
    private List<String> info_clase;


    //Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proficiencias getProficiencias() {
        return proficiencias;
    }

    public void setProficiencias(Proficiencias proficiencias) {
        this.proficiencias = proficiencias;
    }

    public Habilidad_esp getHabilidad_esp() {
        return habilidad_esp;
    }

    public void setHabilidad_esp(Habilidad_esp habilidad_esp) {
        this.habilidad_esp = habilidad_esp;
    }

    public List<String> getEquipo_inicial() {
        return equipo_inicial;
    }

    public void setEquipo_inicial(List<String> equipo_inicial) {
        this.equipo_inicial = equipo_inicial;
    }

    public int getDinero_inicial() {
        return dinero_inicial;
    }

    public void setDinero_inicial(int dinero_inicial) {
        this.dinero_inicial = dinero_inicial;
    }

    public List<String> getInfo_clase() {
        return info_clase;
    }

    public void setInfo_clase(List<String> info_clase) {
        this.info_clase = info_clase;
    }

    public Clase(int id, String nombre, Proficiencias proficiencias, Habilidad_esp habilidad_esp, List<String> equipo_inicial, int dinero_inicial, List<String> info_clase) {
        this.id = id;
        this.nombre = nombre;
        this.proficiencias = proficiencias;
        this.habilidad_esp = habilidad_esp;
        this.equipo_inicial = equipo_inicial;
        this.dinero_inicial = dinero_inicial;
        this.info_clase = info_clase;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", proficiencias=" + proficiencias +
                ", habilidad_esp=" + habilidad_esp +
                ", equipo_inicial=" + equipo_inicial +
                ", dinero_inicial=" + dinero_inicial +
                ", info_clase=" + info_clase +
                '}';
    }
}
