package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.Random;
import java.util.List;



public class Crea_personaje_2 extends Activity {

    Random rand = new Random();
    Integer fuerza = 10;
    Integer destreza;
    Integer constitucion;
    Integer sabiduria;
    Integer carisma;
    Integer inteligencia;
    String cadena;

    private Boolean reroll = Boolean.FALSE;

    private EditText edtFuerza;
    private EditText edtDestreza;
    private EditText edtConstitucion;
    private EditText edtSabiduria;
    private EditText edtCarisma;
    private EditText edtInteligencia;

    private List<Integer> listaStats;
    private List<Integer> lm;

    private List<Integer> generaNumeros() {
        for (int i = 0; i < 6; i++) {
            int n = rand.nextInt(15);
            n += 3;
            listaStats.add(n);
        }
        return listaStats;
    }

    public void onclick(View view) {
        muestraNumeros(reroll);
    }

    private void muestraNumeros(Boolean r) {
        if (r == Boolean.FALSE){
            lm = generaNumeros();
            cadena = "Estos son tus stats. Pulsa otra vez Generar para generar nuevos stats";

        } else {
            lm = generaNumeros();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_2);
        edtFuerza = (EditText) findViewById(R.id.numeroFuerza);
        edtFuerza.setText(fuerza.toString());
    }
}
