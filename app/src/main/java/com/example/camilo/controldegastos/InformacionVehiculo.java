package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class InformacionVehiculo extends AppCompatActivity {

    EditText plac;
    EditText marc;
    EditText tipo;

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
        plac.setText(persistencia.getString("placa",""));
        marc.setText(persistencia.getString("Tipo vehiculo", " "));
        //marc.setText(persistencia.getString(""));
    }
}
