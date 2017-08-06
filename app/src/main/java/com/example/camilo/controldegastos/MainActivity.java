package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Spinner cbmarca;
    Spinner cbTipoVeh;
    EditText ingesoPas;
    EditText placa;

    SharedPreferences persistencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placa = (EditText) findViewById(R.id.etPlacas);
        ingesoPas = (EditText) findViewById(R.id.pasajero);
        llenarComboMarca();
        llenarComboTipoVehiculo();
    }


    public void llenarComboMarca() {
        cbmarca = (Spinner) findViewById(R.id.marca);
        String[] lista = {"Chevrolet", "Mazda", "Audi", "Mercedes Benz"};
        ArrayAdapter<String> spinnerMarca = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        cbmarca.setAdapter(spinnerMarca);
    }

    public void llenarComboTipoVehiculo() {
        cbTipoVeh = (Spinner) findViewById(R.id.tipoVehiculo);
        String[] lista = {"Compacto (uber)", "Bus", "Micro Bus", "Taxi"};
        ArrayAdapter<String> spinnerMarca = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        cbTipoVeh.setAdapter(spinnerMarca);
    }

    public void guardar(View view) {

        persistencia = getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();
        editor.putString("placa", placa.getText().toString());
        editor.putString("Marca", cbmarca.getSelectedItem().toString());
        editor.putString("Tipo vehiculo", cbTipoVeh.getSelectedItem().toString());
        editor.putInt("Ingreso de pasajers", Integer.parseInt(ingesoPas.getText().toString()));

        editor.commit();

        Toast.makeText(this, "Ingreso", Toast.LENGTH_SHORT).show();



    }


    public void ir(View v){
        Intent intent = new Intent(this,ListadoVehiculos.class);
        startActivity(intent);
    }
}
