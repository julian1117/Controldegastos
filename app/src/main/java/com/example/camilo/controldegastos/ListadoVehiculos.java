package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListadoVehiculos extends AppCompatActivity {

    ListView listaVehiculos;

    private ArrayList<String> datos;
    private ArrayAdapter<String> adaptador1;

    private SharedPreferences persistencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_vehiculos);

        Gson gson = new Gson();

        persistencia = getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);
        listaVehiculos = (ListView) findViewById(R.id.listadoVehiculos);

        datos = new ArrayList<String>();

        String lis = persistencia.getString("lista", " ");

        Type type = new TypeToken<List<String>>() {
        }.getType();

        List<String> objects = gson.fromJson(lis, type);

        for (int i = 0; i < objects.size(); i += 4) {
            datos.add("Tipo Vehiculo " + i + 1 + ": " + objects.get(0) + " - " + objects.get(2));
        }

        adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listaVehiculos.setAdapter(adaptador1);

        listaVehiculos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a = adaptador1.getItem(position);

                ir(view);
            }
        });


    }


    public void ir(View v){
        Intent intent = new Intent(this,InformacionVehiculo.class);
        startActivity(intent);
    }
}
