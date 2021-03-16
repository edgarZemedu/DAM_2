package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Ej01Activity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> frutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej01);

        frutas = new ArrayList<>();
        spinner = findViewById(R.id.spinner);
    }


    public void anadir(View view) {
        String fruta = ((EditText)findViewById(R.id.et01)).getText().toString();
        if (!fruta.matches("\\s*")) { // Comprobamos que el EditText no está vacío.
            frutas.add(fruta);
        } // Si lo está, simplemente no añadimos nada.
        ((EditText)findViewById(R.id.et01)).getText().clear();
    }


    public void acabar(View view) {
        findViewById(R.id.btnAcabar01).setEnabled(false);
        findViewById(R.id.btnAnadir01).setEnabled(false);
        findViewById(R.id.et01).setEnabled(false);

        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, frutas));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ej01Activity.this, "Fruta: " + parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner.setVisibility(View.VISIBLE);
    }
}
