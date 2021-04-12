package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ejecuta_crea_personaje(View view){
        Intent i = new Intent(this, Crea_personaje_1.class);
        startActivity(i);
    }
    public void ejecuta_mis_personajes(View view){
        Intent j = new Intent(this, Mis_personajes.class);
        startActivity(j);
    }
}