package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class InformacionVehiculo extends AppCompatActivity {

    EditText plac;
    EditText marc;
    EditText tipo;
    EditText su;
    double suma = 0;
    private ArrayList<String> datos;

    private SharedPreferences persistencia;

    private ArrayList<String> datos1;
    private ArrayList<String> datos2;

    private ArrayAdapter<String> adaptador1;

    private SharedPreferences persistencia1;
    private SharedPreferences persistencia2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_vehiculo);

        plac = (EditText) findViewById(R.id.etPlaca);
        marc = (EditText) findViewById(R.id.edMarca);
        tipo = (EditText) findViewById(R.id.edTipoVeGas);
        su = (EditText) findViewById(R.id.etGanancia);

        cargar();

        persistencia1 = getSharedPreferences("Ganancias", Context.MODE_PRIVATE);
        persistencia2 = getSharedPreferences("gastosSha", Context.MODE_PRIVATE);


        Gson gson = new Gson();

        datos1 = new ArrayList<String>();
        datos2 = new ArrayList<String>();

        String lis = persistencia1.getString("listaGanancias", " ");
        String lis2 = persistencia2.getString("listaGastos", " ");

        Type type = new TypeToken<List<String>>() {
        }.getType();

        Type type2 = new TypeToken<List<String>>() {
        }.getType();


        List<String> objects = gson.fromJson(lis, type);
        List<String> objects2 = gson.fromJson(lis2, type2);

        // for (int i = 0; i < objects.size(); i += 4) {
        //datos1.add("Tipo G: " + objects.get(0) + " - " + objects.get(1));
        // datos1.add("Tipo gas: " + objects2.get(0) + " - " + objects2.get(1));

        if (objects == null && objects2 == null) {
            Toast.makeText(this, "No hay registros", Toast.LENGTH_SHORT).show();
        } else if (objects == null && objects2 != null) {
            su.setText("Gastos: " + objects2.get(1));
        } else if (objects != null && objects2 == null) {
            su.setText("Ganancias: " + objects.get(1));
        } else {
            double gana = Double.parseDouble(objects.get(1));
            double gastooo = Double.parseDouble(objects2.get(1));
            if (gana == 0 && gastooo == 0) {
                su.setText(0);
            } else {
                suma = gana - gastooo;
                su.setText(String.valueOf(suma));
            }
        }
    }

    public void cargar() {

        persistencia = getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);

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

    public void ingresarGasto(View view) {
        Intent intent = new Intent(this, Gastos.class);
        String pl = plac.getText().toString();
        intent.putExtra("placaGlobaG", pl);
        startActivity(intent);
    }

    public void ingresarGanancia(View view) {
        Intent intent = new Intent(this, Ganancias.class);
        String p = plac.getText().toString();
        intent.putExtra("placaGloba", p);
        startActivity(intent);
    }

    public void ingresarLista(View view) {
        Intent intent = new Intent(this, ListadoGanancias.class);
        startActivity(intent);
    }
}
