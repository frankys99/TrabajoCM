package com.example.trabajocm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.trabajocm.R;
import com.example.trabajocm.entidades.Personaje;
import com.example.trabajocm.utilidades.Utilidades;

import java.util.ArrayList;

public class dbPersonajes extends DbHelper {


    Context context;



    public dbPersonajes(@Nullable Context context) {
        super(context);
        this.context =context;

    }



    public long insertarPersonajeNull(Personaje p1) {

        long id = 0;
        Uri uriImage = Uri.parse("android.resource://" + context.getPackageName() +"/"+ R.drawable.descarga);
        String UriString = uriImage.toString();
        if (!(p1.getImagen()==null)){
            Uri uri= Uri.parse(p1.getImagen());
            UriString = uri.toString();
        }




        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_IMAGEN, UriString);
            values.put(Utilidades.CAMPO_NOMBRE,p1.getNombre());
            values.put(Utilidades.CAMPO_CLASE,p1.getClase());
            values.put(Utilidades.CAMPO_RAZA,p1.getRaza());
            values.put(Utilidades.CAMPO_ALINEAMIENTO, p1.getAlineamiento());
            values.put(Utilidades.CAMPO_SECUNDARIAS, p1.getSecundarias());
            values.put(Utilidades.CAMPO_TRASFONDO, "vacio");
            values.put(Utilidades.CAMPO_EQUIPO, p1.getEquipo());
            values.put(Utilidades.CAMPO_FUERZA, p1.getFuerza());
            values.put(Utilidades.CAMPO_DESTREZA, p1.getDestreza());
            values.put(Utilidades.CAMPO_CONSTITUCION, p1.getConstitucion());
            values.put(Utilidades.CAMPO_INTELIGENCIA, p1.getInteligencia());
            values.put(Utilidades.CAMPO_SABIDURIA, p1.getSabiduria());
            values.put(Utilidades.CAMPO_CARISMA, p1.getCarisma());

            values.put(Utilidades.CAMPO_NIVEL, 0);

            values.put(Utilidades.CAMPO_XP, 0);
            values.put(Utilidades.CAMPO_HAB_ESPE, p1.getHabilidad_especial());
            values.put(Utilidades.CAMPO_LENGUA1, "vacio");
            values.put(Utilidades.CAMPO_LENGUA2, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO1, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO2, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO3, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO4, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO5, "vacio");
            values.put(Utilidades.CAMPO_HECHIZO6, "vacio");

            id = db.insert(Utilidades.TABLA_PERSONAJE, null, values);
        }catch (Exception exception){
            exception.toString();
        }
        return id;
    }

    public ArrayList<Personaje> mostrarPersonaje(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();

        Personaje personaje;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PERSONAJE, null);

        if (cursorPersonaje.moveToFirst()) {
            do {
                personaje = new Personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setImagen(cursorPersonaje.getString(1));

                personaje.setNombre(cursorPersonaje.getString(2));
                personaje.setClase(cursorPersonaje.getString(3));
                personaje.setRaza(cursorPersonaje.getString(4));

                personaje.setAlineamiento(cursorPersonaje.getString(5));
                personaje.setSecundarias(cursorPersonaje.getString(6));
                personaje.setTransfondo(cursorPersonaje.getString(7));
                personaje.setEquipo(cursorPersonaje.getString(8));
                personaje.setFuerza(cursorPersonaje.getInt(9));
                personaje.setDestreza(cursorPersonaje.getInt(10));
                personaje.setConstitucion(cursorPersonaje.getInt(11));
                personaje.setInteligencia(cursorPersonaje.getInt(12));
                personaje.setSabiduria(cursorPersonaje.getInt(13));
                personaje.setCarisma(cursorPersonaje.getInt(14));

                personaje.setNivel(cursorPersonaje.getInt(15));

                personaje.setXp(cursorPersonaje.getInt(16));
                personaje.setHabilidad_especial(cursorPersonaje.getString(17));
                personaje.setLengua1(cursorPersonaje.getString(18));
                personaje.setLengua2(cursorPersonaje.getString(19));
                personaje.setHechizo1(cursorPersonaje.getString(20));
                personaje.setHechizo2(cursorPersonaje.getString(21));
                personaje.setHechizo3(cursorPersonaje.getString(22));
                personaje.setHechizo4(cursorPersonaje.getString(23));
                personaje.setHechizo5(cursorPersonaje.getString(24));
                personaje.setHechizo6(cursorPersonaje.getString(25));
                listaPersonajes.add(personaje);




            } while (cursorPersonaje.moveToNext());
        }

        cursorPersonaje.close();
        return listaPersonajes;
    }


    public Personaje mostrar_Resumen_Personaje(int id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PERSONAJE+ " WHERE id = " + id+ " LIMIT 1", null);

        if (cursorPersonaje.moveToFirst()) {
                personaje = new Personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setImagen(cursorPersonaje.getString(1));

                personaje.setNombre(cursorPersonaje.getString(2));
                personaje.setClase(cursorPersonaje.getString(3));
                personaje.setRaza(cursorPersonaje.getString(4));

                personaje.setAlineamiento(cursorPersonaje.getString(5));
                personaje.setSecundarias(cursorPersonaje.getString(6));
                personaje.setTransfondo(cursorPersonaje.getString(7));
                personaje.setEquipo(cursorPersonaje.getString(8));
                personaje.setFuerza(cursorPersonaje.getInt(9));
                personaje.setDestreza(cursorPersonaje.getInt(10));
                personaje.setConstitucion(cursorPersonaje.getInt(11));
                personaje.setInteligencia(cursorPersonaje.getInt(12));
                personaje.setSabiduria(cursorPersonaje.getInt(13));
                personaje.setCarisma(cursorPersonaje.getInt(14));

                personaje.setNivel(cursorPersonaje.getInt(15));

                personaje.setXp(cursorPersonaje.getInt(16));
                personaje.setHabilidad_especial(cursorPersonaje.getString(17));
                personaje.setLengua1(cursorPersonaje.getString(18));
                personaje.setLengua2(cursorPersonaje.getString(19));
                personaje.setHechizo1(cursorPersonaje.getString(20));
                personaje.setHechizo2(cursorPersonaje.getString(21));
                personaje.setHechizo3(cursorPersonaje.getString(22));
                personaje.setHechizo4(cursorPersonaje.getString(23));
                personaje.setHechizo5(cursorPersonaje.getString(24));
                personaje.setHechizo6(cursorPersonaje.getString(25));

        }

        cursorPersonaje.close();
        return personaje;
    }

    public boolean eliminarPersonaje(int id) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + Utilidades.TABLA_PERSONAJE + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }


}
