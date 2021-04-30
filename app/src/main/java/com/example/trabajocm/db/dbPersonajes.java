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
            values.put(Utilidades.CAMPO_CLASE,"vacio");
            values.put(Utilidades.CAMPO_RAZA,"vacio");
            values.put(Utilidades.CAMPO_SALVACIONES, "vacio");
            values.put(Utilidades.CAMPO_SECUNDARIAS, "vacio");
            values.put(Utilidades.CAMPO_DOTES, "vacio");
            values.put(Utilidades.CAMPO_EQUIPO, "vacio");
            values.put(Utilidades.CAMPO_FUERZA, 10);
            values.put(Utilidades.CAMPO_DESTREZA, 10);
            values.put(Utilidades.CAMPO_CONSTITUCION, 10);
            values.put(Utilidades.CAMPO_INTELIGENCIA, 10);
            values.put(Utilidades.CAMPO_SABIDURIA, 10);
            values.put(Utilidades.CAMPO_CARISMA, 10);
            values.put(Utilidades.CAMPO_PV, 10);
            values.put(Utilidades.CAMPO_CA, 10);
            values.put(Utilidades.CAMPO_NIVEL, 0);
            values.put(Utilidades.CAMPO_TURNO, 10);
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
                personaje.setRaza(cursorPersonaje.getString(3));
                personaje.setClase(cursorPersonaje.getString(4));
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
                personaje.setPv(cursorPersonaje.getInt(15));
                personaje.setCa(cursorPersonaje.getInt(16));
                personaje.setNivel(cursorPersonaje.getInt(17));
                personaje.setTurno(cursorPersonaje.getInt(18));
                personaje.setXp(cursorPersonaje.getInt(19));
                personaje.setLengua1(cursorPersonaje.getString(20));
                personaje.setLengua2(cursorPersonaje.getString(21));
                personaje.setHechizo1(cursorPersonaje.getString(22));
                personaje.setHechizo2(cursorPersonaje.getString(23));
                personaje.setHechizo3(cursorPersonaje.getString(24));
                personaje.setHechizo4(cursorPersonaje.getString(25));
                personaje.setHechizo5(cursorPersonaje.getString(26));
                personaje.setHechizo6(cursorPersonaje.getString(27));
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
                personaje.setRaza(cursorPersonaje.getString(3));
                personaje.setClase(cursorPersonaje.getString(4));
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
                personaje.setPv(cursorPersonaje.getInt(15));
                personaje.setCa(cursorPersonaje.getInt(16));
                personaje.setNivel(cursorPersonaje.getInt(17));
                personaje.setTurno(cursorPersonaje.getInt(18));
                personaje.setXp(cursorPersonaje.getInt(19));
                personaje.setLengua1(cursorPersonaje.getString(20));
                personaje.setLengua2(cursorPersonaje.getString(21));
                personaje.setHechizo1(cursorPersonaje.getString(22));
                personaje.setHechizo2(cursorPersonaje.getString(23));
                personaje.setHechizo3(cursorPersonaje.getString(24));
                personaje.setHechizo4(cursorPersonaje.getString(25));
                personaje.setHechizo5(cursorPersonaje.getString(26));
                personaje.setHechizo6(cursorPersonaje.getString(27));

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
