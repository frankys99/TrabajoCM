package com.example.trabajocm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trabajocm.db.dbPersonajes;
import com.example.trabajocm.entidades.Personaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crea_transfondo extends Activity {

    private Spinner spinnerTransfondos;// = (Spinner) findViewById(R.id.spinnerTransfondo);
    private Spinner lenguaje1;// = (Spinner) findViewById(R.id.spinner2);
    private Spinner lenguaje2;// = (Spinner) findViewById(R.id.spinner3);

    private Button finalizar;

    String equipo = "";
    String competencias = "";
    String vlenguaje1 = "";
    String vlenguaje2 = "";

    private Map<String, List<String>> transfondosMapa = new HashMap<>();
    List<String> acólito = new ArrayList<String>(Arrays.asList("Perspicacia", "Religión", "Símbolo sagrado", "Devocionario", "x5 Varas de inciensos"));
    List<String> animador =  new ArrayList<String>(Arrays.asList("Acrobacias", "Interpretación", "Instrumento musical", "Favor de un fan", "Disfraz"));
    List<String> artesano =  new ArrayList<String>(Arrays.asList("Perspicacia", "Persuasión", "Herramientas de artesano", "Carta de presentación", "Mudas de ropa"));
    List<String> charlatán =  new ArrayList<String>(Arrays.asList("Engaño", "Juego de manos", "Ropas de calidad", "Herramientas de timador"));
    List<String> criminal =  new ArrayList<String>(Arrays.asList("Engaño", "Sigilo", "Palanca", "Mudas de ropa"));
    List<String> ermitaño =  new ArrayList<String>(Arrays.asList("Medicina", "Religión", "Estuche con pergaminos", "Manta", "Mudas de ropa", "Útiles de herborista"));
    List<String> erudito =  new ArrayList<String>(Arrays.asList("Arcana", "Historia", "Botella de tinta", "Pluma", "Cuchillo", "Ropas comunes"));
    List<String> heroePueblo =  new ArrayList<String>(Arrays.asList("Supervivencia", "Trato con Animales", "Herramientas artesano", "Pala", "Olla de hierro", "Ropas comunes"));
    List<String> marginado =  new ArrayList<String>(Arrays.asList("Juego de manos", "Sigilo", "Cuchillo", "Mapa de tu ciudad natal", "Raton mascota", "Mudas de ropa"));
    List<String> marinero =  new ArrayList<String>(Arrays.asList("Atletismo", "Percepción", "50 pies de cuerda", "Amuleto de la suerte", "Ropas comunes"));
    List<String> noble =  new ArrayList<String>(Arrays.asList("Historia", "Persuasión", "Mudas de ropa de calidad", "Anillo"));
    List<String> salvaje =  new ArrayList<String>(Arrays.asList("Atletismo", "Supervivencia", "Bastón", "Trampa de caza", "Trofeo", "Mudas de ropa"));
    List<String> soldado =  new ArrayList<String>(Arrays.asList("Atletismo", "Intimidación", "Insignia", "Trofeo", "Baraja de cartas", "Mudas de ropa"));

    public void setTransfondos(Map<String, List<String>> transfondosMapa) {
        this.transfondosMapa.put("Acólito",acólito);
        this.transfondosMapa.put("Animador", animador);
        this.transfondosMapa.put("Artesano ",artesano);
        this.transfondosMapa.put("Charlatán", charlatán);
        this.transfondosMapa.put("Criminal",criminal);
        this.transfondosMapa.put("Ermitaño",ermitaño);
        this.transfondosMapa.put("Erudito",erudito);
        this.transfondosMapa.put("Héroe del pueblo",heroePueblo);
        this.transfondosMapa.put("Marginado",marginado);
        this.transfondosMapa.put("Marinero",marinero);
        this.transfondosMapa.put("Noble",noble);
        this.transfondosMapa.put("Salvaje",salvaje);
        this.transfondosMapa.put("Soldado",soldado);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_transfondo);

        setTransfondos(transfondosMapa);
        Personaje p1 = (Personaje) getIntent().getSerializableExtra("p1");
        spinnerTransfondos = (Spinner) findViewById(R.id.spinnerTransfondo);
        lenguaje1 = (Spinner) findViewById(R.id.spinner2);
        lenguaje2 = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<CharSequence> adapterTransfondo = ArrayAdapter.createFromResource(this,R.array.transfondos, android.R.layout.simple_spinner_item);
        spinnerTransfondos.setAdapter(adapterTransfondo);
        ArrayAdapter<CharSequence> adapterL1 = ArrayAdapter.createFromResource(this,R.array.lenguajes, android.R.layout.simple_spinner_item);
        lenguaje1.setAdapter(adapterL1);
        ArrayAdapter<CharSequence> adapterL2 = ArrayAdapter.createFromResource(this,R.array.lenguajes, android.R.layout.simple_spinner_item);
        lenguaje2.setAdapter(adapterL2);

        TextView vequipo= (TextView) findViewById(R.id.textView13);
        vequipo.setMovementMethod(new ScrollingMovementMethod());
        TextView vcomp = (TextView) findViewById(R.id.textView8);

        spinnerTransfondos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String transfondoElegido= parent.getItemAtPosition(position).toString();
                List<String> aux = transfondosMapa.get(transfondoElegido);
                competencias = aux.get(0)+", "+ aux.get(1) ;
                vcomp.setText(competencias);

                int x = aux.size();
                for (int i = 2; i< x; i++) {
                    equipo = equipo+ ", " + aux.get(i);
                }


                vequipo.setText(equipo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        lenguaje1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String lenguajeElegido1 = parent.getItemAtPosition(position).toString();
                vlenguaje1 = lenguajeElegido1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        lenguaje2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String lenguajeElegido2 = parent.getItemAtPosition(position).toString();
                vlenguaje2 = lenguajeElegido2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        finalizar = findViewById(R.id.button2);
        finalizar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String Transfondo = spinnerTransfondos.getSelectedItem().toString();
                p1.setTransfondo(Transfondo);
                String lengua1 = lenguaje1.getSelectedItem().toString();
                p1.setLengua1(lengua1);
                String lengua2 = lenguaje2.getSelectedItem().toString();
                p1.setLengua2(lengua2);

                String secundarias=p1.getSecundarias();
                p1.setSecundarias(secundarias+ ", "+(String) vcomp.getText());
                String equipo= Datos.getClase_seleccionada().getEquipo_inicial().toString();
                String equipo2= vequipo.getText().toString();
                equipo2 = equipo2.replaceAll(",", System.getProperty("line.separator"));
                p1.setEquipo(equipo+ "line.separator"+equipo2);

                dbPersonajes DBPersonajes = new dbPersonajes(Crea_transfondo.this);
                long id = DBPersonajes.insertarPersonajeNull(p1);
                Intent j = new Intent(Crea_transfondo.this, Mis_personajes.class);
                startActivity(j);
            }
        });
    }
}




