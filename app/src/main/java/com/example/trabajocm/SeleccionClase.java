package com.example.trabajocm;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionClase extends AppCompatActivity {
    /*
    private Spinner clases_spiner;

    public List<Clase>ls_clases = new ArrayList<>();

    public void cargarClases(){

        List<Clase> res = new ArrayList<>();

        //Paladin

        //--Ls proficiencias
        HashMap<String, List<String>> pala_profi = new HashMap<>();
        pala_profi.put("Armadura", Arrays.asList("Armadura de tela","Armadura de cuero ","Armadura de malla"));
        pala_profi.put("Armas",Arrays.asList("Armas simples","Armas marciales"));
        pala_profi.put("Herramientas", new ArrayList<>());
        pala_profi.put("Salvaciones",Arrays.asList("Carisma","Sabiduria"));
        //Se tendría que seleccionar solo dos...
        pala_profi.put("Habilidades",Arrays.asList("Atlético","Médico","Religioso"));
        //--Ls equipamiento
        List<String> pala_equipo = Arrays.asList("Maza de una mano","Escudo","Pack de sacerdote","Simbolo sagrado","Armadura pesada");

        res.add(new Clase("Paladín","./Definir",pala_profi,pala_equipo,100.00));

        //Brujo
        //--ls proficiencias
        HashMap<String, List<String>> brujo_profi = new HashMap<>();
        brujo_profi.put("Armadura",Arrays.asList("Armadura ligera"));
        brujo_profi.put("Armas",Arrays.asList("Armas simples"));
        brujo_profi.put("Herramientas",new ArrayList<>());
        brujo_profi.put("Salvaciones",Arrays.asList("Sabiduría","Carisma"));
        brujo_profi.put("Habilidades",Arrays.asList("Intimidador","Investigador","Maldiciones"));
        //--ls equipamiento
        List<String>brujo_equipo = Arrays.asList("Baston","Paquete de erudito","Enfoque maldito","Armadura de tela");

        res.add(new Clase("Brujo","./Definir",brujo_profi,brujo_equipo,120.00));

        //return res;
        ls_clases = res;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creacion_pj_clase);
        cargarClases();

        //Spinner de selec clases
        String[] opciones_spinner_clases = new String[ls_clases.size()];
        for(int i = 0; i < ls_clases.size(); i++){
            opciones_spinner_clases[i] = ls_clases.get(i).nombre;
        };
        clases_spiner = (Spinner)findViewById(R.id.clases_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones_spinner_clases);
        clases_spiner.setAdapter(adapter);
    }

     */
}
