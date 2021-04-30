package com.example.trabajocm;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajocm.db.dbPersonajes;
import com.example.trabajocm.entidades.Personaje;

public class Resumen_Personaje extends AppCompatActivity {

    private Button volver;
    private Button borrar;
    private Button editar;
    Personaje personaje;
    int id =0;
    ImageView foto;
    EditText PV, CA, Turno, Nivel, XP;
    EditText Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma;
    EditText H1,H2,H3,H4,H5,H6;
    EditText Nombre, clase, raza, salvaciones, secundarias, dotes, lenguaje1, lenguaje2, equipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen__personaje);


        volver =findViewById(R.id.Volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        borrar = findViewById(R.id.BORRAR);
        editar = findViewById(R.id.Editar);

        foto = findViewById(R.id.foto);
        PV = findViewById(R.id.PV_N);
        clase = findViewById(R.id.clase_put);
        raza = findViewById(R.id.raza_put);
        CA = findViewById(R.id.CA_N);
        Turno = findViewById(R.id.Turno_N);
        Nivel = findViewById(R.id.Nivel_N);
        XP = findViewById(R.id.XP_N);
        Fuerza = findViewById(R.id.fuerza_N);
        Destreza = findViewById(R.id.Destreza_N);
        Constitucion = findViewById(R.id.Constitucion_N);
        Inteligencia = findViewById(R.id.Inteligencia_N);
        Sabiduria = findViewById(R.id.Sabiduria_N);
        Carisma = findViewById(R.id.Carisma_N);
        H1 = findViewById(R.id.Hechi1);H2 = findViewById(R.id.Hechi2);H3 = findViewById(R.id.Hechi3);H4 = findViewById(R.id.Hechi4);H5 = findViewById(R.id.Hechi5);H6 = findViewById(R.id.Hechi6);
        Nombre = findViewById(R.id.Nombre_put);
        salvaciones = findViewById(R.id.salvaciones_put);
        secundarias = findViewById(R.id.Secundaria_put);
        dotes = findViewById(R.id.Dotes_put);
        lenguaje1 = findViewById(R.id.Lengua1);
        lenguaje2 = findViewById(R.id.lengua2);
        equipo = findViewById(R.id.Equipo_put);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }

        final dbPersonajes dbpersonaje = new dbPersonajes(Resumen_Personaje.this);
        personaje = dbpersonaje.mostrar_Resumen_Personaje(id);

        if(personaje != null){
            foto.setImageURI(Uri.parse(personaje.getImagen()));
            Nombre.setText(personaje.getNombre());
            clase.setText(personaje.getClase());
            raza.setText(personaje.getRaza());
            salvaciones.setText(personaje.getSalvaciones());
            secundarias.setText(personaje.getSecundarias());
            dotes.setText(personaje.getDotes());
            Fuerza.setText(String.valueOf(personaje.getFuerza()));
            Destreza.setText(String.valueOf(personaje.getDestreza()));
            Constitucion.setText(String.valueOf(personaje.getConstitucion()));
            Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
            Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
            Carisma.setText(String.valueOf(personaje.getCarisma()));

            PV.setText(String.valueOf(personaje.getPv()));
            CA.setText(String.valueOf(personaje.getCa()));
            Nivel.setText(String.valueOf(personaje.getNivel()));
            Turno.setText(String.valueOf(personaje.getTurno()));
            XP.setText(String.valueOf(personaje.getXp()));
            lenguaje1.setText(personaje.getLengua1());
            lenguaje2.setText(personaje.getLengua2());
            equipo.setText(personaje.getEquipo());
            H1.setText(personaje.getHechizo1());
            H2.setText(personaje.getHechizo2());
            H3.setText(personaje.getHechizo3());
            H4.setText(personaje.getHechizo4());
            H5.setText(personaje.getHechizo5());
            H6.setText(personaje.getHechizo6());


            clase.setInputType(InputType.TYPE_NULL);
            raza.setInputType(InputType.TYPE_NULL);
            PV.setInputType(InputType.TYPE_NULL);
            CA.setInputType(InputType.TYPE_NULL);
            Turno.setInputType(InputType.TYPE_NULL);
            Nivel.setInputType(InputType.TYPE_NULL);
            XP.setInputType(InputType.TYPE_NULL);
            Fuerza.setInputType(InputType.TYPE_NULL);
            Destreza.setInputType(InputType.TYPE_NULL);
            Constitucion.setInputType(InputType.TYPE_NULL);
            Inteligencia.setInputType(InputType.TYPE_NULL);
            Sabiduria.setInputType(InputType.TYPE_NULL);
            Carisma.setInputType(InputType.TYPE_NULL);
            Nombre.setInputType(InputType.TYPE_NULL);
            salvaciones.setInputType(InputType.TYPE_NULL);
            secundarias.setInputType(InputType.TYPE_NULL);
            dotes.setInputType(InputType.TYPE_NULL);
            lenguaje1.setInputType(InputType.TYPE_NULL);
            lenguaje2.setInputType(InputType.TYPE_NULL);
            equipo.setInputType(InputType.TYPE_NULL);
            H1.setInputType(InputType.TYPE_NULL);
            H2.setInputType(InputType.TYPE_NULL);
            H3.setInputType(InputType.TYPE_NULL);
            H4.setInputType(InputType.TYPE_NULL);
            H5.setInputType(InputType.TYPE_NULL);
            H6.setInputType(InputType.TYPE_NULL);
        }



        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Resumen_Personaje.this);
                builder.setMessage("¿Desea eliminar este personaje?")
                        .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                if(dbpersonaje.eliminarPersonaje(id)){

                                    lista();
                                }
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });






    }
    private void lista(){
        startActivity(new Intent(getBaseContext(),Mis_personajes.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));


    }
}