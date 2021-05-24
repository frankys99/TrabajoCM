package com.example.trabajocm;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajocm.entidades.Personaje;
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
    private TextView subtitulo_habOspell;

    private Button Guardar;
    private ImageView icono_info_clase;

    public List<Clase> ls_clases;
    public Clase clase_Seleccionada;

    //Dialogo
    private Dialog dialog;

    //Habilidades secundarias escogidas
    private String hab_1_selec;
    private String hab_2_selec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crea_personaje_clase);

        Personaje p1 = (Personaje) getIntent().getSerializableExtra("p1");


        //Cargar las clases de la APIRest
        ls_clases = Datos.getLs_clases();

        //Declarar TextView
        info_clase = (TextView)findViewById(R.id.text_info_clase);
        comp_armas = (TextView)findViewById(R.id.text_comp_armas);
        comp_armaduras = (TextView)findViewById(R.id.text_comp_armaduras);
        res_spinner_sel_equipo = (TextView)findViewById(R.id.res_spinner_equipo);
        cabecera_hab_esp = (TextView)findViewById(R.id.cabecera_hab_esp);
        text_hab_esp = (TextView)findViewById(R.id.text_hab_esp);
        subtitulo_habOspell = (TextView)findViewById(R.id.subtitulo_hab_esp);

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

                //HABILIDAD ESPECIAL O HECHIZOS
                if(clase_Seleccionada.getHechizos().size() == 0){
                    cabecera_hab_esp.setText(clase_Seleccionada.getHabilidad_esp().getNombre_hab());

                    subtitulo_habOspell.setText(clase_Seleccionada.getHabilidad_esp().getNombre_hab() +
                            " es una habilidad especial y única de la clase " + clase_Seleccionada.getNombre() + ".\n");

                    String descripcion_hab_s = Datos.formatListaTexto(clase_Seleccionada.getHabilidad_esp().getDescripcion_hab());
                    text_hab_esp.setText(descripcion_hab_s);
                }else{
                    cabecera_hab_esp.setText("Hechizos");
                    subtitulo_habOspell.setText("La clase " + clase_Seleccionada.getNombre() +
                            " dispone de los siguientes hechizos de nivel 1 :\n");
                    String hechizos = Datos.formatListaElem(clase_Seleccionada.getHechizos());
                    text_hab_esp.setText(hechizos);
                }

                //HABILIDADES A ESCOGER
                //SPINNER: habilidad_1
                List<String>ls_habilidades = clase_Seleccionada.getProficiencias().getHabilidades();
                String[] opciones_hab_spinner = new String[ls_habilidades.size()];
                ls_habilidades.toArray(opciones_hab_spinner);

                ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_spinner);
                comp_hab_1.setAdapter(adapter2);

                hab_1_selec = ls_habilidades.get(0);                    //El spinner por defecto tiene la habilidad de la pos 0

                //SPINNER OnItemSelected : hab_1 -> Generar opciones del spinner hab_2
                comp_hab_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        //SPINNER ANIDADO: habilidad_2
                        List<String>ls_aux = new ArrayList<String>(ls_habilidades);  //copiar ls sin referencia
                        ls_aux.remove(comp_hab_1.getSelectedItem());            //Eliminar hab_1 seleccionada -> evitar duplicados

                        hab_1_selec = comp_hab_1.getSelectedItem().toString();  //Se asigna la habilidad 1 seleccionada
                        hab_2_selec = ls_aux.get(0);                            //Se agina por defecto la hab 2

                        String[] opciones_hab_2_spinner = new String[ls_aux.size()];
                        ls_aux.toArray(opciones_hab_2_spinner);
                        ArrayAdapter<String>adapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item,opciones_hab_2_spinner);
                        comp_hab_2.setAdapter(adapter3);

                        //SPINNER OnItemSelected: hab_2
                        comp_hab_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                hab_2_selec = comp_hab_2.getSelectedItem().toString();  ////Se asigna la habilidad 2 seleccionada
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
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
                abrirDialogo();
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

        Guardar =findViewById(R.id.Guardar);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner mySpinner = (Spinner) findViewById(R.id.clases_spinner);
                String clase = mySpinner.getSelectedItem().toString();
                p1.setClase(clase);
                String equipo= "";
                for (String equipo_i : clase_Seleccionada.getEquipo_inicial()) {

                    equipo+= equipo_i+"\n";
                }
                equipo = equipo.replaceAll("\n", System.getProperty("line.separator"));
                p1.setEquipo(equipo);

                Spinner SpinnerHab1 = (Spinner) findViewById(R.id.spinner_comp_hab_1);
                String Hab1 = SpinnerHab1.getSelectedItem().toString();
                Spinner SpinnerHab2 = (Spinner) findViewById(R.id.spinner_comp_hab_2);
                String Hab2 = SpinnerHab2.getSelectedItem().toString();
                if((p1.getClase().equals("Hechicero")||p1.getClase().equals("Brujo") ||p1.getClase().equals("Mago")||p1.getClase().equals("Bardo")
                        ||p1.getClase().equals("Clérigo")||p1.getClase().equals("Druida"))){
                    if (clase_Seleccionada.getHechizos().size()==5){
                        p1.setHechizo1(clase_Seleccionada.getHechizos().get(0));
                        p1.setHechizo2(clase_Seleccionada.getHechizos().get(1));
                        p1.setHechizo3(clase_Seleccionada.getHechizos().get(2));
                        p1.setHechizo4(clase_Seleccionada.getHechizos().get(3));
                        p1.setHechizo5(clase_Seleccionada.getHechizos().get(4));

                    }else if(clase_Seleccionada.getHechizos().size()==6){
                        p1.setHechizo1(clase_Seleccionada.getHechizos().get(0));
                        p1.setHechizo2(clase_Seleccionada.getHechizos().get(1));
                        p1.setHechizo3(clase_Seleccionada.getHechizos().get(2));
                        p1.setHechizo4(clase_Seleccionada.getHechizos().get(3));
                        p1.setHechizo5(clase_Seleccionada.getHechizos().get(4));
                        p1.setHechizo6(clase_Seleccionada.getHechizos().get(5));

                    }


                }else{
                p1.setHabilidad_especial(clase_Seleccionada.getHabilidad_esp().getNombre_hab());}



                p1.setSecundarias(Hab1+", "+Hab2);
                //comenta las dos de abajo
               // dbPersonajes DBPersonajes = new dbPersonajes(Crea_personaje_clase.this);
                //long id = DBPersonajes.insertarPersonajeNull(p1);
                //Mis_personajes esta por ahora, cuando este transforndo personajes Mis_personajes pasara ha ser Transfondo
                Intent j = new Intent(Crea_personaje_clase.this, Crea_transfondo.class);
                j.putExtra("p1",  p1);
                startActivity(j);
            }
        });


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

    public void ejecuta_siguiente(View view){
        //TODO
        /* CUANDO ESTÉ READY LA PANTALLA TRASFONDO

        //Añadir habilidades seleccionadas a Datos
        List<String> hab_seleccionadas = new ArrayList<>();
        hab_seleccionadas.add(hab_1_selec);
        hab_seleccionadas.add(hab_2_selec);
        Datos.initHabsClase(hab_seleccionadas);

        //Intent i = new Intent(this, Crea_personaje_2.class);
        //startActivity(i);
         */
    }

}
