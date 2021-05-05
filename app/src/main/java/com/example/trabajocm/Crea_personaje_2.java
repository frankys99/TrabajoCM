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
    Integer destreza = 10;
    Integer constitucion = 10;
    Integer sabiduria = 10;
    Integer carisma = 10;
    Integer inteligencia = 10;
    String cadena = "";

    private Boolean reroll;

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
            cadena = "Estos son tus stats definitivos, no pueden cambiarse";
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_2);

        reroll = Boolean.FALSE;
        edtFuerza = (EditText) findViewById(R.id.numeroFuerza);
        edtFuerza.setText(fuerza.toString());
        edtDestreza = (EditText) findViewById(R.id.numeroDestreza);
        edtDestreza.setText(destreza.toString());
        edtConstitucion = (EditText) findViewById(R.id.numeroConstitucion);
        edtConstitucion.setText(constitucion.toString());
        edtSabiduria = (EditText) findViewById(R.id.numeroFuerza);
        edtSabiduria.setText(sabiduria.toString());
        edtCarisma = (EditText) findViewById(R.id.numeroCarisma);
        edtCarisma.setText(carisma.toString());
        edtInteligencia =  (EditText) findViewById(R.id.numeroInteligencia);
        edtInteligencia.setText(inteligencia.toString());


    }
}