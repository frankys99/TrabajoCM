package com.example.trabajocm;

import com.example.trabajocm.modelos.Clase;

import java.util.List;

public class Datos {
    private static List<Clase> ls_clases;
    //razas
    //...

    public static void iniDatosClases(List<Clase>cl){
        ls_clases = cl;
    }

    public static List<Clase> getLs_clases() {
        return ls_clases;
    }
}
