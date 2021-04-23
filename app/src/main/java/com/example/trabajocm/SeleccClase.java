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
import android.widget.Toast;

import com.example.trabajocm.interfaces.ClaseService;
import com.example.trabajocm.modelos.Clase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SeleccClase extends AppCompatActivity {
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

    public List<Clase> ls_clases;
    public Clase clase_Seleccionada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.test_api_rest);

        setContentView(R.layout.creacion_pj_clase_2);

        //Cargar las clases de la API
        //getMethod();
        ls_clases = Datos.getLs_clases();

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
                //proficiencias
                comp_armas.setText(Arrays.toString(clase_Seleccionada.getProficiencias().getArmas()));
                //TODO añadir DB
                comp_armaduras.setText(Arrays.toString(clase_Seleccionada.getProficiencias().getArmaduras()));
                //TODO añadir DB

                //Habilidad especial
                cabecera_hab_esp.setText(clase_Seleccionada.getHabilidad_esp().getNombre_hab());
                //TODO añadir DB
                text_hab_esp.setText(clase_Seleccionada.getHabilidad_esp().getDescripcion_hab().toString());
                //TODO añadir DB

                //Spinner de habilidades
                /*
                List<String>ls_habilidades = clase_Seleccionada.getProficiencias().getHabilidades();
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);
                */
                String[] opciones_hab_spinner = clase_Seleccionada.getProficiencias().getHabilidades();

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
                //TODO añadir a DB
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //evento click_icono - > Info clase ventana emergente
        icono_info_clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clase_Seleccionada.getNombre().equals("Paladín")){
                    startActivity(new Intent(SeleccClase.this, PopUpPaladin.class));
                }else if(clase_Seleccionada.getNombre().equals("Brujo")){
                    startActivity(new Intent(SeleccClase.this,PopUpBrujo.class));
                }
            }
        });

        //Spinner selec_equipo metodo
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

    }

    /*
    private void getMethod(){
        //Create Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cm2021.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create service
        ClaseService claseService = retrofit.create(ClaseService.class);
        Call<List<Clase>> call = claseService.getClases();

        ls_clases = new ArrayList<>();

        call.enqueue(new Callback<List<Clase>>() {

            @Override
            public void onResponse(Call<List<Clase>> call, Response<List<Clase>> response) {

                if(response.isSuccessful()){
                    List<Clase> aux = response.body();

                    for(Clase c : aux){
                        if(c.getId()!= 0){
                            //Log.i("----DATA clase", c.toString());
                            ls_clases.add(c);
                        }
                    }
                    //Log.i("----DATA clase", ls_clases.toString());
                }else{
                    Log.e("ResponseFail", "on Response: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Clase>> call, Throwable t) {
                Log.e("----- ERROR",t.getMessage());
            }
        });
    }

     */

}
