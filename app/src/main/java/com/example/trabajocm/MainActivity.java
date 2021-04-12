package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
    private Spinner selec_equipo;

    private TextView info_clase;
    private TextView comp_armas;
    private TextView comp_armaduras;
    private TextView cabecera_hab_esp;
    private TextView text_hab_esp;
    private TextView res_spinner_sel_equipo;

    private ImageView icono_info_clase;

    public List<Clase> ls_clases = new ArrayList<>();
    public Clase clase_Seleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creacion_pj_clase_2);
        cargarClases();

        //Declarar TextView
        info_clase = (TextView)findViewById(R.id.text_info_clase);
        comp_armas = (TextView)findViewById(R.id.text_comp_armas);
        comp_armaduras = (TextView)findViewById(R.id.text_comp_armaduras);
        res_spinner_sel_equipo = (TextView)findViewById(R.id.res_spinner_equipo);
        cabecera_hab_esp = (TextView)findViewById(R.id.cabecera_hab_esp);
        text_hab_esp = (TextView)findViewById(R.id.text_hab_esp);

        //Declarar imageView
        icono_info_clase =(ImageView)findViewById(R.id.icono_info_clase);

        //Declarar Spinners
        clases_spiner = (Spinner)findViewById(R.id.clases_spinner);
        comp_hab_1 = (Spinner)findViewById(R.id.spinner_comp_hab_1);
        comp_hab_2 = (Spinner)findViewById(R.id.spinner_comp_hab_2);
        selec_equipo = (Spinner)findViewById(R.id.spinner_selec_equipo);


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
                        //TODO añadir DB
                    }
                }
                info_clase.setText(clase_Seleccionada.nombre);
                comp_armas.setText(clase_Seleccionada.proficiencias.get("Armas").toString());
                //TODO añadir DB
                comp_armaduras.setText(clase_Seleccionada.proficiencias.get("Armaduras").toString());
                //TODO añadir DB
                cabecera_hab_esp.setText(clase_Seleccionada.hab_especial.get(0));
                //TODO añadir DB
                text_hab_esp.setText(clase_Seleccionada.hab_especial.get(1));
                //TODO añadir DB

                //Spinner de habilidades
                List<String>ls_habilidades = clase_Seleccionada.proficiencias.get("Habilidades");
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);

                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_1.setAdapter(adapter2);
                //TODO añadir DB
                //TODO Elminar var seleccionada
                ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_2.setAdapter(adapter3);
                //TODO añadir DB
                //TODO Elminar var seleccionada

                //Spinner selec equipo/oro
                String[] opciones_equipo_def = new String[]{"Equipo inicial","Oro"};
                ArrayAdapter<String>adapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_equipo_def);
                selec_equipo.setAdapter(adapter4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Info clase ventana emergente
        icono_info_clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clase_Seleccionada.getNombre().equals("Paladín")){
                    startActivity(new Intent(MainActivity.this,PopUpPaladin.class));
                }else if(clase_Seleccionada.getNombre().equals("Brujo")){
                    startActivity(new Intent(MainActivity.this,PopUpBrujo.class));
                }
            }
        });

        //Spinner selec_equipo metodo
        selec_equipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(selec_equipo.getSelectedItem().equals("Equipo inicial")){
                    res_spinner_sel_equipo.setText("Equipo Inicial:\n" + clase_Seleccionada.equipo.toString());
                    //TODO añadir DB
                }else if(selec_equipo.getSelectedItem().equals("Oro")){
                    res_spinner_sel_equipo.setText("Dinero:\n" + clase_Seleccionada.dinero.toString() + " monedas de oro.");
                    //TODO añadir DB
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



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
        pala_profi.put("Habilidades",Arrays.asList("Atlético","Médico","Religioso"));
        //--ls hab_especial : pos 0 -> titulo/cabecera, pos 1 -> descripción
        List<String> pala_hab_esp = Arrays.asList("Imposición de manos",
            "Tu toque bendito puede curar heridas.Tienes una reserva de poder curativo que se repone cuando tomas un descanso" +
            " prolongado. Con esa reserva, puedes restaruar un total  de puntos de golpes igual al nivel del paladín x5.");
        //--Ls equipamiento
        List<String> pala_equipo = Arrays.asList("Maza de una mano","Escudo","Pack de sacerdote","Simbolo sagrado","Armadura pesada");

        res.add(new Clase("Paladín","./Definir",pala_profi,pala_hab_esp,pala_equipo,100.00));

        //Brujo
        //--ls proficiencias
        HashMap<String, List<String>> brujo_profi = new HashMap<>();
        brujo_profi.put("Armaduras",Arrays.asList("Armadura de tela"));
        brujo_profi.put("Armas",Arrays.asList("Armas simples"));
        brujo_profi.put("Herramientas",new ArrayList<>());
        brujo_profi.put("Salvaciones",Arrays.asList("Sabiduría","Carisma"));
        brujo_profi.put("Habilidades",Arrays.asList("Intimidador","Investigador","Maldiciones"));
        //--ls hab_especial : pos 0 -> titulo/cabecera, pos 1 -> descripción
        List<String>brujo_hab_esp = Arrays.asList("Hechizos",
            "Dispones de dos hechizos de nivel 1:\n   -Invocar diablillo.\n   -Descarga de las sombras.");
        //--ls equipamiento
        List<String>brujo_equipo = Arrays.asList("Baston","Paquete de erudito","Enfoque maldito","Armadura de tela");

        res.add(new Clase("Brujo","./Definir",brujo_profi,brujo_hab_esp,brujo_equipo,120.00));

        //return res;
        ls_clases = res;
    }
}