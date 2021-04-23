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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getClases();
    }

    //Se ejecuta haciendo click boton de activity_main.xml
    //android:onClick="ejecuta_selecClase"
    public void ejecuta_selecClase(View view){
        Intent i = new Intent(this, SeleccClase.class);
        startActivity(i);
    }

    private void getClases(){
        //Ls a crear
        List<Clase> ls_clases = new ArrayList<>();

        //Create Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cm2021.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Create service
        ClaseService claseService = retrofit.create(ClaseService.class);
        Call<List<Clase>> call = claseService.getClases();


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

        Datos.iniDatosClases(ls_clases);
    }
}
