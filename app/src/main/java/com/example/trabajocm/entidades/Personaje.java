package com.example.trabajocm.entidades;

import java.io.Serializable;

public class Personaje implements Serializable {
    private Integer id;
    private String imagen;
    private String nombre;
    private String clase;
    private String raza;
    private String alineamiento;
    private String secundarias;
    private String transfondo;
    private String equipo;
    private int fuerza;
    private int destreza;
    private int constitucion;
    private int inteligencia;
    private int sabiduria;
    private int carisma;


    private int nivel;

    private int xp;
    private String habilidad_especial;
    private String lengua1;
    private String lengua2;
    private String hechizo1;
    private String hechizo2;
    private String hechizo3;
    private String hechizo4;
    private String hechizo5;
    private String hechizo6;

    public Personaje (){ //Constructor sin param.

        this.imagen=null;
        this.nombre="vacio";
        this.clase="vacio";
        this.raza="vacio";
        this.alineamiento="vacio";
        this.secundarias="vacio";
        this.transfondo="vacio";
        this.equipo="vacio";
        this.fuerza=0;
        this.destreza=0;
        this.constitucion=0;
        this.inteligencia=0;
        this.sabiduria=0;
        this.carisma=0;
        this.nivel=0;
        this.xp=0;
        this.habilidad_especial="Vacio";
        this.lengua1="vacio";
        this.lengua2="vacio";
        this.hechizo1="vacio";
        this.hechizo2="vacio";
        this.hechizo3="vacio";
        this.hechizo4="vacio";
        this.hechizo5="vacio";
        this.hechizo6="vacio";
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public String getAlineamiento() {
        return alineamiento;
    }

    public void setAlineamiento(String alineamiento) {
        this.alineamiento = alineamiento;
    }

    public String getSecundarias() {
        return secundarias;
    }

    public void setSecundarias(String secundarias) {
        this.secundarias = secundarias;
    }

    public String getTransfondo() {
        return transfondo;
    }

    public void setTransfondo(String transfondo) {
        this.transfondo = transfondo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }





    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }



    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getHabilidad_especial() {
        return habilidad_especial;
    }

    public void setHabilidad_especial(String habilidad_especial) {
        this.habilidad_especial = habilidad_especial;
    }

    public String getLengua1() {
        return lengua1;
    }

    public void setLengua1(String lengua1) {
        this.lengua1 = lengua1;
    }

    public String getLengua2() {
        return lengua2;
    }

    public void setLengua2(String lengua2) {
        this.lengua2 = lengua2;
    }

    public String getHechizo1() {
        return hechizo1;
    }

    public void setHechizo1(String hechizo1) { this.hechizo1 = hechizo1; }


    public String getHechizo2() {
        return hechizo2;
    }

    public void setHechizo2(String hechizo2) { this.hechizo2 = hechizo2; }

    public String getHechizo3() {
        return hechizo3;
    }

    public void setHechizo3(String hechizo3) { this.hechizo3 = hechizo3; }

    public String getHechizo4() {
        return hechizo4;
    }

    public void setHechizo4(String hechizo4) { this.hechizo4 = hechizo4; }

    public String getHechizo5() {
        return hechizo5;
    }

    public void setHechizo5(String hechizo5) { this.hechizo5 = hechizo5; }

    public String getHechizo6() {
        return hechizo6;
    }

    public void setHechizo6(String hechizo6) { this.hechizo6 = hechizo6; }


}