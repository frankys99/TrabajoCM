package com.example.trabajocm.utilidades;

public class Utilidades {
    public static final String TABLA_PERSONAJE = "t_personaje";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_IMAGEN = "imagen";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CLASE = "clase";
    public static final String CAMPO_RAZA = "raza";
    public static final String CAMPO_ALINEAMIENTO = "salvaciones";
    public static final String CAMPO_SECUNDARIAS = "secundarias";
    public static final String CAMPO_TRASFONDO = "transfondo";
    public static final String CAMPO_EQUIPO = "equipo";
    public static final String CAMPO_FUERZA = "fuerza";
    public static final String CAMPO_DESTREZA = "destreza";
    public static final String CAMPO_CONSTITUCION = "constitucion";
    public static final String CAMPO_INTELIGENCIA = "inteligencia";
    public static final String CAMPO_SABIDURIA = "sabiduria";
    public static final String CAMPO_CARISMA = "carisma";


    public static final String CAMPO_NIVEL = "nivel";

    public static final String CAMPO_XP = "xp";
    public static final String CAMPO_HAB_ESPE = "habilidadEspecial";
    public static final String CAMPO_LENGUA1 = "lengua1";
    public static final String CAMPO_LENGUA2 = "lengua2";
    public static final String CAMPO_HECHIZO1 = "hechizo1";
    public static final String CAMPO_HECHIZO2 = "hechizo2";
    public static final String CAMPO_HECHIZO3 = "hechizo3";
    public static final String CAMPO_HECHIZO4 = "hechizo4";
    public static final String CAMPO_HECHIZO5 = "hechizo5";
    public static final String CAMPO_HECHIZO6 = "hechizo6";

    public static final String CREAR_TABLA_PERSONAJE = "CREATE TABLE "+TABLA_PERSONAJE+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_IMAGEN+" TEXT, "+ CAMPO_NOMBRE+" TEXT, "+CAMPO_CLASE+" TEXT, "+CAMPO_RAZA+" TEXT, "+CAMPO_ALINEAMIENTO+" TEXT, "+CAMPO_SECUNDARIAS+" TEXT, "+CAMPO_TRASFONDO+" TEXT, "+CAMPO_EQUIPO+" TEXT, "+CAMPO_FUERZA+" INTEGER, "+CAMPO_DESTREZA+" INTEGER,"+CAMPO_CONSTITUCION+" INTEGER, "+CAMPO_INTELIGENCIA+" INTEGER, "+CAMPO_SABIDURIA+" INTEGER, "+CAMPO_CARISMA+" INTEGER, "+CAMPO_NIVEL+" INTEGER, "+CAMPO_XP+" INTEGER, "+CAMPO_HAB_ESPE+" TEXT, "+CAMPO_LENGUA1+" TEXT, "+CAMPO_LENGUA2+" TEXT, "+CAMPO_HECHIZO1+" TEXT, "+CAMPO_HECHIZO2+" TEXT, "+CAMPO_HECHIZO3+" TEXT, "+CAMPO_HECHIZO4+" TEXT, "+CAMPO_HECHIZO5+" TEXT, "+CAMPO_HECHIZO6+" TEXT)";






}
