package com.example.trabajocm.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Habilidad_esp {

    @SerializedName("nombre_habilidad")
    private String nombre_hab;
    private List<String> descripcion_hab;

    public Habilidad_esp(String nombre_hab, List<String> descripcion_hab) {
        this.nombre_hab = nombre_hab;
        this.descripcion_hab = descripcion_hab;
    }

    public String getNombre_hab() {
        return nombre_hab;
    }

    public List<String> getDescripcion_hab() {
        return descripcion_hab;
    }

    @Override
    public String toString() {
        return "Habilidad_esp{" +
                "nombre_hab='" + nombre_hab + '\'' +
                ", descripcion_hab=" + descripcion_hab +
                '}';
    }
}
