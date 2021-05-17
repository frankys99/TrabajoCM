package com.example.trabajocm.entidades;

public class raza {

    private String raza;
    private float tamaño;
    private int velocidad;
    private int fuerza;
    private int destreza;
    private int constitucion;
    private int inteligencia;
    private int sabiduria;
    private int carisma;
    private String descripcion;
    private String lengua1;
    private String lengua2;

    public raza(String raza,int tamaño,int velocidad, int fuerza, int destreza, int constitucion,
                     int inteligencia, int sabiduria, int carisma,String descripcion ,String lengua1,String lengua2) {

        this.raza = raza;
        this.tamaño = tamaño;
        this.velocidad = velocidad;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma = carisma;
        this.descripcion = descripcion;
        this.lengua1 = lengua1;
        this.lengua2 = lengua2;


    }

    public String getRaza() {
        return raza;
    }

    public float getTamaño() {
        return tamaño;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLengua1() {
        return lengua1;
    }

    public String getLengua2() {
        return lengua2;
    }
}
