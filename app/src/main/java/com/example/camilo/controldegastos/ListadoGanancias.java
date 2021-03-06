package com.example.camilo.controldegastos;

import android.content.Context;
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

public class ListadoGanancias extends AppCompatActivity {

    ListView listaGanancias;

    private ArrayList<String> datos;

    private ArrayAdapter<String> adaptador1;

    private SharedPreferences persistencia;
    private SharedPreferences persistencia2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_ganancias);

        Gson gson = new Gson();

        persistencia = getSharedPreferences("Ganancias", Context.MODE_PRIVATE);
        persistencia2 = getSharedPreferences("gastosSha", Context.MODE_PRIVATE);
        listaGanancias = (ListView) findViewById(R.id.listadoGananciasGastos);

        datos = new ArrayList<String>();

        String lis = persistencia.getString("listaGanancias", " ");
        String lis2 = persistencia2.getString("listaGastos", " ");

        Type type = new TypeToken<List<String>>() {
        }.getType();

        Type type2 = new TypeToken<List<String>>() {
        }.getType();

        List<String> objects = gson.fromJson(lis, type);
        List<String> objects2 = gson.fromJson(lis2, type2);

        if(objects==null && objects2==null  ){
            datos.add("T. Ganancia:  N/A ");
            datos.add("T. Gasto:  N/A ");
            Toast.makeText(this, "No hay registros", Toast.LENGTH_SHORT).show();

        }else if(objects== null && objects2!=null){
            datos.add("T. Ganancia:  N/A ");
            datos.add("T. Gasto: " + objects2.get(0) + " = " + objects2.get(1));
        }else if (objects!= null && objects2== null){
            datos.add("T. Ganancia: " + objects.get(0) + " = " + objects.get(1));
            datos.add("T. Gasto:  N/A ");
        }else{
            datos.add("T. Ganancia: " + objects.get(0) + " = " + objects.get(1));
            datos.add("T. Gasto: " + objects2.get(0) + " = " + objects2.get(1));
        }

        adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listaGanancias.setAdapter(adaptador1);





    }

}
