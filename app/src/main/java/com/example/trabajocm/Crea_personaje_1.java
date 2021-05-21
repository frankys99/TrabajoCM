package com.example.trabajocm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Crea_personaje_1 extends Activity {
    private ImageView imagen;
    private EditText nombre;
    private TextView textoRazas;
    private Spinner spinnerAlineamientos;
    private Spinner spinnerRazas;
    private Button atras;
    private Map<String,List<String>> statsRazas = new HashMap<>();

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
                textoRazas.setText("Seleccionado "+ razaSeleccionada);

                // Reiniciamos los text view para que al seleccionar otro elemento no haya duplicidades en el texto
                vel.setText("Velocidad:");
                tam.setText("Tamaño:");
                comp.setText("Competencias de habilidades:");

                // Actualizamos los valores de los atributos con la raza seleccionada
                // statsRazas = <Raza, [tamaño, velocidad, stat1, valorstat1, stat2, valorstat2]>

                vel.setText(vel.getText() + " " + statsRazas.get(razaSeleccionada).get(1));
                Datos.setVelocidad(statsRazas.get(razaSeleccionada).get(1));
                tam.setText(tam.getText() + " " + statsRazas.get(razaSeleccionada).get(0));
                Datos.setTamaño(statsRazas.get(razaSeleccionada).get(0));
                if(statsRazas.get(razaSeleccionada).size()==6){
                    Datos.setRaza(razaSeleccionada);
                    Datos.setCompetencias(statsRazas.get(razaSeleccionada).get(2) + " " +statsRazas.get(razaSeleccionada).get(3) + " " + statsRazas.get(razaSeleccionada).get(4) + " " +statsRazas.get(razaSeleccionada).get(5));
                    comp.setText(comp.getText() + " " + statsRazas.get(razaSeleccionada).get(2) + " + "+ statsRazas.get(razaSeleccionada).get(3) +
                            ", " + statsRazas.get(razaSeleccionada).get(4) + " + " + statsRazas.get(razaSeleccionada).get(5));

                }else if(statsRazas.get(razaSeleccionada).size()==4){
                    Datos.setRaza(razaSeleccionada);
                    Datos.setCompetencias(statsRazas.get(razaSeleccionada).get(2) + statsRazas.get(razaSeleccionada).get(3));
                    comp.setText(comp.getText() + " " + statsRazas.get(razaSeleccionada).get(2) + " + "+ statsRazas.get(razaSeleccionada).get(3));
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

    }
    // Funcion para pasar datos a otra activity
    public void ejecuta_suguiente(View view){      // Cambiar por clase a la que va dirigida
        Intent j = new Intent(this, Crea_personaje_2.class);
        Datos.setNombre(nombre.getText().toString());
        Log.i("---->",DatosAux.getLs_razas().toString());
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
            imagen.setImageURI(path);
            Datos.setUri(path);
        }
    }
}