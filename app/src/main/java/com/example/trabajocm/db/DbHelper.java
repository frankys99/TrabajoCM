package com.example.trabajocm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.trabajocm.utilidades.Utilidades;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=14;
    private static final String DATABASE_NOMBRE="Personaje.db";




    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.CREAR_TABLA_PERSONAJE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+Utilidades.TABLA_PERSONAJE);
        onCreate(db);
    }
}
