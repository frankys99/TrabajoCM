package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Crea_transfondo extends Activity {

    private Spinner spinnerTransfondos = (Spinner) findViewById(R.id.spinnerTransfondo);
    private Spinner lenguaje1 = (Spinner) findViewById(R.id.spinner2);
    private Spinner lenguaje2 = (Spinner) findViewById(R.id.spinner3);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_transfondo);

        ArrayAdapter<CharSequence> adapterTransfondo = ArrayAdapter.createFromResource(this,R.array.transfondos, android.R.layout.simple_spinner_item);
        spinnerTransfondos.setAdapter(adapterTransfondo);
    }



}
