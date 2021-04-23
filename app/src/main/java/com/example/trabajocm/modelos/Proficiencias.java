package com.example.trabajocm.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Proficiencias {

    //Model class for proficiencias data
    @SerializedName("Armaduras")
    @Expose
    private String[] armaduras;
    @SerializedName("Armas")
    @Expose
    private String[] armas;
    @SerializedName("Herramientas")
    @Expose
    private String[] herramientas;
    @SerializedName("Salvaciones")
    @Expose
    private String[] salvaciones;
    @SerializedName("Habilidades")
    @Expose
    private String[] habilidades;

    public String[] getArmaduras() {
        return armaduras;
    }

    public String[] getArmas() {
        return armas;
    }

    public String[] getHerramientas() {
        return herramientas;
    }

    public String[] getSalvaciones() {
        return salvaciones;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public Proficiencias(String[] armaduras, String[] armas, String[] herramientas, String[] salvaciones, String[] habilidades) {
        this.armaduras = armaduras;
        this.armas = armas;
        this.herramientas = herramientas;
        this.salvaciones = salvaciones;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Proficiencias{" +
                "armaduras=" + Arrays.toString(armaduras) +
                ", armas=" + Arrays.toString(armas) +
                ", herramientas=" + Arrays.toString(herramientas) +
                ", salvaciones=" + Arrays.toString(salvaciones) +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }
}
