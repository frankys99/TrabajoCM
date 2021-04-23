package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class PopUpBrujo extends AppCompatActivity {

    private TextView txtBrujo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pop_up_brujo);
        txtBrujo = (TextView)findViewById(R.id.txtInfo);
        txtBrujo.setText(Datos.getLs_clases().get(1).getInfo_clase().toString());

        DisplayMetrics medidasPopup = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasPopup);

        int ancho = medidasPopup.widthPixels;
        int alto = medidasPopup.heightPixels;

        //Redimensionar la ventana
        getWindow().setLayout((int)(ancho*0.7), (int)(alto*0.5));
    }
}