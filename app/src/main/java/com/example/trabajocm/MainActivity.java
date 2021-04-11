package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner clases_spiner;
    private Spinner comp_hab_1;
    private Spinner comp_hab_2;

    private TextView info_clase;
    private TextView comp_armas;
    private TextView comp_armaduras;

    public List<Clase> ls_clases = new ArrayList<>();
    public Clase clase_Seleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creacion_pj_clase);
        cargarClases();

        //Declarar TextView
        info_clase = (TextView)findViewById(R.id.info_clase);
        comp_armas = (TextView)findViewById(R.id.text_comp_armas);
        comp_armaduras = (TextView)findViewById(R.id.text_comp_armaduras);
        //Declarar Spinners
        clases_spiner = (Spinner)findViewById(R.id.clases_spinner);
        comp_hab_1 = (Spinner)findViewById(R.id.spinner_comp_hab_1);
        comp_hab_2 = (Spinner)findViewById(R.id.spinner_comp_hab_2);


        //Spinner de selec clases
        String[] opciones_spinner_clases = new String[ls_clases.size()];
        for(int i = 0; i < ls_clases.size(); i++){
            opciones_spinner_clases[i] = ls_clases.get(i).nombre;
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones_spinner_clases);
        clases_spiner.setAdapter(adapter);

        //Set clase_spinner method
        clases_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for(Clase cl : ls_clases){
                    if(cl.nombre == clases_spiner.getSelectedItem().toString()){
                        clase_Seleccionada = cl;
                    }
                }
                comp_armas.setText(clase_Seleccionada.proficiencias.get("Armas").toString());
                comp_armaduras.setText(clase_Seleccionada.proficiencias.get("Armaduras").toString());

                //Spinner de habilidades

                List<String>ls_habilidades = clase_Seleccionada.proficiencias.get("Habilidades");
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);

                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_1.setAdapter(adapter2);
                //TODO Elminar var seleccionada
                ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_2.setAdapter(adapter3);
                //TODO Elminar var seleccionada

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Spinners competencias
        //Va segun escoge la clase T.T

    }

    public void cargarClases(){

        List<Clase> res = new ArrayList<>();

        //Paladin

        //--Ls proficiencias
        HashMap<String, List<String>> pala_profi = new HashMap<>();
        pala_profi.put("Armaduras", Arrays.asList("Armadura de tela","Armadura de cuero ","Armadura de malla"));
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
        brujo_profi.put("Armaduras",Arrays.asList("Armadura ligera"));
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
}