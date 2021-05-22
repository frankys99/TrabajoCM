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
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.trabajocm.db.dbPersonajes;
import com.example.trabajocm.entidades.Personaje;

public class Resumen_Personaje extends AppCompatActivity {

    private Button volver;
    private Button borrar;
    private Button editar;
    Personaje personaje;
    int Ca;
    int id =0;
    ImageView foto;
    EditText PV, CA, Turno, Nivel, XP;
    EditText Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma;
    EditText H1,H2,H3,H4,H5,H6;
    TextView NoHechizo;

    EditText Nombre, clase, raza, salvaciones, secundarias, transfondo, lenguaje1, lenguaje2, equipo;
    TextView equipo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen__personaje);


        volver =findViewById(R.id.atras);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        borrar = findViewById(R.id.BORRAR);
        editar = findViewById(R.id.Editar);
        NoHechizo = findViewById(R.id.Habilidad_Especial);


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
        transfondo = findViewById(R.id.Transfondo_put);
        lenguaje1 = findViewById(R.id.Lengua1);
        lenguaje2 = findViewById(R.id.lengua2);
        //equipo = findViewById(R.id.Equipo_put);
        equipo2 = findViewById(R.id.Equipo_put);

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
           //mostrar salvaciones según la clase(mirar si esta bien)
            if(personaje.getClase().equals("Bárbaro")){
                salvaciones.setText("Fuerza"+", "+ "Constitución");
            }else if (personaje.getRaza().equals("Bardo")){
                salvaciones.setText("Destreza"+", "+ "Carisma");
            }else if (personaje.getClase().equals("Clérigo")){
                salvaciones.setText("Sabiduría"+", "+ "Carisma");
            }else if (personaje.getClase().equals("Druida")){
                salvaciones.setText("Inteligencia"+", "+ "Sabiduría");
            }else if (personaje.getClase().equals("Guerrero")){
                salvaciones.setText("Fuerza"+", "+ "Constitución");
            }else if (personaje.getClase().equals("Monje")){
                salvaciones.setText("Destreza"+", "+ "Fuerza");
            }else if (personaje.getClase().equals("Paladín")){
                salvaciones.setText("Sabiduría"+", "+ "Carisma");
            }else if (personaje.getClase().equals("Explorador")){
                salvaciones.setText("Fuerza"+", "+ "Destreza");
            }else if (personaje.getClase().equals("Pícaro")){
                salvaciones.setText("Destreza"+", "+ "Inteligencia");
            }else if (personaje.getClase().equals("Hechicero")){
                salvaciones.setText("Constitución"+", "+ "Carisma");
            }else if (personaje.getClase().equals("Brujo")){
                salvaciones.setText("Sabiduría"+", "+ "Carisma");
            }else if (personaje.getClase().equals("Mago")){
                salvaciones.setText("Inteligencia"+", "+ "Sabiduría");
            }


            secundarias.setText(personaje.getSecundarias());
            transfondo.setText(personaje.getTransfondo());
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
            }else if(personaje.getClase().equals("Hechicero")||personaje.getClase().equals("Mago")){
                PV.setText(String.valueOf(bono_consti+6));
            }

            int detrez =Integer.parseInt(String.valueOf(Constitucion.getText()));
            int bono_destreza;
            if (detrez==1){bono_destreza=-5;}else if(detrez==2||detrez==3){bono_destreza=-4;}else if(detrez==4||detrez==5){bono_destreza=-3;}
            else if(detrez==6||detrez==7){bono_destreza=-2;}else if(detrez==8||detrez==9){bono_destreza=-1;}else if(detrez==10||detrez==11){ bono_destreza=0;}
            else if(detrez==12||detrez==13){bono_destreza=1;} else if(detrez==14||detrez==15){bono_destreza=2;} else if(detrez==16||detrez==17){bono_destreza=3;}
            else if(detrez==18||detrez==19){bono_destreza=4;}else{bono_destreza=5;}


            if (personaje.getEquipo().equals("vacio")){
                Ca = 10+bono_destreza;
                CA.setText(String.valueOf(Ca));

            }else{
                if(personaje.getEquipo().equals("Escudo.")||personaje.getEquipo().equals("Escudo")){
                    CA.setText(String.valueOf(Ca+2));
                }
                //armadura de cuero
                if (personaje.getEquipo().contains("Acolchada")||personaje.getEquipo().contains("Armadura de cuero")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=11+bono_destreza+2;}else{Ca=11+bono_destreza;}
                    CA.setText(String.valueOf(Ca));
                }else if (personaje.getEquipo().contains("Cuero tachonado")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=12+bono_destreza+2;}else{Ca=12+bono_destreza;}

                    CA.setText(String.valueOf(Ca));
                }else if (personaje.getEquipo().contains("Pieles")){
                    if (bono_destreza>2){bono_destreza=2;}
                    if (personaje.getEquipo().contains("Escudo")){Ca=12+bono_destreza+2;}else{Ca=12+bono_destreza;}

                    CA.setText(String.valueOf(Ca));
                }else if (personaje.getEquipo().contains("camiseta de mallas")){
                    if (bono_destreza>2){bono_destreza=2;}
                    if (personaje.getEquipo().contains("Escudo")){Ca=13+bono_destreza+2;}else{Ca=13+bono_destreza;}

                    CA.setText(String.valueOf(Ca));
                }else if (personaje.getEquipo().contains("Cota de escamas")||personaje.getEquipo().contains("Coraza")){
                    if (bono_destreza>2){bono_destreza=2;}
                    if (personaje.getEquipo().contains("Escudo")){Ca=14+bono_destreza+2;}else{Ca=14+bono_destreza;}
                    CA.setText(String.valueOf(Ca));
                }else if (personaje.getEquipo().contains("Semiplacas")){
                    if (bono_destreza>2){bono_destreza=2;}
                    if (personaje.getEquipo().contains("Escudo")){Ca=15+bono_destreza+2;}else{Ca=15+bono_destreza;}

                    CA.setText(String.valueOf(Ca));
                }else if(personaje.getEquipo().contains("Cota de anillas")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=14+2;}else{Ca=14;}

                    CA.setText(String.valueOf(Ca));
                }else if(personaje.getEquipo().contains("Cota de mallas")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=16+2;}else{Ca=16;}
                    CA.setText(String.valueOf(Ca));
                }else if(personaje.getEquipo().contains("Bandas")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=17+2;}else{Ca=17;}
                    CA.setText(String.valueOf(Ca));
                }else if(personaje.getEquipo().contains("Placas")){
                    if (personaje.getEquipo().contains("Escudo")){Ca=18+2;}else{Ca=18;}
                    CA.setText(String.valueOf(Ca));
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
            NoHechizo.setText(personaje.getHabilidad_especial());


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
            transfondo.setInputType(InputType.TYPE_NULL);
            lenguaje1.setInputType(InputType.TYPE_NULL);
            lenguaje2.setInputType(InputType.TYPE_NULL);
            //equipo.setInputType(InputType.TYPE_NULL);
            H1.setInputType(InputType.TYPE_NULL);
            H2.setInputType(InputType.TYPE_NULL);
            H3.setInputType(InputType.TYPE_NULL);
            H4.setInputType(InputType.TYPE_NULL);
            H5.setInputType(InputType.TYPE_NULL);
            H6.setInputType(InputType.TYPE_NULL);
            NoHechizo.setInputType(InputType.TYPE_NULL);
        }

        if((personaje.getClase().equals("Hechicero")||personaje.getClase().equals("Mago")||personaje.getClase().equals("Bardo")
                ||personaje.getClase().equals("Clérigo")||personaje.getClase().equals("Druida"))){
            if (H6.equals("vacio")){
                H1.setVisibility(View.VISIBLE);
                H2.setVisibility(View.VISIBLE);
                H3.setVisibility(View.VISIBLE);
                H4.setVisibility(View.VISIBLE);
                H6.setText(H5.getText());
                H6.setVisibility(View.VISIBLE);

                NoHechizo.setVisibility(View.GONE);
            }else{
                H1.setVisibility(View.VISIBLE);
                H2.setVisibility(View.VISIBLE);
                H3.setVisibility(View.VISIBLE);
                H4.setVisibility(View.VISIBLE);
                H5.setVisibility(View.VISIBLE);
                H6.setVisibility(View.VISIBLE);
                NoHechizo.setVisibility(View.GONE);
            }





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

                                    startActivity(new Intent(getBaseContext(),Mis_personajes.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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

}