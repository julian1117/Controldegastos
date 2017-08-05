package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListadoVehiculos extends AppCompatActivity {

    ListView lista;

    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_vehiculos);

        lista = (ListView) findViewById(R.id.listadoVehiculos);

    }

    public void cargarDatos(){
        persistencia = getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);
        //lista.add;

    }
}
