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
}