package com.example.trabajocm.modelos;

public class Raza {
    private int id;
    private String nombre;
    private String tamaño;
    private String velocidad;
    private String caracteristica_1;
    private String valor_caract_1;
    private String caracteristica_2;
    private String getValor_caract_2;

    //Constructor
    public Raza(int id, String nombre, String tamaño, String velocidad, String caracteristica_1, String valor_caract_1, String caracteristica_2, String getValor_caract_2) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.velocidad = velocidad;
        this.caracteristica_1 = caracteristica_1;
        this.valor_caract_1 = valor_caract_1;
        this.caracteristica_2 = caracteristica_2;
        this.getValor_caract_2 = getValor_caract_2;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTamaño() {
        return tamaño;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public String getCaracteristica_1() {
        return caracteristica_1;
    }

    public String getValor_caract_1() {
        return valor_caract_1;
    }

    public String getCaracteristica_2() {
        return caracteristica_2;
    }

    public String getGetValor_caract_2() {
        return getValor_caract_2;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", velocidad='" + velocidad + '\'' +
                ", caracteristica_1='" + caracteristica_1 + '\'' +
                ", valor_caract_1='" + valor_caract_1 + '\'' +
                ", caracteristica_2='" + caracteristica_2 + '\'' +
                ", getValor_caract_2='" + getValor_caract_2 + '\'' +
                '}';
    }
}
