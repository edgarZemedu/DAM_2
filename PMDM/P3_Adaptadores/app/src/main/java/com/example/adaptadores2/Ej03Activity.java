package com.example.adaptadores2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Ej03Activity extends AppCompatActivity {

    private Spinner spinnerProvincias;
    private Spinner spinnerCidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej03);

        spinnerProvincias = findViewById(R.id.spinnerProvincias);
        spinnerCidades = findViewById(R.id.spinnerCidades);

        spinnerProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int cidades;
                switch (position) {
                    case 0:
                        cidades = R.array.ciudades_pontevedra;
                        break;
                    case 1:
                        cidades = R.array.ciudades_corunha;
                        break;
                    case 2:
                        cidades = R.array.ciudades_lugo;
                        break;
                    case 3:
                        cidades = R.array.ciudades_ourense;
                        break;
                    default:
                        return;
                }
                spinnerCidades.setAdapter(
                        ArrayAdapter.createFromResource(Ej03Activity.this, cidades, android.R.layout.simple_spinner_dropdown_item));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        spinnerCidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Ej03Activity.this,
                        "Provincia: " + spinnerProvincias.getSelectedItem()
                                + "\nLocalidade: " + view.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
