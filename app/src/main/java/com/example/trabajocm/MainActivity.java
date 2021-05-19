package com.example.trabajocm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajocm.db.dbPersonajes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Acceder API Rest -> Cargar Clases y Razas
        obtenerDatos();

        //btnCrear = findViewById(R.id.btnCrear);
        /*btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db!=null){
                    Toast.makeText(MainActivity.this,"BASE CREADA",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_LONG).show();

                }
            }
        });*/
    }
    public void ejecuta_crea_personaje(View view){
        dbPersonajes DBPersonajes = new dbPersonajes(MainActivity.this);
        long id = DBPersonajes.insertarPersonajeNull();

        if (id >0){
            Toast.makeText(MainActivity.this,"VAMOOOOOOOOSSS", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"SU PUTA MADRE", Toast.LENGTH_LONG).show();
        }
        Intent i = new Intent(this, Crea_personaje_1.class);
        startActivity(i);
    }
    public void ejecuta_mis_personajes(View view){
        Intent j = new Intent(this, Mis_personajes.class);
        startActivity(j);
    }

    private void obtenerDatos(){
        /*
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

         */
    }
}