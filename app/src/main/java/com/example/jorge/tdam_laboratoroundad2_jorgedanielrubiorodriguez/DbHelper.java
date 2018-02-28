package com.example.jorge.tdam_laboratoroundad2_jorgedanielrubiorodriguez;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jorge on 27/02/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NOMBRE="escuela.sqlite";
    private static  int DB_SCHEME_VERSION=1;

    public DbHelper(Context context) {
        super(context, DB_NOMBRE, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crear tabla curso
        db.execSQL(DataBaseManagerCurso.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
}