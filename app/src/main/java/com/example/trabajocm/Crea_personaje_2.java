package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

public class Crea_personaje_2 extends Activity {
    Random rand = new Random();
    Integer fuerza = 10;
    Integer destreza = 10;
    Integer constitucion = 10;
    Integer sabiduria = 10;
    Integer carisma = 10;
    Integer inteligencia = 10;
    String cadena = "";
    String delim = ", ";
    private Integer reroll;

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

    public void onclick (View view) {
        muestraNumeros(reroll);
        //Aqui pondré algo para comprobar si el usuario ha hecho click de nuevo
        reroll += 1;
    }

    private void muestraNumeros(Integer r) {
        TextView textoNumeros = findViewById(R.id.textoNumeros);
        TextView ta = (TextView) findViewById(R.id.textView);
        if (r == 0){
            lm = generaNumeros();
            cadena = "Estos son tus stats. Pulsa otra vez Generar para generar nuevos stats";
            ta.setText(cadena);
            StringBuilder sb = new StringBuilder();
            for (Integer s : lm)
            {
                sb.append(s);
                sb.append("\t");
            }
            textoNumeros.setText(sb);
        }  else if (r == 1) {
            lm = generaNumeros();
            cadena = "Estos son tus stats definitivos, no pueden cambiarse";
            ta.setText(cadena);
            StringBuilder sb = new StringBuilder();
            for (Integer s : lm)
            {
                sb.append(s);
                sb.append("\t");
            }
            textoNumeros.setText(sb);
        } else {
            cadena = "Estos son tus stats definitivos, no pueden cambiarse";
            ta.setText(cadena);
        }

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_2);

        reroll = 0;
        edtFuerza = (EditText) findViewById(R.id.numeroCarisma);
        edtFuerza.setText(fuerza.toString());
        edtDestreza = (EditText) findViewById(R.id.numeroFuerza);
        edtDestreza.setText(destreza.toString());
        edtConstitucion = (EditText) findViewById(R.id.numeroDestreza);
        edtConstitucion.setText(constitucion.toString());
        edtSabiduria = (EditText) findViewById(R.id.numeroCarisma);
        edtSabiduria.setText(sabiduria.toString());
        edtCarisma = (EditText) findViewById(R.id.numeroSabiduria);
        edtCarisma.setText(carisma.toString());
        edtInteligencia =  (EditText) findViewById(R.id.numeroConstitucion);
        edtInteligencia.setText(inteligencia.toString());

    }
}
