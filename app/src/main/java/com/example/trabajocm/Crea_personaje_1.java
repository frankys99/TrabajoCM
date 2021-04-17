package com.example.trabajocm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crea_personaje_1 extends Activity {

    ImageView imagen;

    private Spinner spinner1;
    private Spinner spinner2;
    private String alineamiento;
    private String raza;
    private String nombre;
    private Integer velocidad;
    private String tamaño;
    private Button atras;
    private Map<String,List<String>> statsRazas = new HashMap<>();
    // statsRazas = <Raza, [tamaño, velocidad, stat1, valorstat1, stat2, valorstat2]>
    //                                                            opcional,opcional

    //Listas auxiliares para statsRazas
    List<String> dragonborn = new ArrayList<String>(Arrays.asList("Medium", "30", "Charisma", "1", "Strength", "2"));
    List<String> dwarf = new ArrayList<String>(Arrays.asList("Medium", "25", "Constitution", "2"));
    List<String> elf = new ArrayList<String>(Arrays.asList("Medium", "30", "Dexterity", "2"));
    List<String> gnome = new ArrayList<String>(Arrays.asList("Small", "25", "Intelligence", "2"));
    List<String> half_elf = new ArrayList<String>(Arrays.asList("Medium", "30", "Charisma", "2"));
    List<String> half_orc = new ArrayList<String>(Arrays.asList("Medium", "30", "Constitution", "1", "Strength", "2"));
    List<String> halfling = new ArrayList<String>(Arrays.asList("Small", "30", "Dexterity", "2"));
    List<String> human = new ArrayList<String>(Arrays.asList("Small", "30"));
    List<String> tiefling = new ArrayList<String>(Arrays.asList("Small", "30"));

    public void setStatsRazas(Map<String, List<String>> statsRazas) {
        this.statsRazas.put("Dragonborn",dragonborn);
        this.statsRazas.put("Dwarf",dwarf);
        this.statsRazas.put("Elf",elf);
        this.statsRazas.put("Gnome",gnome);
        this.statsRazas.put("Half-Elf",half_elf);
        this.statsRazas.put("Half-Orc",half_orc);
        this.statsRazas.put("Halfling",halfling);
        this.statsRazas.put("Human",human);
        this.statsRazas.put("Tiefling",tiefling);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_1);
        // Inicializamos el diccionario con los datos de las razas
        setStatsRazas(statsRazas);
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


        atras =findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crea_personaje_1.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
