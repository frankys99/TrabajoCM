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
        clase = findViewById(R.id.Clase_put);
        raza = findViewById(R.id.Raza_put);
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
        salvaciones = findViewById(R.id.Salvaciones_put);
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
            if(personaje.getRaza().equals("Humano")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()+1));
                Destreza.setText(String.valueOf(personaje.getDestreza()+1));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()+1));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()+1));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()+1));
                Carisma.setText(String.valueOf(personaje.getCarisma()+1));
            }else if(personaje.getRaza().equals("Elfo")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()+2));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }else if (personaje.getRaza().equals("Dracónido")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()+2));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()+1));
            }else if (personaje.getRaza().equals("Enano")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()+2));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }else if (personaje.getRaza().equals("Gnomo")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()+2));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }else if (personaje.getRaza().equals("Medio elfo")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()+2));
            }else if (personaje.getRaza().equals("Medio orco")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()+2));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()+1));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }else if (personaje.getRaza().equals("Mediano")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()+2));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }else if (personaje.getRaza().equals("Tiefling")){
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()+1));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()+2));
            }else{
                Fuerza.setText(String.valueOf(personaje.getFuerza()));
                Destreza.setText(String.valueOf(personaje.getDestreza()));
                Constitucion.setText(String.valueOf(personaje.getConstitucion()));
                Inteligencia.setText(String.valueOf(personaje.getInteligencia()));
                Sabiduria.setText(String.valueOf(personaje.getSabiduria()));
                Carisma.setText(String.valueOf(personaje.getCarisma()));
            }
            int consti =Integer.parseInt(String.valueOf(Constitucion.getText()));
            int bono_consti;

            if (consti==1){bono_consti=-5;}else if(consti==2||consti==3){bono_consti=-4;}else if(consti==4||consti==5){bono_consti=-3;}
            else if(consti==6||consti==7){bono_consti=-2;}else if(consti==8||consti==9){bono_consti=-1;}else if(consti==10||consti==11){bono_consti=0;}
            else if(consti==12||consti==13){bono_consti=1;} else if(consti==14||consti==15){bono_consti=2;} else if(consti==16||consti==17){bono_consti=3;}
            else if(consti==18||consti==19){bono_consti=4;}else{bono_consti=5;}



            if(personaje.getClase().equals("Bárbaro")){
                PV.setText(String.valueOf(bono_consti+12));
            } else if (personaje.getClase().equals("Bardo")||personaje.getClase().equals("Clérigo")||personaje.getClase().equals("Druida")||personaje.getClase().equals("Monje")||personaje.getClase().equals("Pícaro")||personaje.getClase().equals("Brujo")){
                PV.setText(String.valueOf(bono_consti+8));
            }else if(personaje.getClase().equals("Guerrero")||personaje.getClase().equals("Paladín")||personaje.getClase().equals("Explorador")){
                PV.setText(String.valueOf(bono_consti+10));
            }else if(personaje.getClase().equals("Hechizero")||personaje.getClase().equals("Mago")){
                PV.setText(String.valueOf(bono_consti+6));
            }

            int detrez =Integer.parseInt(String.valueOf(Constitucion.getText()));
            int bono_destreza;
            if (detrez==1){bono_destreza=-5;}else if(detrez==2||detrez==3){bono_destreza=-4;}else if(detrez==4||detrez==5){bono_destreza=-3;}
            else if(detrez==6||detrez==7){bono_destreza=-2;}else if(detrez==8||detrez==9){bono_destreza=-1;}else if(detrez==10||detrez==11){ bono_destreza=0;}
            else if(detrez==12||detrez==13){bono_destreza=1;} else if(detrez==14||detrez==15){bono_destreza=2;} else if(detrez==16||detrez==17){bono_destreza=3;}
            else if(detrez==18||detrez==19){bono_destreza=4;}else{bono_destreza=5;}


            if (personaje.getEquipo().equals("vacio")){
                CA.setText(String.valueOf(10+bono_destreza));

            }else{
                if (personaje.getEquipo().contains("Acolchada")||personaje.getEquipo().contains("Cuero")){
                    CA.setText(String.valueOf(11+bono_destreza));
                }else if (personaje.getEquipo().contains("Cuero tachonado")){
                    CA.setText(String.valueOf(12+bono_destreza));
                }else if (personaje.getEquipo().contains("Pieles")){
                    if (bono_destreza>2){bono_destreza=2;}
                    CA.setText(String.valueOf(12+bono_destreza));
                }else if (personaje.getEquipo().contains("camiseta de mallas")){
                    if (bono_destreza>2){bono_destreza=2;}
                    CA.setText(String.valueOf(13+bono_destreza));
                }else if (personaje.getEquipo().contains("Cota de escamas")||personaje.getEquipo().contains("Coraza")){
                    if (bono_destreza>2){bono_destreza=2;}
                    CA.setText(String.valueOf(14+bono_destreza));
                }else if (personaje.getEquipo().contains("Semiplacas")){
                    if (bono_destreza>2){bono_destreza=2;}
                    CA.setText(String.valueOf(15+bono_destreza));
                }else if(personaje.getEquipo().contains("Cota de anillas")){
                    CA.setText(String.valueOf(14));
                }else if(personaje.getEquipo().contains("Cota de mallas")){
                    CA.setText(String.valueOf(16));
                }else if(personaje.getEquipo().contains("Bandas")){
                    CA.setText(String.valueOf(17));
                }else if(personaje.getEquipo().contains("Placas")){
                    CA.setText(String.valueOf(18));
                }
                if (personaje.getEquipo().contains("Escudo")){
                    CA.setText(String.valueOf(2+Integer.parseInt(String.valueOf(CA.getText()))));
                }
            }
            Nivel.setText(String.valueOf(personaje.getNivel()));
            Turno.setText(String.valueOf(bono_destreza));
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