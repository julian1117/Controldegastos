package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InformacionVehiculo extends AppCompatActivity {

    EditText plac;
    EditText marc;
    EditText tipo;
    private ArrayList<String> datos;

    private SharedPreferences persistencia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_vehiculo);



        plac = (EditText) findViewById(R.id.etPlaca);
        marc = (EditText) findViewById(R.id.edMarca);
        tipo = (EditText) findViewById(R.id.edTipoVeGas);
        cargar();

    }

    public void cargar (){

        persistencia=getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        datos = new ArrayList<String>();
        String lis = persistencia.getString("lista", " ");

        Type type = new TypeToken<List<String>>() {
        }.getType();

        List<String> objects = gson.fromJson(lis, type);

        plac.setText(objects.get(0));
        tipo.setText(objects.get(2));
        marc.setText(objects.get(1));
    }
}
