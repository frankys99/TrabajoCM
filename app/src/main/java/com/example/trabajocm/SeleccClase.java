package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trabajocm.modelos.Clase;

import java.util.Arrays;
import java.util.List;

public class SeleccClase extends AppCompatActivity {
    private Spinner clases_spiner;
    private Spinner comp_hab_1;
    private Spinner comp_hab_2;
    //private Spinner selec_equipo;

    private TextView info_clase;
    private TextView comp_armas;
    private TextView comp_armaduras;
    private TextView cabecera_hab_esp;
    private TextView text_hab_esp;
    private TextView res_spinner_sel_equipo;

    private ImageView icono_info_clase;

    public List<Clase> ls_clases;
    public Clase clase_Seleccionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.creacion_pj_clase_2);

        //Cargar las clases de la APIRest
        ls_clases = Datos.getLs_clases();

        //TEST RAZASAPI
        Log.i("---CARGA\n", Datos.getLs_razas().toString());

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
        //selec_equipo = (Spinner)findViewById(R.id.spinner_selec_equipo);


        //Spinner de selec clases
        String[] opciones_spinner_clases = new String[ls_clases.size()];
        for(int i = 0; i < ls_clases.size(); i++){
            opciones_spinner_clases[i] = ls_clases.get(i).getNombre();
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones_spinner_clases);
        clases_spiner.setAdapter(adapter);

        //Set clase_spinner method
        clases_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for(Clase cl : ls_clases){
                    if(cl.getNombre() == clases_spiner.getSelectedItem().toString()){
                        clase_Seleccionada = cl;
                        //TODO añadir DB
                    }
                }

                info_clase.setText("Información sobre: " + clase_Seleccionada.getNombre());

                //PROFICIENCIAS
                String armas_s = Datos.formatListaElem(clase_Seleccionada.getProficiencias().getArmas());
                comp_armas.setText(armas_s);
                //TODO añadir DB

                String armaduras_s = Datos.formatListaElem(clase_Seleccionada.getProficiencias().getArmaduras());
                comp_armaduras.setText(armaduras_s);
                //TODO añadir DB

                //HABILIDAD ESPECIAL DE LA CLASE
                cabecera_hab_esp.setText(clase_Seleccionada.getHabilidad_esp().getNombre_hab());
                //TODO añadir DB
                String descripcion_hab_s = Datos.formatListaTexto(clase_Seleccionada.getHabilidad_esp().getDescripcion_hab());
                text_hab_esp.setText(descripcion_hab_s);
                //TODO añadir DB

                //HABILIDADES A ESCOGER
                //Spinner de habilidad_1
                List<String>ls_habilidades = clase_Seleccionada.getProficiencias().getHabilidades();
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);

                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                comp_hab_1.setAdapter(adapter2);
                //TODO añadir DB

                    //TODO AÑADIR BLANK ITEM AL SPINNER -> ¿Con DropDownView?
                    //Eliminar selección del spinner -> evitar duplicados
                    comp_hab_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            ls_habilidades.remove(comp_hab_1.getSelectedItem());

                            //Spinner habilidad_2
                            String[] opciones_hab_2_spinner = new String[ls_habilidades.size()];
                            ls_habilidades.toArray(opciones_hab_2_spinner);
                            ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_2_spinner);
                            comp_hab_2.setAdapter(adapter3);
                            //TODO añadir DB
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                /*
                //Spinner selec equipo/oro
                String[] opciones_equipo_def = new String[]{"Equipo inicial","Oro"};
                ArrayAdapter<String>adapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_equipo_def);
                selec_equipo.setAdapter(adapter4);
                 */

                //EQUIPO INICIAL
                String equipo_ini_s = Datos.formatListaElem(clase_Seleccionada.getEquipo_inicial());
                res_spinner_sel_equipo.setText(equipo_ini_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //EVENTO ON-CLICK ÍCONO - > Info clase ventana emergente
        icono_info_clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clase_Seleccionada.getNombre().equals("Paladin")){
                    startActivity(new Intent(SeleccClase.this, PopUpPaladin.class));
                }else if(clase_Seleccionada.getNombre().equals("Brujo")){
                    startActivity(new Intent(SeleccClase.this,PopUpBrujo.class));
                }
            }
        });

        //Spinner selec_equipo metodo
        /* DESPRECIADO -> NO SE DA A ESCOGER
        selec_equipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(selec_equipo.getSelectedItem().equals("Equipo inicial")){
                    res_spinner_sel_equipo.setText("Equipo Inicial:\n" + clase_Seleccionada.getEquipo_inicial());
                    //TODO añadir DB
                }else if(selec_equipo.getSelectedItem().equals("Oro")){
                    res_spinner_sel_equipo.setText("Dinero:\n" + clase_Seleccionada.getDinero_inicial() + " monedas de oro.");
                    //TODO añadir DB
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
    }
}
