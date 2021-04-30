package com.example.trabajocm.utilidades;

public class Utilidades {
    public static final String TABLA_PERSONAJE = "t_personaje";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_IMAGEN = "imagen";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CLASE = "clase";
    public static final String CAMPO_RAZA = "raza";
    public static final String CAMPO_SALVACIONES = "salvaciones";
    public static final String CAMPO_SECUNDARIAS = "secundarias";
    public static final String CAMPO_DOTES = "dotes";
    public static final String CAMPO_EQUIPO = "equipo";
    public static final String CAMPO_FUERZA = "fuerza";
    public static final String CAMPO_DESTREZA = "destreza";
    public static final String CAMPO_CONSTITUCION = "constitucion";
    public static final String CAMPO_INTELIGENCIA = "inteligencia";
    public static final String CAMPO_SABIDURIA = "sabiduria";
    public static final String CAMPO_CARISMA = "carisma";
    public static final String CAMPO_PV = "pv";
    public static final String CAMPO_CA = "ca";
    public static final String CAMPO_NIVEL = "nivel";
    public static final String CAMPO_TURNO = "turno";
    public static final String CAMPO_XP = "xp";
    public static final String CAMPO_LENGUA1 = "lengua1";
    public static final String CAMPO_LENGUA2 = "lengua2";
    public static final String CAMPO_HECHIZO1 = "hechizo1";
    public static final String CAMPO_HECHIZO2 = "hechizo2";
    public static final String CAMPO_HECHIZO3 = "hechizo3";
    public static final String CAMPO_HECHIZO4 = "hechizo4";
    public static final String CAMPO_HECHIZO5 = "hechizo5";
    public static final String CAMPO_HECHIZO6 = "hechizo6";

    public static final String CREAR_TABLA_PERSONAJE = "CREATE TABLE "+TABLA_PERSONAJE+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_IMAGEN+" TEXT, "+ CAMPO_NOMBRE+" TEXT, "+CAMPO_CLASE+" TEXT, "+CAMPO_RAZA+" TEXT, "+CAMPO_SALVACIONES+" TEXT, "+CAMPO_SECUNDARIAS+" TEXT, "+CAMPO_DOTES+" TEXT, "+CAMPO_EQUIPO+" TEXT, "+CAMPO_FUERZA+" INTEGER, "+CAMPO_DESTREZA+" INTEGER,"+CAMPO_CONSTITUCION+" INTEGER, "+CAMPO_INTELIGENCIA+" INTEGER, "+CAMPO_SABIDURIA+" INTEGER, "+CAMPO_CARISMA+" INTEGER, "+CAMPO_PV+" INTEGER, "+CAMPO_CA+" INTEGER, "+CAMPO_NIVEL+" INTEGER, "+CAMPO_TURNO+" INTEGER, "+CAMPO_XP+" INTEGER, "+CAMPO_LENGUA1+" TEXT, "+CAMPO_LENGUA2+" TEXT, "+CAMPO_HECHIZO1+" TEXT, "+CAMPO_HECHIZO2+" TEXT, "+CAMPO_HECHIZO3+" TEXT, "+CAMPO_HECHIZO4+" TEXT, "+CAMPO_HECHIZO5+" TEXT, "+CAMPO_HECHIZO6+" TEXT)";




    public static final String TABLA_RAZA = "t_raza";
    public static final String CAMPO_TAMAÑO = "tamaño";
    public static final String CAMPO_VELOCIDAD = "velocidad";
    public static final String CAMPO_DESCRIPCION = "descripcion";

    public static final String CREAR_TABLA_RAZA = "CREATE TABLE "+TABLA_RAZA+" ("+CAMPO_RAZA+" TEXT, "+ CAMPO_TAMAÑO+" INTEGER, "+CAMPO_VELOCIDAD+" INTEGER, "+CAMPO_FUERZA+" INTEGER, "+CAMPO_DESTREZA+"INTEGER,"+CAMPO_CONSTITUCION+" INTEGER, "+CAMPO_INTELIGENCIA+" INTEGER, "+CAMPO_SABIDURIA+" INTEGER, "+CAMPO_CARISMA+" INTEGER, "+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_LENGUA1+" TEXT, "+CAMPO_LENGUA2+" TEXT)";
    public static final String LLENAR_TABLA_RAZA = "INSERT INTO  "+TABLA_RAZA+" ("+CAMPO_RAZA+","+ CAMPO_TAMAÑO+" , "+CAMPO_VELOCIDAD+", "+CAMPO_FUERZA+", "+CAMPO_DESTREZA+","+CAMPO_CONSTITUCION+", "+CAMPO_INTELIGENCIA+", "+CAMPO_SABIDURIA+", "+CAMPO_CARISMA+", "+CAMPO_DESCRIPCION+", "+CAMPO_LENGUA1+", "+CAMPO_LENGUA2+")"+ " VALUES('humano',1,11,1,1,1,1,1,1,1,'loco','comun','comun')";






}
