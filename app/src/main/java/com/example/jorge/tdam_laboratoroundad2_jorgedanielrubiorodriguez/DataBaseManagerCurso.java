package com.example.jorge.tdam_laboratoroundad2_jorgedanielrubiorodriguez;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge on 27/02/2018.
 */

public class DataBaseManagerCurso extends DataBaseManager {

    private static final String NOMBRE_TABLA="curso";

    private static final String ID="_id";
    private static final String NOMBRE="nombre";
    private static final String DESCRIPCION="descripcion";
    private static final String PRECIO="precio";


    public static final String CREATE_TABLE = "create table " + NOMBRE_TABLA + " ("
            + ID + " integer PRIMARY KEY AUTOINCREMENT, "
            + NOMBRE + " text NOT NULL, "
            + DESCRIPCION + " text NULL, "
            + PRECIO + " DECIMAL(10,5) NULL"
            + ");";





    public DataBaseManagerCurso(Context ctx) {
        super(ctx);
    }

    @Override
    public void cerrar() {
        super.getDb().close();
    }


    private ContentValues generarContentValues(String id, String name, String descripcion, String precio) {
        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, name);
        valores.put(DESCRIPCION, descripcion);
        valores.put(PRECIO, precio);


        return valores;
    }

    @Override
    public void insertar_4parametros(String id, String nombre, String descripcion, String precio) {
        //super.getDb().execSQL("INSERT "+);

        Log.d("cursos_insertar", super.getDb().insert(NOMBRE_TABLA, null, generarContentValues(id, nombre, descripcion, precio)) + "");

    }

    @Override
    public void actualizar_4parametros(String id, String nombre, String descripcion, String precio) {


        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, nombre);
        valores.put(DESCRIPCION, descripcion);
        valores.put(PRECIO, precio);

        String [] args= new String[]{id};
        Log.d("cursos_actualizar", super.getDb().update(NOMBRE_TABLA, valores, "_id=?", args)+"");




    }

    @Override
    public void eliminar(String id) {

        super.getDb().delete(NOMBRE_TABLA, ID + "=?", new String[]{id});
    }

    @Override
    public void eliminarTodo() {

        super.getDb().execSQL("DELETE FROM "+ NOMBRE_TABLA+";");
        Log.d("cursos_eliminar", "Datos borrados");

    }
    @Override
    public Cursor cargarCursor() {
        String [] columnas= new String[]{ID, NOMBRE, DESCRIPCION, PRECIO};


        return super.getDb().query(NOMBRE_TABLA,columnas,null,null,null,null,null );
    }

    @Override
    Boolean compruebaRegistro(String id) {

        boolean esta=true;

        Cursor resultSet= super.getDb().rawQuery("Select * from " + NOMBRE_TABLA + " WHERE " + ID + "=" + id, null);

        if(resultSet.getCount()<=0)
            esta=false;
        else
            esta=true;

        return esta;

    }

    public List<Curso> getCursosList(){
        List<Curso> list= new ArrayList<>();
        Cursor c= cargarCursor();


        while (c.moveToNext()){
            Curso curso = new Curso();

            curso.setId(c.getString(0));
            curso.setNombre(c.getString(1));
            curso.setDescripcion(c.getString(2));
            curso.setPrecio(c.getDouble(3));


            list.add(curso);
        }

        return list;

    }





}