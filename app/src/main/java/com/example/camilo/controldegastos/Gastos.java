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

public class Gastos extends AppCompatActivity {

    EditText nombre;
    EditText gasto;
    String pla ;

    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);

        nombre= (EditText) findViewById(R.id.etNombreGasto);
        gasto = (EditText) findViewById(R.id.etCostoGasto);

        Bundle datoPlaca = getIntent().getExtras();
        pla = datoPlaca.getString("placaGlobaG");
    }

    public void guardar(View view) {

        persistencia = getSharedPreferences("gastosSha", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();

        List<String> listaGasto = new ArrayList<>();
        listaGasto.add(nombre.getText().toString());
        listaGasto.add(gasto.getText().toString());
        listaGasto.add(pla);

        Gson gson = new Gson();
        String lisGas = gson.toJson(listaGasto);
        editor.putString("listaGastos", lisGas);
        editor.commit();
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();


    }
}
