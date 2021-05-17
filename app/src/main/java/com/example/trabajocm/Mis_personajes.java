package com.example.trabajocm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Mis_personajes extends Activity {

    private Button atras;
    private TextView textoTamaño;
    private TextView textoRaza;
    private TextView textoAlineamiento;
    private TextView textovelocidad;
    private TextView textoNombre;
    private TextView textoCompetencias;
    private ImageView imagen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mis_personajes);

        textoTamaño = (TextView) findViewById(R.id.infoTamaño);
        textoRaza = (TextView) findViewById(R.id.inforaza);
        textoAlineamiento = (TextView) findViewById(R.id.infoAlineamiento);
        textovelocidad = (TextView) findViewById(R.id.infoVelocidad);
        textoNombre = (TextView) findViewById(R.id.infoNombre);
        textoCompetencias = (TextView) findViewById(R.id.infoCompetencias);
        imagen = (ImageView) findViewById(R.id.imagen);


        String raza = Datos.getRaza();
        String alineamiento = Datos.getAlineamiento();
        String velocidad = Datos.getVelocidad();
        String tamaño = Datos.getTamaño();
        String nombre = Datos.getNombre();
        String competencias = Datos.getCompetencias();


        //Imagen TODO
        imagen.setImageURI(Datos.getUri());
        textoTamaño.setText(tamaño);
        textoAlineamiento.setText(alineamiento);
        textovelocidad.setText(velocidad);
        textoRaza.setText(raza);
        textoNombre.setText(nombre);
        textoCompetencias.setText(competencias);


        atras =findViewById(R.id.atras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mis_personajes.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
