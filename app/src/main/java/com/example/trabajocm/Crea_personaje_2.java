package com.example.trabajocm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabajocm.entidades.Personaje;

import java.util.List;
import java.util.Random;

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
    private Button siguiente;
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
        Toast.makeText(Crea_personaje_2.this,  reroll.toString(), Toast.LENGTH_LONG).show();
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

        //recibo el objeto p1
        Personaje p1 = (Personaje) getIntent().getSerializableExtra("p1");
        //Toast.makeText(Crea_personaje_2.this,p1.getImagen(), Toast.LENGTH_LONG).show();

        reroll = 0;
        edtFuerza = (EditText) findViewById(R.id.numeroFuerza);
        edtFuerza.setText(fuerza.toString());
        edtDestreza = (EditText) findViewById(R.id.numeroDestreza);
        edtDestreza.setText(destreza.toString());
        edtConstitucion = (EditText) findViewById(R.id.numeroConstitucion);
        edtConstitucion.setText(constitucion.toString());
        edtSabiduria = (EditText) findViewById(R.id.numeroSabiduria);
        edtSabiduria.setText(sabiduria.toString());
        edtCarisma = (EditText) findViewById(R.id.numeroCarisma);
        edtCarisma.setText(carisma.toString());
        edtInteligencia =  (EditText) findViewById(R.id.numeroInteligencia);
        edtInteligencia.setText(inteligencia.toString());

        siguiente =findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setFuerza(Integer.parseInt(String.valueOf(edtFuerza.getText())));
                p1.setDestreza(Integer.parseInt(String.valueOf(edtDestreza.getText())));
                p1.setConstitucion(Integer.parseInt(String.valueOf(edtConstitucion.getText())));
                p1.setInteligencia(Integer.parseInt(String.valueOf(edtInteligencia.getText())));
                p1.setSabiduria(Integer.parseInt(String.valueOf(edtSabiduria.getText())));
                p1.setCarisma(Integer.parseInt(String.valueOf(edtCarisma.getText())));
                Intent j = new Intent(Crea_personaje_2.this, Crea_personaje_clase.class);
                j.putExtra("p1", p1);
                startActivity(j);
            }
        });
    }



   // public void ejecuta_suguiente(View view){      // Cambiar por clase a la que va dirigida



    //}

}
