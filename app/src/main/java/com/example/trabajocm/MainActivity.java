package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    //PANTALLA PROVISIONAL
    //YA QUE RETROFIT ES UNA PETICIÓN ASYNC => CARGAR PREVIAMENTE
    // API REST =>  https://github.com/keffren/CM2021-API

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtenerDatos();
    }

    //Se ejecuta haciendo click boton de activity_main.xml
    // .xml -> android:onClick="ejecuta_selecClase"
    public void ejecuta_selecClase(View view){
        Intent i = new Intent(this, SeleccClase.class);
        startActivity(i);
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
                Log.e("----- ERROR",t.getMessage());
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
                Log.e("----- ERROR",t.getMessage());
            }
        });

        Datos.iniDatosClases(ls_clases);
        Datos.initDatosRazas(ls_razas);
    }
}
