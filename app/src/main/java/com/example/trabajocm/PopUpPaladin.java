package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;

public class PopUpPaladin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_paladin);


        DisplayMetrics medidasPopup = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasPopup);

        int ancho = medidasPopup.widthPixels;
        int alto = medidasPopup.heightPixels;

        //Redimensionar la ventana
        getWindow().setLayout((int)(ancho*0.7), (int)(alto*0.5));
    }
}