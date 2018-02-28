package com.example.jorge.tdam_laboratoroundad2_jorgedanielrubiorodriguez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btnInsertar,btnActualizar, btnBorrar,btnConsultar;


    private DataBaseManagerCurso managerCurso;
    private RecyclerView recycler;
    private CartaCursoAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Curso> listaItemsCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managerCurso= new DataBaseManagerCurso(this);
        adViews();

        inicializarRecicler();
    }

    private void adViews() {


    }



    public void inicializarRecicler() {

        listaItemsCursos = managerCurso.getCursosList();



        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        // Crear un nuevo adaptador
        adapter = new CartaCursoAdapter(listaItemsCursos, this);

        recycler.setAdapter(adapter);


        recycler.setItemAnimator(new DefaultItemAnimator());

    }
    @Override
    public void onClick(View v) {


    }
    private void recargarRecicler() {
        //cargar datos
        listaItemsCursos = managerCurso.getCursosList();
        // Crear un nuevo adaptador
        adapter = new CartaCursoAdapter(listaItemsCursos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());

    }


    @Override
    protected void onDestroy() {

        managerCurso.cerrar();

        super.onDestroy();
    }
}

