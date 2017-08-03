package com.example.camilo.controldegastos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llenarComboMarca();
        llenarComboTipoVehiculo();
    }


    public void llenarComboMarca() {
        Spinner cbmarca = (Spinner) findViewById(R.id.marca);
        String[] lista = {"Chevrolet", "Mazda", "Audi", "Mercedes Benz"};
        ArrayAdapter<String> spinnerMarca = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        cbmarca.setAdapter(spinnerMarca);
    }

    public void llenarComboTipoVehiculo() {
        Spinner cbmarca = (Spinner) findViewById(R.id.tipoVehiculo);
        String[] lista = {"Compacto (uber)", "Bus", "Micro Bus", "Taxi"};
        ArrayAdapter<String> spinnerMarca = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        cbmarca.setAdapter(spinnerMarca);
    }


}
