package com.example.trabajocm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajocm.interfaces.ApiService;
import com.example.trabajocm.modelos.Clase;
import com.example.trabajocm.modelos.Raza;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private boolean esta_cargando = true;

    private Button b_crear_personaje;
    private Button b_mis_personajes;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarar elementos de la UI
        b_crear_personaje = findViewById(R.id.b_crea_pj);
        b_mis_personajes = findViewById(R.id.b_mis_pjs);

        progress_bar = findViewById(R.id.progressBar);

        //Acceder API Rest -> Cargar Clases y Razas
        obtenerDatos();

        //Temporizador
        TareaAsincrona t = new TareaAsincrona();
        t.execute(10);

        b_crear_personaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Crea_personaje_1.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

        b_mis_personajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Mis_personajes.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

    }


    private class TareaAsincrona extends AsyncTask<Integer,Integer,String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Carga completa!";
        }

        /* AsyncTask<String,Void,Boolean>
        @Override
        protected Boolean doInBackground(String... urls) {
            try{
                obtenerDatos();
                if(!esta_cargando){
                    return true;
                }else {
                    return false;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }

         */

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progress_bar.setProgress(0);
            progress_bar.setVisibility(View.GONE);
            b_crear_personaje.setVisibility(View.VISIBLE);
            b_mis_personajes.setVisibility(View.VISIBLE);

        }
    }

    private void obtenerDatos(){

        //Ls a crear
        List<Clase> ls_clases = new ArrayList<>();
        List<Raza> ls_razas = new ArrayList<>();

        //Create Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cm2021.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create service using the interface
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Clase>> call_clases = apiService.getClases();
        Call<List<Raza>> call_razas = apiService.getRazas();

        call_clases.enqueue(new Callback<List<Clase>>() {

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
                Log.e("-- ERROR CARGAR API",t.getMessage());
            }
        });

        call_razas.enqueue(new Callback<List<Raza>>() {
            @Override
            public void onResponse(Call<List<Raza>> call, Response<List<Raza>> response) {
                if(response.isSuccessful()){
                    List<Raza> aux = response.body();

                    for(Raza r : aux){
                        if(r.getId()!= 0){
                            ls_razas.add(r);
                        }
                    }
                }else{
                    Log.e("ResponseFail", "on Response: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Raza>> call, Throwable t) {
                Log.e("-- ERROR CARGAR API",t.getMessage());
            }
        });

        //Cargar los datos
        Datos.iniDatosClases(ls_clases);
        Datos.initDatosRazas(ls_razas);
        esta_cargando = false;
    }
}