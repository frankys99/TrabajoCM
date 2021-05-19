package com.example.trabajocm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.trabajocm.modelos.Clase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
public class Crea_personaje_clase extends AppCompatActivity {
//public class Crea_personaje_clase extends Activity {
    private Spinner clases_spiner;
    private Spinner comp_hab_1;
    private Spinner comp_hab_2;
    //private Spinner selec_equipo;

    private TextView info_clase;
    private TextView comp_armas;
    private TextView comp_armaduras;
    private TextView cabecera_hab_esp;
    private TextView text_hab_esp;
    private TextView res_spinner_sel_equipo;

    private ImageView icono_info_clase;

    public List<Clase> ls_clases;
    public Clase clase_Seleccionada;

    //Dialogo
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crea_personaje_clase);

        //Cargar las clases de la APIRest
        ls_clases = Datos.getLs_clases();

        //TEST RAZASAPI
        Log.i("---CARGA\n", Datos.getLs_razas().toString());

        //Declarar TextView
        info_clase = (TextView)findViewById(R.id.text_info_clase);
        comp_armas = (TextView)findViewById(R.id.text_comp_armas);
        comp_armaduras = (TextView)findViewById(R.id.text_comp_armaduras);
        res_spinner_sel_equipo = (TextView)findViewById(R.id.res_spinner_equipo);
        cabecera_hab_esp = (TextView)findViewById(R.id.cabecera_hab_esp);
        text_hab_esp = (TextView)findViewById(R.id.text_hab_esp);

        //Declarar imageView
        icono_info_clase =(ImageView)findViewById(R.id.icono_info_clase);

        //Declarar Spinners
        clases_spiner = (Spinner)findViewById(R.id.clases_spinner);
        comp_hab_1 = (Spinner)findViewById(R.id.spinner_comp_hab_1);
        comp_hab_2 = (Spinner)findViewById(R.id.spinner_comp_hab_2);
        //selec_equipo = (Spinner)findViewById(R.id.spinner_selec_equipo);

        //SPINNER: seleccionar clase
        String[] opciones_spinner_clases = new String[ls_clases.size()];
        for(int i = 0; i < ls_clases.size(); i++){
            opciones_spinner_clases[i] = ls_clases.get(i).getNombre();
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones_spinner_clases);
        clases_spiner.setAdapter(adapter);

        //SPINNER: setOnItemSelected
        clases_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for(Clase cl : ls_clases){
                    if(cl.getNombre() == clases_spiner.getSelectedItem().toString()){
                        clase_Seleccionada = cl;
                        //Añadir a Datos
                        Datos.initClaseSelec(clase_Seleccionada);
                    }
                }

                info_clase.setText("Información sobre: " + clase_Seleccionada.getNombre());

                //PROFICIENCIAS
                String armas_s = Datos.formatListaElem(clase_Seleccionada.getProficiencias().getArmas());
                comp_armas.setText(armas_s);

                String armaduras_s = Datos.formatListaElem(clase_Seleccionada.getProficiencias().getArmaduras());
                comp_armaduras.setText(armaduras_s);

                //HABILIDAD ESPECIAL DE LA CLASE
                cabecera_hab_esp.setText(clase_Seleccionada.getHabilidad_esp().getNombre_hab());

                String descripcion_hab_s = Datos.formatListaTexto(clase_Seleccionada.getHabilidad_esp().getDescripcion_hab());
                text_hab_esp.setText(descripcion_hab_s);

                //HABILIDADES A ESCOGER
                //SPINNER: habilidad_1
                List<String>ls_habilidades = clase_Seleccionada.getProficiencias().getHabilidades();
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);

                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_1.setAdapter(adapter2);



                //Spinner hab_1 seleccionado -> Generar opciones del spinner hab_2
                comp_hab_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        //SPINNER ANIDADO: habilidad_2
                        List<String>ls_aux = new ArrayList<String>(ls_habilidades);  //copiar ls sin referencia

                        ls_aux.remove(comp_hab_1.getSelectedItem());            //Eliminar hab_1 seleccionada -> evitar duplicados

                        String[] opciones_hab_2_spinner = new String[ls_aux.size()];
                        ls_aux.toArray(opciones_hab_2_spinner);
                        ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_2_spinner);
                        comp_hab_2.setAdapter(adapter3);

                        //TODO: hab2.select -> Añadir habs a Datos
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                /*
                //Spinner selec equipo/oro
                String[] opciones_equipo_def = new String[]{"Equipo inicial","Oro"};
                ArrayAdapter<String>adapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_equipo_def);
                selec_equipo.setAdapter(adapter4);
                 */

                //EQUIPO INICIAL
                String equipo_ini_s = Datos.formatListaElem(clase_Seleccionada.getEquipo_inicial());
                res_spinner_sel_equipo.setText(equipo_ini_s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //EVENTO ON-CLICK ÍCONO - > Info clase ventana emergente
        icono_info_clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clase_Seleccionada.getNombre().equals("Paladin")){

                    //DIALOGO
                    abrirDialogo();
                    /*
                    AlertDialog.Builder d_builder = new AlertDialog.Builder(getBaseContext());

                    // Crea una instancia de un archivo XML de diseño en sus objetos de vista correspondientes.
                    //   Ejemplo : comparan un Layoutinflater con un hinchador de playa, entiendo la metáfora que dentro va el XML como gas
                    //     y la pelota de playa sería la variable tipo vista/View dónde se carga ese XML

                    LayoutInflater inflater = getLayoutInflater();
                    d_builder.setView(inflater.inflate(R.layout.dialog_info_clase, null))
                            .setNegativeButton("[X]", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog a_d = d_builder.create();
                    a_d.show();
                    */

                }else if(clase_Seleccionada.getNombre().equals("Brujo")){
                    abrirDialogo();
                }
            }
        });


        /* DESPRECIADO -> NO SE DA A ESCOGER
        selec_equipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(selec_equipo.getSelectedItem().equals("Equipo inicial")){
                    res_spinner_sel_equipo.setText("Equipo Inicial:\n" + clase_Seleccionada.getEquipo_inicial());
                    //TODO añadir DB
                }else if(selec_equipo.getSelectedItem().equals("Oro")){
                    res_spinner_sel_equipo.setText("Dinero:\n" + clase_Seleccionada.getDinero_inicial() + " monedas de oro.");
                    //TODO añadir DB
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
    }

    private void abrirDialogo(){
        //https://www.youtube.com/watch?v=5PaWtQAOdi8

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_info_clase);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Declarar
        ImageView avatar_clase_dialog = dialog.findViewById(R.id.avatar_clase_dialog);
        ImageView icono_cerrar_dialog = dialog.findViewById(R.id.imageViewClose);
        TextView nombre_clase_dialog = dialog.findViewById(R.id.nombre_clase_dialog);
        TextView info_clase_dialog = dialog.findViewById(R.id.info_clase_dialog);

        //Set
        nombre_clase_dialog.setText(clase_Seleccionada.getNombre());
        info_clase_dialog.setText(Datos.formatListaTexto(clase_Seleccionada.getInfo_clase()));

        /* Cargar imagen mediante URL:

            https://square.github.io/picasso/
            https://www.youtube.com/watch?v=L8exo2c1AIc
         */
        Picasso.get()
                .load(clase_Seleccionada.getUrl_avatar())
                .resize(600,600)
                .into(avatar_clase_dialog);

        //Implementar funcion mipmap.close
        icono_cerrar_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    //BOTONES : Atras y Siguiente

    public void ejecuta_atras(View view){
        Intent i = new Intent(this, Crea_personaje_2.class);
        startActivity(i);
    }

    //TODO

    public void ejecuta_siguiente(View view){

        //Intent i = new Intent(this, Crea_personaje_2.class);
        //startActivity(i);
    }



}
