package com.example.trabajocm;

import com.example.trabajocm.modelos.Clase;
import com.example.trabajocm.modelos.Raza;

import java.util.List;

public class Datos {
    private static List<Clase> ls_clases;
    private static List<Raza> ls_razas;

    public static void iniDatosClases(List<Clase>cl){
        ls_clases = cl;
    }

    public static void initDatosRazas(List<Raza>rl){ls_razas = rl;}

    public static List<Clase> getLs_clases() {
        return ls_clases;
    }

    public static List<Raza> getLs_razas(){return ls_razas;}
}
