package com.zeme.proyecto_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Ej2Activity extends AppCompatActivity {

    List<String> arrayList = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);

        //spinner = findViewById(R.id.spinnerFrutas);

        Button bAñadir = findViewById(R.id.bAñadir);
        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((TextView)findViewById(R.id.etNombreFruta)).getText().toString().isEmpty()) {

                    //arrayList = new ArrayList<>();
                    arrayList.add(((TextView) findViewById(R.id.etNombreFruta)).getText().toString());


                    //dejarlo vacio una vez que lo agregue
                    ((TextView) findViewById(R.id.etNombreFruta)).setText("");

                    //comprobación
                    Toast.makeText(Ej2Activity.this,"Se a añadido una nueva fruta",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Ej2Activity.this,"Error al añadir, introduce una fruta",Toast.LENGTH_SHORT).show();

                }

            }
        });

        Button bAcabar = findViewById(R.id.bAcabar);
        bAcabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Asignacion del recurso de cada elemento cuando se despliegue
                //spinner.setAdapter(new ArrayAdapter<>(Ej1Activity.this, android.R.layout.simple_list_item_1,arrayList));

                bAcabar.setEnabled(false);
                bAñadir.setEnabled(false);

                Intent i = new Intent(Ej2Activity.this,Ej2_1Activity.class);
                i.putStringArrayListExtra("arrayFrutas", (ArrayList<String>) arrayList);
                startActivity(i);

            }
        });
    }

}