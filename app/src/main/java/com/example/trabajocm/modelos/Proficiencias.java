package com.example.trabajocm.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Proficiencias {

    //Model class for proficiencias data

    @SerializedName("Armaduras")
    @Expose
    private List<String> armaduras;
    @SerializedName("Armas")
    @Expose
    private List<String> armas;
    @SerializedName("Herramientas")
    @Expose
    private List<String> herramientas;
    @SerializedName("Salvaciones")
    @Expose
    private List<String> salvaciones;
    @SerializedName("Habilidades")
    @Expose
    private List<String> habilidades;

    public Proficiencias(List<String> armaduras, List<String> armas, List<String> herramientas, List<String> salvaciones, List<String> habilidades) {
        this.armaduras = armaduras;
        this.armas = armas;
        this.herramientas = herramientas;
        this.salvaciones = salvaciones;
        this.habilidades = habilidades;
    }

    public List<String> getArmaduras() {
        return armaduras;
    }

    public List<String> getArmas() {
        return armas;
    }

    public List<String> getHerramientas() {
        return herramientas;
    }

    public List<String> getSalvaciones() {
        return salvaciones;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        return "Proficiencias{" +
                "armaduras=" + armaduras +
                ", armas=" + armas +
                ", herramientas=" + herramientas +
                ", salvaciones=" + salvaciones +
                ", habilidades=" + habilidades +
                '}';
    }
}
