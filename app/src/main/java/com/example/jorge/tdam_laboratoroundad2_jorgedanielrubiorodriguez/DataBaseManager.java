package com.example.jorge.tdam_laboratoroundad2_jorgedanielrubiorodriguez;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jorge on 27/02/2018.
 */

public abstract class DataBaseManager {
    private DbHelper helper;
    private SQLiteDatabase db;


    public DataBaseManager(Context ctx) {
        helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public void cerrar(){
        db.close();
    }


    abstract void insertar_4parametros(String id, String nombre, String descripcion, String precio);
    abstract void actualizar_4parametros(String id, String nombre, String descripcion, String precio);


    abstract public void eliminar(String id);
    abstract public void eliminarTodo();
    abstract public Cursor cargarCursor();
    abstract Boolean compruebaRegistro(String id);

    public DbHelper getHelper() {
        return helper;
    }

    public void setHelper(DbHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

}
