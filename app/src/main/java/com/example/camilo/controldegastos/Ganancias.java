package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Ganancias extends AppCompatActivity {

    EditText nombreGanan;
    EditText cantidadGanan;
    String pl;
    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganancias);
        nombreGanan = (EditText) findViewById(R.id.nomGanancia);
        cantidadGanan = (EditText) findViewById(R.id.cantIngresoGanancia);

        Bundle datoPlaca = getIntent().getExtras();
        pl = datoPlaca.getString("placaGloba");

    }

    public void guardar(View view) {

        persistencia = getSharedPreferences("Ganancias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();

        List<String> lista = new ArrayList<>();
        lista.add(nombreGanan.getText().toString());
        lista.add(cantidadGanan.getText().toString());
        lista.add(pl);


        Gson gson = new Gson();

        String li = gson.toJson(lista);

        editor.putString("listaGanancias", li);

        editor.commit();

        Toast.makeText(this, "Ganancia guardada", Toast.LENGTH_SHORT).show();

    }


}
