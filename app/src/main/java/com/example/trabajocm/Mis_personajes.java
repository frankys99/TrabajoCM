package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajocm.adaptadores.ListaPersonajesAdapter;
import com.example.trabajocm.db.dbPersonajes;
import com.example.trabajocm.entidades.personaje;

import java.util.ArrayList;


public class Mis_personajes extends Activity {


    private Button atras;
    RecyclerView listaPersonajes;
    ArrayList<personaje> listaArrayPersonaje;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_personajes);
        listaPersonajes = findViewById(R.id.listaPersonajes);
        listaPersonajes.setLayoutManager(new LinearLayoutManager(this));

        dbPersonajes dbContactos = new dbPersonajes(Mis_personajes.this);

        listaArrayPersonaje = new ArrayList<>();

        ListaPersonajesAdapter adapter = new ListaPersonajesAdapter(dbContactos.mostrarPersonaje());
        listaPersonajes.setAdapter(adapter);
        atras =findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }});

/*
        atras =findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }


}
