package com.example.camilo.controldegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoVehiculos extends AppCompatActivity {

    ListView listaVehiculos;

    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador1;

    private SharedPreferences persistencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_vehiculos);

        persistencia=getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);
        listaVehiculos = (ListView) findViewById(R.id.listadoVehiculos);

        datos =new ArrayList<String>();
        int ban = 0;
        do{
            datos.add(persistencia.getString("placa", " ") +" - "+persistencia.getString("Tipo vehiculo", " ") );

            ban ++;
        }while(persistencia.getAll().size()>ban);


        adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        listaVehiculos.setAdapter(adaptador1);
    }
}
