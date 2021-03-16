package com.zeme.proyecto_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ej1Activity extends AppCompatActivity {

    List<String> arrayList = new ArrayList<>();;
    Spinner spinner;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);

        spinner = findViewById(R.id.spinner);

        Button bAñadir = findViewById(R.id.bAñadir);
        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((TextView)findViewById(R.id.etNombreFruta)).getText().toString().isEmpty()) {

                    //arrayList = new ArrayList<>();
                    arrayList.add(((TextView) findViewById(R.id.etNombreFruta)).getText().toString());

                    adapter = new ArrayAdapter<String>(Ej1Activity.this,
                            android.R.layout.simple_spinner_item,
                            arrayList);

                    //dejarlo vacio una vez que lo agregue
                    ((TextView) findViewById(R.id.etNombreFruta)).setText("");

                    //comprobación
                    Toast.makeText(Ej1Activity.this,"Se a añadido una nueva fruta",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Ej1Activity.this,"Error al añadir, introduce una fruta",Toast.LENGTH_SHORT).show();

                }

            }
        });

        Button bAcabar = findViewById(R.id.bAcabar);
        bAcabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Asignacion del recurso de cada elemento cuando se despliegue
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                //spinner.setAdapter(new ArrayAdapter<>(Ej1Activity.this, android.R.layout.simple_list_item_1,arrayList));

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int posicion, long l) {

                        Toast.makeText(Ej1Activity.this,
                                "Fruta seleccionada: "+adapterView.getItemAtPosition(posicion).toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                bAcabar.setEnabled(false);
                bAñadir.setEnabled(false);

            }
        });
        //setear el adaptador del spinner
        spinner.setAdapter(adapter);

    }

}