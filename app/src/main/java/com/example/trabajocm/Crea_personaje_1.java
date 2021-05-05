package com.example.trabajocm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class  Crea_personaje_1 extends Activity {

    ImageView imagen;

    private Spinner spinner1;
    private Spinner spinner2;
    private String alineamiento;
    private String raza;
    private String nombre;
    private Integer velocidad;
    private String tamaño;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_1);
        imagen = (ImageView) findViewById(R.id.imageId);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        String [] opciones1 ={"Dragonborn","Dwarf","Elf","Gnome","Half-Elf",
        "Half-Orc","Halfling","Human","Tiefling"};
        String [] opciones2 = {"Lawful Good","Lawful Neutral","Lawful Evil",
        "Neutral Good", "Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Evil",
                "Chaotic Neutral"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones1);
        spinner1.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones2);
        spinner2.setAdapter(adapter2);
    }
    // Funciones para los spinner
    public void raza(View view){
        String valor = spinner2.getSelectedItem().toString();
    }
    public void alineamiento(View view){
        alineamiento = spinner1.getSelectedItem().toString();
    }




    // Funciones para el boton de seleccion de imagen de galeria
    public void onclick(View view) {
        cargarimagen();
    }
    private void cargarimagen(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Seleccione la aplicación"),10);
    }
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode==RESULT_OK){
            Uri path=data.getData();
            imagen.setImageURI(path);
        }
    }
}
