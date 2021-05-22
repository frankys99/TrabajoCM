package com.example.trabajocm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trabajocm.entidades.Personaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Crea_personaje_1 extends Activity {
    private ImageView imagen;
    Personaje p1= new Personaje();
    private EditText nombre;
    private TextView textoRazas;
    private Spinner spinnerAlineamientos;
    private Spinner spinnerRazas;
    private Button atras;
    private Button siguiente;
    private Map<String,List<String>> statsRazas = new HashMap<>();

    //Listas auxiliares para statsRazas
    List<String> dragonborn = new ArrayList<String>(Arrays.asList("Tu puntuación de Fuerza aumenta en 2, y tu puntuación de Carisma aumenta en 1.","Mediano", "30", "Carisma", "1", "Fuerza", "2"));
    List<String> dwarf = new ArrayList<String>(Arrays.asList("Tu puntuación de Constitución aumenta en 2.","Mediano", "25", "Constitución", "2"));
    List<String> elf = new ArrayList<String>(Arrays.asList("Tu puntuación de destreza aumenta en 2.","Mediano", "30", "Destreza", "2"));
    List<String> gnome = new ArrayList<String>(Arrays.asList("Tu puntuación de inteligencia aumenta en 2.","Pequeño", "25", "Inteligencia", "2"));
    List<String> half_elf = new ArrayList<String>(Arrays.asList("Tu puntuación de carisma aumenta en 2, y otras dos puntuaciones de habilidad a tu elección aumentan en 1.","Mediano", "30", "Carisma", "2"));
    List<String> half_orc = new ArrayList<String>(Arrays.asList("Tu puntuación de Fuerza aumenta en 2, y tu puntuación de Constitución aumenta en 1.","Mediano", "30", "Constitución", "1", "Fuerza", "2"));
    List<String> halfling = new ArrayList<String>(Arrays.asList("Tu puntuación de destreza aumenta en 2.","Pequeño", "30", "Destreza", "2"));
    List<String> human = new ArrayList<String>(Arrays.asList("Tus puntuaciones de habilidad aumentan cada una en 1.","Pequeño", "30"));
    List<String> tiefling = new ArrayList<String>(Arrays.asList("Tu puntuación de Inteligencia aumenta en 1, y tu puntuación de Carisma aumenta en 2.","Pequeño", "30"));

    public void setStatsRazas(Map<String, List<String>> statsRazas) {
        this.statsRazas.put("Dracónido",dragonborn);
        this.statsRazas.put("Enano",dwarf);
        this.statsRazas.put("Elfo",elf);
        this.statsRazas.put("Gnomo",gnome);
        this.statsRazas.put("Medio elfo",half_elf);
        this.statsRazas.put("Medio orco",half_orc);
        this.statsRazas.put("Mediano",halfling);
        this.statsRazas.put("Humano",human);
        this.statsRazas.put("Tiefling",tiefling);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_1);


        // Inicializamos el diccionario con los datos de las razas
        setStatsRazas(statsRazas);

        imagen = (ImageView) findViewById(R.id.imageId);
        Datos.setImagen(imagen);

        textoRazas= (TextView) findViewById(R.id.textoRaza);
        spinnerAlineamientos = (Spinner) findViewById(R.id.spinnerAlineamientos);
        spinnerRazas = (Spinner) findViewById(R.id.spinnerRazas);

        // Proporcionamos la identificación de los cuadros de texto para modificarlos después
        TextView vel = (TextView) findViewById(R.id.velocidad);
        TextView tam = (TextView) findViewById(R.id.tamaño);
        TextView comp = (TextView) findViewById(R.id.competencias);

        // Obtenemos el nombre del personaje
        nombre= (EditText) findViewById(R.id.nombrePersonaje);

        // Adaptadores spinners
        ArrayAdapter<CharSequence> adapterAlineamientos = ArrayAdapter.createFromResource(this,R.array.ArrayAlineamientos, android.R.layout.simple_spinner_item);
        spinnerAlineamientos.setAdapter(adapterAlineamientos);
        ArrayAdapter<CharSequence> adapterRazas = ArrayAdapter.createFromResource(this,R.array.ArrayRazas, android.R.layout.simple_spinner_item);
        spinnerRazas.setAdapter(adapterRazas);

        spinnerAlineamientos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            //Para seleccionar y pasar el alineamiento a otra pantalla
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Datos.setAlineamiento(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // NO hacer nada
            }
        });

        spinnerRazas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Poner en setText el texto diseñado para cada raza
                String razaSeleccionada = parent.getItemAtPosition(position).toString();
                textoRazas.setText(statsRazas.get(razaSeleccionada).get(0));

                // Reiniciamos los text view para que al seleccionar otro elemento no haya duplicidades en el texto
                vel.setText("Velocidad:");
                tam.setText("Tamaño:");
                comp.setText("Competencias de habilidades:");

                // Actualizamos los valores de los atributos con la raza seleccionada
                // statsRazas = <Raza, [tamaño, velocidad, stat1, valorstat1, stat2, valorstat2]>

                vel.setText(vel.getText() + " " + statsRazas.get(razaSeleccionada).get(2));
                Datos.setVelocidad(statsRazas.get(razaSeleccionada).get(2));
                tam.setText(tam.getText() + " " + statsRazas.get(razaSeleccionada).get(1));
                Datos.setTamaño(statsRazas.get(razaSeleccionada).get(1));
                if(statsRazas.get(razaSeleccionada).size()==7){
                    Datos.setRaza(razaSeleccionada);
                    Datos.setCompetencias(statsRazas.get(razaSeleccionada).get(3) + " " +statsRazas.get(razaSeleccionada).get(4) + " " + statsRazas.get(razaSeleccionada).get(5) + " " +statsRazas.get(razaSeleccionada).get(6));
                    comp.setText(comp.getText() + " " + statsRazas.get(razaSeleccionada).get(3) + " + "+ statsRazas.get(razaSeleccionada).get(4) +
                            ", " + statsRazas.get(razaSeleccionada).get(5) + " + " + statsRazas.get(razaSeleccionada).get(6));

                }else if(statsRazas.get(razaSeleccionada).size()==5){
                    Datos.setRaza(razaSeleccionada);
                    Datos.setCompetencias(statsRazas.get(razaSeleccionada).get(3) + statsRazas.get(razaSeleccionada).get(4));
                    comp.setText(comp.getText() + " " + statsRazas.get(razaSeleccionada).get(3) + " + "+ statsRazas.get(razaSeleccionada).get(4));
                }else{
                    Datos.setRaza(razaSeleccionada);
                    Datos.setCompetencias("");
                    comp.setText(comp.getText() + " Esta raza no tiene competencias extra");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // NO hacer nada
            }
        });


        // Boton para ir hacia atrás
        atras =findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Crea_personaje_1.this, MainActivity.class);
                startActivity(intent);
            }
        });

        siguiente =findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecuta_suguiente(v);
            }
        });

    }
    //la primera si puede tenerlo fuera ya que esta es la que comienza el objeto, el resto debe esatr dentro del oncreate pues es-
    //el que puede acceder al objeto que le pasamos y por tanto si trabjamos con el objeto fuera del onCreate, este no existira o -
    //estara vacio.

    // Funcion para pasar datos a otra activity
    public void ejecuta_suguiente(View view){      // Cambiar por clase a la que va dirigida
        Intent j = new Intent(this, Crea_personaje_2.class);

        p1.setNombre(nombre.getText().toString());
        Spinner mySpinner = (Spinner) findViewById(R.id.spinnerRazas);
        String raza = mySpinner.getSelectedItem().toString();
        p1.setRaza(raza);
        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinnerAlineamientos);
        String alineamiento = mySpinner.getSelectedItem().toString();
        p1.setAlineamiento(alineamiento);

        j.putExtra("p1",  p1);

        Datos.setNombre(nombre.getText().toString());

        startActivity(j);
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
            p1.setImagen(path.toString());
            imagen.setImageURI(path);
            Datos.setUri(path);
        }
    }
}