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


    //Metodos genericos para formatear datos de la api
    public static String formatListaTexto(List<String>ls){
        String res = "";
        for(int i = 0; i<ls.size();i++){
            if(ls.get(i).contains(".")){
                String aux = ls.get(i).replace(".",".\n");
                res += aux;
            }else{
                res += ls.get(i) + " ";
            }
        }
        return  res;
    }

    public static String formatListaElem(List<String>ls){
        String res = "";
        for(int i = 0; i<ls.size();i++){
            String aux = ls.get(i);
            res += aux + "\n";
        }
        return  res;
    }
}
