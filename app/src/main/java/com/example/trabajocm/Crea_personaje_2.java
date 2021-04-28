package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Crea_personaje_2 extends Activity {

    Integer fuerza = 10;
    Integer destreza;
    Integer constitucion;
    Integer sabiduria;
    Integer carisma;
    Integer inteligencia;

    private EditText edtFuerza;
    private EditText edtDestreza;
    private EditText edtConstitucion;
    private EditText edtSabiduria;
    private EditText edtCarisma;
    private EditText edtInteligencia;

    private List<Integer> listaStats;


    public void onclick(View view) {
        muestraNumeros();
    }

    private void muestraNumeros() {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_personaje_2);
        edtFuerza = (EditText) findViewById(R.id.numeroFuerza);
        edtFuerza.setText(fuerza.toString());
    }
}
