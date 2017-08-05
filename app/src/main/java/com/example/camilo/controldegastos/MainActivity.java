package com.example.camilo.controldegastos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences persistencia;
    Spinner cbmarca;

    EditText placa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placa = (EditText) findViewById(R.id.etPlaca);
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
        Spinner cbmarca = (Spinner) findViewById(R.id.tipoVehiculo);
        String[] lista = {"Compacto (uber)", "Bus", "Micro Bus", "Taxi"};
        ArrayAdapter<String> spinnerMarca = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lista);
        cbmarca.setAdapter(spinnerMarca);
    }

    public  void guardarDato(){
        /**
        persistencia = getSharedPreferences("registroVehiculo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = persistencia.edit();
        editor.putString("placa",placa.getText().toString());
        editor.putString("Marca", cbmarca.getSelectedItem().toString());
*/
        String b = cbmarca.getSelectedItem().toString();
        Toast.makeText(this, "Ingreso" +b, Toast.LENGTH_SHORT).show();

      //  editor.putInt("edad",Integer.parseInt(edad.getText().toString()));
       // editor.commit();


    }

}
