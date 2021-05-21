package com.example.trabajocm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Crea_transfondo extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_transfondo);
    }

    Spinner spinner = (Spinner) findViewById(R.id.spinnerTransfondo);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.transfondos, android.R.layout.simple_spinner_item);
}
