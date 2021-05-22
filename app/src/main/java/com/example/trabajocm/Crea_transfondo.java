package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crea_transfondo extends Activity {

    private Spinner spinnerTransfondos = (Spinner) findViewById(R.id.spinnerTransfondo);
    private Spinner lenguaje1 = (Spinner) findViewById(R.id.spinner2);
    private Spinner lenguaje2 = (Spinner) findViewById(R.id.spinner3);

    String equipo = "";
    String competencias = "";
    String vlenguaje1 = "";
    String vlenguaje2 = "";

    private Map<String, List<String>> transfondosMapa = new HashMap<>();
    List<String> acólito = new ArrayList<String>(Arrays.asList("Perspicacia", "Religión", "Símbolo sagrado", "Devocionario", "x5 Varas de inciensos"));
    List<String> animador =  new ArrayList<String>(Arrays.asList("Acrobacias", "Interpretación", "Instrumento musical", "Favor de un fan", "Disfraz"));
    List<String> artesanoGremial =  new ArrayList<String>(Arrays.asList("Perspicacia", "Persuasión", "Herramientas de artesano", "Carta de presentación", "Mudas de ropa"));
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
        this.transfondosMapa.put("Artesano gremial",artesanoGremial);
        this.transfondosMapa.put("Charlatán", charlatán);
        this.transfondosMapa.put("Criminal",criminal);
        this.transfondosMapa.put("Ermitaño",ermitaño);
        this.transfondosMapa.put("Erudito",erudito);
        this.transfondosMapa.put("Héroe del pueblo",heroePueblo);
        this.transfondosMapa.put("Marginado",marginado);
        this.transfondosMapa.put("marinero",marinero);
        this.transfondosMapa.put("Noble",noble);
        this.transfondosMapa.put("Salvaje",salvaje);
        this.transfondosMapa.put("Soldado",soldado);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_transfondo);

        setTransfondos(transfondosMapa);

        ArrayAdapter<CharSequence> adapterTransfondo = ArrayAdapter.createFromResource(this,R.array.transfondos, android.R.layout.simple_spinner_item);
        spinnerTransfondos.setAdapter(adapterTransfondo);
        ArrayAdapter<CharSequence> adapterL1 = ArrayAdapter.createFromResource(this,R.array.lenguajes, android.R.layout.simple_spinner_item);
        lenguaje1.setAdapter(adapterL1);
        ArrayAdapter<CharSequence> adapterL2 = ArrayAdapter.createFromResource(this,R.array.lenguajes, android.R.layout.simple_spinner_item);
        lenguaje2.setAdapter(adapterL2);

        TextView vequipo= (TextView) findViewById(R.id.textView13);
        TextView vcomp = (TextView) findViewById(R.id.textView8);

        spinnerTransfondos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String transfondoElegido= parent.getItemAtPosition(position).toString();
                List<String> aux = transfondosMapa.get(transfondoElegido);
                competencias = aux.get(0) + aux.get(1) ;
                vcomp.setText(competencias);
                int x = aux.size();
                for (int i = 2; i< x; i++) {
                    equipo = equipo + aux.get(i);
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
                vlenguaje1 = lenguajeElegido2;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}




