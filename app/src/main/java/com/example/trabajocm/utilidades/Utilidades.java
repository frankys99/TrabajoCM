package com.example.trabajocm.utilidades;

public class Utilidades {
    public static final String TABLA_PERSONAJE = "personaje";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_CLASE = "clase";
    public static final String CAMPO_RAZA = "raza";
    public static final String CAMPO_SALVACIONES = "salvaciones";
    public static final String CAMPO_SECUNDARIAS = "secundarias";
    public static final String CAMPO_DOTES = "dotes";
    public static final String CAMPO_EQUIPO = "equipo";
    public static final String CAMPO_STATS = "stats";
    public static final String CAMPO_STATS_GENERALES = "stats_generales";
    public static final String CAMPO_HECHIZOS = "hechizos";

    public static String CREAR_TABLA_PERSONAJE = "CREATE TABLE "+TABLA_PERSONAJE+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ CAMPO_NOMBRE+" TEXT, "+CAMPO_CLASE+" TEXT, "+CAMPO_RAZA+" TEXT, "+CAMPO_SALVACIONES+" TEXT, "+CAMPO_SECUNDARIAS+" TEXT, "+CAMPO_DOTES+" TEXT, "+CAMPO_EQUIPO+" TEXT, "+CAMPO_STATS+" TEXT, "+CAMPO_STATS_GENERALES+" TEXT, "+CAMPO_HECHIZOS+" TEXT)";


}
