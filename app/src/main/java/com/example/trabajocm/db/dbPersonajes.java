package com.example.trabajocm.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.example.trabajocm.R;
import com.example.trabajocm.entidades.personaje;
import com.example.trabajocm.utilidades.Utilidades;

import java.util.ArrayList;

public class dbPersonajes extends DbHelper {

    Context context;



    public dbPersonajes(@Nullable Context context) {
        super(context);
        this.context =context;

    }



    public long insertarPersonajeNull() {

        long id = 0;
        Uri uriImage = Uri.parse("android.resource://" + context.getPackageName() +"/"+ R.drawable.descarga);
        String UriString = uriImage.toString();

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_IMAGEN, UriString);
            values.put(Utilidades.CAMPO_NOMBRE,"vacio");
            values.put(Utilidades.CAMPO_CLASE,"Bárbaro");
            values.put(Utilidades.CAMPO_RAZA,"Humano");
            values.put(Utilidades.CAMPO_SALVACIONES, "vacio");
            values.put(Utilidades.CAMPO_SECUNDARIAS, "vacio");
            values.put(Utilidades.CAMPO_DOTES, "vacio");
            values.put(Utilidades.CAMPO_EQUIPO, "vacio");
            values.put(Utilidades.CAMPO_FUERZA, 15);
            values.put(Utilidades.CAMPO_DESTREZA, 15);
            values.put(Utilidades.CAMPO_CONSTITUCION, 15);
            values.put(Utilidades.CAMPO_INTELIGENCIA, 15);
            values.put(Utilidades.CAMPO_SABIDURIA, 15);
            values.put(Utilidades.CAMPO_CARISMA, 15);

            values.put(Utilidades.CAMPO_NIVEL, 0);

            values.put(Utilidades.CAMPO_XP, 0);
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

    public ArrayList<personaje> mostrarPersonaje(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<personaje> listaPersonajes = new ArrayList<personaje>();

        personaje personaje;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PERSONAJE, null);

        if (cursorPersonaje.moveToFirst()) {
            do {
                personaje = new personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setImagen(cursorPersonaje.getString(1));

                personaje.setNombre(cursorPersonaje.getString(2));
                personaje.setClase(cursorPersonaje.getString(3));
                personaje.setRaza(cursorPersonaje.getString(4));

                personaje.setSalvaciones(cursorPersonaje.getString(5));
                personaje.setSecundarias(cursorPersonaje.getString(6));
                personaje.setDotes(cursorPersonaje.getString(7));
                personaje.setEquipo(cursorPersonaje.getString(8));
                personaje.setFuerza(cursorPersonaje.getInt(9));
                personaje.setDestreza(cursorPersonaje.getInt(10));
                personaje.setConstitucion(cursorPersonaje.getInt(11));
                personaje.setInteligencia(cursorPersonaje.getInt(12));
                personaje.setSabiduria(cursorPersonaje.getInt(13));
                personaje.setCarisma(cursorPersonaje.getInt(14));

                personaje.setNivel(cursorPersonaje.getInt(15));

                personaje.setXp(cursorPersonaje.getInt(16));
                personaje.setLengua1(cursorPersonaje.getString(17));
                personaje.setLengua2(cursorPersonaje.getString(18));
                personaje.setHechizo1(cursorPersonaje.getString(19));
                personaje.setHechizo2(cursorPersonaje.getString(20));
                personaje.setHechizo3(cursorPersonaje.getString(21));
                personaje.setHechizo4(cursorPersonaje.getString(22));
                personaje.setHechizo5(cursorPersonaje.getString(23));
                personaje.setHechizo6(cursorPersonaje.getString(24));
                listaPersonajes.add(personaje);




            } while (cursorPersonaje.moveToNext());
        }

        cursorPersonaje.close();
        return listaPersonajes;
    }


    public personaje mostrar_Resumen_Personaje(int id){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        personaje personaje = null;
        Cursor cursorPersonaje;

        cursorPersonaje = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PERSONAJE+ " WHERE id = " + id+ " LIMIT 1", null);

        if (cursorPersonaje.moveToFirst()) {
                personaje = new personaje();
                personaje.setId(cursorPersonaje.getInt(0));
                personaje.setImagen(cursorPersonaje.getString(1));

                personaje.setNombre(cursorPersonaje.getString(2));
                personaje.setClase(cursorPersonaje.getString(3));
                personaje.setRaza(cursorPersonaje.getString(4));

                personaje.setSalvaciones(cursorPersonaje.getString(5));
                personaje.setSecundarias(cursorPersonaje.getString(6));
                personaje.setDotes(cursorPersonaje.getString(7));
                personaje.setEquipo(cursorPersonaje.getString(8));
                personaje.setFuerza(cursorPersonaje.getInt(9));
                personaje.setDestreza(cursorPersonaje.getInt(10));
                personaje.setConstitucion(cursorPersonaje.getInt(11));
                personaje.setInteligencia(cursorPersonaje.getInt(12));
                personaje.setSabiduria(cursorPersonaje.getInt(13));
                personaje.setCarisma(cursorPersonaje.getInt(14));

                personaje.setNivel(cursorPersonaje.getInt(15));

                personaje.setXp(cursorPersonaje.getInt(16));
                personaje.setLengua1(cursorPersonaje.getString(17));
                personaje.setLengua2(cursorPersonaje.getString(18));
                personaje.setHechizo1(cursorPersonaje.getString(19));
                personaje.setHechizo2(cursorPersonaje.getString(20));
                personaje.setHechizo3(cursorPersonaje.getString(21));
                personaje.setHechizo4(cursorPersonaje.getString(22));
                personaje.setHechizo5(cursorPersonaje.getString(23));
                personaje.setHechizo6(cursorPersonaje.getString(24));

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
